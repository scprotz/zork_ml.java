package zork;

import java.io.IOException;

public class Dsub
{
	
	Vars vars = null;	
	Rooms rooms = null;
	NRooms nrooms = null;
	Dgame game = null;
	Objcts objcts = null;
	
	private static final int EOF = -1;
	
	public Dsub(Vars vars, Dgame game)
	{
		this.vars = vars;		
		this.game = game;
		this.rooms = new Rooms();
		this.nrooms = new NRooms();		
	}
//	/* RESIDENT SUBROUTINES FOR DUNGEON */
//
//	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
//	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
//	/* WRITTEN BY R. M. SUPNIK */
//
//	#include <stdio.h>
//	#include "funcs.h"
//	#include "vars.h"
//
//	#ifndef SEEK_SET
//	#define SEEK_SET (0)
//	#endif
//
//	extern FILE *dbfile;
//
//	static void rspsb2nl_ P((int, int, int, boolean));
//
//	/* RSPEAK-- OUTPUT RANDOM MESSAGE ROUTINE */
//
//	/* CALLED BY-- */
//
//	/* 	CALL RSPEAK(MSGNUM) */
//
	public void rspeak_(int n) throws IOException
	{
	   rspsb2nl_(n, 0, 0, 1);
	} /* rspeak_ */

	/* RSPSUB-- OUTPUT RANDOM MESSAGE WITH SUBSTITUTABLE ARGUMENT */

	/* CALLED BY-- */

	/* 	CALL RSPSUB(MSGNUM,SUBNUM) */

	void rspsub_(int n, int s1) throws IOException
	{
	   rspsb2nl_(n, s1, 0, 1);
	} /* rspsub_ */

	/* RSPSB2-- OUTPUT RANDOM MESSAGE WITH UP TO TWO SUBSTITUTABLE ARGUMENTS */

	/* CALLED BY-- */

	/* 	CALL RSPSB2(MSGNUM,SUBNUM1,SUBNUM2) */

	void rspsb2_(int n, int s1, int s2) throws IOException
	{
	   rspsb2nl_(n, s1, s2, 1);
	} /* rspsb2_ */

	/* rspsb2nl_ Display a substitutable message with an optional newline */

	private void rspsb2nl_(int n, int y, int z, int nl) throws IOException
	{
	   int res;
	   String zkey = "IanLanceTaylorJr";
	   int x = (int)n;

	   if (x > 0) {
	      x = vars.rmsg_1.rtext[x - 1];
	   }
	   /* 						!IF >0, LOOK UP IN RTEXT. */
	   else if (x == 0) {
	      return;
	   }
	   /* 						!ANYTHING TO DO? */
	   vars.play_1.telflg = true;
	   /* 						!SAID SOMETHING. */

	   x = ((- x) - 1) * 8;
//	   res = fseek(game.init.dbfile, x + (int)vars.rmsg_1.mrloc, SEEK_SET);
//	   game.init.dbfile.seek(x + (int)vars.rmsg_1.mrloc);
	   res = 0;
	   try
	   {
		   game.init.dbfile.seek(x + (int)vars.rmsg_1.mrloc);
	   }
	   catch(Exception e)
	   {
		   res = -1;
	   }
	if(Vars.DEBUG)
	{
//	#ifdef DEBUG
	   if (res == EOF) 
	   {
		   System.err.println("Error seeking database loc "+x);
	       Supp.exit_();
	   }
//	#endif
	}

	   if (nl != 0)
	      Supp.more_output(null);

	   while (true) {
	      int i;

//	      i = getc(game.init.dbfile);
	      i = game.init.dbfile.read();
//	ifdef DEBUG
	      if(Vars.DEBUG)
	      {
	      if (i == EOF) {
	    	  System.err.println("Error reading database loc " + x);
	         Supp.exit_();
	      }
//	#endif
	      }
	      i ^= zkey.charAt( x & 0xf) ^ (x & 0xff);
	      
//	      i ^= zkey[x & 0xf] ^ (x & 0xff);
	      x = x + 1;
	      if (i == '\0')
	         break;
	      else if (i == '\n') {
	    	  System.out.println();
//	         putchar('\n');
	         if (nl != 0)
	            Supp.more_output(null);
	      }
	      else if (i == '#' && y != 0) {
	         long iloc;

//	         iloc = ftell(game.init.dbfile);
	         iloc = game.init.dbfile.getFilePointer();
	         rspsb2nl_(y, 0, 0, 0);
//		 res = fseek(game.init.dbfile, iloc, SEEK_SET);
	         res = 0;
	         try
	         {
	         game.init.dbfile.seek(iloc);
	         }
	         catch(Exception e)
	         {
	        	 res = -1;
	         }
//	#ifdef DEBUG
		 if(Vars.DEBUG)
		 {
	         if (res == EOF) {
	        	 System.err.println("Error seeking database loc " + iloc);
	            Supp.exit_();
	         }
//	#endif
		 }
	         y = z;
	         z = 0;
	      }
	      else
	    	  System.out.print((char)i);
//	         putchar(i);
	   }

	   if (nl != 0)
		   System.out.print("\n");
//	      putchar('\n');
	}

