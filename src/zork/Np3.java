package zork;

import java.io.IOException;

public class Np3
{
	/* SYNMCH--	SYNTAX MATCHER */

	/*COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142*/
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	private Vars vars = null;
	private Dgame game = null;
	private Np np = null;	
	
	public Np3(Vars vars, Np np, Dgame game)
	{
		this.vars = vars;				
		this.np = np;
		this.game = game;
	}

	/* THIS ROUTINE DETAILS ON BIT 4 OF PRSFLG */
	public boolean synmch_()
	{
		/* Initialized data */

		/* THE FOLLOWING DATA STATEMENT WAS ORIGINALLY: */

		/* DATA R50MIN/1RA/ */

		final int r50min = 1600;

		/* System generated locals */
		int i__1;
		boolean ret_val;

		/* Local variables */
		int j;
		int[] newj = new int[1];
		int drive  = 0, limit = 0, qprep, sprep  = 0, dforce[] = new int[1];

		ret_val = false;
		j = np.parse.pv_1.act;
		/* !SET UP PTR TO SYNTAX. */
		drive = 0;
		/* !NO DEFAULT. */
		dforce[0] = 0;
		/* !NO FORCED DEFAULT. */
		qprep = vars.orphs_1.oflag & vars.orphs_1.oprep;

		int GOTO = 100;

		start: do
		{
			switch (GOTO)
			{

				case 100:
					j += 2;
					/* !FIND START OF SYNTAX. */
					if (np.parse.vvoc[j - 1] <= 0 || np.parse.vvoc[j - 1] >= r50min)
					{
						GOTO = 100;
						continue start;
					}
					limit = j + np.parse.vvoc[j - 1] + 1;
					/* !COMPUTE LIMIT. */
					++j;
					/* !ADVANCE TO NEXT. */

				case 200:
					unpack_(j, newj);
					/* !UNPACK SYNTAX. */
					
					sprep = np.parse.syntax_1.dobj & Parse.VPMASK;
					if (!syneql_(np.parse.pv_1.p1(), np.parse.pv_1.o1(), np.parse.syntax_1.dobj,
							np.parse.syntax_1.dfl1, np.parse.syntax_1.dfl2))
					{
						GOTO = 1000;
						continue start;
					}
					sprep = np.parse.syntax_1.iobj & Parse.VPMASK;
					if (syneql_(np.parse.pv_1.p2(), np.parse.pv_1.o2(), np.parse.syntax_1.iobj,
							np.parse.syntax_1.ifl1, np.parse.syntax_1.ifl2))
					{
						GOTO = 6000;
						continue start;
					}

					/* SYNTAX MATCH FAILS, TRY NEXT ONE. */

					if (np.parse.pv_1.o2() != 0)
					{
						GOTO = 3000;
						continue start;
					}
					else
					{
						GOTO = 500;
						continue start;
					}
					/* !IF O2=0, SET DFLT. */
				case 1000:
					if (np.parse.pv_1.o1() != 0)
					{
						GOTO = 3000;
						continue start;
					}
					else
					{
						GOTO = 500;
						continue start;
					}
					/* !IF O1=0, SET DFLT. */
				case 500:
					if (qprep == 0 || qprep == sprep)
					{
						dforce[0] = j;
					}
					/* !IF PREP MCH. */
					if ((np.parse.syntax_1.vflag & Parse.SDRIV) != 0)
					{
						drive = j;
					}
				case 3000:
					j = newj[0];
					if (j < limit)
					{
						GOTO = 200;
						continue start;
					}
					/* !MORE TO DO? */
					/* MATCH HAS FAILED. IF DEFAULT SYNTAX EXISTS, TRY TO SNARF */
					/* ORPHANS OR GWIMS, OR MAKE NEW ORPHANS. */

					if (drive == 0)
					{
						drive = dforce[0];
					}
					/* !NO DRIVER? USE FORCE. */
					if (drive == 0)
					{
						GOTO = 10000;
						continue start;
					}
					/* !ANY DRIVER? */
					unpack_(drive, dforce);
					/* !UNPACK DFLT SYNTAX. */

					/* TRY TO FILL DIRECT OBJECT SLOT IF THAT WAS THE PROBLEM. */

					if ((np.parse.syntax_1.vflag & Parse.SDIR) == 0 || np.parse.pv_1.o1() != 0)
					{
						GOTO = 4000;
						continue start;
					}

					/* FIRST TRY TO SNARF ORPHAN OBJECT. */

					np.parse.pv_1.o1(vars.orphs_1.oflag & vars.orphs_1.oslot);
					if (np.parse.pv_1.o1() == 0)
					{
						GOTO = 3500;
						continue start;
					}
					/* !ANY ORPHAN? */
					if (syneql_(np.parse.pv_1.p1(), np.parse.pv_1.o1(), np.parse.syntax_1.dobj,
							np.parse.syntax_1.dfl1, np.parse.syntax_1.dfl2))
					{
						GOTO = 4000;
						continue start;
					}

					/* ORPHAN FAILS, TRY GWIM. */

				case 3500:
					np.parse.pv_1.o1(
							gwim_(np.parse.syntax_1.dobj, np.parse.syntax_1.dfw1, np.parse.syntax_1.dfw2));
					/* !GET GWIM. */
					if (np.parse.pv_1.o1() > 0)
					{
						GOTO = 4000;
						continue start;
					}
					/* !TEST RESULT. */
					i__1 = np.parse.syntax_1.dobj & Parse.VPMASK;
					np.orphan_(-1, np.parse.pv_1.act, 0, i__1, 0);
					game.dsub.rspeak_(623);
					return ret_val;

				/* TRY TO FILL INDIRECT OBJECT SLOT IF THAT WAS THE PROBLEM. */
				case 4000:
					if ((np.parse.syntax_1.vflag & Parse.SIND) == 0 || np.parse.pv_1.o2() != 0)
					{
						GOTO = 6000;
						continue start;
					}
					np.parse.pv_1.o2(
							gwim_(np.parse.syntax_1.iobj, np.parse.syntax_1.ifw1, np.parse.syntax_1.ifw2));
					/* !GWIM. */
					if (np.parse.pv_1.o2() > 0)
					{
						GOTO = 6000;
						continue start;
					}
					if (np.parse.pv_1.o1() == 0)
					{
						np.parse.pv_1.o1(vars.orphs_1.oflag & vars.orphs_1.oslot);
					}
					i__1 = np.parse.syntax_1.dobj & Parse.VPMASK;
					np.orphan_(-1, np.parse.pv_1.act, np.parse.pv_1.o1(), i__1, 0);
					game.dsub.rspeak_(624);
					return ret_val;

				/* TOTAL CHOMP */
				case 10000:
					game.dsub.rspeak_(601);
					/* !CANT DO ANYTHING. */
					return ret_val;
				/* SYNMCH, PAGE 3 */

				/* NOW TRY TO TAKE INDIVIDUAL OBJECTS AND */
				/* IN GENERAL CLEAN UP THE PARSE VECTOR. */

				case 6000:
					if ((np.parse.syntax_1.vflag & Parse.SFLIP) == 0)
					{
						{
							GOTO = 5000;
							continue start;
						}
					}
					j = np.parse.pv_1.o1();
					/* !YES. */
					np.parse.pv_1.o1(np.parse.pv_1.o2());
					np.parse.pv_1.o2(j);

				case 5000:
					vars.prsvec_1.prsa = np.parse.syntax_1.vflag & Parse.SVMASK;
					vars.prsvec_1.prso = np.parse.pv_1.o1();
					if(vars.prsvec_1.prso == 151)
						System.out.print("");
					/* !GET DIR OBJ. */
					vars.prsvec_1.prsi = np.parse.pv_1.o2();
					/* !GET IND OBJ. */
					if (!takeit_(vars.prsvec_1.prso, np.parse.syntax_1.dobj))
					{
						return ret_val;
					}
					/* !TRY TAKE. */
					if (!takeit_(vars.prsvec_1.prsi, np.parse.syntax_1.iobj))
					{
						return ret_val;
					}
					/* !TRY TAKE. */
					ret_val = true;
					return ret_val;

			}
		} while (true);

	} /* synmch_ */

