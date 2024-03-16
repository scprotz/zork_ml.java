package zork.parser;

import zork.Dgame;
import zork.Np;
import zork.Np1;
import zork.Np2;
import zork.Np3;
import zork.Parse;
import zork.Vars;

public class Parser extends Np
{
	Vars vars = null;
	Dgame game = null;
	Np1 np1 = null;
	Np2 np2 = null;
	Np3 np3 = null;
	Parse parse = null;

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	public Parser(Vars vars, Dgame game)
	{
		super(vars, game);
		this.vars = vars;
		this.game = game;
		this.parse = new Parse();
		this.np2 = new Np2(vars, this, game);
		this.np1 = new Np1(vars, this, game);
		this.np3 = new Np3(vars, this, game);
	}

	/* PARSE- TOP LEVEL PARSE ROUTINE */

	/* THIS ROUTINE DETAILS ON BIT 0 OF PRSFLG */

	public boolean parse_(String inbuf, boolean vbflag)
	{
		/* System generated locals */
		int i__1;
		boolean ret_val;

		/* Local variables */
		int outbuf[] = new int[40];
		int[] outlnt = new int[1];

		/* Parameter adjustments */
//	    --inbuf;

		/* Function Body */
		ret_val = false;
		/* !ASSUME FAILS. */
		vars.prsvec_1.prsa = 0;
		/* !ZERO OUTPUTS. */
		vars.prsvec_1.prsi = 0;
		vars.prsvec_1.prso = 0;
		int GOTO = 0;

		if (!lex_(inbuf, outbuf, outlnt, vbflag))
		{
			GOTO = 100;
		}
		if (GOTO != 100)
		{
			if ((i__1 = np1.sparse_(outbuf, outlnt, vbflag)) < 0)
			{
				GOTO = 100;
			}
			else if (i__1 == 0)
			{
				GOTO = 200;

			}
			else
			{
				GOTO = 300;
			}
		}
		/* DO SYN SCAN. */

		/* PARSE REQUIRES VALIDATION */

		do
		{
			switch (GOTO)
			{

				case 200:
					if (!(vbflag))
					{
						GOTO = 350;
						continue;
					}
					/* !ECHO MODE, FORCE FAIL. */
					if (!np3.synmch_())
					{
						GOTO = 100;
						continue;
					}
					/* !DO SYN MATCH. */
					if (vars.prsvec_1.prso > 0 & vars.prsvec_1.prso < vars.xsrch_1.xmin)
					{
						vars.last_1.lastit = vars.prsvec_1.prso;
					}

					/* SUCCESSFUL PARSE OR SUCCESSFUL VALIDATION */

				case 300:
					ret_val = true;
				case 350:
					orphan_(0, 0, 0, 0, 0);
					/* !CLEAR ORPHANS. */
					return ret_val;

				/* PARSE FAILS, DISALLOW CONTINUATION */

				case 100:
					vars.prsvec_1.prscon = 1;
					return ret_val;
			}
		} while (true);
	} /* parse_ */

	/* ORPHAN- SET UP NEW ORPHANS */

	/* DECLARATIONS */

	public void orphan_(int o1, int o2, int o3, int o4, int o5)
	{
		vars.orphs_1.oflag = o1;
		/* SET UP NEW ORPHANS. */
		vars.orphs_1.oact = o2;
		vars.orphs_1.oslot = o3;
		vars.orphs_1.oprep = o4;
		vars.orphs_1.oname = o5;
	} /* orphan_ */

	/* LEX- LEXICAL ANALYZER */

	/* THIS ROUTINE DETAILS ON BIT 1 OF PRSFLAG */

	private static final char dlimit[] = new char[] { 'A', 'Z', 'A' - 1, '1', '9', '1' - 31, '-',
			'-', '-' - 27 };

	public boolean lex_(String inbuf, int[] outbuf, int[] op, boolean vbflag)
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int i;
		char j = 0;
		int k = 0, j1 = 0, j2, cp = 0;

