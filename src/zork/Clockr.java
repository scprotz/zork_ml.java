package zork;

public class Clockr implements Constants
{
	/* CEVAPP- CLOCK EVENT APPLICABLES */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;
	int[] tempint = new int[1];

	public Clockr(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	static final int cndtck[] = new int[] { 50, 20, 10, 5, 0, 156, 156, 156, 157, 0 };
	static final int lmptck[] = new int[] { 50, 30, 20, 10, 4, 0, 154, 154, 154, 154, 155, 0 };

	void cevapp_(int ri)
	{
		/* Initialized data */

		/* System generated locals */
		int i__1, i__2;

		/* Local variables */
		boolean f = false;
		int i = 0, j, bc = 0, br = 0;
		int GOTO = 1000;

		if (ri == 0)
		{
			return;
		}
		/* IGNORE DISABLED. */
		switch (ri)
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
			case 22:
				GOTO = 22000;
				break;
			case 23:
				GOTO = 23000;
				break;
			case 24:
				GOTO = 24000;
				break;
			default:
				game.dsub.game.dsub.bug_(3, ri);
		}

		/* CEV1-- CURE CLOCK. LET PLAYER SLOWLY RECOVER. */
		loop: do
		{
			switch (GOTO)
			{

				case 1000:
					/* Computing MIN */
					i__1 = 0;
					i__2 = vars.advs_1.astren[PLAYER - 1] + 1;
					vars.advs_1.astren[PLAYER - 1] = Math.min(i__1, i__2);
					/* RECOVER. */
					if (vars.advs_1.astren[PLAYER - 1] >= 0)
					{
						return;
					}
					/* FULLY RECOVERED? */
					vars.cevent_1.ctick[vars.cindex_1.cevcur - 1] = 30;
					/* NO, WAIT SOME MORE. */
					return;

				/* CEV2-- MAINT-ROOM WITH LEAK. RAISE THE WATER LEVEL. */
				case 2000:
					if (vars.play_1.here == vars.rindex_1.maint)
					{
						i__1 = vars.findex_1.rvmnt / 2 + 71;
						game.dsub.rspeak_(i__1);
					}
					/* DESCRIBE. */
					++vars.findex_1.rvmnt;
					/* RAISE WATER LEVEL. */
					if (vars.findex_1.rvmnt <= 16)
					{
						return;
					}
					/* IF NOT FULL, EXIT. */
					vars.cevent_1.ctick[vars.cindex_1.cevmnt - 1] = 0;
					/* FULL, DISABLE CLOCK. */
					vars.rooms_1.rflag[vars.rindex_1.maint - 1] |= Vars.RMUNG;
					vars.rooms_1.rrand(vars.rindex_1.maint - 1, 80);
					/* SAY IT IS FULL OF WATER. */
					if (vars.play_1.here == vars.rindex_1.maint)
					{
						game.dsub.jigsup_(81);
					}
					/* DROWN HIM IF PRESENT. */
					return;

				/* CEV3-- LANTERN. DESCRIBE GROWING DIMNESS. */
				case 3000:
					tempint[0] = vars.findex_1.orlamp;
					litint_(vars.oindex_1.lamp, tempint, vars.cindex_1.cevlnt, lmptck, 12);
					vars.findex_1.orlamp = tempint[0];
					/* DO LIGHT INTERRUPT. */
					return;

				/* CEV4-- MATCH. OUT IT GOES. */
				case 4000:
					game.dsub.rspeak_(153);
					/* MATCH IS OUT. */
					vars.objcts_1.oflag1[vars.oindex_1.match - 1] &= ~Vars.ONBT;
					return;

				/* CEV5-- CANDLE. DESCRIBE GROWING DIMNESS. */
				case 5000:
					tempint[0] = vars.findex_1.orcand;
					litint_(vars.oindex_1.candl, tempint, vars.cindex_1.cevcnd, cndtck, 10);
					vars.findex_1.orcand = tempint[0];
					/* DO CANDLE INTERRUPT. */
					return;

				/* CEV6-- BALLOON */
				case 6000:
					vars.cevent_1.ctick[vars.cindex_1.cevbal - 1] = 3;
					/* RESCHEDULE INTERRUPT. */
					f = vars.advs_1.avehic[vars.play_1.winner - 1] == vars.oindex_1.ballo;
					/* SEE IF IN BALLOON. */
					if (vars.state_1.bloc == vars.rindex_1.vlbot)
					{
						GOTO = 6800;
						continue loop;
					}
					/* AT BOTTOM? */
					if (vars.state_1.bloc == vars.rindex_1.ledg2
							|| vars.state_1.bloc == vars.rindex_1.ledg3
							|| vars.state_1.bloc == vars.rindex_1.ledg4
							|| vars.state_1.bloc == vars.rindex_1.vlbot)
					{
						GOTO = 6700;
						continue loop;
					}
					/* ON LEDGE? */
					if ((vars.objcts_1.oflag2[vars.oindex_1.recep - 1] & Vars.OPENBT) != 0
							&& vars.findex_1.binff != 0)
					{
						GOTO = 6500;
						continue loop;
					}

					/* BALLOON IS IN MIDAIR AND IS DEFLATED (OR HAS RECEPTACLE CLOSED). */
					/* FALL TO NEXT ROOM. */

					if (vars.state_1.bloc != vars.rindex_1.vair1)
					{
						GOTO = 6300;
						continue loop;
					}
					/* IN VAIR1? */
					vars.state_1.bloc = vars.rindex_1.vlbot;
					/* YES, NOW AT VLBOT. */
					game.dsub.newsta_(vars.oindex_1.ballo, 0, vars.state_1.bloc, 0, 0);
					if (f)
					{
						GOTO = 6200;
						continue loop;
					}
					/* IN BALLOON? */
					if (vars.play_1.here == vars.rindex_1.ledg2
							|| vars.play_1.here == vars.rindex_1.ledg3
							|| vars.play_1.here == vars.rindex_1.ledg4
							|| vars.play_1.here == vars.rindex_1.vlbot)
					{
						game.dsub.rspeak_(530);
					}
					/* ON LEDGE, DESCRIBE. */
					return;

				case 6200:
					f = game.dso2.moveto_(vars.state_1.bloc, vars.play_1.winner);
					/* MOVE HIM. */
					if (vars.findex_1.binff == 0)
					{
						GOTO = 6250;
						continue loop;
					}
					/* IN BALLOON. INFLATED? */
					game.dsub.rspeak_(531);
					/* YES, LANDED. */
					f = game.dsub.rmdesc_(0);
					/* DESCRIBE. */
					return;

				case 6250:
					game.dsub.newsta_(vars.oindex_1.ballo, 532, 0, 0, 0);
					/* NO, BALLOON & CONTENTS DIE. */
					game.dsub.newsta_(vars.oindex_1.dball, 0, vars.state_1.bloc, 0, 0);
					/* INSERT DEAD BALLOON. */
					vars.advs_1.avehic[vars.play_1.winner - 1] = 0;
					/* NOT IN VEHICLE. */
					vars.cevent_1.cflag[vars.cindex_1.cevbal - 1] = false;
					/* DISABLE INTERRUPTS. */
					vars.cevent_1.cflag[vars.cindex_1.cevbrn - 1] = false;
					vars.findex_1.binff = 0;
					vars.findex_1.btief = 0;
					return;

				case 6300:
					--vars.state_1.bloc;
					/* NOT IN VAIR1, DESCEND. */
					game.dsub.newsta_(vars.oindex_1.ballo, 0, vars.state_1.bloc, 0, 0);
					if (f)
					{
						GOTO = 6400;
						continue loop;
					}
					/* IS HE IN BALLOON? */
					if (vars.play_1.here == vars.rindex_1.ledg2
							|| vars.play_1.here == vars.rindex_1.ledg3
							|| vars.play_1.here == vars.rindex_1.ledg4
							|| vars.play_1.here == vars.rindex_1.vlbot)
					{
						game.dsub.rspeak_(533);
					}
					/* IF ON LEDGE, DESCRIBE. */
					return;

				case 6400:
					f = game.dso2.moveto_(vars.state_1.bloc, vars.play_1.winner);
					/* IN BALLOON, MOVE HIM. */
					game.dsub.rspeak_(534);
					/* DESCRIBE. */
					f = game.dsub.rmdesc_(0);
					return;

				/* BALLOON IS IN MIDAIR AND IS INFLATED, UP-UP-AND-AWAY */
				/*  */

				case 6500:
					if (vars.state_1.bloc != vars.rindex_1.vair4)
					{
						GOTO = 6600;
						continue loop;
					}
					/* AT VAIR4? */
					vars.cevent_1.ctick[vars.cindex_1.cevbrn - 1] = 0;
					vars.cevent_1.ctick[vars.cindex_1.cevbal - 1] = 0;
					vars.findex_1.binff = 0;
					vars.findex_1.btief = 0;
					vars.state_1.bloc = vars.rindex_1.vlbot;
					/* FALL TO BOTTOM. */
					game.dsub.newsta_(vars.oindex_1.ballo, 0, 0, 0, 0);
					/* BALLOON & CONTENTS DIE. */
					game.dsub.newsta_(vars.oindex_1.dball, 0, vars.state_1.bloc, 0, 0);
					/* SUBSTITUTE DEAD BALLOON. */
					if (f)
					{
						GOTO = 6550;
						continue loop;
					}
					/* WAS HE IN IT? */
					if (vars.play_1.here == vars.rindex_1.ledg2
							|| vars.play_1.here == vars.rindex_1.ledg3
							|| vars.play_1.here == vars.rindex_1.ledg4
							|| vars.play_1.here == vars.rindex_1.vlbot)
					{
						game.dsub.rspeak_(535);
					}
					/* IF HE CAN SEE, DESCRIBE. */
					return;

				case 6550:
					game.dsub.jigsup_(536);
					/* IN BALLOON AT CRASH, DIE. */
					return;

				case 6600:
					++vars.state_1.bloc;
					/* NOT AT VAIR4, GO UP. */
					game.dsub.newsta_(vars.oindex_1.ballo, 0, vars.state_1.bloc, 0, 0);
					if (f)
					{
						GOTO = 6650;
						continue loop;
					}
					/* IN BALLOON? */
					if (vars.play_1.here == vars.rindex_1.ledg2
							|| vars.play_1.here == vars.rindex_1.ledg3
							|| vars.play_1.here == vars.rindex_1.ledg4
							|| vars.play_1.here == vars.rindex_1.vlbot)
					{
						game.dsub.rspeak_(537);
					}
					/* CAN HE SEE IT? */
					return;

				case 6650:
					f = game.dso2.moveto_(vars.state_1.bloc, vars.play_1.winner);
					/* MOVE PLAYER. */
					game.dsub.rspeak_(538);
					/* DESCRIBE. */
					f = game.dsub.rmdesc_(0);
					return;

				/* ON LEDGE, GOES TO MIDAIR ROOM WHETHER INFLATED OR NOT. */

				case 6700:
					vars.state_1.bloc += vars.rindex_1.vair2 - vars.rindex_1.ledg2;
					/* MOVE TO MIDAIR. */
					game.dsub.newsta_(vars.oindex_1.ballo, 0, vars.state_1.bloc, 0, 0);
					if (f)
					{
						GOTO = 6750;
						continue loop;
					}
					/* IN BALLOON? */
					if (vars.play_1.here == vars.rindex_1.ledg2
							|| vars.play_1.here == vars.rindex_1.ledg3
							|| vars.play_1.here == vars.rindex_1.ledg4
							|| vars.play_1.here == vars.rindex_1.vlbot)
					{
						game.dsub.rspeak_(539);
					}
					/* NO, STRANDED. */
					vars.cevent_1.ctick[vars.cindex_1.cevvlg - 1] = 10;
					/* MATERIALIZE GNOME. */
					return;

				case 6750:
					f = game.dso2.moveto_(vars.state_1.bloc, vars.play_1.winner);
					/* MOVE TO NEW ROOM. */
					game.dsub.rspeak_(540);
					/* DESCRIBE. */
					f = game.dsub.rmdesc_(0);
					return;

				/* AT BOTTOM, GO UP IF INFLATED, DO NOTHING IF DEFLATED. */

				case 6800:
					if (vars.findex_1.binff == 0 || !((vars.objcts_1.oflag2[vars.oindex_1.recep - 1]
							& Vars.OPENBT) != 0))
					{
						return;
					}
					vars.state_1.bloc = vars.rindex_1.vair1;
					/* INFLATED AND OPEN, */
					game.dsub.newsta_(vars.oindex_1.ballo, 0, vars.state_1.bloc, 0, 0);
					/* GO UP TO VAIR1. */
					if (f)
					{
						GOTO = 6850;
						continue loop;
					}
					/* IN BALLOON? */
					if (vars.play_1.here == vars.rindex_1.ledg2
							|| vars.play_1.here == vars.rindex_1.ledg3
							|| vars.play_1.here == vars.rindex_1.ledg4
							|| vars.play_1.here == vars.rindex_1.vlbot)
					{
						game.dsub.rspeak_(541);
					}
					/* IF CAN SEE, DESCRIBE. */
					return;

				case 6850:
					f = game.dso2.moveto_(vars.state_1.bloc, vars.play_1.winner);
					/* MOVE PLAYER. */
					game.dsub.rspeak_(542);
					f = game.dsub.rmdesc_(0);
					return;
				/* CEVAPP, PAGE 4 */

				/* CEV7-- BALLOON BURNUP */

				case 7000:
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* FIND BURNING OBJECT */
						if (vars.oindex_1.recep == vars.objcts_1.ocan[i - 1]
								&& (vars.objcts_1.oflag1[i - 1] & Vars.FLAMBT) != 0)
						{
							GOTO = 7200;
							continue loop;
						}
						/* case 7100: */
					}
					game.dsub.bug_(4, 0);

				case 7200:
					game.dsub.newsta_(i, 0, 0, 0, 0);
					/* VANISH OBJECT. */
					vars.findex_1.binff = 0;
					/* UNINFLATED. */
					if (vars.play_1.here == vars.state_1.bloc)
					{
						game.dsub.rspsub_(292, vars.objcts_1.odesc2[i - 1]);
					}
					/* DESCRIBE. */
					return;

				/* CEV8-- FUSE FUNCTION */

				case 8000:
					if (vars.objcts_1.ocan[vars.oindex_1.fuse - 1] != vars.oindex_1.brick)
					{
						GOTO = 8500;
						continue loop;
					}
					/* IGNITED BRICK? */
					br = vars.objcts_1.oroom[vars.oindex_1.brick - 1];
					/* GET BRICK ROOM. */
					bc = vars.objcts_1.ocan[vars.oindex_1.brick - 1];
					/* GET CONTAINER. */
					if (br == 0 && bc != 0)
					{
						br = vars.objcts_1.oroom[bc - 1];
					}
					game.dsub.newsta_(vars.oindex_1.fuse, 0, 0, 0, 0);
					/* KILL FUSE. */
					game.dsub.newsta_(vars.oindex_1.brick, 0, 0, 0, 0);
					/* KILL BRICK. */
					if (br != 0 && br != vars.play_1.here)
					{
						GOTO = 8100;
						continue loop;
					}
					/* BRICK ELSEWHERE? */

					vars.rooms_1.rflag[vars.play_1.here - 1] |= Vars.RMUNG;
					vars.rooms_1.rrand(vars.play_1.here - 1, 114);
					/* MUNG ROOM. */
					game.dsub.jigsup_(150);
					/* DEAD. */
					return;

				case 8100:
					game.dsub.rspeak_(151);
					/* BOOM. */
					vars.state_1.mungrm = br;
					/* SAVE ROOM THAT BLEW. */
					vars.cevent_1.ctick[vars.cindex_1.cevsaf - 1] = 5;
					/* SET SAFE INTERRUPT. */
					if (br != vars.rindex_1.msafe)
					{
						GOTO = 8200;
						continue loop;
					}
					/* BLEW SAFE ROOM? */
					if (bc != vars.oindex_1.sslot)
					{
						return;
					}
					/* WAS BRICK IN SAFE? */
					game.dsub.newsta_(vars.oindex_1.sslot, 0, 0, 0, 0);
					/* KILL SLOT. */
					vars.objcts_1.oflag2[vars.oindex_1.safe - 1] |= Vars.OPENBT;
					vars.findex_1.safef = true;
					/* INDICATE SAFE BLOWN. */
					return;

				case 8200:
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* BLEW WRONG ROOM. */
						if (game.dsub.qhere_(i, br)
								&& (vars.objcts_1.oflag1[i - 1] & Vars.TAKEBT) != 0)
						{
							game.dsub.newsta_(i, 0, 0, 0, 0);
						}
						/* case 8250: */
					}
					if (br != vars.rindex_1.lroom)
					{
						return;
					}
					/* BLEW LIVING ROOM? */
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						if (vars.objcts_1.ocan[i - 1] == vars.oindex_1.tcase)
						{
							game.dsub.newsta_(i, 0, 0, 0, 0);
						}
						/* KILL TROPHY CASE. */
						/* case 8300: */
					}
					return;

