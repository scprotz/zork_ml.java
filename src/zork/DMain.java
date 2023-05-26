package zork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

	private static String[] moves = new String[] {};

	private static int word_index;

	public static BufferedReader words_file = null;
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static String getInput() throws IOException
	{
		try
		{
			if (words_file == null)
			{
				words_file = new BufferedReader(new FileReader(new File("test.properties")));
		
				if (words_file != null)
				{
					ArrayList<String> words = new ArrayList<String>();
					String buf = "";
					while ((buf = words_file.readLine()) != null)
					{
						if (buf.length() != 0 && buf.charAt(0) != '#')
						{							
							words.add(buf);
						}
					}
					moves = words.toArray(new String[0]);
				}
			}
		}
		catch (FileNotFoundException fnfe)
		{
		}
		System.out.flush();
		System.err.flush();
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
