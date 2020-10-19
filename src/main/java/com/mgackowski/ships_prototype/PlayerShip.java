package com.mgackowski.ships_prototype;

import java.util.HashMap;
import java.util.Map;

public class PlayerShip {
	
	private int posX;
	private int posY;
	
	private int maxDurability;
	private int maxRange;
	
	private int health;
	private int fuel;
	private long gold;
	
	private Map<String, Integer> inventory;

	PlayerShip() {
		
		
		this.maxDurability = 2;
		this.maxRange = 9;
		this.health = maxDurability;
		this.fuel = maxRange;
		this.gold = 200;
		this.inventory = new HashMap<String, Integer>();
	}

	public int getMaxDurability() {
		return maxDurability;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public int getHealth() {
		return health;
	}

	public int getFuel() {
		return fuel;
	}

	public Map<String, Integer> getInventory() {
		return inventory;
	}

	public void setMaxDurability(int maxDurability) {
		this.maxDurability = maxDurability;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	
	public char getPrintedCharacter() {
		return '±';
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public long getGold() {
		return gold;
	}

	public void setGold(long gold) {
		this.gold = gold;
	}
	
	


}
