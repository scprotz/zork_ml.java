package zork;

import java.io.IOException;

public class Ballop
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

	boolean ballop_(int arg) throws IOException
	{
		/* System generated locals */
		boolean ret_val;
		int GOTO = 50;
		ret_val = true;
		/* !ASSUME WINS. */
		if (arg != 2)
		{
			GOTO = 200;
		}
		if (GOTO != 200)
		{
			/* !READOUT? */
			if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
			{
				return false;
			}
			/* !ONLY PROCESS LOOK. */
			boolean skip = false;
			if (vars.findex_1.binff != 0)
			{
				skip = true;
			}
			if (!skip)
			{
				/* !INFLATED? */
				game.dsub.rspeak_(543);
				/* !NO. */
				GOTO = 100;
			}
		}
		do
		{
			switch (GOTO)
			{

				case 50:
					game.dsub.rspsub_(544, vars.objcts_1.odesc2[vars.findex_1.binff - 1]);
					/* !YES. */
				case 100:
					if (vars.findex_1.btief != 0)
					{
						game.dsub.rspeak_(545);
					}
					/* !HOOKED? */
					return ret_val;

				case 200:
					if (arg != 1)
					{
						GOTO = 500;
						continue;
					}
					/* !READIN? */
					if (vars.prsvec_1.prsa != vars.vindex_1.walkw)
					{
						GOTO = 300;
						continue;
					}
					/* !WALK? */
					if (game.dso3.findxt_(vars.prsvec_1.prso, vars.play_1.here))
					{
						GOTO = 250;
						continue;
					}
					/* !VALID EXIT? */
					game.dsub.rspeak_(546);
					/* !NO, JOKE. */
					return ret_val;

				case 250:
					if (vars.findex_1.btief == 0)
					{
						GOTO = 275;
						continue;
					}
					/* !TIED UP? */
					game.dsub.rspeak_(547);
					/* !YES, JOKE. */
					return ret_val;

				case 275:
					if (vars.curxt_1.xtype != vars.xpars_1.xnorm)
					{
						GOTO = 10;
						continue;
					}
					/* !NORMAL EXIT? */
					if ((vars.rooms_1.rflag[vars.curxt_1.xroom1 - 1] & Vars.RMUNG) == 0)
					{
						vars.state_1.bloc = vars.curxt_1.xroom1;
					}
				case 10:
					ret_val = false;
					return ret_val;

				case 300:
					if (vars.prsvec_1.prsa != vars.vindex_1.takew
							|| vars.prsvec_1.prso != vars.findex_1.binff)
					{
						GOTO = 350;
						continue;
					}
					game.dsub.rspsub_(548, vars.objcts_1.odesc2[vars.findex_1.binff - 1]);
					/* !RECEP CONT TOO HOT. */
					return ret_val;

				case 350:
					if (vars.prsvec_1.prsa != vars.vindex_1.putw
							|| vars.prsvec_1.prsi != vars.oindex_1.recep
							|| game.dsub.qempty_(vars.oindex_1.recep))
					{
						GOTO = 10;
						continue;
					}
					game.dsub.rspeak_(549);
					return false;

				case 500:
					if (vars.prsvec_1.prsa != vars.vindex_1.unboaw
							|| (vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RLAND) == 0)
					{
						GOTO = 600;
						continue;
					}
					if (vars.findex_1.binff != 0)
					{
						vars.cevent_1.ctick[vars.cindex_1.cevbal - 1] = 3;
					}
					/* !HE GOT OUT, START BALLOON. */
					return false;
				case 600:
					if (vars.prsvec_1.prsa != vars.vindex_1.burnw
							|| vars.objcts_1.ocan[vars.prsvec_1.prso - 1] != vars.oindex_1.recep)
					{
						GOTO = 700;
						continue;
					}
					game.dsub.rspsub_(550, vars.objcts_1.odesc2[vars.prsvec_1.prso - 1]);
					/* !LIGHT FIRE IN RECEP. */
					vars.cevent_1.ctick[vars.cindex_1.cevbrn
							- 1] = vars.objcts_1.osize[vars.prsvec_1.prso - 1] * 20;
					vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] |= Vars.ONBT + Vars.FLAMBT
							+ Vars.LITEBT & ~(Vars.TAKEBT + Vars.READBT);
					if (vars.findex_1.binff != 0)
					{
						return ret_val;
					}
					if (!vars.findex_1.blabf)
					{
						game.dsub.newsta_(vars.oindex_1.blabe, 0, 0, vars.oindex_1.ballo, 0);
					}
					vars.findex_1.blabf = true;
					vars.findex_1.binff = vars.prsvec_1.prso;
					vars.cevent_1.ctick[vars.cindex_1.cevbal - 1] = 3;
					game.dsub.rspeak_(551);
					return ret_val;

				case 700:
					if (vars.prsvec_1.prsa == vars.vindex_1.unboaw && vars.findex_1.binff != 0
							&& (vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RLAND) != 0)
					{
						vars.cevent_1.ctick[vars.cindex_1.cevbal - 1] = 3;
					}

					return false;
			}
		} while (true);

	} /* ballop_ */

}
