package com.mgackowski.ships_prototype.area;

import com.mgackowski.ships_prototype.PlayerShip;

public class GoalArea extends ConcreteArea implements Area {

	public GoalArea() {
		super(AreaType.GOAL, 'X');
	}

	public void affectShip(PlayerShip ship) {
		//
	}

}