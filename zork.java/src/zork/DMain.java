package zork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DMain
{
	/* DUNGEON-- MAIN PROGRAM */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	public static void main(String[] args)
			throws IOException /* void changed to int, Volker Blasius, 11jul93 */
	{
		/* 1) INITIALIZE DATA STRUCTURES */
		/* 2) PLAY GAME */
		Vars vars = new Vars();
		DInit init = new DInit(vars);
		Dgame game = new Dgame(vars, init);

		if (init.init_())
		{
			game.game_();
		}
		/* !IF INIT, PLAY GAME. */
		Supp.exit_();
		/* !DONE */
	} /* MAIN__ */

	/**
	 * Walkthrough provided by
	 * http://www.deblauweschicht.nl/retrogaming/resources/MainframeZork_walkthrough.txt
	 **/

	private static String[] moves = new String[] { 
			// part 1 //
			"look", "open mailbox", "read leaflet", "n", "n", "climb tree", "take egg", "d", "w",
			"e", "open window", "w", "w", "read report", "drop report", "drop leaflet",
			"take lantern", "move rug", "open trap door",
			// part 2 //
			"d", "turn on lamp", "put down egg", "s", "s", "take painting", "s", "u",
			"turn off lamp", "w", "open trophy case", "put painting in case",
			// part 3 //
			"get sword", "open trap door", "d", "turn on lamp", "e", "kill troll with sword",
			"kill troll with sword", "kill troll with sword", "kill troll with sword",
			"kill troll with sword", "s", "s", "e", "u", "take keys", "take bag", "sw", "u", "e",
			"ne", "unlock grate with key", "open grate", "turn off lamp", "u", "sw ", "w",
			"take bottle", "drop sword", "drop keys", "w", "put bag in case",

			// part 4 //
			"open trap door", "d", "turn on lamp", "e", "n", "e"
				// done to satisify RNG //
			, "e", "W" // grail room
			, "e", "e", "n", "n", "w", // winding room
				// end RNG //
			"s", "se", "well", "e", "get necklace", "e", "board bucket", // engravings room
			"open bottle", "pour water in bucket", 
			"disembark bucket", "e", "take all",
			"eat eat-me cake", "e", "throw red cake at pool", "take spices", "w", "eat blue cake",
			"drop orange cake", "nw", "read green paper", 
//			"tell robot 'east'", "e",
//			"tell robot 'push triangular button'", "tell robot 'go south'", "s", "take sphere",
//			"tell robot 'lift cage'", "take sphere", "n", "w", "se", "w", "get in bucket",
//			"get water", "disembark bucket", "w", "w", "d", "n", "open box", "take violin", "w", "w",
//			"w", "u", "turn off lamp", "put sphere in trophy case", "put necklace in trophy case",
//			"put spices in trophy case", "put violin in trophy case", "drop bottle",
//			"drop green paper",
			// FINAL //
			"LOOK"

	};

	private static int word_index;

	public static BufferedReader words_file = null;
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static String getInput() throws IOException
	{
		try
		{
			if (words_file == null)
			{
//				words_file = new BufferedReader(new FileReader(new File("walkthrough.txt")));
		
				if (words_file != null)
				{
					ArrayList<String> words = new ArrayList<String>();
					String buf = "";
					while ((buf = words_file.readLine()) != null)
					{
						if (buf.length() != 0 && buf.charAt(0) != '#')
							words.add(buf.substring(2));
					}
					moves = words.toArray(new String[0]);
				}
			}
		}
		catch (FileNotFoundException fnfe)
		{
		}

		String word = "";
		if (word_index < moves.length)
		{
			
			word = moves[word_index];
			System.err.println(word);
			word_index++;
		}
		else
		{
			while (word.length() == 0)
				word = reader.readLine();
		}
		return word;
	}

}
