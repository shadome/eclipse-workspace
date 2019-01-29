package domain;

import java.util.ArrayList;

public class Trainer extends Character {
	
	protected ArrayList<Monster> team = new ArrayList<Monster>(6); // TODO magic number

	public ArrayList<Monster> getTeam() {
		return team;
	}

}
