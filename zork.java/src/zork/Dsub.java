package zork;

import java.io.IOException;

public class Dsub
{

	Vars vars = null;
	Dgame game = null;

	private static final int EOF = -1;

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	public Dsub(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;

	}

	/* RESIDENT SUBROUTINES FOR DUNGEON */

	/* RSPEAK-- OUTPUT RANDOM MESSAGE ROUTINE */
	public void rspeak_(int n) throws IOException
	{
		rspsb2nl_(n, 0, 0, 1);
	} /* rspeak_ */

	/* RSPSUB-- OUTPUT RANDOM MESSAGE WITH SUBSTITUTABLE ARGUMENT */
	void rspsub_(int n, int s1) throws IOException
	{
		rspsb2nl_(n, s1, 0, 1);
	} /* rspsub_ */

	/* RSPSB2-- OUTPUT RANDOM MESSAGE WITH UP TO TWO SUBSTITUTABLE ARGUMENTS */
	void rspsb2_(int n, int s1, int s2) throws IOException
	{
		rspsb2nl_(n, s1, s2, 1);
	} /* rspsb2_ */

	/* rspsb2nl_ Display a substitutable message with an optional newline */
	private void rspsb2nl_(int n, int y, int z, int nl) throws IOException
	{
		int res;
		String zkey = "IanLanceTaylorJr";
		int x = (int) n;

		if (x > 0)
		{
			x = vars.rmsg_1.rtext[x - 1];
		}
		/* !IF >0, LOOK UP IN RTEXT. */
		else if (x == 0)
		{
			return;
		}
		/* !ANYTHING TO DO? */
		vars.play_1.telflg = true;
		/* !SAID SOMETHING. */

		x = ((-x) - 1) * 8;
		res = 0;
		try
		{
			game.init.dbfile.seek(x + (int) vars.rmsg_1.mrloc);
		}
		catch (Exception e)
		{
			res = -1;
		}
		if (Vars.DEBUG)
		{
//	#ifdef DEBUG
			if (res == EOF)
			{
				System.err.println("Error seeking database loc " + x);
				Supp.exit_();
			}
//	#endif
		}

		if (nl != 0)
			Supp.more_output(null);

		while (true)
		{
			int i;

//	      i = getc(game.init.dbfile);
			i = game.init.dbfile.read();
//	ifdef DEBUG
			if (Vars.DEBUG)
			{
				if (i == EOF)
				{
					System.err.println("Error reading database loc " + x);
					Supp.exit_();
				}
//	#endif
			}
			i ^= zkey.charAt(x & 0xf) ^ (x & 0xff);

//	      i ^= zkey[x & 0xf] ^ (x & 0xff);
			x = x + 1;
			if (i == '\0')
				break;
			else if (i == '\n')
			{
				System.out.println();
//	         putchar('\n');
				if (nl != 0)
					Supp.more_output(null);
			}
			else if (i == '#' && y != 0)
			{
				long iloc;

//	         iloc = ftell(game.init.dbfile);
				iloc = game.init.dbfile.getFilePointer();
				rspsb2nl_(y, 0, 0, 0);
//		 res = fseek(game.init.dbfile, iloc, SEEK_SET);
				res = 0;
				try
				{
					game.init.dbfile.seek(iloc);
				}
				catch (Exception e)
				{
					res = -1;
				}
//	#ifdef DEBUG
				if (Vars.DEBUG)
				{
					if (res == EOF)
					{
						System.err.println("Error seeking database loc " + iloc);
						Supp.exit_();
					}
//	#endif
				}
				y = z;
				z = 0;
			}
			else
				System.out.print((char) i);
//	         putchar(i);
		}

		if (nl != 0)
			System.out.print("\n");
//	      putchar('\n');
	}

	/* OBJACT-- APPLY OBJECTS FROM PARSE VECTOR */

	/* DECLARATIONS */

	boolean objact_() throws IOException
	{
		/* !ASSUME WINS. */
		if (vars.prsvec_1.prsi != 0
				&& game.objcts.oappli_(vars.objcts_1.oactio[vars.prsvec_1.prsi - 1], 0))
		{
			return true;
		}
		/* !YES, LET IT HANDLE. */

		/* !DIR OBJECT? */
		if (vars.prsvec_1.prso != 0
				&& game.objcts.oappli_(vars.objcts_1.oactio[vars.prsvec_1.prso - 1], 0))
		{
			return true;
		}
		/* !YES, LET IT HANDLE. */

		return false;
	} /* objact_ */

	/* BUG-- REPORT FATAL SYSTEM ERROR */

	/* CALLED BY-- */

	/* CALL BUG(NO,PAR) */

