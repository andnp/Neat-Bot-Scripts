package data;

import java.util.ArrayList;

public class CommandCollection extends ArrayList<Command> {
	private static final long serialVersionUID = 1L;
	
	public String grabCommand(String coords){
		for(Command com : this){
			if(!com.hasBeenIssued(coords)){
				return com.issueCommand(coords);
			} 
			if(com.timesIssued > com.issuable){
				this.remove(com);
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
