package zork;

import java.io.IOException;

public class Dso2
{
	/* MOVETO- MOVE PLAYER TO NEW ROOM */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Dso2(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean moveto_(
	int nr,
	int who) throws IOException
	{
	    /* System generated locals */
	    boolean ret_val;

	    /* Local variables */
	    int j;
	    boolean lhr;
	    boolean lnr, nlv;
	    int bits;

	    ret_val = false;
	/* ASSUME FAILS. */
	    lhr = (vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RLAND) != 0;
	    lnr = (vars.rooms_1.rflag[nr - 1] & Vars.RLAND) != 0;
	    j = vars.advs_1.avehic[who - 1];
	/* HIS VEHICLE */
	    
	    if (j == 0) 
	    {
	
		/* IN VEHICLE? */
		    if (lnr) 
		    {
		    	ret_val = true;
		    	/* MOVE SHOULD SUCCEED. */
		    	    if ((vars.rooms_1.rflag[nr - 1] & Vars.RMUNG) == 0) {
		    	    	if (who != vars.aindex_1.player) {
		    	    		game.dsub.newsta_(vars.advs_1.aobj[who - 1], 0, nr, 0, 0);
		    	    	    }
		    	    	    if (j != 0) {
		    	    		game.dsub.newsta_(j, 0, nr, 0, 0);
		    	    	    }
		    	    	    vars.play_1.here = nr;
		    	    	    vars.advs_1.aroom[who - 1] = vars.play_1.here;
		    	    	    scrupd_(vars.rooms_1.rval[nr - 1]);
		    	    	/* SCORE ROOM */
		    	    	    vars.rooms_1.rval[nr - 1] = 0;
		    	    	    return ret_val;		    	    }
		    	    game.dsub.rspeak_(vars.rooms_1.rrand(nr - 1));
		    	/* YES, TELL HOW. */
		    	    return ret_val;
		    }
		/* NO, GOING TO LAND? */
		    game.dsub.rspeak_(427);
		    /* CAN'T GO WITHOUT VEHICLE. */
		    return ret_val;
	    }
//	L100:
	    bits = 0;
	/* ASSUME NOWHERE. */
	    if (j == vars.oindex_1.rboat) {
		bits = Vars.RWATER;
	    }
	/* IN BOAT? */
	    if (j == vars.oindex_1.ballo) {
		bits = Vars.RAIR;
	    }
	/* IN BALLOON? */
	    if (j == vars.oindex_1.bucke) {
		bits = Vars.RBUCK;
	    }
	/* IN BUCKET? */
	    nlv = (vars.rooms_1.rflag[nr - 1] & bits) == 0;
	    if (! lnr && nlv || lnr && lhr && nlv && bits != Vars.RLAND) {
	    	game.dsub.rspsub_(428, vars.objcts_1.odesc2[j - 1]);
	    	/* WRONG VEHICLE. */
	    	    return ret_val;
	    }

//	L500:
	    ret_val = true;
	/* MOVE SHOULD SUCCEED. */
	    if ((vars.rooms_1.rflag[nr - 1] & Vars.RMUNG) == 0) {
	    	  if (who != vars.aindex_1.player) {
	    			game.dsub.newsta_(vars.advs_1.aobj[who - 1], 0, nr, 0, 0);
	    		    }
	    		    if (j != 0) {
	    			game.dsub.newsta_(j, 0, nr, 0, 0);
	    		    }
	    		    vars.play_1.here = nr;
	    		    vars.advs_1.aroom[who - 1] = vars.play_1.here;
	    		    scrupd_(vars.rooms_1.rval[nr - 1]);
	    		/* SCORE ROOM */
	    		    vars.rooms_1.rval[nr - 1] = 0;
	    		    return ret_val;
	    }
	    game.dsub.rspeak_(vars.rooms_1.rrand(nr - 1));
	/* YES, TELL HOW. */
	    return ret_val;

//	L600:
//	    if (who != vars.aindex_1.player) {
//		game.dsub.newsta_(vars.advs_1.aobj[who - 1], 0, nr, 0, 0);
//	    }
//	    if (j != 0) {
//		game.dsub.newsta_(j, 0, nr, 0, 0);
//	    }
//	    vars.play_1.here = nr;
//	    vars.advs_1.aroom[who - 1] = vars.play_1.here;
//	    scrupd_(vars.rooms_1.rval[nr - 1]);
//	/* SCORE ROOM */
//	    vars.rooms_1.rval[nr - 1] = 0;
//	    return ret_val;

//	L800:
//	    game.dsub.rspsub_(428, vars.objcts_1.odesc2[j - 1]);
//	/* WRONG VEHICLE. */
//	    return ret_val;
	} /* moveto_ */

	static final int[] rank = new int[] { 20, 19, 18, 16, 12, 8, 4, 2, 1, 0 };
	static final int[] erank = new int[] { 20, 15, 10, 5, 0 };

	/* SCORE-- PRINT OUT CURRENT SCORE */
	void score_(boolean flg) throws IOException
	{
		/* Initialized data */

		/* Local variables */
		int i, as;

		as = vars.advs_1.ascore[vars.play_1.winner - 1];

		if (vars.findex_1.endgmf)
		{
			Supp.more_output(null);
			System.out.printf("Your score in the endgame ");
			if (flg)
				System.out.printf("would be");
			else
				System.out.printf("is");
			System.out.printf(" %d [total of %d points], in %d moves.\n", vars.state_1.egscor,
					vars.state_1.egmxsc, vars.state_1.moves);

			for (i = 1; i <= 5; ++i)
			{
				if (vars.state_1.egscor * 20 / vars.state_1.egmxsc >= erank[i - 1])
				{
					game.dsub.rspeak_(i + 786);
					break;
				}
			}
		}
		/* !ENDGAME? */
		Supp.more_output(null);
		System.out.printf("Your score ");
		if (flg)
			System.out.printf("would be");
		else
			System.out.printf("is");
		System.out.printf(" %d [total of %d points], in %d move", as, vars.state_1.mxscor,
				vars.state_1.moves);
		if (vars.state_1.moves != 1)
			System.out.printf("s");
		System.out.printf(".\n");

		for (i = 1; i <= 10; ++i)
		{
			if (as * 20 / vars.state_1.mxscor >= rank[i - 1])
			{
				game.dsub.rspeak_(i + 484);
				return;
			}
		}
	} /* score_ */

	/* SCRUPD- UPDATE WINNER'S SCORE */
	void scrupd_(int n)
	{
		if (vars.findex_1.endgmf)
		{
			vars.state_1.egscor += n;
			return;
			/* !UPDATE EG SCORE. */
		}
		/* !ENDGAME? */
		vars.advs_1.ascore[vars.play_1.winner - 1] += n;
		/* !UPDATE SCORE */
		vars.state_1.rwscor += n;
		/* !UPDATE RAW SCORE */
		if (vars.advs_1.ascore[vars.play_1.winner - 1] < vars.state_1.mxscor
				- vars.state_1.deaths * 10)
		{
			return;
		}
		vars.cevent_1.cflag[vars.cindex_1.cevegh - 1] = true;
		/* !TURN ON END GAME */
		vars.cevent_1.ctick[vars.cindex_1.cevegh - 1] = 15;
		return;

	} /* scrupd_ */

}
