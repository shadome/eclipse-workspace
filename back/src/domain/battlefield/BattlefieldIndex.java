package domain.battlefield;

public enum BattlefieldIndex {
	TOPLEFT(0),
	TOPRIGHT(1),
	BOTLEFT(2),
	BOTRIGHT(3);
	
	private int index;
	private BattlefieldIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return this.index;
	}
}
