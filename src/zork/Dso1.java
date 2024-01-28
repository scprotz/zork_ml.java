package zork;

import java.io.IOException;

public class Dso1
{
	Vars vars = null;
	Dgame game = null;

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	public Dso1(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	/* PRINCR- PRINT CONTENTS OF ROOM */
	void princr_(boolean full, int rm) throws IOException
	{
		/* System generated locals */

		/* Local variables */
		int i, j, k;

		j = 329;
		/* !ASSUME SUPERBRIEF FORMAT. */
		for (i = 1; i <= vars.objcts_1.olnt; ++i)
		{
			/* !LOOP ON OBJECTS */
			if (!game.dsub.qhere_(i, rm)
					|| (vars.objcts_1.oflag1[i - 1] & Vars.VISIBT + Vars.NDSCBT) != Vars.VISIBT
					|| i == vars.advs_1.avehic[vars.play_1.winner - 1])
			{
				continue;
			}
			if (!(full) && (vars.findex_1.superf || vars.findex_1.brieff
					&& (vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RSEEN) != 0))
			{
				game.dsub.rspsub_(j, vars.objcts_1.odesc2[i - 1]);
				/* DO SHORT DESCRIPTION OF OBJECT. */
				/* !YOU CAN SEE IT. */
				j = 502;
				continue;
			}

			/* DO LONG DESCRIPTION OF OBJECT. */

			k = vars.objcts_1.odesco[i - 1];
			/* !GET UNTOUCHED. */
			if (k == 0 || (vars.objcts_1.oflag2[i - 1] & Vars.TCHBT) != 0)
			{
				k = vars.objcts_1.odesc1[i - 1];
			}
			game.dsub.rspeak_(k);
			/* !DESCRIBE. */
		}

		/* NOW LOOP TO PRINT CONTENTS OF OBJECTS IN ROOM. */

		for (i = 1; i <= vars.objcts_1.olnt; ++i)
		{
			/* !LOOP ON OBJECTS. */
			if (!game.dsub.qhere_(i, rm)
					|| (vars.objcts_1.oflag1[i - 1] & Vars.VISIBT + Vars.NDSCBT) != Vars.VISIBT)
			{
				continue;
			}
			if ((vars.objcts_1.oflag2[i - 1] & Vars.ACTRBT) != 0)
			{
				invent_(game.dsub.oactor_(i));
			}
			if ((vars.objcts_1.oflag1[i - 1] & Vars.TRANBT) == 0
					&& (vars.objcts_1.oflag2[i - 1] & Vars.OPENBT) == 0 || game.dsub.qempty_(i))
			{
				continue;
			}

			/* OBJECT IS NOT EMPTY AND IS OPEN OR TRANSPARENT. */

			j = 573;
			if (i != vars.oindex_1.tcase)
			{
				princo_(i, j);
				continue;
			}
			/* !TROPHY CASE? */
			j = 574;
			if ((vars.findex_1.brieff || vars.findex_1.superf) && !(full))
			{
				continue;
			}
		}
	} /* princr_ */

	/* INVENT- PRINT CONTENTS OF ADVENTURER */

	/* DECLARATIONS */

	void invent_(int adv) throws IOException
	{
		/* System generated locals */
		int i__1;

		/* Local variables */
		int i, j;

		i = 575;
		/* !FIRST LINE. */
		if (adv != vars.aindex_1.player)
		{
			i = 576;
		}
		/* !IF NOT ME. */
		i__1 = vars.objcts_1.olnt;
		for (j = 1; j <= i__1; ++j)
		{
			/* !LOOP */
			if (vars.objcts_1.oadv[j - 1] != adv
					|| (vars.objcts_1.oflag1[j - 1] & Vars.VISIBT) == 0)
			{
				continue;
			}
			game.dsub.rspsub_(i, vars.objcts_1.odesc2[vars.advs_1.aobj[adv - 1] - 1]);
			i = 0;
			game.dsub.rspsub_(502, vars.objcts_1.odesc2[j - 1]);
		}

		if (i == 0)
		{
			for (j = 1; j <= vars.objcts_1.olnt; ++j)
			{
				/* !LOOP. */
				if (vars.objcts_1.oadv[j - 1] != adv
						|| (vars.objcts_1.oflag1[j - 1] & Vars.VISIBT) == 0
						|| (vars.objcts_1.oflag1[j - 1] & Vars.TRANBT) == 0
								&& (vars.objcts_1.oflag2[j - 1] & Vars.OPENBT) == 0)
				{
					continue;
				}
				if (!game.dsub.qempty_(j))
				{
					princo_(j, 573);
				}
				/* !IF NOT EMPTY, LIST. */
			}
		}
		else
		{
			/* !ANY OBJECTS? */
			if (adv == vars.aindex_1.player)
			{
				game.dsub.rspeak_(578);
			}
			/* !NO, TELL HIM. */
		}
		return;
	} /* invent_ */

	/* PRINCO- PRINT CONTENTS OF OBJECT */
	void princo_(int obj, int desc) throws IOException
	{
		/* Local variables */
		int i;

		game.dsub.rspsub_(desc, vars.objcts_1.odesc2[obj - 1]);
		/* !PRINT HEADER. */
		for (i = 1; i <= vars.objcts_1.olnt; ++i)
		{
			/* !LOOP THRU. */
			if (vars.objcts_1.ocan[i - 1] == obj)
			{
				game.dsub.rspsub_(502, vars.objcts_1.odesc2[i - 1]);
			}
		}
	} /* princo_ */

}
