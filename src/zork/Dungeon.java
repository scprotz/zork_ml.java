package zork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dungeon
{
	public static void main(String[] args)
	{
		Dgame game = new Dgame();
		game.game_();
		
		// Read the walkthrough file //
		ArrayList<String> actions = new ArrayList<String>();
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(new File("walkthrough.properties")));
			String line = "";
			while ((line = reader.readLine()) != null)
			{
				// as long as it doesn't start as comment or empty line, use it //
				if (line.length() != 0 && line.charAt(0) != '#')											
					actions.add(line);				
			}			
		}
		catch (FileNotFoundException fnfe)
		{
			System.err.println("Could not find walkthrough.properties file.");
			fnfe.printStackTrace();
		}
		catch (IOException ioe)
		{
			System.err.println("Could not read walkthrough file.");
			ioe.printStackTrace();
		}
			
		for(String action : actions)
		{
			System.err.println(action);
			System.err.flush();						
			game.doTurn(action);
		}
		
		Supp.exit_();
	}
}
