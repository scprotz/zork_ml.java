package zork;

public class Ballop implements Actions
{
	/* BALLOP- BALLOON FUNCTION */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Ballop(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean ballop_(int arg)
	{
		if (arg != 2)
		{
			return do200(arg);
		}

		/* READOUT? */
		if (vars.prsvec_1.action != LOOK)
		{
			return false;
		}
		/* ONLY PROCESS LOOK. */
		boolean skip = false;
		if (vars.findex_1.binff != 0)
		{
			skip = true;
		}
		if (!skip)
		{
			/* INFLATED? */
			game.dsub.rspeak_(543);
			/* NO. */
			return do100();
		}

		game.dsub.rspsub_(544, vars.objcts_1.odesc2[vars.findex_1.binff - 1]);
		/* YES. */
		return do100();

	} /* ballop_ */

	public boolean do100()
	{
		// HOOKED? //
		if (vars.findex_1.btief != 0)
		{
			game.dsub.rspeak_(545);
		}		
		return true;
	}

	public boolean do200(int arg)
	{
		// READIN? //
		if (arg != 1)
		{
			return do500();
		}
		
		// WALK? //
		if (vars.prsvec_1.action != WALK)
		{
			return do300();
		}
		
		// VALID EXIT? //
		if (game.dso3.findxt_(vars.prsvec_1.direct_object, vars.play_1.here))
		{
			return do250();
		}
		
		game.dsub.rspeak_(546);
		/* NO, JOKE. */
		return true;
	}

	public boolean do250()
	{
		// TIED UP? //
		if (vars.findex_1.btief == 0)
		{
			return do275();
		}
		
		// YES, JOKE. //
		game.dsub.rspeak_(547);
		
		return true;
	}

	public boolean do275()
	{
		// NORMAL EXIT? //
		if (vars.curxt_1.xtype != vars.xpars_1.xnorm)
		{
			return false;
		}
		if ((vars.rooms_1.rflag[vars.curxt_1.xroom1 - 1] & Vars.RMUNG) == 0)
		{
			vars.state_1.bloc = vars.curxt_1.xroom1;
		}
		return false;
	}

	public boolean do300()
	{
		if (vars.prsvec_1.action != TAKE || vars.prsvec_1.direct_object != vars.findex_1.binff)
		{
			return do350();
		}
		game.dsub.rspsub_(548, vars.objcts_1.odesc2[vars.findex_1.binff - 1]);
		/* RECEP CONT TOO HOT. */
		return true;
	}

	public boolean do350()
	{
		if (vars.prsvec_1.action != PUT 
				|| vars.prsvec_1.indirect_object != vars.oindex_1.recep
				|| game.dsub.qempty_(vars.oindex_1.recep))
		{
			return false;
		}
		game.dsub.rspeak_(549);
		return false;
	}

	public boolean do500()
	{
		// HE GOT OUT, START BALLOON. //
		if (vars.prsvec_1.action != UNBOARD
				|| (vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RLAND) == 0)
		{
			return do600();
		}
		if (vars.findex_1.binff != 0)
		{
			vars.cevent_1.ctick[vars.cindex_1.cevbal - 1] = 3;
		}
		return false;
	}

	public boolean do600()
	{
		if (vars.prsvec_1.action != BURN
				|| vars.objcts_1.ocan[vars.prsvec_1.direct_object - 1] != vars.oindex_1.recep)
		{
			return do700();
		}
		game.dsub.rspsub_(550, vars.objcts_1.odesc2[vars.prsvec_1.direct_object - 1]);
		/* LIGHT FIRE IN RECEP. */
		vars.cevent_1.ctick[vars.cindex_1.cevbrn
				- 1] = vars.objcts_1.osize[vars.prsvec_1.direct_object - 1] * 20;
		vars.objcts_1.oflag1[vars.prsvec_1.direct_object - 1] |= Vars.ONBT + Vars.FLAMBT
				+ Vars.LITEBT & ~(Vars.TAKEBT + Vars.READBT);
		if (vars.findex_1.binff != 0)
		{
			return true;
		}
		if (!vars.findex_1.blabf)
		{
			game.dsub.newsta_(vars.oindex_1.blabe, 0, 0, vars.oindex_1.ballo, 0);
		}
		vars.findex_1.blabf = true;
		vars.findex_1.binff = vars.prsvec_1.direct_object;
		vars.cevent_1.ctick[vars.cindex_1.cevbal - 1] = 3;
		game.dsub.rspeak_(551);
		return true;
	}

	public boolean do700()
	{
		if (vars.prsvec_1.action == UNBOARD && vars.findex_1.binff != 0
				&& (vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RLAND) != 0)
		{
			vars.cevent_1.ctick[vars.cindex_1.cevbal - 1] = 3;
		}

		return false;
	}

}
