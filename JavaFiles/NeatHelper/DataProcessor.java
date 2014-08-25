package data;

public class DataProcessor implements Runnable{
	private static String processString = "";
	CommandCollection cc;
	public void run(){
		processInput();
	}
	public void processInput(){
		if(processString.contains("sendresources")){
			processSendResources();
		}
	}
	DataProcessor(String input, CommandCollection cc){
		processString = input;
		this.cc = cc;
	}
	
	private void processSendResources(){
		String coords = processString.substring(processString.indexOf("(") + 1, processString.indexOf(")"));
		if(processString.contains(" f ")){
			SendResourcesCommand command = new SendResourcesCommand("food", coords, "25000");
			if(!cc.exists(command)) cc.add(command);
		} else {
			SendResourcesCommand command = new SendResourcesCommand("food", coords, "1000b");
			if(!cc.exists(command)) cc.add(command);
		}
		if(processString.contains(" w ")){
			SendResourcesCommand command = new SendResourcesCommand("wood", coords, "25000");
			if(!cc.exists(command)) cc.add(command);
		}else {
			SendResourcesCommand command = new SendResourcesCommand("wood", coords, "1000b");
			if(!cc.exists(command)) cc.add(command);
		}
		if(processString.contains(" s ")){
			SendResourcesCommand command = new SendResourcesCommand("stone", coords, "25000");
			if(!cc.exists(command)) cc.add(command);
		}else {
			SendResourcesCommand command = new SendResourcesCommand("stone", coords, "1000b");
			if(!cc.exists(command)) cc.add(command);
		}
		if(processString.contains(" i ")){
			SendResourcesCommand command = new SendResourcesCommand("iron", coords, "25000");
			if(!cc.exists(command)) cc.add(command);
		}else {
			SendResourcesCommand command = new SendResourcesCommand("iron", coords, "1000b");
			if(!cc.exists(command)) cc.add(command);
		}
		if(processString.contains(" g ")){
			SendResourcesCommand command = new SendResourcesCommand("gold", coords, "25000");
			if(!cc.exists(command)) cc.add(command);
		}else {
			SendResourcesCommand command = new SendResourcesCommand("gold", coords, "1000b");
			if(!cc.exists(command)) cc.add(command);
		}
	}
}
