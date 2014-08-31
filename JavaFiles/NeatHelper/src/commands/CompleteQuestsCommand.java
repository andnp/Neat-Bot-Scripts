package commands;

import data.CityBot;
import data.CityList;

public class CompleteQuestsCommand extends Command {

	public CompleteQuestsCommand(CityList cl){
		this.cl = cl;
		this.timeIssued = System.currentTimeMillis();
	}
	
	@Override
	public boolean equals(Command cmd) {
		
		return false;
	}

	@Override
	public String issueCommand(CityBot bot) {
		
		return null;
	}

}
