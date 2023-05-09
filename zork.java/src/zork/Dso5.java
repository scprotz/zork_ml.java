package zork;

public class Dso5
{
	Vars vars = null;
	Dgame game = null;
	
	public Dso5(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}
	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */

//	#include "funcs.h"
//	#include "vars.h"

	/* GTTIME-- GET TOTAL TIME PLAYED */

//	void gttime_(int *t)
//	{
//	   int h, m, s;
//
//	   itime_(&h, &m, &s);
//	   *t = h * 60 + m - (time_1.shour * 60 + time_1.smin);
//	   if (*t < 0) {
//	      *t += 1440;
//	   }
//	   *t += time_1.pltime;
//	} /* gttime_ */

	/* OPNCLS-- PROCESS OPEN/CLOSE FOR DOORS */

	/* DECLARATIONS */

//	boolean opncls_(int obj, int so, int sc)
//	{
//	   /* System generated locals */
//	   boolean ret_val;
//
//	   ret_val = true;
//	   /* 						!ASSUME WINS. */
//	   if (prsvec_1.prsa == vindex_1.closew) {
//	      goto L100;
//	   }
//	   /* 						!CLOSE? */
//	   if (prsvec_1.prsa == vindex_1.openw) {
//	      goto L50;
//	   }
//	   /* 						!OPEN? */
//	   ret_val = false;
//	   /* 						!LOSE */
//	   return ret_val;
//
//	L50:
//	   if ((objcts_1.oflag2[obj - 1] & OPENBT) != 0) {
//	      goto L200;
//	   }
//	   /* 						!OPEN... IS IT? */
//	   rspeak_(so);
//	   objcts_1.oflag2[obj - 1] |= OPENBT;
//	   return ret_val;
//
//	L100:
//	   if (! ((objcts_1.oflag2[obj - 1] & OPENBT) != 0)) {
//	      goto L200;
//	   }
//	   /* 						!CLOSE... IS IT? */
//	   rspeak_(sc);
//	   objcts_1.oflag2[obj - 1] &= ~ OPENBT;
//	   return ret_val;
//
//	L200:
//	   rspeak_(rnd_(3) + 125);
//	   /* 						!DUMMY. */
//	   return ret_val;
//	} /* opncls_ */

	/* LIT-- IS ROOM LIT? */

	/* DECLARATIONS */

	boolean lit_(int rm)
	{
	   /* System generated locals */
	   boolean ret_val;

	   /* Local variables */
	   int i, j, oa;

	   ret_val = true;
	   /* 						!ASSUME WINS */
	   if ((vars.rooms_1.rflag[rm - 1] & Vars.RLIGHT) != 0) {
	      return ret_val;
	   }

	   for (i = 1; i <= vars.objcts_1.olnt; ++i) 
	   {
	      /* 						!LOOK FOR LIT OBJ */
	      if (!game.dsub.qhere_(i, rm)) 
	      {
	//	         goto L100;
		      
		      /* 						!IN ROOM? */
		      oa = vars.objcts_1.oadv[i - 1];
		      /* 						!NO */
		      if (oa <= 0) 
		      {
	//	         goto L1000;
		    	  continue;
		      }
		      /* 						!ON ADV? */
		      if (vars.advs_1.aroom[oa - 1] != rm) 
		      {
	//	         goto L1000;
		    	  continue;
		      }
	      }
	      /* 						!ADV IN ROOM? */

	      /* OBJ IN ROOM OR ON ADV IN ROOM */

//	L100:
	      if ((vars.objcts_1.oflag1[i - 1] & Vars.ONBT) != 0) 
	      {
	         return ret_val;
	      }
	      if ((vars.objcts_1.oflag1[i - 1] & Vars.VISIBT) == 0 || (
	    		  vars.objcts_1.oflag1[i - 1] & Vars.TRANBT) == 0 && (
	    				  vars.objcts_1.oflag2[i - 1] & Vars.OPENBT) == 0) 
	      {
//	         goto L1000;
	    	  continue;
	      }

	      /* OBJ IS VISIBLE AND OPEN OR TRANSPARENT */

	      for (j = 1; j <= vars.objcts_1.olnt; ++j) 
	      {
	         if (vars.objcts_1.ocan[j - 1] == i && (vars.objcts_1.oflag1[j - 1] & 
	        		 Vars.ONBT) != 0) 
	         {
	            return ret_val;
	         }
	         /* L500: */
	      }
//	L1000:
	      ;
	   }
	   ret_val = false;
	   return ret_val;
	} /* lit_ */

	/* WEIGHT- RETURNS SUM OF WEIGHT OF QUALIFYING OBJECTS */

	/* DECLARATIONS */

	int weight_(int rm, int cn, int ad)
	{
	   /* System generated locals */
	   int ret_val, i__1;

	   /* Local variables */
	   int i, j;

	   ret_val = 0;
	   loop: for (i = 1; i <= vars.objcts_1.olnt; ++i) {
	      /* 						!OMIT BIG FIXED ITEMS. */
	      if (vars.objcts_1.osize[i - 1] >= 10000) {
	         continue;
	      }
	      /* 						!IF FIXED, FORGET IT. */
	      if (game.dsub.qhere_(i, rm) && rm != 0 || vars.objcts_1.oadv[i - 1] == ad && ad 
	            != 0) {
	    	  ret_val += vars.objcts_1.osize[i - 1];
	    	  continue loop;
	      }
	      j = i;
	      /* 						!SEE IF CONTAINED. */
	      do {
	         j = vars.objcts_1.ocan[j - 1];
	         /* 						!GET NEXT LEVEL UP. */
	         if (j == 0) {
//	        	 ret_val;
	        	 continue loop;
	         }
	         /* 						!END OF LIST? */
	      } while (j != cn);
//	L50:
//	      ret_val += vars.objcts_1.osize[i - 1];
//	L51:
//	      ret_val;
	   }
	   return ret_val;
	} /* weight_ */

}
