package data;

import java.util.Calendar;

import commands.CompleteQuestsCommand;

public class TimedEventCreator implements Runnable{

	Calendar time = Calendar.getInstance();
	CommandCollection cc;
	CityList cl;
	
	public TimedEventCreator(CommandCollection cc, CityList cl){
		this.cc = cc;
		this.cl = cl;
	}
	
	public void run(){
		while(true){
			if(time.get(Calendar.MINUTE) == 0){
				cc.add(new CompleteQuestsCommand(cl));
			} else if(time.get(Calendar.MINUTE == 30)){
				for(CityBot bot : cl){
					cc.add(new SafeFarmCommand (bot, cl));
				}
			}
		}
	}
}
