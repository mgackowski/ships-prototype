package com.mgackowski.ships_prototype.area;

import com.mgackowski.ships_prototype.PlayerShip;

public class UnchartedSeaArea extends ConcreteArea implements Area {

	public UnchartedSeaArea() {
		super(AreaType.UNCHARTED_SEA, '~');
	}

	public void affectShip(PlayerShip ship) {
		this.setCharacter('·');
	}

}