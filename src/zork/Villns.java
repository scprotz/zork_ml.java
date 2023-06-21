package zork;

public class Villns implements Constants
{
	/* TROLLP- TROLL FUNCTION */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;
	Dgame game = null;

	public Villns(Vars vars, Dgame game)
	{
		this.vars = vars;
		this.game = game;
	}

	boolean trollp_(int arg)
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int i;

		ret_val = true;
		/* ASSUME WINS. */
		if (vars.prsvec_1.action != FIGHT)
		{
			if (vars.prsvec_1.action != VILLAIN_DIED)
			{
				if (vars.prsvec_1.action != VILLAIN_LEFT)
				{
					if (vars.prsvec_1.action != VILLAIN_ENTERED)
					{
						if (vars.prsvec_1.action != VILLAIN_QUIT_FIGHTING)
						{
							if (vars.prsvec_1.action != MOVE
									&& vars.prsvec_1.action != TAKE
									&& vars.prsvec_1.action != MUNG
									&& vars.prsvec_1.action != THROW
									&& vars.prsvec_1.action != GIVE)
							{
								if (!vars.findex_1.trollf
										|| vars.prsvec_1.action != HELLO)
								{
									ret_val = false;
									/* COULDNT HANDLE IT. */
									return ret_val;
								}
								game.dsub.rspeak_(366);
								/* TROLL OUT. */
								return ret_val;
							}
							if (vars.objcts_1.ocapac[vars.oindex_1.troll - 1] < 0)
							{

								/* TROLL OUT? */
								vars.objcts_1.ocapac[vars.oindex_1.troll
										- 1] = -vars.objcts_1.ocapac[vars.oindex_1.troll - 1];
								/* YES, WAKE HIM. */
								vars.objcts_1.oflag1[vars.oindex_1.axe - 1] |= Vars.VISIBT;
								vars.findex_1.trollf = false;
								vars.objcts_1.odesc1[vars.oindex_1.troll - 1] = 436;
								game.dsub.rspeak_(437);
							}

							if (vars.prsvec_1.action != TAKE
									&& vars.prsvec_1.action != MOVE)
							{
								if (vars.prsvec_1.action != MUNG)
								{
									if (vars.prsvec_1.direct_object == 0)
									{
										ret_val = false;
										/* COULDNT HANDLE IT. */
										return ret_val;
									}
									/* NO OBJECT? */
									i = 440;
									/* ASSUME THROW. */
									if (vars.prsvec_1.action == GIVE)
									{
										i = 441;
									}
									/* GIVE? */
									game.dsub.rspsub_(i,
											vars.objcts_1.odesc2[vars.prsvec_1.direct_object - 1]);
									/* TROLL TAKES. */
									if (vars.prsvec_1.direct_object == vars.oindex_1.knife)
									{
										game.dsub.rspeak_(443);
										/* KNIFE, THROWS IT BACK */
										vars.objcts_1.oflag2[vars.oindex_1.troll
												- 1] |= Vars.FITEBT;
										return ret_val;
									}
									/* OBJ KNIFE? */
									game.dsub.newsta_(vars.prsvec_1.direct_object, 442, 0, 0, 0);
									/* NO, EATS IT. */
									return ret_val;
								}
								/* MUNG? */
								game.dsub.rspeak_(439);
								/* JOKE. */
								return ret_val;
							}
							game.dsub.rspeak_(438);
							/* JOKE. */
							return ret_val;
						}
						/* FIRST ENCOUNTER? */
						ret_val = game.dsub.prob_(33, 66);
						/* 33% TRUE UNLESS BADLK. */
						return ret_val;
					}
					/* WAKE UP? */
					vars.findex_1.trollf = false;
					/* FORBID EXITS. */
					vars.objcts_1.oflag1[vars.oindex_1.axe - 1] |= Vars.VISIBT;
					vars.objcts_1.odesc1[vars.oindex_1.troll - 1] = 436;
					/* TROLL IN. */
					if (game.dsub.qhere_(vars.oindex_1.troll, vars.play_1.here))
					{
						game.dsub.rspeak_(437);
					}
					return ret_val;
				}
				/* OUT? */
				vars.findex_1.trollf = true;
				/* PERMIT EXITS. */
				vars.objcts_1.oflag1[vars.oindex_1.axe - 1] &= ~Vars.VISIBT;
				vars.objcts_1.odesc1[vars.oindex_1.troll - 1] = 435;
				/* TROLL OUT. */
				return ret_val;
			}
			/* DEAD? */
			vars.findex_1.trollf = true;
			/* PERMIT EXITS. */
			return ret_val;
		}
		/* FIGHT? */
		if (vars.objcts_1.ocan[vars.oindex_1.axe - 1] == vars.oindex_1.troll)
		{
			ret_val = false;
			/* COULDNT HANDLE IT. */
			return ret_val;
		}
		/* GOT AXE? NOTHING. */
		i = 433;
		/* ASSUME CANT GET. */
		if (game.dsub.qhere_(vars.oindex_1.axe, vars.play_1.here))
		{

			/* HERE? */
			i = 434;
			/* YES, RECOVER. */
			game.dsub.newsta_(vars.oindex_1.axe, 0, 0, vars.oindex_1.troll, 0);
		}
		if (game.dsub.qhere_(vars.oindex_1.troll, vars.play_1.here))
		{
			game.dsub.rspeak_(i);
		}
		/* IF PLAYER HERE. */
		return ret_val;

	} /* trollp_ */

	/* CYCLOP- CYCLOPS FUNCTION */
	boolean cyclop_(int arg)
	{
		/* System generated locals */
		int i__1, i__2;
		boolean ret_val;

		/* Local variables */
		int i;

		ret_val = true;
		/* ASSUME WINS. */
		if (!vars.findex_1.cyclof)
		{
			if (vars.prsvec_1.action == FIGHT
					|| vars.prsvec_1.action == VILLAIN_QUIT_FIGHTING)
			{
				ret_val = false;
				/* FAILS. */
				return ret_val;
			}
			if (Math.abs(vars.findex_1.rvcyc) <= 5)
			{
				if (vars.prsvec_1.action != GIVE)
				{
					i = 0;
					/* ASSUME NOT HANDLED. */
					if (vars.prsvec_1.action == HELLO)
					{
						game.dsub.rspeak_(i);
						/* DISDAIN IT. */
						if (vars.findex_1.rvcyc < 0)
						{
							--vars.findex_1.rvcyc;
						}
						if (vars.findex_1.rvcyc >= 0)
						{
							++vars.findex_1.rvcyc;
						}
						if (!vars.findex_1.cyclof)
						{
							i__1 = Math.abs(vars.findex_1.rvcyc) + 193;
							game.dsub.rspeak_(i__1);
						}
						return ret_val;
					}
					/* HELLO IS NO GO. */
					if (vars.prsvec_1.action == THROW
							|| vars.prsvec_1.action == MUNG)
					{

						i = Supp.rnd_(2) + 200;
					}
					if (vars.prsvec_1.action == TAKE)
					{
						i = 202;
					}
					if (vars.prsvec_1.action == TIE)
					{
						i = 203;
					}
					if (i <= 0)
					{
						ret_val = false;
						/* FAILS. */
						return ret_val;
					}
					else
					{
						game.dsub.rspeak_(i);
						/* DISDAIN IT. */
						if (vars.findex_1.rvcyc < 0)
						{
							--vars.findex_1.rvcyc;
						}
						if (vars.findex_1.rvcyc >= 0)
						{
							++vars.findex_1.rvcyc;
						}
						if (!vars.findex_1.cyclof)
						{
							i__1 = Math.abs(vars.findex_1.rvcyc) + 193;
							game.dsub.rspeak_(i__1);
						}
						return ret_val;
					}
					/* SEE IF HANDLED. */
				}
				/* GIVE? */
				if (vars.prsvec_1.direct_object != vars.oindex_1.food || vars.findex_1.rvcyc < 0)
				{
					if (vars.prsvec_1.direct_object != vars.oindex_1.water)
					{
						i = 192;
						/* ASSUME INEDIBLE. */
						if (vars.prsvec_1.direct_object == vars.oindex_1.garli)
						{
							i = 193;
						}
						/* GARLIC IS JOKE. */
						game.dsub.rspeak_(i);
						/* DISDAIN IT. */
						if (vars.findex_1.rvcyc < 0)
						{
							--vars.findex_1.rvcyc;
						}
						if (vars.findex_1.rvcyc >= 0)
						{
							++vars.findex_1.rvcyc;
						}
						if (!vars.findex_1.cyclof)
						{
							i__1 = Math.abs(vars.findex_1.rvcyc) + 193;
							game.dsub.rspeak_(i__1);
						}
						return ret_val;
					}
					/* DRINK WHEN THIRSTY? */
					if (vars.findex_1.rvcyc >= 0)
					{
						game.dsub.rspeak_(191);
						/* NOT THIRSTY. */
						ret_val = false;
						/* FAILS. */
						return ret_val;
					}
					game.dsub.newsta_(vars.prsvec_1.direct_object, 190, 0, 0, 0);
					/* DRINKS AND */
					vars.findex_1.cyclof = true;
					/* FALLS ASLEEP. */
					vars.objcts_1.oflag2[vars.oindex_1.cyclo
							- 1] = (vars.objcts_1.oflag2[vars.oindex_1.cyclo - 1] | Vars.SLEPBT)
									& ~Vars.FITEBT;
					return ret_val;
				}
				/* FOOD WHEN HUNGRY? */
				game.dsub.newsta_(vars.oindex_1.food, 189, 0, 0, 0);
				/* EATS PEPPERS. */
				/* Computing MIN */
				i__1 = -1;
				i__2 = -vars.findex_1.rvcyc;
				vars.findex_1.rvcyc = Math.min(i__1, i__2);
				/* GETS THIRSTY. */
				return ret_val;
			}
			/* ANNOYED TOO MUCH? */
			vars.findex_1.rvcyc = 0;
			/* RESTART COUNT. */
			game.dsub.jigsup_(188);
			/* YES, EATS PLAYER. */
			return ret_val;
		}
		/* ASLEEP? */
		if (vars.prsvec_1.action != ALARM && vars.prsvec_1.action != MUNG
				&& vars.prsvec_1.action != HELLO
				&& vars.prsvec_1.action != BURN
				&& vars.prsvec_1.action != KILL
				&& vars.prsvec_1.action != ATTACK)
		{
			ret_val = false;
			/* FAILS. */
			return ret_val;
		}
		vars.findex_1.cyclof = false;
		/* WAKE CYCLOPS. */
		game.dsub.rspeak_(187);
		/* DESCRIBE. */
		vars.findex_1.rvcyc = Math.abs(vars.findex_1.rvcyc);
		vars.objcts_1.oflag2[vars.oindex_1.cyclo
				- 1] = (vars.objcts_1.oflag2[vars.oindex_1.cyclo - 1] | Vars.FITEBT) & ~Vars.SLEPBT;
		return ret_val;

	} /* cyclop_ */

	/* THIEFP- THIEF FUNCTION */
	boolean thiefp_(int arg)
	{
		/* System generated locals */
		int i__1;
		boolean ret_val;

		/* Local variables */
		int i, j;

		ret_val = true;
		/* ASSUME WINS. */
		if (vars.prsvec_1.action != FIGHT)
		{
			if (vars.prsvec_1.action != VILLAIN_DIED)
			{
				if (vars.prsvec_1.action != VILLAIN_QUIT_FIGHTING)
				{
					if (vars.prsvec_1.action != HELLO
							|| vars.objcts_1.odesc1[vars.oindex_1.thief - 1] != 504)
					{
						if (vars.prsvec_1.action != VILLAIN_LEFT)
						{
							if (vars.prsvec_1.action != VILLAIN_ENTERED)
							{
								if (vars.prsvec_1.action != TAKE)
								{
									if (vars.prsvec_1.action != THROW
											|| vars.prsvec_1.direct_object != vars.oindex_1.knife
											|| (vars.objcts_1.oflag2[vars.oindex_1.thief - 1]
													& Vars.FITEBT) != 0)
									{
										if (vars.prsvec_1.action != THROW
												&& vars.prsvec_1.action != GIVE
												|| vars.prsvec_1.direct_object == 0
												|| vars.prsvec_1.direct_object == vars.oindex_1.thief)
										{
											ret_val = false;
											return ret_val;
										}
										if (vars.objcts_1.ocapac[vars.oindex_1.thief - 1] < 0)
										{

											/* WAKE HIM UP. */
											vars.objcts_1.ocapac[vars.oindex_1.thief
													- 1] = -vars.objcts_1.ocapac[vars.oindex_1.thief
															- 1];
											vars.hack_1.thfact = true;
											vars.objcts_1.oflag1[vars.oindex_1.still
													- 1] |= Vars.VISIBT;
											vars.objcts_1.odesc1[vars.oindex_1.thief - 1] = 503;
											game.dsub.rspeak_(510);
										}

										if (vars.prsvec_1.direct_object != vars.oindex_1.brick
												|| vars.objcts_1.ocan[vars.oindex_1.fuse
														- 1] != vars.oindex_1.brick
												|| vars.cevent_1.ctick[vars.cindex_1.cevfus
														- 1] == 0)
										{
											i__1 = -vars.oindex_1.thief;
											game.dsub.newsta_(vars.prsvec_1.direct_object, 0, 0, 0, i__1);
											/* THIEF TAKES GIFT. */
											if (vars.objcts_1.otval[vars.prsvec_1.direct_object - 1] > 0)
											{
												game.dsub.rspsub_(627,
														vars.objcts_1.odesc2[vars.prsvec_1.direct_object
																- 1]);
												/* THIEF ENGROSSED. */
												vars.findex_1.thfenf = true;
												return ret_val;
											}
											/* A TREASURE? */
											game.dsub.rspsub_(512,
													vars.objcts_1.odesc2[vars.prsvec_1.direct_object - 1]);
											return ret_val;
										}
										game.dsub.rspeak_(511);
										/* THIEF REFUSES BOMB. */
										return ret_val;
									}
									if (game.dsub.prob_(10, 10))
									{
										j = 508;
										/* THIEF DROPS STUFF. */
										i__1 = vars.objcts_1.olnt;
										for (i = 1; i <= i__1; ++i)
										{
											if (vars.objcts_1.oadv[i - 1] == -vars.oindex_1.thief)
											{
												/* THIEF CARRYING? */
												j = 509;
												game.dsub.newsta_(i, 0, vars.play_1.here, 0, 0);
											}
										}
										game.dsub.newsta_(vars.oindex_1.thief, j, 0, 0, 0);
										/* THIEF VANISHES. */
										return ret_val;
									}
									/* THREW KNIFE, 10%? */
									game.dsub.rspeak_(507);
									/* NO, JUST MAKES */
									vars.objcts_1.oflag2[vars.oindex_1.thief - 1] |= Vars.FITEBT;
									return ret_val;
								}
								/* TAKE? */
								game.dsub.rspeak_(506);
								/* JOKE. */
								return ret_val;
							}
							/* IN? */
							if (game.dsub.qhere_(vars.oindex_1.thief, vars.play_1.here))
							{
								game.dsub.rspeak_(505);
							}
							/* CAN HERO SEE? */
							vars.hack_1.thfact = true;
							/* ENABLE DEMON. */
							vars.objcts_1.odesc1[vars.oindex_1.thief - 1] = 503;
							/* CHANGE DESCRIPTION. */
							vars.objcts_1.oflag1[vars.oindex_1.still - 1] |= Vars.VISIBT;
							if (vars.play_1.here == vars.rindex_1.treas
									&& game.dsub.qhere_(vars.oindex_1.chali, vars.play_1.here))
							{
								vars.objcts_1.oflag1[vars.oindex_1.chali - 1] &= ~Vars.TAKEBT;
							}
							return ret_val;
						}
						/* OUT? */
						vars.hack_1.thfact = false;
						/* DISABLE DEMON. */
						vars.objcts_1.odesc1[vars.oindex_1.thief - 1] = 504;
						/* CHANGE DESCRIPTION. */
						vars.objcts_1.oflag1[vars.oindex_1.still - 1] &= ~Vars.VISIBT;
						vars.objcts_1.oflag1[vars.oindex_1.chali - 1] |= Vars.TAKEBT;
						return ret_val;
					}
					game.dsub.rspeak_(626);
					return ret_val;
				}
				/* FIRST ENCOUNTER? */
				ret_val = game.dsub.prob_(20, 75);
				return ret_val;
			}
			/* DEAD? */
			vars.hack_1.thfact = false;
			/* DISABLE DEMON. */
			vars.objcts_1.oflag1[vars.oindex_1.chali - 1] |= Vars.TAKEBT;
			j = 0;
			i__1 = vars.objcts_1.olnt;
			for (i = 1; i <= i__1; ++i)
			{
				/* CARRYING ANYTHING? */
				/* L125: */
				if (vars.objcts_1.oadv[i - 1] == -vars.oindex_1.thief)
				{
					j = 500;
				}
			}
			game.dsub.rspeak_(j);
			/* TELL IF BOOTY REAPPEARS. */

			j = 501;
			i__1 = vars.objcts_1.olnt;
			for (i = 1; i <= i__1; ++i)
			{
				/* LOOP. */
				if (i == vars.oindex_1.chali || i == vars.oindex_1.thief
						|| vars.play_1.here != vars.rindex_1.treas
						|| !game.dsub.qhere_(i, vars.play_1.here))
				{
					if (vars.objcts_1.oadv[i - 1] == -vars.oindex_1.thief)
					{
						game.dsub.newsta_(i, 0, vars.play_1.here, 0, 0);
					}
				}
				else
				{
					vars.objcts_1.oflag1[i - 1] |= Vars.VISIBT;
					game.dsub.rspsub_(j, vars.objcts_1.odesc2[i - 1]);
					/* DESCRIBE. */
					j = 502;
				}
			}
			return ret_val;
		}
		/* FIGHT? */
		if (vars.objcts_1.ocan[vars.oindex_1.still - 1] == vars.oindex_1.thief)
		{
			ret_val = false;
			return ret_val;
		}
		/* GOT STILLETTO? F. */
		if (game.dsub.qhere_(vars.oindex_1.still, vars.hack_1.thfpos))
		{
			game.dsub.newsta_(vars.oindex_1.still, 0, 0, vars.oindex_1.thief, 0);
			/* YES, RECOVER. */
			if (game.dsub.qhere_(vars.oindex_1.thief, vars.play_1.here))
			{
				game.dsub.rspeak_(499);
			}
			/* IF HERO, TELL. */
			return ret_val;
		}
		/* CAN HE RECOVER IT? */
		game.dsub.newsta_(vars.oindex_1.thief, 0, 0, 0, 0);
		/* NO, VANISH. */
		if (game.dsub.qhere_(vars.oindex_1.thief, vars.play_1.here))
		{
			game.dsub.rspeak_(498);
		}
		/* IF HERO, TELL. */
		return ret_val;
		/* TELL IF BOOTY REAPPEARS. */

	} /* thiefp_ */

}
