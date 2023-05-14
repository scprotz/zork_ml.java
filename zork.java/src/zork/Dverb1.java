package zork;

import java.io.IOException;

public class Dverb1
{
	/* TAKE-- BASIC TAKE SEQUENCE */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;
	Verbs verbs = null;

	public Dverb1(Vars vars, Dgame game, Verbs verbs)
	{
		this.vars = vars;
		this.game = game;
		this.verbs = verbs;
	}

	/* TAKE AN OBJECT (FOR VERBS TAKE, PUT, DROP, READ, ETC.) */
	boolean take_(boolean flg) throws IOException
	{
		/* System generated locals */
		int i__1;
		boolean ret_val;

		/* Local variables */
		int oa;
		int x;
		int GOTO = 500;

		ret_val = false;
		/* !ASSUME LOSES. */
		oa = vars.objcts_1.oactio[vars.prsvec_1.prso - 1];
		/* !GET OBJECT ACTION. */
		if (vars.prsvec_1.prso > vars.star_1.strbit)
		{
			return game.dsub.objact_();
		}

		x = vars.objcts_1.ocan[vars.prsvec_1.prso - 1];
		/* !INSIDE? */
		if (vars.prsvec_1.prso == vars.advs_1.avehic[vars.play_1.winner - 1])
		{
			game.dsub.rspeak_(672);
			/* !DUMMY. */
			return false;
		}
		/* !HIS VEHICLE? */

		boolean skip = false;

		if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.TAKEBT) != 0)
		{
			skip = true;
		}
		if (!skip)
		{
			if (!game.objcts.oappli_(oa, 0))
			{
				i__1 = Supp.rnd_(5) + 552;
				game.dsub.rspeak_(i__1);
			}
			return ret_val;
		}

		/* OBJECT IS TAKEABLE AND IN POSITION TO BE TAKEN. */

		do
		{
			switch (GOTO)
			{

				case 500:
					if (x != 0 || game.dsub.qhere_(vars.prsvec_1.prso, vars.play_1.here))
					{
						GOTO = 600;
						continue;
					}
					if (vars.objcts_1.oadv[vars.prsvec_1.prso - 1] == vars.play_1.winner)
					{
						game.dsub.rspeak_(557);
					}
					/* !ALREADY GOT IT? */
					return ret_val;

				case 600:
					if (x != 0 && vars.objcts_1.oadv[x - 1] == vars.play_1.winner || game.dso5
							.weight_(0, vars.prsvec_1.prso, vars.play_1.winner)
							+ vars.objcts_1.osize[vars.prsvec_1.prso - 1] <= vars.state_1.mxload)
					{
						GOTO = 700;
						continue;
					}
					game.dsub.rspeak_(558);
					/* !TOO MUCH WEIGHT. */
					return ret_val;

				case 700:
					ret_val = true;
					/* !AT LAST. */
					if (game.objcts.oappli_(oa, 0))
					{
						return ret_val;
					}
					/* !DID IT HANDLE? */
					game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, vars.play_1.winner);
					/* !TAKE OBJECT FOR WINNER. */
					vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] |= Vars.TCHBT;
					game.dso2.scrupd_(vars.objcts_1.ofval[vars.prsvec_1.prso - 1]);
					/* !UPDATE SCORE. */
					vars.objcts_1.ofval[vars.prsvec_1.prso - 1] = 0;
					/* !CANT BE SCORED AGAIN. */
					if (flg)
					{
						game.dsub.rspeak_(559);
					}
					/* !TELL TAKEN. */
					return ret_val;
			}
		} while (true);
	} /* take_ */

	/* DROP- DROP VERB PROCESSOR */

	/* DECLARATIONS */

	boolean drop_(boolean z) throws IOException	
	{
		int GOTO = 200;

		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int i, x;

		ret_val = true;
		/* !ASSUME WINS. */
		x = vars.objcts_1.ocan[vars.prsvec_1.prso - 1];
		/* !GET CONTAINER. */
		boolean skip = false;
		if (x == 0)
		{
			skip = true;
		}
		if (!skip)
		{
			/* !IS IT INSIDE? */
			if (vars.objcts_1.oadv[x - 1] != vars.play_1.winner)
			{
				game.dsub.rspeak_(527);
				/* !DONT HAVE IT. */
				return ret_val;
			}

			/* !IS HE CARRYING CON? */
			if ((vars.objcts_1.oflag2[x - 1] & Vars.OPENBT) != 0)
			{
				GOTO = 300;
			}
			if (GOTO != 300)
			{
				game.dsub.rspsub_(525, vars.objcts_1.odesc2[x - 1]);
				/* !CANT REACH. */
				return ret_val;
			}

		}
		do
		{
			switch (GOTO)
			{
				case 200:
					if (vars.objcts_1.oadv[vars.prsvec_1.prso - 1] != vars.play_1.winner)
					{
						game.dsub.rspeak_(527);
						/* !DONT HAVE IT. */
						return ret_val;
					}
					/* !IS HE CARRYING OBJ? */
				case 300:
					if (vars.advs_1.avehic[vars.play_1.winner - 1] == 0)
					{
						GOTO = 400;
						continue;
					}
					/* !IS HE IN VEHICLE? */
					vars.prsvec_1.prsi = vars.advs_1.avehic[vars.play_1.winner - 1];
					/* !YES, */
					put_(true);
					/* !DROP INTO VEHICLE. */
					vars.prsvec_1.prsi = 0;
					/* !DISARM PARSER. */
					return ret_val;
				/* !DONE. */

				case 400:
					game.dsub.newsta_(vars.prsvec_1.prso, 0, vars.play_1.here, 0, 0);
					/* !DROP INTO ROOM. */
					if (vars.play_1.here == vars.rindex_1.mtree)
					{
						game.dsub.newsta_(vars.prsvec_1.prso, 0, vars.rindex_1.fore3, 0, 0);
					}
					game.dso2.scrupd_(vars.objcts_1.ofval[vars.prsvec_1.prso - 1]);
					/* !SCORE OBJECT. */
					vars.objcts_1.ofval[vars.prsvec_1.prso - 1] = 0;
					/* !CANT BE SCORED AGAIN. */
					vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] |= Vars.TCHBT;

					if (game.dsub.objact_())
					{
						return ret_val;
					}
					/* !DID IT HANDLE? */
					i = 0;
					/* !ASSUME NOTHING TO SAY. */
					if (vars.prsvec_1.prsa == vars.vindex_1.dropw)
					{
						i = 528;
					}
					if (vars.prsvec_1.prsa == vars.vindex_1.throww)
					{
						i = 529;
					}
					if (i != 0 && vars.play_1.here == vars.rindex_1.mtree)
					{
						i = 659;
					}
					game.dsub.rspsub_(i, vars.objcts_1.odesc2[vars.prsvec_1.prso - 1]);
					return ret_val;

				case 1000:
					game.dsub.rspeak_(527);
					/* !DONT HAVE IT. */
					return ret_val;
			}
		} while (true);
	} /* drop_ */

	/* PUT- PUT VERB PROCESSOR */
	boolean put_(boolean flg) throws IOException
	{
	   /* System generated locals */
	   boolean ret_val;

	   /* Local variables */
	   int j;
	   int svi, svo;

	   ret_val = false;
	   if (!(vars.prsvec_1.prso <= vars.star_1.strbit && vars.prsvec_1.prsi <= vars.star_1.strbit)) 
	   {
	    
	   
	   if (! game.dsub.objact_()) {
	      game.dsub.rspeak_(560);
	   }
	   /* 						!STAR */
	   ret_val = true;
	   return ret_val;
	   }
//	case 200:
	   if (!((vars.objcts_1.oflag2[vars.prsvec_1.prsi - 1] & Vars.OPENBT) != 0 || (
	            vars.objcts_1.oflag1[vars.prsvec_1.prsi - 1] & Vars.DOORBT + 
	            Vars.CONTBT) != 0 || (vars.objcts_1.oflag2[vars.prsvec_1.prsi - 1] & 
	            		Vars.VEHBT) != 0)) {
	      
	   
	   game.dsub.rspeak_(561);
	   /* 						!CANT PUT IN THAT. */
	   return ret_val;
	   }
//	case 300:
	   if (!((vars.objcts_1.oflag2[vars.prsvec_1.prsi - 1] & Vars.OPENBT) != 0)) {
	      
	   
	   /* 						!IS IT OPEN? */
	   game.dsub.rspeak_(562);
	   /* 						!NO, JOKE */
	   return ret_val;
	   }
//	case 400:
	   if (!(vars.prsvec_1.prso != vars.prsvec_1.prsi)) {
	      
	   
	   /* 						!INTO ITSELF? */
	   game.dsub.rspeak_(563);
	   /* 						!YES, JOKE. */
	   return ret_val;
	   }
//	case 500:
	   if (!(vars.objcts_1.ocan[vars.prsvec_1.prso - 1] != vars.prsvec_1.prsi)) {
	      
	   /* 						!ALREADY INSIDE. */
	   game.dsub.rspsb2_(564, vars.objcts_1.odesc2[vars.prsvec_1.prso - 1], vars.objcts_1.odesc2[
	         vars.prsvec_1.prsi - 1]);
	   ret_val = true;
	   return ret_val;
	   }
//	case 600:
	   if (!(game.dso5.weight_(0, vars.prsvec_1.prso, 0) + game.dso5.weight_(0, vars.prsvec_1.prsi,
	            0) + vars.objcts_1.osize[vars.prsvec_1.prso - 1] <= vars.objcts_1.ocapac[
	         vars.prsvec_1.prsi - 1])) {
	      
	   
	   game.dsub.rspeak_(565);
	   /* 						!THEN CANT DO IT. */
	   return ret_val;
	   }
	   /* NOW SEE IF OBJECT (OR ITS CONTAINER) IS IN ROOM */

//	case 700:
	   j = vars.prsvec_1.prso;
	   /* 						!START SEARCH. */
//	case 725:
	   do
	   {
		   if (game.dsub.qhere_(j, vars.play_1.here)) 
		   {
			   svo = vars.prsvec_1.prso;
			   /* 						!SAVE PARSER. */
			   svi = vars.prsvec_1.prsi;
			   vars.prsvec_1.prsa = vars.vindex_1.takew;
			   vars.prsvec_1.prsi = 0;
			   if (! take_(false)) {
			      return ret_val;
			   }
			   /* 						!TAKE OBJECT. */
			   vars.prsvec_1.prsa = vars.vindex_1.putw;
			   vars.prsvec_1.prso = svo;
			   vars.prsvec_1.prsi = svi;
//			   goto L1000;
			   if (game.dsub.objact_()) {
				      return ret_val;
				   }
				   /* 						!NO, GIVE OBJECT A SHOT. */
				   game.dsub.newsta_(vars.prsvec_1.prso, 2, 0, vars.prsvec_1.prsi, 0);
				   /* 						!CONTAINED INSIDE. */
				   ret_val = true;
				   return ret_val;
			   }
		   /* 						!IS IT HERE? */
		   j = vars.objcts_1.ocan[j - 1];
	   }while(j != 0);
//		   if (j != 0) 
//		   {
//			   goto L725;
//		   }
	   /* 						!MORE TO DO? */
//	   goto L800;
	   /* 						!NO, SCH FAILS. */

//	case 750:
//	   svo = vars.prsvec_1.prso;
//	   /* 						!SAVE PARSER. */
//	   svi = vars.prsvec_1.prsi;
//	   vars.prsvec_1.prsa = vars.vindex_1.takew;
//	   vars.prsvec_1.prsi = 0;
//	   if (! take_(0)) {
//	      return ret_val;
//	   }
//	   /* 						!TAKE OBJECT. */
//	   vars.prsvec_1.prsa = vars.vindex_1.putw;
//	   vars.prsvec_1.prso = svo;
//	   vars.prsvec_1.prsi = svi;
//	   goto L1000;

	   /* NOW SEE IF OBJECT IS ON PERSON. */

//	case 800:
	   if (vars.objcts_1.ocan[vars.prsvec_1.prso - 1] == 0) {
		   if (game.dsub.objact_()) {
			      return ret_val;
			   }
			   /* 						!NO, GIVE OBJECT A SHOT. */
			   game.dsub.newsta_(vars.prsvec_1.prso, 2, 0, vars.prsvec_1.prsi, 0);
			   /* 						!CONTAINED INSIDE. */
			   ret_val = true;
			   return ret_val;	   }
	   /* 						!INSIDE? */
	   if (!((vars.objcts_1.oflag2[vars.objcts_1.ocan[vars.prsvec_1.prso - 1] - 1] & 
	            Vars.OPENBT) != 0)) {
	      
	   /* 						!OPEN? */
	   game.dsub.rspsub_(566, vars.objcts_1.odesc2[vars.prsvec_1.prso - 1]);
	   /* 						!LOSE. */
	   return ret_val;
	   }
//	case 900:
	   game.dso2.scrupd_(vars.objcts_1.ofval[vars.prsvec_1.prso - 1]);
	   /* 						!SCORE OBJECT. */
	   vars.objcts_1.ofval[vars.prsvec_1.prso - 1] = 0;
	   vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] |= Vars.TCHBT;
	   game.dsub.newsta_(vars.prsvec_1.prso, 0, 0, 0, vars.play_1.winner);
	   /* 						!TEMPORARILY ON WINNER. */

