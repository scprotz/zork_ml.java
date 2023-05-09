package zork;

public class Demons
{
	/* FIGHTD- INTERMOVE FIGHT DEMON */

	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	
	Vars vars = null;
	Dgame game = null;
	
	public Demons(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}
	

//	#include "funcs.h"
//	#include "vars.h"
//
//	static boolean infest_ P((int));
//
	void fightd_()
	{
	   /* Initialized data */

	   final int rout = 1;

	   /* Local variables */
	   boolean f;
	   int i, j, ra;
	   int obj;
	   int res;
	   int out;

	   for (i = 1; i <= vars.vill_1.vlnt; ++i) {
	      /* 						!LOOP THRU VILLAINS. */
	      vars.vill_1.vopps[i - 1] = 0;
	      /* 						!CLEAR OPPONENT SLOT. */
	      obj = vars.vill_1.villns[i - 1];
	      /* 						!GET OBJECT NO. */
	      ra = vars.objcts_1.oactio[obj - 1];
	      /* 						!GET HIS ACTION. */
	      if (vars.play_1.here != vars.objcts_1.oroom[obj - 1]) {
	         if (!((vars.objcts_1.oflag2[obj - 1] & Vars.FITEBT) == 0 || ra == 0)) {
	            vars.prsvec_1.prsa = vars.vindex_1.fightw;
	            /* 						!HAVE A FIGHT. */
	            f = game.objcts.oappli_(ra, 0);
	         }
	         if (obj == vars.oindex_1.thief) {
	            vars.findex_1.thfenf = false;
	         }
	         /* 						!TURN OFF ENGROSSED. */
	         vars.advs_1.aflag[vars.aindex_1.player - 1] &= ~ vars.aflags_1.astag;
	         vars.objcts_1.oflag2[obj - 1] &= ~ (Vars.STAGBT + Vars.FITEBT);
	         if (vars.objcts_1.ocapac[obj - 1] >= 0 || ra == 0) {
	            continue;
	         }
	         vars.prsvec_1.prsa = vars.vindex_1.inxw;
	         /* 						!WAKE HIM UP. */
	         f = game.objcts.oappli_(ra, 0);
	         vars.objcts_1.ocapac[obj - 1] = Math.abs(vars.objcts_1.ocapac[obj - 1]);
	         continue;
	      }
	      /* 						!ADVENTURER STILL HERE? */
	      if (obj == vars.oindex_1.thief && vars.findex_1.thfenf) {
	         continue;
	      }
	      /* 						!THIEF ENGROSSED? */
	      if (vars.objcts_1.ocapac[obj - 1] >= 0) {
	         if ((vars.objcts_1.oflag2[obj - 1] & Vars.FITEBT) == 0) {
	            if (ra == 0) {
	               continue;
	            }
	            /* 						!NOT FIGHTING, */
	            vars.prsvec_1.prsa = vars.vindex_1.frstqw;
	            /* 						!SET UP PROBABILITY */
	            if (! game.objcts.oappli_(ra, 0)) {
	               continue;
	            }
	            /* 						!OF FIGHTING. */
	            vars.objcts_1.oflag2[obj - 1] |= Vars.FITEBT;
	            vars.vill_1.vopps[i - 1] = obj;
	            /* 						!SET UP OPP. */
	            continue;
	         }
	         vars.vill_1.vopps[i - 1] = obj;
	         /* 						!FIGHTING, SET UP OPP. */
	         continue;
	      }
	      /* 						!YES, VILL AWAKE? */
	      if (vars.vill_1.vprob[i - 1] == 0 || ! game.dsub.prob_(vars.vill_1.vprob[i - 1], 
	               vars.vill_1.vprob[i - 1])) {
	         vars.vill_1.vprob[i - 1] += 10;
	         /* 						!INCREASE WAKEUP PROB. */
	         continue;
	      /* 						!NOTHING ELSE. */
	      }
	      vars.objcts_1.ocapac[obj - 1] = Math.abs(vars.objcts_1.ocapac[obj - 1]);
	      vars.vill_1.vprob[i - 1] = 0;
	      if (ra == 0) {
	         continue;
	      }
	      /* 						!ANYTHING TO DO? */
	      vars.prsvec_1.prsa = vars.vindex_1.inxw;
	      /* 						!YES, WAKE HIM UP. */
	      f = game.objcts.oappli_(ra, 0);
	      continue;
	      /* 						!NOTHING ELSE HAPPENS. */
	   }
	   /* FIGHTD, PAGE 3 */

	   /* NOW DO ACTUAL COUNTERBLOWS. */

	   out = 0;
	   /* 						!ASSUME HERO OK. */
	   do {
	      for (i = 1; i <= vars.vill_1.vlnt; ++i) {
	         /* 						!LOOP THRU OPPS. */
	         j = vars.vill_1.vopps[i - 1];
	         if (j == 0) {
	            continue;
	         }
	         /* 						!SLOT EMPTY? */
	         vars.prsvec_1.prscon = 1;
	         /* 						!STOP CMD STREAM. */
	         ra = vars.objcts_1.oactio[j - 1];
	         if (ra != 0) {
	            /* 						!VILLAIN ACTION? */
	            vars.prsvec_1.prsa = vars.vindex_1.fightw;
	            /* 						!SEE IF */
	            if (game.objcts.oappli_(ra, 0)) {
	               continue;
	            }
	         }
	         /* 						!SPECIAL ACTION. */
	         res = blow_(vars.aindex_1.player, j, vars.vill_1.vmelee[i - 1], 0, out);

	         /* 						!STRIKE BLOW. */
	         if (res < 0) {
	            return;
	         }
	         /* 						!IF HERO DEAD, EXIT. */
	         if (res == rout) {
	            out = Supp.rnd_(3) + 2;
	         }
	         /* 						!IF HERO OUT, SET FLG. */
	      }
	      --out;
	      /* 						!DECREMENT OUT COUNT. */
	   } while (out > 0);
	      /* 						!IF STILL OUT, GO AGAIN. */
	      return;
	} /* fightd_ */

