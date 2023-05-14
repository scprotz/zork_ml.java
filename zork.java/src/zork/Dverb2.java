package zork;

import java.io.IOException;

public class Dverb2
{
	/* SAVE- SAVE GAME STATE */

	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;
	Verbs verbs = null;
	
	public Dverb2(Vars vars, Dgame game, Verbs verbs)
	{
		this.vars = vars;
		this.game = game;
		this.verbs = verbs;
	}
//	#include <stdio.h>
//	#include "funcs.h"
//	#include "vars.h"

	/* DECLARATIONS */

//	static int cxappl_ P((int));

	void savegm_()
	{
//	   /* Local variables */
//	   int i;
//	   FILE *e;
//
//	   vars.prsvec_1.prswon = false;
//	   /* 						!DISABLE GAME. */
//	   /* Note: save file format is different for PDP vs. non-PDP versions */
//
//	   if ((e = fopen("dsave.dat", BINWRITE)) == NULL)
//	      { GOTO = 100; continue loop; }
//
//	   gttime_(&i);
//	   /* 						!GET TIME. */
//
//	#define do_uio(i, zbuf, cbytes) \
//	   (void) fwrite((final char *)(zbuf), (cbytes), (i), e)
//
//	   do_uio(1, &vers_1.vmaj, sizeof(int));
//	   do_uio(1, &vers_1.vmin, sizeof(int));
//	   do_uio(1, &vers_1.vedit, sizeof(int));
//
//	   do_uio(1, &vars.play_1.winner, sizeof(int));
//	   do_uio(1, &vars.play_1.here, sizeof(int));
//	   do_uio(1, &hack_1.thfpos, sizeof(int));
//	   do_uio(1, &vars.play_1.telflg, sizeof(boolean));
//	   do_uio(1, &hack_1.thfflg, sizeof(boolean));
//	   do_uio(1, &hack_1.thfact, sizeof(boolean));
//	   do_uio(1, &hack_1.swdact, sizeof(boolean));
//	   do_uio(1, &hack_1.swdsta, sizeof(int));
//	   do_uio(64, &vars.puzzle_1.cpvec[0], sizeof(int));
//
//	   do_uio(1, &i, sizeof(int));
//	   do_uio(1, &state_1.moves, sizeof(int));
//	   do_uio(1, &state_1.deaths, sizeof(int));
//	   do_uio(1, &state_1.rwscor, sizeof(int));
//	   do_uio(1, &state_1.egscor, sizeof(int));
//	   do_uio(1, &state_1.mxload, sizeof(int));
//	   do_uio(1, &state_1.ltshft, sizeof(int));
//	   do_uio(1, &state_1.bloc, sizeof(int));
//	   do_uio(1, &state_1.mungrm, sizeof(int));
//	   do_uio(1, &state_1.hs, sizeof(int));
//	   do_uio(1, &screen_1.fromdr, sizeof(int));
//	   do_uio(1, &screen_1.scolrm, sizeof(int));
//	   do_uio(1, &screen_1.scolac, sizeof(int));
//
//	   do_uio(220, &vars.objcts_1.odesc1[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.odesc2[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.oflag1[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.oflag2[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.ofval[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.otval[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.osize[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.ocapac[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.oroom[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.oadv[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.ocan[0], sizeof(int));
//
//	   do_uio(200, &vars.rooms_1.rval[0], sizeof(int));
//	   do_uio(200, &vars.rooms_1.rflag[0], sizeof(int));
//
//	   do_uio(4, &advs_1.aroom[0], sizeof(int));
//	   do_uio(4, &advs_1.ascore[0], sizeof(int));
//	   do_uio(4, &advs_1.avehic[0], sizeof(int));
//	   do_uio(4, &advs_1.astren[0], sizeof(int));
//	   do_uio(4, &advs_1.aflag[0], sizeof(int));
//
//	   do_uio(46, &flags[0], sizeof(boolean));
//	   do_uio(22, &switch_[0], sizeof(int));
//	   do_uio(4, &vill_1.vprob[0], sizeof(int));
//	   do_uio(25, &cevent_1.cflag[0], sizeof(boolean));
//	   do_uio(25, &cevent_1.ctick[0], sizeof(int));
//
//	#undef do_uio
//
//	   if (fclose(e) == EOF)
//	      { GOTO = 100; continue loop; }
//
//	   game.dsub.rspeak_(597);
//	   return;
//
//	case 100:
//	   game.dsub.rspeak_(598);
		throw new RuntimeException("Dverb2.savegm_ not impl");
	   /* 						!CANT DO IT. */
	} /* savegm_ */

