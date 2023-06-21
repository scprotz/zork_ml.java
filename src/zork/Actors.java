package zork;

public class Actors implements Constants
{
	/* AAPPLI- APPLICABLES FOR ADVENTURERS */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Actors(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean aappli_(int ri)
	{

		if (ri == 0)
		{
			/* COMMON FALSE RETURN. */
			return false;
		}

		/* IF ZERO, NO APP. */

		if (ri == 1)
			return do1000();

		if (ri == 2)
			return do2000();

		// error //
		game.dsub.bug_(11, ri);
		return false;

	}

	/* A1-- ROBOT. PROCESS MOST COMMANDS GIVEN TO ROBOT. */

	public boolean do1000()
	{
		if (vars.prsvec_1.action != RAISE || vars.prsvec_1.direct_object != vars.oindex_1.rcage)
		{

			{
				return do1200();
			}
		}
		vars.cevent_1.cflag[vars.cindex_1.cevsph - 1] = false;
		/* ROBOT RAISED CAGE. */
		vars.play_1.winner = PLAYER;
		/* RESET FOR PLAYER. */
		game.dso2.moveto_(vars.rindex_1.cager, vars.play_1.winner);
		/* MOVE TO NEW ROOM. */
		game.dsub.newsta_(vars.oindex_1.cage, 567, vars.rindex_1.cager, 0, 0);
		/* INSTALL CAGE IN ROOM. */
		game.dsub.newsta_(vars.oindex_1.robot, 0, vars.rindex_1.cager, 0, 0);
		/* INSTALL ROBOT IN ROOM. */
		vars.advs_1.aroom[ROBOT - 1] = vars.rindex_1.cager;
		/* ALSO MOVE ROBOT/ADV. */
		vars.findex_1.cagesf = true;
		/* CAGE SOLVED. */
		vars.objcts_1.oflag1[vars.oindex_1.robot - 1] &= ~Vars.NDSCBT;
		vars.objcts_1.oflag1[vars.oindex_1.spher - 1] |= Vars.TAKEBT;
		return true;
	}

	public boolean do1200()
	{
		if (vars.prsvec_1.action != DRINK && vars.prsvec_1.action != EAT)
		{
			if (vars.prsvec_1.action != READ)
			{
				{
					return do1400();
				}
			}
			/* READ, */
			game.dsub.rspeak_(569);
			/* JOKE. */
			return true;
		}
		game.dsub.rspeak_(568);
		/* EAT OR DRINK, JOKE. */
		return true;
	}

	public boolean do1400()
	{
		if (vars.prsvec_1.action == WALK || vars.prsvec_1.action == TAKE
				|| vars.prsvec_1.action == DROP || vars.prsvec_1.action == PUT
				|| vars.prsvec_1.action == PUSH || vars.prsvec_1.action == THROW
				|| vars.prsvec_1.action == TURN || vars.prsvec_1.action == LEAP)
		{
			return false;
		}
		game.dsub.rspeak_(570);
		/* JOKE. */
		return true;
	}
	/* AAPPLI, PAGE 3 */

	/* A2-- MASTER. PROCESS MOST COMMANDS GIVEN TO MASTER. */

	public boolean do2000()
	{
		if ((vars.objcts_1.oflag2[vars.oindex_1.qdoor - 1] & Vars.OPENBT) != 0)
		{
			{
				return do2100();
			}

		}
		game.dsub.rspeak_(783);
		/* NO MASTER YET. */
		return true;
	}

	public boolean do2100()
	{
		if (vars.prsvec_1.action != WALK)
		{
			{
				return do2200();
			}
		}
		/* WALK? */
		int i = 784;
		/* ASSUME WONT. */
		if (vars.play_1.here == vars.rindex_1.scorr
				&& (vars.prsvec_1.direct_object == vars.xsrch_1.xnorth
						|| vars.prsvec_1.direct_object == vars.xsrch_1.xenter)
				|| vars.play_1.here == vars.rindex_1.ncorr
						&& (vars.prsvec_1.direct_object == vars.xsrch_1.xsouth
								|| vars.prsvec_1.direct_object == vars.xsrch_1.xenter))
		{
			i = 785;
		}
		game.dsub.rspeak_(i);
		return true;
	}

	public boolean do2200()
	{
		if (vars.prsvec_1.action == TAKE || vars.prsvec_1.action == DROP
				|| vars.prsvec_1.action == PUT || vars.prsvec_1.action == THROW
				|| vars.prsvec_1.action == PUSH || vars.prsvec_1.action == TURN
				|| vars.prsvec_1.action == SPIN || vars.prsvec_1.action == TURN_TO
				|| vars.prsvec_1.action == FOLLOW || vars.prsvec_1.action == STAY
				|| vars.prsvec_1.action == OPEN || vars.prsvec_1.action == CLOSE
				|| vars.prsvec_1.action == KILL)
		{
			return false;
		}
		game.dsub.rspeak_(786);
		/* MASTER CANT DO IT. */
		return true;
	}
//	} /* aappli_ */

//	/* THIEFD-	INTERMOVE THIEF DEMON */
//
//	/* DECLARATIONS */

	void thiefd_()
	{

		int rhere = 0;

		/* SET UP DETAIL FLAG. */
		boolean once = false;

		do1025(rhere, once);
	}

	/* INIT FLAG. */
	public void do1025(int rhere, boolean once)
	{
		rhere = vars.objcts_1.oroom[vars.oindex_1.thief - 1];
		/* VISIBLE POS. */
		if (rhere != 0)
		{
			vars.hack_1.thfpos = rhere;
		}

		if (vars.hack_1.thfpos == vars.play_1.here)
		{
			do1100(rhere, once);
			return;
		}
		/* THIEF IN WIN RM? */
		if (vars.hack_1.thfpos != vars.rindex_1.treas)
		{
			do1400(rhere, once);
			return;
		}
		/* THIEF NOT IN TREAS? */

		/* THIEF IS IN TREASURE ROOM, AND WINNER IS NOT. */

		if (rhere == 0)
		{
			do1050(rhere, once);
			return;
		}
		/* VISIBLE? */
		game.dsub.newsta_(vars.oindex_1.thief, 0, 0, 0, 0);
		/* YES, VANISH. */
		rhere = 0;
		if (game.dsub.qhere_(vars.oindex_1.still, vars.rindex_1.treas)
				|| vars.objcts_1.oadv[vars.oindex_1.still - 1] == -vars.oindex_1.thief)
		{
			game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
		}
		do1050(rhere, once);
		return;
	}

	public void do1050(int rhere, boolean once)
	{
		int i__1 = -vars.oindex_1.thief;
		game.dso4.robadv_(i__1, vars.hack_1.thfpos, 0, 0);
		/* DROP VALUABLES. */
		if (game.dsub.qhere_(vars.oindex_1.egg, vars.hack_1.thfpos))
		{
			vars.objcts_1.oflag2[vars.oindex_1.egg - 1] |= Vars.OPENBT;
		}
		do1700(rhere, once);
		return;
	}

	/* THIEF AND WINNER IN SAME ROOM. */

	public void do1100(int rhere, boolean once)
	{
		if (vars.hack_1.thfpos == vars.rindex_1.treas)
		{
			do1700(rhere, once);
			return;
		}
		/* IF TREAS ROOM, NOTHING. */
		if ((vars.rooms_1.rflag[vars.hack_1.thfpos - 1] & Vars.RLIGHT) != 0)
		{
			do1400(rhere, once);
			return;
		}
		if (vars.hack_1.thfflg)
		{
			do1300(rhere, once);
			return;
		}
		/* THIEF ANNOUNCED? */
		if (rhere != 0 || game.dsub.prob_(70, 70))
		{
			do1150(rhere, once);
			return;
		}
		/* IF INVIS AND 30%. */
		if (vars.objcts_1.ocan[vars.oindex_1.still - 1] != vars.oindex_1.thief)
		{
			do1700(rhere, once);
			return;
		}
		/* ABORT IF NO STILLETTO. */
		game.dsub.newsta_(vars.oindex_1.thief, 583, vars.hack_1.thfpos, 0, 0);
		/* INSERT THIEF INTO ROOM. */
		vars.hack_1.thfflg = true;
		/* THIEF IS ANNOUNCED. */
		return;
	}

	public void do1150(int rhere, boolean once)
	{
		if (rhere == 0 || (vars.objcts_1.oflag2[vars.oindex_1.thief - 1] & Vars.FITEBT) == 0)
		{
			do1200(rhere, once);
			return;
		}
		if (game.dso4.winnin_(vars.oindex_1.thief, vars.play_1.winner))
		{
			do1175(rhere, once);
			return;
		}
		/* WINNING? */
		game.dsub.newsta_(vars.oindex_1.thief, 584, 0, 0, 0);
		/* NO, VANISH THIEF. */
		vars.objcts_1.oflag2[vars.oindex_1.thief - 1] &= ~Vars.FITEBT;
		if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos)
				|| vars.objcts_1.oadv[vars.oindex_1.still - 1] == -vars.oindex_1.thief)
		{
			game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
		}
		return;
	}

	public void do1175(int rhere, boolean once)
	{
		if (game.dsub.prob_(90, 90))
		{
			do1700(rhere, once);
			return;
		}
		/* 90% CHANCE TO STAY. */
		do1200(rhere, once);
		return;
	}

	public void do1200(int rhere, boolean once)
	{
		if (rhere == 0 || game.dsub.prob_(70, 70))
		{
			do1250(rhere, once);
			return;
		}
		/* IF VISIBLE AND 30% */
		game.dsub.newsta_(vars.oindex_1.thief, 585, 0, 0, 0);
		/* VANISH THIEF. */
		if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos)
				|| vars.objcts_1.oadv[vars.oindex_1.still - 1] == -vars.oindex_1.thief)
		{
			game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
		}
		return;
	}

	public void do1300(int rhere, boolean once)
	{
		if (rhere == 0)
		{
			do1700(rhere, once);
			return;
		}
		do1250(rhere, once);
		return;
	}

	/* ANNOUNCED. VISIBLE? */
	public void do1250(int rhere, boolean once)
	{
		if (game.dsub.prob_(70, 70))
		{
			return;
		}
		/* 70% CHANCE TO DO NOTHING. */
		vars.hack_1.thfflg = true;
		int i__1 = -vars.oindex_1.thief;
		int i__2 = -vars.oindex_1.thief;
		int nr = game.dso4.robrm_(vars.hack_1.thfpos, 100, 0, 0, i__1)
				+ game.dso4.robadv_(vars.play_1.winner, 0, 0, i__2);
		int i = 586;
		/* ROBBED EM. */
		if (rhere != 0)
		{
			i = 588;
		}
		/* WAS HE VISIBLE? */
		if (nr != 0)
		{
			++i;
		}
		/* DID HE GET ANYTHING? */
		game.dsub.newsta_(vars.oindex_1.thief, i, 0, 0, 0);
		/* VANISH THIEF. */
		if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos)
				|| vars.objcts_1.oadv[vars.oindex_1.still - 1] == -vars.oindex_1.thief)
		{
			game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
		}
		if (nr != 0 && !game.dso5.lit_(vars.hack_1.thfpos))
		{
			game.dsub.game.dsub.rspeak_(406);
		}
		rhere = 0;

		do1700(rhere, once);
		return;
	}
	/* ONWARD. */

	/* NOT IN ADVENTURERS ROOM. */
	public void do1400(int rhere, boolean once)
	{
		game.dsub.newsta_(vars.oindex_1.thief, 0, 0, 0, 0);
		/* VANISH. */
		rhere = 0;
		if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos)
				|| vars.objcts_1.oadv[vars.oindex_1.still - 1] == -vars.oindex_1.thief)
		{
			game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
		}
		if ((vars.rooms_1.rflag[vars.hack_1.thfpos - 1] & Vars.RSEEN) == 0)
		{
			do1700(rhere, once);
			return;
		}
		int i__1 = -vars.oindex_1.thief;
		int i = game.dso4.robrm_(vars.hack_1.thfpos, 75, 0, 0, i__1);
		/* ROB ROOM 75%. */
		if (vars.hack_1.thfpos < vars.rindex_1.maze1 || vars.hack_1.thfpos > vars.rindex_1.maz15
				|| vars.play_1.here < vars.rindex_1.maze1 || vars.play_1.here > vars.rindex_1.maz15)
		{
			do1500(rhere, once);
			return;
		}
		i__1 = vars.objcts_1.olnt;
		for (i = 1; i <= i__1; ++i)
		{
			/* BOTH IN MAZE. */
			if (!game.dsub.qhere_(i, vars.hack_1.thfpos) || game.dsub.prob_(60, 60)
					|| (vars.objcts_1.oflag1[i - 1] & Vars.VISIBT + Vars.TAKEBT) != Vars.VISIBT
							+ Vars.TAKEBT)
			{
				continue;
			}
			game.dsub.rspsub_(590, vars.objcts_1.odesc2[i - 1]);
			/* TAKE OBJECT. */
			if (game.dsub.prob_(40, 20))
			{
				do1700(rhere, once);
				return;
			}
			int i__2 = -vars.oindex_1.thief;
			game.dsub.newsta_(i, 0, 0, 0, i__2);
			/* MOST OF THE TIME. */
			vars.objcts_1.oflag2[i - 1] |= Vars.TCHBT;
			{
				do1700(rhere, once);
				return;
			}
		}

		do1700(rhere, once);
		return;
	}

	public void do1500(int rhere, boolean once)
	{
		int i__1 = vars.objcts_1.olnt;
		for (int i = 1; i <= i__1; ++i)
		{
			/* NOT IN MAZE. */
			if (!game.dsub.qhere_(i, vars.hack_1.thfpos) || vars.objcts_1.otval[i - 1] != 0
					|| game.dsub.prob_(80, 60)
					|| (vars.objcts_1.oflag1[i - 1] & Vars.VISIBT + Vars.TAKEBT) != Vars.VISIBT
							+ Vars.TAKEBT)
			{
				{
					continue;
				}
			}
			int i__2 = -vars.oindex_1.thief;
			game.dsub.newsta_(i, 0, 0, 0, i__2);
			vars.objcts_1.oflag2[i - 1] |= Vars.TCHBT;
			{
				do1700(rhere, once);
				return;
			}
		}

		do1700(rhere, once);
		return;
	}

	/* NOW MOVE TO NEW ROOM. */
	public void do1700(int rhere, boolean once)
	{
		if (vars.objcts_1.oadv[vars.oindex_1.rope - 1] == -vars.oindex_1.thief)
		{
			vars.findex_1.domef = false;
		}
		if (once)
		{
			do1800();
			return;
		}
		once = !once;
		do1750(rhere, once);
		return;
	}

	public void do1750(int rhere, boolean once)
	{
		--vars.hack_1.thfpos;
		/* NEXT ROOM. */
		if (vars.hack_1.thfpos <= 0)
		{
			vars.hack_1.thfpos = vars.rooms_1.rlnt;
		}
		if ((vars.rooms_1.rflag[vars.hack_1.thfpos - 1]
				& Vars.RLAND + Vars.RSACRD + Vars.REND) != Vars.RLAND)
		{
			do1750(rhere, once);
			return;
		}
		vars.hack_1.thfflg = false;
		/* NOT ANNOUNCED. */

		do1025(rhere, once);
		return;
	}

	/* ONCE MORE. */

	/* ALL DONE. */
	public void do1800()
	{
		if (vars.hack_1.thfpos == vars.rindex_1.treas)
		{
			return;
		}
		/* IN TREASURE ROOM? */
		int j = 591;
		/* NO, DROP STUFF. */
		if (vars.hack_1.thfpos != vars.play_1.here)
		{
			j = 0;
		}
		int i__1 = vars.objcts_1.olnt;
		for (int i = 1; i <= i__1; ++i)
		{
			if (vars.objcts_1.oadv[i - 1] != -vars.oindex_1.thief || game.dsub.prob_(70, 70)
					|| vars.objcts_1.otval[i - 1] > 0)
			{
				{
					continue;
				}
			}
			game.dsub.newsta_(i, j, vars.hack_1.thfpos, 0, 0);
			j = 0;

		}
		return;
	}
}
