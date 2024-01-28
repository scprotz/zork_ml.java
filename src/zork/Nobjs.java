package zork;

import java.io.IOException;

public class Nobjs
{
	/* NOBJS- NEW OBJECTS PROCESSOR */
	/* OBJECTS IN THIS MODULE CANNOT CALL RMINFO, JIGSUP, */
	/* MAJOR VERBS, OR OTHER NON-RESIDENT SUBROUTINES */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Nobjs(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean nobjs_(int ri, int arg) throws IOException
	{
		/* System generated locals */
		int i__1, i__2;
		boolean ret_val;

		/* Local variables */
		int target = 0;
		int i = 0;
		int j = 0;
		int wl = 0;
		int nxt = 0, odi2 = 0, odo2 = 0;
		int GOTO = 10;

		if (vars.prsvec_1.prso != 0)
		{
			odo2 = vars.objcts_1.odesc2[vars.prsvec_1.prso - 1];
		}
		if (vars.prsvec_1.prsi != 0)
		{
			odi2 = vars.objcts_1.odesc2[vars.prsvec_1.prsi - 1];
		}
		ret_val = true;

		switch (ri - 31)
		{
			case 1:
				GOTO = 1000;
				break;
			case 2:
				GOTO = 2000;
				break;
			case 3:
				GOTO = 3000;
				break;
			case 4:
				GOTO = 4000;
				break;
			case 5:
				GOTO = 5000;
				break;
			case 6:
				GOTO = 6000;
				break;
			case 7:
				GOTO = 7000;
				break;
			case 8:
				GOTO = 8000;
				break;
			case 9:
				GOTO = 9000;
				break;
			case 10:
				GOTO = 10000;
				break;
			case 11:
				GOTO = 11000;
				break;
			case 12:
				GOTO = 12000;
				break;
			case 13:
				GOTO = 13000;
				break;
			case 14:
				GOTO = 14000;
				break;
			case 15:
				GOTO = 15000;
				break;
			case 16:
				GOTO = 16000;
				break;
			case 17:
				GOTO = 17000;
				break;
			case 18:
				GOTO = 18000;
				break;
			case 19:
				GOTO = 19000;
				break;
			case 20:
				GOTO = 20000;
				break;
			case 21:
				GOTO = 21000;
				break;
			default:
				game.dsub.bug_(6, ri);
		}

		loop: do
		{
			switch (GOTO)
			{

				/* RETURN HERE TO DECLARE FALSE RESULT */

				case 10:
					ret_val = false;
					return ret_val;

				/* O32-- BILLS */

				case 1000:
					if (vars.prsvec_1.prsa != vars.vindex_1.eatw)
					{
						GOTO = 1100;
						continue loop;
					}
					/* !EAT? */
					game.dsub.rspeak_(639);
					/* !JOKE. */
					return ret_val;

				case 1100:
					if (vars.prsvec_1.prsa == vars.vindex_1.burnw)
					{
						game.dsub.rspeak_(640);
					}
					/* !BURN? JOKE. */
					GOTO = 10;
					continue loop;
				/* !LET IT BE HANDLED. */
				/* NOBJS, PAGE 3 */

				/* O33-- SCREEN OF LIGHT */

				case 2000:
					target = vars.oindex_1.scol;
					/* !TARGET IS SCOL. */
				case 2100:
					if (vars.prsvec_1.prso != target)
					{
						GOTO = 2400;
						continue loop;
					}
					/* !PRSO EQ TARGET? */
					if (vars.prsvec_1.prsa != vars.vindex_1.pushw
							&& vars.prsvec_1.prsa != vars.vindex_1.movew
							&& vars.prsvec_1.prsa != vars.vindex_1.takew
							&& vars.prsvec_1.prsa != vars.vindex_1.rubw)
					{
						GOTO = 2200;
						continue loop;
					}
					game.dsub.rspeak_(673);
					/* !HAND PASSES THRU. */
					return ret_val;

				case 2200:
					if (vars.prsvec_1.prsa != vars.vindex_1.killw
							&& vars.prsvec_1.prsa != vars.vindex_1.attacw
							&& vars.prsvec_1.prsa != vars.vindex_1.mungw)
					{
						GOTO = 2400;
						continue loop;
					}
					game.dsub.rspsub_(674, odi2);
					/* !PASSES THRU. */
					return ret_val;

				case 2400:
					if (vars.prsvec_1.prsa != vars.vindex_1.throww || vars.prsvec_1.prsi != target)
					{
						GOTO = 10;
						continue loop;
					}
					if (vars.play_1.here == vars.rindex_1.bkbox)
					{
						GOTO = 2600;
						continue loop;
					}
					/* !THRU SCOL? */
					game.dsub.newsta_(vars.prsvec_1.prso, 0, vars.rindex_1.bkbox, 0, 0);
					/* !NO, THRU WALL. */
					game.dsub.rspsub_(675, odo2);
					/* !ENDS UP IN BOX ROOM. */
					vars.cevent_1.ctick[vars.cindex_1.cevscl - 1] = 0;
					/* !CANCEL ALARM. */
					vars.screen_1.scolrm = 0;
					/* !RESET SCOL ROOM. */
					return ret_val;

				case 2600:
					if (vars.screen_1.scolrm == 0)
					{
						GOTO = 2900;
						continue loop;
					}
					/* !TRIED TO GO THRU? */
					game.dsub.newsta_(vars.prsvec_1.prso, 0, vars.screen_1.scolrm, 0, 0);
					/* !SUCCESS. */
					game.dsub.rspsub_(676, odo2);
					/* !ENDS UP SOMEWHERE. */
					vars.cevent_1.ctick[vars.cindex_1.cevscl - 1] = 0;
					/* !CANCEL ALARM. */
					vars.screen_1.scolrm = 0;
					/* !RESET SCOL ROOM. */
					return ret_val;

				case 2900:
					game.dsub.rspeak_(213);
					/* !CANT DO IT. */
					return ret_val;
				/* NOBJS, PAGE 4 */

				/* O34-- GNOME OF ZURICH */

				case 3000:
					if (vars.prsvec_1.prsa != vars.vindex_1.givew  && vars.prsvec_1.prsa != vars.vindex_1.throww)
					{

						GOTO = 3200;
						continue loop;
					}
					if (vars.objcts_1.otval[vars.prsvec_1.prso - 1] != 0)
					{
						GOTO = 3100;
						continue loop;
					}
					/* !THROW A TREASURE? */
					game.dsub.newsta_(vars.prsvec_1.prso, 641, 0, 0, 0);
					/* !NO, GO POP. */
					return ret_val;

				case 3100:
					game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, 0);
					/* !YES, BYE BYE TREASURE. */
					game.dsub.rspsub_(642, odo2);
					game.dsub.newsta_(vars.oindex_1.zgnom, 0, 0, 0, 0);
					/* !BYE BYE GNOME. */
					vars.cevent_1.ctick[vars.cindex_1.cevzgo - 1] = 0;
					/* !CANCEL EXIT. */
					game.dso2.moveto_(vars.rindex_1.bkent, vars.play_1.winner);
					/* !NOW IN BANK ENTRANCE. */
					return ret_val;

				case 3200:
					if (vars.prsvec_1.prsa != vars.vindex_1.attacw
							&& vars.prsvec_1.prsa != vars.vindex_1.killw
							&& vars.prsvec_1.prsa != vars.vindex_1.mungw)
					{
						GOTO = 3300;
						continue loop;
					}
					game.dsub.newsta_(vars.oindex_1.zgnom, 643, 0, 0, 0);
					/* !VANISH GNOME. */
					vars.cevent_1.ctick[vars.cindex_1.cevzgo - 1] = 0;
					/* !CANCEL EXIT. */
					return ret_val;

				case 3300:
					game.dsub.rspeak_(644);
					/* !GNOME IS IMPATIENT. */
					return ret_val;

				/* O35-- EGG */

				case 4000:
					if (vars.prsvec_1.prsa != vars.vindex_1.openw
							|| vars.prsvec_1.prso != vars.oindex_1.egg)
					{
						GOTO = 4500;
						continue loop;
					}
					if (!((vars.objcts_1.oflag2[vars.oindex_1.egg - 1] & Vars.OPENBT) != 0))
					{
						GOTO = 4100;
						continue loop;
					}
					/* !OPEN ALREADY? */
					game.dsub.rspeak_(649);
					/* !YES. */
					return ret_val;

				case 4100:
					if (vars.prsvec_1.prsi != 0)
					{
						GOTO = 4200;
						continue loop;
					}
					/* !WITH SOMETHING? */
					game.dsub.rspeak_(650);
					/* !NO, CANT. */
					return ret_val;

				case 4200:
					if (vars.prsvec_1.prsi != vars.oindex_1.hands)
					{
						GOTO = 4300;
						continue loop;
					}
					/* !WITH HANDS? */
					game.dsub.rspeak_(651);
					/* !NOT RECOMMENDED. */
					return ret_val;

				case 4300:
					i = 652;
					/* !MUNG MESSAGE. */
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prsi - 1] & Vars.TOOLBT) != 0
							|| (vars.objcts_1.oflag2[vars.prsvec_1.prsi - 1] & Vars.WEAPBT) != 0)
					{
						GOTO = 4600;
						continue loop;
					}
					i = 653;
					/* !NOVELTY 1. */
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.FITEBT) != 0)
					{
						i = 654;
					}
					vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] |= Vars.FITEBT;
					game.dsub.rspsub_(i, odi2);
					return ret_val;

				case 4500:
					if (vars.prsvec_1.prsa != vars.vindex_1.openw
							&& vars.prsvec_1.prsa != vars.vindex_1.mungw)
					{
						GOTO = 4800;
						continue loop;
					}
					i = 655;
					/* !YOU BLEW IT. */
				case 4600:
					game.dsub.newsta_(vars.oindex_1.begg, i,
							vars.objcts_1.oroom[vars.oindex_1.egg - 1],
							vars.objcts_1.ocan[vars.oindex_1.egg - 1],
							vars.objcts_1.oadv[vars.oindex_1.egg - 1]);
					game.dsub.newsta_(vars.oindex_1.egg, 0, 0, 0, 0);
					/* !VANISH EGG. */
					vars.objcts_1.otval[vars.oindex_1.begg - 1] = 2;
					/* !BAD EGG HAS VALUE. */
					if (vars.objcts_1.ocan[vars.oindex_1.canar - 1] != vars.oindex_1.egg)
					{
						GOTO = 4700;
						continue loop;
					}
					/* !WAS CANARY INSIDE? */
					game.dsub.rspeak_(vars.objcts_1.odesco[vars.oindex_1.bcana - 1]);
					/* !YES, DESCRIBE RESULT. */
					vars.objcts_1.otval[vars.oindex_1.bcana - 1] = 1;
					return ret_val;					
				case 4700:
					game.dsub.newsta_(vars.oindex_1.bcana, 0, 0, 0, 0);
					/* !NO, VANISH IT. */
					return ret_val;

				case 4800:
					if (vars.prsvec_1.prsa != vars.vindex_1.dropw
							|| vars.play_1.here != vars.rindex_1.mtree)
					{
						GOTO = 10;
						continue loop;
					}
					game.dsub.newsta_(vars.oindex_1.begg, 658, vars.rindex_1.fore3, 0, 0);
					/* !DROPPED EGG. */
					game.dsub.newsta_(vars.oindex_1.egg, 0, 0, 0, 0);
					vars.objcts_1.otval[vars.oindex_1.begg - 1] = 2;
					if (vars.objcts_1.ocan[vars.oindex_1.canar - 1] != vars.oindex_1.egg)
					{
						GOTO = 4700;
						continue loop;
					}
					vars.objcts_1.otval[vars.oindex_1.bcana - 1] = 1;
					/* !BAD CANARY. */
					return ret_val;
				/* NOBJS, PAGE 5 */

				/* O36-- CANARIES, GOOD AND BAD */

				case 5000:
					if (vars.prsvec_1.prsa != vars.vindex_1.windw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !WIND EM UP? */
					if (vars.prsvec_1.prso == vars.oindex_1.canar)
					{
						GOTO = 5100;
						continue loop;
					}
					/* !RIGHT ONE? */
					game.dsub.rspeak_(645);
					/* !NO, BAD NEWS. */
					return ret_val;

				case 5100:
					if (!vars.findex_1.singsf && (vars.play_1.here == vars.rindex_1.mtree
							|| vars.play_1.here >= vars.rindex_1.fore1
									&& vars.play_1.here < vars.rindex_1.clear))
					{
						GOTO = 5200;
						continue loop;
					}
					game.dsub.rspeak_(646);
					/* !NO, MEDIOCRE NEWS. */
					return ret_val;

				case 5200:
					vars.findex_1.singsf = true;
					/* !SANG SONG. */
					i = vars.play_1.here;
					if (i == vars.rindex_1.mtree)
					{
						i = vars.rindex_1.fore3;
					}
					/* !PLACE BAUBLE. */
					game.dsub.newsta_(vars.oindex_1.baubl, 647, i, 0, 0);
					return ret_val;

				/* O37-- WHITE CLIFFS */

				case 6000:
					if (vars.prsvec_1.prsa != vars.vindex_1.clmbw
							&& vars.prsvec_1.prsa != vars.vindex_1.clmbuw
							&& vars.prsvec_1.prsa != vars.vindex_1.clmbdw)
					{
						GOTO = 10;
						continue loop;
					}
					game.dsub.rspeak_(648);
					/* !OH YEAH? */
					return ret_val;

				/* O38-- WALL */

				case 7000:
					i__1 = vars.play_1.here - vars.findex_1.mloc;
					if ((Math.abs(i__1)) != 1 || game.dso6.mrhere_(vars.play_1.here) != 0
							|| vars.prsvec_1.prsa != vars.vindex_1.pushw)
					{
						GOTO = 7100;
						continue loop;
					}
					game.dsub.rspeak_(860);
					/* !PUSHED MIRROR WALL. */
					return ret_val;

				case 7100:
					if ((vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RNWALL) == 0)
					{
						GOTO = 10;
						continue loop;
					}
					game.dsub.rspeak_(662);
					/* !NO WALL. */
					return ret_val;
				/* NOBJS, PAGE 6 */

				/* O39-- SONG BIRD GLOBAL */

				case 8000:
					if (vars.prsvec_1.prsa != vars.vindex_1.findw)
					{
						GOTO = 8100;
						continue loop;
					}
					/* !FIND? */
					game.dsub.rspeak_(666);
					return ret_val;

				case 8100:
					if (vars.prsvec_1.prsa != vars.vindex_1.examiw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !EXAMINE? */
					game.dsub.rspeak_(667);
					return ret_val;

				/* O40-- PUZZLE/SCOL WALLS */

				case 9000:
					if (vars.play_1.here != vars.rindex_1.cpuzz)
					{
						GOTO = 9500;
						continue loop;
					}
					/* !PUZZLE WALLS? */
					if (vars.prsvec_1.prsa != vars.vindex_1.pushw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !PUSH? */
					for (i = 1; i <= 8; i += 2)
					{
						/* !LOCATE WALL. */
						if (vars.prsvec_1.prso == vars.puzzle_1.cpwl[i - 1])
						{
							GOTO = 9200;
							continue loop;
						}
						/* case 9100: */
					}
					game.dsub.bug_(80, vars.prsvec_1.prso);
					/* !WHAT? */

				case 9200:
					j = vars.puzzle_1.cpwl[i];
					/* !GET DIRECTIONAL OFFSET. */
					nxt = vars.findex_1.cphere + j;
					/* !GET NEXT STATE. */
					wl = vars.puzzle_1.cpvec[nxt - 1];
					/* !GET C(NEXT STATE). */
					switch (wl + 4)
					{
						case 1:
							GOTO = 9300;
							continue loop;
						case 2:
							GOTO = 9300;
							continue loop;
						case 3:
							GOTO = 9300;
							continue loop;
						case 4:
							GOTO = 9250;
							continue loop;
						case 5:
							GOTO = 9350;
							continue loop;
					}
					/* !PROCESS. */

				case 9250:
					game.dsub.rspeak_(876);
					/* !CLEAR CORRIDOR. */
					return ret_val;

				case 9300:
					if (vars.puzzle_1.cpvec[nxt + j - 1] == 0)
					{
						GOTO = 9400;
						continue loop;
					}
					/* !MOVABLE, ROOM TO MOVE? */
				case 9350:
					game.dsub.rspeak_(877);
					/* !IMMOVABLE, NO ROOM. */
					return ret_val;

				case 9400:
					i = 878;
					/* !ASSUME FIRST PUSH. */
					if (vars.findex_1.cpushf)
					{
						i = 879;
					}
					/* !NOT? */
					vars.findex_1.cpushf = true;
					vars.puzzle_1.cpvec[nxt + j - 1] = wl;
					/* !MOVE WALL. */
					vars.puzzle_1.cpvec[nxt - 1] = 0;
					/* !VACATE NEXT STATE. */
					game.dso7.cpgoto_(nxt);
					/* !ONWARD. */
					game.dso7.cpinfo_(i, nxt);
					/* !DESCRIBE. */
					game.dso1.princr_(true, vars.play_1.here);
					/* !PRINT ROOMS CONTENTS. */
					vars.rooms_1.rflag[vars.play_1.here - 1] |= Vars.RSEEN;
					return ret_val;

				case 9500:
					if (vars.play_1.here != vars.screen_1.scolac)
					{
						GOTO = 9700;
						continue loop;
					}
					/* !IN SCOL ACTIVE ROOM? */
					for (i = 1; i <= 12; i += 3)
					{
						target = vars.screen_1.scolwl[i];
						/* !ASSUME TARGET. */
						if (vars.screen_1.scolwl[i - 1] == vars.play_1.here)
						{
							GOTO = 2100;
							continue loop;
						}
						/* !TREAT IF FOUND. */
						/* case 9600: */
					}

				case 9700:
					if (vars.play_1.here != vars.rindex_1.bkbox)
					{
						GOTO = 10;
						continue loop;
					}
					/* !IN BOX ROOM? */
					target = vars.oindex_1.wnort;
					GOTO = 2100;
					continue loop;
				/* NOBJS, PAGE 7 */

				/* O41-- SHORT POLE */

				case 10000:
					if (vars.prsvec_1.prsa != vars.vindex_1.raisew)
					{
						GOTO = 10100;
						continue loop;
					}
					/* !LIFT? */
					i = 749;
					/* !ASSUME UP. */
					if (vars.findex_1.poleuf == 2)
					{
						i = 750;
					}
					/* !ALREADY UP? */
					game.dsub.rspeak_(i);
					vars.findex_1.poleuf = 2;
					/* !POLE IS RAISED. */
					return ret_val;

				case 10100:
					if (vars.prsvec_1.prsa != vars.vindex_1.lowerw
							&& vars.prsvec_1.prsa != vars.vindex_1.pushw)
					{

						GOTO = 10;
						continue loop;
					}
					if (vars.findex_1.poleuf != 0)
					{
						GOTO = 10200;
						continue loop;
					}
					/* !ALREADY LOWERED? */
					game.dsub.rspeak_(751);
					/* !CANT DO IT. */
					return ret_val;

				case 10200:
					if (vars.findex_1.mdir % 180 != 0)
					{
						GOTO = 10300;
						continue loop;
					}
					/* !MIRROR N-S? */
					vars.findex_1.poleuf = 0;
					/* !YES, LOWER INTO */
					game.dsub.rspeak_(752);
					/* !CHANNEL. */
					return ret_val;

				case 10300:
					if (vars.findex_1.mdir != 270 || vars.findex_1.mloc != vars.rindex_1.mrb)
					{
						GOTO = 10400;
						continue loop;
					}
					vars.findex_1.poleuf = 0;
					/* !LOWER INTO HOLE. */
					game.dsub.rspeak_(753);
					return ret_val;

				case 10400:
					i__1 = vars.findex_1.poleuf + 753;
					game.dsub.rspeak_(i__1);
					/* !POLEUF = 1 OR 2. */
					vars.findex_1.poleuf = 1;
					/* !NOW ON FLOOR. */
					return ret_val;

				/* O42-- MIRROR SWITCH */

				case 11000:
					if (vars.prsvec_1.prsa != vars.vindex_1.pushw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !PUSH? */
					if (vars.findex_1.mrpshf)
					{
						GOTO = 11300;
						continue loop;
					}
					/* !ALREADY PUSHED? */
					game.dsub.rspeak_(756);
					/* !BUTTON GOES IN. */
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* !BLOCKED? */
						if (game.dsub.qhere_(i, vars.rindex_1.mreye) && i != vars.oindex_1.rbeam)
						{
							GOTO = 11200;
							continue loop;
						}
						/* case 11100: */
					}
					game.dsub.rspeak_(757);
					/* !NOTHING IN BEAM. */
					return ret_val;

				case 11200:
					vars.cevent_1.cflag[vars.cindex_1.cevmrs - 1] = true;
					/* !MIRROR OPENS. */
					vars.cevent_1.ctick[vars.cindex_1.cevmrs - 1] = 7;
					vars.findex_1.mrpshf = true;
					vars.findex_1.mropnf = true;
					return ret_val;

				case 11300:
					game.dsub.rspeak_(758);
					/* !MIRROR ALREADYOPEN. */
					return ret_val;
				/* NOBJS, PAGE 8 */

				/* O43-- BEAM FUNCTION */

				case 12000:
					if (vars.prsvec_1.prsa != vars.vindex_1.takew
							|| vars.prsvec_1.prso != vars.oindex_1.rbeam)
					{
						GOTO = 12100;
						continue loop;
					}
					game.dsub.rspeak_(759);
					/* !TAKE BEAM, JOKE. */
					return ret_val;

				case 12100:
					i = vars.prsvec_1.prso;
					/* !ASSUME BLK WITH DIROBJ. */
					if (vars.prsvec_1.prsa == vars.vindex_1.putw
							&& vars.prsvec_1.prsi == vars.oindex_1.rbeam)
					{
						GOTO = 12200;
						continue loop;
					}
					if (vars.prsvec_1.prsa != vars.vindex_1.mungw
							|| vars.prsvec_1.prso != vars.oindex_1.rbeam || vars.prsvec_1.prsi == 0)
					{
						GOTO = 10;
						continue loop;
					}
					i = vars.prsvec_1.prsi;
				case 12200:
					if (vars.objcts_1.oadv[i - 1] != vars.play_1.winner)
					{
						GOTO = 12300;
						continue loop;
					}
					/* !CARRYING? */
					game.dsub.newsta_(i, 0, vars.play_1.here, 0, 0);
					/* !DROP OBJ. */
					game.dsub.rspsub_(760, vars.objcts_1.odesc2[i - 1]);
					return ret_val;

				case 12300:
					j = 761;
					/* !ASSUME NOT IN ROOM. */
					if (game.dsub.qhere_(j, vars.play_1.here))
					{
						i = 762;
					}
					/* !IN ROOM? */
					game.dsub.rspsub_(j, vars.objcts_1.odesc2[i - 1]);
					/* !DESCRIBE. */
					return ret_val;

				/* O44-- BRONZE DOOR */

				case 13000:
					if (vars.play_1.here == vars.rindex_1.ncell
							|| vars.findex_1.lcell == 4 && (vars.play_1.here == vars.rindex_1.cell
									|| vars.play_1.here == vars.rindex_1.scorr))
					{
						GOTO = 13100;
						continue loop;
					}
					game.dsub.rspeak_(763);
					/* !DOOR NOT THERE. */
					return ret_val;

				case 13100:
					if (!game.dso5.opncls_(vars.oindex_1.odoor, 764, 765))
					{
						GOTO = 10;
						continue loop;
					}
					/* !OPEN/CLOSE? */
					if (vars.play_1.here == vars.rindex_1.ncell
							&& (vars.objcts_1.oflag2[vars.oindex_1.odoor - 1] & Vars.OPENBT) != 0)
					{
						game.dsub.rspeak_(766);
					}
					return ret_val;

				/* O45-- QUIZ DOOR */

				case 14000:
					if (vars.prsvec_1.prsa != vars.vindex_1.openw
							&& vars.prsvec_1.prsa != vars.vindex_1.closew)
					{

						GOTO = 14100;
						continue loop;
					}
					game.dsub.rspeak_(767);
					/* !DOOR WONT MOVE. */
					return ret_val;

				case 14100:
					if (vars.prsvec_1.prsa != vars.vindex_1.knockw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !KNOCK? */
					if (vars.findex_1.inqstf)
					{
						GOTO = 14200;
						continue loop;
					}
					/* !TRIED IT ALREADY? */
					vars.findex_1.inqstf = true;
					/* !START INQUISITION. */
					vars.cevent_1.cflag[vars.cindex_1.cevinq - 1] = true;
					vars.cevent_1.ctick[vars.cindex_1.cevinq - 1] = 2;
					vars.findex_1.quesno = Supp.rnd_(8);
					/* !SELECT QUESTION. */
					vars.findex_1.nqatt = 0;
					vars.findex_1.corrct = 0;
					game.dsub.rspeak_(768);
					/* !ANNOUNCE RULES. */
					game.dsub.rspeak_(769);
					i__1 = vars.findex_1.quesno + 770;
					game.dsub.rspeak_(i__1);
					/* !ASK QUESTION. */
					return ret_val;

				case 14200:
					game.dsub.rspeak_(798);
					/* !NO REPLY. */
					return ret_val;

				/* O46-- LOCKED DOOR */

				case 15000:
					if (vars.prsvec_1.prsa != vars.vindex_1.openw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !OPEN? */
					game.dsub.rspeak_(778);
					/* !CANT. */
					return ret_val;

				/* O47-- CELL DOOR */

				case 16000:
					ret_val = game.dso5.opncls_(vars.oindex_1.cdoor, 779, 780);
					/* !OPEN/CLOSE? */
					return ret_val;
				/* NOBJS, PAGE 9 */

				/* O48-- DIALBUTTON */

				case 17000:
					if (vars.prsvec_1.prsa != vars.vindex_1.pushw)
					{
						GOTO = 10;
						continue loop;
					}
					/* !PUSH? */
					game.dsub.rspeak_(809);
					/* !CLICK. */
					if ((vars.objcts_1.oflag2[vars.oindex_1.cdoor - 1] & Vars.OPENBT) != 0)
					{
						game.dsub.rspeak_(810);
					}
					/* !CLOSE CELL DOOR. */

					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* !RELOCATE OLD TO HYPER. */
						if (vars.objcts_1.oroom[i - 1] == vars.rindex_1.cell
								&& (vars.objcts_1.oflag1[i - 1] & Vars.DOORBT) == 0)
						{
							i__2 = vars.findex_1.lcell * vars.hyper_1.hfactr;
							game.dsub.newsta_(i, 0, i__2, 0, 0);
						}
						if (vars.objcts_1.oroom[i - 1] == vars.findex_1.pnumb * vars.hyper_1.hfactr)
						{
							game.dsub.newsta_(i, 0, vars.rindex_1.cell, 0, 0);
						}
						/* case 17100: */
					}

					vars.objcts_1.oflag2[vars.oindex_1.odoor - 1] &= ~Vars.OPENBT;
					vars.objcts_1.oflag2[vars.oindex_1.cdoor - 1] &= ~Vars.OPENBT;
					vars.objcts_1.oflag1[vars.oindex_1.odoor - 1] &= ~Vars.VISIBT;
					if (vars.findex_1.pnumb == 4)
					{
						vars.objcts_1.oflag1[vars.oindex_1.odoor - 1] |= Vars.VISIBT;
					}

					if (vars.advs_1.aroom[vars.aindex_1.player - 1] != vars.rindex_1.cell)
					{
						GOTO = 17400;
						continue loop;
					}
					/* !PLAYER IN CELL? */
					if (vars.findex_1.lcell != 4)
					{
						GOTO = 17200;
						continue loop;
					}
					/* !IN RIGHT CELL? */
					vars.objcts_1.oflag1[vars.oindex_1.odoor - 1] |= Vars.VISIBT;
					game.dso2.moveto_(vars.rindex_1.ncell, vars.aindex_1.player);
					/* !YES, MOVETO NCELL. */
					GOTO = 17400;
					continue loop;
				case 17200:
					game.dso2.moveto_(vars.rindex_1.pcell, vars.aindex_1.player);
					/* !NO, MOVETO PCELL. */

				case 17400:
					vars.findex_1.lcell = vars.findex_1.pnumb;
					return ret_val;
				/* NOBJS, PAGE 10 */

				/* O49-- DIAL INDICATOR */

				case 18000:
					if (vars.prsvec_1.prsa != vars.vindex_1.spinw)
					{
						GOTO = 18100;
						continue loop;
					}
					/* !SPIN? */
					vars.findex_1.pnumb = Supp.rnd_(8) + 1;
					/* !WHEE */
					/* ! */
					i__1 = vars.findex_1.pnumb + 712;
					game.dsub.rspsub_(797, i__1);
					return ret_val;

				case 18100:
					if (vars.prsvec_1.prsa != vars.vindex_1.movew
							&& vars.prsvec_1.prsa != vars.vindex_1.putw
							&& vars.prsvec_1.prsa != vars.vindex_1.trntow)
					{
						GOTO = 10;
						continue loop;
					}
					if (vars.prsvec_1.prsi != 0)
					{
						GOTO = 18200;
						continue loop;
					}
					/* !TURN DIAL TO X? */
					game.dsub.rspeak_(806);
					/* !MUST SPECIFY. */
					return ret_val;

				case 18200:
					if (vars.prsvec_1.prsi >= vars.oindex_1.num1
							&& vars.prsvec_1.prsi <= vars.oindex_1.num8)
					{
						GOTO = 18300;
						continue loop;
					}
					game.dsub.rspeak_(807);
					/* !MUST BE DIGIT. */
					return ret_val;

				case 18300:
					vars.findex_1.pnumb = vars.prsvec_1.prsi - vars.oindex_1.num1 + 1;
					/* !SET UP NEW. */
					i__1 = vars.findex_1.pnumb + 712;
					game.dsub.rspsub_(808, i__1);
					return ret_val;

				/* O50-- GLOBAL MIRROR */

				case 19000:
					ret_val = mirpan_(832, false);
					return ret_val;

				/* O51-- GLOBAL PANEL */

				case 20000:
					if (vars.play_1.here != vars.rindex_1.fdoor)
					{
						GOTO = 20100;
						continue loop;
					}
					/* !AT FRONT DOOR? */
					if (vars.prsvec_1.prsa != vars.vindex_1.openw
							&& vars.prsvec_1.prsa != vars.vindex_1.closew)
					{

						GOTO = 10;
						continue loop;
					}
					game.dsub.rspeak_(843);
					/* !PANEL IN DOOR, NOGO. */
					return ret_val;

				case 20100:
					ret_val = mirpan_(838, true);
					return ret_val;

				/* O52-- PUZZLE ROOM SLIT */

				case 21000:
					if (vars.prsvec_1.prsa != vars.vindex_1.putw
							|| vars.prsvec_1.prsi != vars.oindex_1.cslit)
					{
						GOTO = 10;
						continue loop;
					}
					if (vars.prsvec_1.prso != vars.oindex_1.gcard)
					{
						GOTO = 21100;
						continue loop;
					}
					/* !PUT CARD IN SLIT? */
					game.dsub.newsta_(vars.prsvec_1.prso, 863, 0, 0, 0);
					/* !KILL CARD. */
					vars.findex_1.cpoutf = true;
					/* !OPEN DOOR. */
					vars.objcts_1.oflag1[vars.oindex_1.stldr - 1] &= ~Vars.VISIBT;
					return ret_val;

				case 21100:
					if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.VICTBT) == 0
							&& (vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.VILLBT) == 0)
					{
						GOTO = 21200;
						continue loop;
					}
					i__1 = Supp.rnd_(5) + 552;
					game.dsub.rspeak_(i__1);
					/* !JOKE FOR VILL, VICT. */
					return ret_val;

				case 21200:
					game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, 0);
					/* !KILL OBJECT. */
					game.dsub.rspsub_(864, odo2);
					/* !DESCRIBE. */
					return ret_val;
			}

		} while (true);
	} /* nobjs_ */

	/* MIRPAN--	PROCESSOR FOR GLOBAL MIRROR/PANEL */

	/* DECLARATIONS */

	private boolean mirpan_(
	int st,
	boolean pnf)
	{
//	    /* System generated locals */
//	    int i__1;
//	    boolean ret_val;
//
//	    /* Local variables */
//	    int num;
//	    int mrbf;
//
//	    ret_val = true;
//	    num = game.dso6.mrhere_(vars.play_1.here);
//	/* GET MIRROR NUM. */
//	    if (num != 0) {
//		GOTO = 100; continue loop;
//	    }
//	/* ANY HERE? */
//	    game.dsub.rspeak_(st);
//	/* NO, LOSE. */
//	    return ret_val;
//
//	case 100:
//	    mrbf = 0;
//	/* ASSUME MIRROR OK. */
//	    if (num == 1 && ! vars.findex_1.mr1f || num == 2 && ! vars.findex_1.mr2f) {
//		mrbf = 1;
//	    }
//	    if (vars.prsvec_1.prsa != vars.vindex_1.movew && vars.prsvec_1.prsa != vars.vindex_1.openw) {
//		GOTO = 200; continue loop;
//	    }
//	    i__1 = st + 1;
//	    game.dsub.rspeak_(i__1);
//	/* CANT OPEN OR MOVE. */
//	    return ret_val;
//
//	case 200:
//	    if (pnf || vars.prsvec_1.prsa != vars.vindex_1.lookiw && vars.prsvec_1.prsa != 
//		    vars.vindex_1.examiw && vars.prsvec_1.prsa != vars.vindex_1.lookw) {
//		GOTO = 300; continue loop;
//	    }
//	    i__1 = mrbf + 844;
//	    game.dsub.rspeak_(i__1);
//	/* LOOK IN MIRROR. */
//	    return ret_val;
//
//	case 300:
//	    if (vars.prsvec_1.prsa != vars.vindex_1.mungw) {
//		GOTO = 400; continue loop;
//	    }
//	/* BREAK? */
//	    i__1 = st + 2 + mrbf;
//	    game.dsub.rspeak_(i__1);
//	/* DO IT. */
//	    if (num == 1 && ! (pnf)) {
//		vars.findex_1.mr1f = false;
//	    }
//	    if (num == 2 && ! (pnf)) {
//		vars.findex_1.mr2f = false;
//	    }
//	    return ret_val;
//
//	case 400:
//	    if (pnf || mrbf == 0) {
//		GOTO = 500; continue loop;
//	    }
//	/* BROKEN MIRROR? */
//	    game.dsub.rspeak_(846);
//	    return ret_val;
//
//	case 500:
//	    if (vars.prsvec_1.prsa != vars.vindex_1.pushw) {
//		GOTO = 600; continue loop;
//	    }
//	/* PUSH? */
//	    i__1 = st + 3 + num;
//	    game.dsub.rspeak_(i__1);
//	    return ret_val;
//
//	case 600:
//	    ret_val = false;
//	/* CANT HANDLE IT. */
//	    return ret_val;
//
		throw new RuntimeException("Nobjs.mirpan_ not impl");
	} /* mirpan_ */

}
