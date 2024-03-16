package zork.rooms;

import zork.Dgame;
import zork.Supp;
import zork.Vars;
import zork.Vars.rindex_;
import zork.Vars.rooms_;
import zork.Vars.xsrch_;



/* RAPPL1- SPECIAL PURPOSE ROOM ROUTINES, PART 1 */

/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
/* WRITTEN BY R. M. SUPNIK */


public class Room
{
	
//	public static final int RSEEN = 32768;
//	public static final int RLIGHT = 16384;
//	public static final int RLAND = 8192;
//	public static final int RWATER = 4096;
//	public static final int RAIR = 2048;
//	public static final int RSACRD = 1024;
//	public static final int RFILL = 512;
//	public static final int RMUNG = 256;
//	public static final int RBUCK = 128;
//	public static final int RHOUSE = 64;
//	public static final int RNWALL = 32;
//	public static final int REND = 16;
//
//	
////	Vars vars = null;
////	Dgame game = null;
//
//	
//	public class rooms_
//	{
//		int rlnt, rdesc1[] = new int[200], rdesc2[] = new int[200], rexit[] = new int[200],
//				ractio[] = new int[200], rval[] = new int[200], rflag[] = new int[200];
//
//		public int rrand(int index)
//		{			
//			int i = index + 601;
//			
////			int i = index - 601;
//			int array_number = i / 200;
//			switch (array_number)
//			{
//				case 0:
//					return rdesc1[i];
//				case 1:
//					return rdesc2[i - 200];
//				case 2:
//					return rexit[i - 400];
//				case 3:
//					return ractio[i - 600];				 
//				case 4:
//					return rval[i - 800];
//				case 5:
//					return rflag[i - 1000];
//				default:
//					throw new RuntimeException("Could not find rrand index correctly.");
//			}
//		}
//		
//		public void rrand(int index, int value)
//		{
//			
//			int i = index + 600;			 
//			int array_number = i / 200;
//			switch (array_number)
//			{
//				case 0:
//					rdesc1[i] = value; break;
//				case 1:
//					rdesc2[i - 200] = value; break;
//				case 2:
//					rexit[i - 400] = value; break;
//				case 3:
//					ractio[i - 600] = value; break;
//				case 4:
//					rval[i - 800] = value; break;
//				case 5:
//					rflag[i - 1000] = value; break;
//				default:
//					throw new RuntimeException("Could not find rrand index correctly. " + index + "="+ value + " : " + array_number);
//			}
//		}
//	};
//
//
//	public rooms_ rooms_1 = new rooms_();
////	#define eqr ((int *)&rooms_1 + 1)
////	#define rrand ((int *)&rooms_1 + 601)
//
//	/* Room flags */
//
//
//	public class rindex_
//	{
//		final int whous = 2;
//		final int lroom = 8;
//		final int cella = 9;
//		final int mtrol = 10;
//		final int maze1 = 11;
//		final int mgrat = 25;
//		final int maz15 = 30;
//		final int fore1 = 31;
//		final int fore3 = 33;
//
//		final int clear = 36;
//		final int reser = 40;
//		final int strea = 42;
//		final int egypt = 44;
//		final int echor = 49;
//		final int tshaf = 61;
//		final int bshaf = 76;
//		final int mmach = 77;
//		final int dome = 79;
//
//		final int mtorc = 80;
//		final int carou = 83;
//		final int riddl = 91;
//		final int lld2 = 94;
//		final int temp1 = 96;
//		final int temp2 = 97;
//		final int maint = 100;
//		final int blroo = 102;
//		final int treas = 103;
//
//		final int rivr1 = 107;
//		final int rivr2 = 108;
//		final int rivr3 = 109;
//		final int mcycl = 101;
//		final int rivr4 = 112;
//		final int rivr5 = 113;
//		final int fchmp = 114;
//		final int falls = 120;
//		final int mbarr = 119;
//
//		final int mrain = 121;
//		final int pog = 122;
//		final int vlbot = 126;
//		final int vair1 = 127;
//		final int vair2 = 128;
//		final int vair3 = 129;
//		final int vair4 = 130;
//		final int ledg2 = 131;
//		final int ledg3 = 132;
//
//		final int ledg4 = 133;
//		final int msafe = 135;
//		final int cager = 140;
//		final int caged = 141;
//		final int twell = 142;
//		final int bwell = 143;
//		final int alice = 144;
//		final int alism = 145;
//		final int alitr = 146;
//
//		final int mtree = 147;
//		final int bkent = 148;
//		final int bkvw = 151;
//		final int bktwi = 153;
//		final int bkvau = 154;
//		final int bkbox = 155;
//		final int crypt = 157;
//		final int tstrs = 158;
//		final int mrant = 159;
//
//		final int mreye = 160;
//		final int mra = 161;
//		final int mrb = 162;
//		final int mrc = 163;
//		final int mrg = 164;
//		final int mrd = 165;
//		final int fdoor = 166;
//		final int mrae = 167;
//		final int mrce = 171;
//		final int mrcw = 172;
//		final int mrge = 173;
//
//		final int mrgw = 174;
//		final int mrdw = 176;
//		final int inmir = 177;
//		final int scorr = 179;
//		final int ncorr = 182;
//		final int parap = 183;
//		final int cell = 184;
//		final int pcell = 185;
//		final int ncell = 186;
//		final int cpant = 188;
//
//		final int cpout = 189;
//		final int cpuzz = 190;
//	};
//
//	Dgame game;
//	Vars vars;
//	
//	public Room(Vars vars, Dgame game)
//	{
//		this.vars = vars;
//		this.game = game;
//	}
//	
//	public rindex_ rindex_1 = new rindex_();
//
//	   public class xsrch_ {
//	      final int xmin = 1024; 
//	final int    		  xmax = 16384; 
//	final int    		  xdown = 10240; 
//	final int    		  xup = 9216; 
//	final int    		  xnorth = 1024; 
//	final int    		  xsouth = 5120; 
//	final int    		  xenter = 13312; 
//	final int    		  xexit = 14336; 
//	final int    		  xeast = 3072; 
//	            final int  xwest =  7168;
//	   };
////	#ifdef INIT
////	            = { 1024, 16384, 10240, 9216, 1024, 5120, 13312, 14336, 3072, 
////	                7168 }
////	#endif
////	   ;
//
//	public xsrch_ xsrch_1 = new xsrch_();
//
//	
//	
//	boolean rappl1_(int ri)
//	{
//		/* System generated locals */
//		int i__1, i__2;
//		boolean ret_val;
//		int GOTO = 1000;
//
//		/* Local variables */
//		int i = 0;
//		int j = 0;
//
//		ret_val = true;
//		/* !USUALLY IGNORED. */
//		if (ri == 0)
//		{
//			return ret_val;
//		}
//		/* !RETURN IF NAUGHT. */
//
//		/* !SET TO FALSE FOR */
//
//		/* !NEW DESC NEEDED. */
//		switch (ri)
//		{
//			case 1:
//				GOTO = 1000;
//				break;
//			case 2:
//				GOTO = 2000;
//				break;
//			case 3:
//				GOTO = 3000;
//				break;
//			case 4:
//				GOTO = 4000;
//				break;
//			case 5:
//				GOTO = 5000;
//				break;
//			case 6:
//				GOTO = 6000;
//				break;
//			case 7:
//				GOTO = 7000;
//				break;
//			case 8:
//				GOTO = 8000;
//				break;
//			case 9:
//				GOTO = 9000;
//				break;
//			case 10:
//				GOTO = 10000;
//				break;
//			case 11:
//				GOTO = 11000;
//				break;
//			case 12:
//				GOTO = 12000;
//				break;
//			case 13:
//				GOTO = 13000;
//				break;
//			case 14:
//				GOTO = 14000;
//				break;
//			case 15:
//				GOTO = 15000;
//				break;
//			case 16:
//				GOTO = 16000;
//				break;
//			case 17:
//				GOTO = 17000;
//				break;
//			case 18:
//				GOTO = 18000;
//				break;
//			case 19:
//				GOTO = 19000;
//				break;
//			case 20:
//				GOTO = 20000;
//				break;
//			case 21:
//				GOTO = 21000;
//				break;
//			case 22:
//				GOTO = 22000;
//				break;
//			case 23:
//				GOTO = 23000;
//				break;
//			case 24:
//				GOTO = 24000;
//				break;
//			case 25:
//				GOTO = 25000;
//				break;
//			case 26:
//				GOTO = 26000;
//				break;
//			case 27:
//				GOTO = 27000;
//				break;
//			case 28:
//				GOTO = 28000;
//				break;
//			case 29:
//				GOTO = 29000;
//				break;
//			case 30:
//				GOTO = 30000;
//				break;
//			case 31:
//				GOTO = 31000;
//				break;
//			case 32:
//				GOTO = 32000;
//				break;
//			case 33:
//				GOTO = 33000;
//				break;
//			case 34:
//				GOTO = 34000;
//				break;
//			case 35:
//				GOTO = 35000;
//				break;
//			case 36:
//				GOTO = 36000;
//				break;
//			case 37:
//				GOTO = 37000;
//				break;
//			default:
//				game.dsub.bug_(1, ri);
//		}
//
//		loop: do
//		{
//			switch (GOTO)
//			{
//
//				/* R1-- EAST OF HOUSE. DESCRIPTION DEPENDS ON STATE OF WINDOW */
//
//				case 1000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					i = 13;
//					/* !ASSUME CLOSED. */
//					if ((vars.objcts_1.oflag2[vars.oindex_1.windo - 1] & Vars.OPENBT) != 0)
//					{
//						i = 12;
//					}
//					/* !IF OPEN, AJAR. */
//					game.dsub.rspsub_(11, i);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* R2-- KITCHEN. SAME VIEW FROM INSIDE. */
//				case 2000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					i = 13;
//					/* !ASSUME CLOSED. */
//					if ((vars.objcts_1.oflag2[vars.oindex_1.windo - 1] & Vars.OPENBT) != 0)
//					{
//						i = 12;
//					}
//					/* !IF OPEN, AJAR. */
//					game.dsub.rspsub_(14, i);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* R3-- LIVING ROOM. DESCRIPTION DEPENDS ON MAGICF (STATE OF */
//				/* DOOR TO CYCLOPS ROOM), RUG (MOVED OR NOT), DOOR (OPEN OR CLOSED) */
//				case 3000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						GOTO = 3500;
//						continue loop;
//					}
//					/* !LOOK? */
//					i = 15;
//					/* !ASSUME NO HOLE. */
//					if (vars.findex_1.magicf)
//					{
//						i = 16;
//					}
//					/* !IF MAGICF, CYCLOPS HOLE. */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					i = vars.findex_1.orrug + 17;
//					/* !ASSUME INITIAL STATE. */
//					if ((vars.objcts_1.oflag2[vars.oindex_1.door - 1] & Vars.OPENBT) != 0)
//					{
//						i += 2;
//					}
//					/* !DOOR OPEN? */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* NOT A LOOK WORD. REEVALUATE TROPHY CASE. */
//
//				case 3500:
//				    if (vars.prsvec_1.prsa != vars.vindex_1.takew && (vars.prsvec_1.prsa != vars.vindex_1.putw || 
//					    vars.prsvec_1.prsi != vars.oindex_1.tcase)) 
//				    {
//				    	return ret_val;
//				    }
//				    vars.advs_1.ascore[vars.play_1.winner - 1] = vars.state_1.rwscor;
//					
//				    /* SCORE TROPHY CASE. */
//					i__1 = vars.objcts_1.olnt;
//					inner_for: for (i = 1; i <= i__1; ++i) 
//					{
//						/* RETAIN RAW SCORE AS WELL. */
//						j = i;
//						/* FIND OUT IF IN CASE. */
////					L3550:
//						do
//						{
//						j = vars.objcts_1.ocan[j - 1];
//					/* TRACE OWNERSHIP. */
//							if (j == 0) {
//							    continue inner_for;
//							}
//						}
//						while(j != vars.oindex_1.tcase);
////						    goto L3550;
////						}
//					/* DO ALL LEVELS. */
//						vars.advs_1.ascore[vars.play_1.winner - 1] += vars.objcts_1.otval[i - 1];
//
//					    }
//					game.dso2.scrupd_(0);
//				/* SEE IF ENDGAME TRIG. */
//				return ret_val;
//				/* RAPPL1, PAGE 3 */
//				/* R4-- CELLAR. SHUT DOOR AND BAR IT IF HE JUST WALKED IN. */
//
//				case 4000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						GOTO = 4500;
//						continue loop;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(21);
//					/* !DESCRIBE CELLAR. */
//					return ret_val;
//
//				case 4500:
//					if (vars.prsvec_1.prsa != vars.vindex_1.walkiw)
//					{
//						return ret_val;
//					}
//					/* !WALKIN? */
//					if ((vars.objcts_1.oflag2[vars.oindex_1.door - 1]
//							& Vars.OPENBT + Vars.TCHBT) != Vars.OPENBT)
//					{
//						return ret_val;
//					}
//					vars.objcts_1.oflag2[vars.oindex_1.door
//							- 1] = (vars.objcts_1.oflag2[vars.oindex_1.door - 1] | Vars.TCHBT)
//									& ~Vars.OPENBT;
//					game.dsub.rspeak_(22);
//					/* !SLAM AND BOLT DOOR. */
//					return ret_val;
//
//				/* R5-- MAZE11. DESCRIBE STATE OF GRATING. */
//
//				case 5000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(23);
//					/* !DESCRIBE. */
//					i = 24;
//					/* !ASSUME LOCKED. */
//					if (vars.findex_1.grunlf)
//					{
//						i = 26;
//					}
//					/* !UNLOCKED? */
//					if ((vars.objcts_1.oflag2[vars.oindex_1.grate - 1] & Vars.OPENBT) != 0)
//					{
//						i = 25;
//					}
//					/* !OPEN? */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE GRATE. */
//					return ret_val;
//
//				/* R6-- CLEARING. DESCRIBE CLEARING, MOVE LEAVES. */
//
//				case 6000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						GOTO = 6500;
//						continue loop;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(27);
//					/* !DESCRIBE. */
//					if (vars.findex_1.rvclr == 0)
//					{
//						return ret_val;
//					}
//					/* !LEAVES MOVED? */
//					i = 28;
//					/* !YES, ASSUME GRATE CLOSED. */
//					if ((vars.objcts_1.oflag2[vars.oindex_1.grate - 1] & Vars.OPENBT) != 0)
//					{
//						i = 29;
//					}
//					/* !OPEN? */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE GRATE. */
//					return ret_val;
//
//				case 6500:
//					if (vars.findex_1.rvclr != 0
//							|| game.dsub.qhere_(vars.oindex_1.leave, vars.rindex_1.clear)
//									&& (vars.prsvec_1.prsa != vars.vindex_1.movew
//											|| vars.prsvec_1.prso != vars.oindex_1.leave))
//					{
//						return ret_val;
//					}
//					game.dsub.rspeak_(30);
//					/* !MOVE LEAVES, REVEAL GRATE. */
//					vars.findex_1.rvclr = 1;
//					/* !INDICATE LEAVES MOVED. */
//					return ret_val;
//				/* RAPPL1, PAGE 4 */
//
//				/* R7-- RESERVOIR SOUTH. DESCRIPTION DEPENDS ON LOW TIDE FLAG. */
//
//				case 7000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					i = 31;
//					/* !ASSUME FULL. */
//					if (vars.findex_1.lwtidf)
//					{
//						i = 32;
//					}
//					/* !IF LOW TIDE, EMPTY. */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					game.dsub.rspeak_(33);
//					/* !DESCRIBE EXITS. */
//					return ret_val;
//
//				/* R8-- RESERVOIR. STATE DEPENDS ON LOW TIDE FLAG. */
//
//				case 8000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					i = 34;
//					/* !ASSUME FULL. */
//					if (vars.findex_1.lwtidf)
//					{
//						i = 35;
//					}
//					/* !IF LOW TIDE, EMTPY. */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* R9-- RESERVOIR NORTH. ALSO DEPENDS ON LOW TIDE FLAG. */
//
//				case 9000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					i = 36;
//					/* !YOU GET THE IDEA. */
//					if (vars.findex_1.lwtidf)
//					{
//						i = 37;
//					}
//					game.dsub.rspeak_(i);
//					game.dsub.rspeak_(38);
//					return ret_val;
//
//				/* R10-- GLACIER ROOM. STATE DEPENDS ON MELTED, VANISHED FLAGS. */
//
//				case 10000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(39);
//					/* !BASIC DESCRIPTION. */
//					i = 0;
//					/* !ASSUME NO CHANGES. */
//					if (vars.findex_1.glacmf)
//					{
//						i = 40;
//					}
//					/* !PARTIAL MELT? */
//					if (vars.findex_1.glacrf)
//					{
//						i = 41;
//					}
//					/* !COMPLETE MELT? */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* R11-- FOREST ROOM */
//
//				case 11000:
//					if (vars.prsvec_1.prsa == vars.vindex_1.walkiw)
//					{
//						vars.cevent_1.cflag[vars.cindex_1.cevfor - 1] = true;
//					}
//					/* !IF WALK IN, BIRDIE. */
//					return ret_val;
//
//				/* R12-- MIRROR ROOM. STATE DEPENDS ON MIRROR INTACT. */
//
//				case 12000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(42);
//					/* !DESCRIBE. */
//					if (vars.findex_1.mirrmf)
//					{
//						game.dsub.rspeak_(43);
//					}
//					/* !IF BROKEN, NASTY REMARK. */
//					return ret_val;
//				/* RAPPL1, PAGE 5 */
//
//				/* R13-- CAVE2 ROOM. BLOW OUT CANDLES WITH 50% PROBABILITY. */
//
//				case 13000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.walkiw)
//					{
//						return ret_val;
//					}
//					/* !WALKIN? */
//					if (game.dsub.prob_(50, 50)
//							|| vars.objcts_1.oadv[vars.oindex_1.candl - 1] != vars.play_1.winner
//							|| !((vars.objcts_1.oflag1[vars.oindex_1.candl - 1] & Vars.ONBT) != 0))
//					{
//						return ret_val;
//					}
//					vars.objcts_1.oflag1[vars.oindex_1.candl - 1] &= ~Vars.ONBT;
//					game.dsub.rspeak_(47);
//					/* !TELL OF WINDS. */
//					vars.cevent_1.cflag[vars.cindex_1.cevcnd - 1] = false;
//					/* !HALT CANDLE COUNTDOWN. */
//					return ret_val;
//
//				/* R14-- BOOM ROOM. BLOW HIM UP IF CARRYING FLAMING OBJECT. */
//
//				case 14000:
//					j = vars.objcts_1.odesc2[vars.oindex_1.candl - 1];
//					/* !ASSUME CANDLE. */
//					if (vars.objcts_1.oadv[vars.oindex_1.candl - 1] == vars.play_1.winner
//							&& (vars.objcts_1.oflag1[vars.oindex_1.candl - 1] & Vars.ONBT) != 0)
//					{
//						GOTO = 14100;
//						continue loop;
//					}
//					j = vars.objcts_1.odesc2[vars.oindex_1.torch - 1];
//					/* !ASSUME TORCH. */
//					if (vars.objcts_1.oadv[vars.oindex_1.torch - 1] == vars.play_1.winner
//							&& (vars.objcts_1.oflag1[vars.oindex_1.torch - 1] & Vars.ONBT) != 0)
//					{
//						GOTO = 14100;
//						continue loop;
//					}
//					j = vars.objcts_1.odesc2[vars.oindex_1.match - 1];
//					if (vars.objcts_1.oadv[vars.oindex_1.match - 1] == vars.play_1.winner
//							&& (vars.objcts_1.oflag1[vars.oindex_1.match - 1] & Vars.ONBT) != 0)
//					{
//						GOTO = 14100;
//						continue loop;
//					}
//					return ret_val;
//				/* !SAFE */
//
//				case 14100:
//					if (vars.prsvec_1.prsa != vars.vindex_1.trnonw)
//					{
//						GOTO = 14200;
//						continue loop;
//					}
//					/* !TURN ON? */
//					game.dsub.rspsub_(294, j);
//					/* !BOOM */
//					/* ! */
//					game.dsub.jigsup_(44);
//					return ret_val;
//
//				case 14200:
//					if (vars.prsvec_1.prsa != vars.vindex_1.walkiw)
//					{
//						return ret_val;
//					}
//					/* !WALKIN? */
//					game.dsub.rspsub_(295, j);
//					/* !BOOM */
//					/* ! */
//					game.dsub.jigsup_(44);
//					return ret_val;
//
//				/* R15-- NO-OBJS. SEE IF EMPTY HANDED, SCORE LIGHT SHAFT. */
//
//				case 15000:
//					vars.findex_1.empthf = true;
//					/* !ASSUME TRUE. */
//					i__1 = vars.objcts_1.olnt;
//					for (i = 1; i <= i__1; ++i)
//					{
//						/* !SEE IF CARRYING. */
//						if (vars.objcts_1.oadv[i - 1] == vars.play_1.winner)
//						{
//							vars.findex_1.empthf = false;
//						}
//						/* case 15100: */
//					}
//
//					if (vars.play_1.here != vars.rindex_1.bshaf
//							|| !game.dso5.lit_(vars.play_1.here))
//					{
//						return ret_val;
//					}
//					game.dso2.scrupd_(vars.state_1.ltshft);
//					/* !SCORE LIGHT SHAFT. */
//					vars.state_1.ltshft = 0;
//					/* !NEVER AGAIN. */
//					return ret_val;
//				/* RAPPL1, PAGE 6 */
//
//				/* R16-- MACHINE ROOM. DESCRIBE MACHINE. */
//
//				case 16000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					i = 46;
//					/* !ASSUME LID CLOSED. */
//					if ((vars.objcts_1.oflag2[vars.oindex_1.machi - 1] & Vars.OPENBT) != 0)
//					{
//						i = 12;
//					}
//					/* !IF OPEN, OPEN. */
//					game.dsub.rspsub_(45, i);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* R17-- BAT ROOM. UNLESS CARRYING GARLIC, FLY AWAY WITH ME... */
//
//				case 17000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						GOTO = 17500;
//						continue loop;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(48);
//					/* !DESCRIBE ROOM. */
//					if (vars.objcts_1.oadv[vars.oindex_1.garli - 1] == vars.play_1.winner)
//					{
//						game.dsub.rspeak_(49);
//					}
//					/* !BAT HOLDS NOSE. */
//					return ret_val;
//
//				case 17500:
//					if (vars.prsvec_1.prsa != vars.vindex_1.walkiw
//							|| vars.objcts_1.oadv[vars.oindex_1.garli - 1] == vars.play_1.winner)
//					{
//						return ret_val;
//					}
//					game.dsub.rspeak_(50);
//					/* !TIME TO FLY, JACK. */
//					game.dso2.moveto_(vars.bats_1.batdrp[Supp.rnd_(9)], vars.play_1.winner);
//					/* !SELECT RANDOM DEST. */
//					ret_val = false;
//					/* !INDICATE NEW DESC NEEDED. */
//					return ret_val;
//
//				/* R18-- DOME ROOM. STATE DEPENDS ON WHETHER ROPE TIED TO RAILING. */
//
//				case 18000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						GOTO = 18500;
//						continue loop;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(51);
//					/* !DESCRIBE. */
//					if (vars.findex_1.domef)
//					{
//						game.dsub.rspeak_(52);
//					}
//					/* !IF ROPE, DESCRIBE. */
//					return ret_val;
//
//				case 18500:
//					if (vars.prsvec_1.prsa == vars.vindex_1.leapw)
//					{
//						game.dsub.jigsup_(53);
//					}
//					/* !DID HE JUMP??? */
//					return ret_val;
//
//				/* R19-- TORCH ROOM. ALSO DEPENDS ON WHETHER ROPE TIED TO RAILING. */
//
//				case 19000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(54);
//					/* !DESCRIBE. */
//					if (vars.findex_1.domef)
//					{
//						game.dsub.rspeak_(55);
//					}
//					/* !IF ROPE, DESCRIBE. */
//					return ret_val;
//
//				/* R20-- CAROUSEL ROOM. SPIN HIM OR KILL HIM. */
//
//				case 20000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						GOTO = 20500;
//						continue loop;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(56);
//					/* !DESCRIBE. */
//					if (!vars.findex_1.caroff)
//					{
//						game.dsub.rspeak_(57);
//					}
//					/* !IF NOT FLIPPED, SPIN. */
//					return ret_val;
//
//				case 20500:
//					if (vars.prsvec_1.prsa == vars.vindex_1.walkiw && vars.findex_1.carozf)
//					{
//						game.dsub.jigsup_(58);
//					}
//					/* !WALKED IN. */
//					return ret_val;
//				/* RAPPL1, PAGE 7 */
//
//				/* R21-- LLD ROOM. HANDLE EXORCISE, DESCRIPTIONS. */
//
//				case 21000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						GOTO = 21500;
//						continue loop;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(59);
//					/* !DESCRIBE. */
//					if (!vars.findex_1.lldf)
//					{
//						game.dsub.rspeak_(60);
//					}
//					/* !IF NOT VANISHED, GHOSTS. */
//					return ret_val;
//
//				case 21500:
//					if (vars.prsvec_1.prsa != vars.vindex_1.exorcw)
//					{
//						return ret_val;
//					}
//					/* !EXORCISE? */
//					if (vars.objcts_1.oadv[vars.oindex_1.bell - 1] == vars.play_1.winner
//							&& vars.objcts_1.oadv[vars.oindex_1.book - 1] == vars.play_1.winner
//							&& vars.objcts_1.oadv[vars.oindex_1.candl - 1] == vars.play_1.winner
//							&& (vars.objcts_1.oflag1[vars.oindex_1.candl - 1] & Vars.ONBT) != 0)
//					{
//						GOTO = 21600;
//						continue loop;
//					}
//					game.dsub.rspeak_(62);
//					/* !NOT EQUIPPED. */
//					return ret_val;
//
//				case 21600:
//					if (game.dsub.qhere_(vars.oindex_1.ghost, vars.play_1.here))
//					{
//						GOTO = 21700;
//						continue loop;
//					}
//					/* !GHOST HERE? */
//					game.dsub.jigsup_(61);
//					/* !NOPE, EXORCISE YOU. */
//					return ret_val;
//
//				case 21700:
//					game.dsub.newsta_(vars.oindex_1.ghost, 63, 0, 0, 0);
//					/* !VANISH GHOST. */
//					vars.findex_1.lldf = true;
//					/* !OPEN GATE. */
//					return ret_val;
//
//				/* R22-- LLD2-ROOM. IS HIS HEAD ON A POLE? */
//
//				case 22000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(64);
//					/* !DESCRIBE. */
//					if (vars.findex_1.onpolf)
//					{
//						game.dsub.rspeak_(65);
//					}
//					/* !ON POLE? */
//					return ret_val;
//
//				/* R23-- DAM ROOM. DESCRIBE RESERVOIR, PANEL. */
//
//				case 23000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(66);
//					/* !DESCRIBE. */
//					i = 67;
//					if (vars.findex_1.lwtidf)
//					{
//						i = 68;
//					}
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE RESERVOIR. */
//					game.dsub.rspeak_(69);
//					/* !DESCRIBE PANEL. */
//					if (vars.findex_1.gatef)
//					{
//						game.dsub.rspeak_(70);
//					}
//					/* !BUBBLE IS GLOWING. */
//					return ret_val;
//
//				/* R24-- TREE ROOM */
//
//				case 24000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(660);
//					/* !DESCRIBE. */
//					i = 661;
//					/* !SET FLAG FOR BELOW. */
//					i__1 = vars.objcts_1.olnt;
//					for (j = 1; j <= i__1; ++j)
//					{
//						/* !DESCRIBE OBJ IN FORE3. */
//						if (!game.dsub.qhere_(j, vars.rindex_1.fore3) || j == vars.oindex_1.ftree)
//						{
////	    		GOTO = 24200; continue loop;
//							continue;
//						}
//						game.dsub.rspeak_(i);
//						/* !SET STAGE, */
//						i = 0;
//						game.dsub.rspsub_(502, vars.objcts_1.odesc2[j - 1]);
//						/* !DESCRIBE. */
////	case 24200:
////		;
//					}
//					return ret_val;
//				/* RAPPL1, PAGE 8 */
//
//				/*
//				 * R25-- CYCLOPS-ROOM. DEPENDS ON CYCLOPS STATE, ASLEEP FLAG, MAGIC FLAG.
//				 */
//
//				case 25000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(606);
//					/* !DESCRIBE. */
//					i = 607;
//					/* !ASSUME BASIC STATE. */
//					if (vars.findex_1.rvcyc > 0)
//					{
//						i = 608;
//					}
//					/* !>0? HUNGRY. */
//					if (vars.findex_1.rvcyc < 0)
//					{
//						i = 609;
//					}
//					/* !<0? THIRSTY. */
//					if (vars.findex_1.cyclof)
//					{
//						i = 610;
//					}
//					/* !ASLEEP? */
//					if (vars.findex_1.magicf)
//					{
//						i = 611;
//					}
//					/* !GONE? */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					if (!vars.findex_1.cyclof && vars.findex_1.rvcyc != 0)
//					{
//						i__1 = Math.abs(vars.findex_1.rvcyc) + 193;
//						game.dsub.rspeak_(i__1);
//					}
//					return ret_val;
//
//				/* R26-- BANK BOX ROOM. */
//
//				case 26000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.walkiw)
//					{
//						return ret_val;
//					}
//					/* !SURPRISE HIM. */
//					for (i = 1; i <= 8; i += 2)
//					{
//						/* !SCOLRM DEPENDS ON */
//						if (vars.screen_1.fromdr == vars.screen_1.scoldr[i - 1])
//						{
//							vars.screen_1.scolrm = vars.screen_1.scoldr[i];
//						}
//						/* case 26100: */
//					}
//					/* !ENTRY DIRECTION. */
//					return ret_val;
//
//				/* R27-- TREASURE ROOM. */
//
//				case 27000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.walkiw || !vars.hack_1.thfact)
//					{
//						return ret_val;
//					}
//					if (vars.objcts_1.oroom[vars.oindex_1.thief - 1] != vars.play_1.here)
//					{
//						game.dsub.newsta_(vars.oindex_1.thief, 82, vars.play_1.here, 0, 0);
//					}
//					vars.hack_1.thfpos = vars.play_1.here;
//					/* !RESET SEARCH PATTERN. */
//					vars.objcts_1.oflag2[vars.oindex_1.thief - 1] |= Vars.FITEBT;
//					if (vars.objcts_1.oroom[vars.oindex_1.chali - 1] == vars.play_1.here)
//					{
//						vars.objcts_1.oflag1[vars.oindex_1.chali - 1] &= ~Vars.TAKEBT;
//					}
//
//					/* VANISH EVERYTHING IN ROOM */
//
//					j = 0;
//					/* !ASSUME NOTHING TO VANISH. */
//					i__1 = vars.objcts_1.olnt;
//					for (i = 1; i <= i__1; ++i)
//					{
//						if (i == vars.oindex_1.chali || i == vars.oindex_1.thief
//								|| !game.dsub.qhere_(i, vars.play_1.here))
//						{
////		    GOTO = 27200; continue loop;
//							continue;
//						}
//						j = 83;
//						/* !FLAG BYEBYE. */
//						vars.objcts_1.oflag1[i - 1] &= ~Vars.VISIBT;
////	case 27200:
////		;
//					}
//					game.dsub.rspeak_(j);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* R28-- CLIFF FUNCTION. SEE IF CARRYING INFLATED BOAT. */
//
//				case 28000:
//					vars.findex_1.deflaf = vars.objcts_1.oadv[vars.oindex_1.rboat
//							- 1] != vars.play_1.winner;
//					/* !TRUE IF NOT CARRYING. */
//					return ret_val;
//				/* RAPPL1, PAGE 9 */
//
//				/* R29-- RIVR4 ROOM. PLAY WITH BUOY. */
//
//				case 29000:
//					if (!vars.findex_1.buoyf
//							|| vars.objcts_1.oadv[vars.oindex_1.buoy - 1] != vars.play_1.winner)
//					{
//						return ret_val;
//					}
//					game.dsub.rspeak_(84);
//					/* !GIVE HINT, */
//					vars.findex_1.buoyf = false;
//					/* !THEN DISABLE. */
//					return ret_val;
//
//				/* R30-- OVERFALLS. DOOM. */
//
//				case 30000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						game.dsub.jigsup_(85);
//					}
//					/* !OVER YOU GO. */
//					return ret_val;
//
//				/* R31-- BEACH ROOM. DIG A HOLE. */
//
//				case 31000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.digw
//							|| vars.prsvec_1.prso != vars.oindex_1.shove)
//					{
//						return ret_val;
//					}
//					++vars.findex_1.rvsnd;
//					/* !INCREMENT DIG STATE. */
//					switch (vars.findex_1.rvsnd)
//					{
//						case 1:
//							GOTO = 31100;
//							continue loop;
//						case 2:
//							GOTO = 31100;
//							continue loop;
//						case 3:
//							GOTO = 31100;
//							continue loop;
//						case 4:
//							GOTO = 31400;
//							continue loop;
//						case 5:
//							GOTO = 31500;
//							continue loop;
//					}
//					/* !PROCESS STATE. */
//					game.dsub.bug_(2, vars.findex_1.rvsnd);
//
//				case 31100:
//					i__1 = vars.findex_1.rvsnd + 85;
//					game.dsub.rspeak_(i__1);
//					/* !1-3... DISCOURAGE HIM. */
//					return ret_val;
//
//				case 31400:
//					i = 89;
//					/* !ASSUME DISCOVERY. */
//					if ((vars.objcts_1.oflag1[vars.oindex_1.statu - 1] & Vars.VISIBT) != 0)
//					{
//						i = 88;
//					}
//					game.dsub.rspeak_(i);
//					vars.objcts_1.oflag1[vars.oindex_1.statu - 1] |= Vars.VISIBT;
//					return ret_val;
//
//				case 31500:
//					vars.findex_1.rvsnd = 0;
//					/* !5... SAND COLLAPSES */
//					game.dsub.jigsup_(90);
//					/* !AND SO DOES HE. */
//					return ret_val;
//
//				/* R32-- TCAVE ROOM. DIG A HOLE IN GUANO. */
//
//				case 32000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.digw
//							|| vars.prsvec_1.prso != vars.oindex_1.shove)
//					{
//						return ret_val;
//					}
//					i = 91;
//					/* !ASSUME NO GUANO. */
//					if (!game.dsub.qhere_(vars.oindex_1.guano, vars.play_1.here))
//					{
//						GOTO = 32100;
//						continue loop;
//					}
//					/* !IS IT HERE? */
//					/* Computing MIN */
//					i__1 = 4;
//					i__2 = vars.findex_1.rvgua + 1;
//					vars.findex_1.rvgua = Math.min(i__1, i__2);
//					/* !YES, SET NEW STATE. */
//					i = vars.findex_1.rvgua + 91;
//					/* !GET NASTY REMARK. */
//				case 32100:
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* R33-- FALLS ROOM */
//
//				case 33000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(96);
//					/* !DESCRIBE. */
//					i = 97;
//					/* !ASSUME NO RAINBOW. */
//					if (vars.findex_1.rainbf)
//					{
//						i = 98;
//					}
//					/* !GOT ONE? */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					return ret_val;
//				/* RAPPL1, PAGE 10 */
//
//				/* R34-- LEDGE FUNCTION. LEDGE CAN COLLAPSE. */
//
//				case 34000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(100);
//					/* !DESCRIBE. */
//					i = 102;
//					/* !ASSUME SAFE ROOM OK. */
//					if ((vars.rooms_1.rflag[vars.rindex_1.msafe - 1] & Vars.RMUNG) != 0)
//					{
//						i = 101;
//					}
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* R35-- SAFE ROOM. STATE DEPENDS ON WHETHER SAFE BLOWN. */
//
//				case 35000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						return ret_val;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(104);
//					/* !DESCRIBE. */
//					i = 105;
//					/* !ASSUME OK. */
//					if (vars.findex_1.safef)
//					{
//						i = 106;
//					}
//					/* !BLOWN? */
//					game.dsub.rspeak_(i);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				/* R36-- MAGNET ROOM. DESCRIBE, CHECK FOR SPINDIZZY DOOM. */
//
//				case 36000:
//					if (vars.prsvec_1.prsa != vars.vindex_1.lookw)
//					{
//						GOTO = 36500;
//						continue loop;
//					}
//					/* !LOOK? */
//					game.dsub.rspeak_(107);
//					/* !DESCRIBE. */
//					return ret_val;
//
//				case 36500:
//					if (vars.prsvec_1.prsa != vars.vindex_1.walkiw || !vars.findex_1.caroff)
//					{
//						return ret_val;
//					}
//					/* !WALKIN ON FLIPPED? */
//					if (vars.findex_1.carozf)
//					{
//						GOTO = 36600;
//						continue loop;
//					}
//					/* !ZOOM? */
//					game.dsub.rspeak_(108);
//					/* !NO, SPIN HIS COMPASS. */
//					return ret_val;
//
//				case 36600:
//					i = 58;
//					/* !SPIN HIS INSIDES. */
//					if (vars.play_1.winner != vars.aindex_1.player)
//					{
//						i = 99;
//					}
//					/* !SPIN ROBOT. */
//					game.dsub.jigsup_(i);
//					/* !DEAD. */
//					return ret_val;
//
//				/* R37-- CAGE ROOM. IF SOLVED CAGE, MOVE TO OTHER CAGE ROOM. */
//
//				case 37000:
//					if (vars.findex_1.cagesf)
//					{
//						game.dso2.moveto_(vars.rindex_1.cager, vars.play_1.winner);
//					}
//					/* !IF SOLVED, MOVE. */
//					return ret_val;
//			}
//		} while (true);
//	} /* rappl1_ */

}
