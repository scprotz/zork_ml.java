package zork;

import java.io.IOException;

public class Dso1
{
	Vars vars = null;
	Dgame game = null;
	
	public Dso1(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}
	
	/* PRINCR- PRINT CONTENTS OF ROOM */

	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */

//	#include "funcs.h"
//	#include "vars.h"

	void princr_(boolean full, int rm) throws IOException
	{
	   /* System generated locals */

	   /* Local variables */
	   int i, j, k;

	   j = 329;
	   /* 						!ASSUME SUPERBRIEF FORMAT. */
	   for (i = 1; i <= vars.objcts_1.olnt; ++i) {
	      /* 						!LOOP ON OBJECTS */
	      if (! game.dsub.qhere_(i, rm) || (vars.objcts_1.oflag1[i - 1] & Vars.VISIBT + 
	    		  Vars.NDSCBT) != Vars.VISIBT || i == vars.advs_1.avehic[
	            vars.play_1.winner - 1]) {
	         continue;
	      }
	      if (! (full) && (vars.findex_1.superf || vars.findex_1.brieff && (
	    		  vars.rooms_1.rflag[vars.play_1.here - 1] & Vars.RSEEN) != 0)) {
	    	  game.dsub.rspsub_(j, vars.objcts_1.odesc2[i - 1]);
	      /* DO SHORT DESCRIPTION OF OBJECT. */
	         /* 						!YOU CAN SEE IT. */
	         j = 502;
	         continue;
	      }

	      /* DO LONG DESCRIPTION OF OBJECT. */

	      k = vars.objcts_1.odesco[i - 1];
	      /* 						!GET UNTOUCHED. */
	      if (k == 0 || (vars.objcts_1.oflag2[i - 1] & Vars.TCHBT) != 0) {
	         k = vars.objcts_1.odesc1[i - 1];
	      }
	      game.dsub.rspeak_(k);
	      /* 						!DESCRIBE. */
	   }

	   /* NOW LOOP TO PRINT CONTENTS OF OBJECTS IN ROOM. */

	   for (i = 1; i <= vars.objcts_1.olnt; ++i) {
	      /* 						!LOOP ON OBJECTS. */
	      if (! game.dsub.qhere_(i, rm) || (vars.objcts_1.oflag1[i - 1] & Vars.VISIBT + 
	    		  Vars.NDSCBT) != Vars.VISIBT) {
	         continue;
	      }
	      if ((vars.objcts_1.oflag2[i - 1] & Vars.ACTRBT) != 0) {
	         invent_(game.dsub.oactor_(i));
	      }
	      if ((vars.objcts_1.oflag1[i - 1] & Vars.TRANBT) == 0 && (
	    		  vars.objcts_1.oflag2[i - 1] & Vars.OPENBT) == 0 || game.dsub.qempty_(i))
	      {
	         continue;
	      }

	      /* OBJECT IS NOT EMPTY AND IS OPEN OR TRANSPARENT. */

	      j = 573;
	      if (i != vars.oindex_1.tcase) {
	         princo_(i, j);
	         continue;
	      }
	      /* 						!TROPHY CASE? */
	      j = 574;
	      if ((vars.findex_1.brieff || vars.findex_1.superf) && ! (full)) {
	         continue;
	      }
	   }
	} /* princr_ */

	/* INVENT- PRINT CONTENTS OF ADVENTURER */

	/* DECLARATIONS */

	void invent_(int adv)
	{
//	   /* System generated locals */
//	   int i__1;
//
//	   /* Local variables */
//	   int i, j;
//
//	   i = 575;
//	   /* 						!FIRST LINE. */
//	   if (adv != aindex_1.player) {
//	      i = 576;
//	   }
//	   /* 						!IF NOT ME. */
//	   i__1 = objcts_1.olnt;
//	   for (j = 1; j <= i__1; ++j) {
//	      /* 						!LOOP */
//	      if (objcts_1.oadv[j - 1] != adv || (objcts_1.oflag1[j - 1] & 
//	               VISIBT) == 0) {
//	         continue;
//	      }
//	      rspsub_(i, objcts_1.odesc2[advs_1.aobj[adv - 1] - 1]);
//	      i = 0;
//	      rspsub_(502, objcts_1.odesc2[j - 1]);
//	   }
//
//	   if (i == 0) {
//	      for (j = 1; j <= objcts_1.olnt; ++j) {
//	         /* 						!LOOP. */
//	         if (objcts_1.oadv[j - 1] != adv || (objcts_1.oflag1[j - 1] & 
//	                  VISIBT) == 0 || (objcts_1.oflag1[j - 1] & 
//	                     TRANBT) == 0 && (objcts_1.oflag2[j - 1] & 
//	                        OPENBT) == 0) {
//	            continue;
//	         }
//	         if (! qempty_(j)) {
//	            princo_(j, 573);
//	         }
//	         /* 						!IF NOT EMPTY, LIST. */
//	      }
//	   } else {
//	       /* 						!ANY OBJECTS? */
//	       if (adv == aindex_1.player) {
//		  rspeak_(578);
//	       }
//	       /* 						!NO, TELL HIM. */
//	   }
//	   return;
		throw new RuntimeException("Dso1.invent_ not impl.");
	} /* invent_ */

	/* PRINCO-	PRINT CONTENTS OF OBJECT */

	/* DECLARATIONS */

	void princo_(int obj, int desc)
	{
//	   /* Local variables */
//	   int i;
//
//	   rspsub_(desc, objcts_1.odesc2[obj - 1]);
//	   /* 						!PRINT HEADER. */
//	   for (i = 1; i <= objcts_1.olnt; ++i) {
//	      /* 						!LOOP THRU. */
//	      if (objcts_1.ocan[i - 1] == obj) {
//	         rspsub_(502, objcts_1.odesc2[i - 1]);
//	      }
//	      /* L100: */
//	   }
		throw new RuntimeException("Dso1.princo_ not impl.");
	} /* princo_ */

}
