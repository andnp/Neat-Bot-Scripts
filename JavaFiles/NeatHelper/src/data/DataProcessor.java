package data;

public class DataProcessor implements Runnable{
	private static String processString = "";
	CommandCollection cc;
	public void run(){
		processInput();
	}
	public void processInput(){
		if(processString.contains("sendresources")){
			String coords = processString.substring(processString.indexOf("("), processString.indexOf(")"));
			if(processString.contains(" f ")){
				SendResourcesCommand command = new SendResourcesCommand("food", coords);
				if(!cc.exists(command)) cc.add(command);
			}
			if(processString.contains(" w ")){
				SendResourcesCommand command = new SendResourcesCommand("wood", coords);
				if(!cc.exists(command)) cc.add(command);
			}
			if(processString.contains(" s ")){
				SendResourcesCommand command = new SendResourcesCommand("stone", coords);
				if(!cc.exists(command)) cc.add(command);
			}
			if(processString.contains(" i ")){
				SendResourcesCommand command = new SendResourcesCommand("iron", coords);
				if(!cc.exists(command)) cc.add(command);
			}
			if(processString.contains(" g ")){
				SendResourcesCommand command = new SendResourcesCommand("gold", coords);
				if(!cc.exists(command)) cc.add(command);
			}
		}
	}
	DataProcessor(String input, CommandCollection cc){
		processString = input;
		this.cc = cc;
	}
}
