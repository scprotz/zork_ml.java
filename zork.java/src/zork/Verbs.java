package zork;

import java.io.IOException;

public class Verbs
{
	/* VAPPLI- MAIN VERB PROCESSING ROUTINE */

	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;
	Dverb1 dverb1 = null;
	Dverb2 dverb2 = null;
	Sverbs sverbs = null;
	
	public Verbs(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
		this.dverb1 = new Dverb1(vars, game, this);
		this.dverb2 = new Dverb2(vars, game, this);
		this.sverbs = new Sverbs(vars, game, this);
	}

//	#include "funcs.h"
//	#include "vars.h"
//
	public boolean vappli_(int ri) throws IOException
	{
		/* Initialized data */

		final int mxnop = 39;
		final int mxsmp = 99;

		/* System generated locals */
		int i__1;
		boolean ret_val;

		/* Local variables */
		int melee;
		boolean f = false;
		int i = 0, j = 0, av  = 0;
		int rmk = 0;
		int odi2 = 0, odo2 = 0;
		int GOTO = 0;
		ret_val = true;
		/* !ASSUME WINS. */

		if (vars.prsvec_1.prso > 220)
		{
			GOTO = 5;
		}

		if (GOTO != 5)
		{
			if (vars.prsvec_1.prso != 0)
			{
				odo2 = vars.objcts_1.odesc2[vars.prsvec_1.prso - 1];
			}
		}
		GOTO = 5;

		loop: do
		{
			switch (GOTO)
			{

				/* !SET UP DESCRIPTORS. */
				case 5:
					if (vars.prsvec_1.prsi != 0)
					{
						odi2 = vars.objcts_1.odesc2[vars.prsvec_1.prsi - 1];
					}
					av = vars.advs_1.avehic[vars.play_1.winner - 1];
					rmk = Supp.rnd_(6) + 372;
					/* !REMARK FOR HACK-HACKS. */

					if (ri == 0)
					{
						GOTO = 10;
						continue loop;

					}
					/* !ZERO IS FALSE. */
					if (ri <= mxnop)
					{
						return ret_val;
					}
					/* !NOP? */
					if (ri <= mxsmp)
					{
						GOTO = 100;
						continue loop;

					}
					/* !SIMPLE VERB? */
					switch (ri - mxsmp)
					{
						case 1:
							GOTO = 18000;
							continue loop;

						case 2:
							GOTO = 20000;
							continue loop;

						case 3:
							GOTO = 22000;
							continue loop;

						case 4:
							GOTO = 23000;
							continue loop;

						case 5:
							GOTO = 24000;
							continue loop;

						case 6:
							GOTO = 25000;
							continue loop;

						case 7:
							GOTO = 26000;
							continue loop;

						case 8:
							GOTO = 27000;
							continue loop;

						case 9:
							GOTO = 28000;
							continue loop;

						case 10:
							GOTO = 29000;
							continue loop;

						case 11:
							GOTO = 30000;
							continue loop;

						case 12:
							GOTO = 31000;
							continue loop;

						case 13:
							GOTO = 32000;
							continue loop;

						case 14:
							GOTO = 33000;
							continue loop;

						case 15:
							GOTO = 34000;
							continue loop;

						case 16:
							GOTO = 35000;
							continue loop;

						case 17:
							GOTO = 36000;
							continue loop;

						case 18:
							GOTO = 38000;
							continue loop;

						case 19:
							GOTO = 39000;
							continue loop;

						case 20:
							GOTO = 40000;
							continue loop;

						case 21:
							GOTO = 41000;
							continue loop;

						case 22:
							GOTO = 42000;
							continue loop;

						case 23:
							GOTO = 43000;
							continue loop;

						case 24:
							GOTO = 44000;
							continue loop;

						case 25:
							GOTO = 45000;
							continue loop;

						case 26:
							GOTO = 46000;
							continue loop;

						case 27:
							GOTO = 47000;
							continue loop;

						case 28:
							GOTO = 48000;
							continue loop;

						case 29:
							GOTO = 49000;
							continue loop;

						case 30:
							GOTO = 50000;
							continue loop;

						case 31:
							GOTO = 51000;
							continue loop;

						case 32:
							GOTO = 52000;
							continue loop;

						case 33:
							GOTO = 53000;
							continue loop;

						case 34:
							GOTO = 55000;
							continue loop;

						case 35:
							GOTO = 56000;
							continue loop;

						case 36:
							GOTO = 58000;
							continue loop;

						case 37:
							GOTO = 59000;
							continue loop;

						case 38:
							GOTO = 60000;
							continue loop;

						case 39:
							GOTO = 63000;
							continue loop;

						case 40:
							GOTO = 64000;
							continue loop;

						case 41:
							GOTO = 65000;
							continue loop;

						case 42:
							GOTO = 66000;
							continue loop;

						case 43:
							GOTO = 68000;
							continue loop;

						case 44:
							GOTO = 69000;
							continue loop;

						case 45:
							GOTO = 70000;
							continue loop;

						case 46:
							GOTO = 71000;
							continue loop;

						case 47:
							GOTO = 72000;
							continue loop;

						case 48:
							GOTO = 73000;
							continue loop;

						case 49:
							GOTO = 74000;
							continue loop;

						case 50:
							GOTO = 77000;
							continue loop;

						case 51:
							GOTO = 78000;
							continue loop;

						case 52:
							GOTO = 80000;
							continue loop;

						case 53:
							GOTO = 81000;
							continue loop;

						case 54:
							GOTO = 82000;
							continue loop;

						case 55:
							GOTO = 83000;
							continue loop;

						case 56:
							GOTO = 84000;
							continue loop;

						case 57:
							GOTO = 85000;
							continue loop;

						case 58:
							GOTO = 86000;
							continue loop;

						case 59:
							GOTO = 87000;
							continue loop;

						case 60:
							GOTO = 88000;
							continue loop;

					}
					game.dsub.bug_(7, ri);

					/* ALL VERB PROCESSORS RETURN HERE TO DECLARE FAILURE. */

				case 10:
					ret_val = false;
					/* !LOSE. */
					return ret_val;

				/* SIMPLE VERBS ARE HANDLED EXTERNALLY. */

				case 100:
					ret_val = sverbs.sverbs_(ri);
					return ret_val;

				/* V100-- READ. OUR FIRST REAL VERB. */

				case 18000:
					if (game.dso5.lit_(vars.play_1.here))
					{
						GOTO = 18100;
						continue loop;
					}
					/* !ROOM LIT? */
					game.dsub.rspeak_(356);
					/* !NO, CANT READ. */
					return ret_val;

				case 18100:
					if (vars.prsvec_1.prsi == 0)
					{
						GOTO = 18200;
						continue loop;
					}
					/* !READ THROUGH OBJ? */
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prsi - 1] & Vars.TRANBT) != 0)
					{
						GOTO = 18200;
						continue loop;
					}
					game.dsub.rspsub_(357, odi2);
					/* !NOT TRANSPARENT. */
					return ret_val;

