package zork;

import java.io.IOException;

public class Dgame
{
	/* GAME- MAIN COMMAND LOOP FOR DUNGEON */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */

	Vars vars = null;
	DInit init = null;

	Np np = null;
	Verbs verbs = null;
	Actors actors = null;
	Demons demons = null;
	Dsub dsub = null;

	Dso1 dso1 = null;
	Dso2 dso2 = null;
	Dso3 dso3 = null;
	Dso4 dso4 = null;
	Dso5 dso5 = null;
	Dso6 dso6 = null;
	Dso7 dso7 = null;

	Gdt gdt = null;
	Objcts objcts = null;
	Clockr clockr = null;

	Ballop ballop = null;
	Lightp lightp = null;
	Nobjs nobjs = null;
	Sobjs sobjs = null;
	Villns villns = null;

	Rooms rooms = null;
	NRooms nrooms = null;

	/** Dsub needs this to initialize **/
	// TODO: Should refactor the requiring functions **/

	
	
	public Dgame(Vars vars, DInit init)
	{
		this.vars = vars;
		this.init = init;

		this.demons = new Demons(vars, this);
		this.objcts = new Objcts(vars, this);
		this.rooms = new Rooms(vars, this);
		this.nrooms = new NRooms(vars, this);
		this.ballop = new Ballop(vars, this);
		this.lightp = new Lightp(vars, this);
		this.gdt = new Gdt();
		this.dsub = new Dsub(vars, this);
		this.dso1 = new Dso1(vars, this);
		this.dso2 = new Dso2(vars, this);
		this.dso3 = new Dso3(vars, this);
		this.dso4 = new Dso4(vars, this);
		this.dso5 = new Dso5(vars, this);
		this.dso6 = new Dso6(vars, this);
		this.dso7 = new Dso7(vars, this);

		this.verbs = new Verbs(vars, this);
		
		this.nobjs = new Nobjs(vars, this);
		this.sobjs = new Sobjs(vars, this);
		this.villns = new Villns(vars, this);
		this.np = new Np(vars, this);
		this.clockr = new Clockr(vars, this);

		this.actors = new Actors(vars, this);
	}


