package zork;

public class Lightp implements Constants
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

		/* Local variables */
		int flobts;

		/* ASSUME WINS */
		flobts = Vars.FLAMBT + Vars.LITEBT + Vars.ONBT;
		if (obj != vars.oindex_1.candl)
		{
			return do20000(obj, flobts);
		}

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
		/* BURNING WHEN SEEN. */
		return do19100();
	}

	public boolean do19100()
	{

		if (vars.prsvec_1.indirect_object == vars.oindex_1.candl)
		{
			return false;
		}
		/* IGNORE IND REFS. */
		if (vars.prsvec_1.action != TURN_OFF)
		{
			return do19200();
		}
		/* TURN OFF? */
		int i = 513;
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
		return true;
	}

	/* HERE FOR FALSE RETURN */

	public boolean do19200()
	{
		if (vars.prsvec_1.action != BURN && vars.prsvec_1.action != TURN_ON)
		{

			return false;
		}
		if ((vars.objcts_1.oflag1[vars.oindex_1.candl - 1] & Vars.LITEBT) != 0)
		{
			do19300();
			return true;
		}
		game.dsub.rspeak_(515);
		/* CANDLES TOO SHORT. */
		return true;
	}

	public void do19300()
	{
		if (vars.prsvec_1.indirect_object != 0)
		{
			do19400();
			return;
		}
		/* ANY FLAME? */
		game.dsub.rspeak_(516);
		/* NO, LOSE. */
		vars.prsvec_1.is_parsed = false;
	}

	public void do19400()
	{
		if (vars.prsvec_1.indirect_object != vars.oindex_1.match
				|| !((vars.objcts_1.oflag1[vars.oindex_1.match - 1] & Vars.ONBT) != 0))
		{
			do19500();
			return;
		}
		int i = 517;
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
	}

	public void do19500()
	{
		if (vars.prsvec_1.indirect_object != vars.oindex_1.torch
				|| !((vars.objcts_1.oflag1[vars.oindex_1.torch - 1] & Vars.ONBT) != 0))
		{
			game.dsub.rspeak_(519);
			/* CANT LIGHT WITH THAT. */
			return;
		}
		if ((vars.objcts_1.oflag1[vars.oindex_1.candl - 1] & Vars.ONBT) != 0)
		{
			game.dsub.rspeak_(520);
			/* ALREADY ON. */
			return;
		}
		/* ALREADY ON? */
		game.dsub.newsta_(vars.oindex_1.candl, 521, 0, 0, 0);
		/* NO, VAPORIZE. */
		return;

	}

	public boolean do20000(int obj, int flobts)
	{
		if (obj != vars.oindex_1.match)
		{
			game.dsub.bug_(6, obj);
		}
		if (vars.prsvec_1.action != TURN_ON || vars.prsvec_1.direct_object != vars.oindex_1.match)
		{

			return do20500(flobts);
		}
		if (vars.findex_1.ormtch != 0)
		{
			return do20100(flobts);
		}
		/* ANY MATCHES LEFT? */
		game.dsub.rspeak_(183);
		/* NO, LOSE. */
		return true;
	}

	public boolean do20100(int flobts)
	{
		--vars.findex_1.ormtch;
		/* DECREMENT NO MATCHES. */
		vars.objcts_1.oflag1[vars.oindex_1.match - 1] |= flobts;
		vars.cevent_1.ctick[vars.cindex_1.cevmat - 1] = 2;
		/* COUNTDOWN. */
		game.dsub.rspeak_(184);
		return true;
	}

	public boolean do20500(int flobts)
	{
		if (vars.prsvec_1.action != TURN_OFF
				|| (vars.objcts_1.oflag1[vars.oindex_1.match - 1] & Vars.ONBT) == 0)
		{
			return false;
		}
		vars.objcts_1.oflag1[vars.oindex_1.match - 1] &= ~flobts;
		vars.cevent_1.ctick[vars.cindex_1.cevmat - 1] = 0;
		game.dsub.rspeak_(185);
		return true;
	}

}
