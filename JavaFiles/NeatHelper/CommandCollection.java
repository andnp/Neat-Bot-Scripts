package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CommandCollection extends ArrayList<Command> {
	private static final long serialVersionUID = 1L;
	
	public String grabCommand(String coords){
		Collections.sort(this, new ScoreComparator());
		ArrayList<Command> toRemove = new ArrayList<Command>();
		for(Command com : this){
			if(!com.hasBeenIssued(coords)){
				return com.issueCommand(coords);
			} 
			if(com.hasReceived.size() > com.timesIssuable){
				toRemove.add(com);
			} else if(com.timeIssued + 60000 <= System.currentTimeMillis()){
				toRemove.add(com);
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
