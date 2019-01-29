package domain;

import java.util.List;

import domain.Move;
import domain.Statistic;
import domain.Type;

public class Monster implements Cloneable {
	protected int number;
	protected String name;
	protected int level;
	protected Type type1;
	protected Type type2;

	/** Moves usable during a battle. */
	protected Move[] moveset = new Move[4]; // TODO magic number
	/** List of moves learnt by the monster from which a move set is extracted. */
	protected List<Move> trainedMoves;

//	private HPStatistic hp;
	protected int hp; // percent
	protected Statistic attack;
	protected Statistic defense;
	protected Statistic spattack;
	protected Statistic spdefense;
	protected Statistic speed;

	// TODO protected XXX icon;
	// TODO protected XXX frontSprite;
	// TODO protected XXX backSprite;

	// TODO protected Item heldItem;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Monster m = (Monster) super.clone();
		m.attack = (Statistic) m.attack.clone();
		m.defense = (Statistic) m.defense.clone();
		m.spattack = (Statistic) m.spattack.clone();
		m.spdefense = (Statistic) m.spdefense.clone();
		m.speed = (Statistic) m.speed.clone();
		// moves should not get cloned
		return m;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Type getType1() {
		return type1;
	}

	public void setType1(Type type1) {
		this.type1 = type1;
	}

	public Type getType2() {
		return type2;
	}

	public void setType2(Type type2) {
		this.type2 = type2;
	}

	public Move[] getMoveset() {
		return moveset;
	}

	public void setMoveset(Move[] moveset) {
		this.moveset = moveset;
	}

	public List<Move> getTrainedMoves() {
		return trainedMoves;
	}

	public void setTrainedMoves(List<Move> trainedMoves) {
		this.trainedMoves = trainedMoves;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Statistic getAttack() {
		return attack;
	}

	public void setAttack(Statistic attack) {
		this.attack = attack;
	}

	public Statistic getDefense() {
		return defense;
	}

	public void setDefense(Statistic defense) {
		this.defense = defense;
	}

	public Statistic getSpattack() {
		return spattack;
	}

	public void setSpattack(Statistic spattack) {
		this.spattack = spattack;
	}

	public Statistic getSpdefense() {
		return spdefense;
	}

	public void setSpdefense(Statistic spdefense) {
		this.spdefense = spdefense;
	}

	public Statistic getSpeed() {
		return speed;
	}

	public void setSpeed(Statistic speed) {
		this.speed = speed;
	}
}
