package zork;

public class Sobjs implements Actions
{
	/* SOBJS- SIMPLE OBJECTS PROCESSOR */
	/* OBJECTS IN THIS MODULE CANNOT CALL RMINFO, JIGSUP, */
	/* MAJOR VERBS, OR OTHER NON-RESIDENT SUBROUTINES */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Sobjs(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean sobjs_(int ri, int arg)
	{
		/* System generated locals */
		int i__1;
		boolean ret_val;

		/* Local variables */
		int i;
		int mroom;
		int av;
		int odi2 = 0, odo2 = 0;

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
		ret_val = true;

		int GOTO = 10;

		switch (ri)
		{
			case 1:
				GOTO = 1000;
				break;
			case 2:
				GOTO = 3000;
				break;
			case 3:
				GOTO = 4000;
				break;
			case 4:
				GOTO = 6000;
				break;
			case 5:
				GOTO = 7000;
				break;
			case 6:
				GOTO = 8000;
				break;
			case 7:
				GOTO = 9000;
				break;
			case 8:
				GOTO = 13000;
				break;
			case 9:
				GOTO = 14000;
				break;
			case 10:
				GOTO = 16000;
				break;
			case 11:
				GOTO = 17000;
				break;
			case 12:
				GOTO = 21000;
				break;
			case 13:
				GOTO = 23000;
				break;
			case 14:
				GOTO = 24000;
				break;
			case 15:
				GOTO = 27000;
				break;
			case 16:
				GOTO = 28000;
				break;
			case 17:
				GOTO = 29000;
				break;
			case 18:
				GOTO = 30000;
				break;
			case 19:
				GOTO = 31000;
				break;
			case 20:
				GOTO = 33000;
				break;
			case 21:
				GOTO = 34000;
				break;
			case 22:
				GOTO = 36000;
				break;
			case 23:
				GOTO = 37000;
				break;
			case 24:
				GOTO = 38000;
				break;
			case 25:
				GOTO = 41000;
				break;
			case 26:
				GOTO = 42000;
				break;
			case 27:
				GOTO = 43000;
				break;
			case 28:
				GOTO = 44000;
				break;
			case 29:
				GOTO = 46000;
				break;
			case 30:
				GOTO = 53000;
				break;
			case 31:
				GOTO = 56000;
				break;
			default:
				game.dsub.bug_(6, ri);
				break;
		}

		if (GOTO == 10)
			return false;
//	/* RETURN HERE TO DECLARE FALSE RESULT */
//
//	case 10:
//	    ret_val = false;
//	    return ret_val;
//	/* SOBJS, PAGE 3 */
//
//	/* O1--	GUNK FUNCTION */
//
		loop: do
		{
			switch (GOTO)
			{
				case 1000:
					if (vars.objcts_1.ocan[vars.oindex_1.gunk - 1] == 0)
					{
						return false;
					}
					/* NOT INSIDE? F */
					game.dsub.newsta_(vars.oindex_1.gunk, 122, 0, 0, 0);
					/* FALLS APART. */
					return ret_val;

				/* O2-- TROPHY CASE */

				case 3000:
					if (vars.prsvec_1.prsa != TAKE)
					{
						return false;
					}
					/* TAKE? */
					game.dsub.rspeak_(128);
					/* CANT. */
					return ret_val;

				/* O3-- BOTTLE FUNCTION */

				case 4000:
					if (vars.prsvec_1.prsa != THROW)
					{
						GOTO = 4100;
						continue loop;
					}
					/* THROW? */
					game.dsub.newsta_(vars.prsvec_1.prso, 129, 0, 0, 0);
					/* BREAKS. */
					return ret_val;

				case 4100:
					if (vars.prsvec_1.prsa != MUNG)
					{
						return false;
					}
					/* MUNG? */
					game.dsub.newsta_(vars.prsvec_1.prso, 131, 0, 0, 0);
					/* BREAKS. */
					return ret_val;
				/* SOBJS, PAGE 4 */

				/* O4-- ROPE FUNCTION */

				case 6000:
					if (vars.play_1.here == vars.rindex_1.dome)
					{
						GOTO = 6100;
						continue loop;
					}
					/* IN DOME? */
					vars.findex_1.domef = false;
					/* NO, */
					if (vars.prsvec_1.prsa != UNTIE)
					{
						GOTO = 6050;
						continue loop;
					}
					/* UNTIE? */
					game.dsub.rspeak_(134);
					/* CANT */
					return ret_val;

				case 6050:
					if (vars.prsvec_1.prsa != TIE)
					{
						return false;
					}
					/* TIE? */
					game.dsub.rspeak_(135);
					/* CANT TIE */
					return ret_val;

				case 6100:
					if (vars.prsvec_1.prsa != TIE
							|| vars.prsvec_1.prsi != vars.oindex_1.raili)
					{
						GOTO = 6200;
						continue loop;
					}
					if (vars.findex_1.domef)
					{
						GOTO = 6150;
						continue loop;
					}
					/* ALREADY TIED? */
					vars.findex_1.domef = true;
					/* NO, TIE IT. */
					vars.objcts_1.oflag1[vars.oindex_1.rope - 1] |= Vars.NDSCBT;
					vars.objcts_1.oflag2[vars.oindex_1.rope - 1] |= Vars.CLMBBT;
					game.dsub.newsta_(vars.oindex_1.rope, 137, vars.rindex_1.dome, 0, 0);
					return ret_val;

				case 6150:
					game.dsub.rspeak_(136);
					/* DUMMY. */
					return ret_val;

				case 6200:
					if (vars.prsvec_1.prsa != UNTIE)
					{
						GOTO = 6300;
						continue loop;
					}
					/* UNTIE? */
					if (vars.findex_1.domef)
					{
						GOTO = 6250;
						continue loop;
					}
					/* TIED? */
					game.dsub.rspeak_(134);
					/* NO, DUMMY. */
					return ret_val;

				case 6250:
					vars.findex_1.domef = false;
					/* YES, UNTIE IT. */
					vars.objcts_1.oflag1[vars.oindex_1.rope - 1] &= ~Vars.NDSCBT;
					vars.objcts_1.oflag2[vars.oindex_1.rope - 1] &= ~Vars.CLMBBT;
					game.dsub.rspeak_(139);
					return ret_val;

				case 6300:
					if (vars.findex_1.domef || vars.prsvec_1.prsa != DROP)
					{
						GOTO = 6400;
						continue loop;
					}
					/* DROP & UNTIED? */
					game.dsub.newsta_(vars.oindex_1.rope, 140, vars.rindex_1.mtorc, 0, 0);
					/* YES, DROP. */
					return ret_val;

				case 6400:
					if (vars.prsvec_1.prsa != TAKE || !vars.findex_1.domef)
					{
						return false;
					}
					game.dsub.rspeak_(141);
					/* TAKE & TIED. */
					return ret_val;

				/* O5-- SWORD FUNCTION */

				case 7000:
					if (vars.prsvec_1.prsa == TAKE
							&& vars.play_1.winner == vars.aindex_1.player)
					{

						vars.hack_1.swdact = true;
					}
					return false;

				/* O6-- LANTERN */

				case 8000:
					if (vars.prsvec_1.prsa != THROW)
					{
						GOTO = 8100;
						continue loop;
					}
					/* THROW? */
					game.dsub.newsta_(vars.oindex_1.lamp, 0, 0, 0, 0);
					/* KILL LAMP, */
					game.dsub.newsta_(vars.oindex_1.blamp, 142, vars.play_1.here, 0, 0);
					/* REPLACE WITH BROKEN. */
					return ret_val;

				case 8100:
					if (vars.prsvec_1.prsa == TURN_ON)
					{
						vars.cevent_1.cflag[vars.cindex_1.cevlnt - 1] = true;
					}
					if (vars.prsvec_1.prsa == TURN_OFF)
					{
						vars.cevent_1.cflag[vars.cindex_1.cevlnt - 1] = false;
					}
					return false;

				/* O7-- RUG FUNCTION */

				case 9000:
					if (vars.prsvec_1.prsa != RAISE)
					{
						GOTO = 9100;
						continue loop;
					}
					/* RAISE? */
					game.dsub.rspeak_(143);
					/* CANT */
					return ret_val;

				case 9100:
					if (vars.prsvec_1.prsa != TAKE)
					{
						GOTO = 9200;
						continue loop;
					}
					/* TAKE? */
					game.dsub.rspeak_(144);
					/* CANT */
					return ret_val;

				case 9200:
					if (vars.prsvec_1.prsa != MOVE)
					{
						GOTO = 9300;
						continue loop;
					}
					/* MOVE? */
					i__1 = vars.findex_1.orrug + 145;
					game.dsub.rspeak_(i__1);
					vars.findex_1.orrug = 1;
					vars.objcts_1.oflag1[vars.oindex_1.door - 1] |= Vars.VISIBT;
					return ret_val;

				case 9300:
					if (vars.prsvec_1.prsa != LOOK_UNDER || vars.findex_1.orrug != 0
							|| (vars.objcts_1.oflag2[vars.oindex_1.door - 1] & Vars.OPENBT) != 0)
					{
						return false;
					}
					game.dsub.rspeak_(345);
					return ret_val;
				/* SOBJS, PAGE 5 */

				/* O8-- SKELETON */

				case 13000:
					i = game.dso4.robrm_(vars.play_1.here, 100, vars.rindex_1.lld2, 0, 0)
							+ game.dso4.robadv_(vars.play_1.winner, vars.rindex_1.lld2, 0, 0);
					if (i != 0)
					{
						game.dsub.rspeak_(162);
					}
					/* IF ROBBED, SAY SO. */
					return ret_val;

				/* O9-- MIRROR */

				case 14000:
					if (vars.findex_1.mirrmf || vars.prsvec_1.prsa != RUB)
					{
						GOTO = 14500;
						continue loop;
					}
					mroom = vars.play_1.here ^ 1;
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* INTERCHANGE OBJS. */
						if (vars.objcts_1.oroom[i - 1] == vars.play_1.here)
						{
							vars.objcts_1.oroom[i - 1] = -1;
						}
						if (vars.objcts_1.oroom[i - 1] == mroom)
						{
							vars.objcts_1.oroom[i - 1] = vars.play_1.here;
						}
						if (vars.objcts_1.oroom[i - 1] == -1)
						{
							vars.objcts_1.oroom[i - 1] = mroom;
						}
						/* case 14100: */
					}
					game.dso2.moveto_(mroom, vars.play_1.winner);
					game.dsub.rspeak_(163);
					/* SHAKE WORLD. */
					return ret_val;

				case 14500:
					if (vars.prsvec_1.prsa != LOOK
							&& vars.prsvec_1.prsa != LOOK_IN
							&& vars.prsvec_1.prsa != EXAMINE)
					{
						GOTO = 14600;
						continue loop;
					}
					i = 164;
					/* MIRROR OK. */
					if (vars.findex_1.mirrmf)
					{
						i = 165;
					}
					/* MIRROR DEAD. */
					game.dsub.rspeak_(i);
					return ret_val;

				case 14600:
					if (vars.prsvec_1.prsa != TAKE)
					{
						GOTO = 14700;
						continue loop;
					}
					/* TAKE? */
					game.dsub.rspeak_(166);
					/* JOKE. */
					return ret_val;

				case 14700:
					if (vars.prsvec_1.prsa != MUNG
							&& vars.prsvec_1.prsa != THROW)
					{

						return false;
					}
					i = 167;
					/* MIRROR BREAKS. */
					if (vars.findex_1.mirrmf)
					{
						i = 168;
					}
					/* MIRROR ALREADY BROKEN. */
					vars.findex_1.mirrmf = true;
					vars.findex_1.badlkf = true;
					game.dsub.rspeak_(i);
					return ret_val;
				/* SOBJS, PAGE 6 */

				/* O10-- DUMBWAITER */

				case 16000:
					if (vars.prsvec_1.prsa != RAISE)
					{
						GOTO = 16100;
						continue loop;
					}
					/* RAISE? */
					if (vars.findex_1.cagetf)
					{
						GOTO = 16400;
						continue loop;
					}
					/* ALREADY AT TOP? */
					game.dsub.newsta_(vars.oindex_1.tbask, 175, vars.rindex_1.tshaf, 0, 0);
					/* NO, RAISE BASKET. */
					game.dsub.newsta_(vars.oindex_1.fbask, 0, vars.rindex_1.bshaf, 0, 0);
					vars.findex_1.cagetf = true;
					/* AT TOP. */
					return ret_val;

				case 16100:
					if (vars.prsvec_1.prsa != LOWER)
					{
						GOTO = 16200;
						continue loop;
					}
					/* LOWER? */
					if (!vars.findex_1.cagetf)
					{
						GOTO = 16400;
						continue loop;
					}
					/* ALREADY AT BOTTOM? */
					game.dsub.newsta_(vars.oindex_1.tbask, 176, vars.rindex_1.bshaf, 0, 0);
					/* NO, LOWER BASKET. */
					game.dsub.newsta_(vars.oindex_1.fbask, 0, vars.rindex_1.tshaf, 0, 0);
					vars.findex_1.cagetf = false;
					if (!game.dso5.lit_(vars.play_1.here))
					{
						game.dsub.rspeak_(406);
					}
					/* IF DARK, DIE. */
					return ret_val;

				case 16200:
					if (vars.prsvec_1.prso != vars.oindex_1.fbask
							&& vars.prsvec_1.prsi != vars.oindex_1.fbask)
					{
						GOTO = 16300;
						continue loop;
					}
					game.dsub.rspeak_(130);
					/* WRONG BASKET. */
					return ret_val;

				case 16300:
					if (vars.prsvec_1.prsa != TAKE)
					{
						return false;
					}
					/* TAKE? */
					game.dsub.rspeak_(177);
					/* JOKE. */
					return ret_val;

				case 16400:
					i__1 = Supp.rnd_(3) + 125;
					game.dsub.rspeak_(i__1);
					/* DUMMY. */
					return ret_val;

				/* O11-- GHOST FUNCTION */

				case 17000:
					i = 178;
					/* ASSUME DIRECT. */
					if (vars.prsvec_1.prso != vars.oindex_1.ghost)
					{
						i = 179;
					}
					/* IF NOT, INDIRECT. */
					game.dsub.rspeak_(i);
					return ret_val;
				/* SPEAK AND EXIT. */
				/* SOBJS, PAGE 7 */

				/* O12-- TUBE */

				case 21000:
					if (vars.prsvec_1.prsa != PUT
							|| vars.prsvec_1.prsi != vars.oindex_1.tube)
					{
						return false;
					}
					game.dsub.rspeak_(186);
					/* CANT PUT BACK IN. */
					return ret_val;

				/* O13-- CHALICE */

				case 23000:
					if (vars.prsvec_1.prsa != TAKE
							|| vars.objcts_1.ocan[vars.prsvec_1.prso - 1] != 0
							|| vars.objcts_1.oroom[vars.prsvec_1.prso - 1] != vars.rindex_1.treas
							|| vars.objcts_1.oroom[vars.oindex_1.thief - 1] != vars.rindex_1.treas
							|| (vars.objcts_1.oflag2[vars.oindex_1.thief - 1] & Vars.FITEBT) == 0
							|| !vars.hack_1.thfact)
					{
						return false;
					}
					game.dsub.rspeak_(204);
					/* CANT TAKE. */
					return ret_val;

				/* O14-- PAINTING */

				case 24000:
					if (vars.prsvec_1.prsa != MUNG)
					{
						return false;
					}
					/* MUNG? */
					game.dsub.rspeak_(205);
					/* DESTROY PAINTING. */
					vars.objcts_1.ofval[vars.prsvec_1.prso - 1] = 0;
					vars.objcts_1.otval[vars.prsvec_1.prso - 1] = 0;
					vars.objcts_1.odesc1[vars.prsvec_1.prso - 1] = 207;
					vars.objcts_1.odesc2[vars.prsvec_1.prso - 1] = 206;
					return ret_val;
				/* SOBJS, PAGE 8 */

				/* O15-- BOLT */

				case 27000:
					if (vars.prsvec_1.prsa != TURN)
					{
						return false;
					}
					/* TURN BOLT? */
					if (vars.prsvec_1.prsi != vars.oindex_1.wrenc)
					{
						GOTO = 27500;
						continue loop;
					}
					/* WITH WRENCH? */
					if (vars.findex_1.gatef)
					{
						GOTO = 27100;
						continue loop;
					}
					/* PROPER BUTTON PUSHED? */
					game.dsub.rspeak_(210);
					/* NO, LOSE. */
					return ret_val;

				case 27100:
					if (vars.findex_1.lwtidf)
					{
						GOTO = 27200;
						continue loop;
					}
					/* LOW TIDE NOW? */
					vars.findex_1.lwtidf = true;
					/* NO, EMPTY DAM. */
					game.dsub.rspeak_(211);
					vars.objcts_1.oflag2[vars.oindex_1.coffi - 1] &= ~Vars.SCRDBT;
					vars.objcts_1.oflag1[vars.oindex_1.trunk - 1] |= Vars.VISIBT;
					vars.rooms_1.rflag[vars.rindex_1.reser
							- 1] = (vars.rooms_1.rflag[vars.rindex_1.reser - 1] | Vars.RLAND)
									& ~(Vars.RWATER + Vars.RSEEN);
					return ret_val;

				case 27200:
					vars.findex_1.lwtidf = false;
					/* YES, FILL DAM. */
					game.dsub.rspeak_(212);
					if (game.dsub.qhere_(vars.oindex_1.trunk, vars.rindex_1.reser))
					{
						vars.objcts_1.oflag1[vars.oindex_1.trunk - 1] &= ~Vars.VISIBT;
					}
					vars.rooms_1.rflag[vars.rindex_1.reser
							- 1] = (vars.rooms_1.rflag[vars.rindex_1.reser - 1] | Vars.RWATER)
									& ~Vars.RLAND;
					return ret_val;

				case 27500:
					game.dsub.rspsub_(299, odi2);
					/* NOT WITH THAT. */
					return ret_val;

				/* O16-- GRATING */

				case 28000:
					if (vars.prsvec_1.prsa != OPEN
							&& vars.prsvec_1.prsa != CLOSE)
					{

						return false;
					}
					if (vars.findex_1.grunlf)
					{
						GOTO = 28200;
						continue loop;
					}
					/* UNLOCKED? */
					game.dsub.rspeak_(214);
					/* NO, LOCKED. */
					return ret_val;

				case 28200:
					i = 215;
					/* UNLOCKED, VIEW FRM CLR. */
					if (vars.play_1.here != vars.rindex_1.clear)
					{
						i = 216;
					}
					/* VIEW FROM BELOW. */
					ret_val = game.dso5.opncls_(vars.oindex_1.grate, i, 885);
					/* OPEN/CLOSE. */
					vars.rooms_1.rflag[vars.rindex_1.mgrat - 1] &= ~Vars.RLIGHT;
					if ((vars.objcts_1.oflag2[vars.oindex_1.grate - 1] & Vars.OPENBT) != 0)
					{
						vars.rooms_1.rflag[vars.rindex_1.mgrat - 1] |= Vars.RLIGHT;
					}
					if (!game.dso5.lit_(vars.play_1.here))
					{
						game.dsub.rspeak_(406);
					}
					/* IF DARK, DIE. */
					return ret_val;

				/* O17-- TRAP DOOR */

				case 29000:
					if (vars.play_1.here != vars.rindex_1.lroom)
					{
						GOTO = 29100;
						continue loop;
					}
					/* FROM LIVING ROOM? */
					ret_val = game.dso5.opncls_(vars.oindex_1.door, 218, 219);
					/* OPEN/CLOSE. */
					return ret_val;

				case 29100:
					if (vars.play_1.here != vars.rindex_1.cella)
					{
						return false;
					}
					/* FROM CELLAR? */
					if (vars.prsvec_1.prsa != OPEN
							|| (vars.objcts_1.oflag2[vars.oindex_1.door - 1] & Vars.OPENBT) != 0)
					{
						GOTO = 29200;
						continue loop;
					}
					game.dsub.rspeak_(220);
					/* CANT OPEN CLOSED DOOR. */
					return ret_val;

				case 29200:
					ret_val = game.dso5.opncls_(vars.oindex_1.door, 0, 22);
					/* NORMAL OPEN/CLOSE. */
					return ret_val;

				/* O18-- DURABLE DOOR */

				case 30000:
					i = 0;
					/* ASSUME NO APPL. */
					if (vars.prsvec_1.prsa == OPEN)
					{
						i = 221;
					}
					/* OPEN? */
					if (vars.prsvec_1.prsa == BURN)
					{
						i = 222;
					}
					/* BURN? */
					if (vars.prsvec_1.prsa == MUNG)
					{
						i = Supp.rnd_(3) + 223;
					}
					/* MUNG? */
					if (i == 0)
					{
						return false;
					}
					game.dsub.rspeak_(i);
					return ret_val;

				/* O19-- MASTER SWITCH */

				case 31000:
					if (vars.prsvec_1.prsa != TURN)
					{
						return false;
					}
					/* TURN? */
					if (vars.prsvec_1.prsi != vars.oindex_1.screw)
					{
						GOTO = 31500;
						continue loop;
					}
					/* WITH SCREWDRIVER? */
					if ((vars.objcts_1.oflag2[vars.oindex_1.machi - 1] & Vars.OPENBT) != 0)
					{
						GOTO = 31600;
						continue loop;
					}
					/* LID UP? */
					game.dsub.rspeak_(226);
					/* NO, ACTIVATE. */
					if (vars.objcts_1.ocan[vars.oindex_1.coal - 1] != vars.oindex_1.machi)
					{
						GOTO = 31400;
						continue loop;
					}
					/* COAL INSIDE? */
					game.dsub.newsta_(vars.oindex_1.coal, 0, 0, 0, 0);
					/* KILL COAL, */
					game.dsub.newsta_(vars.oindex_1.diamo, 0, 0, vars.oindex_1.machi, 0);
					/* REPLACE WITH DIAMOND. */
					return ret_val;

				case 31400:
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* KILL NONCOAL OBJECTS. */
						if (vars.objcts_1.ocan[i - 1] != vars.oindex_1.machi)
						{
							continue;
						}
						/* INSIDE MACHINE? */
						game.dsub.newsta_(i, 0, 0, 0, 0);
						/* KILL OBJECT AND CONTENTS. */
						game.dsub.newsta_(vars.oindex_1.gunk, 0, 0, vars.oindex_1.machi, 0);
						/* REDUCE TO GUNK. */
					}
					return ret_val;

				case 31500:
					game.dsub.rspsub_(300, odi2);
					/* CANT TURN WITH THAT. */
					return ret_val;

				case 31600:
					game.dsub.rspeak_(227);
					/* LID IS UP. */
					return ret_val;
				/* SOBJS, PAGE 9 */

				/* O20-- LEAK */

				case 33000:
					if (vars.prsvec_1.prso != vars.oindex_1.leak
							|| vars.prsvec_1.prsa != PLUG
							|| vars.findex_1.rvmnt <= 0)
					{
						return false;
					}
					if (vars.prsvec_1.prsi != vars.oindex_1.putty)
					{
						GOTO = 33100;
						continue loop;
					}
					/* WITH PUTTY? */
					vars.findex_1.rvmnt = -1;
					/* DISABLE LEAK. */
					vars.cevent_1.ctick[vars.cindex_1.cevmnt - 1] = 0;
					game.dsub.rspeak_(577);
					return ret_val;

				case 33100:
					game.dsub.rspsub_(301, odi2);
					/* CANT WITH THAT. */
					return ret_val;

				/* O21-- DROWNING BUTTONS */

				case 34000:
					if (vars.prsvec_1.prsa != PUSH)
					{
						return false;
					}
					/* PUSH? */
					switch (vars.prsvec_1.prso - vars.oindex_1.rbutt + 1)
					{
						case 1:
							GOTO = 34100;
							continue loop;
						case 2:
							GOTO = 34200;
							continue loop;
						case 3:
							GOTO = 34300;
							continue loop;
						case 4:
							GOTO = 34400;
							continue loop;
					}
					return false;
				/* NOT A BUTTON. */

				case 34100:
					vars.rooms_1.rflag[vars.play_1.here - 1] ^= Vars.RLIGHT;
					i = 230;
					if ((vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RLIGHT) != 0)
					{
						i = 231;
					}
					game.dsub.rspeak_(i);
					return ret_val;

				case 34200:
					vars.findex_1.gatef = true;
					/* RELEASE GATE. */
					game.dsub.rspeak_(232);
					return ret_val;

				case 34300:
					vars.findex_1.gatef = false;
					/* INTERLOCK GATE. */
					game.dsub.rspeak_(232);
					return ret_val;

				case 34400:
					if (vars.findex_1.rvmnt != 0)
					{
						GOTO = 34500;
						continue loop;
					}
					/* LEAK ALREADY STARTED? */
					game.dsub.rspeak_(233);
					/* NO, START LEAK. */
					vars.findex_1.rvmnt = 1;
					vars.cevent_1.ctick[vars.cindex_1.cevmnt - 1] = -1;
					return ret_val;

				case 34500:
					game.dsub.rspeak_(234);
					/* BUTTON JAMMED. */
					return ret_val;

				/* O22-- INFLATABLE BOAT */

				case 36000:
					if (vars.prsvec_1.prsa != INFLATE)
					{
						return false;
					}
					/* INFLATE? */
					if (vars.objcts_1.oroom[vars.oindex_1.iboat - 1] != 0)
					{
						GOTO = 36100;
						continue loop;
					}
					/* IN ROOM? */
					game.dsub.rspeak_(235);
					/* NO, JOKE. */
					return ret_val;

				case 36100:
					if (vars.prsvec_1.prsi != vars.oindex_1.pump)
					{
						GOTO = 36200;
						continue loop;
					}
					/* WITH PUMP? */
					game.dsub.newsta_(vars.oindex_1.iboat, 0, 0, 0, 0);
					/* KILL DEFL BOAT, */
					game.dsub.newsta_(vars.oindex_1.rboat, 236, vars.play_1.here, 0, 0);
					/* REPL WITH INF. */
					vars.findex_1.deflaf = false;
					return ret_val;

				case 36200:
					i = 237;
					/* JOKES. */
					if (vars.prsvec_1.prsi != vars.oindex_1.lungs)
					{
						i = 303;
					}
					game.dsub.rspsub_(i, odi2);
					return ret_val;

				/* O23-- DEFLATED BOAT */

				case 37000:
					if (vars.prsvec_1.prsa != INFLATE)
					{
						GOTO = 37100;
						continue loop;
					}
					/* INFLATE? */
					game.dsub.rspeak_(238);
					/* JOKE. */
					return ret_val;

				case 37100:
					if (vars.prsvec_1.prsa != PLUG)
					{
						return false;
					}
					/* PLUG? */
					if (vars.prsvec_1.prsi != vars.oindex_1.putty)
					{
						GOTO = 33100;
						continue loop;
					}
					/* WITH PUTTY? */
					game.dsub.newsta_(vars.oindex_1.iboat, 239,
							vars.objcts_1.oroom[vars.oindex_1.dboat - 1],
							vars.objcts_1.ocan[vars.oindex_1.dboat - 1],
							vars.objcts_1.oadv[vars.oindex_1.dboat - 1]);
					game.dsub.newsta_(vars.oindex_1.dboat, 0, 0, 0, 0);
					/* KILL DEFL BOAT, REPL. */
					return ret_val;
				/* SOBJS, PAGE 10 */

				/* O24-- RUBBER BOAT */

				case 38000:
					if (arg != 0)
					{
						return false;
					}
					/* DISMISS READIN, OUT. */
					if (vars.prsvec_1.prsa != BOARD
							|| vars.objcts_1.oadv[vars.oindex_1.stick - 1] != vars.play_1.winner)
					{
						GOTO = 38100;
						continue loop;
					}
					game.dsub.newsta_(vars.oindex_1.rboat, 0, 0, 0, 0);
					/* KILL INFL BOAT, */
					game.dsub.newsta_(vars.oindex_1.dboat, 240, vars.play_1.here, 0, 0);
					/* REPL WITH DEAD. */
					vars.findex_1.deflaf = true;
					return ret_val;

				case 38100:
					if (vars.prsvec_1.prsa != INFLATE)
					{
						GOTO = 38200;
						continue loop;
					}
					/* INFLATE? */
					game.dsub.rspeak_(367);
					/* YES, JOKE. */
					return ret_val;

				case 38200:
					if (vars.prsvec_1.prsa != DEFLATE)
					{
						return false;
					}
					/* DEFLATE? */
					if (av == vars.oindex_1.rboat)
					{
						GOTO = 38300;
						continue loop;
					}
					/* IN BOAT? */
					if (vars.objcts_1.oroom[vars.oindex_1.rboat - 1] == 0)
					{
						GOTO = 38400;
						continue loop;
					}
					/* ON GROUND? */
					game.dsub.newsta_(vars.oindex_1.rboat, 0, 0, 0, 0);
					/* KILL INFL BOAT, */
					game.dsub.newsta_(vars.oindex_1.iboat, 241, vars.play_1.here, 0, 0);
					/* REPL WITH DEFL. */
					vars.findex_1.deflaf = true;
					return ret_val;

				case 38300:
					game.dsub.rspeak_(242);
					/* IN BOAT. */
					return ret_val;

				case 38400:
					game.dsub.rspeak_(243);
					/* NOT ON GROUND. */
					return ret_val;

				/* O25-- BRAIDED ROPE */

				case 41000:
					if (vars.prsvec_1.prsa != TIE
							|| vars.prsvec_1.prso != vars.oindex_1.brope
							|| vars.prsvec_1.prsi != vars.oindex_1.hook1
									&& vars.prsvec_1.prsi != vars.oindex_1.hook2)
					{
						GOTO = 41500;
						continue loop;
					}
					vars.findex_1.btief = vars.prsvec_1.prsi;
					/* RECORD LOCATION. */
					vars.cevent_1.cflag[vars.cindex_1.cevbal - 1] = false;
					/* STALL ASCENT. */
					game.dsub.rspeak_(248);
					return ret_val;

				case 41500:
					if (vars.prsvec_1.prsa != UNTIE
							|| vars.prsvec_1.prso != vars.oindex_1.brope)
					{

						return false;
					}
					if (vars.findex_1.btief != 0)
					{
						GOTO = 41600;
						continue loop;
					}
					/* TIED UP? */
					game.dsub.rspeak_(249);
					/* NO, JOKE. */
					return ret_val;

				case 41600:
					game.dsub.rspeak_(250);
					vars.findex_1.btief = 0;
					/* UNTIE. */
					vars.cevent_1.ctick[vars.cindex_1.cevbal - 1] = 3;
					/* RESTART CLOCK. */
					vars.cevent_1.cflag[vars.cindex_1.cevbal - 1] = true;
					return ret_val;

				/* O26-- SAFE */

				case 42000:
					i = 0;
					/* ASSUME UNPROCESSED. */
					if (vars.prsvec_1.prsa == TAKE)
					{
						i = 251;
					}
					/* TAKE? */
					if (vars.prsvec_1.prsa == OPEN && vars.findex_1.safef)
					{
						i = 253;
					}
					/* OPEN AFTER BLAST? */
					if (vars.prsvec_1.prsa == OPEN && !vars.findex_1.safef)
					{
						i = 254;
					}
					/* OPEN BEFORE BLAST? */
					if (vars.prsvec_1.prsa == CLOSE && vars.findex_1.safef)
					{
						i = 253;
					}
					/* CLOSE AFTER? */
					if (vars.prsvec_1.prsa == CLOSE && !vars.findex_1.safef)
					{
						i = 255;
					}
					if (i == 0)
					{
						return false;
					}
					game.dsub.rspeak_(i);
					return ret_val;

				/* O27-- FUSE */

				case 43000:
					if (vars.prsvec_1.prsa != BURN)
					{
						return false;
					}
					/* BURN? */
					game.dsub.rspeak_(256);
					vars.cevent_1.ctick[vars.cindex_1.cevfus - 1] = 2;
					/* START COUNTDOWN. */
					return ret_val;

				/* O28-- GNOME */

				case 44000:
					if (vars.prsvec_1.prsa != GIVE
							&& vars.prsvec_1.prsa != THROW)
					{

						GOTO = 44500;
						continue loop;
					}
					if (vars.objcts_1.otval[vars.prsvec_1.prso - 1] == 0)
					{
						GOTO = 44100;
						continue loop;
					}
					/* TREASURE? */
					game.dsub.rspsub_(257, odo2);
					/* YES, GET DOOR. */
					game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, 0);
					game.dsub.newsta_(vars.oindex_1.gnome, 0, 0, 0, 0);
					/* VANISH GNOME. */
					vars.findex_1.gnodrf = true;
					return ret_val;

				case 44100:
					game.dsub.rspsub_(258, odo2);
					/* NO, LOSE OBJECT. */
					game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, 0);
					return ret_val;