	/* RESTORE- RESTORE GAME STATE */

	/* DECLARATIONS */

	void rstrgm_()
	{
//	   /* Local variables */
//	   int i, j, k;
//	   FILE *e;
//
//	   vars.prsvec_1.prswon = false;
//	   /* 						!DISABLE GAME. */
//	   /* Note: save file format is different for PDP vs. non-PDP versions */
//
//	   if ((e = fopen("dsave.dat", BINREAD)) == NULL)
//	      { GOTO = 100; continue loop; }
//
//	#define do_uio(i, zbuf, cbytes) \
//	   (void)fread((char *)(zbuf), (cbytes), (i), e)
//
//	   do_uio(1, &i, sizeof(int));
//	   do_uio(1, &j, sizeof(int));
//	   do_uio(1, &k, sizeof(int));
//
//	   if (i != vers_1.vmaj | j != vers_1.vmin) {
//	      { GOTO = 200; continue loop; }
//	   }
//
//	   do_uio(1, &vars.play_1.winner, sizeof(int));
//	   do_uio(1, &vars.play_1.here, sizeof(int));
//	   do_uio(1, &hack_1.thfpos, sizeof(int));
//	   do_uio(1, &vars.play_1.telflg, sizeof(boolean));
//	   do_uio(1, &hack_1.thfflg, sizeof(boolean));
//	   do_uio(1, &hack_1.thfact, sizeof(boolean));
//	   do_uio(1, &hack_1.swdact, sizeof(boolean));
//	   do_uio(1, &hack_1.swdsta, sizeof(int));
//	   do_uio(64, &vars.puzzle_1.cpvec[0], sizeof(int));
//
//	   do_uio(1, &time_1.pltime, sizeof(int));
//	   do_uio(1, &state_1.moves, sizeof(int));
//	   do_uio(1, &state_1.deaths, sizeof(int));
//	   do_uio(1, &state_1.rwscor, sizeof(int));
//	   do_uio(1, &state_1.egscor, sizeof(int));
//	   do_uio(1, &state_1.mxload, sizeof(int));
//	   do_uio(1, &state_1.ltshft, sizeof(int));
//	   do_uio(1, &state_1.bloc, sizeof(int));
//	   do_uio(1, &state_1.mungrm, sizeof(int));
//	   do_uio(1, &state_1.hs, sizeof(int));
//	   do_uio(1, &screen_1.fromdr, sizeof(int));
//	   do_uio(1, &screen_1.scolrm, sizeof(int));
//	   do_uio(1, &screen_1.scolac, sizeof(int));
//
//	   do_uio(220, &vars.objcts_1.odesc1[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.odesc2[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.oflag1[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.oflag2[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.ofval[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.otval[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.osize[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.ocapac[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.oroom[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.oadv[0], sizeof(int));
//	   do_uio(220, &vars.objcts_1.ocan[0], sizeof(int));
//
//	   do_uio(200, &vars.rooms_1.rval[0], sizeof(int));
//	   do_uio(200, &vars.rooms_1.rflag[0], sizeof(int));
//
//	   do_uio(4, &advs_1.aroom[0], sizeof(int));
//	   do_uio(4, &advs_1.ascore[0], sizeof(int));
//	   do_uio(4, &advs_1.avehic[0], sizeof(int));
//	   do_uio(4, &advs_1.astren[0], sizeof(int));
//	   do_uio(4, &advs_1.aflag[0], sizeof(int));
//
//	   do_uio(46, &flags[0], sizeof(boolean));
//	   do_uio(22, &switch_[0], sizeof(int));
//	   do_uio(4, &vill_1.vprob[0], sizeof(int));
//	   do_uio(25, &cevent_1.cflag[0], sizeof(boolean));
//	   do_uio(25, &cevent_1.ctick[0], sizeof(int));
//
//	   (void)fclose(e);
//
//	   game.dsub.rspeak_(599);
//	   return;
//
//	case 100:
//	   game.dsub.rspeak_(598);
//	   /* 						!CANT DO IT. */
//	   return;
//
//	case 200:
//	   game.dsub.rspeak_(600);
//	   /* 						!OBSOLETE VERSION */
//	   (void)fclose(e);
		throw new RuntimeException("Dverb2.rstrgm_ not impl");
	} /* rstrgm_ */