	void bug_(int a, int b) throws IOException
	{
//	#ifdef DEBUG
		if (Vars.DEBUG)
		{

			/* Local variables */

			Supp.more_output(null);
			System.out.println("PROGRAM ERROR " + a + ", PARAMETER=" + b);

			if (vars.debug_1.dbgflg != 0)
			{
				return;
			}
			Supp.exit_();
//	#endif
		}

	} /* bug_ */

	/* NEWSTA-- SET NEW STATUS FOR OBJECT */

	/* CALLED BY-- */

	/* CALL NEWSTA(OBJECT,STRING,NEWROOM,NEWCON,NEWADV) */

	void newsta_(int o, int r, int rm, int cn, int ad) throws IOException
	{
		rspeak_(r);
		vars.objcts_1.oroom[o - 1] = rm;
		vars.objcts_1.ocan[o - 1] = cn;
		vars.objcts_1.oadv[o - 1] = ad;
	} /* newsta_ */

	/* QHERE-- TEST FOR OBJECT IN ROOM */

	/* DECLARATIONS */

	boolean qhere_(int obj, int rm)
	{
		/* Local variables */
		int i;

		if (vars.objcts_1.oroom[obj - 1] == rm)
		{
			return true;
		}
		/* !IN ROOM? */
		for (i = 1; i <= vars.oroom2_1.r2lnt; ++i)
		{
			/* !NO, SCH ROOM2. */
			if (vars.oroom2_1.oroom2[i - 1] == obj && vars.oroom2_1.rroom2[i - 1] == rm)
			{
				return true;
			}
		}
		/* !NOT PRESENT. */
		return false;
	} /* qhere_ */

	/* QEMPTY-- TEST FOR OBJECT EMPTY */

	/* DECLARATIONS */

	boolean qempty_(int obj)
	{
		/* Local variables */
		int i;

		/* !ASSUME LOSE. */
		for (i = 1; i <= vars.objcts_1.olnt; ++i)
		{
			if (vars.objcts_1.ocan[i - 1] == obj)
			{
				return false;
			}
			/* !INSIDE TARGET? */
		}
		return true;
	} /* qempty_ */

	/* JIGSUP- YOU ARE DEAD */

	/* DECLARATIONS */
	static final int rlist[] = new int[] { 8, 6, 36, 35, 34, 4, 34, 6, 5 };

