package zork;

public class NRooms
{
	/* RAPPL2- SPECIAL PURPOSE ROOM ROUTINES, PART 2 */

	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;
	
	public NRooms(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean rappl2_(int ri)
	{
	    /* Initialized data */

	    final int newrms = 38;

	    /* System generated locals */
	    int i__1;
	    boolean ret_val;

	    /* Local variables */
	    int i = 0;
	    int j = 0;
	    int GOTO = 0;

	    ret_val = true;
	    switch (ri - newrms + 1) {
		case 1:  GOTO = 38000; break;
		case 2:  GOTO = 39000; break;
		case 3:  GOTO = 40000; break;
		case 4:  GOTO = 41000; break;
		case 5:  GOTO = 42000; break;
		case 6:  GOTO = 43000; break;
		case 7:  GOTO = 44000; break;
		case 8:  GOTO = 45000; break;
		case 9:  GOTO = 46000; break;
		case 10:  GOTO = 47000; break;
		case 11:  GOTO = 48000; break;
		case 12:  GOTO = 49000; break;
		case 13:  GOTO = 50000; break;
		case 14:  GOTO = 51000; break;
		case 15:  GOTO = 52000; break;
		case 16:  GOTO = 53000; break;
		case 17:  GOTO = 54000; break;
		case 18:  GOTO = 55000; break;
		case 19:  GOTO = 56000; break;
		case 20:  GOTO = 57000; break;
		case 21:  GOTO = 58000; break;
		case 22:  GOTO = 59000; break;
		case 23:  GOTO = 60000; break;
	    default:
	    	game.dsub.bug_(70, ri);
		    return ret_val;
	    }

	/* R38--	MIRROR D ROOM */
	    
	    loop: do
	    {
	    	switch(GOTO)
	    	{

	case 38000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.lookw) {
		lookto_(vars.rindex_1.fdoor, vars.rindex_1.mrg, 0, 682, 681);
	    }
	    return ret_val;

	/* R39--	MIRROR G ROOM */

	case 39000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.walkiw) {
		game.dsub.jigsup_(685);
	    }
	    return ret_val;

	/* R40--	MIRROR C ROOM */

	case 40000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.lookw) {
		lookto_(vars.rindex_1.mrg, vars.rindex_1.mrb, 683, 0, 681);
	    }
	    return ret_val;

	/* R41--	MIRROR B ROOM */

	case 41000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.lookw) {
		lookto_(vars.rindex_1.mrc, vars.rindex_1.mra, 0, 0, 681);
	    }
	    return ret_val;

	/* R42--	MIRROR A ROOM */

