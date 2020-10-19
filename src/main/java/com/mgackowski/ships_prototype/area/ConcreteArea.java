package com.mgackowski.ships_prototype.area;

import com.mgackowski.ships_prototype.PlayerShip;

public class ConcreteArea {
	
	private AreaType type;
	private char character;

	public ConcreteArea(AreaType type, char character) {
		this.type = type;
		this.character = character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public AreaType getType() {
		return this.type;
	}

	public char getPrintedCharacter() {
		return this.character;
	}

	public void affectShip(PlayerShip ship) {
		// TODO Auto-generated method stub
	}

}