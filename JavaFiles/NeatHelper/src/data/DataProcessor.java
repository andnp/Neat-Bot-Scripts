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
				cc.add( new SendResourcesCommand("food", coords));
			}
			if(processString.contains(" w ")){
				cc.add( new SendResourcesCommand("wood", coords));
			}
			if(processString.contains(" s ")){
				cc.add( new SendResourcesCommand("stone", coords));
			}
			if(processString.contains(" i ")){
				cc.add( new SendResourcesCommand("iron", coords));
			}
			if(processString.contains(" g ")){
				cc.add( new SendResourcesCommand("gold", coords));
			}
		}
	}
	DataProcessor(String input, CommandCollection cc){
		processString = input;
		this.cc = cc;
	}
}