				case 8500:
					if (game.dsub.qhere_(vars.oindex_1.fuse, vars.play_1.here)
							|| vars.objcts_1.oadv[vars.oindex_1.fuse - 1] == vars.play_1.winner)
					{
						game.dsub.rspeak_(152);
					}
					game.dsub.newsta_(vars.oindex_1.fuse, 0, 0, 0, 0);
					/* KILL FUSE. */
					return;
				/* CEVAPP, PAGE 5 */

				/* CEV9-- LEDGE MUNGE. */

				case 9000:
					vars.rooms_1.rflag[vars.rindex_1.ledg4 - 1] |= Vars.RMUNG;
					vars.rooms_1.rrand(vars.rindex_1.ledg4 - 1, 109);
					if (vars.play_1.here == vars.rindex_1.ledg4)
					{
						GOTO = 9100;
						continue loop;
					}
					/* WAS HE THERE? */
					game.dsub.rspeak_(110);
					/* NO, NARROW ESCAPE. */
					return;

				case 9100:
					if (vars.advs_1.avehic[vars.play_1.winner - 1] != 0)
					{
						GOTO = 9200;
						continue loop;
					}
					/* IN VEHICLE? */
					game.dsub.jigsup_(111);
					/* NO, DEAD. */
					return;

				case 9200:
					if (vars.findex_1.btief != 0)
					{
						GOTO = 9300;
						continue loop;
					}
					/* TIED TO LEDGE? */
					game.dsub.rspeak_(112);
					/* NO, NO PLACE TO LAND. */
					return;

