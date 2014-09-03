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
	public void addCity(CityBot newBot){
		boolean canAdd = true;
		for(CityBot bot : this){
			if(bot.coords.equals(newBot.coords)){
				canAdd = false;
			}
		}
		if(canAdd) this.add(newBot);
	}
	public CityBot getByCoords(String coords){
		for(CityBot bot : this){
			if(bot.coords.equals(coords)) return bot;
		}
		return null;
	}
}
