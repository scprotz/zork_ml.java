package zork;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class DInit
{
	/* INIT-- DUNGEON INITIALIZATION SUBROUTINE */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;

	public DInit(Vars vars)
	{
		this.vars = vars;
	}

	/* This is here to avoid depending on the existence of <stdlib.h> */
	public RandomAccessFile dbfile = null;
	public static final String LOCALTEXTFILE = "dtextc.dat";

	/* Read a single two byte int from the index file */

	private static int rdint(RandomAccessFile file) throws IOException
	{
		int ch = file.read();
		return ((ch > 127) ? (ch - 256) : (ch)) * 256 + file.read();
	}

	/* Read a number of two byte ints from the index file */

	private void rdints(int c, int pi[], RandomAccessFile indxfile) throws IOException
	{
		int index = 0;
		while (c-- != 0)
		{
			pi[index] = rdint(indxfile);
			index++;
		}
	}

	/*
	 * Read a partial array of ints. These are stored as index,value pairs.
	 */

	private void rdpartialints(int c, int pi[], RandomAccessFile indxfile) throws IOException
	{
		while (true)
		{
			int i;

			if (c < 255)
			{
				i = indxfile.read();
				if (i == 255)
					return;
			}
			else
			{
				i = rdint(indxfile);
				if (i == -1)
					return;
			}

			pi[i] = rdint(indxfile);
		}
	}

	/* Read a number of one byte flags from the index file */

	private void rdflags(int c, boolean pf[], RandomAccessFile indxfile) throws IOException
	{
		int index = 0;
		while (c-- != 0)
		{
//	      *pf++ = getc(indxfile);
			pf[index] = (indxfile.read() > 0 ? true : false);
//		   *pf++ = indxfile.read();
			index++;
		}
	}

	public boolean init_() throws IOException
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int xmax, r2max;
		int i, j, k;
		RandomAccessFile indxfile;
		int mmax, omax, rmax, vmax, amax, cmax;

		Supp.more_init();

		/* NOW START INITIALIZATION PROPER */

		ret_val = false;
		/* !ASSUME INIT FAILS. */
		mmax = 1050;
		/* !SET UP ARRAY LIMITS. */
		omax = 220;
		rmax = 200;
		vmax = 4;
		amax = 4;
		cmax = 25;
		xmax = 900;
		r2max = 20;

		vars.rmsg_1.mlnt = 0;
		/* !INIT ARRAY COUNTERS. */
		vars.objcts_1.olnt = 0;
		vars.rooms_1.rlnt = 0;
		vars.vill_1.vlnt = 0;
		vars.advs_1.alnt = 0;
		vars.cevent_1.clnt = 0;
		vars.exits_1.xlnt = 1;
		vars.oroom2_1.r2lnt = 0;

		vars.state_1.ltshft = 10;
		/* !SET UP STATE VARIABLES. */
		vars.state_1.mxscor = vars.state_1.ltshft;
		vars.state_1.egscor = 0;
		vars.state_1.egmxsc = 0;
		vars.state_1.mxload = 100;
		vars.state_1.rwscor = 0;
		vars.state_1.deaths = 0;
		vars.state_1.moves = 0;
		vars.time_1.pltime = 0;
		vars.state_1.mungrm = 0;
		vars.state_1.hs = 0;
		vars.prsvec_1.prsa = 0;
		/* !CLEAR PARSE VECTOR. */
		vars.prsvec_1.prsi = 0;
		vars.prsvec_1.prso = 0;
		vars.prsvec_1.prscon = 1;
		vars.orphs_1.oflag = 0;
		/* !CLEAR ORPHANS. */
		vars.orphs_1.oact = 0;
		vars.orphs_1.oslot = 0;
		vars.orphs_1.oprep = 0;
		vars.orphs_1.oname = 0;
		vars.hack_1.thfflg = false;
		/* !THIEF NOT INTRODUCED BUT */
		vars.hack_1.thfact = true;
		/* !IS ACTIVE. */
		vars.hack_1.swdact = false;
		/* !SWORD IS INACTIVE. */
		vars.hack_1.swdsta = 0;
		/* !SWORD IS OFF. */

		/* !INIT DB FILE POINTER. */
		vars.star_1.mbase = 0;
		/* !INIT MELEE BASE. */
		/* INIT, PAGE 3 */

		/* INIT ALL ARRAYS. */

		for (i = 1; i <= cmax; ++i)
		{
			/* !CLEAR CLOCK EVENTS */
			vars.cevent_1.cflag[i - 1] = false;
			vars.cevent_1.ctick[i - 1] = 0;
			vars.cevent_1.cactio[i - 1] = 0;
			/* L5: */
		}

		vars.findex_1.buoyf = true;
		/* !SOME START AS TRUE. */
		vars.findex_1.egyptf = true;
		vars.findex_1.cagetf = true;
		vars.findex_1.mr1f = true;
		vars.findex_1.mr2f = true;
		vars.findex_1.follwf = true;
		vars.findex_1.ormtch = 4;
		/* !NUMBER OF MATCHES. */
		vars.findex_1.lcell = 1;
		vars.findex_1.pnumb = 1;
		vars.findex_1.mdir = 270;
		vars.findex_1.mloc = vars.rindex_1.mrb;
		vars.findex_1.cphere = 10;

		for (i = 1; i <= r2max; ++i)
		{
			/* !CLEAR ROOM 2 ARRAY. */
			vars.oroom2_1.rroom2[i - 1] = 0;
			vars.oroom2_1.oroom2[i - 1] = 0;
			/* L15: */
		}

		for (i = 1; i <= xmax; ++i)
		{
			/* !CLEAR TRAVEL ARRAY. */
			vars.exits_1.travel[i - 1] = 0;
			/* L20: */
		}

		for (i = 1; i <= vmax; ++i)
		{
			/* !CLEAR VILLAINS ARRAYS. */
			vars.vill_1.vopps[i - 1] = 0;
			vars.vill_1.vprob[i - 1] = 0;
			vars.vill_1.villns[i - 1] = 0;
			vars.vill_1.vbest[i - 1] = 0;
			vars.vill_1.vmelee[i - 1] = 0;
			/* L30: */
		}

		for (i = 1; i <= omax; ++i)
		{
			/* !CLEAR OBJECT ARRAYS. */
			vars.objcts_1.odesc1[i - 1] = 0;
			vars.objcts_1.odesc2[i - 1] = 0;
			vars.objcts_1.odesco[i - 1] = 0;
			vars.objcts_1.oread[i - 1] = 0;
			vars.objcts_1.oactio[i - 1] = 0;
			vars.objcts_1.oflag1[i - 1] = 0;
			vars.objcts_1.oflag2[i - 1] = 0;
			vars.objcts_1.ofval[i - 1] = 0;
			vars.objcts_1.otval[i - 1] = 0;
			vars.objcts_1.osize[i - 1] = 0;
			vars.objcts_1.ocapac[i - 1] = 0;
			vars.objcts_1.ocan[i - 1] = 0;
			vars.objcts_1.oadv[i - 1] = 0;
			vars.objcts_1.oroom[i - 1] = 0;
			/* L40: */
		}

		for (i = 1; i <= rmax; ++i)
		{
			/* !CLEAR ROOM ARRAYS. */
			vars.rooms_1.rdesc1[i - 1] = 0;
			vars.rooms_1.rdesc2[i - 1] = 0;
			vars.rooms_1.ractio[i - 1] = 0;
			vars.rooms_1.rflag[i - 1] = 0;
			vars.rooms_1.rval[i - 1] = 0;
			vars.rooms_1.rexit[i - 1] = 0;
			/* L50: */
		}

		for (i = 1; i <= mmax; ++i)
		{
			/* !CLEAR MESSAGE DIRECTORY. */
			vars.rmsg_1.rtext[i - 1] = 0;
			/* L60: */
		}

		for (i = 1; i <= amax; ++i)
		{
			/* !CLEAR ADVENTURER'S ARRAYS. */
			vars.advs_1.aroom[i - 1] = 0;
			vars.advs_1.ascore[i - 1] = 0;
			vars.advs_1.avehic[i - 1] = 0;
			vars.advs_1.aobj[i - 1] = 0;
			vars.advs_1.aactio[i - 1] = 0;
			vars.advs_1.astren[i - 1] = 0;
			vars.advs_1.aflag[i - 1] = 0;
			/* L70: */
		}

		vars.debug_1.dbgflg = 0;
		vars.debug_1.prsflg = 0;
		vars.debug_1.gdtflg = 0;

		if (Vars.ALLOW_GDT)
		{

			/* allow setting gdtflg true if user id matches wizard id */
			/* this way, the wizard doesn't have to recompile to use gdt */

			if (Local.wizard())
			{
				vars.debug_1.gdtflg = 1;
			}

		} /* ALLOW_GDT */

		vars.screen_1.fromdr = 0;
		/* !INIT SCOL GOODIES. */
		vars.screen_1.scolrm = 0;
		vars.screen_1.scolac = 0;
		/* INIT, PAGE 4 */

		/* NOW RESTORE FROM EXISTING INDEX FILE. */
		dbfile = new RandomAccessFile(new File(LOCALTEXTFILE), "r");

		indxfile = dbfile;

		i = rdint(indxfile);
		j = rdint(indxfile);
		k = rdint(indxfile);

		/* !GET VERSION. */
		if (i != vars.vers_1.vmaj || j != vars.vers_1.vmin)
		{
			error1925(i, j, k);
			return ret_val;
		}

		vars.state_1.mxscor = rdint(indxfile);
		vars.star_1.strbit = rdint(indxfile);
		vars.state_1.egmxsc = rdint(indxfile);

		vars.rooms_1.rlnt = rdint(indxfile);
		rdints(vars.rooms_1.rlnt, vars.rooms_1.rdesc1, indxfile);
		rdints(vars.rooms_1.rlnt, vars.rooms_1.rdesc2, indxfile);
		rdints(vars.rooms_1.rlnt, vars.rooms_1.rexit, indxfile);
		rdpartialints(vars.rooms_1.rlnt, vars.rooms_1.ractio, indxfile);
		rdpartialints(vars.rooms_1.rlnt, vars.rooms_1.rval, indxfile);
		rdints(vars.rooms_1.rlnt, vars.rooms_1.rflag, indxfile);

		vars.exits_1.xlnt = rdint(indxfile);
		rdints(vars.exits_1.xlnt, vars.exits_1.travel, indxfile);

		vars.objcts_1.olnt = rdint(indxfile);
		rdints(vars.objcts_1.olnt, vars.objcts_1.odesc1, indxfile);
		rdints(vars.objcts_1.olnt, vars.objcts_1.odesc2, indxfile);
		rdpartialints(vars.objcts_1.olnt, vars.objcts_1.odesco, indxfile);
		rdpartialints(vars.objcts_1.olnt, vars.objcts_1.oactio, indxfile);
		rdints(vars.objcts_1.olnt, vars.objcts_1.oflag1, indxfile);
		rdpartialints(vars.objcts_1.olnt, vars.objcts_1.oflag2, indxfile);
		rdpartialints(vars.objcts_1.olnt, vars.objcts_1.ofval, indxfile);
		rdpartialints(vars.objcts_1.olnt, vars.objcts_1.otval, indxfile);
		rdints(vars.objcts_1.olnt, vars.objcts_1.osize, indxfile);
		rdpartialints(vars.objcts_1.olnt, vars.objcts_1.ocapac, indxfile);
		rdints(vars.objcts_1.olnt, vars.objcts_1.oroom, indxfile);
		rdpartialints(vars.objcts_1.olnt, vars.objcts_1.oadv, indxfile);
		rdpartialints(vars.objcts_1.olnt, vars.objcts_1.ocan, indxfile);
		rdpartialints(vars.objcts_1.olnt, vars.objcts_1.oread, indxfile);

		vars.oroom2_1.r2lnt = rdint(indxfile);
		rdints(vars.oroom2_1.r2lnt, vars.oroom2_1.oroom2, indxfile);
		rdints(vars.oroom2_1.r2lnt, vars.oroom2_1.rroom2, indxfile);

		vars.cevent_1.clnt = rdint(indxfile);
		rdints(vars.cevent_1.clnt, vars.cevent_1.ctick, indxfile);
		rdints(vars.cevent_1.clnt, vars.cevent_1.cactio, indxfile);
		rdflags(vars.cevent_1.clnt, vars.cevent_1.cflag, indxfile);

		vars.vill_1.vlnt = rdint(indxfile);
		rdints(vars.vill_1.vlnt, vars.vill_1.villns, indxfile);
		rdpartialints(vars.vill_1.vlnt, vars.vill_1.vprob, indxfile);
		rdpartialints(vars.vill_1.vlnt, vars.vill_1.vopps, indxfile);
		rdints(vars.vill_1.vlnt, vars.vill_1.vbest, indxfile);
		rdints(vars.vill_1.vlnt, vars.vill_1.vmelee, indxfile);

		vars.advs_1.alnt = rdint(indxfile);
		rdints(vars.advs_1.alnt, vars.advs_1.aroom, indxfile);
		rdpartialints(vars.advs_1.alnt, vars.advs_1.ascore, indxfile);
		rdpartialints(vars.advs_1.alnt, vars.advs_1.avehic, indxfile);
		rdints(vars.advs_1.alnt, vars.advs_1.aobj, indxfile);
		rdints(vars.advs_1.alnt, vars.advs_1.aactio, indxfile);
		rdints(vars.advs_1.alnt, vars.advs_1.astren, indxfile);
		rdpartialints(vars.advs_1.alnt, vars.advs_1.aflag, indxfile);

		vars.star_1.mbase = rdint(indxfile);
		vars.rmsg_1.mlnt = rdint(indxfile);
		rdints(vars.rmsg_1.mlnt, vars.rmsg_1.rtext, indxfile);

		/* Save location of start of message text */
		vars.rmsg_1.mrloc = indxfile.getFilePointer();

		/* !INIT DONE. */

		/* THE INTERNAL DATA BASE IS NOW ESTABLISHED. */
		/* SET UP TO PLAY THE GAME. */

		Supp.srand(new Date().getTime());

		vars.play_1.winner = vars.aindex_1.player;
		vars.last_1.lastit = vars.advs_1.aobj[vars.aindex_1.player - 1];
		vars.play_1.here = vars.advs_1.aroom[vars.play_1.winner - 1];
		vars.hack_1.thfpos = vars.objcts_1.oroom[vars.oindex_1.thief - 1];
		vars.state_1.bloc = vars.objcts_1.oroom[vars.oindex_1.ballo - 1];
		ret_val = true;

		return ret_val;
	}

	/* init_ */
	public void error1925(int i, int j, int k)
	{
		if (Vars.DEBUG)
		{
			Supp.more_output(null);
			System.out.println(LOCALTEXTFILE + " is version " + i + "." + j + "" + (char) k + ".");
			Supp.more_output(null);
			System.out.println("I require version " + vars.vers_1.vmaj + "." + vars.vers_1.vmin
					+ (char) vars.vers_1.vedit + ".");
			error1975();
		}
	}

	public void error1950()
	{
		if (Vars.DEBUG)
		{
			Supp.more_output(null);
			System.out.println("I can't open " + LOCALTEXTFILE + ".");
		}
		error1975();
	}

	public void error1975()
	{
		if (Vars.DEBUG)
		{
			Supp.more_output("Suddenly a sinister, wraithlike figure appears before you,");
			Supp.more_output("seeming to float in the air.  In a low, sorrowful voice he says,");
			Supp.more_output("\"Alas, the very nature of the world has changed, and the dungeon");
			Supp.more_output(
					"cannot be found.  All must now pass away.\"  Raising his oaken staff");
			Supp.more_output("in farewell, he fades into the spreading darkness.  In his place");
			Supp.more_output("appears a tastefully lettered sign reading:");
			Supp.more_output("");
			Supp.more_output("                       INITIALIZATION FAILURE");
			Supp.more_output("");
			Supp.more_output("The darkness becomes all encompassing, and your vision fails.");
		}
	}

}
