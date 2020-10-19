package com.mgackowski.ships_prototype;

import com.mgackowski.ships_prototype.area.Area;
import com.mgackowski.ships_prototype.area.AreaFactory;
import com.mgackowski.ships_prototype.area.AreaType;

public class SeaMap {
	
	private Area[][] grid;
	private long goldPrice;
	private long goldReward;
	
	private int shipSpawnX;
	private int shipSpawnY;
	private int goalSpawnX;
	private int goalSpawnY;
	
	SeaMap(int width,int height,int goalDistance, int rocks, long goldPrice, long goldReward) {
		generateMap(width, height, goalDistance, rocks);
		this.goldPrice = goldPrice;
		this.goldReward = goldReward;
	};

	public int getGoalSpawnX() {
		return goalSpawnX;
	}

	public int getGoalSpawnY() {
		return goalSpawnY;
	}

	public int getShipSpawnX() {
		return shipSpawnX;
	}

	public int getShipSpawnY() {
		return shipSpawnY;
	}
	
	public long getgoldPrice() {
		return goldPrice;
	}
	
	public long getgoldReward() {
		return goldReward;
	}

	private void generateMap(int width,int height,int goalDistance, int rocks) {
		
		this.grid = new Area[width][height];
		
		if (goalDistance > width + height - 2) {
			System.err.println("Can't fit the desired goal in the map");
			return;
		}
		
		int goalPathWidth;
		int goalPathHeight;
		do {
			goalPathWidth = (int) Math.floor(Math.random() * goalDistance);
			goalPathHeight = goalDistance - goalPathWidth;
		}
		while(goalPathWidth >= width || goalPathHeight >= height);
		
		int spawnMaxOffsetX = width - goalPathWidth;
		int spawnMaxOffsetY = height - goalPathHeight;
		
		int spawnLocationX = (int) Math.floor(Math.random() * spawnMaxOffsetX);
		int spawnLocationY = (int) Math.floor(Math.random() * spawnMaxOffsetY);
		
		int goalLocationX = spawnLocationX + goalPathWidth;
		int goalLocationY = spawnLocationY + goalPathHeight;
		
		AreaFactory factory = new AreaFactory();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = factory.createArea(AreaType.UNCHARTED_SEA);
			}
		}
		
		if (Math.random() < 0.5) {
			grid[spawnLocationX][spawnLocationY] = factory.createArea(AreaType.PLAYER_SPAWN);
			grid[goalLocationX][goalLocationY] = factory.createArea(AreaType.GOAL);
			this.shipSpawnX = spawnLocationX;
			this.shipSpawnY = spawnLocationY;
			this.goalSpawnX = goalLocationX;
			this.goalSpawnY = goalLocationY;
		} else {
			grid[spawnLocationX][spawnLocationY] = factory.createArea(AreaType.GOAL);
			grid[goalLocationX][goalLocationY] = factory.createArea(AreaType.PLAYER_SPAWN);
			this.shipSpawnX = goalLocationX;
			this.shipSpawnY = goalLocationY;
			this.goalSpawnX = spawnLocationX;
			this.goalSpawnY = spawnLocationY;
		}
		
		for (int r = 0; r < rocks; r++) {
			while(true) {
				int rockSpawnX = (int) Math.floor(Math.random() * width);
				int rockSpawnY = (int) Math.floor(Math.random() * height);
				if(grid[rockSpawnX][rockSpawnY].getType() == AreaType.UNCHARTED_SEA) {
					grid[rockSpawnX][rockSpawnY] = factory.createArea(AreaType.ROCKS);
					break;
				}
			}	
		}
		
	}
	
	
	
	public Area[][] getGrid() {
		return grid;
	}



	public void printToConsole() {
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[j][i].getPrintedCharacter() + " ");
			}
			System.out.print("\n");
		}
		
		
	}
	
	

}
