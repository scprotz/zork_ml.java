package zork;

import java.io.IOException;

public class DMain
{
	/* DUNGEON-- MAIN PROGRAM */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */

//	#define EXTERN
//	#define INIT

//	#include "funcs.h"
//	#include "vars.h"

	public static void main(String[] args) throws IOException /* void changed to int, Volker Blasius, 11jul93 */
	{
		/* 1) INITIALIZE DATA STRUCTURES */
		/* 2) PLAY GAME */
		Vars vars = new Vars();
		DInit init = new DInit(vars);
		Dgame game = new Dgame(vars, init);
		
		if (init.init_())
		{
			game.game_();
		}
		/* !IF INIT, PLAY GAME. */
		Supp.exit_();
		/* !DONE */
	} /* MAIN__ */

}