				case 18200:
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.READBT) != 0)
					{
						GOTO = 18300;
						continue loop;
					}
					game.dsub.rspsub_(358, odo2);
					/* !NOT READABLE. */
					return ret_val;

				case 18300:
					if (!game.dsub.objact_())
					{
						game.dsub.rspeak_(vars.objcts_1.oread[vars.prsvec_1.prso - 1]);
					}
					return ret_val;

				/* V101-- MELT. UNLESS OBJECT HANDLES, JOKE. */

				case 20000:
					if (!game.dsub.objact_())
					{
						game.dsub.rspsub_(361, odo2);
					}
					return ret_val;

				/* V102-- INFLATE. WORKS ONLY WITH BOATS. */

				case 22000:
					if (!game.dsub.objact_())
					{
						game.dsub.rspeak_(368);
					}
					/* !OBJ HANDLE? */
					return ret_val;

				/* V103-- DEFLATE. */

				case 23000:
					if (!game.dsub.objact_())
					{
						game.dsub.rspeak_(369);
					}
					/* !OBJ HANDLE? */
					return ret_val;

				/* V104-- ALARM. IF SLEEPING, WAKE HIM UP. */

				case 24000:
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.SLEPBT) == 0)
					{
						GOTO = 24100;
						continue loop;
					}
					ret_val = game.dsub.objact_();
					/* !SLEEPING, LET OBJ DO. */
					return ret_val;

				case 24100:
					game.dsub.rspsub_(370, odo2);
					/* !JOKE. */
					return ret_val;

				/* V105-- EXORCISE. OBJECTS HANDLE. */

				case 25000:
					f = game.dsub.objact_();
					/* !OBJECTS HANDLE. */
					return ret_val;

				/* V106-- PLUG. LET OBJECTS HANDLE. */

				case 26000:
					if (!game.dsub.objact_())
					{
						game.dsub.rspeak_(371);
					}
					return ret_val;

				/* V107-- KICK. IF OBJECT IGNORES, JOKE. */

				case 27000:
					if (!game.dsub.objact_())
					{
						game.dsub.rspsb2_(378, odo2, rmk);
					}
					return ret_val;

				/* V108-- WAVE. SAME. */

				case 28000:
					if (!game.dsub.objact_())
					{
						game.dsub.rspsb2_(379, odo2, rmk);
					}
					return ret_val;

				/* V109,V110-- RAISE, LOWER. SAME. */

				case 29000:
				case 30000:
					if (!game.dsub.objact_())
					{
						game.dsub.rspsb2_(380, odo2, rmk);
					}
					return ret_val;

				/* V111-- RUB. SAME. */

				case 31000:
					if (!game.dsub.objact_())
					{
						game.dsub.rspsb2_(381, odo2, rmk);
					}
					return ret_val;

				/* V112-- PUSH. SAME. */

				case 32000:
					if (!game.dsub.objact_())
					{
						game.dsub.rspsb2_(382, odo2, rmk);
					}
					return ret_val;
				/* VAPPLI, PAGE 5 */

				/* V113-- UNTIE. IF OBJECT IGNORES, JOKE. */

				case 33000:
					if (game.dsub.objact_())
					{
						return ret_val;
					}
					/* !OBJECT HANDLE? */
					i = 383;
					/* !NO, NOT TIED. */
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.TIEBT) == 0)
					{
						i = 384;
					}
					game.dsub.rspeak_(i);
					return ret_val;

				/* V114-- TIE. NEVER REALLY WORKS. */

				case 34000:
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.TIEBT) != 0)
					{
						GOTO = 34100;
						continue loop;
					}
					game.dsub.rspeak_(385);
					/* !NOT TIEABLE. */
					return ret_val;

				case 34100:
					if (!game.dsub.objact_())
					{
						game.dsub.rspsub_(386, odo2);
					}
					/* !JOKE. */
					return ret_val;

				/* V115-- TIE UP. NEVER REALLY WORKS. */

				case 35000:
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prsi - 1] & Vars.TIEBT) != 0)
					{
						GOTO = 35100;
						continue loop;
					}
					game.dsub.rspsub_(387, odo2);
					/* !NOT TIEABLE. */
					return ret_val;

				case 35100:
					i = 388;
					/* !ASSUME VILLAIN. */
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.VILLBT) == 0)
					{
						i = 389;
					}
					game.dsub.rspsub_(i, odo2);
					/* !JOKE. */
					return ret_val;

				/* V116-- TURN. OBJECT MUST HANDLE. */

				case 36000:
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.TURNBT) != 0)
					{
						GOTO = 36100;
						continue loop;
					}
					game.dsub.rspeak_(390);
					/* !NOT TURNABLE. */
					return ret_val;

				case 36100:
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prsi - 1] & Vars.TOOLBT) != 0)
					{
						GOTO = 36200;
						continue loop;
					}
					game.dsub.rspsub_(391, odi2);
					/* !NOT A TOOL. */
					return ret_val;

				case 36200:
					ret_val = game.dsub.objact_();
					/* !LET OBJECT HANDLE. */
					return ret_val;

				/* V117-- BREATHE. BECOMES INFLATE WITH LUNGS. */

				case 38000:
					vars.prsvec_1.prsa = vars.vindex_1.inflaw;
					vars.prsvec_1.prsi = vars.oindex_1.lungs;
					GOTO = 22000;
					continue loop;
				/* !HANDLE LIKE INFLATE. */

				/* V118-- KNOCK. MOSTLY JOKE. */

				case 39000:
					if (game.dsub.objact_())
					{
						return ret_val;
					}
					/* !OBJ HANDLE? */
					i = 394;
					/* !JOKE FOR DOOR. */
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.DOORBT) == 0)
					{
						i = 395;
					}
					game.dsub.rspsub_(i, odo2);
					/* !JOKE FOR NONDOORS TOO. */
					return ret_val;

				/* V119-- LOOK. */

				case 40000:
					if (vars.prsvec_1.prso != 0)
					{
						GOTO = 41500;
						continue loop;
					}
					/* !SOMETHING TO LOOK AT? */
					ret_val = game.dsub.rmdesc_(3);
					/* !HANDLED BY RMDESC. */
					return ret_val;

				/* V120-- EXAMINE. */

				case 41000:
					if (vars.prsvec_1.prso != 0)
					{
						GOTO = 41500;
						continue loop;
					}
					/* !SOMETHING TO EXAMINE? */
					ret_val = game.dsub.rmdesc_(0);
					/* !HANDLED BY RMDESC. */
					return ret_val;

				case 41500:
					if (game.dsub.objact_())
					{
						return ret_val;
					}
					/* !OBJ HANDLE? */
					i = vars.objcts_1.oread[vars.prsvec_1.prso - 1];
					/* !GET READING MATERIAL. */
					if (i != 0)
					{
						game.dsub.rspeak_(i);
					}
					/* !OUTPUT IF THERE, */
					if (i == 0)
					{
						game.dsub.rspsub_(429, odo2);
					}
					/* !OTHERWISE DEFAULT. */
					vars.prsvec_1.prsa = vars.vindex_1.foow;
					/* !DEFUSE ROOM PROCESSORS. */
					return ret_val;

				/* V121-- SHAKE. IF HOLLOW OBJECT, SOME ACTION. */

				case 42000:
					if (game.dsub.objact_())
					{
						return ret_val;
					}
					/* !OBJECT HANDLE? */
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.VILLBT) == 0)
					{
						GOTO = 42100;
						continue loop;
					}
					game.dsub.rspeak_(371);
					/* !JOKE FOR VILLAINS. */
					return ret_val;

				case 42100:
					if (game.dsub.qempty_(vars.prsvec_1.prso)
							|| (vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.TAKEBT) == 0)
					{
						GOTO = 10;
						continue loop;
					}
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.OPENBT) != 0)
					{
						GOTO = 42300;
						continue loop;
					}
					/* !OPEN? SPILL. */
					game.dsub.rspsub_(396, odo2);
					/* !NO, DESCRIBE NOISE. */
					return ret_val;

				case 42300:
					game.dsub.rspsub_(397, odo2);
					/* !SPILL THE WORKS. */
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* !SPILL CONTENTS. */
						if (vars.objcts_1.ocan[i - 1] != vars.prsvec_1.prso)
						{
//	    		GOTO = 42500;
//	    		continue loop;
							continue;
						}
						/* !INSIDE? */
						vars.objcts_1.oflag2[i - 1] |= Vars.TCHBT;
						if (av == 0)
						{
							game.dsub.newsta_(i, 0, vars.play_1.here, 0, 0);
							/* !NO, SPILL ON FLOOR, */
							if (i == vars.oindex_1.water)
							{
								game.dsub.newsta_(i, 133, 0, 0, 0);
							}
						}
						/* !IN VEHICLE? */
						game.dsub.newsta_(i, 0, 0, av, 0);
						/* !YES, SPILL IN THERE. */
						continue;

					}
					return ret_val;

				/* V122-- MOVE. MOSTLY JOKES. */

				case 43000:
					if (game.dsub.objact_())
					{
						return ret_val;
					}
					/* !OBJ HANDLE? */
					i = 398;
					/* !ASSUME NOT HERE. */
					if (game.dsub.qhere_(vars.prsvec_1.prso, vars.play_1.here))
					{
						i = 399;
					}
					game.dsub.rspsub_(i, odo2);
					/* !JOKE. */
					return ret_val;

				/* V123-- TURN ON. */

				case 44000:
					f = game.dso5.lit_(vars.play_1.here);
					/* !RECORD IF LIT. */
					if (game.dsub.objact_())
					{
						GOTO = 44300;
						continue loop;
					}
					/* !OBJ HANDLE? */
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.LITEBT) != 0
							&& vars.objcts_1.oadv[vars.prsvec_1.prso - 1] == vars.play_1.winner)
					{
						GOTO = 44100;
						continue loop;
					}
					game.dsub.rspeak_(400);
					/* !CANT DO IT. */
					return ret_val;

				case 44100:
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.ONBT) == 0)
					{
						GOTO = 44200;
						continue loop;
					}
					game.dsub.rspeak_(401);
					/* !ALREADY ON. */
					return ret_val;

				case 44200:
					vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] |= Vars.ONBT;
					game.dsub.rspsub_(404, odo2);
				case 44300:
					if (!f && game.dso5.lit_(vars.play_1.here))
					{
						f = game.dsub.rmdesc_(0);
					}
					/* !ROOM NEWLY LIT. */
					return ret_val;

				/* V124-- TURN OFF. */

				case 45000:
					if (game.dsub.objact_())
					{
						GOTO = 45300;
						continue loop;
					}
					/* !OBJ HANDLE? */
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.LITEBT) != 0
							&& vars.objcts_1.oadv[vars.prsvec_1.prso - 1] == vars.play_1.winner)
					{
						GOTO = 45100;
						continue loop;
					}
					game.dsub.rspeak_(402);
					/* !CANT DO IT. */
					return ret_val;

				case 45100:
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.ONBT) != 0)
					{
						GOTO = 45200;
						continue loop;
					}
					game.dsub.rspeak_(403);
					/* !ALREADY OFF. */
					return ret_val;

				case 45200:
					vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] &= ~Vars.ONBT;
					game.dsub.rspsub_(405, odo2);
				case 45300:
					if (!game.dso5.lit_(vars.play_1.here))
					{
						game.dsub.rspeak_(406);
					}
					/* !MAY BE DARK. */
					return ret_val;

				/* V125-- OPEN. A FINE MESS. */

				case 46000:
					if (game.dsub.objact_())
					{
						return ret_val;
					}
					/* !OBJ HANDLE? */
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.CONTBT) != 0)
					{
						GOTO = 46100;
						continue loop;
					}
				case 46050:
					game.dsub.rspsub_(407, odo2);
					/* !NOT OPENABLE. */
					return ret_val;

				case 46100:
					if (vars.objcts_1.ocapac[vars.prsvec_1.prso - 1] != 0)
					{
						GOTO = 46200;
						continue loop;
					}
					game.dsub.rspsub_(408, odo2);
					/* !NOT OPENABLE. */
					return ret_val;

				case 46200:
					if (!((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.OPENBT) != 0))
					{
						GOTO = 46225;
						continue loop;
					}
					game.dsub.rspeak_(412);
					/* !ALREADY OPEN. */
					return ret_val;

				case 46225:
					vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] |= Vars.OPENBT;
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.TRANBT) != 0
							|| game.dsub.qempty_(vars.prsvec_1.prso))
					{
						GOTO = 46300;
						continue loop;
					}
					game.dso1.princo_(vars.prsvec_1.prso, 410);
					/* !PRINT CONTENTS. */
					return ret_val;

				case 46300:
					game.dsub.rspeak_(409);
					/* !DONE */
					return ret_val;

				/* V126-- CLOSE. */

				case 47000:
					if (game.dsub.objact_())
					{
						return ret_val;
					}
					/* !OBJ HANDLE? */
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.CONTBT) == 0)
					{
						GOTO = 46050;
						continue loop;
					}
					if (vars.objcts_1.ocapac[vars.prsvec_1.prso - 1] != 0)
					{
						GOTO = 47100;
						continue loop;
					}
					game.dsub.rspsub_(411, odo2);
					/* !NOT CLOSABLE. */
					return ret_val;

				case 47100:
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.OPENBT) != 0)
					{
						GOTO = 47200;
						continue loop;
					}
					/* !OPEN? */
					game.dsub.rspeak_(413);
					/* !NO, JOKE. */
					return ret_val;

				case 47200:
					vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] &= ~Vars.OPENBT;
					game.dsub.rspeak_(414);
					/* !DONE. */
					return ret_val;
				/* VAPPLI, PAGE 7 */

				/* V127-- FIND. BIG MEGILLA. */

				case 48000:
					if (game.dsub.objact_())
					{
						return ret_val;
					}
					/* !OBJ HANDLE? */
					i = 415;
					/* !DEFAULT CASE. */
					if (game.dsub.qhere_(vars.prsvec_1.prso, vars.play_1.here))
					{
						GOTO = 48300;
						continue loop;
					}
					/* !IN ROOM? */
					if (vars.objcts_1.oadv[vars.prsvec_1.prso - 1] == vars.play_1.winner)
					{
						GOTO = 48200;
						continue loop;
					}
					/* !ON WINNER? */
					j = vars.objcts_1.ocan[vars.prsvec_1.prso - 1];
					/* !DOWN ONE LEVEL. */
					if (j == 0)
					{
						GOTO = 10;
						continue loop;
					}
					if ((vars.objcts_1.oflag1[j - 1] & Vars.TRANBT) == 0
							&& (!((vars.objcts_1.oflag2[j - 1] & Vars.OPENBT) != 0)
									|| (vars.objcts_1.oflag1[j - 1]
											& Vars.DOORBT + Vars.CONTBT) == 0))
					{
						GOTO = 10;
						continue loop;
					}
					i = 417;
					/* !ASSUME IN ROOM. */
					if (game.dsub.qhere_(j, vars.play_1.here))
					{
						GOTO = 48100;
						continue loop;
					}
					if (vars.objcts_1.oadv[j - 1] != vars.play_1.winner)
					{
						GOTO = 10;
						continue loop;
					}
					/* !NOT HERE OR ON PERSON. */
					i = 418;
				case 48100:
					game.dsub.rspsub_(i, vars.objcts_1.odesc2[j - 1]);
					/* !DESCRIBE FINDINGS. */
					return ret_val;

				case 48200:
					i = 416;
				case 48300:
					game.dsub.rspsub_(i, odo2);
					/* !DESCRIBE FINDINGS. */
					return ret_val;

	/* V128--	WAIT.  RUN CLOCK DEMON. */

	case 49000:
	    game.dsub.rspeak_(419);
	/* 						!TIME PASSES. */
	    for (i = 1; i <= 3; ++i) {
		if (clockd_()) {
		    return ret_val;
		}
	/* case 49100: */
	    }
	    return ret_val;

	/* V129--	SPIN. */
	/* V159--	TURN TO. */

	case 50000:
	case 88000:
	    if (! game.dsub.objact_()) {
		game.dsub.rspeak_(663);
	    }
	/* 						!IF NOT OBJ, JOKE. */
	    return ret_val;

	/* V130--	BOARD.  WORKS WITH VEHICLES. */

	case 51000:
	    if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.VEHBT) != 0) {
		GOTO = 51100;
			 continue loop;
	    }
	    game.dsub.rspsub_(421, odo2);
	/* 						!NOT VEHICLE, JOKE. */
	    return ret_val;

	case 51100:
	    if (game.dsub.qhere_(vars.prsvec_1.prso, vars.play_1.here)) {
		GOTO = 51200;
			 continue loop;
	    }
	/* 						!HERE? */
	    game.dsub.rspsub_(420, odo2);
	/* 						!NO, JOKE. */
	    return ret_val;

	case 51200:
	    if (av == 0) {
		GOTO = 51300;
			 continue loop;
	    }
	/* 						!ALREADY GOT ONE? */
	    game.dsub.rspsub_(422, odo2);
	/* 						!YES, JOKE. */
	    return ret_val;

	case 51300:
	    if (game.dsub.objact_()) {
		return ret_val;
	    }
	/* 						!OBJ HANDLE? */
	    game.dsub.rspsub_(423, odo2);
	/* 						!DESCRIBE. */
	    vars.advs_1.avehic[vars.play_1.winner - 1] = vars.prsvec_1.prso;
	    if (vars.play_1.winner != vars.aindex_1.player) {
		vars.objcts_1.ocan[vars.advs_1.aobj[vars.play_1.winner - 1] - 1] = vars.prsvec_1.prso;
	    }
	    return ret_val;

	/* V131--	DISEMBARK. */

	case 52000:
	    if (av == vars.prsvec_1.prso) {
		GOTO = 52100;
			 continue loop;
	    }
	/* 						!FROM VEHICLE? */
	    game.dsub.rspeak_(424);
	/* 						!NO, JOKE. */
	    return ret_val;

	case 52100:
	    if (game.dsub.objact_()) {
		return ret_val;
	    }
	/* 						!OBJ HANDLE? */
	    if ((vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RLAND) != 0) {
		GOTO = 52200;
			 continue loop;
	    }
	    game.dsub.rspeak_(425);
	/* 						!NOT ON LAND. */
	    return ret_val;

	case 52200:
	    vars.advs_1.avehic[vars.play_1.winner - 1] = 0;
	    game.dsub.rspeak_(426);
	    if (vars.play_1.winner != vars.aindex_1.player) {
		game.dsub.newsta_(vars.advs_1.aobj[vars.play_1.winner - 1], 0, vars.play_1.here, 0, 0);
	    }
	    return ret_val;

	/* V132--	TAKE.  HANDLED EXTERNALLY. */

	case 53000:
	    ret_val = game.verbs.dverb1.take_(true);
	    return ret_val;

	/* V133--	INVENTORY.  PROCESSED EXTERNALLY. */

	case 55000:
	    game.dso1.invent_(vars.play_1.winner);
	    return ret_val;
	/* VAPPLI, PAGE 8 */

	/* V134--	FILL.  STRANGE DOINGS WITH WATER. */

	case 56000:
	    if (vars.prsvec_1.prsi != 0) {
		GOTO = 56050;
			 continue loop;
	    }
	/* 						!ANY OBJ SPECIFIED? */
	    if ((vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RWATER + Vars.RFILL) != 
		    0) {
		GOTO = 56025;
			 continue loop;
	    }
	    game.dsub.rspeak_(516);
	/* 						!NOTHING TO FILL WITH. */
	    vars.prsvec_1.prswon = false;
	/* 						!YOU LOSE. */
	    return ret_val;

	case 56025:
	    vars.prsvec_1.prsi = vars.oindex_1.gwate;
	/* 						!USE GLOBAL WATER. */
	case 56050:
	    if (game.dsub.objact_()) {
		return ret_val;
	    }
	/* 						!OBJ HANDLE? */
	    if (vars.prsvec_1.prsi != vars.oindex_1.gwate && vars.prsvec_1.prsi != vars.oindex_1.water) {
		game.dsub.rspsb2_(444, odi2, odo2);
	    }
	    return ret_val;

	/* V135,V136--	EAT/DRINK */

	case 58000:
	case 59000:
	    if (game.dsub.objact_()) {
		return ret_val;
	    }
	/* 						!OBJ HANDLE? */
	    if (vars.prsvec_1.prso == vars.oindex_1.gwate) {
		GOTO = 59500;
			 continue loop;
	    }
	/* 						!DRINK GLOBAL WATER? */
	    if (! ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.FOODBT) != 0)) {
		GOTO = 59400;
			 continue loop;
	    }
	/* 						!EDIBLE? */
	    if (vars.objcts_1.oadv[vars.prsvec_1.prso - 1] == vars.play_1.winner) {
		GOTO = 59200;
			 continue loop;
	    }
	/* 						!YES, ON WINNER? */
	case 59100:
	    game.dsub.rspsub_(454, odo2);
	/* 						!NOT ACCESSIBLE. */
	    return ret_val;

	case 59200:
	    if (vars.prsvec_1.prsa == vars.vindex_1.drinkw) {
		GOTO = 59300;
			 continue loop;
	    }
	/* 						!DRINK FOOD? */
	    game.dsub.newsta_(vars.prsvec_1.prso, 455, 0, 0, 0);
	/* 						!NO, IT DISAPPEARS. */
	    return ret_val;

	case 59300:
	    game.dsub.rspeak_(456);
	/* 						!YES, JOKE. */
	    return ret_val;

	case 59400:
	    if (! ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.DRNKBT) != 0)) {
		GOTO = 59600;
			 continue loop;
	    }
	/* 						!DRINKABLE? */
	    if (vars.objcts_1.ocan[vars.prsvec_1.prso - 1] == 0) {
		GOTO = 59100;
			 continue loop;
	    }
	/* 						!YES, IN SOMETHING? */
	    if (vars.objcts_1.oadv[vars.objcts_1.ocan[vars.prsvec_1.prso - 1] - 1] != vars.play_1.winner) 
		    {
		GOTO = 59100;
			 continue loop;
	    }
	    if ((vars.objcts_1.oflag2[vars.objcts_1.ocan[vars.prsvec_1.prso - 1] - 1] & 
		    Vars.OPENBT) != 0) {
		GOTO = 59500;
			 continue loop;
	    }
	/* 						!CONT OPEN? */
	    game.dsub.rspeak_(457);
	/* 						!NO, JOKE. */
	    return ret_val;

	case 59500:
	    game.dsub.newsta_(vars.prsvec_1.prso, 458, 0, 0, 0);
	/* 						!GONE. */
	    return ret_val;

	case 59600:
	    game.dsub.rspsub_(453, odo2);
	/* 						!NOT FOOD OR DRINK. */
	    return ret_val;

	/* V137--	BURN.  COMPLICATED. */

	case 60000:
	    if ((vars.objcts_1.oflag1[vars.prsvec_1.prsi - 1] & Vars.FLAMBT + 
		    Vars.LITEBT + Vars.ONBT) != Vars.FLAMBT + 
		    Vars.LITEBT + Vars.ONBT) {
		GOTO = 60400;
			 continue loop;
	    }
	    if (game.dsub.objact_()) {
		return ret_val;
	    }
	/* 						!OBJ HANDLE? */
	    if (vars.objcts_1.ocan[vars.prsvec_1.prso - 1] != vars.oindex_1.recep) {
		GOTO = 60050;
			 continue loop;
	    }
	/* 						!BALLOON? */
	    if (game.objcts.oappli_(vars.objcts_1.oactio[vars.oindex_1.ballo - 1], 0)) {
		return ret_val;
	    }
	/* 						!DID IT HANDLE? */
	case 60050:
	    if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.BURNBT) == 0) {
		GOTO = 60300;
			 continue loop;
	    }
	    if (vars.objcts_1.oadv[vars.prsvec_1.prso - 1] != vars.play_1.winner) {
		GOTO = 60100;
			 continue loop;
	    }
	/* 						!CARRYING IT? */
	    game.dsub.rspsub_(459, odo2);
	    game.dsub.jigsup_(460);
	    return ret_val;

	case 60100:
	    j = vars.objcts_1.ocan[vars.prsvec_1.prso - 1];
	/* 						!GET CONTAINER. */
	    if (game.dsub.qhere_(vars.prsvec_1.prso, vars.play_1.here) || av != 0 && j == av) {
		GOTO = 60200;
			 continue loop;
	    }
	    if (j == 0) {
		GOTO = 60150;
			 continue loop;
	    }
	/* 						!INSIDE? */
	    if (! ((vars.objcts_1.oflag2[j - 1] & Vars.OPENBT) != 0)) {
		GOTO = 60150;
			 continue loop;
	    }
	/* 						!OPEN? */
	    if (game.dsub.qhere_(j, vars.play_1.here) || av != 0 && vars.objcts_1.ocan[j - 1] == av) {
		GOTO = 60200;
			 continue loop;
	    }
	case 60150:
	    game.dsub.rspeak_(461);
	/* 						!CANT REACH IT. */
	    return ret_val;

	case 60200:
	    game.dsub.rspsub_(462, odo2);
	/* 						!BURN IT. */
	    game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, 0);
	    return ret_val;

	case 60300:
	    game.dsub.rspsub_(463, odo2);
	/* 						!CANT BURN IT. */
	    return ret_val;

	case 60400:
	    game.dsub.rspsub_(301, odi2);
	/* 						!CANT BURN IT WITH THAT. */
	    return ret_val;
	/* VAPPLI, PAGE 9 */

	/* V138--	MUNG.  GO TO COMMON ATTACK CODE. */

	case 63000:
	    i = 466;
	/* 						!CHOOSE PHRASE. */
	    if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.VILLBT) != 0) {
		GOTO = 66100;
			 continue loop;
	    }
	    if (! game.dsub.objact_()) {
		game.dsub.rspsb2_(466, odo2, rmk);
	    }
	    return ret_val;

	/* V139--	KILL.  GO TO COMMON ATTACK CODE. */

	case 64000:
	    i = 467;
	/* 						!CHOOSE PHRASE. */
	    GOTO = 66100;
			 continue loop;

	/* V140--	SWING.  INVERT OBJECTS, FALL THRU TO ATTACK. */

	case 65000:
	    j = vars.prsvec_1.prso;
	/* 						!INVERT. */
	    vars.prsvec_1.prso = vars.prsvec_1.prsi;
	    vars.prsvec_1.prsi = j;
	    j = odo2;
	    odo2 = odi2;
	    odi2 = j;
	    vars.prsvec_1.prsa = vars.vindex_1.attacw;
	/* 						!FOR OBJACT. */

	/* V141--	ATTACK.  FALL THRU TO ATTACK CODE. */

	case 66000:
	    i = 468;

	/* COMMON MUNG/ATTACK/SWING/KILL CODE. */

	case 66100:
	    if (vars.prsvec_1.prso != 0) {
		GOTO = 66200;
			 continue loop;
	    }
	/* 						!ANYTHING? */
	    game.dsub.rspeak_(469);
	/* 						!NO, JOKE. */
	    return ret_val;

	case 66200:
	    if (game.dsub.objact_()) {
		return ret_val;
	    }
	/* 						!OBJ HANDLE? */
	    if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.VILLBT) != 0) {
		GOTO = 66300;
			 continue loop;
	    }
	    if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.VICTBT) == 0) {
		game.dsub.rspsub_(470, odo2);
	    }
	    return ret_val;

	case 66300:
	    j = 471;
	/* 						!ASSUME NO WEAPON. */
	    if (vars.prsvec_1.prsi == 0) {
		GOTO = 66500;
			 continue loop;
	    }
	    if ((vars.objcts_1.oflag2[vars.prsvec_1.prsi - 1] & Vars.WEAPBT) == 0) {
		GOTO = 66400;
			 continue loop;
	    }
	    melee = 1;
	/* 						!ASSUME SWORD. */
	    if (vars.prsvec_1.prsi != vars.oindex_1.sword) {
		melee = 2;
	    }
	/* 						!MUST BE KNIFE. */
	    i = game.demons.blow_(vars.aindex_1.player, vars.prsvec_1.prso, melee, 1, 0);
	/* 						!STRIKE BLOW. */
	    return ret_val;

	case 66400:
	    j = 472;
	/* 						!NOT A WEAPON. */
	case 66500:
	    game.dsub.rspsb2_(i, odo2, j);
	/* 						!JOKE. */
	    return ret_val;
	/* VAPPLI, PAGE 10 */

	/* V142--	WALK.  PROCESSED EXTERNALLY. */

	case 68000:
	    ret_val = dverb2.walk_();
	    return ret_val;

	/* V143--	TELL.  PROCESSED IN GAME. */

	case 69000:
	    game.dsub.rspeak_(603);
	    return ret_val;

	/* V144--	PUT.  PROCESSED EXTERNALLY. */

	case 70000:
	    ret_val = dverb1.put_(true);
	    return ret_val;

	/* V145,V146,V147,V148--	DROP/GIVE/POUR/THROW */

	case 71000:
	case 72000:
	case 73000:
	case 74000:
	    ret_val = dverb1.drop_(false);
	    return ret_val;

	/* V149--	SAVE */

	case 77000:
	    if ((vars.rooms_1.rflag[vars.rindex_1.tstrs - 1] & Vars.RSEEN) == 0) {
		GOTO = 77100;
			 continue loop;
	    }
	    game.dsub.rspeak_(828);
	/* 						!NO SAVES IN ENDGAME. */
	    return ret_val;

	case 77100:
	    dverb2.savegm_();
	    return ret_val;

	/* V150--	RESTORE */

	case 78000:
	    if ((vars.rooms_1.rflag[vars.rindex_1.tstrs - 1] & Vars.RSEEN) == 0) {
		GOTO = 78100;
			 continue loop;
	    }
	    game.dsub.rspeak_(829);
	/* 						!NO RESTORES IN ENDGAME. */
	    return ret_val;

	case 78100:
	    dverb2.rstrgm_();
	    return ret_val;
	/* VAPPLI, PAGE 11 */

	/* V151--	HELLO */

	case 80000:
	    if (vars.prsvec_1.prso != 0) {
		GOTO = 80100;
			 continue loop;
	    }
	/* 						!ANY OBJ? */
	    i__1 = Supp.rnd_(4) + 346;
	    game.dsub.rspeak_(i__1);
	/* 						!NO, VANILLA HELLO. */
	    return ret_val;

	case 80100:
	    if (vars.prsvec_1.prso != vars.oindex_1.aviat) {
		GOTO = 80200;
			 continue loop;
	    }
	/* 						!HELLO AVIATOR? */
	    game.dsub.rspeak_(350);
	/* 						!NOTHING HAPPENS. */
	    return ret_val;

	case 80200:
	    if (vars.prsvec_1.prso != vars.oindex_1.sailo) {
		GOTO = 80300;
			 continue loop;
	    }
	/* 						!HELLO SAILOR? */
	    ++vars.state_1.hs;
	/* 						!COUNT. */
	    i = 351;
	/* 						!GIVE NORMAL OR */
	    if (vars.state_1.hs % 10 == 0) {
		i = 352;
	    }
	/* 						!RANDOM MESSAGE. */
	    if (vars.state_1.hs % 20 == 0) {
		i = 353;
	    }
	    game.dsub.rspeak_(i);
	/* 						!SPEAK UP. */
	    return ret_val;

	case 80300:
	    if (game.dsub.objact_()) {
		return ret_val;
	    }
	/* 						!OBJ HANDLE? */
	    i = 354;
	/* 						!ASSUME VILLAIN. */
	    if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.VILLBT + 
		    Vars.ACTRBT) == 0) {
		i = 355;
	    }
	    game.dsub.rspsub_(i, odo2);
	/* 						!HELLO THERE */
	/* 						! */
	    return ret_val;

	/* V152--	LOOK INTO */

	case 81000:
	    if (game.dsub.objact_()) {
		return ret_val;
	    }
	/* 						!OBJ HANDLE? */
	    if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.DOORBT) == 0) {
		GOTO = 81300;
			 continue loop;
	    }
	    if (! ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.OPENBT) != 0)) {
		GOTO = 81200;
			 continue loop;
	    }
	/* 						!OPEN? */
	    game.dsub.rspsub_(628, odo2);
	/* 						!OPEN DOOR- UNINTERESTING. */
	    return ret_val;

	case 81200:
	    game.dsub.rspsub_(525, odo2);
	/* 						!CLOSED DOOR- CANT SEE. */
	    return ret_val;

	case 81300:
	    if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.VEHBT) != 0) {
		GOTO = 81400;
			 continue loop;
	    }
	    if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.OPENBT) != 0 || (
		    vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.TRANBT) != 0) {
		GOTO = 81400;
			 continue loop;
	    }
	    if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.CONTBT) != 0) {
		GOTO = 81200;
			 continue loop;
	    }
	    game.dsub.rspsub_(630, odo2);
	/* 						!CANT LOOK INSIDE. */
	    return ret_val;

	case 81400:
	    if (game.dsub.qempty_(vars.prsvec_1.prso)) {
		GOTO = 81500;
			 continue loop;
	    }
	/* 						!VEH OR SEE IN.  EMPTY? */
	    game.dso1.princo_(vars.prsvec_1.prso, 573);
	/* 						!NO, LIST CONTENTS. */
	    return ret_val;

	case 81500:
	    game.dsub.rspsub_(629, odo2);
	/* 						!EMPTY. */
	    return ret_val;

	/* V153--	LOOK UNDER */

	case 82000:
	    if (! game.dsub.objact_()) {
		game.dsub.rspeak_(631);
	    }
	/* 						!OBJECT HANDLE? */
	    return ret_val;
	/* VAPPLI, PAGE 12 */

	/* V154--	PUMP */

	case 83000:
	    if (vars.objcts_1.oroom[vars.oindex_1.pump - 1] == vars.play_1.here || vars.objcts_1.oadv[
		    vars.oindex_1.pump - 1] == vars.play_1.winner) {
		GOTO = 83100;
			 continue loop;
	    }
	    game.dsub.rspeak_(632);
	/* 						!NO. */
	    return ret_val;

	case 83100:
	    vars.prsvec_1.prsi = vars.oindex_1.pump;
	/* 						!BECOMES INFLATE */
	    vars.prsvec_1.prsa = vars.vindex_1.inflaw;
	/* 						!X WITH PUMP. */
	    GOTO = 22000;
			 continue loop;
	/* 						!DONE. */

	/* V155--	WIND */

	case 84000:
	    if (! game.dsub.objact_()) {
		game.dsub.rspsub_(634, odo2);
	    }
	/* 						!OBJ HANDLE? */
	    return ret_val;

	/* V156--	CLIMB */
	/* V157--	CLIMB UP */
	/* V158--	CLIMB DOWN */

	case 85000:
	case 86000:
	case 87000:
	    i = vars.xsrch_1.xup;
	/* 						!ASSUME UP. */
	    if (vars.prsvec_1.prsa == vars.vindex_1.clmbdw) {
		i = vars.xsrch_1.xdown;
	    }
	/* 						!UNLESS CLIMB DN. */
	    f = (vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.CLMBBT) != 0;
	    if (f && game.dso3.findxt_(i, vars.play_1.here)) {
		GOTO = 87500;
			 continue loop;
	    }
	/* 						!ANYTHING TO CLIMB? */
	    if (game.dsub.objact_()) {
		return ret_val;
	    }
	/* 						!OBJ HANDLE? */
	    i = 657;
	    if (f) {
		i = 524;
	    }
	/* 						!VARIETY OF JOKES. */
	    if (! f && (vars.prsvec_1.prso == vars.oindex_1.wall || vars.prsvec_1.prso >= 
		    vars.oindex_1.wnort && vars.prsvec_1.prso <= vars.oindex_1.wnort + 3)) {
		i = 656;
	    }
	    game.dsub.rspeak_(i);
	/* 						!JOKE. */
	    return ret_val;

	case 87500:
	    vars.prsvec_1.prsa = vars.vindex_1.walkw;
	/* 						!WALK */
	    vars.prsvec_1.prso = i;
	/* 						!IN SPECIFIED DIR. */
	    ret_val = dverb2.walk_();
	    return ret_val;
