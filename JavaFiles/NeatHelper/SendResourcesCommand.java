package data;

public class SendResourcesCommand extends Command{
	String res;
	int timesIssuable = 2;
	SendResourcesCommand(String res, String coords, String amount){
		this.res = res;
		this.coords = coords;
		this.hasReceived.add(coords);
		this.timeIssued = System.currentTimeMillis();
		if(!res.equals("gold")){
			command = "if(city.resource." + res + ".amount > 25000) sendresources " + coords + " " + res + " " + amount + " -2 -1 scout";
		} else {
			command = "if(city.resource." + res + " > 25000) sendresources " + coords + " " + res + " " + amount + " -2 -1 scout";
		}
		System.out.println(command);
	}
	public String issueCommand(String issueCoords){
		this.hasReceived.add(issueCoords);
		return command;
	}
	public boolean equals(Command com){
		if(com.command != this.command) return false;
		return true;
	}	
}
