package data;

public class CityBot {
	CommandCollection cc;
	CityList cl;
	long last_check_in;
	long HALF_HOUR = 1000 * 60 * 30;
	int wood = 0, food = 0, stone = 0, iron = 0, gold = 0;
	String coords;
	
	CityBot(String coords, CommandCollection cc, CityList cl){
		this.last_check_in = System.currentTimeMillis();
		this.coords = coords;
		this.cc = cc;
		this.cl = cl;
	}
	
	public boolean stillOn(){
		if(last_check_in + HALF_HOUR < System.currentTimeMillis()){
			return true;
		} else {
			return false;
		}
	}
	
	public void addRes(int food, int wood, int stone, int iron, int gold){
		this.food = food;
		this.wood = wood;
		this.stone = stone;
		this.iron = iron;
		this.gold = gold;
		
		int floatingKeep = ((food / 10) + wood + (stone / 5) + iron + gold) / 5;
		
		if(food < floatingKeep){
			cc.add(new SendResourcesCommand("food", this.coords, (floatingKeep * 10) + "", cl));
		} else {
			cc.add(new SendResourcesCommand("food", this.coords, "1000b", cl));
		}
		if(wood < floatingKeep){
			cc.add(new SendResourcesCommand("wood", this.coords, floatingKeep + "", cl));
		} else {
			cc.add(new SendResourcesCommand("wood", this.coords, "1000b", cl));
		}
		if(stone < floatingKeep){
			cc.add(new SendResourcesCommand("stone", this.coords, (floatingKeep * 5) + "", cl));
		} else {
			cc.add(new SendResourcesCommand("stone", this.coords, "1000b", cl));
		}
		if(iron < floatingKeep){
			cc.add(new SendResourcesCommand("iron", this.coords, floatingKeep + "", cl));
		} else {
			cc.add(new SendResourcesCommand("iron", this.coords, "1000b", cl));
		}
		if(gold < floatingKeep){
			cc.add(new SendResourcesCommand("gold", this.coords, floatingKeep + "", cl));
		} else {
			cc.add(new SendResourcesCommand("gold", this.coords, "1000b", cl));
		}
	}
}
