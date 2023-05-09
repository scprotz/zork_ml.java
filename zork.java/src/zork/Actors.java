package zork;

import java.io.IOException;

public class Actors
{
	/* AAPPLI- APPLICABLES FOR ADVENTURERS */

	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	
	private Vars vars = null;
	Dgame game = null;
	public Actors(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}
//
//	#include "funcs.h"
//	#include "vars.h"

	boolean aappli_(int ri)
	{
//	   /* System generated locals */
//	   boolean ret_val;
//
//	   /* Local variables */
//	   boolean f;
//	   int i;
//
//	   if (ri == 0) {
//	   /* COMMON FALSE RETURN. */
//	      return false;
//	   }
//	   /* 						!IF ZERO, NO APP. */
//	   ret_val = true;
//	   /* 						!ASSUME WINS. */
//	   switch (ri) {
//	      case 1:  {
//			GOTO = 1000;
//			continue;
//		}
//	      case 2:  {
//			GOTO = 2000;
//			continue;
//		}
//	   }
//	   /* 						!BRANCH ON ADV. */
//	   bug_(11, ri);
//
//
//	   /* A1--	ROBOT.  PROCESS MOST COMMANDS GIVEN TO ROBOT. */
//
//	case 1000:
//	   if (prsvec_1.prsa != vindex_1.raisew || prsvec_1.prso != vars.oindex_1.rcage) {
//
//	      {
//			GOTO = 1200;
//			continue;
//		}
//	   }
//	   cevent_1.cflag[cindex_1.cevsph - 1] = false;
//	   /* 						!ROBOT RAISED CAGE. */
//	   vars.play_1.winner = aindex_1.player;
//	   /* 						!RESET FOR PLAYER. */
//	   f = moveto_(vars.rindex_1.cager, vars.play_1.winner);
//	   /* 						!MOVE TO NEW ROOM. */
//	   game.dsub.newsta_(vars.oindex_1.cage, 567, vars.rindex_1.cager, 0, 0);
//	   /* 						!INSTALL CAGE IN ROOM. */
//	   game.dsub.newsta_(vars.oindex_1.robot, 0, vars.rindex_1.cager, 0, 0);
//	   /* 						!INSTALL ROBOT IN ROOM. */
//	   advs_1.aroom[aindex_1.arobot - 1] = vars.rindex_1.cager;
//	   /* 						!ALSO MOVE ROBOT/ADV. */
//	   findex_1.cagesf = true;
//	   /* 						!CAGE SOLVED. */
//	   vars.objcts_1.oflag1[vars.oindex_1.robot - 1] &= ~ NDSCBT;
//	   vars.objcts_1.oflag1[vars.oindex_1.spher - 1] |= Vars.TAKEBT;
//	   return ret_val;
//
//	case 1200:
//	   if (prsvec_1.prsa != vindex_1.drinkw && prsvec_1.prsa != vindex_1.eatw) {
//	      if (prsvec_1.prsa != vindex_1.readw) {
//	         {
//			GOTO = 1400;
//			continue;
//		}
//	      }
//	      /* 						!READ, */
//	      rspeak_(569);
//	      /* 						!JOKE. */
//	      return ret_val;
//	   }
//	   rspeak_(568);
//	   /* 						!EAT OR DRINK, JOKE. */
//	   return ret_val;
//
//	case 1400:
//	   if (prsvec_1.prsa == vindex_1.walkw || prsvec_1.prsa == vindex_1.takew || 
//	         prsvec_1.prsa == vindex_1.dropw || prsvec_1.prsa == vindex_1.putw 
//	         || prsvec_1.prsa == vindex_1.pushw || prsvec_1.prsa == 
//	         vindex_1.throww || prsvec_1.prsa == vindex_1.turnw || 
//	         prsvec_1.prsa == vindex_1.leapw) {
//	      return false;
//	   }
//	   rspeak_(570);
//	   /* 						!JOKE. */
//	   return ret_val;
//	   /* AAPPLI, PAGE 3 */
//
//	   /* A2--	MASTER.  PROCESS MOST COMMANDS GIVEN TO MASTER. */
//
//	case 2000:
//	   if ((vars.objcts_1.oflag2[vars.oindex_1.qdoor - 1] & OPENBT) != 0) {
//	      {
//			GOTO = 2100;
//			continue;
//		}
//	   }
//	   rspeak_(783);
//	   /* 						!NO MASTER YET. */
//	   return ret_val;
//
//	case 2100:
//	   if (prsvec_1.prsa != vindex_1.walkw) {
//	      {
//			GOTO = 2200;
//			continue;
//		}
//	   }
//	   /* 						!WALK? */
//	   i = 784;
//	   /* 						!ASSUME WONT. */
//	   if (vars.play_1.here == vars.rindex_1.scorr && (prsvec_1.prso == xsrch_1.xnorth || 
//	            prsvec_1.prso == xsrch_1.xenter) || vars.play_1.here == vars.rindex_1.ncorr 
//	         && (prsvec_1.prso == xsrch_1.xsouth || prsvec_1.prso == 
//	            xsrch_1.xenter)) {
//	      i = 785;
//	   }
//	   rspeak_(i);
//	   return ret_val;
//
//	case 2200:
//	   if (prsvec_1.prsa == vindex_1.takew || prsvec_1.prsa == vindex_1.dropw || 
//	         prsvec_1.prsa == vindex_1.putw || prsvec_1.prsa == 
//	         vindex_1.throww || prsvec_1.prsa == vindex_1.pushw || 
//	         prsvec_1.prsa == vindex_1.turnw || prsvec_1.prsa == 
//	         vindex_1.spinw || prsvec_1.prsa == vindex_1.trntow || 
//	         prsvec_1.prsa == vindex_1.follow || prsvec_1.prsa == 
//	         vindex_1.stayw || prsvec_1.prsa == vindex_1.openw || 
//	         prsvec_1.prsa == vindex_1.closew || prsvec_1.prsa == 
//	         vindex_1.killw) {
//	      return false;
//	   }
//	   rspeak_(786);
//	   /* 						!MASTER CANT DO IT. */
//	   return ret_val;
		throw new RuntimeException("Actors.appli_ not implemneted");
	} /* aappli_ */

//	/* THIEFD-	INTERMOVE THIEF DEMON */
//
//	/* DECLARATIONS */

