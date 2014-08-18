package data;

import java.util.ArrayList;

public class CommandCollection extends ArrayList<Command> {
	private static final long serialVersionUID = 1L;
	
	public String grabCommand(String coords){
		for(int i = 0; i < this.size(); i++){
			if(!this.get(i).hasBeenIssued(coords)){
				return this.get(i).issueCommand(coords);
			} 
			if(this.get(i).timesIssued > this.get(i).issuable){
				this.remove(i);
			}
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
