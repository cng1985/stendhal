/*
 * @(#) games/stendhal/client/entity/Blood2DView.java
 *
 * $Id$
 */

package games.stendhal.client.entity;

//
//

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Map;

import marauroa.common.game.RPObject;

import games.stendhal.client.AnimatedSprite;
import games.stendhal.client.SpriteStore;

/**
 * The 2D view of blood.
 */
public class Blood2DView extends AnimatedStateEntity2DView {
	/**
	 * Create a 2D view of blood.
	 *
	 * @param	entity		The entity to render.
	 */
	public Blood2DView(final Blood blood) {
		super(blood);
	}


	//
	// AnimatedStateEntity2DView
	//

	/**
	 * Populate named state sprites.
	 *
	 * @param	map		The map to populate.
	 * @param	object		The entity to load sprites for.
	 */
	protected void buildSprites(Map<String, AnimatedSprite> map, RPObject object) {
		SpriteStore store = SpriteStore.get();

		map.put("0", store.getAnimatedSprite("data/sprites/combat/blood_red.png", 0, 1, 1, 1, 0L, false));
		map.put("1", store.getAnimatedSprite("data/sprites/combat/blood_red.png", 1, 1, 1, 1, 0L, false));
		map.put("2", store.getAnimatedSprite("data/sprites/combat/blood_red.png", 2, 1, 1, 1, 0L, false));
		map.put("3", store.getAnimatedSprite("data/sprites/combat/blood_red.png", 3, 1, 1, 1, 0L, false));
	}


	/**
	 * Get the default state name.
	 * <strong>All sub-classes MUST provide a <code>0</code>
	 * named animation, or override this method</strong>.
	 */
	protected String getDefaultState() {
		return "0";
	}


	//
	// Entity2DView
	//

	/**
	 * Get the 2D area that is drawn in.
	 *
	 * @return	The 2D area this draws in.
	 */
	@Override
	public Rectangle2D getDrawnArea() {
		return new Rectangle.Double(getX(), getY(), 1.0, 1.0);
	}


	/**
	 * Determines on top of which other entities this entity should be
	 * drawn. Entities with a high Z index will be drawn on top of ones
	 * with a lower Z index.
	 * 
	 * Also, players can only interact with the topmost entity.
	 * 
	 * @return	The drawing index.
	 */
	public int getZIndex() {
		return 2000;
	}
}