	void thiefd_() throws IOException
	{		
	   /* System generated locals */
	   int i__1, i__2;

	   /* Local variables */
	   int i, j, nr;
	   boolean once;
	   int rhere   = 0;

	   int GOTO = 1025;
	   
	   /* 						!SET UP DETAIL FLAG. */
	   once = false;
	   
start:   do
	   	{
		   switch(GOTO)
		   {
			   
			   /* 						!INIT FLAG. */
			   case 1025:
				   rhere = vars.objcts_1.oroom[vars.oindex_1.thief - 1];
				   /* 						!VISIBLE POS. */
				   if (rhere != 0) 
				   {
					   vars.hack_1.thfpos = rhere;
				   }

				   if (vars.hack_1.thfpos == vars.play_1.here) 
				   {
					   {
						   GOTO = 1100;
						   continue;
					   }
				   }
				   /* 						!THIEF IN WIN RM? */
				   if (vars.hack_1.thfpos != vars.rindex_1.treas) 
				   {
					   {
						   GOTO = 1400;
						   continue;
					   }
				   }
				   /* 						!THIEF NOT IN TREAS? */

				   /* THIEF IS IN TREASURE ROOM, AND WINNER IS NOT. */

				   if (rhere == 0) 
				   {
					   {
						   GOTO = 1050;
						   continue;
					   }
				   }
				   /* 						!VISIBLE? */
				   game.dsub.newsta_(vars.oindex_1.thief, 0, 0, 0, 0);
				   /* 						!YES, VANISH. */
				   rhere = 0;
				   if (game.dsub.qhere_(vars.oindex_1.still, vars.rindex_1.treas) || vars.objcts_1.oadv[
				         vars.oindex_1.still - 1] == -vars.oindex_1.thief) 
				   {
				      game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
				   }
			   case 1050:
				   i__1 = -vars.oindex_1.thief;
				   i = game.dso4.robadv_(i__1, vars.hack_1.thfpos, 0, 0);
				   /* 						!DROP VALUABLES. */
				   if (game.dsub.qhere_(vars.oindex_1.egg, vars.hack_1.thfpos)) 
				   {
					   vars.objcts_1.oflag2[vars.oindex_1.egg - 1] |= Vars.OPENBT;
				   }
				   {
					   GOTO = 1700;
					   continue;
				   }

				   /* THIEF AND WINNER IN SAME ROOM. */

			   case 1100:
				   if (vars.hack_1.thfpos == vars.rindex_1.treas) 
				   {
					   {
						   GOTO = 1700;
						   continue;
					   }
				   }
				   /* 						!IF TREAS ROOM, NOTHING. */
				   if ((vars.rooms_1.rflag[vars.hack_1.thfpos - 1] & Vars.RLIGHT) != 0) 
				   {
					   {
						   GOTO = 1400;
						   continue;
					   }
				   }
				   if (vars.hack_1.thfflg) 
				   {
					   {
						   GOTO = 1300;
						   continue;
					   }
				   }
				   /* 						!THIEF ANNOUNCED? */
				   if (rhere != 0 || game.dsub.prob_(70, 70)) 
				   {
					   {
						   GOTO = 1150;
						   continue;
					   }
				   }
				   /* 						!IF INVIS AND 30%. */
				   if (vars.objcts_1.ocan[vars.oindex_1.still - 1] != vars.oindex_1.thief) 
				   {
					   {
						   GOTO = 1700;
						   continue;
					   }
				   }
				   /* 						!ABORT IF NO STILLETTO. */
				   game.dsub.newsta_(vars.oindex_1.thief, 583, vars.hack_1.thfpos, 0, 0);
				   /* 						!INSERT THIEF INTO ROOM. */
				   vars.hack_1.thfflg = true;
				   /* 						!THIEF IS ANNOUNCED. */
				   return;

			   case 1150:
				   if (rhere == 0 || (vars.objcts_1.oflag2[vars.oindex_1.thief - 1] & Vars.FITEBT) == 0) 
				   {
					   {
						   GOTO = 1200;
						   continue;
					   }
				   }
				   if (game.dso4.winnin_(vars.oindex_1.thief, vars.play_1.winner)) 
				   {
					   {
						   GOTO = 1175;
						   continue;
					   }
				   }
				   /* 						!WINNING? */
				   game.dsub.newsta_(vars.oindex_1.thief, 584, 0, 0, 0);
				   /* 						!NO, VANISH THIEF. */
				   vars.objcts_1.oflag2[vars.oindex_1.thief - 1] &= ~ Vars.FITEBT;
				   if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos) || vars.objcts_1.oadv[
				       vars.oindex_1.still - 1] == -vars.oindex_1.thief) 
				   {
					   game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
				   }
				   return;
			   case 1175:
				   if (game.dsub.prob_(90, 90)) 
				   {
					   {
						   GOTO = 1700;
						   continue;
					   }
				   }
				   /* 						!90% CHANCE TO STAY. */

			   case 1200:
				   if (rhere == 0 || game.dsub.prob_(70, 70)) 
				   {
					   {
						   GOTO = 1250;
						   continue;
					   }
				   }
				   /* 						!IF VISIBLE AND 30% */
				   game.dsub.newsta_(vars.oindex_1.thief, 585, 0, 0, 0);
				   /* 						!VANISH THIEF. */
				   if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos) || vars.objcts_1.oadv[
				       vars.oindex_1.still - 1] == -vars.oindex_1.thief) 
				   {
					   game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
				   }
				   return;

			   case 1300:
				   if (rhere == 0) 
				   {
					   {
						   GOTO = 1700;
						   continue;
					   }
				   }
				   /* 						!ANNOUNCED.  VISIBLE? */
			   case 1250:
				   if (game.dsub.prob_(70, 70)) 
				   {
					   return;
				   }
				   /* 						!70% CHANCE TO DO NOTHING. */
				   vars.hack_1.thfflg = true;
				   i__1 = -vars.oindex_1.thief;
				   i__2 = -vars.oindex_1.thief;
				   nr = game.dso4.robrm_(vars.hack_1.thfpos, 100, 0, 0, i__1) + game.dso4.robadv_(vars.play_1.winner, 0, 0, i__2);
				   i = 586;
				   /* 						!ROBBED EM. */
				   if (rhere != 0) 
				   {
					   i = 588;
				   }
				   /* 						!WAS HE VISIBLE? */
				   if (nr != 0) 
				   {
					   ++i;
				   }
				   /* 						!DID HE GET ANYTHING? */
				   game.dsub.newsta_(vars.oindex_1.thief, i, 0, 0, 0);
				   /* 						!VANISH THIEF. */
				   if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos) || vars.objcts_1.oadv[vars.oindex_1.still - 1] == -vars.oindex_1.thief) 
				   {
					   game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
				   }
				   if (nr != 0 && ! game.dso5.lit_(vars.hack_1.thfpos)) 
				   {
					   game.dsub.rspeak_(406);
				   }
				   rhere = 0;
				   {
					   GOTO = 1700;
					   continue;
				   }
				   /* 						!ONWARD. */

				   /* NOT IN ADVENTURERS ROOM. */

			   case 1400:
				   game.dsub.newsta_(vars.oindex_1.thief, 0, 0, 0, 0);
				   /* 						!VANISH. */
				   rhere = 0;
				   if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos) || vars.objcts_1.oadv[vars.oindex_1.still - 1] == -vars.oindex_1.thief) 
				   {
					   game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
				   }
				   if ((vars.rooms_1.rflag[vars.hack_1.thfpos - 1] & Vars.RSEEN) == 0) 
				   {
					   {
						   GOTO = 1700;
						   continue;
					   }	
				   }
				   i__1 = -vars.oindex_1.thief;
				   i = game.dso4.robrm_(vars.hack_1.thfpos, 75, 0, 0, i__1);
				   /* 						!ROB ROOM 75%. */
				   if (vars.hack_1.thfpos < vars.rindex_1.maze1 || vars.hack_1.thfpos > vars.rindex_1.maz15 || 
	         vars.play_1.here < vars.rindex_1.maze1 || vars.play_1.here > vars.rindex_1.maz15) 
				   {
					   {
						   GOTO = 1500;
						   continue;
					   }
				   }
				   i__1 = vars.objcts_1.olnt;
				   for (i = 1; i <= i__1; ++i) 
				   {
					   /* 						!BOTH IN MAZE. */
					   if (! game.dsub.qhere_(i, vars.hack_1.thfpos) || game.dsub.prob_(60, 60) || (
							   vars.objcts_1.oflag1[i - 1] & Vars.VISIBT + Vars.TAKEBT) !=
							   Vars.VISIBT + Vars.TAKEBT) 
					   {
						   {
							   continue;
						   }
					   }
					   game.dsub.rspsub_(590, vars.objcts_1.odesc2[i - 1]);
					   /* 						!TAKE OBJECT. */
					   if (game.dsub.prob_(40, 20)) {
						   {
							   GOTO = 1700;
							   continue start;
						   }
					   }
					   i__2 = -vars.oindex_1.thief;
					   game.dsub.newsta_(i, 0, 0, 0, i__2);
					   /* 						!MOST OF THE TIME. */
					   vars.objcts_1.oflag2[i - 1] |= Vars.TCHBT;
					   {
						   GOTO = 1700;
						   continue start;
					   }					   
				   }
				   {
					   GOTO = 1700;
					   continue;
				   }

			   case 1500:
				   i__1 = vars.objcts_1.olnt;
				   for (i = 1; i <= i__1; ++i) 
				   {
					   /* 						!NOT IN MAZE. */
					   if (! game.dsub.qhere_(i, vars.hack_1.thfpos) || vars.objcts_1.otval[i - 1] != 0 || 
							   game.dsub.prob_(80, 60) || (vars.objcts_1.oflag1[i - 1] & 
									   Vars.VISIBT + Vars.TAKEBT) != Vars.VISIBT + 
									   Vars.TAKEBT) {
						   {							   
							   continue;
						   }
					   }
					   i__2 = -vars.oindex_1.thief;
					   game.dsub.newsta_(i, 0, 0, 0, i__2);
					   vars.objcts_1.oflag2[i - 1] |= Vars.TCHBT;
					   {
						   GOTO = 1700;
						   continue start;
					   }
				   }

				   /* NOW MOVE TO NEW ROOM. */

			   case 1700:
				   if (vars.objcts_1.oadv[vars.oindex_1.rope - 1] == -vars.oindex_1.thief) 
				   {
					   vars.findex_1.domef = false;
				   }
				   if (once) 
				   {
					   {
						   GOTO = 1800;
						   continue;
					   }
				   }
				   once = ! once;
			   case 1750:
				   --vars.hack_1.thfpos;
				   /* 						!NEXT ROOM. */
				   if (vars.hack_1.thfpos <= 0) 
				   {
					   vars.hack_1.thfpos = vars.rooms_1.rlnt;
				   }
				   if ((vars.rooms_1.rflag[vars.hack_1.thfpos - 1] & Vars.RLAND + Vars.RSACRD + 
						   Vars.REND) != Vars.RLAND) 
				   {
					   {
						   GOTO = 1750;
						   continue;
					   }
				   }
				   vars.hack_1.thfflg = false;
				   /* 						!NOT ANNOUNCED. */
				   {
					   GOTO = 1025;
					   continue;
				   }
				   /* 						!ONCE MORE. */

				   /* ALL DONE. */

			   case 1800:
				   if (vars.hack_1.thfpos == vars.rindex_1.treas) 
				   {
					   return;
				   }
				   /* 						!IN TREASURE ROOM? */
				   j = 591;
				   /* 						!NO, DROP STUFF. */
				   if (vars.hack_1.thfpos != vars.play_1.here) 
				   {
					   j = 0;
				   }
				   i__1 = vars.objcts_1.olnt;
				   for (i = 1; i <= i__1; ++i) 
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
	   }while(true); 
		
	} /* thiefd_ */

}