				case 9300:
					vars.state_1.bloc = vars.rindex_1.vlbot;
					/* YES, CRASH BALLOON. */
					game.dsub.newsta_(vars.oindex_1.ballo, 0, 0, 0, 0);
					/* BALLOON & CONTENTS DIE. */
					game.dsub.newsta_(vars.oindex_1.dball, 0, vars.state_1.bloc, 0, 0);
					/* INSERT DEAD BALLOON. */
					vars.findex_1.btief = 0;
					vars.findex_1.binff = 0;
					vars.cevent_1.cflag[vars.cindex_1.cevbal - 1] = false;
					vars.cevent_1.cflag[vars.cindex_1.cevbrn - 1] = false;
					game.dsub.jigsup_(113);
					/* DEAD */
					return;

				/* CEV10-- SAFE MUNG. */

				case 10000:
					vars.rooms_1.rflag[vars.state_1.mungrm - 1] |= Vars.RMUNG;
					vars.rooms_1.rrand(vars.state_1.mungrm - 1, 114);
					if (vars.play_1.here == vars.state_1.mungrm)
					{
						GOTO = 10100;
						continue loop;
					}
					/* IS HE PRESENT? */
					game.dsub.rspeak_(115);
					/* LET HIM KNOW. */
					if (vars.state_1.mungrm == vars.rindex_1.msafe)
					{
						vars.cevent_1.ctick[vars.cindex_1.cevled - 1] = 8;
					}
					/* START LEDGE CLOCK. */
					return;