				case 44500:
					game.dsub.rspeak_(259);
					/* NERVOUS GNOME. */
					if (!vars.findex_1.gnomef)
					{
						vars.cevent_1.ctick[vars.cindex_1.cevgno - 1] = 5;
					}
					/* SCHEDULE BYEBYE. */
					vars.findex_1.gnomef = true;
					return ret_val;

				/* O29-- COKE BOTTLES */

				case 46000:
					if (vars.prsvec_1.prsa != THROW
							&& vars.prsvec_1.prsa != MUNG)
					{

						return false;
					}
					game.dsub.newsta_(vars.prsvec_1.prso, 262, 0, 0, 0);
					/* MUNG BOTTLES. */
					return ret_val;
				/* SOBJS, PAGE 11 */

				/* O30-- ROBOT */

				case 53000:
					if (vars.prsvec_1.prsa != GIVE)
					{
						GOTO = 53200;
						continue loop;
					}
					/* GIVE? */
					game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, vars.aindex_1.arobot);
					/* PUT ON ROBOT. */
					game.dsub.rspsub_(302, odo2);
					return ret_val;

				case 53200:
					if (vars.prsvec_1.prsa != MUNG
							&& vars.prsvec_1.prsa != THROW)
					{

						return false;
					}
					game.dsub.newsta_(vars.oindex_1.robot, 285, 0, 0, 0);
					/* KILL ROBOT. */
					return ret_val;

				/* O31-- GRUE */

				case 56000:
					if (vars.prsvec_1.prsa != EXAMINE)
					{
						GOTO = 56100;
						continue loop;
					}
					/* EXAMINE? */
					game.dsub.rspeak_(288);
					return ret_val;

				case 56100:
					if (vars.prsvec_1.prsa != FIND)
					{
						return false;
					}
					/* FIND? */
					game.dsub.rspeak_(289);
					return ret_val;
//		throw new RuntimeException("Sobjs.sobjs_ not impl");
			}

		} while (true);
	} /* sobjs_ */

}
