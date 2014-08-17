package data;

import java.util.ArrayList;

public class CommandCollection extends ArrayList<Command> {
	private static final long serialVersionUID = 1L;
	
	public String grabCommand(String coords){
		for(int i = 0; i < this.size(); i++){
			if(!this.get(i).hasBeenIssued(coords)){
				this.get(i).issueCommand(coords);
			}
		}
		return "";
	}
}
