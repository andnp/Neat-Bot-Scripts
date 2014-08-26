package data;

import java.util.ArrayList;

public class CityList extends ArrayList<CityBot>{
	private static final long serialVersionUID = 1L;

	public void checkActivity(){
		ArrayList<CityBot> toRemove = new ArrayList<CityBot>();
		for(CityBot bot : this){
			if(!bot.stillOn()){
				toRemove.add(bot);
			}
		}
		for(CityBot bot : toRemove){
			this.remove(bot);
		}
	}
}
