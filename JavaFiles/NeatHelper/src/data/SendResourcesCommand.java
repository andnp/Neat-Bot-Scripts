package data;

public class SendResourcesCommand extends Command{
	String res;
	int issuable = 5;
	SendResourcesCommand(String res, String coords){
		this.res = res;
		this.coords = coords;
		this.hasReceived.add(coords);
		command = "sendresources " + coords + " " + res + " 25000 -2 1k scout";
		System.out.println(command);
	}
	public String issueCommand(String issueCoords){
		this.hasReceived.add(issueCoords);
		timesIssued++;
		return command;
	}
	public boolean equals(Command com){
		if(com.command != this.command) return false;
		return true;
	}
}
