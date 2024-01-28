package zork;

import java.io.IOException;

public class Objcts
{
	/* OAPPLI- OBJECT SPECIAL ACTION ROUTINES */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Objcts(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean oappli_(int ri, int arg) throws IOException
	{
		/* Initialized data */
		int GOTO = 10;
		final int mxsmp = 99;

		/* System generated locals */
		int i__1;
		boolean ret_val = false;

		/* Local variables */
		int flobts = 0, i;
		int j, av = 0, io = 0, ir = 0, iz = 0;
		int odi2 = 0, odo2 = 0;
		int nloc = 0;

		if (ri != 0)
		{

			/* !ZERO IS FALSE APP. */
			if (ri <= mxsmp)
			{
				GOTO = 100;
			}

			if (GOTO != 100)
			{
				/* !SIMPLE OBJECT? */
				if (vars.prsvec_1.prso <= 220)
				{
					if (vars.prsvec_1.prso != 0)
					{
						odo2 = vars.objcts_1.odesc2[vars.prsvec_1.prso - 1];
					}
				}
				if (vars.prsvec_1.prsi != 0)
				{
					odi2 = vars.objcts_1.odesc2[vars.prsvec_1.prsi - 1];
				}
				av = vars.advs_1.avehic[vars.play_1.winner - 1];
				flobts = Vars.FLAMBT + Vars.LITEBT + Vars.ONBT;
				ret_val = true;

				switch (ri - mxsmp)
				{
					case 1:
						GOTO = 2000;
						break;
					case 2:
						GOTO = 5000;
						break;
					case 3:
						GOTO = 10000;
						break;
					case 4:
						GOTO = 11000;
						break;
					case 5:
						GOTO = 12000;
						break;
					case 6:
						GOTO = 15000;
						break;
					case 7:
						GOTO = 18000;
						break;
					case 8:
						GOTO = 19000;
						break;
					case 9:
						GOTO = 20000;
						break;
					case 10:
						GOTO = 22000;
						break;
					case 11:
						GOTO = 25000;
						break;
					case 12:
						GOTO = 26000;
						break;
					case 13:
						GOTO = 32000;
						break;
					case 14:
						GOTO = 35000;
						break;
					case 15:
						GOTO = 39000;
						break;
					case 16:
						GOTO = 40000;
						break;
					case 17:
						GOTO = 45000;
						break;
					case 18:
						GOTO = 47000;
						break;
					case 19:
						GOTO = 48000;
						break;
					case 20:
						GOTO = 49000;
						break;
					case 21:
						GOTO = 50000;
						break;
					case 22:
						GOTO = 51000;
						break;
					case 23:
						GOTO = 52000;
						break;
					case 24:
						GOTO = 54000;
						break;
					case 25:
						GOTO = 55000;
						break;
					case 26:
						GOTO = 56000;
						break;
					case 27:
						GOTO = 57000;
						break;
					case 28:
						GOTO = 58000;
						break;
					case 29:
						GOTO = 59000;
						break;
					case 30:
						GOTO = 60000;
						break;
					case 31:
						GOTO = 61000;
						break;
					case 32:
						GOTO = 62000;
						break;
					default:
						game.dsub.bug_(6, ri);
				}
			}
		}

		loop: do
		{
			switch (GOTO)
			{

				/* RETURN HERE TO DECLARE FALSE RESULT */

				case 10:
					ret_val = false;
					return ret_val;

				/* SIMPLE OBJECTS, PROCESSED EXTERNALLY. */

				case 100:
					if (ri < 32)
					{
						ret_val = game.sobjs.sobjs_(ri, arg);
					}
					else
					{
						ret_val = game.nobjs.nobjs_(ri, arg);
					}
					return ret_val;
				/* OAPPLI, PAGE 3 */

				/* O100-- MACHINE FUNCTION */

				case 2000:
					if (vars.play_1.here != vars.rindex_1.mmach)
					{
						GOTO = 10;
						continue;
					}
					/* !NOT HERE? F */
					ret_val = game.dso5.opncls_(vars.oindex_1.machi, 123, 124);
					/* !HANDLE OPN/CLS. */
					return ret_val;

				/* O101-- WATER FUNCTION */

				case 5000:
					if (vars.prsvec_1.prsa != vars.vindex_1.fillw)
					{
						GOTO = 5050;
						continue;
					}
					/* !FILL X WITH Y IS */
					vars.prsvec_1.prsa = vars.vindex_1.putw;
					/* !MADE INTO */
					i = vars.prsvec_1.prsi;
					vars.prsvec_1.prsi = vars.prsvec_1.prso;
					vars.prsvec_1.prso = i;
					/* !PUT Y IN X. */
					i = odi2;
					odi2 = odo2;
					odo2 = i;
				case 5050:
					if (vars.prsvec_1.prso == vars.oindex_1.water
							|| vars.prsvec_1.prso == vars.oindex_1.gwate)
					{
						GOTO = 5100;
						continue;
					}
					game.dsub.rspeak_(561);
					/* !WATER IS IND OBJ, */
					return ret_val;
				/* !PUNT. */

				case 5100:
					if (vars.prsvec_1.prsa != vars.vindex_1.takew)
					{
						GOTO = 5400;
						continue;
					}
					/* !TAKE WATER? */
					if (vars.objcts_1.oadv[vars.oindex_1.bottl - 1] == vars.play_1.winner
							&& vars.objcts_1.ocan[vars.prsvec_1.prso - 1] != vars.oindex_1.bottl)
					{
						GOTO = 5500;
						continue;
					}
					if (vars.objcts_1.ocan[vars.prsvec_1.prso - 1] == 0)
					{
						GOTO = 5200;
						continue;
					}
					/* !INSIDE ANYTHING? */
					if ((vars.objcts_1.oflag2[vars.objcts_1.ocan[vars.prsvec_1.prso - 1] - 1]
							& Vars.OPENBT) != 0)
					{
						GOTO = 5200;
						continue;
					}
					/* !YES, OPEN? */
					game.dsub.rspsub_(525,
							vars.objcts_1.odesc2[vars.objcts_1.ocan[vars.prsvec_1.prso - 1] - 1]);
					/* !INSIDE, CLOSED, PUNT. */
					return ret_val;

				case 5200:
					game.dsub.rspeak_(615);
					/* !NOT INSIDE OR OPEN, */
					return ret_val;
				/* !SLIPS THRU FINGERS. */

				case 5400:
					if (vars.prsvec_1.prsa != vars.vindex_1.putw)
					{
						GOTO = 5700;
						continue;
					}
					/* !PUT WATER IN X? */
					if (av != 0 && vars.prsvec_1.prsi == av)
					{
						GOTO = 5800;
						continue;
					}
					/* !IN VEH? */
					if (vars.prsvec_1.prsi == vars.oindex_1.bottl)
					{
						GOTO = 5500;
						continue;
					}
					/* !IN BOTTLE? */
					game.dsub.rspsub_(297, odi2);
					/* !WONT GO ELSEWHERE. */
					game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, 0);
					/* !VANISH WATER. */
					return ret_val;

				case 5500:
					if ((vars.objcts_1.oflag2[vars.oindex_1.bottl - 1] & Vars.OPENBT) != 0)
					{
						GOTO = 5550;
						continue;
					}
					/* !BOTTLE OPEN? */
					game.dsub.rspeak_(612);
					/* !NO, LOSE. */
					return ret_val;

				case 5550:
					if (game.dsub.qempty_(vars.oindex_1.bottl))
					{
						GOTO = 5600;
						continue;
					}
					/* !OPEN, EMPTY? */
					game.dsub.rspeak_(613);
					/* !NO, ALREADY FULL. */
					return ret_val;

				case 5600:
					game.dsub.newsta_(vars.oindex_1.water, 614, 0, vars.oindex_1.bottl, 0);
					/* !TAKE WATER TO BOTTLE. */
					return ret_val;

				case 5700:
					if (vars.prsvec_1.prsa != vars.vindex_1.dropw
							&& vars.prsvec_1.prsa != vars.vindex_1.pourw
							&& vars.prsvec_1.prsa != vars.vindex_1.givew)
					{
						GOTO = 5900;
						continue;
					}
					if (av != 0)
					{
						GOTO = 5800;
						continue;
					}
					/* !INTO VEHICLE? */
					game.dsub.newsta_(vars.prsvec_1.prso, 133, 0, 0, 0);
					/* !NO, VANISHES. */
					return ret_val;

				case 5800:
					game.dsub.newsta_(vars.oindex_1.water, 0, 0, av, 0);
					/* !WATER INTO VEHICLE. */
					game.dsub.rspsub_(296, vars.objcts_1.odesc2[av - 1]);
					/* !DESCRIBE. */
					return ret_val;

				case 5900:
					if (vars.prsvec_1.prsa != vars.vindex_1.throww)
					{
						GOTO = 10;
						continue;
					}
					/* !LAST CHANCE, THROW? */
					game.dsub.newsta_(vars.prsvec_1.prso, 132, 0, 0, 0);
					/* !VANISHES. */
					return ret_val;
				/* OAPPLI, PAGE 4 */

				/* O102-- LEAF PILE */

				case 10000:
					if (vars.prsvec_1.prsa != vars.vindex_1.burnw)
					{
						GOTO = 10500;
						continue;
					}
					/* !BURN? */
					if (vars.objcts_1.oroom[vars.prsvec_1.prso - 1] == 0)
					{
						GOTO = 10100;
						continue;
					}
					/* !WAS HE CARRYING? */
					game.dsub.newsta_(vars.prsvec_1.prso, 158, 0, 0, 0);
					/* !NO, BURN IT. */
					return ret_val;

				case 10100:
					game.dsub.newsta_(vars.prsvec_1.prso, 0, vars.play_1.here, 0, 0);
					/* !DROP LEAVES. */
					game.dsub.jigsup_(159);
					/* !BURN HIM. */
					return ret_val;

				case 10500:
					if (vars.prsvec_1.prsa != vars.vindex_1.movew)
					{
						GOTO = 10600;
						continue;
					}
					/* !MOVE? */
					game.dsub.rspeak_(2);
					/* !DONE. */
					return ret_val;

				case 10600:
					if (vars.prsvec_1.prsa != vars.vindex_1.lookuw || vars.findex_1.rvclr != 0)
					{
						GOTO = 10;
						continue;
					}
					game.dsub.rspeak_(344);
					/* !LOOK UNDER? */
					return ret_val;

				/* O103-- TROLL, DONE EXTERNALLY. */

				case 11000:
					ret_val = game.villns.trollp_(arg);
					/* !TROLL PROCESSOR. */
					return ret_val;

				/* O104-- RUSTY KNIFE. */

				case 12000:
					if (vars.prsvec_1.prsa != vars.vindex_1.takew)
					{
						GOTO = 12100;
						continue;
					}
					/* !TAKE? */
					if (vars.objcts_1.oadv[vars.oindex_1.sword - 1] == vars.play_1.winner)
					{
						game.dsub.rspeak_(160);
					}
					/* !PULSE SWORD. */
					GOTO = 10;
					continue;

				case 12100:
					if (((vars.prsvec_1.prsa != vars.vindex_1.attacw
							&& vars.prsvec_1.prsa != vars.vindex_1.killw)
							|| vars.prsvec_1.prsi != vars.oindex_1.rknif)
							&& ((vars.prsvec_1.prsa != vars.vindex_1.swingw
									&& vars.prsvec_1.prsa != vars.vindex_1.throww)
									|| vars.prsvec_1.prso != vars.oindex_1.rknif))
					{
						GOTO = 10;
						continue;
					}
					game.dsub.newsta_(vars.oindex_1.rknif, 0, 0, 0, 0);
					/* !KILL KNIFE. */
					game.dsub.jigsup_(161);
					/* !KILL HIM. */
					return ret_val;
				/* OAPPLI, PAGE 5 */

				/* O105-- GLACIER */

				case 15000:
					if (vars.prsvec_1.prsa != vars.vindex_1.throww)
					{
						GOTO = 15500;
						continue;
					}
					/* !THROW? */
					if (vars.prsvec_1.prso != vars.oindex_1.torch)
					{
						GOTO = 15400;
						continue;
					}
					/* !TORCH? */
					game.dsub.newsta_(vars.oindex_1.ice, 169, 0, 0, 0);
					/* !MELT ICE. */
					vars.objcts_1.odesc1[vars.oindex_1.torch - 1] = 174;
					/* !MUNG TORCH. */
					vars.objcts_1.odesc2[vars.oindex_1.torch - 1] = 173;
					vars.objcts_1.oflag1[vars.oindex_1.torch - 1] &= ~flobts;
					game.dsub.newsta_(vars.oindex_1.torch, 0, vars.rindex_1.strea, 0, 0);
					/* !MOVE TORCH. */
					vars.findex_1.glacrf = true;
					/* !GLACIER GONE. */
					if (!game.dso5.lit_(vars.play_1.here))
					{
						game.dsub.rspeak_(170);
					}
					/* !IN DARK? */
					return ret_val;

				case 15400:
					game.dsub.rspeak_(171);
					/* !JOKE IF NOT TORCH. */
					return ret_val;

				case 15500:
					if (vars.prsvec_1.prsa != vars.vindex_1.meltw
							|| vars.prsvec_1.prso != vars.oindex_1.ice)
					{
						GOTO = 10;
						continue;
					}
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prsi - 1] & flobts) == flobts)
					{
						GOTO = 15600;
						continue;
					}
					game.dsub.rspsub_(298, odi2);
					/* !CANT MELT WITH THAT. */
					return ret_val;