	/* BLOW- STRIKE BLOW */

	/* DECLARATIONS */

	int blow_(int h, int v, int rmk, int hflg, int out)
	{
//	   /* Initialized data */
//
//	   final int rmiss = 0;
//	   final int rout = 1;
//	   final int rkill = 2;
//	   final int rstag = 5;
//	   final int rlose = 6;
//	   final int rhes = 7;
//	   final int rsit = 8;
//	   static final int def1r[3] = { 1,2,3 };
//	   static final int def2r[4] = { 13,23,24,25 };
//	   static final int def3r[5] = { 35,36,46,47,57 };
//	   static final int rvectr[66] = { 0,0,0,0,5,5,1,1,2,2,2,2,0,0,0,0,0,5,
//	      5,3,3,1,0,0,0,5,5,3,3,3,1,2,2,2,0,0,0,0,0,5,5,3,3,4,4,0,0,0,5,5,
//	      3,3,3,4,4,4,0,5,5,3,3,3,3,4,4,4 };
//	   static final int rstate[45] = { 5000,3005,3008,4011,3015,3018,1021,
//	      0,0,5022,3027,3030,4033,3037,3040,1043,0,0,4044,2048,4050,4054,
//	      5058,4063,4067,3071,1074,4075,1079,4080,4084,4088,4092,4096,4100,
//	      1104,4105,2109,4111,4115,4119,4123,4127,3131,3134 };
//
//	   /* System generated locals */
//	   int ret_val, i__1, i__2;
//
//	   /* Local variables */
//	   boolean f;
//	   int i, j, oa, ra, od, mi, dv, def;
//	   int tbl;
//	   int att, res;
//	   int dweap;
//	   int pblose;
//
//	   ra = vars.objcts_1.oactio[v - 1];
//	   /* 						!GET VILLAIN ACTION, */
//	   dv = vars.objcts_1.odesc2[v - 1];
//	   /* 						!DESCRIPTION. */
//	   ret_val = rmiss;
//	   /* 						!ASSUME NO RESULT. */
//	   if (! (hflg)) {
//	      goto L1000;
//	   }
//	   /* 						!HERO STRIKING BLOW? */
//
//	   /* HERO IS ATTACKER, VILLAIN IS DEFENDER. */
//
//	   pblose = 10;
//	   /* 						!BAD LK PROB. */
//	   vars.objcts_1.oflag2[v - 1] |= Vars.FITEBT;
//	   if ((advs_1.aflag[h - 1] & vars.aflags_1.astag) == 0) {
//	      goto L100;
//	   }
//	   rspeak_(591);
//	   /* 						!YES, CANT FIGHT. */
//	   advs_1.aflag[h - 1] &= ~ vars.aflags_1.astag;
//	   return ret_val;
//
//	L100:
//	   att = fights_(h, 1);
//	   /* 						!GET HIS STRENGTH. */
//	   oa = att;
//	   def = vilstr_(v);
//	   /* 						!GET VILL STRENGTH. */
//	   od = def;
//	   dweap = 0;
//	   /* 						!ASSUME NO WEAPON. */
//	   i__1 = vars.objcts_1.olnt;
//	   for (i = 1; i <= i__1; ++i) {
//	      /* 						!SEARCH VILLAIN. */
//	      if (vars.objcts_1.ocan[i - 1] == v && (vars.objcts_1.oflag2[i - 1] & 
//	               WEAPBT) != 0) {
//	         dweap = i;
//	      }
//	      /* L200: */
//	   }
//	   if (v == advs_1.aobj[vars.aindex_1.player - 1]) {
//	      goto L300;
//	   }
//	   /* 						!KILLING SELF? */
//	   if (def != 0) {
//	      goto L2000;
//	   }
//	   /* 						!DEFENDER ALIVE? */
//	   rspsub_(592, dv);
//	   /* 						!VILLAIN DEAD. */
//	   return ret_val;
//
//	L300:
//	   jigsup_(593);
//	   /* 						!KILLING SELF. */
//	   return ret_val;
//
//	   /* VILLAIN IS ATTACKER, HERO IS DEFENDER. */
//
//	L1000:
//	   pblose = 50;
//	   /* 						!BAD LK PROB. */
//	   advs_1.aflag[h - 1] &= ~ vars.aflags_1.astag;
//	   if ((vars.objcts_1.oflag2[v - 1] & Vars.STAGBT) == 0) {
//	      goto L1200;
//	   }
//	   vars.objcts_1.oflag2[v - 1] &= ~ Vars.STAGBT;
//	   rspsub_(594, dv);
//	   /* 						!DESCRIBE. */
//	   return ret_val;
//
//	L1200:
//	   att = vilstr_(v);
//	   /* 						!SET UP ATT, DEF. */
//	   oa = att;
//	   def = fights_(h, 1);
//	   if (def <= 0) {
//	      return ret_val;
//	   }
//	   /* 						!DONT ALLOW DEAD DEF. */
//	   od = fights_(h, 0);
//	   dweap = (i__1 = fwim_(0, WEAPBT, 0, 0, h, 1), 
//	         Math.abs(i__1));
//	   /* 						!FIND A WEAPON. */
//	   /* BLOW, PAGE 4 */
//
//	   /* PARTIES ARE NOW EQUIPPED.  DEF CANNOT BE ZERO. */
//	   /* ATT MUST BE > 0. */
//
//	L2000:
//	   if (def > 0) {
//	      goto L2100;
//	   }
//	   /* 						!DEF ALIVE? */
//	   res = rkill;
//	   if (hflg) {
//	      rspsub_(595, dv);
//	   }
//	   /* 						!DEADER. */
//	   goto L3000;
//
//	L2100:
//	   if ((i__1 = def - 2) < 0) {
//	      goto L2200;
//	   } else if (i__1 == 0) {
//	      goto L2300;
//	   } else {
//	      goto L2400;
//	   }
//	   /* 						!DEF <2,=2,>2 */
//	L2200:
//	   att = min(att,3);
//	   /* 						!SCALE ATT. */
//	   tbl = def1r[att - 1];
//	   /* 						!CHOOSE TABLE. */
//	   goto L2500;
//
//	L2300:
//	   att = min(att,4);
//	   /* 						!SCALE ATT. */
//	   tbl = def2r[att - 1];
//	   /* 						!CHOOSE TABLE. */
//	   goto L2500;
//
//	L2400:
//	   att -= def;
//	   /* 						!SCALE ATT. */
//	   /* Computing MIN */
//	   i__1 = 2, i__2 = max(-2,att);
//	   att = min(i__1,i__2) + 3;
//	   tbl = def3r[att - 1];
//
//	L2500:
//	   res = rvectr[tbl + rnd_(10) - 1];
//	   /* 						!GET RESULT. */
//	   if (out == 0) {
//	      goto L2600;
//	   }
//	   /* 						!WAS HE OUT? */
//	   if (res == rstag) {
//	      goto L2550;
//	   }
//	   /* 						!YES, STAG--> HES. */
//	   res = rsit;
//	   /* 						!OTHERWISE, SITTING. */
//	   goto L2600;
//	L2550:
//	   res = rhes;
//	L2600:
//	   if (res == rstag && dweap != 0 && prob_(25, pblose)) {
//	      res = rlose;
//	   }
//
//	   mi = rstate[(rmk - 1) * 9 + res];
//	   /* 						!CHOOSE TABLE ENTRY. */
//	   if (mi == 0) {
//	      goto L3000;
//	   }
//	   i__1 = mi / 1000;
//	   i = mi % 1000 + rnd_(i__1) + star_1.mbase + 1;
//	   j = dv;
//	   if (! (hflg) && dweap != 0) {
//	      j = vars.objcts_1.odesc2[dweap - 1];
//	   }
//	   rspsub_(i, j);
//	   /* 						!PRESENT RESULT. */
//	   /* BLOW, PAGE 5 */
//
//	   /* NOW APPLY RESULT */
//
//	L3000:
//	   switch (res + 1) {
//	   case 1:  goto L4000;
//	   case 2:  goto L3100;
//	   case 3:  goto L3200;
//	   case 4:  goto L3300;
//	   case 5:  goto L3400;
//	   case 6:  goto L3500;
//	   case 7:  goto L3600;
//	   case 8:  goto L4000;
//	   case 9:  goto L3200;
//	   }
//
//	L3100:
//	   if (hflg) {
//	      def = -def;
//	   }
//	   /* 						!UNCONSCIOUS. */
//	   goto L4000;
//
//	L3200:
//	   def = 0;
//	   /* 						!KILLED OR SITTING DUCK. */
//	   goto L4000;
//
//	L3300:
//	   /* Computing MAX */
//	   i__1 = 0, i__2 = def - 1;
//	   def = max(i__1,i__2);
//	   /* 						!LIGHT WOUND. */
//	   goto L4000;
//
//	L3400:
//	   /* Computing MAX */
//	   i__1 = 0, i__2 = def - 2;
//	   def = max(i__1,i__2);
//	   /* 						!SERIOUS WOUND. */
//	   goto L4000;
//
//	L3500:
//	   if (hflg) {
//	      goto L3550;
//	   }
//	   /* 						!STAGGERED. */
//	   advs_1.aflag[h - 1] |= vars.aflags_1.astag;
//	   goto L4000;
//
//	L3550:
//	   vars.objcts_1.oflag2[v - 1] |= Vars.STAGBT;
//	   goto L4000;
//
//	L3600:
//	   newsta_(dweap, 0, vars.play_1.here, 0, 0);
//	   /* 						!LOSE WEAPON. */
//	   dweap = 0;
//	   if (hflg) {
//	      goto L4000;
//	   }
//	   /* 						!IF HERO, DONE. */
//	   dweap = (i__1 = fwim_(0, WEAPBT, 0, 0, h, 1), 
//	         Math.abs(i__1));
//	   /* 						!GET NEW. */
//	   if (dweap != 0) {
//	      rspsub_(605, vars.objcts_1.odesc2[dweap - 1]);
//	   }
//	   /* BLOW, PAGE 6 */
//
//	L4000:
//	   ret_val = res;
//	   /* 						!RETURN RESULT. */
//	   if (! (hflg)) {
//	      goto L4500;
//	   }
//	   /* 						!HERO? */
//	   vars.objcts_1.ocapac[v - 1] = def;
//	   /* 						!STORE NEW CAPACITY. */
//	   if (def != 0) {
//	      goto L4100;
//	   }
//	   /* 						!DEAD? */
//	   vars.objcts_1.oflag2[v - 1] &= ~ Vars.FITEBT;
//	   rspsub_(572, dv);
//	   /* 						!HE DIES. */
//	   newsta_(v, 0, 0, 0, 0);
//	   /* 						!MAKE HIM DISAPPEAR. */
//	   if (ra == 0) {
//	      return ret_val;
//	   }
//	   /* 						!IF NX TO DO, EXIT. */
//	   vars.prsvec_1.prsa = vars.vindex_1.deadxw;
//	   /* 						!LET HIM KNOW. */
//	   f = game.objcts.oappli_(ra, 0);
//	   return ret_val;
//
//	L4100:
//	   if (res != rout || ra == 0) {
//	      return ret_val;
//	   }
//	   vars.prsvec_1.prsa = vars.vindex_1.outxw;
//	   /* 						!LET HIM BE OUT. */
//	   f = game.objcts.oappli_(ra, 0);
//	   return ret_val;
//
//	L4500:
//	   advs_1.astren[h - 1] = -10000;
//	   /* 						!ASSUME DEAD. */
//	   if (def != 0) {
//	      advs_1.astren[h - 1] = def - od;
//	   }
//	   if (def >= od) {
//	      goto L4600;
//	   }
//	   cevent_1.ctick[cindex_1.cevcur - 1] = 30;
//	   cevent_1.cflag[cindex_1.cevcur - 1] = TRUE_;
//	L4600:
//	   if (fights_(h, 1) > 0) {
//	      return ret_val;
//	   }
//	   advs_1.astren[h - 1] = 1 - fights_(h, 0);
//	   /* 						!HE'S DEAD. */
//	   jigsup_(596);
//	   ret_val = -1;
//	   return ret_val;
		throw new RuntimeException("Demons.blow_ not impl.");
	} /* blow_ */

