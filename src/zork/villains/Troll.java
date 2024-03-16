package zork.villains;

import zork.Vars;

public class Troll extends Villain
{
//	boolean trollp_(int arg)
//	{
//		/* System generated locals */
//		boolean ret_val;
//
//		/* Local variables */
//		int i;
//
//		ret_val = true;
//		/* !ASSUME WINS. */
//		if (vars.prsvec_1.prsa != vars.vindex_1.fightw)
//		{
//			if (vars.prsvec_1.prsa != vars.vindex_1.deadxw)
//			{
//				if (vars.prsvec_1.prsa != vars.vindex_1.outxw)
//				{
//					if (vars.prsvec_1.prsa != vars.vindex_1.inxw)
//					{
//						if (vars.prsvec_1.prsa != vars.vindex_1.frstqw)
//						{
//							if (vars.prsvec_1.prsa != vars.vindex_1.movew
//									&& vars.prsvec_1.prsa != vars.vindex_1.takew
//									&& vars.prsvec_1.prsa != vars.vindex_1.mungw
//									&& vars.prsvec_1.prsa != vars.vindex_1.throww
//									&& vars.prsvec_1.prsa != vars.vindex_1.givew)
//							{
//								if (!vars.findex_1.trollf
//										|| vars.prsvec_1.prsa != vars.vindex_1.hellow)
//								{
//									ret_val = false;
//									/* !COULDNT HANDLE IT. */
//									return ret_val;
//								}
//								game.dsub.rspeak_(366);
//								/* !TROLL OUT. */
//								return ret_val;
//							}
//							if (vars.objcts_1.ocapac[vars.oindex_1.troll - 1] < 0)
//							{
//
//								/* !TROLL OUT? */
//								vars.objcts_1.ocapac[vars.oindex_1.troll
//										- 1] = -vars.objcts_1.ocapac[vars.oindex_1.troll - 1];
//								/* !YES, WAKE HIM. */
//								vars.objcts_1.oflag1[vars.oindex_1.axe - 1] |= Vars.VISIBT;
//								vars.findex_1.trollf = false;
//								vars.objcts_1.odesc1[vars.oindex_1.troll - 1] = 436;
//								game.dsub.rspeak_(437);
//							}
//
//							if (vars.prsvec_1.prsa != vars.vindex_1.takew
//									&& vars.prsvec_1.prsa != vars.vindex_1.movew)
//							{
//								if (vars.prsvec_1.prsa != vars.vindex_1.mungw)
//								{
//									if (vars.prsvec_1.prso == 0)
//									{
//										ret_val = false;
//										/* !COULDNT HANDLE IT. */
//										return ret_val;
//									}
//									/* !NO OBJECT? */
//									i = 440;
//									/* !ASSUME THROW. */
//									if (vars.prsvec_1.prsa == vars.vindex_1.givew)
//									{
//										i = 441;
//									}
//									/* !GIVE? */
//									game.dsub.rspsub_(i,
//											vars.objcts_1.odesc2[vars.prsvec_1.prso - 1]);
//									/* !TROLL TAKES. */
//									if (vars.prsvec_1.prso == vars.oindex_1.knife)
//									{
//										game.dsub.rspeak_(443);
//										/* !KNIFE, THROWS IT BACK */
//										vars.objcts_1.oflag2[vars.oindex_1.troll
//												- 1] |= Vars.FITEBT;
//										return ret_val;
//									}
//									/* !OBJ KNIFE? */
//									game.dsub.newsta_(vars.prsvec_1.prso, 442, 0, 0, 0);
//									/* !NO, EATS IT. */
//									return ret_val;
//								}
//								/* !MUNG? */
//								game.dsub.rspeak_(439);
//								/* !JOKE. */
//								return ret_val;
//							}
//							game.dsub.rspeak_(438);
//							/* !JOKE. */
//							return ret_val;
//						}
//						/* !FIRST ENCOUNTER? */
//						ret_val = game.dsub.prob_(33, 66);
//						/* !33% TRUE UNLESS BADLK. */
//						return ret_val;
//					}
//					/* !WAKE UP? */
//					vars.findex_1.trollf = false;
//					/* !FORBID EXITS. */
//					vars.objcts_1.oflag1[vars.oindex_1.axe - 1] |= Vars.VISIBT;
//					vars.objcts_1.odesc1[vars.oindex_1.troll - 1] = 436;
//					/* !TROLL IN. */
//					if (game.dsub.qhere_(vars.oindex_1.troll, vars.play_1.here))
//					{
//						game.dsub.rspeak_(437);
//					}
//					return ret_val;
//				}
//				/* !OUT? */
//				vars.findex_1.trollf = true;
//				/* !PERMIT EXITS. */
//				vars.objcts_1.oflag1[vars.oindex_1.axe - 1] &= ~Vars.VISIBT;
//				vars.objcts_1.odesc1[vars.oindex_1.troll - 1] = 435;
//				/* !TROLL OUT. */
//				return ret_val;
//			}
//			/* !DEAD? */
//			vars.findex_1.trollf = true;
//			/* !PERMIT EXITS. */
//			return ret_val;
//		}
//		/* !FIGHT? */
//		if (vars.objcts_1.ocan[vars.oindex_1.axe - 1] == vars.oindex_1.troll)
//		{
//			ret_val = false;
//			/* !COULDNT HANDLE IT. */
//			return ret_val;
//		}
//		/* !GOT AXE? NOTHING. */
//		i = 433;
//		/* !ASSUME CANT GET. */
//		if (game.dsub.qhere_(vars.oindex_1.axe, vars.play_1.here))
//		{
//
//			/* !HERE? */
//			i = 434;
//			/* !YES, RECOVER. */
//			game.dsub.newsta_(vars.oindex_1.axe, 0, 0, vars.oindex_1.troll, 0);
//		}
//		if (game.dsub.qhere_(vars.oindex_1.troll, vars.play_1.here))
//		{
//			game.dsub.rspeak_(i);
//		}
//		/* !IF PLAYER HERE. */
//		return ret_val;
//
//	} /* trollp_ */
}
