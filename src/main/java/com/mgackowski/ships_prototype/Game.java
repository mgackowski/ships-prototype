package com.mgackowski.ships_prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mgackowski.ships_prototype.area.Area;

public class Game {
	
	Scanner scanner;
	
	Game() {
		scanner = new Scanner(System.in);
	}
	
	private char getInput() {
	    char firstChar = scanner.next().charAt(0);
	    return firstChar;
	}
	
	public void playMap(SeaMap map, PlayerShip ship) {
		
		System.out.println("X MARKS THE SPOT");
		
		Area[][] grid = map.getGrid();
		
		ship.setPosX(map.getShipSpawnX());
		ship.setPosY(map.getShipSpawnY());
		
		boolean mapFinished = false;
		
		while(!mapFinished) {
		
			/* Print map with ship */
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if(j == ship.getPosX() && i == ship.getPosY()) {
						System.out.print(ship.getPrintedCharacter() + " ");
					} else {
						System.out.print(grid[j][i].getPrintedCharacter() + " ");
					}
				}
				System.out.print("\n");
			}
			
			System.out.println("Range: \t\t" + ship.getFuel() + " / " + ship.getMaxRange());
			System.out.println("Durability: \t" + ship.getHealth() + " / " + ship.getMaxDurability());
			System.out.println("Gold: \t\t" + ship.getGold());
			//System.out.printf("Ship position: [" + ship.getPosX() + "][" + ship.getPosY() + "]");
			
			char playerMove = getInput();
			switch(playerMove) {
				case 'W' :
				case 'w' : ship.setPosY(ship.getPosY() - 1); break;
				case 'S' :
				case 's' : ship.setPosY(ship.getPosY() + 1); break;
				case 'A' :
				case 'a' : ship.setPosX(ship.getPosX() - 1); break;
				case 'D' :
				case 'd' : ship.setPosX(ship.getPosX() + 1); break;
				default : System.err.println("Enter W/A/S/D."); continue;
			}
			
			if(ship.getPosX() == map.getGoalSpawnX() && ship.getPosY() == map.getGoalSpawnY()) {
				System.out.println("Found " + map.getgoldReward() + " gold!");
				ship.setGold(ship.getGold() + map.getgoldReward());
				mapFinished = true;
			}
			
			ship.setFuel(ship.getFuel() - 1);
			grid[ship.getPosX()][ship.getPosY()].affectShip(ship);
			
			if(ship.getFuel() <= 0) {
				System.out.println("Out of range...");
				mapFinished = true;
			}
			
			if(ship.getHealth() <= 0) {
				System.out.println("Ship destroyed!");
				mapFinished = true;
			}
			
		}
		
	}
	
	public void playTavern() {
		
		boolean gameFinished = false;
		
		PlayerShip ship = new PlayerShip();
		
		while(!gameFinished) {
		
			if(ship.getGold() <= 0) {
				System.out.println("You're broke. Game over!");
				gameFinished = true;
				continue;
			}
			
			if(ship.getHealth() <= 0) {
				System.out.println("You lost your ship. Game over!");
				gameFinished = true;
				continue;
			}
			
			List<SeaMap> maps = new ArrayList<SeaMap>();
			maps.add(new SeaMap(4,4,6,1,50,100));
			maps.add(new SeaMap(5,5,7,2,100,200));
			maps.add(new SeaMap(6,6,8,3,200,400));
			
			//reset ship
			ship.setFuel(ship.getMaxRange());
			
			System.out.println("\n-- Welcome to the Tavern --");
			System.out.println("Maps:");
			for (int i = 0; i < maps.size(); i++) {
				System.out.println((i+1) + " - cost: " + maps.get(i).getgoldPrice());
			}
			System.out.println("Services:");
			System.out.println("R - ship repair - cost: 50");
			System.out.println("M - merchant (unavailable)");
			
			System.out.println("\nRange: \t\t" + ship.getFuel() + " / " + ship.getMaxRange());
			System.out.println("Durability: \t" + ship.getHealth() + " / " + ship.getMaxDurability());
			System.out.println("Gold: \t\t" + ship.getGold());
			
			char playerChoice = getInput();
			switch(playerChoice) {
				case 'R' :
				case 'r' : System.err.println("Not implemented."); break;
				case 'M' :
				case 'm' : System.err.println("Not implemented."); break;
				case '1' : 
					if (ship.getGold() >= maps.get(0).getgoldPrice()) {
						ship.setGold(ship.getGold() - maps.get(0).getgoldPrice());
						playMap(maps.get(0),ship);
					} else {
						System.err.println("Not enough coin!");
					}
					break;
				case '2' : 
					if (ship.getGold() >= maps.get(1).getgoldPrice()) {
						ship.setGold(ship.getGold() - maps.get(1).getgoldPrice());
						playMap(maps.get(1),ship);
					} else {
						System.err.println("Not enough coin!");
					}
					break;
				case '3' : 
					if (ship.getGold() >= maps.get(2).getgoldPrice()) {
						ship.setGold(ship.getGold() - maps.get(2).getgoldPrice());
						playMap(maps.get(2),ship);
					} else {
						System.err.println("Not enough coin!");
					}
					break;
				default : System.err.println("Enter one of the options."); break;
			}
			
		}
		
	}

}