	case 42000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.lookw) {
		lookto_(vars.rindex_1.mrb, 0, 0, 684, 681);
	    }
	    return ret_val;
	/* RAPPL2, PAGE 3 */

	/* R43--	MIRROR C EAST/WEST */

	case 43000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.lookw) {
		ewtell_(vars.play_1.here, 683);
	    }
	    return ret_val;

	/* R44--	MIRROR B EAST/WEST */

	case 44000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.lookw) {
		ewtell_(vars.play_1.here, 686);
	    }
	    return ret_val;

	/* R45--	MIRROR A EAST/WEST */

	case 45000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.lookw) {
		ewtell_(vars.play_1.here, 687);
	    }
	    return ret_val;

	/* R46--	INSIDE MIRROR */

	case 46000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    game.dsub.rspeak_(688);
	/* DESCRIBE */

	/* NOW DESCRIBE POLE STATE. */

	/* CASES 1,2--	MDIR=270 & MLOC=MRB, POLE IS UP OR IN HOLE */
	/* CASES 3,4--	MDIR=0 V MDIR=180, POLE IS UP OR IN CHANNEL */
	/* CASE 5--	POLE IS UP */

	    i = 689;
	/* ASSUME CASE 5. */
	    if (vars.findex_1.mdir == 270 && vars.findex_1.mloc == vars.rindex_1.mrb) {
		i = Math.min(vars.findex_1.poleuf,1) + 690;
	    }
	    if (vars.findex_1.mdir % 180 == 0) {
		i = Math.min(vars.findex_1.poleuf,1) + 692;
	    }
	    game.dsub.rspeak_(i);
	/* DESCRIBE POLE. */
	    i__1 = vars.findex_1.mdir / 45 + 695;
	    game.dsub.rspsub_(694, i__1);
	/* DESCRIBE ARROW. */
	    return ret_val;
	/* RAPPL2, PAGE 4 */

	/* R47--	MIRROR EYE ROOM */

	case 47000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    i = 704;
	/* ASSUME BEAM STOP. */
	    i__1 = vars.objcts_1.olnt;
	    for (j = 1; j <= i__1; ++j) 
	    {
	    	if (game.dsub.qhere_(j, vars.play_1.here) && j != vars.oindex_1.rbeam) 
	    	{
	    		GOTO = 47200; continue loop;
	    	}
	/* case 47100: */
	    }
	    i = 703;
	case 47200:
	    game.dsub.rspsub_(i, vars.objcts_1.odesc2[j - 1]);
	/* DESCRIBE BEAM. */
	    lookto_(vars.rindex_1.mra, 0, 0, 0, 0);
	/* LOOK NORTH. */
	    return ret_val;

	/* R48--	INSIDE CRYPT */

	case 48000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    i = 46;
	/* CRYPT IS OPEN/CLOSED. */
	    if ((vars.objcts_1.oflag2[vars.oindex_1.tomb - 1] & Vars.OPENBT) != 0) {
		i = 12;
	    }
	    game.dsub.rspsub_(705, i);
	    return ret_val;

	/* R49--	SOUTH CORRIDOR */

	case 49000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    game.dsub.rspeak_(706);
	/* DESCRIBE. */
	    i = 46;
	/* ODOOR IS OPEN/CLOSED. */
	    if ((vars.objcts_1.oflag2[vars.oindex_1.odoor - 1] & Vars.OPENBT) != 0) {
		i = 12;
	    }
	    if (vars.findex_1.lcell == 4) {
		game.dsub.rspsub_(707, i);
	    }
	/* DESCRIBE ODOOR IF THERE. */
	    return ret_val;

	/* R50--	BEHIND DOOR */

	case 50000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.walkiw) {
		GOTO = 50100; continue loop;
	    }
	/* WALK IN? */
	    vars.cevent_1.cflag[vars.cindex_1.cevfol - 1] = true;
	/* MASTER FOLLOWS. */
	    vars.cevent_1.ctick[vars.cindex_1.cevfol - 1] = -1;
	    return ret_val;

	case 50100:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    i = 46;
	/* QDOOR IS OPEN/CLOSED. */
	    if ((vars.objcts_1.oflag2[vars.oindex_1.qdoor - 1] & Vars.OPENBT) != 0) {
		i = 12;
	    }
	    game.dsub.rspsub_(708, i);
	    return ret_val;
	/* RAPPL2, PAGE 5 */

	/* R51--	FRONT DOOR */

	case 51000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.walkiw) {
		vars.cevent_1.ctick[vars.cindex_1.cevfol - 1] = 0;
	    }
	/* IF EXITS, KILL FOLLOW. */
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    lookto_(0, vars.rindex_1.mrd, 709, 0, 0);
	/* DESCRIBE SOUTH. */
	    i = 46;
	/* PANEL IS OPEN/CLOSED. */
	    if (vars.findex_1.inqstf) {
		i = 12;
	    }
	/* OPEN IF INQ STARTED. */
	    j = 46;
	/* QDOOR IS OPEN/CLOSED. */
	    if ((vars.objcts_1.oflag2[vars.oindex_1.qdoor - 1] & Vars.OPENBT) != 0) {
		j = 12;
	    }
	    game.dsub.rspsb2_(710, i, j);
	    return ret_val;

	/* R52--	NORTH CORRIDOR */

	case 52000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    i = 46;
	    if ((vars.objcts_1.oflag2[vars.oindex_1.cdoor - 1] & Vars.OPENBT) != 0) {
		i = 12;
	    }
	/* CDOOR IS OPEN/CLOSED. */
	    game.dsub.rspsub_(711, i);
	    return ret_val;

	/* R53--	PARAPET */

	case 53000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.lookw) {
		i__1 = vars.findex_1.pnumb + 712;
		game.dsub.rspsub_(712, i__1);
	    }
	    return ret_val;

	/* R54--	CELL */

	case 54000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    i = 721;
	/* CDOOR IS OPEN/CLOSED. */
	    if ((vars.objcts_1.oflag2[vars.oindex_1.cdoor - 1] & Vars.OPENBT) != 0) {
		i = 722;
	    }
	    game.dsub.rspeak_(i);
	    i = 46;
	/* ODOOR IS OPEN/CLOSED. */
	    if ((vars.objcts_1.oflag2[vars.oindex_1.odoor - 1] & Vars.OPENBT) != 0) {
		i = 12;
	    }
	    if (vars.findex_1.lcell == 4) {
		game.dsub.rspsub_(723, i);
	    }
	/*						!DESCRIBE. */
	    return ret_val;

	/* R55--	PRISON CELL */

	case 55000:
	    if (vars.prsvec_1.prsa == vars.vindex_1.lookw) {
		game.dsub.rspeak_(724);
	    }
	/* LOOK? */
	    return ret_val;

	/* R56--	NIRVANA CELL */

	case 56000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    i = 46;
	/* ODOOR IS OPEN/CLOSED. */
	    if ((vars.objcts_1.oflag2[vars.oindex_1.odoor - 1] & Vars.OPENBT) != 0) {
		i = 12;
	    }
	    game.dsub.rspsub_(725, i);
	    return ret_val;
	/* RAPPL2, PAGE 6 */

	/* R57--	NIRVANA AND END OF GAME */

	case 57000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.walkiw) {
		return ret_val;
	    }
	/* WALKIN? */
	    game.dsub.rspeak_(726);
	    game.dso2.score_(false);
	/* moved to exit routine	CLOSE(DBCH) */
	    Supp.exit_();

	/* R58--	TOMB ROOM */

	case 58000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    i = 46;
	/* TOMB IS OPEN/CLOSED. */
	    if ((vars.objcts_1.oflag2[vars.oindex_1.tomb - 1] & Vars.OPENBT) != 0) {
		i = 12;
	    }
	    game.dsub.rspsub_(792, i);
	    return ret_val;

	/* R59--	PUZZLE SIDE ROOM */

	case 59000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    i = 861;
	/* ASSUME DOOR CLOSED. */
	    if (vars.findex_1.cpoutf) {
		i = 862;
	    }
	/* OPEN? */
	    game.dsub.rspeak_(i);
	/* DESCRIBE. */
	    return ret_val;

	/* R60--	PUZZLE ROOM */

	case 60000:
	    if (vars.prsvec_1.prsa != vars.vindex_1.lookw) {
		return ret_val;
	    }
	/* LOOK? */
	    if (vars.findex_1.cpushf) {
		GOTO = 60100; continue loop;
	    }
	/* STARTED PUZZLE? */
	    game.dsub.rspeak_(868);
	/* NO, DESCRIBE. */
	    if ((vars.objcts_1.oflag2[vars.oindex_1.warni - 1] & Vars.TCHBT) != 0) {
		game.dsub.rspeak_(869);
	    }
	    return ret_val;

	case 60100:
	    game.dso7.cpinfo_(880, vars.findex_1.cphere);
	/* DESCRIBE ROOM. */
	    return ret_val;
	    	}
	    }while(true);
	} /* rappl2_ */

	/* LOOKTO--	DESCRIBE VIEW IN MIRROR HALLWAY */

	/* DECLARATIONS */

	private void lookto_(int nrm, int srm, int nt, int st, int ht)
	{
	    /* System generated locals */
	    int i__1;

	    /* Local variables */
	    int i, m1, dir, mrbf;

	    game.dsub.rspeak_(ht);
	/* DESCRIBE HALL. */
	    game.dsub.rspeak_(nt);
	/* DESCRIBE NORTH VIEW. */
	    game.dsub.rspeak_(st);
	/* DESCRIBE SOUTH VIEW. */
	    dir = 0;
	/* ASSUME NO DIRECTION. */
	    i__1 = vars.findex_1.mloc - vars.play_1.here;
	    
	    int GOTO = 100;
	    
	    if ((Math.abs(i__1)) != 1) 
	    {
	    	GOTO = 200;
	    }
	    if(GOTO != 200)
	    {
		/* MIRROR TO N OR S? */
		    if (vars.findex_1.mloc == nrm) 
		    {
		    	dir = 695;
		    }
		    if (vars.findex_1.mloc == srm) 
		    {
		    	dir = 699;
		    }
		/* DIR=N/S. */
		    boolean skip = false;
		    if (vars.findex_1.mdir % 180 != 0) 
		    {
//		    	GOTO = 100;
		    	skip = true;
		    }
		    if(!skip)
		    {
		/* MIRROR N-S? */
			    game.dsub.rspsub_(847, dir);
			/* YES, HE SEES PANEL */
			    game.dsub.rspsb2_(848, dir, dir);
			/* AND NARROW ROOMS. */
			    GOTO = 200;
		    }
	    }
	    	switch(GOTO)
	    	{
				case 100:
				    m1 = game.dso6.mrhere_(vars.play_1.here);
				/* WHICH MIRROR? */
				    mrbf = 0;
				/* ASSUME INTACT. */
				    if (m1 == 1 && ! vars.findex_1.mr1f || m1 == 2 && ! vars.findex_1.mr2f) {
					mrbf = 1;
				    }
				    i__1 = mrbf + 849;
				    game.dsub.rspsub_(i__1, dir);
				/* DESCRIBE. */
				    if (m1 == 1 && vars.findex_1.mropnf) {
					i__1 = mrbf + 823;
					game.dsub.rspeak_(i__1);
				    }
				    if (mrbf != 0) {
					game.dsub.rspeak_(851);
				    }
			
				case 200:
				    i = 0;
				/* ASSUME NO MORE TO DO. */
				    if (nt == 0 && (dir == 0 || dir == 699)) {
					i = 852;
				    }
				    if (st == 0 && (dir == 0 || dir == 695)) {
					i = 853;
				    }
				    if (nt + st + dir == 0) {
					i = 854;
				    }
				    if (ht != 0) {
					game.dsub.rspeak_(i);
				    }
				    
	/* DESCRIBE HALLS. */
	    	}
	    
//	    throw new RuntimeException("Nrooms.lookto_ not impl.");
	} /* lookto_ */

	/* EWTELL--	DESCRIBE E/W NARROW ROOMS */

	/* DECLARATIONS */

	private void ewtell_(int rm, int st)
	{
//	    /* System generated locals */
//	    int i__1;
//
//	    /* Local variables */
//	    int i;
//	    boolean m1;
//
//	/* NOTE THAT WE ARE EAST OR WEST OF MIRROR, AND */
//	/* MIRROR MUST BE N-S. */
//
//	    m1 = vars.findex_1.mdir + (rm - vars.rindex_1.mrae) % 2 * 180 == 180;
//	    i = (rm - vars.rindex_1.mrae) % 2 + 819;
//	/* GET BASIC E/W STRING. */
//	    if (m1 && ! vars.findex_1.mr1f || ! m1 && ! vars.findex_1.mr2f) {
//		i += 2;
//	    }
//	    game.dsub.rspeak_(i);
//	    if (m1 && vars.findex_1.mropnf) {
//		i__1 = (i - 819) / 2 + 823;
//		game.dsub.rspeak_(i__1);
//	    }
//	    game.dsub.rspeak_(825);
//	    game.dsub.rspeak_(st);
		throw new RuntimeException("NRooms.ewtell not impl.");
	} /* ewtell_ */
	

}
