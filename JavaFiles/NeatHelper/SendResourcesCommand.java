package data;

public class SendResourcesCommand extends Command{
	String res;
	int timesIssuable = 2;
	SendResourcesCommand(String res, String coords, String amount, CityList cl){
		this.cl = cl;
		this.res = res;
		this.coords = coords;
		this.hasReceived.add(coords);
		this.timeIssued = System.currentTimeMillis();
		command = "sendresources " + coords + " " + res + " " + amount + " -2 -1 scout";
		System.out.println(command);
	}
	public String issueCommand(CityBot bot){
		this.hasReceived.add(bot.coords);
		return command;
	}
	public boolean equals(Command com){
		if(com.command != this.command) return false;
		return true;
	}	
}
