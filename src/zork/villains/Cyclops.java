package zork.villains;

import zork.Vars;

public class Cyclops extends Villain
{
//	/* CYCLOP- CYCLOPS FUNCTION */
//	boolean cyclop_(int arg)
//	{
//		/* System generated locals */
//		int i__1, i__2;
//		boolean ret_val;
//
//		/* Local variables */
//		int i;
//
//		ret_val = true;
//		/* !ASSUME WINS. */
//		if (!vars.findex_1.cyclof)
//		{
//			if (vars.prsvec_1.prsa == vars.vindex_1.fightw
//					|| vars.prsvec_1.prsa == vars.vindex_1.frstqw)
//			{
//				ret_val = false;
//				/* !FAILS. */
//				return ret_val;
//			}
//			if (Math.abs(vars.findex_1.rvcyc) <= 5)
//			{
//				if (vars.prsvec_1.prsa != vars.vindex_1.givew)
//				{
//					i = 0;
//					/* !ASSUME NOT HANDLED. */
//					if (vars.prsvec_1.prsa == vars.vindex_1.hellow)
//					{
//						game.dsub.rspeak_(i);
//						/* !DISDAIN IT. */
//						if (vars.findex_1.rvcyc < 0)
//						{
//							--vars.findex_1.rvcyc;
//						}
//						if (vars.findex_1.rvcyc >= 0)
//						{
//							++vars.findex_1.rvcyc;
//						}
//						if (!vars.findex_1.cyclof)
//						{
//							i__1 = Math.abs(vars.findex_1.rvcyc) + 193;
//							game.dsub.rspeak_(i__1);
//						}
//						return ret_val;
//					}
//					/* !HELLO IS NO GO. */
//					if (vars.prsvec_1.prsa == vars.vindex_1.throww
//							|| vars.prsvec_1.prsa == vars.vindex_1.mungw)
//					{
//
//						i = Supp.rnd_(2) + 200;
//					}
//					if (vars.prsvec_1.prsa == vars.vindex_1.takew)
//					{
//						i = 202;
//					}
//					if (vars.prsvec_1.prsa == vars.vindex_1.tiew)
//					{
//						i = 203;
//					}
//					if (i <= 0)
//					{
//						ret_val = false;
//						/* !FAILS. */
//						return ret_val;
//					}
//					else
//					{
//						game.dsub.rspeak_(i);
//						/* !DISDAIN IT. */
//						if (vars.findex_1.rvcyc < 0)
//						{
//							--vars.findex_1.rvcyc;
//						}
//						if (vars.findex_1.rvcyc >= 0)
//						{
//							++vars.findex_1.rvcyc;
//						}
//						if (!vars.findex_1.cyclof)
//						{
//							i__1 = Math.abs(vars.findex_1.rvcyc) + 193;
//							game.dsub.rspeak_(i__1);
//						}
//						return ret_val;
//					}
//					/* !SEE IF HANDLED. */
//				}
//				/* !GIVE? */
//				if (vars.prsvec_1.prso != vars.oindex_1.food || vars.findex_1.rvcyc < 0)
//				{
//					if (vars.prsvec_1.prso != vars.oindex_1.water)
//					{
//						i = 192;
//						/* !ASSUME INEDIBLE. */
//						if (vars.prsvec_1.prso == vars.oindex_1.garli)
//						{
//							i = 193;
//						}
//						/* !GARLIC IS JOKE. */
//						game.dsub.rspeak_(i);
//						/* !DISDAIN IT. */
//						if (vars.findex_1.rvcyc < 0)
//						{
//							--vars.findex_1.rvcyc;
//						}
//						if (vars.findex_1.rvcyc >= 0)
//						{
//							++vars.findex_1.rvcyc;
//						}
//						if (!vars.findex_1.cyclof)
//						{
//							i__1 = Math.abs(vars.findex_1.rvcyc) + 193;
//							game.dsub.rspeak_(i__1);
//						}
//						return ret_val;
//					}
//					/* !DRINK WHEN THIRSTY? */
//					if (vars.findex_1.rvcyc >= 0)
//					{
//						game.dsub.rspeak_(191);
//						/* !NOT THIRSTY. */
//						ret_val = false;
//						/* !FAILS. */
//						return ret_val;
//					}
//					game.dsub.newsta_(vars.prsvec_1.prso, 190, 0, 0, 0);
//					/* !DRINKS AND */
//					vars.findex_1.cyclof = true;
//					/* !FALLS ASLEEP. */
//					vars.objcts_1.oflag2[vars.oindex_1.cyclo
//							- 1] = (vars.objcts_1.oflag2[vars.oindex_1.cyclo - 1] | Vars.SLEPBT)
//									& ~Vars.FITEBT;
//					return ret_val;
//				}
//				/* !FOOD WHEN HUNGRY? */
//				game.dsub.newsta_(vars.oindex_1.food, 189, 0, 0, 0);
//				/* !EATS PEPPERS. */
//				/* Computing MIN */
//				i__1 = -1;
//				i__2 = -vars.findex_1.rvcyc;
//				vars.findex_1.rvcyc = Math.min(i__1, i__2);
//				/* !GETS THIRSTY. */
//				return ret_val;
//			}
//			/* !ANNOYED TOO MUCH? */
//			vars.findex_1.rvcyc = 0;
//			/* !RESTART COUNT. */
//			game.dsub.jigsup_(188);
//			/* !YES, EATS PLAYER. */
//			return ret_val;
//		}
//		/* !ASLEEP? */
//		if (vars.prsvec_1.prsa != vars.vindex_1.alarmw && vars.prsvec_1.prsa != vars.vindex_1.mungw
//				&& vars.prsvec_1.prsa != vars.vindex_1.hellow
//				&& vars.prsvec_1.prsa != vars.vindex_1.burnw
//				&& vars.prsvec_1.prsa != vars.vindex_1.killw
//				&& vars.prsvec_1.prsa != vars.vindex_1.attacw)
//		{
//			ret_val = false;
//			/* !FAILS. */
//			return ret_val;
//		}
//		vars.findex_1.cyclof = false;
//		/* !WAKE CYCLOPS. */
//		game.dsub.rspeak_(187);
//		/* !DESCRIBE. */
//		vars.findex_1.rvcyc = Math.abs(vars.findex_1.rvcyc);
//		vars.objcts_1.oflag2[vars.oindex_1.cyclo
//				- 1] = (vars.objcts_1.oflag2[vars.oindex_1.cyclo - 1] | Vars.FITEBT) & ~Vars.SLEPBT;
//		return ret_val;
//
//	} /* cyclop_ */
}
