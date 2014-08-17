package data;

import java.util.ArrayList;

public abstract class Command {
	String coords;
	ArrayList<String> hasReceived = new ArrayList<String>();
	
	public boolean hasBeenIssued(String coords){
		for(int i = 0; i < hasReceived.size(); i++){
			if(hasReceived.get(i).equals(coords)){
				return true;
			}
		}
		return false;
	}
	public abstract String issueCommand(String issueCoords);
}