	/* WALK- MOVE IN SPECIFIED DIRECTION */

	/* DECLARATIONS */

	boolean walk_() throws IOException
	{
		/* System generated locals */
		boolean ret_val;
		int GOTO = 100;

		ret_val = true;
		/* !ASSUME WINS. */
		if (vars.play_1.winner != vars.aindex_1.player || game.dso5.game.dso5.lit_(vars.play_1.here)
				|| game.dsub.prob_(25, 25))
		{
			{
				GOTO = 500;
			}
		}
		if (GOTO != 500)
		{
			if (!game.dso3.findxt_(vars.prsvec_1.prso, vars.play_1.here))
			{
				{
					GOTO = 450;
				}
			}
			/* !INVALID EXIT? GRUE */
			/* ! */
			if (GOTO != 450)
			{
				switch (vars.curxt_1.xtype)
				{
					case 1:
					{
						GOTO = 400;
						break;
					}
					case 2:
					{
						GOTO = 200;
						break;
					}
					case 3:
					{
						GOTO = 100;
						break;
					}
					case 4:
					{
						GOTO = 300;
						break;
					}
				}
				/* !DECODE EXIT TYPE. */
				if (GOTO != 100 && GOTO != 200 && GOTO != 300 && GOTO != 400)
					game.dsub.bug_(9, vars.curxt_1.xtype);
			}
		}
		loop: do
		{
			switch (GOTO)
			{
				case 100:
					if (cxappl_(vars.curxt_1.xactio) != 0)
					{
						{
							GOTO = 400;
							continue loop;
						}
					}
					/* !CEXIT... RETURNED ROOM? */
					if (vars.findex_1.flags(vars.curxt_1.xflag() - 1))
					{
						{
							GOTO = 400;
							continue loop;
						}
					}
					/* !NO, FLAG ON? */
				case 200:
					game.dsub.jigsup_(523);
					/* !BAD EXIT, GRUE */
					/* ! */
					return ret_val;

				case 300:
					if (cxappl_(vars.curxt_1.xactio) != 0)
					{
						{
							GOTO = 400;
							continue loop;
						}
					}
					/* !DOOR... RETURNED ROOM? */
					if ((vars.objcts_1.oflag2[vars.curxt_1.xobj - 1] & Vars.OPENBT) != 0)
					{
						{
							GOTO = 400;
							continue loop;
						}
					}
					/* !NO, DOOR OPEN? */
					game.dsub.jigsup_(523);
					/* !BAD EXIT, GRUE */
					/* ! */
					return ret_val;

				case 400:
					if (game.dso5.lit_(vars.curxt_1.xroom1))
					{
						{
							GOTO = 900;
							continue loop;
						}
					}
					/* !VALID ROOM, IS IT LIT? */
				case 450:
					game.dsub.jigsup_(522);
					/* !NO, GRUE */
					/* ! */
					return ret_val;

				/* ROOM IS LIT, OR WINNER IS NOT PLAYER (NO GRUE). */

				case 500:
					if (game.dso3.findxt_(vars.prsvec_1.prso, vars.play_1.here))
					{
						{
							GOTO = 550;
							continue loop;
						}
					}
					/* !EXIT EXIST? */
				case 525:
					vars.curxt_1.xstrng = 678;
					/* !ASSUME WALL. */
					if (vars.prsvec_1.prso == vars.xsrch_1.xup)
					{
						vars.curxt_1.xstrng = 679;
					}
					/* !IF UP, CANT. */
					if (vars.prsvec_1.prso == vars.xsrch_1.xdown)
					{
						vars.curxt_1.xstrng = 680;
					}
					/* !IF DOWN, CANT. */
					if ((vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RNWALL) != 0)
					{
						vars.curxt_1.xstrng = 524;
					}
					game.dsub.rspeak_(vars.curxt_1.xstrng);
					vars.prsvec_1.prscon = 1;
					/* !STOP CMD STREAM. */
					return ret_val;

				case 550:
					switch (vars.curxt_1.xtype)
					{
						case 1:
						{
							GOTO = 900;
							continue loop;
						}
						case 2:
						{
							GOTO = 600;
							continue loop;
						}
						case 3:
						{
							GOTO = 700;
							continue loop;
						}
						case 4:
						{
							GOTO = 800;
							continue loop;
						}
					}
					/* !BRANCH ON EXIT TYPE. */
					game.dsub.bug_(9, vars.curxt_1.xtype);

				case 700:
					if (cxappl_(vars.curxt_1.xactio) != 0)
					{
						{
							GOTO = 900;
							continue loop;
						}
					}
					/* !CEXIT... RETURNED ROOM? */
					if (vars.findex_1.flags(vars.curxt_1.xflag() - 1))
					{
						{
							GOTO = 900;
							continue loop;
						}
					}
					/* !NO, FLAG ON? */
				case 600:
					if (vars.curxt_1.xstrng == 0)
					{
						{
							GOTO = 525;
							continue loop;
						}
					}
					/* !IF NO REASON, USE STD. */
					game.dsub.rspeak_(vars.curxt_1.xstrng);
					/* !DENY EXIT. */
					vars.prsvec_1.prscon = 1;
					/* !STOP CMD STREAM. */
					return ret_val;

				case 800:
					if (cxappl_(vars.curxt_1.xactio) != 0)
					{
						{
							GOTO = 900;
							continue loop;
						}
					}
					/* !DOOR... RETURNED ROOM? */
					if ((vars.objcts_1.oflag2[vars.curxt_1.xobj - 1] & Vars.OPENBT) != 0)
					{
						{
							GOTO = 900;
							continue loop;
						}
					}
					/* !NO, DOOR OPEN? */
					if (vars.curxt_1.xstrng == 0)
					{
						vars.curxt_1.xstrng = 525;
					}
					/* !IF NO REASON, USE STD. */
					game.dsub.rspsub_(vars.curxt_1.xstrng,
							vars.objcts_1.odesc2[vars.curxt_1.xobj - 1]);
					vars.prsvec_1.prscon = 1;
					/* !STOP CMD STREAM. */
					return ret_val;

				case 900:
					ret_val = game.dso2.moveto_(vars.curxt_1.xroom1, vars.play_1.winner);
					/* !MOVE TO ROOM. */
					if (ret_val)
					{
						ret_val = game.dsub.rmdesc_(0);
					}
					/* !DESCRIBE ROOM. */
					return ret_val;
			}
		} while (true);
	} /* walk_ */

