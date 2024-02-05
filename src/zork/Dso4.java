package zork;

public class Dso4
{
	/* ROBADV-- STEAL WINNER'S VALUABLES */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Dso4(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	int robadv_(int adv, int nr, int nc, int na)
	{
		/* System generated locals */
		int ret_val;

		/* Local variables */
		int i;

		ret_val = 0;
		/* !COUNT OBJECTS */
		for (i = 1; i <= vars.objcts_1.olnt; ++i)
		{
			if (vars.objcts_1.oadv[i - 1] != adv || vars.objcts_1.otval[i - 1] <= 0
					|| (vars.objcts_1.oflag2[i - 1] & Vars.SCRDBT) != 0)
			{
				continue;
			}
			game.dsub.newsta_(i, 0, nr, nc, na);
			/* !STEAL OBJECT */
			++ret_val;
		}
		return ret_val;
	} /* robadv_ */

	/* ROBRM-- STEAL ROOM VALUABLES */
	int robrm_(int rm, int pr, int nr, int nc, int na)
	{
		/* System generated locals */
		int ret_val;

		/* Local variables */
		int i;

		ret_val = 0;
		/* !COUNT OBJECTS */
		for (i = 1; i <= vars.objcts_1.olnt; ++i)
		{
			/* !LOOP ON OBJECTS. */
			if (!game.dsub.qhere_(i, rm))
			{
				continue;
			}
			if (vars.objcts_1.otval[i - 1] <= 0 || (vars.objcts_1.oflag2[i - 1] & Vars.SCRDBT) != 0
					|| (vars.objcts_1.oflag1[i - 1] & Vars.VISIBT) == 0 || !game.dsub.prob_(pr, pr))
			{
				if ((vars.objcts_1.oflag2[i - 1] & Vars.ACTRBT) != 0)
				{
					ret_val += robadv_(game.dsub.oactor_(i), nr, nc, na);
				}
			}
			else
			{
				game.dsub.newsta_(i, 0, nr, nc, na);
				++ret_val;
				vars.objcts_1.oflag2[i - 1] |= Vars.TCHBT;
				continue;
			}
		}
		return ret_val;
	} /* robrm_ */

	/* WINNIN-- SEE IF VILLAIN IS WINNING */
	boolean winnin_(int vl, int hr)
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int ps, vs;

		vs = vars.objcts_1.ocapac[vl - 1];
		/* !VILLAIN STRENGTH */
		ps = vs - game.dso4.fights_(hr, true);
		/* !HIS MARGIN OVER HERO */
		if (ps > 3)
		{
			ret_val = game.dsub.prob_(90, 100);
		}
		/* !+3... 90% WINNING */
		else if (ps > 0)
		{
			ret_val = game.dsub.prob_(75, 85);
		}
		/* !>0... 75% WINNING */
		else if (ps == 0)
		{
			ret_val = game.dsub.prob_(50, 30);
		}
		/* !=0... 50% WINNING */
		else if (vs > 1)
		{
			ret_val = game.dsub.prob_(25, 25);
		}
		/* !ANY VILLAIN STRENGTH. */
		else
		{
			ret_val = game.dsub.prob_(10, 0);
		}
		return ret_val;
	} /* winnin_ */

	/* FIGHTS-- COMPUTE FIGHT STRENGTH */
	int fights_(int h, boolean flg)
	{
		/* Initialized data */
		final int smin = 2;
		final int smax = 7;

		/* System generated locals */
		int ret_val;

		ret_val = smin + ((smax - smin) * vars.advs_1.ascore[h - 1] + vars.state_1.mxscor / 2)
				/ vars.state_1.mxscor;
		if (flg)
		{
			ret_val += vars.advs_1.astren[h - 1];
		}
		return ret_val;
	} /* fights_ */

	/* VILSTR- COMPUTE VILLAIN STRENGTH */
	int vilstr_(int v)
	{
		/* System generated locals */
		int ret_val, i__2, i__3;

		/* Local variables */
		int i;

		ret_val = vars.objcts_1.ocapac[v - 1];
		if (ret_val <= 0)
		{
			return ret_val;
		}
		if (v == vars.oindex_1.thief && vars.findex_1.thfenf)
		{
			vars.findex_1.thfenf = false;
			/* !THIEF UNENGROSSED. */
			ret_val = Math.min(ret_val, 2);
			/* !NO BETTER THAN 2. */
		}
		for (i = 1; i <= vars.vill_1.vlnt; ++i)
		{
			/* !SEE IF BEST WEAPON. */
			if (vars.vill_1.villns[i - 1] == v && vars.prsvec_1.prsi == vars.vill_1.vbest[i - 1])
			{
				/* Computing MAX */
				i__2 = 1;
				i__3 = ret_val - 1;
				ret_val = Math.max(i__2, i__3);
			}
		}
		return ret_val;
	} /* vilstr_ */

}