				case 10100:
					i = 116;
					/* HE'S DEAD, */
					if ((vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RHOUSE) != 0)
					{
						i = 117;
					}
					game.dsub.jigsup_(i);
					/* LET HIM KNOW. */
					return;
				/* CEVAPP, PAGE 6 */

				/* CEV11-- VOLCANO GNOME */

				case 11000:
					if (vars.play_1.here == vars.rindex_1.ledg2
							|| vars.play_1.here == vars.rindex_1.ledg3
							|| vars.play_1.here == vars.rindex_1.ledg4
							|| vars.play_1.here == vars.rindex_1.vlbot)
					{
						GOTO = 11100;
						continue loop;
					}
					/* IS HE ON LEDGE? */
					vars.cevent_1.ctick[vars.cindex_1.cevvlg - 1] = 1;
					/* NO, WAIT A WHILE. */
					return;

				case 11100:
					game.dsub.newsta_(vars.oindex_1.gnome, 118, vars.play_1.here, 0, 0);
					/* YES, MATERIALIZE GNOME. */
					return;

				/* CEV12-- VOLCANO GNOME DISAPPEARS */

				case 12000:
					game.dsub.newsta_(vars.oindex_1.gnome, 149, 0, 0, 0);
					/* DISAPPEAR THE GNOME. */
					return;