//		throw new RuntimeException("implement vappli_");
	    	}
	    }while(true);
	} /* vappli_ */
//
//	/* CLOCKD- CLOCK DEMON FOR INTERMOVE CLOCK EVENTS */
//
//	/* DECLARATIONS */

	boolean clockd_()
	{
	    /* System generated locals */
	    int i__1;
	    boolean ret_val;

	    /* Local variables */
	    int i;

	    ret_val = false;
	    /* 						!ASSUME NO ACTION. */
	    i__1 = vars.cevent_1.clnt;
	    for (i = 1; i <= i__1; ++i) 
	    {	    	
	    	if (! vars.cevent_1.cflag[i - 1] || vars.cevent_1.ctick[i - 1] == 0) 
	    	{
	    		continue;
	    	}
	    	if (vars.cevent_1.ctick[i - 1] < 0) 
	    	{
	    		ret_val = true;
	    		game.clockr.cevapp_(vars.cevent_1.cactio[i - 1]);
	    		continue;
	    	}
	    	/* 						!PERMANENT ENTRY? */
	    	--vars.cevent_1.ctick[i - 1];
	    	if (vars.cevent_1.ctick[i - 1] != 0) 
	    	{
	    		ret_val = true;
	    		game.clockr.cevapp_(vars.cevent_1.cactio[i - 1]);
	    		continue;	    		
	    	}	
	    }
	    return ret_val;	    

	} /* clockd_ */

}