	/* OBJACT-- APPLY OBJECTS FROM PARSE VECTOR */

	/* DECLARATIONS */

	boolean objact_()
	{
	   /* 						!ASSUME WINS. */
	   if (vars.prsvec_1.prsi != 0 && 
	         objcts.oappli_(vars.objcts_1.oactio[vars.prsvec_1.prsi - 1], 0)) {
	      return true;
	   }
	   /* 						!YES, LET IT HANDLE. */

	   /* 						!DIR OBJECT? */
	   if (vars.prsvec_1.prso != 0 && 
	         objcts.oappli_(vars.objcts_1.oactio[vars.prsvec_1.prso - 1], 0)) {
	      return true;
	   }
	   /* 						!YES, LET IT HANDLE. */

	   return false;
	} /* objact_ */

	/* BUG-- REPORT FATAL SYSTEM ERROR */

	/* CALLED BY-- */

	/* 	CALL BUG(NO,PAR) */

	void bug_(int a, int b)
	{
//	#ifdef DEBUG
		if (Vars.DEBUG)
		{

			/* Local variables */

			Supp.more_output(null);
			System.out.println("PROGRAM ERROR " + a + ", PARAMETER=" + b);

			if (vars.debug_1.dbgflg != 0)
			{
				return;
			}
			Supp.exit_();
//	#endif
		}

	} /* bug_ */

	/* NEWSTA-- SET NEW STATUS FOR OBJECT */

	/* CALLED BY-- */

	/* 	CALL NEWSTA(OBJECT,STRING,NEWROOM,NEWCON,NEWADV) */

	void newsta_(int o, int r, int rm, int cn, int ad) throws IOException
	{
	   rspeak_(r);
	   vars.objcts_1.oroom[o - 1] = rm;
	   vars.objcts_1.ocan[o - 1] = cn;
	   vars.objcts_1.oadv[o - 1] = ad;
	} /* newsta_ */

	/* QHERE-- TEST FOR OBJECT IN ROOM */

	/* DECLARATIONS */

	boolean qhere_(int obj, int rm)
	{
	   /* Local variables */
	   int i;

	   if (vars.objcts_1.oroom[obj - 1] == rm) {
	      return true;
	   }
	   /* 						!IN ROOM? */
	   for (i = 1; i <= vars.oroom2_1.r2lnt; ++i) {
	      /* 						!NO, SCH ROOM2. */
	      if (vars.oroom2_1.oroom2[i - 1] == obj && vars.oroom2_1.rroom2[i - 1] == rm) {
	         return true;
	      }
	   }
	   /* 						!NOT PRESENT. */
	   return false;
	} /* qhere_ */

	/* QEMPTY-- TEST FOR OBJECT EMPTY */

	/* DECLARATIONS */

	boolean qempty_(int obj)
	{
	   /* Local variables */
	   int i;

	   /* 						!ASSUME LOSE. */
	   for (i = 1; i <= vars.objcts_1.olnt; ++i) {
	      if (vars.objcts_1.ocan[i - 1] == obj) {
	         return false;
	      }
	      /* 						!INSIDE TARGET? */
	   }
	   return true;
	} /* qempty_ */

	/* JIGSUP- YOU ARE DEAD */

	/* DECLARATIONS */