				case 15600:
					vars.findex_1.glacmf = true;
					/* !PARTIAL MELT. */
					if (vars.prsvec_1.prsi != vars.oindex_1.torch)
					{
						GOTO = 15700;
						continue;
					}
					/* !MELT WITH TORCH? */
					vars.objcts_1.odesc1[vars.oindex_1.torch - 1] = 174;
					/* !MUNG TORCH. */
					vars.objcts_1.odesc2[vars.oindex_1.torch - 1] = 173;
					vars.objcts_1.oflag1[vars.oindex_1.torch - 1] &= ~flobts;
				case 15700:
					game.dsub.jigsup_(172);
					/* !DROWN. */
					return ret_val;

				/* O106-- BLACK BOOK */

				case 18000:
					if (vars.prsvec_1.prsa != vars.vindex_1.openw)
					{
						GOTO = 18100;
						continue;
					}
					/* !OPEN? */
					game.dsub.rspeak_(180);
					/* !JOKE. */
					return ret_val;

				case 18100:
					if (vars.prsvec_1.prsa != vars.vindex_1.closew)
					{
						GOTO = 18200;
						continue;
					}
					/* !CLOSE? */
					game.dsub.rspeak_(181);
					return ret_val;

				case 18200:
					if (vars.prsvec_1.prsa != vars.vindex_1.burnw)
					{
						GOTO = 10;
						continue;
					}
					/* !BURN? */
					game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, 0);
					/* !FATAL JOKE. */
					game.dsub.jigsup_(182);
					return ret_val;
				/* OAPPLI, PAGE 6 */

				/* O107-- CANDLES, PROCESSED EXTERNALLY */

				case 19000:
					ret_val = game.lightp.lightp_(vars.oindex_1.candl);
					return ret_val;

				/* O108-- MATCHES, PROCESSED EXTERNALLY */

				case 20000:
					ret_val = game.lightp.lightp_(vars.oindex_1.match);
					return ret_val;

				/* O109-- CYCLOPS, PROCESSED EXTERNALLY. */

				case 22000:
					ret_val = game.villns.cyclop_(arg);
					/* !CYCLOPS */
					return ret_val;

				/* O110-- THIEF, PROCESSED EXTERNALLY */

				case 25000:
					ret_val = game.villns.thiefp_(arg);
					return ret_val;

				/* O111-- WINDOW */

				case 26000:
					ret_val = game.dso5.opncls_(vars.oindex_1.windo, 208, 209);
					/* !OPEN/CLS WINDOW. */
					return ret_val;

				/* O112-- PILE OF BODIES */

				case 32000:
					if (vars.prsvec_1.prsa != vars.vindex_1.takew)
					{
						GOTO = 32500;
						continue;
					}
					/* !TAKE? */
					game.dsub.rspeak_(228);
					/* !CANT. */
					return ret_val;

				case 32500:
					if (vars.prsvec_1.prsa != vars.vindex_1.burnw
							&& vars.prsvec_1.prsa != vars.vindex_1.mungw)
					{
						GOTO = 10;
						continue;
					}
					if (vars.findex_1.onpolf)
					{
						return ret_val;
					}
					/* !BURN OR MUNG? */
					vars.findex_1.onpolf = true;
					/* !SET HEAD ON POLE. */
					game.dsub.newsta_(vars.oindex_1.hpole, 0, vars.rindex_1.lld2, 0, 0);
					game.dsub.jigsup_(229);
					/* !BEHEADED. */
					return ret_val;

				/* O113-- VAMPIRE BAT */

				case 35000:
					game.dsub.rspeak_(50);
					/* !TIME TO FLY, JACK. */
					game.dso2.moveto_(vars.bats_1.batdrp[Supp.rnd_(9)], vars.play_1.winner);
					/* !SELECT RANDOM DEST. */
					game.dsub.rmdesc_(0);
					return ret_val;
				/* OAPPLI, PAGE 7 */

				/* O114-- STICK */

				case 39000:
					if (vars.prsvec_1.prsa != vars.vindex_1.wavew)
					{
						GOTO = 10;
						continue;
					}
					/* !WAVE? */
					if (vars.play_1.here == vars.rindex_1.mrain)
					{
						GOTO = 39500;
						continue;
					}
					/* !ON RAINBOW? */
					if (vars.play_1.here == vars.rindex_1.pog
							|| vars.play_1.here == vars.rindex_1.falls)
					{
						GOTO = 39200;
						continue;
					}
					game.dsub.rspeak_(244);
					/* !NOTHING HAPPENS. */
					return ret_val;

				case 39200:
					vars.objcts_1.oflag1[vars.oindex_1.pot - 1] |= Vars.VISIBT;
					vars.findex_1.rainbf = !vars.findex_1.rainbf;
					/* !COMPLEMENT RAINBOW. */
					i = 245;
					/* !ASSUME OFF. */
					if (vars.findex_1.rainbf)
					{
						i = 246;
					}
					/* !IF ON, SOLID. */
					game.dsub.rspeak_(i);
					/* !DESCRIBE. */
					return ret_val;

				case 39500:
					vars.findex_1.rainbf = false;
					/* !ON RAINBOW, */
					game.dsub.jigsup_(247);
					/* !TAKE A FALL. */
					return ret_val;

				/* O115-- BALLOON, HANDLED EXTERNALLY */

				case 40000:
					ret_val = game.ballop.ballop_(arg);
					return ret_val;

				/* O116-- HEADS */

				case 45000:
					if (vars.prsvec_1.prsa != vars.vindex_1.hellow)
					{
						GOTO = 45100;
						continue;
					}
					/* !HELLO HEADS? */
					game.dsub.rspeak_(633);
					/* !TRULY BIZARRE. */
					return ret_val;

				case 45100:
					if (vars.prsvec_1.prsa == vars.vindex_1.readw)
					{
						GOTO = 10;
						continue;
					}
					/* !READ IS OK. */
					game.dsub.newsta_(vars.oindex_1.lcase, 260, vars.rindex_1.lroom, 0, 0);
					/* !MAKE LARGE CASE. */
					i = game.dso4.robadv_(vars.play_1.winner, 0, vars.oindex_1.lcase, 0)
							+ game.dso4.robrm_(vars.play_1.here, 100, 0, vars.oindex_1.lcase, 0);
					game.dsub.jigsup_(261);
					/* !KILL HIM. */
					return ret_val;
				/* OAPPLI, PAGE 8 */

				/* O117-- SPHERE */

				case 47000:
					if (vars.findex_1.cagesf || vars.prsvec_1.prsa != vars.vindex_1.takew)
					{
						GOTO = 10;
						continue;
					}
					/* !TAKE? */
					if (vars.play_1.winner != vars.aindex_1.player)
					{
						GOTO = 47500;
						continue;
					}
					/* !ROBOT TAKE? */
					game.dsub.rspeak_(263);
					/* !NO, DROP CAGE. */
					if (vars.objcts_1.oroom[vars.oindex_1.robot - 1] != vars.play_1.here)
					{
						GOTO = 47200;
						continue;
					}
					/* !ROBOT HERE? */
					game.dso2.moveto_(vars.rindex_1.caged, vars.play_1.winner);
					/* !YES, MOVE INTO CAGE. */
					game.dsub.newsta_(vars.oindex_1.robot, 0, vars.rindex_1.caged, 0, 0);
					/* !MOVE ROBOT. */
					vars.advs_1.aroom[vars.aindex_1.arobot - 1] = vars.rindex_1.caged;
					vars.objcts_1.oflag1[vars.oindex_1.robot - 1] |= Vars.NDSCBT;
					vars.cevent_1.ctick[vars.cindex_1.cevsph - 1] = 10;
					/* !GET OUT IN 10 OR ELSE. */
					return ret_val;

				case 47200:
					game.dsub.newsta_(vars.oindex_1.spher, 0, 0, 0, 0);
					/* !YOURE DEAD. */
					vars.rooms_1.rflag[vars.rindex_1.cager - 1] |= Vars.RMUNG;
					vars.rooms_1.rrand(vars.rindex_1.cager - 1, 147);
					game.dsub.jigsup_(148);
					/* !MUNG PLAYER. */
					return ret_val;

				case 47500:
					game.dsub.newsta_(vars.oindex_1.spher, 0, 0, 0, 0);
					/* !ROBOT TRIED, */
					game.dsub.newsta_(vars.oindex_1.robot, 264, 0, 0, 0);
					/* !KILL HIM. */
					game.dsub.newsta_(vars.oindex_1.cage, 0, vars.play_1.here, 0, 0);
					/* !INSERT MANGLED CAGE. */
					return ret_val;

				/* O118-- GEOMETRICAL BUTTONS */

				case 48000:
					if (vars.prsvec_1.prsa != vars.vindex_1.pushw)
					{
						GOTO = 10;
						continue;
					}
					/* !PUSH? */
					i = vars.prsvec_1.prso - vars.oindex_1.sqbut + 1;
					/* !GET BUTTON INDEX. */
					if (i <= 0 || i >= 4)
					{
						GOTO = 10;
						continue;
					}
					/* !A BUTTON? */
					if (vars.play_1.winner != vars.aindex_1.player)
					{
						switch (i)
						{
							case 1:
								GOTO = 48100;
								continue;
							case 2:
								GOTO = 48200;
								continue;
							case 3:
								GOTO = 48300;
								continue;
						}
					}
					game.dsub.jigsup_(265);
					/* !YOU PUSHED, YOU DIE. */
					return ret_val;

				case 48100:
					i = 267;
					if (vars.findex_1.carozf)
					{
						i = 266;
					}
					/* !SPEED UP? */
					vars.findex_1.carozf = true;
					game.dsub.rspeak_(i);
					return ret_val;

				case 48200:
					i = 266;
					/* !ASSUME NO CHANGE. */
					if (vars.findex_1.carozf)
					{
						i = 268;
					}
					vars.findex_1.carozf = false;
					game.dsub.rspeak_(i);
					return ret_val;

				case 48300:
					vars.findex_1.caroff = !vars.findex_1.caroff;
					/* !FLIP CAROUSEL. */
					if (!game.dsub.qhere_(vars.oindex_1.irbox, vars.rindex_1.carou))
					{
						return ret_val;
					}
					/* !IRON BOX IN CAROUSEL? */
					game.dsub.rspeak_(269);
					/* !YES, THUMP. */
					vars.objcts_1.oflag1[vars.oindex_1.irbox - 1] ^= Vars.VISIBT;
					if (vars.findex_1.caroff)
					{
						vars.rooms_1.rflag[vars.rindex_1.carou - 1] &= ~Vars.RSEEN;
					}
					return ret_val;

				/* O119-- FLASK FUNCTION */

				case 49000:
					if (vars.prsvec_1.prsa == vars.vindex_1.openw)
					{
						GOTO = 49100;
						continue;
					}
					/* !OPEN? */
					if (vars.prsvec_1.prsa != vars.vindex_1.mungw
							&& vars.prsvec_1.prsa != vars.vindex_1.throww)
					{

						GOTO = 10;
						continue;
					}
					game.dsub.newsta_(vars.oindex_1.flask, 270, 0, 0, 0);
					/* !KILL FLASK. */
				case 49100:
					vars.rooms_1.rflag[vars.play_1.here - 1] |= Vars.RMUNG;
					vars.rooms_1.rrand(vars.play_1.here - 1, 271);
					game.dsub.jigsup_(272);
					/* !POISONED. */
					return ret_val;

				/* O120-- BUCKET FUNCTION */

				case 50000:
					if (arg != 2)
					{
						GOTO = 10;
						continue;
					}
					/* !READOUT? */
					if (vars.objcts_1.ocan[vars.oindex_1.water - 1] != vars.oindex_1.bucke
							|| vars.findex_1.bucktf)
					{
						GOTO = 50500;
						continue;
					}
					vars.findex_1.bucktf = true;
					/* !BUCKET AT TOP. */
					vars.cevent_1.ctick[vars.cindex_1.cevbuc - 1] = 100;
					/* !START COUNTDOWN. */
					game.dsub.newsta_(vars.oindex_1.bucke, 290, vars.rindex_1.twell, 0, 0);
					/* !REPOSITION BUCKET. */
					GOTO = 50900;
					continue;
				/* !FINISH UP. */

				case 50500:
					if (vars.objcts_1.ocan[vars.oindex_1.water - 1] == vars.oindex_1.bucke
							|| !vars.findex_1.bucktf)
					{
						GOTO = 10;
						continue;
					}
					vars.findex_1.bucktf = false;
					game.dsub.newsta_(vars.oindex_1.bucke, 291, vars.rindex_1.bwell, 0, 0);
					/* !BUCKET AT BOTTOM. */
				case 50900:
					if (av != vars.oindex_1.bucke)
					{
						return ret_val;
					}
					/* !IN BUCKET? */
					game.dso2.moveto_(vars.objcts_1.oroom[vars.oindex_1.bucke - 1],
							vars.play_1.winner);
					/* !MOVE ADVENTURER. */
					game.dsub.rmdesc_(0);
					/* !DESCRIBE ROOM. */
					return ret_val;
				/* OAPPLI, PAGE 9 */

				/* O121-- EATME CAKE */

				case 51000:
					if (vars.prsvec_1.prsa != vars.vindex_1.eatw
							|| vars.prsvec_1.prso != vars.oindex_1.ecake
							|| vars.play_1.here != vars.rindex_1.alice)
					{
						GOTO = 10;
						continue;
					}
					game.dsub.newsta_(vars.oindex_1.ecake, 273, 0, 0, 0);
					/* !VANISH CAKE. */
					vars.objcts_1.oflag1[vars.oindex_1.robot - 1] &= ~Vars.VISIBT;
					ret_val = game.dso2.moveto_(vars.rindex_1.alism, vars.play_1.winner);
					/* !MOVE TO ALICE SMALL. */
					iz = 64;
					ir = vars.rindex_1.alism;
					io = vars.rindex_1.alice;
					GOTO = 52405;
					continue;

				/* O122-- ICINGS */

				case 52000:
					if (vars.prsvec_1.prsa != vars.vindex_1.readw)
					{
						GOTO = 52200;
						continue;
					}
					/* !READ? */
					i = 274;
					/* !CANT READ. */
					if (vars.prsvec_1.prsi != 0)
					{
						i = 275;
					}
					/* !THROUGH SOMETHING? */
					if (vars.prsvec_1.prsi == vars.oindex_1.bottl)
					{
						i = 276;
					}
					/* !THROUGH BOTTLE? */
					if (vars.prsvec_1.prsi == vars.oindex_1.flask)
					{
						i = vars.prsvec_1.prso - vars.oindex_1.orice + 277;
					}
					/* !THROUGH FLASK? */
					game.dsub.rspeak_(i);
					/* !READ FLASK. */
					return ret_val;

				case 52200:
					if (vars.prsvec_1.prsa != vars.vindex_1.throww
							|| vars.prsvec_1.prso != vars.oindex_1.rdice
							|| vars.prsvec_1.prsi != vars.oindex_1.pool)
					{
						GOTO = 52300;
						continue;
					}
					game.dsub.newsta_(vars.oindex_1.pool, 280, 0, 0, 0);
					/* !VANISH POOL. */
					vars.objcts_1.oflag1[vars.oindex_1.saffr - 1] |= Vars.VISIBT;
					return ret_val;

				case 52300:
					if (vars.play_1.here != vars.rindex_1.alice
							&& vars.play_1.here != vars.rindex_1.alism
							&& vars.play_1.here != vars.rindex_1.alitr)
					{
						GOTO = 10;
						continue;
					}
					if ((vars.prsvec_1.prsa != vars.vindex_1.eatw
							&& vars.prsvec_1.prsa != vars.vindex_1.throww)
							|| vars.prsvec_1.prso != vars.oindex_1.orice)
					{
						GOTO = 52400;
						continue;
					}
					game.dsub.newsta_(vars.oindex_1.orice, 0, 0, 0, 0);
					/* !VANISH ORANGE ICE. */
					vars.rooms_1.rflag[vars.play_1.here - 1] |= Vars.RMUNG;
					vars.rooms_1.rrand(vars.play_1.here - 1, 281);
					game.dsub.jigsup_(282);
					/* !VANISH ADVENTURER. */
					return ret_val;

				case 52400:
					if (vars.prsvec_1.prsa != vars.vindex_1.eatw
							|| vars.prsvec_1.prso != vars.oindex_1.blice)
					{
						GOTO = 10;
						continue;
					}
					game.dsub.newsta_(vars.oindex_1.blice, 283, 0, 0, 0);
					/* !VANISH BLUE ICE. */
					if (vars.play_1.here != vars.rindex_1.alism)
					{
						GOTO = 52500;
						continue;
					}
					/* !IN REDUCED ROOM? */
					vars.objcts_1.oflag1[vars.oindex_1.robot - 1] |= Vars.VISIBT;
					io = vars.play_1.here;
					ret_val = game.dso2.moveto_(vars.rindex_1.alice, vars.play_1.winner);
					iz = 0;
					ir = vars.rindex_1.alice;

					/* Do a size change, common loop used also by code at 51000 */

				case 52405:
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* !ENLARGE WORLD. */
						if (vars.objcts_1.oroom[i - 1] != io || vars.objcts_1.osize[i - 1] == 10000)
						{
							continue;
						}
						vars.objcts_1.oroom[i - 1] = ir;
						vars.objcts_1.osize[i - 1] = iz;

					}
					return ret_val;

				case 52500:
					game.dsub.jigsup_(284);
					/* !ENLARGED IN WRONG ROOM. */
					return ret_val;

				/* O123-- BRICK */

				case 54000:
					if (vars.prsvec_1.prsa != vars.vindex_1.burnw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !BURN? */
					game.dsub.jigsup_(150);
					/* !BOOM */
					/* ! */
					return ret_val;

				/* O124-- MYSELF */

				case 55000:
					if (vars.prsvec_1.prsa != vars.vindex_1.givew)
					{
						GOTO = 55100;
						continue loop;
					}
					/* !GIVE? */
					game.dsub.newsta_(vars.prsvec_1.prso, 2, 0, 0, vars.aindex_1.player);
					/* !DONE. */
					return ret_val;

				case 55100:
					if (vars.prsvec_1.prsa != vars.vindex_1.takew)
					{
						GOTO = 55200;
						continue loop;
					}
					/* !TAKE? */
					game.dsub.rspeak_(286);
					/* !JOKE. */
					return ret_val;

				case 55200:
					if (vars.prsvec_1.prsa != vars.vindex_1.killw
							&& vars.prsvec_1.prsa != vars.vindex_1.mungw)
					{
						GOTO = 10;
						continue loop;
					}
					game.dsub.jigsup_(287);
					/* !KILL, NO JOKE. */
					return ret_val;
				/* OAPPLI, PAGE 10 */

				/* O125-- PANELS INSIDE MIRROR */

				case 56000:
					if (vars.prsvec_1.prsa != vars.vindex_1.pushw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !PUSH? */
					if (vars.findex_1.poleuf != 0)
					{
						GOTO = 56100;
						continue loop;
					}
					/* !SHORT POLE UP? */
					i = 731;
					/* !NO, WONT BUDGE. */
					if (vars.findex_1.mdir % 180 == 0)
					{
						i = 732;
					}
					/* !DIFF MSG IF N-S. */
					game.dsub.rspeak_(i);
					/* !TELL WONT MOVE. */
					return ret_val;

				case 56100:
					if (vars.findex_1.mloc != vars.rindex_1.mrg)
					{
						GOTO = 56200;
						continue loop;
					}
					/* !IN GDN ROOM? */
					game.dsub.rspeak_(733);
					/* !YOU LOSE. */
					game.dsub.jigsup_(685);
					return ret_val;

				case 56200:
					i = 831;
					/* !ROTATE L OR R. */
					if (vars.prsvec_1.prso == vars.oindex_1.rdwal
							|| vars.prsvec_1.prso == vars.oindex_1.ylwal)
					{
						i = 830;
					}
					game.dsub.rspeak_(i);
					/* !TELL DIRECTION. */
					vars.findex_1.mdir = (vars.findex_1.mdir + 45 + (i - 830) * 270) % 360;
					/* !CALCULATE NEW DIR. */
					i__1 = vars.findex_1.mdir / 45 + 695;
					game.dsub.rspsub_(734, i__1);
					/* !TELL NEW DIR. */
					if (vars.findex_1.wdopnf)
					{
						game.dsub.rspeak_(730);
					}
					/* !IF PANEL OPEN, CLOSE. */
					vars.findex_1.wdopnf = false;
					return ret_val;
				/* !DONE. */

				/* O126-- ENDS INSIDE MIRROR */

				case 57000:
					if (vars.prsvec_1.prsa != vars.vindex_1.pushw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !PUSH? */
					if (vars.findex_1.mdir % 180 == 0)
					{
						GOTO = 57100;
						continue loop;
					}
					/* !MIRROR N-S? */
					game.dsub.rspeak_(735);
					/* !NO, WONT BUDGE. */
					return ret_val;

				case 57100:
					if (vars.prsvec_1.prso != vars.oindex_1.pindr)
					{
						GOTO = 57300;
						continue loop;
					}
					/* !PUSH PINE WALL? */
					if ((vars.findex_1.mloc == vars.rindex_1.mrc && vars.findex_1.mdir == 180)
							|| (vars.findex_1.mloc == vars.rindex_1.mrd && vars.findex_1.mdir == 0)
							|| vars.findex_1.mloc == vars.rindex_1.mrg)
					{
						GOTO = 57200;
						continue loop;
					}
					game.dsub.rspeak_(736);
					/* !NO, OPENS. */
					vars.findex_1.wdopnf = true;
					/* !INDICATE OPEN. */
					vars.cevent_1.cflag[vars.cindex_1.cevpin - 1] = true;
					/* !TIME OPENING. */
					vars.cevent_1.ctick[vars.cindex_1.cevpin - 1] = 5;
					return ret_val;

				case 57200:
					game.dsub.rspeak_(737);
					/* !GDN SEES YOU, DIE. */
					game.dsub.jigsup_(685);
					return ret_val;

				case 57300:
					nloc = vars.findex_1.mloc - 1;
					/* !NEW LOC IF SOUTH. */
					if (vars.findex_1.mdir == 0)
					{
						nloc = vars.findex_1.mloc + 1;
					}
					/* !NEW LOC IF NORTH. */
					if (nloc >= vars.rindex_1.mra && nloc <= vars.rindex_1.mrd)
					{
						GOTO = 57400;
						continue loop;
					}
					game.dsub.rspeak_(738);
					/* !HAVE REACHED END. */
					return ret_val;

				case 57400:
					i = 699;
					/* !ASSUME SOUTH. */
					if (vars.findex_1.mdir == 0)
					{
						i = 695;
					}
					/* !NORTH. */
					j = 739;
					/* !ASSUME SMOOTH. */
					if (vars.findex_1.poleuf != 0)
					{
						j = 740;
					}
					/* !POLE UP, WOBBLES. */
					game.dsub.rspsub_(j, i);
					/* !DESCRIBE. */
					vars.findex_1.mloc = nloc;
					if (vars.findex_1.mloc != vars.rindex_1.mrg)
					{
						return ret_val;
					}
					/* !NOW IN GDN ROOM? */

					if (vars.findex_1.poleuf != 0)
					{
						GOTO = 57500;
						continue loop;
					}
					/* !POLE UP, GDN SEES. */
					if (vars.findex_1.mropnf || vars.findex_1.wdopnf)
					{
						GOTO = 57600;
						continue loop;
					}
					/* !DOOR OPEN, GDN SEES. */
					if (vars.findex_1.mr1f && vars.findex_1.mr2f)
					{
						return ret_val;
					}
					/* !MIRRORS INTACT, OK. */
					game.dsub.rspeak_(742);
					/* !MIRRORS BROKEN, DIE. */
					game.dsub.jigsup_(743);
					return ret_val;

				case 57500:
					game.dsub.rspeak_(741);
					/* !POLE UP, DIE. */
					game.dsub.jigsup_(743);
					return ret_val;

				case 57600:
					game.dsub.rspeak_(744);
					/* !DOOR OPEN, DIE. */
					game.dsub.jigsup_(743);
					return ret_val;
				/* OAPPLI, PAGE 11 */

				/* O127-- GLOBAL GUARDIANS */

				case 58000:
					if (vars.prsvec_1.prsa != vars.vindex_1.attacw
							&& vars.prsvec_1.prsa != vars.vindex_1.killw
							&& vars.prsvec_1.prsa != vars.vindex_1.mungw)
					{
						GOTO = 58100;
						continue loop;
					}
					game.dsub.jigsup_(745);
					/* !LOSE. */
					return ret_val;

				case 58100:
					if (vars.prsvec_1.prsa != vars.vindex_1.hellow)
					{
						GOTO = 10;
						continue loop;
					}
					/* !HELLO? */
					game.dsub.rspeak_(746);
					/* !NO REPLY. */
					return ret_val;

				/* O128-- GLOBAL MASTER */

				case 59000:
					if (vars.prsvec_1.prsa != vars.vindex_1.attacw
							&& vars.prsvec_1.prsa != vars.vindex_1.killw
							&& vars.prsvec_1.prsa != vars.vindex_1.mungw)
					{
						GOTO = 59100;
						continue loop;
					}
					game.dsub.jigsup_(747);
					/* !BAD IDEA. */
					return ret_val;

				case 59100:
					if (vars.prsvec_1.prsa != vars.vindex_1.takew)
					{
						GOTO = 10;
						continue loop;
					}
					/* !TAKE? */
					game.dsub.rspeak_(748);
					/* !JOKE. */
					return ret_val;

				/* O129-- NUMERAL FIVE (FOR JOKE) */

				case 60000:
					if (vars.prsvec_1.prsa != vars.vindex_1.takew)
					{
						GOTO = 10;
						continue loop;
					}
					/* !TAKE FIVE? */
					game.dsub.rspeak_(419);
					/* !TIME PASSES. */
					for (i = 1; i <= 3; ++i)
					{
						/* !WAIT A WHILE. */
						if (game.verbs.clockd_())
						{
							return ret_val;
						}
					}
					return ret_val;

				/* O130-- CRYPT FUNCTION */

				case 61000:
					if (!vars.findex_1.endgmf)
					{
						GOTO = 45000;
						continue loop;
					}
					/* !IF NOT EG, DIE. */
					if (vars.prsvec_1.prsa != vars.vindex_1.openw)
					{
						GOTO = 61100;
						continue loop;
					}
					/* !OPEN? */
					i = 793;
					if ((vars.objcts_1.oflag2[vars.oindex_1.tomb - 1] & Vars.OPENBT) != 0)
					{
						i = 794;
					}
					game.dsub.rspeak_(i);
					vars.objcts_1.oflag2[vars.oindex_1.tomb - 1] |= Vars.OPENBT;
					return ret_val;

				case 61100:
					if (vars.prsvec_1.prsa != vars.vindex_1.closew)
					{
						GOTO = 45000;
						continue loop;
					}
					/* !CLOSE? */
					i = 795;
					if ((vars.objcts_1.oflag2[vars.oindex_1.tomb - 1] & Vars.OPENBT) != 0)
					{
						i = 796;
					}
					game.dsub.rspeak_(i);
					vars.objcts_1.oflag2[vars.oindex_1.tomb - 1] &= ~Vars.OPENBT;
					if (vars.play_1.here == vars.rindex_1.crypt)
					{
						vars.cevent_1.ctick[vars.cindex_1.cevste - 1] = 3;
					}
					/* !IF IN CRYPT, START EG. */
					return ret_val;
				/* OAPPLI, PAGE 12 */

				/* O131-- GLOBAL LADDER */

				case 62000:
					if (vars.puzzle_1.cpvec[vars.findex_1.cphere] == -2
							|| vars.puzzle_1.cpvec[vars.findex_1.cphere - 2] == -3)
					{
						GOTO = 62100;
						continue loop;
					}
					game.dsub.rspeak_(865);
					/* !NO, LOSE. */
					return ret_val;

				case 62100:
					if (vars.prsvec_1.prsa == vars.vindex_1.clmbw
							|| vars.prsvec_1.prsa == vars.vindex_1.clmbuw)
					{

						GOTO = 62200;
						continue loop;
					}
					game.dsub.rspeak_(866);
					/* !CLIMB IT? */
					return ret_val;

				case 62200:
					if (vars.findex_1.cphere == 10
							&& vars.puzzle_1.cpvec[vars.findex_1.cphere] == -2)
					{
						GOTO = 62300;
						continue loop;
					}
					game.dsub.rspeak_(867);
					/* !NO, HIT YOUR HEAD. */
					return ret_val;

				case 62300:
					game.dso2.moveto_(vars.rindex_1.cpant, vars.play_1.winner);
					/* !TO ANTEROOM. */
					game.dsub.rmdesc_(3);
					/* !DESCRIBE. */
					return ret_val;
			}
		} while (true);
	} /* oappli_ */

}
