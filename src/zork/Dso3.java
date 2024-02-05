package zork;

public class Dso3
{
	/* FINDXT- FIND EXIT FROM ROOM */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Dso3(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean findxt_(int dir, int rm)
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int i, xi;
		int xxxflg;

		ret_val = true;
		/* !ASSUME WINS. */
		xi = vars.rooms_1.rexit[rm - 1];
		/* !FIND FIRST ENTRY. */
		if (xi == 0)
		{
			/* !YES, LOSE. */
			return false;
		}
		/* !NO EXITS? */

		do
		{
			i = vars.exits_1.travel[xi - 1];
			/* !GET ENTRY. */
			vars.curxt_1.xroom1 = i & vars.xpars_1.xrmask;
			/*
			 * mask to 16-bits to get rid of sign extension problems with 32-bit ints
			 */
			xxxflg = ~vars.xpars_1.xlflag & 65535;
			vars.curxt_1.xtype = ((i & xxxflg) / vars.xpars_1.xfshft & vars.xpars_1.xfmask) + 1;
			switch (vars.curxt_1.xtype)
			{
				case 4:
				case 3:
					vars.curxt_1.xobj = vars.exits_1.travel[xi + 1] & vars.xpars_1.xrmask;
					vars.curxt_1.xactio = vars.exits_1.travel[xi + 1] / vars.xpars_1.xashft;
				case 2:
					vars.curxt_1.xstrng = vars.exits_1.travel[xi];
				case 1:
					xi += vars.xpars_1.xelnt[vars.curxt_1.xtype - 1];
					/* !ADVANCE TO NEXT ENTRY. */
					if ((i & vars.xpars_1.xdmask) == dir)
					{
						return ret_val;
					}
					break;
				default:
					/* !BRANCH ON ENTRY. */
					game.dsub.bug_(10, vars.curxt_1.xtype);
			}

			/* !DOOR/CEXIT/NEXIT - STRING. */
		} while ((i & vars.xpars_1.xlflag) == 0);
		return ret_val;
	} /* findxt_ */

	/* FWIM- FIND WHAT I MEAN */
	int fwim_(int f1, int f2, int rm, int con, int adv, boolean nocare)
	{
		/* System generated locals */
		int ret_val;

		/* Local variables */
		int i, j;

		int nocare_int = nocare ? 1 : 0;

		/* OBJECTS */
		ret_val = 0;
		/* !ASSUME NOTHING. */
		for (i = 1; i <= vars.objcts_1.olnt; ++i)
		{
			/* !LOOP */
			if ((rm == 0 || vars.objcts_1.oroom[i - 1] != rm)
					&& (adv == 0 || vars.objcts_1.oadv[i - 1] != adv)
					&& (con == 0 || vars.objcts_1.ocan[i - 1] != con))
			{
				continue;
			}

			/* OBJECT IS ON LIST... IS IT A MATCH? */

			if ((vars.objcts_1.oflag1[i - 1] & Vars.VISIBT) == 0)
			{
				continue;
			}

			boolean a = (~(nocare_int) & (vars.objcts_1.oflag1[i - 1] & Vars.TAKEBT)) == 0;
			if (!(a || (vars.objcts_1.oflag1[i - 1] & f1) == 0
					&& (vars.objcts_1.oflag2[i - 1] & f2) == 0))
			{

				if (ret_val != 0)
				{
					return -ret_val;
				}
				/* !ALREADY GOT SOMETHING? */
				ret_val = i;
				/* !NOTE MATCH. */
			}
			/* DOES OBJECT CONTAIN A MATCH? */

			if ((vars.objcts_1.oflag2[i - 1] & Vars.OPENBT) == 0)
			{
				continue;
			}
			for (j = 1; j <= vars.objcts_1.olnt; ++j)
			{
				/* !NO, SEARCH CONTENTS. */
				if (vars.objcts_1.ocan[j - 1] != i
						|| (vars.objcts_1.oflag1[j - 1] & Vars.VISIBT) == 0
						|| (vars.objcts_1.oflag1[j - 1] & f1) == 0
								&& (vars.objcts_1.oflag2[j - 1] & f2) == 0)
				{
					continue;
				}
				if (ret_val == 0)
				{
					ret_val = j;
					continue;
				}
				ret_val = -ret_val;
				return ret_val;
			}
		}
		return ret_val;
	} /* fwim_ */

	/* YESNO- OBTAIN YES/NO ANSWER */
	/* YES-IS-TRUE=YESNO(QUESTION,YES-STRING,NO-STRING) */
	boolean yesno_(int q, int y, int n)
	{
		/* Local variables */
		do
		{
			game.dsub.rspeak_(q);
			/* !ASK */
			System.out.flush();
//			String ans = DMain.getInput();
			String ans = "Y";
			/* !GET ANSWER */
			if (ans.length() > 0 && (ans.charAt(0) == 'Y' || ans.charAt(0) == 'y'))
			{
				/* !YES, */
				game.dsub.rspeak_(y);
				/* !OUT WITH IT. */
				return true;
			}
			if (ans.length() > 0 && (ans.charAt(0) == 'N' || ans.charAt(0) == 'n'))
			{
				/* !NO, */
				game.dsub.rspeak_(n);
				/* !LIKEWISE. */
				return false;
			}
			game.dsub.rspeak_(6);
			/* !SCOLD. */
		} while (true);

	} /* yesno_ */

}
