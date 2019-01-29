package domain;

import domain.MoveCategory;
import domain.Type;

public class Move {
	protected Type type;
	protected MoveCategory category;
//	protected int pp;
	protected int power;
//	protected int accuracy;
	protected boolean[] canTargetFriend = new boolean[6];
	protected boolean[] canTargetOpponent = new boolean [6];
}
