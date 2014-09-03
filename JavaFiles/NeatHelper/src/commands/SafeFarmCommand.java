package commands;

import data.CityBot;
import data.CityList;

public class SafeFarmCommand extends Command {

	String command = "";


	public SafeFarmCommand(CityBot bot, CityList cl){
		this.cl = cl;
		this.timeIssued = System.currentTimeMillis();
		if(bot.troops[CityBot.ARCHER] < 500){
			command = "safevalleyfarm 1,2,3";
		} else if(bot.troops[CityBot.ARCHER] < 4000){
			command = "safevalleyfarm 4,5,6";
		} else if(bot.troops[CityBot.ARCHER] < 15000){
			command = "safevalleyfarm 7,8,9";
		} else if(bot.troops[CityBot.ARCHER] > 15000){
			command = "safevalleyfarm 8,9,10";
		} else {
			command = "echo 'safefarmcommand error'";
		}
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
