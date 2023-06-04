package zork;

import java.io.IOException;

public class Lightp
{
	/* LIGHTP- LIGHT PROCESSOR */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Lightp(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean lightp_(int obj)
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int flobts;
		int i;

		int GOTO = 19100;
		ret_val = true;
		/* ASSUME WINS */
		flobts = Vars.FLAMBT + Vars.LITEBT + Vars.ONBT;
		if (obj != vars.oindex_1.candl)
		{
			GOTO = 20000;
		}

		if (GOTO != 20000)
		{
			/* CANDLE? */
			boolean skip = false;
			if (vars.findex_1.orcand != 0)
			{
				skip = true;
			}
			if (!skip)
			{
				/* FIRST REF? */
				vars.findex_1.orcand = 1;
				/* YES, CANDLES ARE */
				vars.cevent_1.ctick[vars.cindex_1.cevcnd - 1] = 50;
			}
		}
		/* BURNING WHEN SEEN. */

		do
		{
			switch (GOTO)
			{

				case 19100:
					if (vars.prsvec_1.prsi == vars.oindex_1.candl)
					{
						return false;
					}
					/* IGNORE IND REFS. */
					if (vars.prsvec_1.prsa != vars.vindex_1.trnofw)
					{
						GOTO = 19200;
						continue;
					}
					/* TURN OFF? */
					i = 513;
					/* ASSUME OFF. */
					if ((vars.objcts_1.oflag1[vars.oindex_1.candl - 1] & Vars.ONBT) != 0)
					{
						i = 514;
					}
					/* IF ON, DIFFERENT. */
					vars.cevent_1.cflag[vars.cindex_1.cevcnd - 1] = false;
					/* DISABLE COUNTDOWN. */
					vars.objcts_1.oflag1[vars.oindex_1.candl - 1] &= ~Vars.ONBT;
					game.dsub.rspeak_(i);
					return ret_val;

				case 19200:
					if (vars.prsvec_1.prsa != vars.vindex_1.burnw
							&& vars.prsvec_1.prsa != vars.vindex_1.trnonw)
					{

						return false;
					}
					if ((vars.objcts_1.oflag1[vars.oindex_1.candl - 1] & Vars.LITEBT) != 0)
					{
						GOTO = 19300;
						continue;
					}
					game.dsub.rspeak_(515);
					/* CANDLES TOO SHORT. */
					return ret_val;

				case 19300:
					if (vars.prsvec_1.prsi != 0)
					{
						GOTO = 19400;
						continue;
					}
					/* ANY FLAME? */
					game.dsub.rspeak_(516);
					/* NO, LOSE. */
					vars.prsvec_1.parsed_successfully = false;
					return ret_val;

				case 19400:
					if (vars.prsvec_1.prsi != vars.oindex_1.match
							|| !((vars.objcts_1.oflag1[vars.oindex_1.match - 1] & Vars.ONBT) != 0))
					{
						GOTO = 19500;
						continue;
					}
					i = 517;
					/* ASSUME OFF. */
					if ((vars.objcts_1.oflag1[vars.oindex_1.candl - 1] & Vars.ONBT) != 0)
					{
						i = 518;
					}
					/* IF ON, JOKE. */
					vars.objcts_1.oflag1[vars.oindex_1.candl - 1] |= Vars.ONBT;
					vars.cevent_1.cflag[vars.cindex_1.cevcnd - 1] = true;
					/* RESUME COUNTDOWN. */
					game.dsub.rspeak_(i);
					return ret_val;

				case 19500:
					if (vars.prsvec_1.prsi != vars.oindex_1.torch
							|| !((vars.objcts_1.oflag1[vars.oindex_1.torch - 1] & Vars.ONBT) != 0))
					{
						GOTO = 19600;
						continue;
					}
					if ((vars.objcts_1.oflag1[vars.oindex_1.candl - 1] & Vars.ONBT) != 0)
					{
						GOTO = 19700;
						continue;
					}
					/* ALREADY ON? */
					game.dsub.newsta_(vars.oindex_1.candl, 521, 0, 0, 0);
					/* NO, VAPORIZE. */
					return ret_val;

				case 19600:
					game.dsub.rspeak_(519);
					/* CANT LIGHT WITH THAT. */
					return ret_val;

				case 19700:
					game.dsub.rspeak_(520);
					/* ALREADY ON. */
					return ret_val;

				case 20000:
					if (obj != vars.oindex_1.match)
					{
						game.dsub.bug_(6, obj);
					}
					if (vars.prsvec_1.prsa != vars.vindex_1.trnonw
							|| vars.prsvec_1.prso != vars.oindex_1.match)
					{

						GOTO = 20500;
						continue;
					}
					if (vars.findex_1.ormtch != 0)
					{
						GOTO = 20100;
						continue;
					}
					/* ANY MATCHES LEFT? */
					game.dsub.rspeak_(183);
					/* NO, LOSE. */
					return ret_val;

				case 20100:
					--vars.findex_1.ormtch;
					/* DECREMENT NO MATCHES. */
					vars.objcts_1.oflag1[vars.oindex_1.match - 1] |= flobts;
					vars.cevent_1.ctick[vars.cindex_1.cevmat - 1] = 2;
					/* COUNTDOWN. */
					game.dsub.rspeak_(184);
					return ret_val;

				case 20500:
					if (vars.prsvec_1.prsa != vars.vindex_1.trnofw
							|| (vars.objcts_1.oflag1[vars.oindex_1.match - 1] & Vars.ONBT) == 0)
					{
						return false;
					}
					vars.objcts_1.oflag1[vars.oindex_1.match - 1] &= ~flobts;
					vars.cevent_1.ctick[vars.cindex_1.cevmat - 1] = 0;
					game.dsub.rspeak_(185);
					return ret_val;
			}
		} while (true);

		/* HERE FOR FALSE RETURN */

//	case 10:
//	    ret_val = false;
//	    return ret_val;
//	    throw new RuntimeException("Lightp.lightp_ not impl");
	} /* lightp_ */

}
