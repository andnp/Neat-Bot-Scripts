package commands;

import data.CityBot;
import data.CityList;

public class CompleteQuestsCommand extends Command {

	String command = "completequests routine";
	
	public CompleteQuestsCommand(CityList cl){
		this.cl = cl;
		this.timeIssued = System.currentTimeMillis();
	}
	
	@Override
	public boolean equals(Command cmd) {
		return cmd.command.equals(command);
	}

	@Override
	public String issueCommand(CityBot bot) {
		this.hasReceived.add(bot.coords);
		return command;
	}

}