	/* UNPACK- UNPACK SYNTAX SPECIFICATION, ADV POINTER */
	private void unpack_(int oldj, int[] j)
	{
		/* Local variables */
		int i;

		for (i = 1; i <= 11; ++i)
		{
			/* !CLEAR SYNTAX. */
			np.parse.syntax_1.syn(i - 1, 0);
			/* case 10: */
		}

		int GOTO = 0;

		np.parse.syntax_1.vflag = np.parse.vvoc[oldj - 1];
		j[0] = oldj + 1;
		if ((np.parse.syntax_1.vflag & Parse.SDIR) == 0)
		{
			return;
		}
		np.parse.syntax_1.dfl1 = -1;
		/* !ASSUME STD. */
		np.parse.syntax_1.dfl2 = -1;
		if ((np.parse.syntax_1.vflag & Parse.SSTD) == 0)
		{
			GOTO = 100;
		}

		if (GOTO != 100)
		{
			np.parse.syntax_1.dfw1 = -1;
			/* !YES. */
			np.parse.syntax_1.dfw2 = -1;
			np.parse.syntax_1.dobj = Parse.VABIT + Parse.VRBIT + Parse.VFBIT;
			GOTO = 200;
		}

		start: do
		{
			switch (GOTO)
			{
				case 100:
					np.parse.syntax_1.dobj = np.parse.vvoc[j[0] - 1];
					/* !NOT STD. */
					np.parse.syntax_1.dfw1 = np.parse.vvoc[j[0]];
					np.parse.syntax_1.dfw2 = np.parse.vvoc[j[0] + 1];
					j[0] += 3;
					if ((np.parse.syntax_1.dobj & Parse.VEBIT) == 0)
					{
						{
							GOTO = 200;
							continue start;
						}
					}
					np.parse.syntax_1.dfl1 = np.parse.syntax_1.dfw1;
					/* !YES. */
					np.parse.syntax_1.dfl2 = np.parse.syntax_1.dfw2;

				case 200:
					if ((np.parse.syntax_1.vflag & Parse.SIND) == 0)
					{
						return;
					}
					np.parse.syntax_1.ifl1 = -1;
					/* !ASSUME STD. */
					np.parse.syntax_1.ifl2 = -1;
					np.parse.syntax_1.iobj = np.parse.vvoc[j[0] - 1];
					np.parse.syntax_1.ifw1 = np.parse.vvoc[j[0]];
					np.parse.syntax_1.ifw2 = np.parse.vvoc[j[0] + 1];
					j[0] += 3;
					if ((np.parse.syntax_1.iobj & Parse.VEBIT) == 0)
					{
						return;
					}
					np.parse.syntax_1.ifl1 = np.parse.syntax_1.ifw1;
					/* !YES. */
					np.parse.syntax_1.ifl2 = np.parse.syntax_1.ifw2;
//		throw new RuntimeException("Np3.unpack_ not impl");

			}
		} while (true);

	} /* unpack_ */