	public void game_() throws IOException
	{
		/* Local variables */
		int i;

		/* START UP, DESCRIBE CURRENT LOCATION. */

		dsub.rspeak_(1);
		/* !WELCOME ABOARD. */

		dsub.rmdesc_(3);
		/* !START GAME. */

		/* NOW LOOP, READING AND EXECUTING COMMANDS. */

		int GOTO = 100;
		do
		{
			switch (GOTO)
			{
				case 100:

					vars.play_1.winner = vars.aindex_1.player;
					/* !PLAYER MOVING. */
					vars.play_1.telflg = false;
					/* !ASSUME NOTHING TOLD. */
					if (vars.prsvec_1.prscon <= 1)
					{
						np.rdline_(vars.input_1.inbuf, 1);
					}

					if (Vars.ALLOW_GDT)
					{
						String str = new String(vars.input_1.inbuf);
						str = str.substring(vars.prsvec_1.prscon - 1);
						if (str.startsWith("GDT"))
						{
							/* !CALL ON GDT? */
							gdt.gdt_();
							/* !YES, INVOKE. */
							GOTO = 100;
							continue;
							/* !ONWARD. */
						}

					} /* ALLOW_GDT */

					++vars.state_1.moves;
					vars.prsvec_1.prswon = np.parse_(vars.input_1.inbuf, true);
					if (!vars.prsvec_1.prswon)
					{

						GOTO = 400;
						continue;
					}
					/* !PARSE LOSES? */
					if (xvehic_(1))
					{
						GOTO = 400;
						continue;
					}
					/* !VEHICLE HANDLE? */

					if (vars.prsvec_1.prsa == vars.vindex_1.tellw)
					{
						GOTO = 2000;
						continue;
					}
					/* !TELL? */
				case 300:
					if (vars.prsvec_1.prso == vars.oindex_1.valua
							|| vars.prsvec_1.prso == vars.oindex_1.every)
					{

						GOTO = 900;
						continue;
					}
					if (!verbs.vappli_(vars.prsvec_1.prsa))
					{
						GOTO = 400;
						continue;
					}
					/* !VERB OK? */
				case 350:
					if (!vars.findex_1.echof && vars.play_1.here == vars.rindex_1.echor)
					{
						GOTO = 1000;
						continue;
					}
//		    f = 
					dsub.rappli_(vars.rooms_1.ractio[vars.play_1.here - 1]);

				case 400:

					xendmv_(vars.play_1.telflg);
					/* !DO END OF MOVE. */
					if (!dso5.lit_(vars.play_1.here))
					{
						vars.prsvec_1.prscon = 1;
					}
					GOTO = 100;
					continue;

				case 900:
					verbs.dverb1.valuac_(vars.oindex_1.valua);
					GOTO = 350;
					continue;
				/* GAME, PAGE 3 */

				/* SPECIAL CASE-- ECHO ROOM. */
				/* IF INPUT IS NOT 'ECHO' OR A DIRECTION, JUST ECHO. */

				case 1000:
					np.rdline_(vars.input_1.inbuf, 0);
					++vars.state_1.moves;
					/* !CHARGE FOR MOVES. */
					if (!new String(vars.input_1.inbuf).equals("ECHO"))
					{
						GOTO = 1300;
						continue;
					}

					dsub.rspeak_(571);
					/* !KILL THE ECHO. */
					vars.findex_1.echof = true;
					vars.objcts_1.oflag2[vars.oindex_1.bar - 1] &= ~Vars.SCRDBT;
					vars.prsvec_1.prswon = true;
					/* !FAKE OUT PARSER. */
					vars.prsvec_1.prscon = 1;
					/* !FORCE NEW INPUT. */
					GOTO = 400;
					continue;

				case 1300:
					vars.prsvec_1.prswon = np.parse_(vars.input_1.inbuf, false);
					if (!vars.prsvec_1.prswon || vars.prsvec_1.prsa != vars.vindex_1.walkw)
					{
						GOTO = 1400;
						continue;
					}
					if (dso3.findxt_(vars.prsvec_1.prso, vars.play_1.here))
					{
						GOTO = 300;
						continue;
					}
					/* !VALID EXIT? */

				case 1400:
					Supp.more_output(new String(vars.input_1.inbuf));
					vars.play_1.telflg = true;
					/* !INDICATE OUTPUT. */
					GOTO = 1000;
					continue;
				/* !MORE ECHO ROOM. */
				/* GAME, PAGE 4 */

				/* SPECIAL CASE-- TELL <ACTOR>, NEW COMMAND */
				/* NOTE THAT WE CANNOT BE IN THE ECHO ROOM. */

				case 2000:
					if ((vars.objcts_1.oflag2[vars.prsvec_1.prso - 1] & Vars.ACTRBT) != 0)
					{
						GOTO = 2100;
						continue;
					}
					dsub.rspeak_(602);
					/* !CANT DO IT. */
					GOTO = 350;
					continue;
				/* !VAPPLI SUCCEEDS. */

				case 2100:
					vars.play_1.winner = dsub.oactor_(vars.prsvec_1.prso);
					/* !NEW PLAYER. */
					vars.play_1.here = vars.advs_1.aroom[vars.play_1.winner - 1];
					/* !NEW LOCATION. */
					if (vars.prsvec_1.prscon <= 1)
					{
						GOTO = 2700;
						continue;
					}
					/* !ANY INPUT? */
					if (np.parse_(vars.input_1.inbuf, true))
					{
						GOTO = 2150;
						continue;
					}
				case 2700:
					i = 341;
					/* !FAILS. */
					if (vars.play_1.telflg)
					{
						i = 604;
					}
					/* !GIVE RESPONSE. */
					dsub.rspeak_(i);
				case 2600:
					vars.play_1.winner = vars.aindex_1.player;
					/* !RESTORE STATE. */
					vars.play_1.here = vars.advs_1.aroom[vars.play_1.winner - 1];
					GOTO = 350;
					continue;

				case 2150:
					if (actors.aappli_(vars.advs_1.aactio[vars.play_1.winner - 1]))
					{
						GOTO = 2400;
						continue;
					}
					/* !ACTOR HANDLE? */
					if (xvehic_(1))
					{
						GOTO = 2400;
						continue;
					}
					/* !VEHICLE HANDLE? */
					if (vars.prsvec_1.prso == vars.oindex_1.valua
							|| vars.prsvec_1.prso == vars.oindex_1.every)
					{
						GOTO = 2900;
						continue;
					}
					if (!verbs.vappli_(vars.prsvec_1.prsa))
					{
						GOTO = 2400;
						continue;
					}
					/* !VERB HANDLE? */
					/* case 2350: */
//		    f = 
					dsub.rappli_(vars.rooms_1.ractio[vars.play_1.here - 1]);

				case 2400:
					xendmv_(vars.play_1.telflg);
					/* !DO END OF MOVE. */
					GOTO = 2600;
					continue;
				/* !DONE. */

				case 2900:
					verbs.dverb1.valuac_(vars.oindex_1.valua);
					/* !ALL OR VALUABLES. */
					GOTO = 350;
					continue;
			}
		} while (true);

	} /* game_ */

	/* XENDMV- EXECUTE END OF MOVE FUNCTIONS. */
	private void xendmv_(boolean flag) throws IOException
	{

		if (!(flag))
		{
			dsub.rspeak_(341);
		}
		/* !DEFAULT REMARK. */
		if (vars.hack_1.thfact)
		{
			actors.thiefd_();
		}
		/* !THIEF DEMON. */
		if (vars.prsvec_1.prswon)
		{
			demons.fightd_();
		}
		/* !FIGHT DEMON. */
		if (vars.hack_1.swdact)
		{
			demons.swordd_();
		}
		/* !SWORD DEMON. */
		if (vars.prsvec_1.prswon)
		{

			verbs.clockd_();
		}
		/* !CLOCK DEMON. */
		if (vars.prsvec_1.prswon)
		{
			xvehic_(2);
		}
		/* !VEHICLE READOUT. */
	} /* xendmv_ */

	/* XVEHIC- EXECUTE VEHICLE FUNCTION */
	private boolean xvehic_(int n) throws IOException
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int av;

		ret_val = false;
		/* !ASSUME LOSES. */
		av = vars.advs_1.avehic[vars.play_1.winner - 1];
		/* !GET VEHICLE. */
		if (av != 0)
		{
			ret_val = objcts.oappli_(vars.objcts_1.oactio[av - 1], n);
		}
		return ret_val;
	} /* xvehic_ */

}
