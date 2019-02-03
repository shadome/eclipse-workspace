package domain.battlefield;

public enum BattlefieldPosition {
	SELF(0),
	FRIEND(1),
	DIRECT_ENEMY(0),
	BOTTOM_RIGHT(1),
	PLAYER_TEAM_1(2),
	PLAYER_TEAM_2(3),
	PLAYER_TEAM_3(4),
	;
	
	private int index;
	private BattlefieldPosition(int index) {
		this.index = index;
	}
	public int getIndex() {
		return this.index;
	}
}
