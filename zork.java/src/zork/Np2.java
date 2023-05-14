package zork;

import java.io.IOException;

public class Np2
{
	/* GETOBJ-- FIND OBJ DESCRIBED BY ADJ, NAME PAIR */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	private Vars vars = null;
	Np np = null;
	Dgame game = null;

	public Np2(Vars vars, Np np, Dgame game)
	{
		this.vars = vars;
		this.np = np;
		this.game = game;
	}

	/* THIS ROUTINE DETAILS ON BIT 3 OF PRSFLG */
	int getobj_(int oidx, int aidx, int spcobj) throws IOException
	{
		/* System generated locals */
		int ret_val = 0, i__1;

		/* Local variables */
		int i, av;
		int obj;
		int nobj = 0;
		boolean chomp;

		/* GETOBJ, PAGE 2 */
		int GOTO = 100;

		chomp = false;
		av = vars.advs_1.avehic[vars.play_1.winner - 1];
		obj = 0;
		/* !ASSUME DARK. */
		if (!game.dso5.lit_(vars.play_1.here))
		{
			GOTO = 200;
		}
		/* !LIT? */

		if (GOTO != 200)
		{
			obj = schlst_(oidx, aidx, vars.play_1.here, 0, 0, spcobj);
			/* !SEARCH ROOM. */
			if (obj < 0)
			{
				GOTO = 1000;
			}
			else if (obj == 0)
			{
				GOTO = 200;
			}
			else
			{
				GOTO = 100;
			}
		}

		loop: do
		{
			switch (GOTO)
			{
				/* !TEST RESULT. */
				case 100:
					if (av == 0 || av == obj || (vars.objcts_1.oflag2[obj - 1] & Vars.FINDBT) != 0)
					{
						GOTO = 200;
						continue loop;
					}
					if (vars.objcts_1.ocan[obj - 1] == av)
					{
						GOTO = 200;
						continue loop;
					}
					/* !TEST IF REACHABLE. */
					chomp = true;
					/* !PROBABLY NOT. */

				case 200:
					if (av == 0)
					{
						GOTO = 400;
						continue loop;
					}
					/* !IN VEHICLE? */
					nobj = schlst_(oidx, aidx, 0, av, 0, spcobj);
					/* !SEARCH VEHICLE. */
					if (nobj < 0)
					{
						GOTO = 1100;
						continue loop;
					}
					else if (nobj == 0)
					{
						GOTO = 400;
						continue loop;
					}
					else
					{
						GOTO = 300;
						continue loop;
					}
					/* !TEST RESULT. */
				case 300:
					chomp = false;
					/* !REACHABLE. */
					if (obj == nobj)
					{
						GOTO = 400;
						continue loop;
					}
					/* !SAME AS BEFORE? */
					if (obj != 0)
					{
						nobj = -nobj;
					}
					/* !AMB RESULT? */
					obj = nobj;

				case 400:
					nobj = schlst_(oidx, aidx, 0, 0, vars.play_1.winner, spcobj);
					/* !SEARCH ADVENTURER. */
					if (nobj < 0)
					{
						GOTO = 1100;
						continue loop;
					}
					else if (nobj == 0)
					{
						GOTO = 600;
						continue loop;
					}
					else
					{
						GOTO = 500;
						continue loop;
					}
					/* !TEST RESULT */
				case 500:
					if (obj != 0)
					{
						nobj = -nobj;
					}
					/* !AMB RESULT? */
				case 1100:
					obj = nobj;
					/* !RETURN NEW OBJECT. */
				case 600:
					if (chomp)
					{
						obj = -10000;
					}
					/* !UNREACHABLE. */
				case 1000:
					ret_val = obj;

					if (ret_val != 0)
					{
						GOTO = 1500;
						continue loop;
					}
					/* !GOT SOMETHING? */
					i__1 = vars.objcts_1.olnt;
					for (i = vars.star_1.strbit + 1; i <= i__1; ++i)
					{
						/* !NO, SEARCH GLOBALS. */
						if (!thisit_(oidx, aidx, i, spcobj))
						{
							continue;
						}
						if (!game.dso6.ghere_(i, vars.play_1.here))
						{
							continue;
						}
						/* !CAN IT BE HERE? */
						if (ret_val != 0)
						{
							ret_val = -i;
						}
						/* !AMB MATCH? */
						if (ret_val == 0)
						{
							ret_val = i;
						}

					}

				case 1500:
					/* !END OF SEARCH. */
					return ret_val;
			}
		} while (true);
	} /* getobj_ */