	void jigsup_(int desc)
	{
//	   /* Initialized data */
//
//	   static const int rlist[9] = { 8,6,36,35,34,4,34,6,5 };
//
//	   /* Local variables */
//	   int nonofl;
//	   boolean f;
//	   int i, j;
//
//	   rspeak_(desc);
//	   /* 						!DESCRIBE SAD STATE. */
//	   prsvec_1.prscon = 1;
//	   /* 						!STOP PARSER. */
//	#ifdef DEBUG
//	   if (debug_1.dbgflg != 0) {
//	      return;
//	   }
//	#endif
//	   /* 						!IF DBG, EXIT. */
//	   advs_1.avehic[play_1.winner - 1] = 0;
//	   /* 						!GET RID OF VEHICLE. */
//	   if (!(play_1.winner == aindex_1.player)) {
//	      /* 						!HIMSELF? */
//	      rspsub_(432, objcts_1.odesc2[advs_1.aobj[play_1.winner - 1] - 1]);
//	      /* 						!NO, SAY WHO DIED. */
//	      newsta_(advs_1.aobj[play_1.winner - 1], 0, 0, 0, 0);
//	      /* 						!SEND TO HYPER SPACE. */
//	      return;
//	   }
//
//	   if (findex_1.endgmf) {
//	      goto L900;
//	   }
//	   /* 						!NO RECOVERY IN END GAME. */
//	   if (state_1.deaths >= 2) {
//	      goto L1000;
//	   }
//	   /* 						!DEAD TWICE? KICK HIM OFF. */
//	   if (! yesno_(10, 9, 8)) {
//	      goto L1100;
//	   }
//	   /* 						!CONTINUE? */
//
//	   for (j = 1; j <= objcts_1.olnt; ++j) {
//	      /* 						!TURN OFF FIGHTING. */
//	      if (qhere_(j, play_1.here)) {
//	         objcts_1.oflag2[j - 1] &= ~ FITEBT;
//	      }
//	      /* L50: */
//	   }
//
//	   ++state_1.deaths;
//	   scrupd_(- 10);
//	   /* 						!CHARGE TEN POINTS. */
//	   f = moveto_(rindex_1.fore1, play_1.winner);
//	   /* 						!REPOSITION HIM. */
//	   findex_1.egyptf = true;
//	   /* 						!RESTORE COFFIN. */
//	   if (objcts_1.oadv[oindex_1.coffi - 1] == play_1.winner) {
//	      newsta_(oindex_1.coffi, 0, rindex_1.egypt, 0, 0);
//	   }
//	   objcts_1.oflag2[oindex_1.door - 1] &= ~ TCHBT;
//	   objcts_1.oflag1[oindex_1.robot - 1] = (objcts_1.oflag1[oindex_1.robot - 1]
//	         | VISIBT) & ~ NDSCBT;
//	   if (objcts_1.oroom[oindex_1.lamp - 1] != 0 || objcts_1.oadv[oindex_1.lamp 
//	         - 1] == play_1.winner) {
//	      newsta_(oindex_1.lamp, 0, rindex_1.lroom, 0, 0);
//	   }
//
//	   /* NOW REDISTRIBUTE HIS VALUABLES AND OTHER BELONGINGS. */
//
//	   /* THE LAMP HAS BEEN PLACED IN THE LIVING ROOM. */
//	   /* THE FIRST 8 NON-VALUABLES ARE PLACED IN LOCATIONS AROUND THE HOUSE. */
//	   /* HIS VALUABLES ARE PLACED AT THE END OF THE MAZE. */
//	   /* REMAINING NON-VALUABLES ARE PLACED AT THE END OF THE MAZE. */
//
//	   i = 1;
//	   for (j = 1; j <= objcts_1.olnt; ++j) {
//	      /* 						!LOOP THRU OBJECTS. */
//	      if (objcts_1.oadv[j - 1] != play_1.winner || objcts_1.otval[j - 1] != 
//	            0) {
//	         goto L200;
//	      }
//	      ++i;
//	      if (i > 9) {
//	         goto L400;
//	      }
//	      /* 						!MOVE TO RANDOM LOCATIONS. */
//	      newsta_(j, 0, rlist[i - 1], 0, 0);
//	L200:
//	      ;
//	   }
//
//	L400:
//	   i = rooms_1.rlnt + 1;
//	   /* 						!NOW MOVE VALUABLES. */
//	   nonofl = RAIR + RWATER + RSACRD + REND;
//	   /* 						!DONT MOVE HERE. */
//	   for (j = 1; j <= objcts_1.olnt; ++j) {
//	      if (objcts_1.oadv[j - 1] != play_1.winner || objcts_1.otval[j - 1] == 
//	            0) {
//	         goto L300;
//	      }
//	L250:
//	      --i;
//	      /* 						!FIND NEXT ROOM. */
//	      if ((rooms_1.rflag[i - 1] & nonofl) != 0) {
//	         goto L250;
//	      }
//	      newsta_(j, 0, i, 0, 0);
//	      /* 						!YES, MOVE. */
//	L300:
//	      ;
//	   }
//
//	   for (j = 1; j <= objcts_1.olnt; ++j) {
//	      /* 						!NOW GET RID OF REMAINDER. */
//	      if (objcts_1.oadv[j - 1] != play_1.winner) {
//	         goto L500;
//	      }
//	L450:
//	      --i;
//	      /* 						!FIND NEXT ROOM. */
//	      if ((rooms_1.rflag[i - 1] & nonofl) != 0) {
//	         goto L450;
//	      }
//	      newsta_(j, 0, i, 0, 0);
//	L500:
//	      ;
//	   }
//	   return;
//
//	   /* CAN'T OR WON'T CONTINUE, CLEAN UP AND EXIT. */
//
//	L900:
//	   rspeak_(625);
//	   /* 						!IN ENDGAME, LOSE. */
//	   goto L1100;
//
//	L1000:
//	   rspeak_(7);
//	   /* 						!INVOLUNTARY EXIT. */
//	L1100:
//	   score_(0);
//	   /* 						!TELL SCORE. */
//	   (void) fclose(dbfile);
//	   exit_();
		throw new RuntimeException("Dsub.jigsup_ not impl");
	} /* jigsup_ */

