package com.mgackowski.ships_prototype.area;

import com.mgackowski.ships_prototype.PlayerShip;

public interface Area {
	
	AreaType getType();
	char getPrintedCharacter();
	void affectShip(PlayerShip ship);

}