	/* SWORDD- SWORD INTERMOVE DEMON */

	/* DECLARATIONS */

	void swordd_()
	{
//	   /* System generated locals */
//	   int i__1, i__2;
//
//	   /* Local variables */
//	   int i, ng;
//
//	   if (vars.objcts_1.oadv[vars.oindex_1.sword - 1] != vars.aindex_1.player) {
//	      goto L500;
//	   }
//	   /* 						!HOLDING SWORD? */
//	   ng = 2;
//	   /* 						!ASSUME VILL CLOSE. */
//	   if (infest_(vars.play_1.here)) {
//	      goto L300;
//	   }
//	   /* 						!VILL HERE? */
//	   ng = 1;
//	   i__1 = xsrch_1.xmax;
//	   i__2 = xsrch_1.xmin;
//	   for (i = xsrch_1.xmin; i__2 < 0 ? i >= i__1 : i <= i__1; i += i__2) {
//	      /* 						!NO, SEARCH ROOMS. */
//	      if (! findxt_(i, vars.play_1.here)) {
//	         goto L200;
//	      }
//	      /* 						!ROOM THAT WAY? */
//	      switch (curxt_1.xtype) {
//	      case 1:  goto L50;
//	      case 2:  goto L200;
//	      case 3:  goto L50;
//	      case 4:  goto L50;
//	      }
//	      /* 						!SEE IF ROOM AT ALL. */
//	L50:
//	      if (infest_(curxt_1.xroom1)) {
//	         goto L300;
//	      }
//	      /* 						!CHECK ROOM. */
//	L200:
//	      ;
//	   }
//	   ng = 0;
//	   /* 						!NO GLOW. */
//
//	L300:
//	   if (ng == hack_1.swdsta) {
//	      return;
//	   }
//	   /* 						!ANY STATE CHANGE? */
//	   i__2 = ng + 495;
//	   rspeak_(i__2);
//	   /* 						!YES, TELL NEW STATE. */
//	   hack_1.swdsta = ng;
//	   return;
//
//	L500:
//	   hack_1.swdact = false;
//	   /* 						!DROPPED SWORD, */
//	   return;
//	   /* 						!DISABLE DEMON. */
		throw new RuntimeException("Demons.swordd_ not impl.");
	} /* swordd_ */

	/* INFEST-	SUBROUTINE TO TEST FOR INFESTED ROOM */

	/* DECLARATIONS */
//	static boolean infest_(r)
//	int r;
//	{
//	   /* System generated locals */
//	   boolean ret_val;
//
//	   if (! vars.findex_1.endgmf) {
//	      ret_val = vars.objcts_1.oroom[vars.oindex_1.cyclo - 1] == r || vars.objcts_1.oroom[
//	         vars.oindex_1.troll - 1] == r || vars.objcts_1.oroom[vars.oindex_1.thief - 
//	         1] == r && hack_1.thfact;
//	   }
//	   else {
//	      ret_val = r == rindex_1.mrg || r == rindex_1.mrge || r == 
//	         rindex_1.mrgw || r == rindex_1.inmir && vars.findex_1.mloc == 
//	         rindex_1.mrg;
//	   }
//	   return ret_val;
//	} /* infest_ */

}