	/* OACTOR-	GET ACTOR ASSOCIATED WITH OBJECT */

	/* DECLARATIONS */

	int oactor_(int obj)
	{
	   /* System generated locals */

	   /* Local variables */
	   int i;

	   for (i = 1; i <= vars.advs_1.alnt; ++i) {
	      /* 						!LOOP THRU ACTORS. */
	      /* 						!ASSUME FOUND. */
	      if (vars.advs_1.aobj[i - 1] == obj) {
	         return i;
	      }
	      /* 						!FOUND IT? */
	      /* L100: */
	   }
	   if(Vars.DEBUG)
	   {
//	#ifdef DEBUG
	   bug_(40, obj);
//	#endif
	   }
	   /* 						!NO, DIE. */
	   return vars.advs_1.alnt + 1;
	} /* oactor_ */

	/* PROB-		COMPUTE PROBABILITY */

	/* DECLARATIONS */

	boolean prob_(int g, int b)
	{
	   /* System generated locals */

	   /* Local variables */
	   int i;

	   i = g;
	   /* 						!ASSUME GOOD LUCK. */
	   if (vars.findex_1.badlkf) 
	   {
	      i = b;
	   }
	   /* 						!IF BAD, TOO BAD. */
	   /* 						!COMPUTE. */
	   return (Supp.rnd_(100) < i);
	} /* prob_ */

	/* RMDESC-- PRINT ROOM DESCRIPTION */

	/* RMDESC PRINTS A DESCRIPTION OF THE CURRENT ROOM. */
	/* IT IS ALSO THE PROCESSOR FOR VERBS 'LOOK' AND 'EXAMINE'. */

