package com.mgackowski.ships_prototype.area;

public class AreaFactory {
	
	public Area createArea(AreaType type) {
		
		switch(type) {
			case UNCHARTED_SEA : return new UnchartedSeaArea();
			case PLAYER_SPAWN : return new SpawnArea();
			case GOAL : return new GoalArea();
			case ROCKS : return new RocksArea();
			default : return null;
		}
		
	}

}
