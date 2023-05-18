package zork;

import java.io.IOException;

public class Dso5
{
	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Dso5(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	/* GTTIME-- GET TOTAL TIME PLAYED */
	void gttime_(int[] t)
	{
		int[] h = new int[1], m = new int[1], s = new int[1];

		Supp.itime_(h, m, s);
		t[0] = h[0] * 60 + m[0] - (vars.time_1.shour[0] * 60 + vars.time_1.smin[0]);
		if (t[0] < 0)
		{
			t[0] += 1440;
		}
		t[0] += vars.time_1.pltime;
	} /* gttime_ */

	/* OPNCLS-- PROCESS OPEN/CLOSE FOR DOORS */
	boolean opncls_(int obj, int so, int sc) throws IOException
	{
		/* System generated locals */
		boolean ret_val;

		ret_val = true;
		/* !ASSUME WINS. */
		if (vars.prsvec_1.prsa == vars.vindex_1.closew)
		{
			if (!((vars.objcts_1.oflag2[obj - 1] & Vars.OPENBT) != 0))
			{
				game.dsub.rspeak_(Supp.rnd_(3) + 125);
				return ret_val;
			}
			/* !CLOSE... IS IT? */
			game.dsub.rspeak_(sc);
			vars.objcts_1.oflag2[obj - 1] &= ~Vars.OPENBT;
			return ret_val;
		}
		/* !CLOSE? */
		if (vars.prsvec_1.prsa != vars.vindex_1.openw)
		{
			/* !OPEN? */
			ret_val = false;
			/* !LOSE */
			return ret_val;
		}

		if ((vars.objcts_1.oflag2[obj - 1] & Vars.OPENBT) != 0)
		{
			game.dsub.rspeak_(Supp.rnd_(3) + 125);
			return ret_val;
		}
		/* !OPEN... IS IT? */
		game.dsub.rspeak_(so);
		vars.objcts_1.oflag2[obj - 1] |= Vars.OPENBT;
		return ret_val;

	} /* opncls_ */

	/* LIT-- IS ROOM LIT? */
	boolean lit_(int rm)
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int i, j, oa;

		ret_val = true;
		/* !ASSUME WINS */
		if ((vars.rooms_1.rflag[rm - 1] & Vars.RLIGHT) != 0)
		{
			return ret_val;
		}

		for (i = 1; i <= vars.objcts_1.olnt; ++i)
		{
			/* !LOOK FOR LIT OBJ */
			if (!game.dsub.qhere_(i, rm))
			{

				/* !IN ROOM? */
				oa = vars.objcts_1.oadv[i - 1];
				/* !NO */
				if (oa <= 0)
				{
					continue;
				}
				/* !ON ADV? */
				if (vars.advs_1.aroom[oa - 1] != rm)
				{
					continue;
				}
			}
			/* !ADV IN ROOM? */

			/* OBJ IN ROOM OR ON ADV IN ROOM */

			if ((vars.objcts_1.oflag1[i - 1] & Vars.ONBT) != 0)
			{
				return ret_val;
			}
			if ((vars.objcts_1.oflag1[i - 1] & Vars.VISIBT) == 0
					|| (vars.objcts_1.oflag1[i - 1] & Vars.TRANBT) == 0
							&& (vars.objcts_1.oflag2[i - 1] & Vars.OPENBT) == 0)
			{
				continue;
			}

			/* OBJ IS VISIBLE AND OPEN OR TRANSPARENT */

			for (j = 1; j <= vars.objcts_1.olnt; ++j)
			{
				if (vars.objcts_1.ocan[j - 1] == i
						&& (vars.objcts_1.oflag1[j - 1] & Vars.ONBT) != 0)
				{
					return ret_val;
				}
				/* L500: */
			}
		}
		ret_val = false;
		return ret_val;
	} /* lit_ */

	/* WEIGHT- RETURNS SUM OF WEIGHT OF QUALIFYING OBJECTS */
	int weight_(int rm, int cn, int ad)
	{
		/* System generated locals */
		int ret_val;

		/* Local variables */
		int i, j;

		ret_val = 0;
		loop: for (i = 1; i <= vars.objcts_1.olnt; ++i)
		{
			/* !OMIT BIG FIXED ITEMS. */
			if (vars.objcts_1.osize[i - 1] >= 10000)
			{
				continue;
			}
			/* !IF FIXED, FORGET IT. */
			if (game.dsub.qhere_(i, rm) && rm != 0 || vars.objcts_1.oadv[i - 1] == ad && ad != 0)
			{
				ret_val += vars.objcts_1.osize[i - 1];
				continue loop;
			}
			j = i;
			/* !SEE IF CONTAINED. */
			do
			{
				j = vars.objcts_1.ocan[j - 1];
				/* !GET NEXT LEVEL UP. */
				if (j == 0)
				{
					continue loop;
				}
				/* !END OF LIST? */
			} while (j != cn);
		}
		return ret_val;
	} /* weight_ */

}