	boolean rmdesc_(int full) throws IOException
	{
	   /* System generated locals */
	   boolean ret_val, L__1;

	   /* Local variables */
	   int i = 0, ra = 0;
	   int GOTO = 0;

	   /* FULL=	0/1/2/3=	SHORT/OBJ/ROOM/FULL */

	   ret_val = true;

	   /* 						!ASSUME WINS. */
	   if (vars.prsvec_1.prso < vars.xsrch_1.xmin) {
	      GOTO = 50;
	   }
	   if(GOTO != 0)
	   {
	   /* 						!IF DIRECTION, */
	   vars.screen_1.fromdr = vars.prsvec_1.prso;
	   /* 						!SAVE AND */
	   vars.prsvec_1.prso = 0;
	   /* 						!CLEAR. */
	   }
		  do
		  {
			  switch(GOTO)
			  {
	case 50:
	   if (vars.play_1.here == vars.advs_1.aroom[vars.aindex_1.player - 1]) {
	      GOTO = 100;
			continue;
	   }
	   /* 						!PLAYER JUST MOVE? */
	   rspeak_(2);
	   /* 						!NO, JUST SAY DONE. */
	   vars.prsvec_1.prsa = vars.vindex_1.walkiw;
	   /* 						!SET UP WALK IN ACTION. */
	   return ret_val;

	case 100:
	   if (game .dso5.lit_(vars.play_1.here)) {
	      GOTO = 300;
			continue;
	   }
	   /* 						!LIT? */
	   rspeak_(430);
	   /* 						!WARN OF GRUE. */
	   ret_val = false;
	   return ret_val;

	case 300:
	   ra = vars.rooms_1.ractio[vars.play_1.here - 1];
	   /* 						!GET ROOM ACTION. */
	   if (full == 1) {
	      GOTO = 600;
			continue;
	   }
	   /* 						!OBJ ONLY? */
	   i = vars.rooms_1.rdesc2[vars.play_1.here - 1];
	   /* 						!ASSUME SHORT DESC. */
	   if (full == 0 && (vars.findex_1.superf || (vars.rooms_1.rflag[vars.play_1.here - 1] & 
	               Vars.RSEEN) != 0 && vars.findex_1.brieff)) {
	      GOTO = 400;
			continue;
	   }

	   /*  The next line means that when you request VERBOSE mode, you */
	   /*  only get long room descriptions 20% of the time. I don't either */
	   /*  like or understand this, so the mod. ensures VERBOSE works */
	   /*  all the time.			jmh@ukc.ac.uk 22/10/87 */

	   /* &		        .AND.(BRIEFF.OR.PROB(80,80)))))       GO TO 400 */
	   i = vars.rooms_1.rdesc1[vars.play_1.here - 1];
	   /* 						!USE LONG. */
	   if (i != 0 || ra == 0) {
	      GOTO = 400;
			continue;
	   }
	   /* 						!IF GOT DESC, SKIP. */
	   vars.prsvec_1.prsa = vars.vindex_1.lookw;
	   /* 						!PRETEND LOOK AROUND. */
	   if (! rappli_(ra)) {
	      GOTO = 100;
			continue;
	   }
	   /* 						!ROOM HANDLES, NEW DESC? */
	   vars.prsvec_1.prsa = vars.vindex_1.foow;
	   /* 						!NOP PARSER. */
	   GOTO = 500;
			continue;

	case 400:
	   rspeak_(i);
	   /* 						!OUTPUT DESCRIPTION. */
	case 500:
	   if (vars.advs_1.avehic[vars.play_1.winner - 1] != 0) {
	      rspsub_(431, vars.objcts_1.odesc2[vars.advs_1.avehic[vars.play_1.winner - 1] - 
	            1]);
	   }

	case 600:
	   if (full != 2) {
	      L__1 = full != 0;
	      game.dso1.princr_(L__1, vars.play_1.here);
	   }
	   vars.rooms_1.rflag[vars.play_1.here - 1] |= Vars.RSEEN;
	   if (full != 0 || ra == 0) {
	      return ret_val;
	   }
	   /* 						!ANYTHING MORE? */
	   vars.prsvec_1.prsa = vars.vindex_1.walkiw;
	   /* 						!GIVE HIM A SURPISE. */
	   if (! rappli_(ra)) {
	      GOTO = 100;
			continue;
	   }
	   /* 						!ROOM HANDLES, NEW DESC? */
	   vars.prsvec_1.prsa = vars.vindex_1.foow;
	   return ret_val;
		  }
	}while(true);

	} /* rmdesc_ */

	/* RAPPLI-	ROUTING ROUTINE FOR ROOM APPLICABLES */

	/* DECLARATIONS */

	boolean rappli_(int ri)
	{
	   /* Initialized data */

	   final int newrms = 38;

	   /* System generated locals */

	   /* 						!ASSUME WINS. */
	   if (ri == 0) {
	      return true;
	   }
	   /* 						!IF ZERO, WIN. */
	   if (ri >= newrms) {
	      return nrooms.rappl2_(ri);
	   }
	   /* 						!IF NEW, PROCESSOR 2. */
	   else 
	   {
	      return rooms.rappl1_(ri);
	   }
	   
	   /* 						!IF OLD, PROCESSOR 1. */
	} /* rappli_ */

}
