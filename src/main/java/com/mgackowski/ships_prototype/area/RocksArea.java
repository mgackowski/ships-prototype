package com.mgackowski.ships_prototype.area;

import com.mgackowski.ships_prototype.PlayerShip;

public class RocksArea extends ConcreteArea implements Area {

	public RocksArea() {
		super(AreaType.ROCKS, '~');
	}

	public void affectShip(PlayerShip ship) {
		System.out.println("Hit rocks!");
		ship.setHealth(ship.getHealth() - 1);
		this.setCharacter('®');
	}

}