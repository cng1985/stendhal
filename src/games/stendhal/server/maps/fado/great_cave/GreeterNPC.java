package games.stendhal.server.maps.fado.great_cave;

import games.stendhal.server.StendhalRPZone;
import games.stendhal.server.config.ZoneConfigurator;
import games.stendhal.server.entity.npc.SellerBehaviour;
import games.stendhal.server.entity.npc.ShopList;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.pathfinder.FixedPath;
import games.stendhal.server.pathfinder.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Builds a Wizard NPC who explains about the city  
 *
 * @author kymara
 */
public class GreeterNPC implements ZoneConfigurator {
	private ShopList shops = ShopList.get();

	/**
	 * Configure a zone.
	 *
	 * @param	zone		The zone to be configured.
	 * @param	attributes	Configuration attributes.
	 */
	public void configureZone(StendhalRPZone zone, Map<String, String> attributes) {
		buildNPC(zone);
	}

	private void buildNPC(StendhalRPZone zone) {
		SpeakerNPC npc = new SpeakerNPC("Erodel Bmud") {

			@Override
			protected void createPath() {
				List<Node> nodes = new LinkedList<Node>();
				nodes.add(new Node(99, 111));
				nodes.add(new Node(106, 111));
				nodes.add(new Node(106, 98));
				nodes.add(new Node(105, 98));
				nodes.add(new Node(105, 89));
				nodes.add(new Node(107, 89));
				nodes.add(new Node(107, 44));
				nodes.add(new Node(104, 44));
				nodes.add(new Node(104, 40));
				nodes.add(new Node(57, 40));
				nodes.add(new Node(57, 51));
				nodes.add(new Node(93, 51));
				nodes.add(new Node(57, 51));
				nodes.add(new Node(57, 40));
				nodes.add(new Node(104, 40));
				nodes.add(new Node(104, 44));
				nodes.add(new Node(107, 44));
				nodes.add(new Node(107, 89));
				nodes.add(new Node(105, 89));
				nodes.add(new Node(105, 98));
				nodes.add(new Node(106, 98));
				nodes.add(new Node(106, 111));
				setPath(new FixedPath(nodes, true));
			}

			@Override
			protected void createDialog() {
			        addGreeting("Salutations, traveller.");
				addJob("I am a wizard, like all who dwell in this underground city. We practise #magic here.");
				addReply("magic","Indeed, enchantments such as our Sunlight Spell to keep the grass and flowers healthy down here. I suppose you are wondering why you have seen traditional enemies such as dark elves and green elves in company together here, let me #explain.");
				addReply("explain","As a city for wizards only, we have much to learn from one another. Thus, old quarrels are forgotten and we live here in peace.");
				addHelp("It is part of my #job to #offer you enchanted scrolls to travel to any major city in Faiumoni. I also have a supply of scrolls you may mark, and some scrolls to summon creatures. Be aware, they do not come cheap.");
				addSeller(new SellerBehaviour(shops.get("allscrolls")) {

					@Override
					public int getUnitPrice(String item) {
						// Player pays 150 % of standard price
						return (int) (1.50f * priceList.get(item));
					}
				});
				addQuest("Neither can live while the other survives! The Dark Lord must be killed...no ... wait... that was some other time. Forgive me for confusing you, I need nothing.");
 				addGoodbye("Adieu.");
			}
		};

		npc.setDescription("You see a friendly looking elderly wizard.");
		npc.setEntityClass("friendlywizardnpc");
		npc.setPosition(99, 111);
		npc.initHP(100);
		zone.add(npc);
	}
}