				/* CEV13-- BUCKET. */

				case 13000:
					if (vars.objcts_1.ocan[vars.oindex_1.water - 1] == vars.oindex_1.bucke)
					{
						game.dsub.newsta_(vars.oindex_1.water, 0, 0, 0, 0);
					}
					return;

				/* CEV14-- SPHERE. IF EXPIRES, HE'S TRAPPED. */

				case 14000:
					vars.rooms_1.rflag[vars.rindex_1.cager - 1] |= Vars.RMUNG;
					vars.rooms_1.rrand(vars.rindex_1.cager - 1, 147);
					game.dsub.jigsup_(148);
					/* MUNG PLAYER. */
					return;

				/* CEV15-- END GAME HERALD. */

				case 15000:
					vars.findex_1.endgmf = true;
					/* WE'RE IN ENDGAME. */
					game.dsub.rspeak_(119);
					/* INFORM OF ENDGAME. */
					return;
				/* CEVAPP, PAGE 7 */

				/* CEV16-- FOREST MURMURS */

				case 16000:
					vars.cevent_1.cflag[vars.cindex_1.cevfor
							- 1] = vars.play_1.here == vars.rindex_1.mtree
									|| vars.play_1.here >= vars.rindex_1.fore1
											&& vars.play_1.here < vars.rindex_1.clear;
					if (vars.cevent_1.cflag[vars.cindex_1.cevfor - 1] && game.dsub.prob_(10, 10))
					{
						game.dsub.rspeak_(635);
					}
					return;

