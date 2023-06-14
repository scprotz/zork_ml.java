package zork;

public class Demons implements Actions
{
	/* FIGHTD- INTERMOVE FIGHT DEMON */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */

	Vars vars = null;
	Dgame game = null;

	public Demons(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	void fightd_()
	{
		/* Initialized data */

		final int rout = 1;

		/* Local variables */
		int i, j, ra;
		int obj;
		int res;
		int out;

		for (i = 1; i <= vars.vill_1.vlnt; ++i)
		{
			/* LOOP THRU VILLAINS. */
			vars.vill_1.vopps[i - 1] = 0;
			/* CLEAR OPPONENT SLOT. */
			obj = vars.vill_1.villns[i - 1];
			/* GET OBJECT NO. */
			ra = vars.objcts_1.oactio[obj - 1];
			/* GET HIS ACTION. */
			if (vars.play_1.here != vars.objcts_1.oroom[obj - 1])
			{
				if (!((vars.objcts_1.oflag2[obj - 1] & Vars.FITEBT) == 0 || ra == 0))
				{
					vars.prsvec_1.action = FIGHT;
					/* HAVE A FIGHT. */
					game.objcts.oappli_(ra, 0);
				}
				if (obj == vars.oindex_1.thief)
				{
					vars.findex_1.thfenf = false;
				}
				/* TURN OFF ENGROSSED. */
				vars.advs_1.aflag[vars.aindex_1.player - 1] &= ~vars.aflags_1.astag;
				vars.objcts_1.oflag2[obj - 1] &= ~(Vars.STAGBT + Vars.FITEBT);
				if (vars.objcts_1.ocapac[obj - 1] >= 0 || ra == 0)
				{
					continue;
				}
				vars.prsvec_1.action = VILLAIN_ENTERED;
				/* WAKE HIM UP. */
				game.objcts.oappli_(ra, 0);
				vars.objcts_1.ocapac[obj - 1] = Math.abs(vars.objcts_1.ocapac[obj - 1]);
				continue;
			}
			/* ADVENTURER STILL HERE? */
			if (obj == vars.oindex_1.thief && vars.findex_1.thfenf)
			{
				continue;
			}
			/* THIEF ENGROSSED? */
			if (vars.objcts_1.ocapac[obj - 1] >= 0)
			{
				if ((vars.objcts_1.oflag2[obj - 1] & Vars.FITEBT) == 0)
				{
					if (ra == 0)
					{
						continue;
					}
					/* NOT FIGHTING, */
					vars.prsvec_1.action = VILLAIN_QUIT_FIGHTING;
					/* SET UP PROBABILITY */
					if (!game.objcts.oappli_(ra, 0))
					{
						continue;
					}
					/* OF FIGHTING. */
					vars.objcts_1.oflag2[obj - 1] |= Vars.FITEBT;
					vars.vill_1.vopps[i - 1] = obj;
					/* SET UP OPP. */
					continue;
				}
				vars.vill_1.vopps[i - 1] = obj;
				/* FIGHTING, SET UP OPP. */
				continue;
			}
			/* YES, VILL AWAKE? */
			if (vars.vill_1.vprob[i - 1] == 0 || !game.dsub.game.dsub
					.prob_(vars.vill_1.vprob[i - 1], vars.vill_1.vprob[i - 1]))
			{
				vars.vill_1.vprob[i - 1] += 10;
				/* INCREASE WAKEUP PROB. */
				continue;
				/* NOTHING ELSE. */
			}
			vars.objcts_1.ocapac[obj - 1] = Math.abs(vars.objcts_1.ocapac[obj - 1]);
			vars.vill_1.vprob[i - 1] = 0;
			if (ra == 0)
			{
				continue;
			}
			/* ANYTHING TO DO? */
			vars.prsvec_1.action = VILLAIN_ENTERED;
			/* YES, WAKE HIM UP. */
			game.objcts.oappli_(ra, 0);
			continue;
			/* NOTHING ELSE HAPPENS. */
		}
		/* FIGHTD, PAGE 3 */

		/* NOW DO ACTUAL COUNTERBLOWS. */

		out = 0;
		/* ASSUME HERO OK. */
		do
		{
			for (i = 1; i <= vars.vill_1.vlnt; ++i)
			{
				/* LOOP THRU OPPS. */
				j = vars.vill_1.vopps[i - 1];
				if (j == 0)
				{
					continue;
				}
				/* SLOT EMPTY? */
				vars.prsvec_1.prscon = 1;
				/* STOP CMD STREAM. */
				ra = vars.objcts_1.oactio[j - 1];
				if (ra != 0)
				{
					/* VILLAIN ACTION? */
					vars.prsvec_1.action = FIGHT;
					/* SEE IF */
					if (game.objcts.oappli_(ra, 0))
					{
						continue;
					}
				}
				/* SPECIAL ACTION. */
				res = blow_(vars.aindex_1.player, j, vars.vill_1.vmelee[i - 1], false, out);

				/* STRIKE BLOW. */
				if (res < 0)
				{
					return;
				}
				/* IF HERO DEAD, EXIT. */
				if (res == rout)
				{
					out = Supp.rnd_(3) + 2;
				}
				/* IF HERO OUT, SET FLG. */
			}
			--out;
			/* DECREMENT OUT COUNT. */
		} while (out > 0);
		/* IF STILL OUT, GO AGAIN. */
		return;
	} /* fightd_ */

	static final int def1r[] = new int[] { 1, 2, 3 };
	static final int def2r[] = new int[] { 13, 23, 24, 25 };
	static final int def3r[] = new int[] { 35, 36, 46, 47, 57 };
	static final int rvectr[] = new int[] { 0, 0, 0, 0, 5, 5, 1, 1, 2, 2, 2, 2, 0, 0, 0, 0, 0, 5, 5,
			3, 3, 1, 0, 0, 0, 5, 5, 3, 3, 3, 1, 2, 2, 2, 0, 0, 0, 0, 0, 5, 5, 3, 3, 4, 4, 0, 0, 0,
			5, 5, 3, 3, 3, 4, 4, 4, 0, 5, 5, 3, 3, 3, 3, 4, 4, 4 };
	static final int rstate[] = new int[] { 5000, 3005, 3008, 4011, 3015, 3018, 1021, 0, 0, 5022,
			3027, 3030, 4033, 3037, 3040, 1043, 0, 0, 4044, 2048, 4050, 4054, 5058, 4063, 4067,
			3071, 1074, 4075, 1079, 4080, 4084, 4088, 4092, 4096, 4100, 1104, 4105, 2109, 4111,
			4115, 4119, 4123, 4127, 3131, 3134 };

	/* BLOW- STRIKE BLOW */
	int blow_(int h, int v, int rmk, boolean hflg, int out)
	{
		/* Initialized data */

		final int rmiss = 0;
		final int rout = 1;
		final int rkill = 2;
		final int rstag = 5;
		final int rlose = 6;
		final int rhes = 7;
		final int rsit = 8;

		/* System generated locals */
		int ret_val, i__1, i__2;

		/* Local variables */
		int i, j, ra, od = 0, mi, dv, def = 0;
		int tbl = 0;
		int att = 0, res = 0;
		int dweap = 0;
		int pblose = 0;

		ra = vars.objcts_1.oactio[v - 1];
		/* GET VILLAIN ACTION, */
		dv = vars.objcts_1.odesc2[v - 1];
		/* DESCRIPTION. */
		ret_val = rmiss;

		int GOTO = 100;
		/* ASSUME NO RESULT. */
		if (!hflg)
		{
			GOTO = 1000;
		}
		if (GOTO != 1000)
		{
			/* HERO STRIKING BLOW? */

			/* HERO IS ATTACKER, VILLAIN IS DEFENDER. */

			pblose = 10;
			/* BAD LK PROB. */
			vars.objcts_1.oflag2[v - 1] |= Vars.FITEBT;
			boolean skip_to_100 = false;
			if ((vars.advs_1.aflag[h - 1] & vars.aflags_1.astag) == 0)
			{
				skip_to_100 = true;
			}
			if (!skip_to_100)
			{
				game.dsub.rspeak_(591);
				/* YES, CANT FIGHT. */
				vars.advs_1.aflag[h - 1] &= ~vars.aflags_1.astag;
				return ret_val;
			}
		}

		do
		{
			switch (GOTO)
			{

				case 100:
					att = game.dso4.fights_(h, true);
					/* GET HIS STRENGTH. */
					def = game.dso4.vilstr_(v);
					/* GET VILL STRENGTH. */
					od = def;
					dweap = 0;
					/* ASSUME NO WEAPON. */
					i__1 = vars.objcts_1.olnt;
					for (i = 1; i <= i__1; ++i)
					{
						/* SEARCH VILLAIN. */
						if (vars.objcts_1.ocan[i - 1] == v
								&& (vars.objcts_1.oflag2[i - 1] & Vars.WEAPBT) != 0)
						{
							dweap = i;
						}
						/* case 200: */
					}
					if (v == vars.advs_1.aobj[vars.aindex_1.player - 1])
					{
						GOTO = 300;
						continue;
					}
					/* KILLING SELF? */
					if (def != 0)
					{
						GOTO = 2000;
						continue;
					}
					/* DEFENDER ALIVE? */
					game.dsub.rspsub_(592, dv);
					/* VILLAIN DEAD. */
					return ret_val;

				case 300:
					game.dsub.jigsup_(593);
					/* KILLING SELF. */
					return ret_val;

				/* VILLAIN IS ATTACKER, HERO IS DEFENDER. */

				case 1000:
					pblose = 50;
					/* BAD LK PROB. */
					vars.advs_1.aflag[h - 1] &= ~vars.aflags_1.astag;
					if ((vars.objcts_1.oflag2[v - 1] & Vars.STAGBT) == 0)
					{
						GOTO = 1200;
						continue;
					}
					vars.objcts_1.oflag2[v - 1] &= ~Vars.STAGBT;
					game.dsub.rspsub_(594, dv);
					/* DESCRIBE. */
					return ret_val;

				case 1200:
					att = game.dso4.vilstr_(v);
					/* SET UP ATT, DEF. */
					def = game.dso4.fights_(h, true);
					if (def <= 0)
					{
						return ret_val;
					}
					/* DONT ALLOW DEAD DEF. */
					od = game.dso4.fights_(h, false);
					i__1 = game.dso3.fwim_(0, Vars.WEAPBT, 0, 0, h, true);
					dweap = Math.abs(i__1);
					/* FIND A WEAPON. */
					/* BLOW, PAGE 4 */

					/* PARTIES ARE NOW EQUIPPED. DEF CANNOT BE ZERO. */
					/* ATT MUST BE > 0. */

				case 2000:
					if (def > 0)
					{
						GOTO = 2100;
						continue;
					}
					/* DEF ALIVE? */
					res = rkill;
					if (hflg)
					{
						game.dsub.rspsub_(595, dv);
					}
					/* DEADER. */
					GOTO = 3000;
					continue;

				case 2100:
					if ((i__1 = def - 2) < 0)
					{
						GOTO = 2200;
						continue;
					}
					else if (i__1 == 0)
					{
						GOTO = 2300;
						continue;
					}
					else
					{
						GOTO = 2400;
						continue;
					}
					/* DEF <2,=2,>2 */
				case 2200:
					att = Math.min(att, 3);
					/* SCALE ATT. */
					tbl = def1r[att - 1];
					/* CHOOSE TABLE. */
					GOTO = 2500;
					continue;

				case 2300:
					att = Math.min(att, 4);
					/* SCALE ATT. */
					tbl = def2r[att - 1];
					/* CHOOSE TABLE. */
					GOTO = 2500;
					continue;

				case 2400:
					att -= def;
					/* SCALE ATT. */
					/* Computing MIN */
					i__1 = 2;
					i__2 = Math.max(-2, att);
					att = Math.min(i__1, i__2) + 3;
					tbl = def3r[att - 1];

				case 2500:
					res = rvectr[tbl + Supp.rnd_(10) - 1];
					/* GET RESULT. */
					if (out == 0)
					{
						GOTO = 2600;
						continue;
					}
					/* WAS HE OUT? */
					if (res == rstag)
					{
						GOTO = 2550;
						continue;
					}
					/* YES, STAG--> HES. */
					res = rsit;
					/* OTHERWISE, SITTING. */
					GOTO = 2600;
					continue;
				case 2550:
					res = rhes;
				case 2600:
					if (res == rstag && dweap != 0 && game.dsub.prob_(25, pblose))
					{
						res = rlose;
					}

					mi = rstate[(rmk - 1) * 9 + res];
					/* CHOOSE TABLE ENTRY. */
					if (mi == 0)
					{
						GOTO = 3000;
						continue;
					}
					i__1 = mi / 1000;
					i = mi % 1000 + Supp.rnd_(i__1) + vars.star_1.mbase + 1;
					j = dv;
					if (!(hflg) && dweap != 0)
					{
						j = vars.objcts_1.odesc2[dweap - 1];
					}
					game.dsub.rspsub_(i, j);
					/* PRESENT RESULT. */
					/* BLOW, PAGE 5 */

					/* NOW APPLY RESULT */

				case 3000:
					switch (res + 1)
					{
						case 1:
							GOTO = 4000;
							continue;
						case 2:
							GOTO = 3100;
							continue;
						case 3:
							GOTO = 3200;
							continue;
						case 4:
							GOTO = 3300;
							continue;
						case 5:
							GOTO = 3400;
							continue;
						case 6:
							GOTO = 3500;
							continue;
						case 7:
							GOTO = 3600;
							continue;
						case 8:
							GOTO = 4000;
							continue;
						case 9:
							GOTO = 3200;
							continue;
					}

				case 3100:
					if (hflg)
					{
						def = -def;
					}
					/* UNCONSCIOUS. */
					GOTO = 4000;
					continue;

				case 3200:
					def = 0;
					/* KILLED OR SITTING DUCK. */
					GOTO = 4000;
					continue;

				case 3300:
					/* Computing MAX */
					i__1 = 0;
					i__2 = def - 1;
					def = Math.max(i__1, i__2);
					/* LIGHT WOUND. */
					GOTO = 4000;
					continue;

				case 3400:
					/* Computing MAX */
					i__1 = 0;
					i__2 = def - 2;
					def = Math.max(i__1, i__2);
					/* SERIOUS WOUND. */
					GOTO = 4000;
					continue;

				case 3500:
					if (hflg)
					{
						GOTO = 3550;
						continue;
					}
					/* STAGGERED. */
					vars.advs_1.aflag[h - 1] |= vars.aflags_1.astag;
					GOTO = 4000;
					continue;

				case 3550:
					vars.objcts_1.oflag2[v - 1] |= Vars.STAGBT;
					GOTO = 4000;
					continue;

				case 3600:
					game.dsub.newsta_(dweap, 0, vars.play_1.here, 0, 0);
					/* LOSE WEAPON. */
					dweap = 0;
					if (hflg)
					{
						GOTO = 4000;
						continue;
					}
					/* IF HERO, DONE. */
					i__1 = game.dso3.fwim_(0, Vars.WEAPBT, 0, 0, h, true);
					dweap = Math.abs(i__1);
					/* GET NEW. */
					if (dweap != 0)
					{
						game.dsub.rspsub_(605, vars.objcts_1.odesc2[dweap - 1]);
					}
					/* BLOW, PAGE 6 */

				case 4000:
					ret_val = res;
					/* RETURN RESULT. */
					if (!(hflg))
					{
						GOTO = 4500;
						continue;
					}
					/* HERO? */
					vars.objcts_1.ocapac[v - 1] = def;
					/* STORE NEW CAPACITY. */
					if (def != 0)
					{
						GOTO = 4100;
						continue;
					}
					/* DEAD? */
					vars.objcts_1.oflag2[v - 1] &= ~Vars.FITEBT;
					game.dsub.rspsub_(572, dv);
					/* HE DIES. */
					game.dsub.newsta_(v, 0, 0, 0, 0);
					/* MAKE HIM DISAPPEAR. */
					if (ra == 0)
					{
						return ret_val;
					}
					/* IF NX TO DO, EXIT. */
					vars.prsvec_1.action = VILLAIN_DIED;
					/* LET HIM KNOW. */
					game.objcts.oappli_(ra, 0);
					return ret_val;

				case 4100:
					if (res != rout || ra == 0)
					{
						return ret_val;
					}
					vars.prsvec_1.action = VILLAIN_LEFT;
					/* LET HIM BE OUT. */
					game.objcts.oappli_(ra, 0);
					return ret_val;

				case 4500:
					vars.advs_1.astren[h - 1] = -10000;
					/* ASSUME DEAD. */
					if (def != 0)
					{
						vars.advs_1.astren[h - 1] = def - od;
					}
					if (def >= od)
					{
						GOTO = 4600;
						continue;
					}
					vars.cevent_1.ctick[vars.cindex_1.cevcur - 1] = 30;
					vars.cevent_1.cflag[vars.cindex_1.cevcur - 1] = true;
				case 4600:
					if (game.dso4.fights_(h, true) > 0)
					{
						return ret_val;
					}
					vars.advs_1.astren[h - 1] = 1 - game.dso4.fights_(h, false);
					/* HE'S DEAD. */
					game.dsub.jigsup_(596);
					ret_val = -1;
					return ret_val;
			}

		} while (true);
	} /* blow_ */

	/* SWORDD- SWORD INTERMOVE DEMON */

	/* DECLARATIONS */

	void swordd_()
	{
		/* System generated locals */
		int i__1, i__2;

		/* Local variables */
		int i, ng;

		if (vars.objcts_1.oadv[vars.oindex_1.sword - 1] != vars.aindex_1.player)
		{
			/* DROPPED SWORD, */
			vars.hack_1.swdact = false;
			return;
		}
		/* HOLDING SWORD? */
		ng = 2;
		/* ASSUME VILL CLOSE. */
		if (infest_(vars.play_1.here))
		{
			if (ng == vars.hack_1.swdsta)
			{
				return;
			}
			/* ANY STATE CHANGE? */
			i__2 = ng + 495;
			game.dsub.rspeak_(i__2);
			/* YES, TELL NEW STATE. */
			vars.hack_1.swdsta = ng;
			return;
		}
		/* VILL HERE? */
		ng = 1;
		i__1 = vars.xsrch_1.xmax;
		i__2 = vars.xsrch_1.xmin;
		for (i = vars.xsrch_1.xmin; i__2 < 0 ? i >= i__1 : i <= i__1; i += i__2)
		{
			/* NO, SEARCH ROOMS. */
			if (!game.dso3.findxt_(i, vars.play_1.here))
			{
				continue;
			}
			/* ROOM THAT WAY? */
			switch (vars.curxt_1.xtype)
			{
				case 1:
					break;
				case 2:
					continue;
				case 3:
					break;
				case 4:
					break;
			}
			/* SEE IF ROOM AT ALL. */
			if (infest_(vars.curxt_1.xroom1))
			{
				if (ng == vars.hack_1.swdsta)
				{
					return;
				}
				/* ANY STATE CHANGE? */
				i__2 = ng + 495;
				game.dsub.rspeak_(i__2);
				/* YES, TELL NEW STATE. */
				vars.hack_1.swdsta = ng;
				return;
			}
			/* CHECK ROOM. */
		}
		ng = 0;
		/* NO GLOW. */

		if (ng == vars.hack_1.swdsta)
		{
			return;
		}
		/* ANY STATE CHANGE? */
		i__2 = ng + 495;
		game.dsub.rspeak_(i__2);
		/* YES, TELL NEW STATE. */
		vars.hack_1.swdsta = ng;
		return;

	} /* swordd_ */

	/* INFEST- SUBROUTINE TO TEST FOR INFESTED ROOM */

	/* DECLARATIONS */
	private boolean infest_(int r)
	{
		/* System generated locals */
		boolean ret_val;

		if (!vars.findex_1.endgmf)
		{
			ret_val = vars.objcts_1.oroom[vars.oindex_1.cyclo - 1] == r
					|| vars.objcts_1.oroom[vars.oindex_1.troll - 1] == r
					|| vars.objcts_1.oroom[vars.oindex_1.thief - 1] == r && vars.hack_1.thfact;
		}
		else
		{
			ret_val = r == vars.rindex_1.mrg || r == vars.rindex_1.mrge || r == vars.rindex_1.mrgw
					|| r == vars.rindex_1.inmir && vars.findex_1.mloc == vars.rindex_1.mrg;
		}
		return ret_val;
	} /* infest_ */

}
