package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CommandCollection extends ArrayList<Command> {
	private static final long serialVersionUID = 1L;
	
	public String grabCommand(String coords){
		Collections.sort(this, new ScoreComparator());
		ArrayList<Integer> toRemove = new ArrayList<Integer>();
		for(int i = 0; i < this.size(); i++){
			if(!this.get(i).hasBeenIssued(coords)){
				return this.get(i).issueCommand(coords);
			} 
			if(this.get(i).hasReceived.size() > this.get(i).timesIssuable){
				toRemove.add(i);
			} else if(this.get(i).timeIssued + 60000 <= System.currentTimeMillis()){
				toRemove.add(i);
			}
		}
		for(Integer i : toRemove){
			this.remove(i);
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
