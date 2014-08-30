package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CommandCollection extends ArrayList<Command> {
	private static final long serialVersionUID = 1L;
	CityList cl;
	
	CommandCollection(CityList cl){
		this.cl = cl;
	}
	
	public String grabCommand(String coords){
		Collections.sort(this, new ScoreComparator());
		ArrayList<Command> toRemove = new ArrayList<Command>();
		String ret = "";
		for(Command com : this){
			if(!com.hasBeenIssued(coords)){
				ret = com.issueCommand(cl.getByCoords(coords));
			} 
			if(com.hasReceived.size() == cl.size()){
				toRemove.add(com);
			} else if(com.timeIssued + 60000 <= System.currentTimeMillis()){
				toRemove.add(com);
			}
			if(!ret.isEmpty()){
				return ret;
			}
		}
		for(Command com : toRemove){
			this.remove(com);
		}
		return "";
	}
	
	public boolean exists(Command com){
		for(int i = 0; i < this.size(); i++){
			if(this.get(i).equals(com)){
				return true;
			}
		}
		return false;
	}
}

class ScoreComparator implements Comparator<Command>{

	public int compare(Command arg0, Command arg1) {
		
		return arg0.getScore() - arg1.getScore();
	}
	
}