	/* SYNEQL- TEST FOR SYNTAX EQUALITY */
	private boolean syneql_(int prep, int obj, int sprep, int sfl1, int sfl2)
	{
		/* System generated locals */
		boolean ret_val;

		if (obj != 0)
		{
			/* !ANY OBJECT? */
			ret_val = prep == (sprep & Parse.VPMASK) && (sfl1 & vars.objcts_1.oflag1[obj - 1]
					| sfl2 & vars.objcts_1.oflag2[obj - 1]) != 0;
			return ret_val;
		}

		ret_val = prep == 0 && sfl1 == 0 && sfl2 == 0;
		return ret_val;

	} /* syneql_ */

	/* TAKEIT-	PARSER BASED TAKE OF OBJECT */
	private boolean takeit_(int obj, int sflag)
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int x = 0;
		int odo2 = 0;

		ret_val = false;

		int GOTO = 500;
		/* !ASSUME LOSES. */
		if (obj == 0 || obj > vars.star_1.strbit)
		{
			GOTO = 4000;
		}
		if (GOTO != 4000)
		{
			/* !NULL/STARS WIN. */
			odo2 = vars.objcts_1.odesc2[obj - 1];
			/* !GET DESC. */
			x = vars.objcts_1.ocan[obj - 1];
			/* !GET CONTAINER. */
			if (x == 0 || (sflag & Parse.VFBIT) == 0)
			{
				GOTO = 500;				
			}
			if(GOTO != 500)
			{
				if ((vars.objcts_1.oflag2[x - 1] & Vars.OPENBT) != 0)
				{
					GOTO = 500;
				}
			}
			if (GOTO != 500)
			{
				game.dsub.rspsub_(566, odo2);
				/* !CANT REACH. */
				return ret_val;
			}
		}
		loop: do
		{
			switch (GOTO)
			{

				case 500:
					if ((sflag & Parse.VRBIT) == 0)
					{
						GOTO = 1000;
						continue loop;
					}
					if ((sflag & Parse.VTBIT) == 0)
					{
						GOTO = 2000;
						continue loop;
					}

					/* SHOULD BE IN ROOM (VRBIT NE 0) AND CAN BE TAKEN (VTBIT NE 0) */

					if (np.np2.schlst_(0, 0, vars.play_1.here, 0, 0, obj) <= 0)
					{
						GOTO = 4000;
						continue loop;
					}
					/* !IF NOT, OK. */

					/* ITS IN THE ROOM AND CAN BE TAKEN. */

					if ((vars.objcts_1.oflag1[obj - 1] & Vars.TAKEBT) != 0
							&& (vars.objcts_1.oflag2[obj - 1] & Vars.TRYBT) == 0)
					{
						GOTO = 3000;
						continue loop;
					}

					/* NOT TAKEABLE. IF WE CARE, FAIL. */

					if ((sflag & Parse.VCBIT) == 0)
					{
						GOTO = 4000;
						continue loop;
					}
					game.dsub.rspsub_(445, odo2);
					return ret_val;

				/* 1000-- IT SHOULD NOT BE IN THE ROOM. */
				/* 2000-- IT CANT BE TAKEN. */

				case 2000:
					if ((sflag & Parse.VCBIT) == 0)
					{
						GOTO = 4000;
						continue loop;
					}
				case 1000:
					if (np.np2.schlst_(0, 0, vars.play_1.here, 0, 0, obj) <= 0)
					{
						GOTO = 4000;
						continue loop;
					}
					game.dsub.rspsub_(665, odo2);
					return ret_val;

				/* OBJECT IS IN THE ROOM, CAN BE TAKEN BY THE PARSER, */
				/* AND IS TAKEABLE IN GENERAL. IT IS NOT A STAR. */
				/* TAKING IT SHOULD NOT HAVE SIDE AFFECTS. */
				/* IF IT IS INSIDE SOMETHING, THE CONTAINER IS OPEN. */
				/* THE FOLLOWING CODE IS LIFTED FROM SUBROUTINE TAKE. */

				case 3000:
					if (obj != vars.advs_1.avehic[vars.play_1.winner - 1])
					{
						GOTO = 3500;
						continue loop;
					}
					/* !TAKE VEHICLE? */
					game.dsub.rspeak_(672);
					return ret_val;

				case 3500:
					if (x != 0 && vars.objcts_1.oadv[x - 1] == vars.play_1.winner
							|| game.dso5.weight_(0, obj, vars.play_1.winner)
									+ vars.objcts_1.osize[obj - 1] <= vars.state_1.mxload)
					{
						GOTO = 3700;
						continue loop;
					}
					game.dsub.rspeak_(558);
					/* !TOO BIG. */
					return ret_val;

				case 3700:
					game.dsub.newsta_(obj, 559, 0, 0, vars.play_1.winner);
					/* !DO TAKE. */
					vars.objcts_1.oflag2[obj - 1] |= Vars.TCHBT;
					game.dso2.scrupd_(vars.objcts_1.ofval[obj - 1]);
					vars.objcts_1.ofval[obj - 1] = 0;

				case 4000:
					ret_val = true;
					/* !SUCCESS. */
					return ret_val;
			}
		} while (true);

	} /* takeit_ */

	/* GWIM- GET WHAT I MEAN IN AMBIGOUS SITUATIONS */
	private int gwim_(int sflag, int sfw1, int sfw2)
	{
		/* System generated locals */
		int ret_val;

		/* Local variables */
		int av;
		int nobj, robj = 0;
		boolean nocare;
		int GOTO = 50;

		/* GWIM, PAGE 2 */

		ret_val = -1;
		/* !ASSUME LOSE. */
		av = vars.advs_1.avehic[vars.play_1.winner - 1];
		nobj = 0;
		nocare = (sflag & Parse.VCBIT) == 0;

		/* FIRST SEARCH ADVENTURER */

		if ((sflag & Parse.VABIT) != 0)
		{
			nobj = game.dso3.fwim_(sfw1, sfw2, 0, 0, vars.play_1.winner, nocare);
		}
		if ((sflag & Parse.VRBIT) != 0)
		{
			GOTO = 100;			
		}

		loop2: do
		{
			switch (GOTO)
			{
				case 50:
					ret_val = nobj;
					return ret_val;

				/* ALSO SEARCH ROOM */

				case 100:
					robj = game.dso3.fwim_(sfw1, sfw2, vars.play_1.here, 0, 0, nocare);
					if (robj < 0)
					{
						GOTO = 500;
						continue loop2;
					}
					else if (robj == 0)
					{
						GOTO = 50;
						continue loop2;
					}
					else
					{
						GOTO = 200;
						continue loop2;
					}
					/* !TEST RESULT. */

					/* ROBJ > 0 */

				case 200:
					if (av == 0 || robj == av
							|| (vars.objcts_1.oflag2[robj - 1] & Vars.FINDBT) != 0)
					{
						GOTO = 300;
						continue loop2;
					}
					if (vars.objcts_1.ocan[robj - 1] != av)
					{
						GOTO = 50;
						continue loop2;
					}
					/* !UNREACHABLE? TRY NOBJ */
				case 300:
					if (nobj != 0)
					{
						return ret_val;
					}
					/* !IF AMBIGUOUS, RETURN. */
					if (!takeit_(robj, sflag))
					{
						return ret_val;
					}
					/* !IF UNTAKEABLE, RETURN */
					ret_val = robj;
				case 500:
					return ret_val;
			}
		} while (true);
//		throw new RuntimeException("Np3.gwim_ not impl.");
	} /* gwim_ */

}
