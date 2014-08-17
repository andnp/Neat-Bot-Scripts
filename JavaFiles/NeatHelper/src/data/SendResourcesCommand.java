package data;

public class SendResourcesCommand extends Command{
	String res;
	SendResourcesCommand(String res, String coords){
		this.res = res;
		this.coords = coords;
		this.hasReceived.add(coords);
	}
	public String issueCommand(String issueCoords){
		this.hasReceived.add(issueCoords);
		return "sendresources " + coords + " " + res + " 25000 -2 1k scout";
	}
}