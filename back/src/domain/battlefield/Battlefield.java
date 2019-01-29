package domain.battlefield;

import domain.Player;
import domain.Trainer;

public class Battlefield {

	protected Weather weather;

	protected Player player;
	
	protected Trainer opponent;
	
//	protected Monster[] onFieldMonsters = new Monster[BattlefieldPosition.values().length]; // inferred from Trainer objects

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Trainer getOpponent() {
		return opponent;
	}

	public void setOpponent(Trainer opponent) {
		this.opponent = opponent;
	}
}
