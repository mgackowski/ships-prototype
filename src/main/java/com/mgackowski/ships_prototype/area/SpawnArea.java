package com.mgackowski.ships_prototype.area;

import com.mgackowski.ships_prototype.PlayerShip;

public class SpawnArea extends ConcreteArea implements Area {

	public SpawnArea() {
		super(AreaType.PLAYER_SPAWN, 's');
	}

	public void affectShip(PlayerShip ship) {
		// TODO Auto-generated method stub
	}

}