	/* SCHLST--	SEARCH FOR OBJECT */
	int schlst_(
	int oidx,
	int aidx,
	int rm,
	int cn,
	int ad,
	int spcobj)
	{
	    /* System generated locals */
	    int ret_val, i__1, i__2;

	    /* Local variables */
	    int i, j, x;

	    ret_val = 0;
	    /* 						!NO RESULT. */
	    i__1 = vars.objcts_1.olnt;
	    for (i = 1; i <= i__1; ++i) 
	    {
	    	/* 						!SEARCH OBJECTS. */
	    	if ((vars.objcts_1.oflag1[i - 1] & Vars.VISIBT) == 0 || ((rm == 0 || !
	    			game.dsub.qhere_(i, rm)) && (cn == 0 || vars.objcts_1.ocan[i - 1] != cn) 
	    			&& (ad == 0 || vars.objcts_1.oadv[i - 1] != ad))) 
	    	{
//	    		goto L1000;
	    		continue;
	    	}
	    	boolean skip_to_200 = false;
	    	if (! thisit_(oidx, aidx, i, spcobj)) 
	    	{
//	    		goto L200;
	    		skip_to_200 = true;
	    	}
	    	if(!skip_to_200)
	    	{
		    	if (ret_val != 0) 
		    	{
	//	    		goto L2000;
		    	    ret_val = -ret_val;
		    		/* 						!AMB RETURN. */
		    		    return ret_val;
		    	}
		    	/* 						!GOT ONE ALREADY? */
		    	ret_val = i;
		    	/* 						!NO. */
	    	}
	    	/* IF OPEN OR TRANSPARENT, SEARCH THE OBJECT ITSELF. */

//	L200:
			if ((vars.objcts_1.oflag1[i - 1] & Vars.TRANBT) == 0 && (
			vars.objcts_1.oflag2[i - 1] & Vars.OPENBT) == 0) 
			{
//				goto L1000;
				continue;
			}

			/* SEARCH IS CONDUCTED IN REVERSE.  ALL OBJECTS ARE CHECKED TO */
			/* SEE IF THEY ARE AT SOME LEVEL OF CONTAINMENT INSIDE OBJECT 'I'. */
			/* IF THEY ARE AT LEVEL 1, OR IF ALL LINKS IN THE CONTAINMENT */
			/* CHAIN ARE OPEN, VISIBLE, AND HAVE SEARCHME SET, THEY CAN QUALIFY */
		
			/* AS A POTENTIAL MATCH. */

			i__2 = vars.objcts_1.olnt;
			inner_for: for (j = 1; j <= i__2; ++j) 
			{
				/* 						!SEARCH OBJECTS. */
				if ((vars.objcts_1.oflag1[j - 1] & Vars.VISIBT) == 0 || ! thisit_(
						oidx, aidx, j, spcobj)) 
				{
//					goto L500;
					continue inner_for;
				}				
				x = vars.objcts_1.ocan[j - 1];
				/* 						!GET CONTAINER. */
//	L300:
				do
				{
					boolean skip_to_400 = false;
			    	if (x == i) 
			    	{	
	//		    		goto L400;
			    		skip_to_400 = true;
			    	}
			    	
			    	if(! skip_to_400)
			    	{
					/* 						!INSIDE TARGET? */
				    	if (x == 0) 
				    	{
		//		    		goto L500;
				    		continue inner_for;
				    	}
				    	/* 						!INSIDE ANYTHING? */
				    	if ((vars.objcts_1.oflag1[x - 1] & Vars.VISIBT) == 0 || ((
				    			vars.objcts_1.oflag1[x - 1] & Vars.TRANBT) == 0 && (
				    			vars.objcts_1.oflag2[x - 1] & Vars.OPENBT) == 0) || (
				    			vars.objcts_1.oflag2[x - 1] & Vars.SCHBT) == 0) 
				    	{
		//		    		goto L500;
				    		continue inner_for;
				    	}
				    	x = vars.objcts_1.ocan[x - 1];
				    	/* 						!GO ANOTHER LEVEL. */
	//			    	goto L300;
				    	continue;
		    		}
		    		break;
				}while(true);
		    	

//	L400:
		    	if (ret_val != 0) 
		    	{
//		    		goto L2000;
		    	    ret_val = -ret_val;
		    		/* 						!AMB RETURN. */
		    		    return ret_val;
		    	}
				/* 						!ALREADY GOT ONE? */
		    	ret_val = j;
		    	/* 						!NO. */
//	L500:
			}
//	L1000:
	    }
	    return ret_val;

//	L2000:
//	    ret_val = -ret_val;
	/* 						!AMB RETURN. */
//	    return ret_val;

	} /* schlst_ */

	/* THISIT-- VALIDATE OBJECT VS DESCRIPTION */
	private boolean thisit_(int oidx, int aidx, int obj, int spcobj)
	{
		/* Initialized data */

		/* THE FOLLOWING DATA STATEMENT USED RADIX-50 NOTATION (R50MIN/1RA/) */

		/* IN RADIX-50 NOTATION, AN "A" IN THE FIRST POSITION IS */
		/* ENCODED AS 1*40*40 = 1600. */

		final int r50min = 1600;

		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int i;

		ret_val = false;
		/* !ASSUME NO MATCH. */
		if (spcobj != 0 && obj == spcobj)
		{
			ret_val = true;
			return ret_val;
		}

		/* CHECK FOR OBJECT NAMES */

		i = oidx + 1;
		int GOTO = 100;
		loop2: do
		{
			switch (GOTO)
			{
				case 100:
					++i;
					if (np.parse.ovoc[i - 1] <= 0 || np.parse.ovoc[i - 1] >= r50min)
					{
						return ret_val;
					}
					/* !IF DONE, LOSE. */
					if (np.parse.ovoc[i - 1] != obj)
					{
						GOTO = 100;
						continue loop2;
					}
					/* !IF FAIL, CONT. */

					if (aidx == 0)
					{
						ret_val = true;
						return ret_val;
					}
					/* !ANY ADJ? */
					i = aidx + 1;
				case 200:
					++i;
					if (np.parse.avoc[i - 1] <= 0 || np.parse.avoc[i - 1] >= r50min)
					{
						return ret_val;
					}
					/* !IF DONE, LOSE. */
					if (np.parse.avoc[i - 1] != obj)
					{
						GOTO = 200;
						continue loop2;
					}
					/* !IF FAIL, CONT. */

				case 500:
					ret_val = true;
					return ret_val;

			}
		} while (true);
	} /* thisit_ */

}