				/* CEV17-- SCOL ALARM */

				case 17000:
					if (vars.play_1.here == vars.rindex_1.bktwi)
					{
						vars.cevent_1.cflag[vars.cindex_1.cevzgi - 1] = true;
					}
					/* IF IN TWI, GNOME. */
					if (vars.play_1.here == vars.rindex_1.bkvau)
					{
						game.dsub.jigsup_(636);
					}
					/* IF IN VAU, DEAD. */
					return;

				/* CEV18-- ENTER GNOME OF ZURICH */

				case 18000:
					vars.cevent_1.cflag[vars.cindex_1.cevzgo - 1] = true;
					/* EXITS, TOO. */
					game.dsub.newsta_(vars.oindex_1.zgnom, 0, vars.rindex_1.bktwi, 0, 0);
					/* PLACE IN TWI. */
					if (vars.play_1.here == vars.rindex_1.bktwi)
					{
						game.dsub.rspeak_(637);
					}
					/* ANNOUNCE. */
					return;

				/* CEV19-- EXIT GNOME */

				case 19000:
					game.dsub.newsta_(vars.oindex_1.zgnom, 0, 0, 0, 0);
					/* VANISH. */
					if (vars.play_1.here == vars.rindex_1.bktwi)
					{
						game.dsub.rspeak_(638);
					}
					/* ANNOUNCE. */
					return;
				/* CEVAPP, PAGE 8 */