	void jigsup_(int desc) throws IOException
	{
		/* Initialized data */

		/* Local variables */
		int nonofl;
		int i, j;

		rspeak_(desc);
		/* !DESCRIBE SAD STATE. */
		vars.prsvec_1.prscon = 1;
		/* !STOP PARSER. */
		if (Vars.DEBUG)
			if (vars.debug_1.dbgflg != 0)
			{
				return;
			}

		/* !IF DBG, EXIT. */
		vars.advs_1.avehic[vars.play_1.winner - 1] = 0;
		/* !GET RID OF VEHICLE. */
		if (!(vars.play_1.winner == vars.aindex_1.player))
		{
			/* !HIMSELF? */
			rspsub_(432, vars.objcts_1.odesc2[vars.advs_1.aobj[vars.play_1.winner - 1] - 1]);
			/* !NO, SAY WHO DIED. */
			newsta_(vars.advs_1.aobj[vars.play_1.winner - 1], 0, 0, 0, 0);
			/* !SEND TO HYPER SPACE. */
			return;
		}

		if (vars.findex_1.endgmf)
		{
			rspeak_(625);
			game.dso2.score_(false);
			Supp.exit_();
		}

		/* !NO RECOVERY IN END GAME. */
		if (vars.state_1.deaths >= 2)
		{
			rspeak_(7);
			game.dso2.score_(false);
			Supp.exit_();
		}

		/* !DEAD TWICE? KICK HIM OFF. */
		if (!game.dso3.yesno_(10, 9, 8))
		{
			game.dso2.score_(false);
			Supp.exit_();
		}

		/* !CONTINUE? */

		for (j = 1; j <= vars.objcts_1.olnt; ++j)
		{
			/* !TURN OFF FIGHTING. */
			if (qhere_(j, vars.play_1.here))
			{
				vars.objcts_1.oflag2[j - 1] &= ~Vars.FITEBT;
			}
			/* L50: */
		}

		++vars.state_1.deaths;
		game.dso2.scrupd_(-10);
		/* !CHARGE TEN POINTS. */
		game.dso2.moveto_(vars.rindex_1.fore1, vars.play_1.winner);
		/* !REPOSITION HIM. */
		vars.findex_1.egyptf = true;
		/* !RESTORE COFFIN. */
		if (vars.objcts_1.oadv[vars.oindex_1.coffi - 1] == vars.play_1.winner)
		{
			newsta_(vars.oindex_1.coffi, 0, vars.rindex_1.egypt, 0, 0);
		}
		vars.objcts_1.oflag2[vars.oindex_1.door - 1] &= ~Vars.TCHBT;
		vars.objcts_1.oflag1[vars.oindex_1.robot
				- 1] = (vars.objcts_1.oflag1[vars.oindex_1.robot - 1] | Vars.VISIBT) & ~Vars.NDSCBT;
		if (vars.objcts_1.oroom[vars.oindex_1.lamp - 1] != 0
				|| vars.objcts_1.oadv[vars.oindex_1.lamp - 1] == vars.play_1.winner)
		{
			newsta_(vars.oindex_1.lamp, 0, vars.rindex_1.lroom, 0, 0);
		}

		/* NOW REDISTRIBUTE HIS VALUABLES AND OTHER BELONGINGS. */

		/* THE LAMP HAS BEEN PLACED IN THE LIVING ROOM. */
		/* THE FIRST 8 NON-VALUABLES ARE PLACED IN LOCATIONS AROUND THE HOUSE. */
		/* HIS VALUABLES ARE PLACED AT THE END OF THE MAZE. */
		/* REMAINING NON-VALUABLES ARE PLACED AT THE END OF THE MAZE. */

		i = 1;
		for (j = 1; j <= vars.objcts_1.olnt; ++j)
		{
			/* !LOOP THRU OBJECTS. */
			if (vars.objcts_1.oadv[j - 1] != vars.play_1.winner || vars.objcts_1.otval[j - 1] != 0)
			{
				continue;
			}
			++i;
			if (i > 9)
			{
				break;
			}
			/* !MOVE TO RANDOM LOCATIONS. */
			newsta_(j, 0, rlist[i - 1], 0, 0);;
		}

		i = vars.rooms_1.rlnt + 1;
		/* !NOW MOVE VALUABLES. */
		nonofl = Vars.RAIR + Vars.RWATER + Vars.RSACRD + Vars.REND;
		/* !DONT MOVE HERE. */
		for (j = 1; j <= vars.objcts_1.olnt; ++j)
		{
			if (vars.objcts_1.oadv[j - 1] != vars.play_1.winner || vars.objcts_1.otval[j - 1] == 0)
			{
				continue;
			}
			do
			{
				--i;
			} while (
			/* !FIND NEXT ROOM. */
			(vars.rooms_1.rflag[i - 1] & nonofl) != 0);

			newsta_(j, 0, i, 0, 0);
			/* !YES, MOVE. */

		}

		for (j = 1; j <= vars.objcts_1.olnt; ++j)
		{
			/* !NOW GET RID OF REMAINDER. */
			if (vars.objcts_1.oadv[j - 1] != vars.play_1.winner)
			{
				continue;
			}
			do
			{

				--i;
				/* !FIND NEXT ROOM. */
			} while ((vars.rooms_1.rflag[i - 1] & nonofl) != 0);
			newsta_(j, 0, i, 0, 0);

		}
		return;
	} /* jigsup_ */

	/* OACTOR- GET ACTOR ASSOCIATED WITH OBJECT */

	/* DECLARATIONS */

	int oactor_(int obj) throws IOException
	{
		/* System generated locals */

		/* Local variables */
		int i;

		for (i = 1; i <= vars.advs_1.alnt; ++i)
		{
			/* !LOOP THRU ACTORS. */
			/* !ASSUME FOUND. */
			if (vars.advs_1.aobj[i - 1] == obj)
			{
				return i;
			}
			/* !FOUND IT? */
			/* L100: */
		}
		if (Vars.DEBUG)
		{
//	#ifdef DEBUG
			bug_(40, obj);
//	#endif
		}
		/* !NO, DIE. */
		return vars.advs_1.alnt + 1;
	} /* oactor_ */

	/* PROB- COMPUTE PROBABILITY */

	/* DECLARATIONS */

	boolean prob_(int g, int b)
	{
		/* System generated locals */

		/* Local variables */
		int i;

		i = g;
		/* !ASSUME GOOD LUCK. */
		if (vars.findex_1.badlkf)
		{
			i = b;
		}
		/* !IF BAD, TOO BAD. */
		/* !COMPUTE. */
		return (Supp.rnd_(100) < i);
	} /* prob_ */

	/* RMDESC-- PRINT ROOM DESCRIPTION */

	/* RMDESC PRINTS A DESCRIPTION OF THE CURRENT ROOM. */
	/* IT IS ALSO THE PROCESSOR FOR VERBS 'LOOK' AND 'EXAMINE'. */

