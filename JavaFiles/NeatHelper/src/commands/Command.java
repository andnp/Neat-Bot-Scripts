package commands;

import java.util.ArrayList;

import data.CityBot;
import data.CityList;

public abstract class Command {
	String coords;
	String command;
	public int timesIssuable;
	public long timeIssued;
	CityList cl;
	public ArrayList<String> hasReceived = new ArrayList<String>();
	
	public boolean hasBeenIssued(String coords){
		for(int i = 0; i < hasReceived.size(); i++){
			if(hasReceived.get(i).equals(coords)){
				return true;
			}
		}
		return false;
	}
	public int getScore(){
		int score = (int)(System.currentTimeMillis() - timeIssued);
		return score;
	}
	
	public abstract boolean equals(Command cmd);
	
	public abstract String issueCommand(CityBot bot);
}
