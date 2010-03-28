package games.stendhal.server.maps.semos.wizardstower;

import games.stendhal.server.core.config.ZoneConfigurator;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.core.rule.EntityManager;
import games.stendhal.server.entity.creature.Creature;

import java.util.Map;

public class ThirdFloorCreatures implements ZoneConfigurator {

	/**
	 * Configure a zone.
	 * 
	 * @param	zone		The zone to be configured.
	 * @param	attributes	Configuration attributes.
	 */

	public void configureZone(final StendhalRPZone zone, final Map<String, String> attributes) {
		buildThirdFloor(zone, attributes);
	}

	private void buildThirdFloor(final StendhalRPZone zone, final Map<String, String> attributes) {
		final EntityManager manager = SingletonRepository.getEntityManager();

		final Creature creature = manager.getCreature("fallen warrior");
		final Creature creature1 = manager.getCreature("high lich");
		final Creature creature2 = manager.getCreature("elder skeleton");
		final Creature creature3 = manager.getCreature("fallen high priest");

		creature1.setName("archlich");

		creature.clearDropItemList();
		creature1.clearDropItemList();
		creature2.clearDropItemList();
		creature3.clearDropItemList();

		creature.setXP(0);
		creature1.setXP(0);
		creature2.setXP(0);
		creature3.setXP(0);
		
		creature.setPosition(15,2);
		creature1.setPosition(1,15);
		creature2.setPosition(15,28);
		creature3.setPosition(29,15);

		zone.add(creature);
		zone.add(creature1);
		zone.add(creature2);
		zone.add(creature3);
	}
}
