package domain;

public class Statistic implements Cloneable {
//	protected int displayValue; // calculated
	protected int base;
//	protected int ev;
//	protected int iv;	
//	private int combatValue; // combat, calculated
//	protected int modifier; // combat
//	protected float nature;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}
	
//	public void addEV(int amount) { // formula
//		assert(amount < 4);
//		ev += amount;
//		if (ev > 252)
//			ev = 252;
//	}
//	
//	public int getDisplayValue(int level) { // formula (passer lazy)
//		assert(level < 101);
//		return (int) ((((int) ((2 * base + iv + ((int) (ev / 4))) * level / 100)) + 5) * nature);
//	}
//	
//	public int getCombatValue() {
//		// todo
//		return this.combatValue;
//	}
//
//	public void setCombatValue(int combatValue) {
//		this.combatValue = combatValue;
//	}
}
