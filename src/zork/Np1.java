package zork;

public class Np1 implements Actions
{
	/* SPARSE- START OF PARSE */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */

	private Vars vars = null;
	private Np np = null;
	Dgame game = null;

	public Np1(Vars vars, Np np, Dgame game)
	{
		this.vars = vars;
		this.np = np;
		this.game = game;
	}

	int sparse_(int[] lbuf, int[] llnt, boolean vbflag)
	{
		/* Initialized data */

		/* DATA R50MIN/1RA/,R50WAL/3RWAL/ */
		final int r50min = 1600;
		final int r50wal = 36852;

		/* System generated locals */
		int ret_val, i__1, i__2;

		/* Local variables */
		int i, j, adj;
		int obj = 0;
		int prep, pptr, lbuf1, lbuf2;
		int buzlnt, prplnt, dirlnt;

		/* Parameter adjustments */
//	    --lbuf;
		// TODO: do i need to fix this??

		/* Function Body */

		/* SET UP FOR PARSING */

		ret_val = -1;
		/* ASSUME PARSE FAILS. */
		adj = 0;
		/* CLEAR PARTS HOLDERS. */
		np.parse.pv_1.act = 0;
		prep = 0;
		pptr = 0;
		np.parse.pv_1.o1(0);
		np.parse.pv_1.o2(0);
		np.parse.pv_1.p1(0);
		np.parse.pv_1.p2(0);

		buzlnt = 20;
		prplnt = 45;
		dirlnt = 75;

		/* NOW LOOP OVER INPUT BUFFER OF LEXICAL TOKENS. */

		int GOTO = 125;

		i__1 = llnt[0];
//		for (i = 1; i <= i__1; i += 2)
		loop: for (i = 0; i < i__1; i += 2)
		{
			GOTO = 125;
			/* TWO WORDS/TOKEN. */
			lbuf1 = lbuf[i];
			/* GET CURRENT TOKEN. */
			lbuf2 = lbuf[i + 1];
			if (lbuf1 == 0)
			{
				GOTO = 1500;
				break;
			}
			/* END OF BUFFER? */

			/* CHECK FOR BUZZ WORD */

			i__2 = buzlnt;
			for (j = 1; j <= i__2; j += 2)
			{
				if (lbuf1 == np.parse.buzvoc_1.bvoc[j - 1] && lbuf2 == np.parse.buzvoc_1.bvoc[j])
				{
					continue loop;
				}
			}

			/* CHECK FOR ACTION OR DIRECTION */

			if (GOTO != 1000)
			{
				if (np.parse.pv_1.act != 0)
				{
					GOTO = 75;
				}
			}

			/* GOT ACTION ALREADY? */
			if (GOTO == 125)
				j = 1;
			/* CHECK FOR ACTION. */
			in_do_while: do
			{
				switch (GOTO)
				{
				case 125:
					if (lbuf1 == np.parse.vvoc[j - 1] && lbuf2 == np.parse.vvoc[j])
					{
						GOTO = 3000;
						continue in_do_while;
					}

					j += 2;
					/* ADV TO NEXT SYNONYM. */
					if (!(np.parse.vvoc[j - 1] > 0 && np.parse.vvoc[j - 1] < r50min))
					{
						GOTO = 125;
						continue in_do_while;
					}
					/* ANOTHER VERB? */
					j = j + np.parse.vvoc[j - 1] + 1;
					/* NO, ADVANCE OVER SYNTAX. */
					if (np.parse.vvoc[j - 1] != -1)
					{
						GOTO = 125;
						continue in_do_while;
					}

					/* TABLE DONE? */
				case 75:
					if (np.parse.pv_1.act != 0 && (np.parse.vvoc[np.parse.pv_1.act - 1] != r50wal || prep != 0))
					{
						GOTO = 200;
						continue in_do_while;

					}
					i__2 = dirlnt;
					for (j = 1; j <= i__2; j += 3)
					{
						/* THEN CHK FOR DIR. */
						if (lbuf1 == np.parse.dirvoc_1.dvoc[j - 1] && lbuf2 == np.parse.dirvoc_1.dvoc[j])
						{
							GOTO = 2000;
							continue in_do_while;
						}
						/* case 100: */
					}

					/* NOT AN ACTION, CHECK FOR PREPOSITION, ADJECTIVE, OR OBJECT. */

				case 200:
					i__2 = prplnt;
					for (j = 1; j <= i__2; j += 3)
					{
						/* LOOK FOR PREPOSITION. */
						if (lbuf1 == np.parse.prpvoc_1.pvoc[j - 1] && lbuf2 == np.parse.prpvoc_1.pvoc[j])
						{
							GOTO = 4000;
							continue in_do_while;
						}

					}
					j = 1;

					/* LOOK FOR ADJECTIVE. */
				case 300:
					if (lbuf1 == np.parse.avoc[j - 1] && lbuf2 == np.parse.avoc[j])
					{
						GOTO = 5000;
						continue in_do_while;
					}
					++j;
				case 325:
					++j;
					/* ADVANCE TO NEXT ENTRY. */
					if (np.parse.avoc[j - 1] > 0 && np.parse.avoc[j - 1] < r50min)
					{
						GOTO = 325;
						continue in_do_while;
					}
					/* A RADIX 50 CONSTANT? */
					if (np.parse.avoc[j - 1] != -1)
					{
						GOTO = 300;
						continue in_do_while;
					}
					/* POSSIBLY, END TABLE? */

					j = 1;
					/* LOOK FOR OBJECT. */
				case 450:
					if (lbuf1 == np.parse.ovoc[j - 1] && lbuf2 == np.parse.ovoc[j])
					{
						GOTO = 600;
						continue in_do_while;
					}
					++j;
				case 500:
					++j;
					if (np.parse.ovoc[j - 1] > 0 && np.parse.ovoc[j - 1] < r50min)
					{
						GOTO = 500;
						continue in_do_while;
					}
					if (np.parse.ovoc[j - 1] != -1)
					{
						GOTO = 450;
						continue in_do_while;
					}

					/* NOT RECOGNIZABLE */

					if (vbflag)
					{
						game.dsub.rspeak_(601);
					}
					return ret_val;
				/* SPARSE, PAGE 9 */

				/* OBJECT PROCESSING (CONTINUATION OF DO LOOP ON PREV PAGE) */

				case 600:
					obj = np.np2.getobj_(j, adj, 0);
					/* IDENTIFY OBJECT. */
					if (obj <= 0)
					{
						GOTO = 6000;
						continue in_do_while;
					}
					/* IF LE, COULDNT. */
					if (obj != vars.oindex_1.itobj)
					{
						GOTO = 650;
						continue in_do_while;
					}
					/* "IT"? */
					obj = np.np2.getobj_(0, 0, vars.last_1.lastit);
					/* FIND LAST. */
					if (obj <= 0)
					{
						GOTO = 6000;
						continue in_do_while;
					}
					/* IF LE, COULDNT. */

				case 650:
					if (prep == 9)
					{
						GOTO = 8000;
						continue in_do_while;
					}
					/* "OF" OBJ? */
					if (pptr == 2)
					{
						GOTO = 7000;
						continue in_do_while;
					}
					/* TOO MANY OBJS? */
					++pptr;
					np.parse.pv_1.objvec[pptr - 1] = obj;
					/* STUFF INTO VECTOR. */
					np.parse.pv_1.prpvec[pptr - 1] = prep;
				case 700:
					prep = 0;
					adj = 0;
					/*
					 * Go to end of do loop (moved "1000 CONTINUE" to end of module, to av oid
					 */
					/* complaints about people jumping back into the doloop.) */
					continue loop;

				/* SPECIAL PARSE PROCESSORS */

				/* 2000-- DIRECTION */
				case 2000:
					vars.prsvec_1.action = WALK;
					vars.prsvec_1.direct_object = np.parse.dirvoc_1.dvoc[j + 1];
					ret_val = 1;
					return ret_val;

				/* 3000-- ACTION */
				case 3000:
					np.parse.pv_1.act = j;
					vars.orphs_1.oact = 0;
					continue loop;

				/* 4000-- PREPOSITION */
				case 4000:
					if (prep != 0)
					{
						GOTO = 4500;
						continue in_do_while;
					}
					prep = np.parse.prpvoc_1.pvoc[j + 1];
					adj = 0;
					continue loop;

				case 4500:
					if (vbflag)
					{
						game.dsub.rspeak_(616);
					}
					return ret_val;

				/* 5000-- ADJECTIVE */
				case 5000:
					adj = j;
					j = vars.orphs_1.oname & vars.orphs_1.oflag;
					if (j != 0 && i >= llnt[0])
					{
						GOTO = 600;
						continue in_do_while;
					}
					continue loop;

				/* 6000-- UNIDENTIFIABLE OBJECT (INDEX INTO OVOC IS J) */
				case 6000:
					if (obj < 0)
					{
						GOTO = 6100;
						continue in_do_while;
					}
					j = 579;
					if (game.dso5.lit_(vars.play_1.here))
					{
						j = 618;
					}
					if (vbflag)
					{
						game.dsub.rspeak_(j);
					}
					return ret_val;

				case 6100:
					if (obj != -10000)
					{
						GOTO = 6200;
						continue in_do_while;
					}
					if (vbflag)
					{
						game.dsub.rspsub_(620, vars.objcts_1.odesc2[vars.advs_1.avehic[vars.play_1.winner - 1] - 1]);
					}
					return ret_val;

				case 6200:
					if (vbflag)
					{
						game.dsub.rspeak_(619);
					}
					if (np.parse.pv_1.act == 0)
					{
						np.parse.pv_1.act = vars.orphs_1.oflag & vars.orphs_1.oact;
					}
					np.orphan_(-1, np.parse.pv_1.act, np.parse.pv_1.o1(), prep, j);
					return ret_val;

				/* 7000-- TOO MANY OBJECTS. */

				case 7000:
					if (vbflag)
					{
						game.dsub.rspeak_(617);
					}
					return ret_val;

				/* 8000-- RANDOMNESS FOR "OF" WORDS */

				case 8000:
					if (np.parse.pv_1.objvec[pptr - 1] == obj)
					{
						GOTO = 700;
						continue in_do_while;
					}
					if (vbflag)
					{
						game.dsub.rspeak_(601);
					}
					return ret_val;

				/* End of do-loop. */
				} // end switch;

			} while (true);
		}

		GOTO = 1500;
		/* AT LAST. */

		/* NOW SOME MISC CLEANUP -- We fell out of the do-loop */
		loop2: do
		{
			switch (GOTO)
			{
			case 1500:
				if (np.parse.pv_1.act == 0)
				{
					np.parse.pv_1.act = vars.orphs_1.oflag & vars.orphs_1.oact;
				}
				if (np.parse.pv_1.act == 0)
				{
					GOTO = 9000;
					continue loop2;
				}
				/* IF STILL NONE, PUNT. */
				if (adj != 0)
				{
					{
						GOTO = 10000;
						continue loop2;
					}
				}
				/* IF DANGLING ADJ, PUNT. */

				if (vars.orphs_1.oflag != 0 && vars.orphs_1.oprep != 0 && prep == 0 && np.parse.pv_1.o1() != 0
						&& np.parse.pv_1.o2() == 0 && np.parse.pv_1.act == vars.orphs_1.oact)
				{
					{
						GOTO = 11000;
						continue loop2;
					}
				}

				ret_val = 0;
				/* PARSE SUCCEEDS. */
				if (prep == 0)
				{
					{
						GOTO = 1750;
						continue loop2;
					}
				}
				/* IF DANGLING PREP, */
				if (pptr == 0 || np.parse.pv_1.prpvec[pptr - 1] != 0)
				{
					{
						GOTO = 12000;
						continue loop2;
					}
				}
				np.parse.pv_1.prpvec[pptr - 1] = prep;

				/* CVT TO 'PICK UP FROB'. */

				/* 1750-- RETURN A RESULT */
			case 1750:
				/* WIN. */
				return ret_val;
			/* LOSE. */

			/* 9000-- NO ACTION, PUNT */
			case 9000:
				if (np.parse.pv_1.o1() == 0)
				{
					GOTO = 10000;
					continue loop2;
				}
				/* ANY DIRECT OBJECT? */
				if (vbflag)
				{
					game.dsub.rspsub_(621, vars.objcts_1.odesc2[np.parse.pv_1.o1() - 1]);
				}
				/* WHAT TO DO? */
				np.orphan_(-1, 0, np.parse.pv_1.o1(), 0, 0);
				return ret_val;

			/* 10000-- TOTAL CHOMP */
			case 10000:
				if (vbflag)
				{
					game.dsub.rspeak_(622);
				}
				/* HUH? */
				return ret_val;

			/* 11000-- ORPHAN PREPOSITION. CONDITIONS ARE */
			/* O1.NE.0, O2=0, PREP=0, ACT=OACT */
			case 11000:
				if (vars.orphs_1.oslot != 0)
				{
					GOTO = 11500;
					continue loop2;
				}
				/* ORPHAN OBJECT? */
				np.parse.pv_1.p1(vars.orphs_1.oprep);
				/* NO, JUST USE PREP. */
				GOTO = 1750;
				continue loop2;

			case 11500:
				np.parse.pv_1.o2(np.parse.pv_1.o1());
				/* YES, USE AS DIRECT OBJ. */
				np.parse.pv_1.p2(vars.orphs_1.oprep);
				np.parse.pv_1.o1(vars.orphs_1.oslot);
				np.parse.pv_1.p1(0);
				GOTO = 1750;
				continue loop2;

			/* 12000-- TRUE HANGING PREPOSITION. */
			/* ORPHAN FOR LATER. */
			case 12000:
				np.orphan_(-1, np.parse.pv_1.act, 0, prep, 0);
				/* ORPHAN PREP. */
				GOTO = 1750;
				continue loop2;
			}
		} while (true);
	} /* snp.parse_ */

}
