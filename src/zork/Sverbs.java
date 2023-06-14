package zork;

public class Sverbs
{
	/* SVERBS- SIMPLE VERBS PROCESSOR */
	/* ALL VERBS IN THIS ROUTINE MUST BE INDEPENDANT */
	/* OF OBJECT ACTIONS */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;
	Verbs verbs = null;

	static final int jokes[] = new int[] { 4, 5, 3, 304, 305, 306, 307, 308, 309, 310, 311, 312,
			313, 5314, 5319, 324, 325, 883, 884, 120, 120, 0, 0, 0, 0 };
	static final int answer[] = new int[] { 0, 1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 6, 7, 7 };
	static final String ansstr[] = new String[] { "TEMPLE", "FOREST", "30003", "FLASK", "RUB",
			"FONDLE", "CARRES", "TOUCH", "BONES", "BODY", "SKELE", "RUSTYKNIFE", "NONE", "NOWHER" };

	public Sverbs(Vars vars, Dgame game, Verbs verbs)
	{
		this.vars = vars;
		this.game = game;
		this.verbs = verbs;
	}

	boolean sverbs_(int ri)
	{
		/* Initialized data */

		final int mxnop = 39;
		final int mxjoke = 64;
		int GOTO = 0;

		/* System generated locals */
		int i__1, i__2;
		boolean ret_val;

		/* Local variables */
//	   final char []z, []z2;
		char z;
//		char z2;
		int i = 0, j;
		int[] k = new int[1];
		int l;
//	   char ch[1*6];
		char[] ch = new char[6];
		int cp, wp;
		char pp1[] = new char[1 * 6], pp2[] = new char[1 * 6];
		int odi2 = 0, odo2 = 0;

		ret_val = true;
		/* ASSUME WINS. */
		if (vars.prsvec_1.direct_object != 0)
		{
			odo2 = vars.objcts_1.odesc2[vars.prsvec_1.direct_object - 1];
		}
		/* SET UP DESCRIPTORS. */
		if (vars.prsvec_1.indirect_object != 0)
		{
			odi2 = vars.objcts_1.odesc2[vars.prsvec_1.indirect_object - 1];
		}

		if (ri == 0)
		{
			game.dsub.bug_(7, ri);
		}
		/* ZERO IS VERBOTEN. */
		if (ri <= mxnop)
		{
			return ret_val;
		}
		/* NOP? */
		if (ri > mxjoke)
		{

			/* JOKE? */
			switch (ri - mxjoke)
			{
				case 1:
					GOTO = 65000;
					break;
				case 2:
					GOTO = 66000;
					break;
				case 3:
					GOTO = 67000;
					break;
				case 4:
					GOTO = 68000;
					break;
				case 5:
					GOTO = 69000;
					break;
				case 6:
					GOTO = 1000;
					break;
				case 7:
					GOTO = 2000;
					break;
				case 8:
					GOTO = 3000;
					break;
				case 9:
					GOTO = 4000;
					break;
				case 10:
					GOTO = 5000;
					break;
				case 11:
					GOTO = 6000;
					break;
				case 12:
					GOTO = 7000;
					break;
				case 13:
					GOTO = 8000;
					break;
				case 14:
					GOTO = 9000;
					break;
				case 15:
					GOTO = 10000;
					break;
				case 16:
					GOTO = 11000;
					break;
				case 17:
					GOTO = 12000;
					break;
				case 18:
					GOTO = 13000;
					break;
				case 19:
					GOTO = 14000;
					break;
				case 20:
					GOTO = 15000;
					break;
				case 21:
					GOTO = 16000;
					break;
				case 22:
					GOTO = 17000;
					break;
				case 23:
					GOTO = 18000;
					break;
				case 24:
					GOTO = 19000;
					break;
				case 25:
					GOTO = 20000;
					break;
				case 26:
					GOTO = 21000;
					break;
				case 27:
					GOTO = 22000;
					break;
				case 28:
					GOTO = 23000;
					break;
				case 29:
					GOTO = 24000;
					break;
				case 30:
					GOTO = 25000;
					break;
				case 31:
					GOTO = 26000;
					break;
				case 32:
					GOTO = 27000;
					break;
				default:
					game.dsub.bug_(7, ri);
			}

			if(GOTO == 0)
			{
				/* ALL VERB PROCESSORS RETURN HERE TO DECLARE FAILURE. */
	
				/* case 10: */
				ret_val = false;
				/* LOSE. */
				return ret_val;
			}
		}
		/* JOKE PROCESSOR. */
		/* FIND PROPER ENTRY IN JOKES, USE IT TO SELECT STRING TO PRINT. */

		loop: do
		{
			switch (GOTO)
			{

				case 100:
					i = jokes[ri - mxnop - 1];
					/* GET TABLE ENTRY. */
					j = i / 1000;
					/* ISOLATE # STRINGS. */
					if (j != 0)
					{
						i = i % 1000 + Supp.rnd_(j);
					}
					/* IF RANDOM, CHOOSE. */
					game.dsub.rspeak_(i);
					/* PRINT JOKE. */
					return ret_val;
				/* SVERBS, PAGE 2A */

				/* V65-- ROOM */

				case 65000:
					ret_val = game.dsub.rmdesc_(2);
					/* DESCRIBE ROOM ONLY. */
					return ret_val;

				/* V66-- OBJECTS */

				case 66000:
					ret_val = game.dsub.rmdesc_(1);
					/* DESCRIBE OBJ ONLY. */
					if (!vars.play_1.telflg)
					{
						game.dsub.rspeak_(138);
					}
					/* NO OBJECTS. */
					return ret_val;

				/* V67-- RNAME */

				case 67000:
					i__1 = vars.rooms_1.rdesc2[vars.play_1.here - 1];
					game.dsub.rspeak_(i__1);
					/* SHORT ROOM NAME. */
					return ret_val;

				/* V68-- RESERVED */

				case 68000:
					return ret_val;

				/* V69-- RESERVED */

				case 69000:
					return ret_val;
				/* SVERBS, PAGE 3 */

				/* V70-- BRIEF. SET FLAG. */

				case 1000:
					vars.findex_1.brieff = true;
					/* BRIEF DESCRIPTIONS. */
					vars.findex_1.superf = false;
					game.dsub.rspeak_(326);
					return ret_val;

				/* V71-- VERBOSE. CLEAR FLAGS. */

				case 2000:
					vars.findex_1.brieff = false;
					/* LONG DESCRIPTIONS. */
					vars.findex_1.superf = false;
					game.dsub.rspeak_(327);
					return ret_val;

				/* V72-- SUPERBRIEF. SET FLAG. */

				case 3000:
					vars.findex_1.superf = true;
					game.dsub.rspeak_(328);
					return ret_val;

				/* V73-- STAY (USED IN ENDGAME). */

				case 4000:
					if (vars.play_1.winner != vars.aindex_1.amastr)
					{
						GOTO = 4100;
						continue loop;
					}
					/* TELL MASTER, STAY. */
					game.dsub.rspeak_(781);
					/* HE DOES. */
					vars.cevent_1.ctick[vars.cindex_1.cevfol - 1] = 0;
					/* NOT FOLLOWING. */
					return ret_val;

				case 4100:
					if (vars.play_1.winner == vars.aindex_1.player)
					{
						game.dsub.rspeak_(664);
					}
					/* JOKE. */
					return ret_val;

				/* V74-- VERSION. PRINT INFO. */

				case 5000:
					System.out.printf("V%1d.%1d%c\n", vars.vers_1.vmaj, vars.vers_1.vmin,
							vars.vers_1.vedit);
					vars.play_1.telflg = true;
					return ret_val;

				/* V75-- SWIM. ALWAYS A JOKE. */

				case 6000:
					i = 330;
					/* ASSUME WATER. */
					if ((vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RWATER + Vars.RFILL) == 0)
					{
						i = Supp.rnd_(3) + 331;
					}
					game.dsub.rspeak_(i);
					return ret_val;

				/* V76-- GERONIMO. IF IN BARREL, FATAL, ELSE JOKE. */

				case 7000:
					if (vars.play_1.here == vars.rindex_1.mbarr)
					{
						GOTO = 7100;
						continue loop;
					}
					/* IN BARREL? */
					game.dsub.rspeak_(334);
					/* NO, JOKE. */
					return ret_val;

				case 7100:
					game.dsub.jigsup_(335);
					/* OVER FALLS. */
					return ret_val;

				/* V77-- SINBAD ET AL. CHASE CYCLOPS, ELSE JOKE. */

				case 8000:
					if (vars.play_1.here == vars.rindex_1.mcycl
							&& game.dsub.qhere_(vars.oindex_1.cyclo, vars.play_1.here))
					{
						GOTO = 8100;
						continue loop;
					}
					game.dsub.rspeak_(336);
					/* NOT HERE, JOKE. */
					return ret_val;

				case 8100:
					game.dsub.newsta_(vars.oindex_1.cyclo, 337, 0, 0, 0);
					/* CYCLOPS FLEES. */
					vars.findex_1.cyclof = true;
					/* SET ALL FLAGS. */
					vars.findex_1.magicf = true;
					vars.objcts_1.oflag2[vars.oindex_1.cyclo - 1] &= ~Vars.FITEBT;
					return ret_val;

				/* V78-- WELL. OPEN DOOR, ELSE JOKE. */

				case 9000:
					if (vars.findex_1.riddlf || vars.play_1.here != vars.rindex_1.riddl)
					{
						GOTO = 9100;
						continue loop;
					}
					/* IN RIDDLE ROOM? */
					vars.findex_1.riddlf = true;
					/* YES, SOLVED IT. */
					game.dsub.rspeak_(338);
					return ret_val;

				case 9100:
					game.dsub.rspeak_(339);
					/* WELL, WHAT? */
					return ret_val;

				/* V79-- PRAY. IF IN TEMP2, POOF */
				/*  */

				case 10000:
					if (vars.play_1.here != vars.rindex_1.temp2)
					{
						GOTO = 10050;
						continue loop;
					}
					/* IN TEMPLE? */
					if (game.dso2.moveto_(vars.rindex_1.fore1, vars.play_1.winner))
					{
						GOTO = 10100;
						continue loop;
					}
					/* FORE1 STILL THERE? */
				case 10050:
					game.dsub.rspeak_(340);
					/* JOKE. */
					return ret_val;

				case 10100:
					game.dsub.rmdesc_(3);
					/* MOVED, DESCRIBE. */
					return ret_val;

				/* V80-- TREASURE. IF IN TEMP1, POOF */
				/*  */

				case 11000:
					if (vars.play_1.here != vars.rindex_1.temp1)
					{
						GOTO = 11050;
						continue loop;
					}
					/* IN TEMPLE? */
					if (game.dso2.moveto_(vars.rindex_1.treas, vars.play_1.winner))
					{
						GOTO = 10100;
						continue loop;
					}
					/* TREASURE ROOM THERE? */
				case 11050:
					game.dsub.rspeak_(341);
					/* NOTHING HAPPENS. */
					return ret_val;

				/* V81-- TEMPLE. IF IN TREAS, POOF */
				/*  */

				case 12000:
					if (vars.play_1.here != vars.rindex_1.treas)
					{
						GOTO = 12050;
						continue loop;
					}
					/* IN TREASURE? */
					if (game.dso2.moveto_(vars.rindex_1.temp1, vars.play_1.winner))
					{
						GOTO = 10100;
						continue loop;
					}
					/* TEMP1 STILL THERE? */
				case 12050:
					game.dsub.rspeak_(341);
					/* NOTHING HAPPENS. */
					return ret_val;

				/* V82-- BLAST. USUALLY A JOKE. */

				case 13000:
					i = 342;
					/* DONT UNDERSTAND. */
					if (vars.prsvec_1.direct_object == vars.oindex_1.safe)
					{
						i = 252;
					}
					/* JOKE FOR SAFE. */
					game.dsub.rspeak_(i);
					return ret_val;

				/* V83-- SCORE. PRINT SCORE. */

				case 14000:
					game.dso2.score_(false);
					return ret_val;

				/* V84-- QUIT. FINISH OUT THE GAME. */

				case 15000:
					game.dso2.score_(true);
					/* TELLL SCORE. */
					if (!game.dso3.yesno_(343, 0, 0))
					{
						return ret_val;
					}
					/* ASK FOR Y/N DECISION. */
					Supp.exit_();
					/* BYE. */
					/* SVERBS, PAGE 4 */

					/* V85-- FOLLOW (USED IN ENDGAME) */

				case 16000:
					if (vars.play_1.winner != vars.aindex_1.amastr)
					{
						return ret_val;
					}
					/* TELL MASTER, FOLLOW. */
					game.dsub.rspeak_(782);
					vars.cevent_1.ctick[vars.cindex_1.cevfol - 1] = -1;
					/* STARTS FOLLOWING. */
					return ret_val;

				/* V86-- WALK THROUGH */

				case 17000:
					if (vars.screen_1.scolrm == 0 || vars.prsvec_1.direct_object != vars.oindex_1.scol
							&& (vars.prsvec_1.direct_object != vars.oindex_1.wnort
									|| vars.play_1.here != vars.rindex_1.bkbox))
					{
						GOTO = 17100;
						continue loop;
					}
					vars.screen_1.scolac = vars.screen_1.scolrm;
					/* WALKED THRU SCOL. */
					vars.prsvec_1.direct_object = 0;
					/* FAKE OUT FROMDR. */
					vars.cevent_1.ctick[vars.cindex_1.cevscl - 1] = 6;
					/* START ALARM. */
					game.dsub.rspeak_(668);
					/* DISORIENT HIM. */
					game.dso2.moveto_(vars.screen_1.scolrm, vars.play_1.winner);
					/* INTO ROOM. */
					game.dsub.rmdesc_(3);
					/* DESCRIBE. */
					return ret_val;

				case 17100:
					if (vars.play_1.here != vars.screen_1.scolac)
					{
						GOTO = 17300;
						continue loop;
					}
					/* ON OTHER SIDE OF SCOL? */
					for (i = 1; i <= 12; i += 3)
					{
						/* WALK THRU PROPER WALL? */
						if (vars.screen_1.scolwl[i - 1] == vars.play_1.here
								&& vars.screen_1.scolwl[i] == vars.prsvec_1.direct_object)
						{
							GOTO = 17500;
							continue loop;
						}
						/* case 17200: */
					}

				case 17300:
					if ((vars.objcts_1.oflag1[vars.prsvec_1.direct_object - 1] & Vars.TAKEBT) != 0)
					{
						GOTO = 17400;
						continue loop;
					}
					i = 669;
					/* NO, JOKE. */
					if (vars.prsvec_1.direct_object == vars.oindex_1.scol)
					{
						i = 670;
					}
					/* SPECIAL JOKE FOR SCOL. */
					game.dsub.rspsub_(i, odo2);
					return ret_val;

				case 17400:
					i = 671;
					/* JOKE. */
					if (vars.objcts_1.oroom[vars.prsvec_1.direct_object - 1] != 0)
					{
						i = Supp.rnd_(5) + 552;
					}
					/* SPECIAL JOKES IF CARRY. */
					game.dsub.rspeak_(i);
					return ret_val;

				case 17500:
					vars.prsvec_1.direct_object = vars.screen_1.scolwl[i + 1];
					/* THRU SCOL WALL... */
					for (i = 1; i <= 8; i += 2)
					{
						/* FIND MATCHING ROOM. */
						if (vars.prsvec_1.direct_object == vars.screen_1.scoldr[i - 1])
						{
							vars.screen_1.scolrm = vars.screen_1.scoldr[i];
						}
						/* case 17600: */
					}
					/* DECLARE NEW SCOLRM. */
					vars.cevent_1.ctick[vars.cindex_1.cevscl - 1] = 0;
					/* CANCEL ALARM. */
					game.dsub.rspeak_(668);
					/* DISORIENT HIM. */
					game.dso2.moveto_(vars.rindex_1.bkbox, vars.play_1.winner);
					/* BACK IN BOX ROOM. */
					game.dsub.rmdesc_(3);
					return ret_val;

				/* V87-- RING. A JOKE. */

				case 18000:
					i = 359;
					/* CANT RING. */
					if (vars.prsvec_1.direct_object == vars.oindex_1.bell)
					{
						i = 360;
					}
					/* DING, DONG. */
					game.dsub.rspeak_(i);
					/* JOKE. */
					return ret_val;

				/* V88-- BRUSH. JOKE WITH OBSCURE TRAP. */

				case 19000:
					if (vars.prsvec_1.direct_object == vars.oindex_1.teeth)
					{
						GOTO = 19100;
						continue loop;
					}
					/* BRUSH TEETH? */
					game.dsub.rspeak_(362);
					/* NO, JOKE. */
					return ret_val;

				case 19100:
					if (vars.prsvec_1.indirect_object != 0)
					{
						GOTO = 19200;
						continue loop;
					}
					/* WITH SOMETHING? */
					game.dsub.rspeak_(363);
					/* NO, JOKE. */
					return ret_val;

				case 19200:
					if (vars.prsvec_1.indirect_object == vars.oindex_1.putty
							&& vars.objcts_1.oadv[vars.oindex_1.putty - 1] == vars.play_1.winner)
					{
						GOTO = 19300;
						continue loop;
					}
					game.dsub.rspsub_(364, odi2);
					/* NO, JOKE. */
					return ret_val;

				case 19300:
					game.dsub.jigsup_(365);
					/* YES, DEAD */
					/*  */
					/*  */
					/*  */
					/*  */
					/*  */
					return ret_val;
				/* SVERBS, PAGE 5 */

				/* V89-- DIG. UNLESS SHOVEL, A JOKE. */

				case 20000:
					if (vars.prsvec_1.direct_object == vars.oindex_1.shove)
					{
						return ret_val;
					}
					/* SHOVEL? */
					i = 392;
					/* ASSUME TOOL. */
					if ((vars.objcts_1.oflag1[vars.prsvec_1.direct_object - 1] & Vars.TOOLBT) == 0)
					{
						i = 393;
					}
					game.dsub.rspsub_(i, odo2);
					return ret_val;

				/* V90-- TIME. PRINT OUT DURATION OF GAME. */

				case 21000:
					game.dso5.gttime_(k);
					/* GET PLAY TIME. */
					i = k[0] / 60;
					j = k[0] % 60;

					System.out.printf("You have been playing Dungeon for ");
					if (i >= 1)
					{
						System.out.printf("%d hour", i);
						if (i >= 2)
							System.out.printf("s");
						System.out.printf(" and ");
					}
					System.out.printf("%d minute", j);
					if (j != 1)
						System.out.printf("s");
					System.out.printf(".\n");
					vars.play_1.telflg = true;
					return ret_val;

				/* V91-- LEAP. USUALLY A JOKE, WITH A CATCH. */

				case 22000:
					if (vars.prsvec_1.direct_object == 0)
					{
						GOTO = 22200;
						continue loop;
					}
					/* OVER SOMETHING? */
					if (game.dsub.qhere_(vars.prsvec_1.direct_object, vars.play_1.here))
					{
						GOTO = 22100;
						continue loop;
					}
					/* HERE? */
					game.dsub.rspeak_(447);
					/* NO, JOKE. */
					return ret_val;

				case 22100:
					if ((vars.objcts_1.oflag2[vars.prsvec_1.direct_object - 1] & Vars.VILLBT) == 0)
					{
						GOTO = 22300;
						continue loop;
					}
					game.dsub.rspsub_(448, odo2);
					/* CANT JUMP VILLAIN. */
					return ret_val;

				case 22200:
					if (!game.dso3.findxt_(vars.xsrch_1.xdown, vars.play_1.here))
					{
						GOTO = 22300;
						continue loop;
					}
					/* DOWN EXIT? */
					if (vars.curxt_1.xtype == vars.xpars_1.xno
							|| vars.curxt_1.xtype == vars.xpars_1.xcond
									&& !vars.findex_1.flags(vars.curxt_1.xflag() - 1))
					{
						GOTO = 22400;
						continue loop;
					}
				case 22300:
					i__1 = Supp.rnd_(5) + 314;
					game.dsub.rspeak_(i__1);
					/* WHEEEE */
					/*  */
					return ret_val;

				case 22400:
					i__1 = Supp.rnd_(4) + 449;
					game.dsub.jigsup_(i__1);
					/* FATAL LEAP. */
					return ret_val;
				/* SVERBS, PAGE 6 */

				/* V92-- LOCK. */

				case 23000:
					if (vars.prsvec_1.direct_object == vars.oindex_1.grate
							&& vars.play_1.here == vars.rindex_1.mgrat)
					{
						GOTO = 23200;
						continue loop;
					}
				case 23100:
					game.dsub.rspeak_(464);
					/* NOT LOCK GRATE. */
					return ret_val;

				case 23200:
					vars.findex_1.grunlf = false;
					/* GRATE NOW LOCKED. */
					game.dsub.rspeak_(214);
					vars.exits_1.travel[vars.rooms_1.rexit[vars.play_1.here - 1]] = 214;
					/* CHANGE EXIT STATUS. */
					return ret_val;

				/* V93-- UNLOCK */

				case 24000:
					if (vars.prsvec_1.direct_object != vars.oindex_1.grate
							|| vars.play_1.here != vars.rindex_1.mgrat)
					{
						GOTO = 23100;
						continue loop;
					}
					if (vars.prsvec_1.indirect_object == vars.oindex_1.keys)
					{
						GOTO = 24200;
						continue loop;
					}
					/* GOT KEYS? */
					game.dsub.rspsub_(465, odi2);
					/* NO, JOKE. */
					return ret_val;

				case 24200:
					vars.findex_1.grunlf = true;
					/* UNLOCK GRATE. */
					game.dsub.rspeak_(217);
					vars.exits_1.travel[vars.rooms_1.rexit[vars.play_1.here - 1]] = 217;
					/* CHANGE EXIT STATUS. */
					return ret_val;

				/* V94-- DIAGNOSE. */

				case 25000:
					i = game.dso4.fights_(vars.play_1.winner, false);
					/* GET FIGHTS STRENGTH. */
					j = vars.advs_1.astren[vars.play_1.winner - 1];
					/* GET HEALTH. */
					/* Computing MIN */
					i__1 = i + j;
					k[0] = Math.min(i__1, 4);
					/* GET STATE. */
					if (!vars.cevent_1.cflag[vars.cindex_1.cevcur - 1])
					{
						j = 0;
					}
					/* IF NO WOUNDS. */
					/* Computing MIN */
					i__1 = 4;
					i__2 = Math.abs(j);
					l = Math.min(i__1, i__2);
					/* SCALE. */
					i__1 = l + 473;
					game.dsub.rspeak_(i__1);
					/* DESCRIBE HEALTH. */
					i = (-j - 1) * 30 + vars.cevent_1.ctick[vars.cindex_1.cevcur - 1];
					/* COMPUTE WAIT. */

					if (j != 0)
					{
						System.out.printf("You will be cured after %d moves.\n", i);
					}

					i__1 = k[0] + 478;
					game.dsub.rspeak_(i__1);
					/* HOW MUCH MORE? */
					if (vars.state_1.deaths != 0)
					{
						i__1 = vars.state_1.deaths + 482;
						game.dsub.rspeak_(i__1);
					}
					/* HOW MANY DEATHS? */
					return ret_val;
				/* SVERBS, PAGE 7 */

				/* V95-- INCANT */

				case 26000:
					for (i = 1; i <= 6; ++i)
					{
						/* SET UP PARSE. */
						pp1[i - 1] = ' ';
						pp2[i - 1] = ' ';
						/* case 26100: */
					}
					wp = 1;
					/* WORD POINTER. */
					cp = 1;
					/* CHAR POINTER. */
					if (vars.prsvec_1.prscon <= 1)
					{
						GOTO = 26300;
						continue loop;
					}
					int index = 0;
					for (z = vars.input_1.inbuf[vars.prsvec_1.prscon - 1
							+ index]; z != '\0'; index++)
					{
						/* PARSE INPUT */
						if (z == ',')
						{
							GOTO = 26300;
							continue loop;
						}
						/* END OF PHRASE? */
						if (z == ' ')
						{

							/* SPACE? */
							if (cp != 1)
							{
								++wp;
							}
							cp = 1;
							continue;
						}
						if (wp == 1)
						{
							pp1[cp - 1] = z;
						}
						/* STUFF INTO HOLDER. */
						if (wp == 2)
						{
							pp2[cp - 1] = z;
						}
						/* Computing MIN */
						i__2 = cp + 1;
						cp = Math.min(i__2, 6);

					}

				case 26300:
					vars.prsvec_1.prscon = 1;
					/* KILL REST OF LINE. */
					if (pp1[0] != ' ')
					{
						GOTO = 26400;
						continue loop;
					}
					/* ANY INPUT? */
					game.dsub.rspeak_(856);
					/* NO, HO HUM. */
					return ret_val;

				case 26400:
					game.dso7.encryp_(pp1, ch);
					/* COMPUTE RESPONSE. */
					if (pp2[0] != ' ')
					{
						GOTO = 26600;
						continue loop;
					}
					/* TWO PHRASES? */

					if (vars.findex_1.spellf)
					{
						GOTO = 26550;
						continue loop;
					}
					/* HE'S TRYING TO LEARN. */
					if ((vars.rooms_1.rflag[vars.rindex_1.tstrs - 1] & Vars.RSEEN) == 0)
					{
						GOTO = 26575;
						continue loop;
					}
					vars.findex_1.spellf = true;
					/* TELL HIM. */
					vars.play_1.telflg = true;
					System.out.printf("A hollow voice replies:  \"%.6s %.6s\".\n", pp1, ch);

					return ret_val;

				case 26550:
					game.dsub.rspeak_(857);
					/* HE'S GOT ONE ALREADY. */
					return ret_val;

				case 26575:
					game.dsub.rspeak_(858);
					/* HE'S NOT IN ENDGAME. */
					return ret_val;

				case 26600:
					if ((vars.rooms_1.rflag[vars.rindex_1.tstrs - 1] & Vars.RSEEN) != 0)
					{
						GOTO = 26800;
						continue loop;
					}
					for (i = 1; i <= 6; ++i)
					{
						if (pp2[i - 1] != ch[i - 1])
						{
							GOTO = 26575;
							continue loop;
						}
						/* WRONG. */
						/* case 26700: */
					}
					vars.findex_1.spellf = true;
					/* IT WORKS. */
					game.dsub.rspeak_(859);
					vars.cevent_1.ctick[vars.cindex_1.cevste - 1] = 1;
					/* FORCE START. */
					return ret_val;

				case 26800:
					game.dsub.rspeak_(855);
					/* TOO LATE. */
					return ret_val;
				/* SVERBS, PAGE 8 */

				/* V96-- ANSWER */

				case 27000:
					if (vars.prsvec_1.prscon > 1 && vars.play_1.here == vars.rindex_1.fdoor
							&& vars.findex_1.inqstf)
					{
						GOTO = 27100;
						continue loop;
					}
					game.dsub.rspeak_(799);
					/* NO ONE LISTENS. */
					vars.prsvec_1.prscon = 1;
					return ret_val;

				case 27100:
					 for (j = 1; j <= 14; j ++) 
					 {
					      /* CHECK ANSWERS. */
					      if (vars.findex_1.quesno != answer[j - 1])
					         continue;
//					      /* ONLY CHECK PROPER ANS. */
					      String zz = ansstr[j - 1];
					      int ans_index = vars.prsvec_1.prscon -1;
					      String user_answer = new String(vars.input_1.inbuf);
//					      char[] z2 = vars.input_1.inbuf + vars.prsvec_1.prscon - 1;
					      String zz2 = user_answer.substring(ans_index).trim();
					      System.out.println(zz2);
					      
					      int zindex = 0;
					      int z2index = 0;
					      while (zindex < zz.length() && zz.charAt(zindex) != '\0' ) 
					      {
					         while (zz2.charAt(z2index) == ' ')
					            z2index++;
					         /* STRIP INPUT BLANKS. */
					         if (zz.charAt(zindex) != zz2.charAt(z2index))
					            continue;
					         zindex++;
					         z2index++;
					      }
					      GOTO = 27500;
					      continue loop;
					      /* RIGHT ANSWER. */

					   }

					   vars.prsvec_1.prscon = 1;
					   /* KILL REST OF LINE. */
					   ++vars.findex_1.nqatt;
					   /* WRONG, CRETIN. */
					   if (vars.findex_1.nqatt >= 5) {
						   GOTO = 27400;
						   continue;
					   }
					   /* TOO MANY WRONG? */
					   i__1 = vars.findex_1.nqatt + 800;
					   game.dsub.rspeak_(i__1);
					   /* NO, TRY AGAIN. */
					   return ret_val;

				case 27400:
					game.dsub.rspeak_(826);
					/* ALL OVER. */
					vars.cevent_1.cflag[vars.cindex_1.cevinq - 1] = false;
					/* LOSE. */
					return ret_val;

				case 27500:
					vars.prsvec_1.prscon = 1;
					/* KILL REST OF LINE. */
					++vars.findex_1.corrct;
					/* GOT IT RIGHT. */
					game.dsub.rspeak_(800);
					/* HOORAY. */
					if (vars.findex_1.corrct >= 3)
					{
						GOTO = 27600;
						continue loop;
					}
					/* WON TOTALLY? */
					vars.cevent_1.ctick[vars.cindex_1.cevinq - 1] = 2;
					/* NO, START AGAIN. */
					vars.findex_1.quesno = (vars.findex_1.quesno + 3) % 8;
					vars.findex_1.nqatt = 0;
					game.dsub.rspeak_(769);
					/* ASK NEXT QUESTION. */
					i__1 = vars.findex_1.quesno + 770;
					game.dsub.rspeak_(i__1);
					return ret_val;

				case 27600:
					game.dsub.rspeak_(827);
					/* QUIZ OVER, */
					vars.cevent_1.cflag[vars.cindex_1.cevinq - 1] = false;
					vars.objcts_1.oflag2[vars.oindex_1.qdoor - 1] |= Vars.OPENBT;
					return ret_val;

			}
		} while (true);
	} /* sverbs_ */

}
