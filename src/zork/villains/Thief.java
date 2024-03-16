package zork.villains;

import zork.Vars;

public class Thief extends Villain
{

	public Thief()
	{	
		super();
	}



//	/* THIEFP- THIEF FUNCTION */
//	boolean thiefp_(int arg)
//	{
//		/* System generated locals */
//		int i__1;
//		boolean ret_val;
//
//		/* Local variables */
//		int i, j;
//
//		ret_val = true;
//		/* !ASSUME WINS. */
//		if (vars.prsvec_1.prsa != vars.vindex_1.fightw)
//		{
//			if (vars.prsvec_1.prsa != vars.vindex_1.deadxw)
//			{
//				if (vars.prsvec_1.prsa != vars.vindex_1.frstqw)
//				{
//					if (vars.prsvec_1.prsa != vars.vindex_1.hellow
//							|| vars.objcts_1.odesc1[vars.oindex_1.thief - 1] != 504)
//					{
//						if (vars.prsvec_1.prsa != vars.vindex_1.outxw)
//						{
//							if (vars.prsvec_1.prsa != vars.vindex_1.inxw)
//							{
//								if (vars.prsvec_1.prsa != vars.vindex_1.takew)
//								{
//									if (vars.prsvec_1.prsa != vars.vindex_1.throww
//											|| vars.prsvec_1.prso != vars.oindex_1.knife
//											|| (vars.objcts_1.oflag2[vars.oindex_1.thief - 1]
//													& Vars.FITEBT) != 0)
//									{
//										if (vars.prsvec_1.prsa != vars.vindex_1.throww
//												&& vars.prsvec_1.prsa != vars.vindex_1.givew
//												|| vars.prsvec_1.prso == 0
//												|| vars.prsvec_1.prso == vars.oindex_1.thief)
//										{
//											ret_val = false;
//											return ret_val;
//										}
//										if (vars.objcts_1.ocapac[vars.oindex_1.thief - 1] < 0)
//										{
//
//											/* !WAKE HIM UP. */
//											vars.objcts_1.ocapac[vars.oindex_1.thief
//													- 1] = -vars.objcts_1.ocapac[vars.oindex_1.thief
//															- 1];
//											vars.hack_1.thfact = true;
//											vars.objcts_1.oflag1[vars.oindex_1.still
//													- 1] |= Vars.VISIBT;
//											vars.objcts_1.odesc1[vars.oindex_1.thief - 1] = 503;
//	+										game.dsub.rspeak_(510);
//										}
//
//										if (vars.prsvec_1.prso != vars.oindex_1.brick
//												|| vars.objcts_1.ocan[vars.oindex_1.fuse
//														- 1] != vars.oindex_1.brick
//												|| vars.cevent_1.ctick[vars.cindex_1.cevfus
//														- 1] == 0)
//										{
//											i__1 = -vars.oindex_1.thief;
//											game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, i__1);
//											/* !THIEF TAKES GIFT. */
//											if (vars.objcts_1.otval[vars.prsvec_1.prso - 1] > 0)
//											{
//												game.dsub.rspsub_(627,
//														vars.objcts_1.odesc2[vars.prsvec_1.prso
//																- 1]);
//												/* !THIEF ENGROSSED. */
//												vars.findex_1.thfenf = true;
//												return ret_val;
//											}
//											/* !A TREASURE? */
//											game.dsub.rspsub_(512,
//													vars.objcts_1.odesc2[vars.prsvec_1.prso - 1]);
//											return ret_val;
//										}
//										game.dsub.rspeak_(511);
//										/* !THIEF REFUSES BOMB. */
//										return ret_val;
//									}
//									if (game.dsub.prob_(10, 10))
//									{
//										j = 508;
//										/* !THIEF DROPS STUFF. */
//										i__1 = vars.objcts_1.olnt;
//										for (i = 1; i <= i__1; ++i)
//										{
//											if (vars.objcts_1.oadv[i - 1] == -vars.oindex_1.thief)
//											{
//												/* !THIEF CARRYING? */
//												j = 509;
//												game.dsub.newsta_(i, 0, vars.play_1.here, 0, 0);
//											}
//										}
//										game.dsub.newsta_(vars.oindex_1.thief, j, 0, 0, 0);
//										/* !THIEF VANISHES. */
//										return ret_val;
//									}
//									/* !THREW KNIFE, 10%? */
//									game.dsub.rspeak_(507);
//									/* !NO, JUST MAKES */
//									vars.objcts_1.oflag2[vars.oindex_1.thief - 1] |= Vars.FITEBT;
//									return ret_val;
//								}
//								/* !TAKE? */
//								game.dsub.rspeak_(506);
//								/* !JOKE. */
//								return ret_val;
//							}
//							/* !IN? */
//							if (game.dsub.qhere_(vars.oindex_1.thief, vars.play_1.here))
//							{
//								game.dsub.rspeak_(505);
//							}
//							/* !CAN HERO SEE? */
//							vars.hack_1.thfact = true;
//							/* !ENABLE DEMON. */
//							vars.objcts_1.odesc1[vars.oindex_1.thief - 1] = 503;
//							/* !CHANGE DESCRIPTION. */
//							vars.objcts_1.oflag1[vars.oindex_1.still - 1] |= Vars.VISIBT;
//							if (vars.play_1.here == vars.rindex_1.treas
//									&& game.dsub.qhere_(vars.oindex_1.chali, vars.play_1.here))
//							{
//								vars.objcts_1.oflag1[vars.oindex_1.chali - 1] &= ~Vars.TAKEBT;
//							}
//							return ret_val;
//						}
//						/* !OUT? */
//						vars.hack_1.thfact = false;
//						/* !DISABLE DEMON. */
//						vars.objcts_1.odesc1[vars.oindex_1.thief - 1] = 504;
//						/* !CHANGE DESCRIPTION. */
//						vars.objcts_1.oflag1[vars.oindex_1.still - 1] &= ~Vars.VISIBT;
//						vars.objcts_1.oflag1[vars.oindex_1.chali - 1] |= Vars.TAKEBT;
//						return ret_val;
//					}
//					game.dsub.rspeak_(626);
//					return ret_val;
//				}
//				/* !FIRST ENCOUNTER? */
//				ret_val = game.dsub.prob_(20, 75);
//				return ret_val;
//			}
//			/* !DEAD? */
//			vars.hack_1.thfact = false;
//			/* !DISABLE DEMON. */
//			vars.objcts_1.oflag1[vars.oindex_1.chali - 1] |= Vars.TAKEBT;
//			j = 0;
//			i__1 = vars.objcts_1.olnt;
//			for (i = 1; i <= i__1; ++i)
//			{
//				/* !CARRYING ANYTHING? */
//				/* L125: */
//				if (vars.objcts_1.oadv[i - 1] == -vars.oindex_1.thief)
//				{
//					j = 500;
//				}
//			}
//			game.dsub.rspeak_(j);
//			/* !TELL IF BOOTY REAPPEARS. */
//
//			j = 501;
//			i__1 = vars.objcts_1.olnt;
//			for (i = 1; i <= i__1; ++i)
//			{
//				/* !LOOP. */
//				if (i == vars.oindex_1.chali || i == vars.oindex_1.thief
//						|| vars.play_1.here != vars.rindex_1.treas
//						|| !game.dsub.qhere_(i, vars.play_1.here))
//				{
//					if (vars.objcts_1.oadv[i - 1] == -vars.oindex_1.thief)
//					{
//						game.dsub.newsta_(i, 0, vars.play_1.here, 0, 0);
//					}
//				}
//				else
//				{
//					vars.objcts_1.oflag1[i - 1] |= Vars.VISIBT;
//					game.dsub.rspsub_(j, vars.objcts_1.odesc2[i - 1]);
//					/* !DESCRIBE. */
//					j = 502;
//				}
//			}
//			return ret_val;
//		}
//		/* !FIGHT? */
//		if (vars.objcts_1.ocan[vars.oindex_1.still - 1] == vars.oindex_1.thief)
//		{
//			ret_val = false;
//			return ret_val;
//		}
//		/* !GOT STILLETTO? F. */
//		if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos))
//		{
//			game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
//			/* !YES, RECOVER. */
//			if (game.dsub.qhere_(vars.oindex_1.thief, vars.play_1.here))
//			{
//				game.dsub.rspeak_(499);
//			}
//			/* !IF HERO, TELL. */
//			return ret_val;
//		}
//		/* !CAN HE RECOVER IT? */
//		game.dsub.newsta_(vars.oindex_1.thief, 0, 0, 0, 0);
//		/* !NO, VANISH. */
//		if (game.dsub.qhere_(vars.oindex_1.thief, vars.play_1.here))
//		{
//			game.dsub.rspeak_(498);
//		}
//		/* !IF HERO, TELL. */
//		return ret_val;
//		/* !TELL IF BOOTY REAPPEARS. */
//
//	} /* thiefp_ */

}