	/* CXAPPL- CONDITIONAL EXIT PROCESSORS */
	private int cxappl_(int ri) throws IOException
	{
		/* System generated locals */
		int ret_val, i__1;
		int GOTO = 1000;
		/* Local variables */
		int i = 0, j, k;
		int nxt = 0;
		int ldir = 0;

		ret_val = 0;
		/* !NO RETURN. */
		if (ri == 0)
		{
			return ret_val;
		}
		/* !IF NO ACTION, DONE. */
		switch (ri)
		{
			case 1:
			{
				GOTO = 1000;
				break;
			}
			case 2:
			{
				GOTO = 2000;
				break;
			}
			case 3:
			{
				GOTO = 3000;
				break;
			}
			case 4:
			{
				GOTO = 4000;
				break;
			}
			case 5:
			{
				GOTO = 5000;
				break;
			}
			case 6:
			{
				GOTO = 6000;
				break;
			}
			case 7:
			{
				GOTO = 7000;
				break;
			}
			case 8:
			{
				GOTO = 8000;
				break;
			}
			case 9:
			{
				GOTO = 9000;
				break;
			}
			case 10:
			{
				GOTO = 10000;
				break;
			}
			case 11:
			{
				GOTO = 11000;
				break;
			}
			case 12:
			{
				GOTO = 12000;
				break;
			}
			case 13:
			{
				GOTO = 13000;
				break;
			}
			case 14:
			{
				GOTO = 14000;
				break;
			}
			default:
				game.dsub.bug_(5, ri);
		}

		/* C1- COFFIN-CURE */
		loop2: do
		{
			switch (GOTO)
			{
				case 1000:
					vars.findex_1.egyptf = vars.objcts_1.oadv[vars.oindex_1.coffi
							- 1] != vars.play_1.winner;
					/* !T IF NO COFFIN. */
					return ret_val;

				/* C2- CAROUSEL EXIT */
				/* C5- CAROUSEL OUT */

				case 2000:
					if (vars.findex_1.caroff)
					{
						return ret_val;
					}
					/* !IF FLIPPED, NOTHING. */
				case 2500:
					game.dsub.rspeak_(121);
					/* !SPIN THE COMPASS. */
				case 5000:
					i = vars.xpars_1.xelnt[vars.xpars_1.xcond - 1] * Supp.rnd_(8);
					/* !CHOOSE RANDOM EXIT. */
					vars.curxt_1.xroom1 = vars.exits_1.travel[vars.rooms_1.rexit[vars.play_1.here
							- 1] + i - 1] & vars.xpars_1.xrmask;
					ret_val = vars.curxt_1.xroom1;
					/* !RETURN EXIT. */
					return ret_val;

				/* C3- CHIMNEY FUNCTION */

				case 3000:
					vars.findex_1.litldf = false;
					/* !ASSUME HEAVY LOAD. */
					j = 0;
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* !COUNT OBJECTS. */
						if (vars.objcts_1.oadv[i - 1] == vars.play_1.winner)
						{
							++j;
						}
						/* case 3100: */
					}

					if (j > 2)
					{
						return ret_val;
					}
					/* !CARRYING TOO MUCH? */
					vars.curxt_1.xstrng = 446;
					/* !ASSUME NO LAMP. */
					if (vars.objcts_1.oadv[vars.oindex_1.lamp - 1] != vars.play_1.winner)
					{
						return ret_val;
					}
					/* !NO LAMP? */
					vars.findex_1.litldf = true;
					/* !HE CAN DO IT. */
					if ((vars.objcts_1.oflag2[vars.oindex_1.door - 1] & Vars.OPENBT) == 0)
					{
						vars.objcts_1.oflag2[vars.oindex_1.door - 1] &= ~Vars.TCHBT;
					}
					return ret_val;

				/* C4- FROBOZZ FLAG (MAGNET ROOM, FAKE EXIT) */
				/* C6- FROBOZZ FLAG (MAGNET ROOM, REAL EXIT) */

				case 4000:
					if (vars.findex_1.caroff)
					{
						{
							GOTO = 2500;
							continue loop2;
						}
					}
					/* !IF FLIPPED, GO SPIN. */
					vars.findex_1.frobzf = false;
					/* !OTHERWISE, NOT AN EXIT. */
					return ret_val;

				case 6000:
					if (vars.findex_1.caroff)
					{
						{
							GOTO = 2500;
							continue loop2;
						}
					}
					/* !IF FLIPPED, GO SPIN. */
					vars.findex_1.frobzf = true;
					/* !OTHERWISE, AN EXIT. */
					return ret_val;

				/* C7- FROBOZZ FLAG (BANK ALARM) */

				case 7000:
					vars.findex_1.frobzf = vars.objcts_1.oroom[vars.oindex_1.bills - 1] != 0
							& vars.objcts_1.oroom[vars.oindex_1.portr - 1] != 0;
					return ret_val;
				/* CXAPPL, PAGE 3 */

				/* C8- FROBOZZ FLAG (MRGO) */

				case 8000:
					vars.findex_1.frobzf = false;
					/* !ASSUME CANT MOVE. */
					if (vars.findex_1.mloc != vars.curxt_1.xroom1)
					{
						{
							GOTO = 8100;
							continue loop2;
						}
					}
					/* !MIRROR IN WAY? */
					if (vars.prsvec_1.prso == vars.xsrch_1.xnorth
							|| vars.prsvec_1.prso == vars.xsrch_1.xsouth)
					{
						{
							GOTO = 8200;
							continue loop2;
						}
					}
					if (vars.findex_1.mdir % 180 != 0)
					{
						{
							GOTO = 8300;
							continue loop2;
						}
					}
					/* !MIRROR MUST BE N-S. */
					vars.curxt_1.xroom1 = (vars.curxt_1.xroom1 - vars.rindex_1.mra << 1)
							+ vars.rindex_1.mrae;
					/* !CALC EAST ROOM. */
					if (vars.prsvec_1.prso > vars.xsrch_1.xsouth)
					{
						++vars.curxt_1.xroom1;
					}
					/* !IF SW/NW, CALC WEST. */
				case 8100:
					ret_val = vars.curxt_1.xroom1;
					return ret_val;

				case 8200:
					vars.curxt_1.xstrng = 814;
					/* !ASSUME STRUC BLOCKS. */
					if (vars.findex_1.mdir % 180 == 0)
					{
						return ret_val;
					}
					/* !IF MIRROR N-S, DONE. */
				case 8300:
					ldir = vars.findex_1.mdir;
					/* !SEE WHICH MIRROR. */
					if (vars.prsvec_1.prso == vars.xsrch_1.xsouth)
					{
						ldir = 180;
					}
					vars.curxt_1.xstrng = 815;
					/* !MIRROR BLOCKS. */
					if (ldir > 180 && !vars.findex_1.mr1f || ldir < 180 && !vars.findex_1.mr2f)
					{
						vars.curxt_1.xstrng = 816;
					}
					return ret_val;

				/* C9- FROBOZZ FLAG (MIRIN) */

				case 9000:
					if (game.dso6.mrhere_(vars.play_1.here) != 1)
					{
						{
							GOTO = 9100;
							continue loop2;
						}
					}
					/* !MIRROR 1 HERE? */
					if (vars.findex_1.mr1f)
					{
						vars.curxt_1.xstrng = 805;
					}
					/* !SEE IF BROKEN. */
					vars.findex_1.frobzf = vars.findex_1.mropnf;
					/* !ENTER IF OPEN. */
					return ret_val;

				case 9100:
					vars.findex_1.frobzf = false;
					/* !NOT HERE, */
					vars.curxt_1.xstrng = 817;
					/* !LOSE. */
					return ret_val;
				/* CXAPPL, PAGE 4 */

				/* C10- FROBOZZ FLAG (MIRROR EXIT) */

				case 10000:
					vars.findex_1.frobzf = false;
					/* !ASSUME CANT. */
					ldir = (vars.prsvec_1.prso - vars.xsrch_1.xnorth) / vars.xsrch_1.xnorth * 45;
					/* !XLATE DIR TO DEGREES. */
					if (!vars.findex_1.mropnf || (vars.findex_1.mdir + 270) % 360 != ldir
							&& vars.prsvec_1.prso != vars.xsrch_1.xexit)
					{
						{
							GOTO = 10200;
							continue loop2;
						}
					}
					vars.curxt_1.xroom1 = (vars.findex_1.mloc - vars.rindex_1.mra << 1)
							+ vars.rindex_1.mrae + 1 - vars.findex_1.mdir / 180;
					/* !ASSUME E-W EXIT. */
					if (vars.findex_1.mdir % 180 == 0)
					{
						{
							GOTO = 10100;
							continue loop2;
						}
					}
					/* !IF N-S, OK. */
					vars.curxt_1.xroom1 = vars.findex_1.mloc + 1;
					/* !ASSUME N EXIT. */
					if (vars.findex_1.mdir > 180)
					{
						vars.curxt_1.xroom1 = vars.findex_1.mloc - 1;
					}
					/* !IF SOUTH. */
				case 10100:
					ret_val = vars.curxt_1.xroom1;
					return ret_val;

				case 10200:
					if (!vars.findex_1.wdopnf || (vars.findex_1.mdir + 180) % 360 != ldir
							&& vars.prsvec_1.prso != vars.xsrch_1.xexit)
					{
						return ret_val;
					}
					vars.curxt_1.xroom1 = vars.findex_1.mloc + 1;
					/* !ASSUME N. */
					if (vars.findex_1.mdir == 0)
					{
						vars.curxt_1.xroom1 = vars.findex_1.mloc - 1;
					}
					/* !IF S. */
					game.dsub.rspeak_(818);
					/* !CLOSE DOOR. */
					vars.findex_1.wdopnf = false;
					ret_val = vars.curxt_1.xroom1;
					return ret_val;

				/* C11- MAYBE DOOR. NORMAL MESSAGE IS THAT DOOR IS CLOSED. */
				/* BUT IF LCELL.NE.4, DOOR ISNT THERE. */

				case 11000:
					if (vars.findex_1.lcell != 4)
					{
						vars.curxt_1.xstrng = 678;
					}
					/* !SET UP MSG. */
					return ret_val;

				/* C12- FROBZF (PUZZLE ROOM MAIN ENTRANCE) */

				case 12000:
					vars.findex_1.frobzf = true;
					/* !ALWAYS ENTER. */
					vars.findex_1.cphere = 10;
					/* !SET SUBSTATE. */
					return ret_val;

				/* C13- CPOUTF (PUZZLE ROOM SIZE ENTRANCE) */

				case 13000:
					vars.findex_1.cphere = 52;
					/* !SET SUBSTATE. */
					return ret_val;
				/* CXAPPL, PAGE 5 */

				/* C14- FROBZF (PUZZLE ROOM TRANSITIONS) */

				case 14000:
					vars.findex_1.frobzf = false;
					/* !ASSSUME LOSE. */
					if (vars.prsvec_1.prso != vars.xsrch_1.xup)
					{
						{
							GOTO = 14100;
							continue loop2;
						}
					}
					/* !UP? */
					if (vars.findex_1.cphere != 10)
					{
						return ret_val;
					}
					/* !AT EXIT? */
					vars.curxt_1.xstrng = 881;
					/* !ASSUME NO LADDER. */
					if (vars.puzzle_1.cpvec[vars.findex_1.cphere] != -2)
					{
						return ret_val;
					}
					/* !LADDER HERE? */
					game.dsub.rspeak_(882);
					/* !YOU WIN. */
					vars.findex_1.frobzf = true;
					/* !LET HIM OUT. */
					return ret_val;

				case 14100:
					if (vars.findex_1.cphere != 52 || vars.prsvec_1.prso != vars.xsrch_1.xwest
							|| !vars.findex_1.cpoutf)
					{
						{
							GOTO = 14200;
							continue loop2;
						}
					}
					vars.findex_1.frobzf = true;
					/* !YES, LET HIM OUT. */
					return ret_val;

				case 14200:
					for (i = 1; i <= 16; i += 2)
					{
						/* !LOCATE EXIT. */
						if (vars.prsvec_1.prso == vars.puzzle_1.cpdr[i - 1])
						{
							{
								GOTO = 14400;
								continue loop2;
							}
						}
						/* case 14300: */
					}
					return ret_val;
				/* !NO SUCH EXIT. */

				case 14400:
					j = vars.puzzle_1.cpdr[i];
					/* !GET DIRECTIONAL OFFSET. */
					nxt = vars.findex_1.cphere + j;
					/* !GET NEXT STATE. */
					k = 8;
					/* !GET ORTHOGONAL DIR. */
					if (j < 0)
					{
						k = -8;
					}
					if ((Math.abs(j) == 1 || Math.abs(j) == 8
							|| (vars.puzzle_1.cpvec[vars.findex_1.cphere + k - 1] == 0
									|| vars.puzzle_1.cpvec[nxt - k - 1] == 0))
							&& vars.puzzle_1.cpvec[nxt - 1] == 0)
					{
						{
							GOTO = 14500;
							continue loop2;
						}
					}
					return ret_val;

				case 14500:
					game.dso7.cpgoto_(nxt);
					/* !MOVE TO STATE. */
					vars.curxt_1.xroom1 = vars.rindex_1.cpuzz;
					/* !STAY IN ROOM. */
					ret_val = vars.curxt_1.xroom1;
					return ret_val;
			}
		} while (true);
	} /* cxappl_ */

}