	boolean rmdesc_(int full) throws IOException
	{
		/* System generated locals */
		boolean ret_val, L__1;

		/* Local variables */
		int i = 0, ra = 0;
		int GOTO = 0;

		/* FULL= 0/1/2/3= SHORT/OBJ/ROOM/FULL */

		ret_val = true;

		/* !ASSUME WINS. */
		if (vars.prsvec_1.prso < vars.xsrch_1.xmin)
		{
			GOTO = 50;
		}
		if (GOTO != 50)
		{
			/* !IF DIRECTION, */
			vars.screen_1.fromdr = vars.prsvec_1.prso;
			/* !SAVE AND */
			vars.prsvec_1.prso = 0;
			/* !CLEAR. */
		}
		GOTO = 50;
		do
		{
			switch (GOTO)
			{
				case 50:
					if (vars.play_1.here == vars.advs_1.aroom[vars.aindex_1.player - 1])
					{
						GOTO = 100;
						continue;
					}
					/* !PLAYER JUST MOVE? */
					rspeak_(2);
					/* !NO, JUST SAY DONE. */
					vars.prsvec_1.prsa = vars.vindex_1.walkiw;
					/* !SET UP WALK IN ACTION. */
					return ret_val;

				case 100:
					if (game.dso5.lit_(vars.play_1.here))
					{
						GOTO = 300;
						continue;
					}
					/* !LIT? */
					rspeak_(430);
					/* !WARN OF GRUE. */
					ret_val = false;
					return ret_val;

				case 300:
					ra = vars.rooms_1.ractio[vars.play_1.here - 1];
					/* !GET ROOM ACTION. */
					if (full == 1)
					{
						GOTO = 600;
						continue;
					}
					/* !OBJ ONLY? */
					i = vars.rooms_1.rdesc2[vars.play_1.here - 1];
					/* !ASSUME SHORT DESC. */
					if (full == 0 && (vars.findex_1.superf
							|| (vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RSEEN) != 0
									&& vars.findex_1.brieff))
					{
						GOTO = 400;
						continue;
					}

					/* The next line means that when you request VERBOSE mode, you */
					/* only get long room descriptions 20% of the time. I don't either */
					/* like or understand this, so the mod. ensures VERBOSE works */
					/* all the time. jmh@ukc.ac.uk 22/10/87 */

					/* & .AND.(BRIEFF.OR.PROB(80,80))))) GO TO 400 */
					i = vars.rooms_1.rdesc1[vars.play_1.here - 1];
					/* !USE LONG. */
					if (i != 0 || ra == 0)
					{
						GOTO = 400;
						continue;
					}
					/* !IF GOT DESC, SKIP. */
					vars.prsvec_1.prsa = vars.vindex_1.lookw;
					/* !PRETEND LOOK AROUND. */
					if (!rappli_(ra))
					{
						GOTO = 100;
						continue;
					}
					/* !ROOM HANDLES, NEW DESC? */
					vars.prsvec_1.prsa = vars.vindex_1.foow;
					/* !NOP PARSER. */
					GOTO = 500;
					continue;

				case 400:
					rspeak_(i);
					/* !OUTPUT DESCRIPTION. */
				case 500:
					if (vars.advs_1.avehic[vars.play_1.winner - 1] != 0)
					{
						rspsub_(431, vars.objcts_1.odesc2[vars.advs_1.avehic[vars.play_1.winner - 1]
								- 1]);
					}

				case 600:
					if (full != 2)
					{
						L__1 = full != 0;
						game.dso1.princr_(L__1, vars.play_1.here);
					}
					vars.rooms_1.rflag[vars.play_1.here - 1] |= Vars.RSEEN;
					if (full != 0 || ra == 0)
					{
						return ret_val;
					}
					/* !ANYTHING MORE? */
					vars.prsvec_1.prsa = vars.vindex_1.walkiw;
					/* !GIVE HIM A SURPISE. */
					if (!rappli_(ra))
					{
						GOTO = 100;
						continue;
					}
					/* !ROOM HANDLES, NEW DESC? */
					vars.prsvec_1.prsa = vars.vindex_1.foow;
					return ret_val;
			}
		} while (true);

	} /* rmdesc_ */

	/* RAPPLI- ROUTING ROUTINE FOR ROOM APPLICABLES */
	boolean rappli_(int ri) throws IOException
	{
		/* Initialized data */

		final int newrms = 38;

		/* System generated locals */

		/* !ASSUME WINS. */
		if (ri == 0)
		{
			return true;
		}
		/* !IF ZERO, WIN. */
		if (ri >= newrms)
		{
			return game.nrooms.rappl2_(ri);
		}
		/* !IF NEW, PROCESSOR 2. */
		else
		{
			return game.rooms.rappl1_(ri);
		}

		/* !IF OLD, PROCESSOR 1. */
	} /* rappli_ */

}
