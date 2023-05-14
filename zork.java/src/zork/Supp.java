package zork;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Supp
{
	
	
	
	/* supp.c -- support routines for dungeon */

//	#include <stdio.h>

//	#ifdef unix
//	#include <sys/types.h>
//	#endif

//	#ifdef BSD4_2
//	#include <sys/time.h>
//	#else /* ! BSD4_2 */
//	#include <time.h>
//	#endif /* ! BSD4_2 */

//	#include "funcs.h"

	/* Define these here to avoid using <stdlib.h> */

	/* We should have a definition for time_t and struct tm by now.  Make
	 * sure we have definitions for the functions we want to call.
	 * The argument to localtime should be P((final time_t *)), but Ultrix
	 * 4.0 leaves out the final in their prototype.  Damn them.
	 */
	/* Terminate the game */

	public static void exit_() throws IOException
	{
		DMain.reader.close();
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

	/* Random number generator */
	
	private static Random random  = new Random();
	
	public static void srand(long seed)
	{
		random.setSeed(seed);
	}

	public static int rnd_(int maxval)
	{
		return (int)(util.Random.randint() % maxval);
//		return random.nextInt(maxval);		
	}

	/* Terminal support routines for dungeon */
	/* By Ian Lance Taylor ian@airs.com or uunet!airs!ian */

	/* The dungeon game can often output long strings, more than enough
	 * to overwhelm a typical 24 row terminal (I assume that back when
	 * dungeon was written people generally used paper terminals (I know
	 * I did) so this was not a problem).  The functions in this file
	 * provide a very simplistic ``more'' facility.  They are necessarily
	 * somewhat operating system dependent, although I have tried to
	 * minimize it as much as I could.
	 */

	/* The following macro definitions may be used to control how these
	 * functions work:
	 *
	 *	MORE_NONE	Don't use the more facility at all
	 *	MORE_24		Always assume a 24 row terminal
	 *	MORE_TERMCAP	Use termcap routines to get rows of terminal
	 *	MORE_TERMINFO	Use terminfo routines to get rows of terminal
	 *	MORE_AMOS	Use AMOS monitor calls to get rows of terminal
	 *
	 * If none of these are defined then this will use termcap routines on
	 * unix and AMOS routines on AMOS.
	 */

//	#ifndef MORE_NONE
//	#ifndef MORE_24
//	#ifndef MORE_TERMCAP
//	#ifndef MORE_TERMINFO
//	#ifndef MORE_AMOS
//	#ifdef __AMOS__
//	#define MORE_AMOS
//	#else /* ! __AMOS__ */
//	#ifdef unix
//	#define MORE_TERMCAP
//	#else /* ! unix */
//	#define MORE_NONE
//	#endif /* ! unix */
//	#endif /* ! __AMOS__ */
//	#endif /* ! MORE_AMOS */
//	#endif /* ! MORE_TERMINFO */
//	#endif /* ! MORE_TERMCAP */
//	#endif /* ! MORE_24 */
//	#endif /* ! MORE_NONE */

//	#ifdef MORE_TERMCAP

//	extern char *getenv P((final char *));
//	extern void tgetent P((char *, final char *));
//	extern int tgetnum P((final char *));

//	#else /* ! MORE_TERMCAP */

//	#ifdef MORE_TERMINFO

//	#include <cursesX.h>
//	#include <term.h>
//	extern void setupterm P((final char *, int, int));

//	#else /* ! MORE_TERMINFO */

//	#ifdef MORE_AMOS

//	#include <moncal.h>
//	#include <unistd.h>

//	#endif /* MORE_AMOS */
//	#endif /* ! MORE_TERMINFO */
//	#endif /* ! MORE_TERMCAP */

	/* Initialize the more waiting facility (determine how many rows the
	 * terminal has).
	 */

//	private static int crows;
//	private static int coutput;

	public static void more_init()
	{
//	#ifdef MORE_NONE

//	    crows = 0;

//	#else /* ! MORE_NONE */
//	#ifdef MORE_24

//	    crows = 24;

//	#else /* ! MORE_24 */
//	#ifdef MORE_TERMCAP

//	    char buf[2048];
//	    char *term;
//
//	    term = getenv("TERM");
//	    if (term == NULL)
//		crows = 0;
//	    else {
//		tgetent(buf, term);
//		crows = tgetnum("li");
//	    }
//
//	#else /* ! MORE_TERMCAP */
//	#ifdef MORE_TERMINFO

//	    int i;
//
//	    setupterm(NULL, 1, &i);
//	    if (i != 1)
//	        crows = 0;
//	    else
//		crows = lines;
//
//	#else /* ! MORE_TERMINFO */
//	#ifdef MORE_AMOS
//
//	    trm_char st;
//
//	    if (isatty(fileno(stdin)) == 0)
//		crows = 0;
//	    else {
//		    trmchr(&st, 0);
//		    crows = st.row;
//	    }
//
//	#else /* ! MORE_AMOS */
//
//	    This should be impossible
//
//	#endif /* ! MORE_AMOS */
//	#endif /* ! MORE_TERMINFO */
//	#endif /* ! MORE_TERMCAP */
//	#endif /* ! MORE_24 */
//	#endif /* ! MORE_NONE */
	}

	/* The program wants to output a line to the terminal.  If z is not
	 * NULL it is a simple string which is output here; otherwise it
	 * needs some sort of formatting, and is output after this function
	 * returns (if all computers had vprintf I would just it, but they
	 * probably don't).
	 */

	 
	
	public static void more_output(String z)
//	final char *z;
	{
//		if (crows > 0  &&  coutput > crows - 2) {
//			printf("Press return to continue: ");
//			(void) fflush(stdout);
//			while (getchar() != '\n')
//				;
//			coutput = 0;
//		}

		if (z != null && z.length() > 0)
//			printf("%s\n", z);
			System.out.println(new String(z));

//		coutput++;
	}

	/* The terminal is waiting for input (clear the number of output lines) */

	public static void more_input()
	{
//	    coutput = 0;
	}

}