		/* Function Body */

		for (i = 0; i < 40; ++i)
		{
			outbuf[i] = 0;
		}

		/* ASSUME LEX FAILS. */
		ret_val = false;

		/* OUTPUT PTR. */
		op[0] = -1;
		
		vars.prsvec_1.prscon--;
		int GOTO = 50;
		start: do
		{
			switch (GOTO)
			{
				case 50:
					/* ADV OUTPUT PTR. */
					op[0] += 2;
					/* CHAR PTR=0. */
					cp = 0;

					
				case 200:

					/* END OF INPUT? */
					if (vars.prsvec_1.prscon == inbuf.length())
					{
						GOTO = 1000;
						continue;
					}
					
					/* GET CHARACTER */
					j = inbuf.charAt(vars.prsvec_1.prscon);

					/* ADVANCE PTR. */
					vars.prsvec_1.prscon++;

					/* END OF COMMAND? */
					if (j == '.')
					{
						GOTO = 1000;
						continue;
					}
					/* END OF COMMAND? */
					if (j == ',')
					{
						GOTO = 1000;
						continue;
					}

					/* SPACE? */
					if (j == ' ')
					{
						GOTO = 6000;
						continue;
					}
					
					for (i = 1; i <= 9; i += 3)
					{
						/* SCH FOR CHAR. */
						if (j >= dlimit[i - 1] & j <= dlimit[i])
						{
							GOTO = 4000;
							continue start;
						}
						/* case 500: */
					}

					if (vbflag)
					{
						game.dsub.rspeak_(601);
					}
					/* GREEK TO ME, FAIL. */
					return ret_val;

				/* END OF INPUT, SEE IF PARTIAL WORD AVAILABLE. */
				case 1000:
					if (inbuf.length() == vars.prsvec_1.prscon)
					{
						vars.prsvec_1.prscon = 1;
					}
					else
						vars.prsvec_1.prscon++;
					/* FORCE PARSE RESTART. */
					if (cp == 0 & op[0] == 1)
					{
						return ret_val;
					}
					if (cp == 0)
					{
						op[0] += -2;
					}
					/* ANY LAST WORD? */
					ret_val = true;

					// DAVE //
					// shift array elements left 1 space //
					for (int n = 1; n < outbuf.length; n++)
						outbuf[n - 1] = outbuf[n];
					outbuf[outbuf.length - 1] = 0;

					return ret_val;

				/* LEGITIMATE CHARACTERS: LETTER, DIGIT, OR HYPHEN. */

				case 4000:
					j1 = j - dlimit[i + 1];
					if (cp >= 6)
					{
						GOTO = 200;
						continue;
					}
					/* IGNORE IF TOO MANY CHAR. */
					k = op[0] + cp / 3;
					/* COMPUTE WORD INDEX. */
					switch (cp % 3 + 1)
					{
						case 1:
							GOTO = 4100;
							continue;
						case 2:
							GOTO = 4200;
							continue;
						case 3:
							GOTO = 4300;
							continue;
					}
					/* BRANCH ON CHAR. */
				case 4100:
					j2 = j1 * 780;
					/* CHAR 1... *780 */
					outbuf[k] = outbuf[k] + j2 + j2;
					/* *1560 (40 ADDED BELOW). */
				case 4200:
					outbuf[k] += j1 * 39;
					/* *39 (1 ADDED BELOW). */
				case 4300:
					outbuf[k] += j1;
					/* *1. */
					++cp;
					GOTO = 200;
					continue;
				/* GET NEXT CHAR. */

				/* SPACE */
				case 6000:
					if (cp == 0)
					{
						GOTO = 200;
						continue;
					}
					/* ANY WORD YET? */
					GOTO = 50;
					continue;
				/* YES, ADV OP. */
			}
		} while (true);
	} /* lex_ */

}
