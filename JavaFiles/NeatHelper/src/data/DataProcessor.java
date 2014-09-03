package data;

import java.util.Scanner;

public class DataProcessor implements Runnable{
	private static String processString = "";
	CommandCollection cc;
	CityList cl;
	public void run(){
		processInput();
	}
	public void processInput(){
		if(processString.contains("CheckIn")){
			processCheckIn();
		} else if(processString.contains("Troops")){
			processTroops();
		}
	}
	DataProcessor(String input, CommandCollection cc, CityList cl){
		processString = input;
		this.cc = cc;
		this.cl = cl;
	}
	
	private void processCheckIn(){
		String coords = processString.substring(processString.indexOf("(") + 1, processString.indexOf(")"));
		Scanner sc = new Scanner(processString.substring( processString.indexOf(")") + 1 ));
		CityBot bot = cl.getByCoords(coords);
		if(bot == null){
			bot = new CityBot(coords, cc, cl);
		}
		
		
		bot.addRes((int)sc.nextInt(),(int)sc.nextInt(),(int)sc.nextInt(),(int)sc.nextInt(),(int)sc.nextInt());
		cl.addCity(bot);
		sc.close();
	}
	private void processTroops(){
		String coords = processString.substring(processString.indexOf("(") + 1, processString.indexOf(")"));
		CityBot bot = cl.getByCoords(coords);
		bot.addTroops(processString.substring( processString.indexOf(")") + 1 ));
	}
}
