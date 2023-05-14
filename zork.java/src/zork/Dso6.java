package zork;

import java.io.IOException;

public class Dso6
{
	/* GHERE--	IS GLOBAL ACTUALLY IN THIS ROOM? */

	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;	
	Dgame game = null;

	public Dso6(Vars vars, Dgame game)
	{
		this.vars = vars;		
		this.game = game;
	}
	

	boolean ghere_(int obj, int rm) throws IOException
	{
	   /* System generated locals */
	   boolean ret_val;

	   ret_val = true;
	   int GOTO = 2000;
	   /* 						!ASSUME WINS. */
	   switch (obj - vars.star_1.strbit) {
	   case 1: 
	   case 2:
	   case 3:
	   case 4:
	   case 5:
	   case 6:
	   case 7:
	   case 8:
	   case 9:
	   case 10: 
	   case 11:  
	      return true;
	   /* 1000--	STARS ARE ALWAYS HERE */
	   case 12:  GOTO = 2000;break;
	   case 13:  GOTO = 3000;break;
	   case 14:  GOTO = 4000;break;
	   case 15:  GOTO = 5000;break;
	   case 16:  GOTO = 5000;break;
	   case 17:  GOTO = 5000;break;
	   case 18:  GOTO = 6000;break;
	   case 19:  GOTO = 7000;break;
	   case 20:  GOTO = 8000;break;
	   case 21:  GOTO = 9000;break;
	   case 22:  GOTO = 9100;break;
	   case 23:  GOTO = 8000;break;
	   case 24:  GOTO = 10000;break;
	   case 25:  GOTO = 11000;break;
	   default:
		   game.dsub.bug_(60, obj);
		   break;
	   }
	


	   /* 2000--	BIRD */
	   switch(GOTO)
	   {

	case 2000:
	   ret_val = rm >= vars.rindex_1.fore1 && rm < vars.rindex_1.clear || rm == 
	      vars.rindex_1.mtree;
	   return ret_val;

	   /* 3000--	TREE */

	case 3000:
	   ret_val = rm >= vars.rindex_1.fore1 && rm < vars.rindex_1.clear && rm != 
	      vars.rindex_1.fore3;
	   return ret_val;

	   /* 4000--	NORTH WALL */

	case 4000:
	   ret_val = rm >= vars.rindex_1.bkvw && rm <= vars.rindex_1.bkbox || rm == 
	      vars.rindex_1.cpuzz;
	   return ret_val;

	   /* 5000--	EAST, SOUTH, WEST WALLS */

	case 5000:
	   ret_val = rm >= vars.rindex_1.bkvw && rm < vars.rindex_1.bkbox || rm == 
	      vars.rindex_1.cpuzz;
	   return ret_val;

	   /* 6000--	GLOBAL WATER */

	case 6000:
	   ret_val = (vars.rooms_1.rflag[rm - 1] & Vars.RWATER + Vars.RFILL) != 0;
	   return ret_val;

	   /* 7000--	GLOBAL GUARDIANS */

	case 7000:
	   ret_val = rm >= vars.rindex_1.mrc && rm <= vars.rindex_1.mrd || rm >= 
	      vars.rindex_1.mrce && rm <= vars.rindex_1.mrdw || rm == vars.rindex_1.inmir;
	   return ret_val;

	   /* 8000--	ROSE/CHANNEL */

	case 8000:
	   ret_val = rm >= vars.rindex_1.mra && rm <= vars.rindex_1.mrd || rm == 
	      vars.rindex_1.inmir;
	   return ret_val;

	   /* 9000--	MIRROR */
	   /* 9100		PANEL */

	case 9100:
	   if (rm == vars.rindex_1.fdoor) {
	      return ret_val;
	   }
	   /* 						!PANEL AT FDOOR. */
	case 9000:
	   ret_val = rm >= vars.rindex_1.mra && rm <= vars.rindex_1.mrc || rm >= 
	      vars.rindex_1.mrae && rm <= vars.rindex_1.mrcw;
	   return ret_val;

	   /* 10000--	MASTER */

	case 10000:
	   ret_val = rm == vars.rindex_1.fdoor || rm == vars.rindex_1.ncorr || rm == 
	      vars.rindex_1.parap || rm == vars.rindex_1.cell;
	   return ret_val;

	   /* 11000--	LADDER */

	case 11000:
	   ret_val = rm == vars.rindex_1.cpuzz;
	   return ret_val;
	   }
		   throw new RuntimeException("Dso6.ghere_ action not found");

	} /* ghere_ */

	/* MRHERE--	IS MIRROR HERE? */

	/* DECLARATIONS */

	int mrhere_(int rm)
	{
//	   /* System generated locals */
//	   int ret_val;
//
//	   if (rm < vars.rindex_1.mrae || rm > vars.rindex_1.mrdw) {
//	      goto L100;
//	   }
//
//	   /* RM IS AN E-W ROOM, MIRROR MUST BE N-S (MDIR= 0 OR 180) */
//
//	   ret_val = 1;
//	   /* 						!ASSUME MIRROR 1 HERE. */
//	   if ((rm - vars.rindex_1.mrae) % 2 == findex_1.mdir / 180) {
//	      ret_val = 2;
//	   }
//	   return ret_val;
//
//	   /* RM IS NORTH OR SOUTH OF MIRROR.  IF MIRROR IS N-S OR NOT */
//	   /* WITHIN ONE ROOM OF RM, LOSE. */
//
//	L100:
//	   ret_val = 0;
//	   if ((abs(findex_1.mloc - rm)) != 1 || findex_1.mdir % 180 ==
//	         0) {
//	      return ret_val;
//	   }
//
//	   /* RM IS WITHIN ONE OF MLOC, AND MDIR IS E-W */
//
//	   ret_val = 1;
//	   if (rm < findex_1.mloc && findex_1.mdir < 180 || rm > findex_1.mloc && 
//	         findex_1.mdir > 180) {
//	      ret_val = 2;
//	   }
//	   return ret_val;
	   throw new RuntimeException("Dso6.mrhere_ not impl");
	} /* mrhere_ */

}
