package zork;

public class Dso7
{
	/* ENCRYP--	ENCRYPT PASSWORD */

	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;
	
	public Dso7(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;		
	}


	void encryp_(final char []inw, char []outw)
	{
//	   /* Initialized data */
//
//	   final char *keyw = "ECORMS";
//
//	   int i, j, uinw[6], usum;
//	   char ukeyw[1*6];
//	   int uinws, ukeyws;
//
//	   /* Parameter adjustments */
//	   --outw;
//	   --inw;
//
//	   /* Function Body */
//
//	   uinws = 0;
//	   /* UNBIASED INW SUM. */
//	   ukeyws = 0;
//	   /* UNBIASED KEYW SUM. */
//	   j = 1;
//	   /* POINTER IN KEYWORD. */
//	   for (i = 1; i <= 6; ++i) {
//	      /* UNBIAS, COMPUTE SUMS. */
//	      ukeyw[i - 1] = (keyw[i - 1] - 64);
//	      if (inw[j] <= '@') {
//	         j = 1;
//	      }
//	      uinw[i - 1] = inw[j] - 64;
//	      ukeyws += ukeyw[i - 1];
//	      uinws += uinw[i - 1];
//	      ++j;
//	      /* L100: */
//	   }
//
//	   usum = uinws % 8 + (ukeyws % 8 << 3);
//	   /* COMPUTE MASK. */
//	   for (i = 1; i <= 6; ++i) {
//	      j = (uinw[i - 1] ^ ukeyw[i - 1] ^ usum) & 31;
//	      usum = (usum + 1) % 32;
//	      if (j > 26) {
//	         j %= 26;
//	      }
//	      outw[i] = (max(1,j) + 64);
//	      /* L200: */
//	   }
		throw new RuntimeException("Dso7.encryp not impl");
	} /* encryp_ */

	/* CPGOTO--	MOVE TO NEXT STATE IN PUZZLE ROOM */

	/* DECLARATIONS */

	void cpgoto_(int st)
	{
	   /* System generated locals */
	   int i__2;

	   /* Local variables */
	   int i;

	   vars.rooms_1.rflag[vars.rindex_1.cpuzz - 1] &= ~ Vars.RSEEN;
	   for (i = 1; i <= vars.objcts_1.olnt; ++i) {
	      /* RELOCATE OBJECTS. */
	      if (vars.objcts_1.oroom[i - 1] == vars.rindex_1.cpuzz && (vars.objcts_1.oflag2[i - 1]
	               & Vars.ACTRBT + Vars.VILLBT) == 0) {
	         i__2 = vars.findex_1.cphere * vars.hyper_1.hfactr;
	         game.dsub.newsta_(i, 0, i__2, 0, 0);
	      }
	      if (vars.objcts_1.oroom[i - 1] == st * vars.hyper_1.hfactr) {
	         game.dsub.newsta_(i, 0, vars.rindex_1.cpuzz, 0, 0);
	      }
	      /* L100: */
	   }
	   vars.findex_1.cphere = st;
	} /* cpgoto_ */

	/* CPINFO--	DESCRIBE PUZZLE ROOM */

	/* DECLARATIONS */
	   static final int[] dgmoft = new int[]{ -9,-8,-7,-1,1,7,8,9 };

	void cpinfo_(int rmk, int st)
	{
	   /* Initialized data */

	   final char[] pict = "SSS M".toCharArray();

	   /* Local variables */
	   int i, j, k, l;
	   char[] dgm = new char[8];

	   game.dsub.rspeak_(rmk);
	   for (i = 1; i <= 8; ++i) {
	      j = dgmoft[i - 1];
	      dgm[i - 1] = pict[vars.puzzle_1.cpvec[st + j - 1] + 3];
	      /* GET PICTURE ELEMENT. */
	      if (Math.abs(j) == 1 || Math.abs(j) == 8) {
	         continue;
	      }
	      k = 8;
	      if (j < 0) {
	         k = -8;
	      }
	      /* GET ORTHO DIR. */
	      l = j - k;
	      if (vars.puzzle_1.cpvec[st + k - 1] != 0 && vars.puzzle_1.cpvec[st + l - 1] !=
	            0) {
	         dgm[i - 1] = '?';
	      }
	   }

	   Supp.print("       |"+dgm[0]+""+ dgm[0]+" "+dgm[1]+""+dgm[1]+" "+dgm[2]+""+dgm[2]+"|\n");
	   Supp.print(" West  |"+dgm[3]+""+ dgm[3]+" .. "+dgm[4]+""+ dgm[4]+"| East\n");
	   Supp.print("       |"+dgm[5]+""+ dgm[5]+" "+dgm[6]+""+ dgm[6]+" "+dgm[7]+""+ dgm[7]+"|\n");

	   if (st == 10) {
	      game.dsub.rspeak_(870);
	   }
	   /* AT HOLE? */
	   if (st == 37) {
	      game.dsub.rspeak_(871);
	   }
	   /* AT NICHE? */
	   i = 872;
	   /* DOOR OPEN? */
	   if (vars.findex_1.cpoutf) {
	      i = 873;
	   }
	   if (st == 52) {
	      game.dsub.rspeak_(i);
	   }
	   /* AT DOOR? */
	   if (vars.puzzle_1.cpvec[st] == -2) {
	      game.dsub.rspeak_(874);
	   }
	   /* EAST LADDER? */
	   if (vars.puzzle_1.cpvec[st - 2] == -3) {
	      game.dsub.rspeak_(875);
	   }
	   /* WEST LADDER? */
		
	} /* cpinfo_ */

}
