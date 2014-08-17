package data;

import java.util.ArrayList;

public abstract class Command {
	String coords;
	String command;
	int timesIssued = 0;
	int issuable = 5;
	ArrayList<String> hasReceived = new ArrayList<String>();
	
	public boolean hasBeenIssued(String coords){
		for(int i = 0; i < hasReceived.size(); i++){
			if(hasReceived.get(i).equals(coords)){
				return true;
			}
		}
		return false;
	}
	public abstract boolean equals(Command cmd);
	
	public abstract String issueCommand(String issueCoords);
}