				/* CEV20-- START OF ENDGAME */

				case 20000:
					if (vars.findex_1.spellf)
					{
						GOTO = 20200;
						continue loop;
					}
					/* SPELL HIS WAY IN? */
					if (vars.play_1.here != vars.rindex_1.crypt)
					{
						return;
					}
					/* NO, STILL IN TOMB? */
					if (!game.dso5.lit_(vars.play_1.here))
					{
						GOTO = 20100;
						continue loop;
					}
					/* LIGHTS OFF? */
					vars.cevent_1.ctick[vars.cindex_1.cevste - 1] = 3;
					/* RESCHEDULE. */
					return;

				case 20100:
					game.dsub.rspeak_(727);
					/* ANNOUNCE. */
				case 20200:
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* STRIP HIM OF OBJS. */
						game.dsub.newsta_(i, 0, vars.objcts_1.oroom[i - 1],
								vars.objcts_1.ocan[i - 1], 0);
						/* case 20300: */
					}
					game.dsub.newsta_(vars.oindex_1.lamp, 0, 0, 0, PLAYER);
					/* GIVE HIM LAMP. */
					game.dsub.newsta_(vars.oindex_1.sword, 0, 0, 0, PLAYER);
					/* GIVE HIM SWORD. */

					vars.objcts_1.oflag1[vars.oindex_1.lamp
							- 1] = (vars.objcts_1.oflag1[vars.oindex_1.lamp - 1] | Vars.LITEBT)
									& ~Vars.ONBT;
					vars.objcts_1.oflag2[vars.oindex_1.lamp - 1] |= Vars.TCHBT;
					vars.cevent_1.cflag[vars.cindex_1.cevlnt - 1] = false;
					/* LAMP IS GOOD AS NEW. */
					vars.cevent_1.ctick[vars.cindex_1.cevlnt - 1] = 350;
					vars.findex_1.orlamp = 0;
					vars.objcts_1.oflag2[vars.oindex_1.sword - 1] |= Vars.TCHBT;
					vars.hack_1.swdact = true;
					vars.hack_1.swdsta = 0;

					vars.hack_1.thfact = false;
					/* THIEF GONE. */
					vars.findex_1.endgmf = true;
					/* ENDGAME RUNNING. */
					vars.cevent_1.cflag[vars.cindex_1.cevmat - 1] = false;
					/* MATCHES GONE, */
					vars.cevent_1.cflag[vars.cindex_1.cevcnd - 1] = false;
					/* CANDLES GONE. */

					game.dso2.scrupd_(vars.rooms_1.rval[vars.rindex_1.crypt - 1]);
					/* SCORE CRYPT, */
					vars.rooms_1.rval[vars.rindex_1.crypt - 1] = 0;
					/* BUT ONLY ONCE. */
					f = game.dso2.moveto_(vars.rindex_1.tstrs, vars.play_1.winner);
					/* TO TOP OF STAIRS, */
					f = game.dsub.rmdesc_(3);
					/* AND DESCRIBE. */
					return;
				/* BAM */
				/*  */

				/* CEV21-- MIRROR CLOSES. */

				case 21000:
					vars.findex_1.mrpshf = false;
					/* BUTTON IS OUT. */
					vars.findex_1.mropnf = false;
					/* MIRROR IS CLOSED. */
					if (vars.play_1.here == vars.rindex_1.mrant)
					{
						game.dsub.rspeak_(728);
					}
					/* DESCRIBE BUTTON. */
					if (vars.play_1.here == vars.rindex_1.inmir
							|| game.dso6.mrhere_(vars.play_1.here) == 1)
					{
						game.dsub.rspeak_(729);
					}
					return;
				/* CEVAPP, PAGE 9 */

				/* CEV22-- DOOR CLOSES. */

				case 22000:
					if (vars.findex_1.wdopnf)
					{
						game.dsub.rspeak_(730);
					}
					/* DESCRIBE. */
					vars.findex_1.wdopnf = false;
					/* CLOSED. */
					return;

				/* CEV23-- INQUISITOR'S QUESTION */

				case 23000:
					if (vars.advs_1.aroom[PLAYER - 1] != vars.rindex_1.fdoor)
					{
						return;
					}
					/* IF PLAYER LEFT, DIE. */
					game.dsub.rspeak_(769);
					i__1 = vars.findex_1.quesno + 770;
					game.dsub.rspeak_(i__1);
					vars.cevent_1.ctick[vars.cindex_1.cevinq - 1] = 2;
					return;

				/* CEV24-- MASTER FOLLOWS */

				case 24000:
					if (vars.advs_1.aroom[MASTER - 1] == vars.play_1.here)
					{
						return;
					}
					/* NO MOVEMENT, DONE. */
					if (vars.play_1.here != vars.rindex_1.cell
							&& vars.play_1.here != vars.rindex_1.pcell)
					{
						GOTO = 24100;
						continue loop;
					}
					if (vars.findex_1.follwf)
					{
						game.dsub.rspeak_(811);
					}
					/* WONT GO TO CELLS. */
					vars.findex_1.follwf = false;
					return;

				case 24100:
					vars.findex_1.follwf = true;
					/* FOLLOWING. */
					i = 812;
					/* ASSUME CATCHES UP. */
					i__1 = vars.xsrch_1.xmax;
					i__2 = vars.xsrch_1.xmin;
					for (j = vars.xsrch_1.xmin; i__2 < 0 ? j >= i__1 : j <= i__1; j += i__2)
					{
						if (game.dso3.findxt_(j, vars.advs_1.aroom[MASTER - 1])
								&& vars.curxt_1.xroom1 == vars.play_1.here)
						{
							i = 813;
						}
						/* case 24200: */
					}
					game.dsub.rspeak_(i);
					game.dsub.newsta_(vars.oindex_1.master, 0, vars.play_1.here, 0, 0);
					/* MOVE MASTER OBJECT. */
					vars.advs_1.aroom[MASTER - 1] = vars.play_1.here;
					/* MOVE MASTER PLAYER. */
					return;
			}
		} while (true);
	} /* cevapp_ */

	/* LITINT- LIGHT INTERRUPT PROCESSOR */
	private void litint_(int obj, int ctr[], int cev, final int ticks[], int tickln)
	{
		// TODO: Light seems to be dim - need to fix?? //
		/* Parameter adjustments */
//	   --ticks;
//		ticks[0] -= 1;

		/* Function Body */
//	   ++(*ctr);
		ctr[0] += 1;
		/* ADVANCE STATE CNTR. */
		vars.cevent_1.ctick[cev - 1] = ticks[ctr[0] - 1];
		/* RESET INTERRUPT. */
		if (vars.cevent_1.ctick[cev - 1] != 0)
		{
			if (vars.objcts_1.oroom[obj - 1] == vars.play_1.here
					|| vars.objcts_1.oadv[obj - 1] == vars.play_1.winner)
			{
				game.dsub.rspeak_(ticks[ctr[0] + tickln / 2]);
			}
			return;
		}
		/* EXPIRED? */
		vars.objcts_1.oflag1[obj - 1] &= ~(Vars.LITEBT + Vars.FLAMBT + Vars.ONBT);
		if (vars.objcts_1.oroom[obj - 1] == vars.play_1.here
				|| vars.objcts_1.oadv[obj - 1] == vars.play_1.winner)
		{
			game.dsub.rspsub_(293, vars.objcts_1.odesc2[obj - 1]);
		}
		return;

	} /* litint_ */

}