//	case 1000:
	   if (game.dsub.objact_()) {
	      return ret_val;
	   }
	   /* 						!NO, GIVE OBJECT A SHOT. */
	   game.dsub.newsta_(vars.prsvec_1.prso, 2, 0, vars.prsvec_1.prsi, 0);
	   /* 						!CONTAINED INSIDE. */
	   ret_val = true;
	   return ret_val;
	} /* put_ */

	/* VALUAC- HANDLES VALUABLES/EVERYTHING */

	void valuac_(int v)
	{
//	   /* Local variables */
//	   boolean f;
//	   int i;
//	   boolean f1;
//	   int savep, saveh;
//
//	   f = true;
//	   /* 						!ASSUME NO ACTIONS. */
//	   i = 579;
//	   /* 						!ASSUME NOT LIT. */
//	   if (! lit_(vars.play_1.here)) {
//	      goto L4000;
//	   }
//	   /* 						!IF NOT LIT, PUNT. */
//	   i = 677;
//	   /* 						!ASSUME WRONG VERB. */
//	   savep = vars.prsvec_1.prso;
//	   /* 						!SAVE PRSO. */
//	   saveh = vars.play_1.here;
//	   /* 						!SAVE HERE. */
//
//	   /* case 100: */
//	   if (vars.prsvec_1.prsa != vars.vindex_1.takew) {
//	      goto L1000;
//	   }
//	   /* 						!TAKE EVERY/VALUA? */
//	   for (vars.prsvec_1.prso = 1; vars.prsvec_1.prso <= vars.objcts_1.olnt; ++vars.prsvec_1.prso) {
//	      /* 						!LOOP THRU OBJECTS. */
//	      if (! game.dsub.qhere_(vars.prsvec_1.prso, vars.play_1.here) || (vars.objcts_1.oflag1[
//	               vars.prsvec_1.prso - 1] & VISIBT) == 0 || (
//	                  vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & ACTRBT) != 0 || 
//	            savep == v && vars.objcts_1.otval[vars.prsvec_1.prso - 1] <= 0) {
//	         continue;
//	      }
//	      if ((vars.objcts_1.oflag1[vars.prsvec_1.prso - 1] & Vars.TAKEBT) == 0 && (
//	               vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & TRYBT) == 0) {
//	         continue;
//	      }
//	      f = false;
//	      game.dsub.rspsub_(580, vars.objcts_1.odesc2[vars.prsvec_1.prso - 1]);
//	      f1 = take_(1);
//	      if (saveh != vars.play_1.here) {
//	         return;
//	      }
//	   }
//	   goto L3000;
//
//	case 1000:
//	   if (vars.prsvec_1.prsa != vars.vindex_1.dropw) {
//	      goto L2000;
//	   }
//	   /* 						!DROP EVERY/VALUA? */
//	   for (vars.prsvec_1.prso = 1; vars.prsvec_1.prso <= vars.objcts_1.olnt; ++vars.prsvec_1.prso) {
//	      if (vars.objcts_1.oadv[vars.prsvec_1.prso - 1] != vars.play_1.winner || savep == v 
//	            && vars.objcts_1.otval[vars.prsvec_1.prso - 1] <= 0) {
//	         continue;
//	      }
//	      f = false;
//	      game.dsub.rspsub_(580, vars.objcts_1.odesc2[vars.prsvec_1.prso - 1]);
//	      f1 = drop_(1);
//	      if (saveh != vars.play_1.here) {
//	         return;
//	      }
//	   }
//	   goto L3000;
//
//	case 2000:
//	   if (vars.prsvec_1.prsa != vars.vindex_1.putw) {
//	      goto L3000;
//	   }
//	   /* 						!PUT EVERY/VALUA? */
//	   for (vars.prsvec_1.prso = 1; vars.prsvec_1.prso <= vars.objcts_1.olnt; ++vars.prsvec_1.prso) {
//	      /* 						!LOOP THRU OBJECTS. */
//	      if (vars.objcts_1.oadv[vars.prsvec_1.prso - 1] != vars.play_1.winner || 
//	            vars.prsvec_1.prso == vars.prsvec_1.prsi || savep == v && 
//	            vars.objcts_1.otval[vars.prsvec_1.prso - 1] <= 0 || (vars.objcts_1.oflag1[
//	               vars.prsvec_1.prso - 1] & VISIBT) == 0) {
//	         continue;
//	      }
//	      f = false;
//	      game.dsub.rspsub_(580, vars.objcts_1.odesc2[vars.prsvec_1.prso - 1]);
//	      f1 = put_(1);
//	      if (saveh != vars.play_1.here) {
//	         return;
//	      }
//	   }
//
//	case 3000:
//	   i = 581;
//	   if (savep == v) {
//	      i = 582;
//	   }
//	   /* 						!CHOOSE MESSAGE. */
//	case 4000:
//	   if (f) {
//	      game.dsub.rspeak_(i);
//	   }
//	   /* 						!IF NOTHING, REPORT. */
		throw new RuntimeException("Dverb1.valuac_ not impl");
	} /* valuac_ */

}
