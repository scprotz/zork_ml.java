package zork;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Supp
{
	/* Terminate the game */

	public static void exit_() throws IOException
	{
		System.err.println("The game is over.");
	    System.exit(0);
	}

	/* Get time in hours, minutes and seconds */

	public static void itime_(int[] hrptr, int[] minptr, int[] secptr)
	{
		GregorianCalendar cal = new GregorianCalendar();

		hrptr[0] = cal.get(Calendar.HOUR_OF_DAY);
		minptr[0] = cal.get(Calendar.MINUTE);
		secptr[0] = cal.get(Calendar.SECOND);
	}

	
	private static Random random  = new Random();
	
	public static void srand(long seed)
	{
		random.setSeed(seed);
	}

	static int rndcnt = 1;
	public static int rnd_(int maxval)
	{
		rndcnt ++;
		return rndcnt % maxval;
	}
}
