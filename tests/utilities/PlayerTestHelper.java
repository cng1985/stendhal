package utilities;

import games.stendhal.server.entity.player.Player;
import marauroa.common.game.RPObject;

public class PlayerTestHelper  {

	public static Player createPlayer() {
		PlayerHelper.generatePlayerRPClasses();
		Player pl = new Player(new RPObject());
		PlayerHelper.addEmptySlots(pl);
		return pl;
	}

}
