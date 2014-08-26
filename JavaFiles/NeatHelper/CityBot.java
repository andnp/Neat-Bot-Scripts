package data;

public class CityBot {
	long last_check_in;
	long HALF_HOUR = 1000 * 60 * 30;
	int wood = 0, food = 0, stone = 0, iron = 0, gold = 0;
	
	CityBot(){
		this.last_check_in = System.currentTimeMillis();
	}
	
	public boolean stillOn(){
		if(last_check_in + HALF_HOUR < System.currentTimeMillis()){
			return true;
		} else {
			return false;
		}
	}
}
