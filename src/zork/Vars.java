package zork;

public class Vars
{
	/* vars.h -- variables for dungeon */

	/* These variable definitions are really ugly because they are actually
	 * translations of FORTRAN common blocks.  In the original FORTRAN source
	 * the common blocks were included many times by each function that
	 * needed them; I have changed this to define them all in this one file,
	 * and include this in every source file.  It's less modular, and it
	 * makes everything slower to compile, but it's easier on me.
	 * A few structures used only by the parsing routines are in parse.h.
	 */

//	#ifndef VARS_H
//	#define VARS_H

//	#ifndef EXTERN
//	#define EXTERN extern
//	#endif
	
	public static final boolean DEBUG = true;
	public static final boolean ALLOW_GDT = true;

	public class prsvec_
	{
	   int prsa, prsi, prso;
	   boolean prswon;
	   int prscon;
	};


	public prsvec_ prsvec_1 = new prsvec_();

	public class orphs_
	{
	   int oflag, oact, oslot, oprep, oname;
	};


	public orphs_ orphs_1 = new orphs_();
//	#define orp ((int *)&orphs_1)

	public class last_
	{
	   int lastit;
	};


	public last_ last_1 = new last_();

	public class play_
	{
	   int winner, here;
	   boolean telflg;
	};


	public play_ play_1 = new play_();

	public class rooms_
	{
		int rlnt, rdesc1[] = new int[200], rdesc2[] = new int[200], rexit[] = new int[200],
				ractio[] = new int[200], rval[] = new int[200], rflag[] = new int[200];

		public int rrand(int index)
		{			
			int i = index + 601;
			
//			int i = index - 601;
			int array_number = i / 200;
			switch (array_number)
			{
				case 0:
					return rdesc1[i];
				case 1:
					return rdesc2[i - 200];
				case 2:
					return rexit[i - 400];
				case 3:
					return ractio[i - 600];				 
				case 4:
					return rval[i - 800];
				case 5:
					return rflag[i - 1000];
				default:
					throw new RuntimeException("Could not find rrand index correctly.");
			}
		}
		
		public void rrand(int index, int value)
		{
			
			int i = index + 600;			 
			int array_number = i / 200;
			switch (array_number)
			{
				case 0:
					rdesc1[i] = value; break;
				case 1:
					rdesc2[i - 200] = value; break;
				case 2:
					rexit[i - 400] = value; break;
				case 3:
					ractio[i - 600] = value; break;
				case 4:
					rval[i - 800] = value; break;
				case 5:
					rflag[i - 1000] = value; break;
				default:
					throw new RuntimeException("Could not find rrand index correctly. " + index + "="+ value + " : " + array_number);
			}
		}
	};


	public rooms_ rooms_1 = new rooms_();
//	#define eqr ((int *)&rooms_1 + 1)
//	#define rrand ((int *)&rooms_1 + 601)

	/* Room flags */

	public static final int RSEEN = 32768;
	public static final int RLIGHT = 16384;
	public static final int RLAND = 8192;
	public static final int RWATER = 4096;
	public static final int RAIR = 2048;
	public static final int RSACRD = 1024;
	public static final int RFILL = 512;
	public static final int RMUNG = 256;
	public static final int RBUCK = 128;
	public static final int RHOUSE = 64;
	public static final int RNWALL = 32;
	public static final int REND = 16;

	public class rindex_
	{
		final int whous = 2;
		final int lroom = 8;
		final int cella = 9;
		final int mtrol = 10;
		final int maze1 = 11;
		final int mgrat = 25;
		final int maz15 = 30;
		final int fore1 = 31;
		final int fore3 = 33;

		final int clear = 36;
		final int reser = 40;
		final int strea = 42;
		final int egypt = 44;
		final int echor = 49;
		final int tshaf = 61;
		final int bshaf = 76;
		final int mmach = 77;
		final int dome = 79;

		final int mtorc = 80;
		final int carou = 83;
		final int riddl = 91;
		final int lld2 = 94;
		final int temp1 = 96;
		final int temp2 = 97;
		final int maint = 100;
		final int blroo = 102;
		final int treas = 103;

		final int rivr1 = 107;
		final int rivr2 = 108;
		final int rivr3 = 109;
		final int mcycl = 101;
		final int rivr4 = 112;
		final int rivr5 = 113;
		final int fchmp = 114;
		final int falls = 120;
		final int mbarr = 119;

		final int mrain = 121;
		final int pog = 122;
		final int vlbot = 126;
		final int vair1 = 127;
		final int vair2 = 128;
		final int vair3 = 129;
		final int vair4 = 130;
		final int ledg2 = 131;
		final int ledg3 = 132;

		final int ledg4 = 133;
		final int msafe = 135;
		final int cager = 140;
		final int caged = 141;
		final int twell = 142;
		final int bwell = 143;
		final int alice = 144;
		final int alism = 145;
		final int alitr = 146;

		final int mtree = 147;
		final int bkent = 148;
		final int bkvw = 151;
		final int bktwi = 153;
		final int bkvau = 154;
		final int bkbox = 155;
		final int crypt = 157;
		final int tstrs = 158;
		final int mrant = 159;

		final int mreye = 160;
		final int mra = 161;
		final int mrb = 162;
		final int mrc = 163;
		final int mrg = 164;
		final int mrd = 165;
		final int fdoor = 166;
		final int mrae = 167;
		final int mrce = 171;
		final int mrcw = 172;
		final int mrge = 173;

		final int mrgw = 174;
		final int mrdw = 176;
		final int inmir = 177;
		final int scorr = 179;
		final int ncorr = 182;
		final int parap = 183;
		final int cell = 184;
		final int pcell = 185;
		final int ncell = 186;
		final int cpant = 188;

		final int cpout = 189;
		final int cpuzz = 190;
	};
//	#ifdef INIT
//	= { 2, 8, 9, 10, 11, 25, 30, 31, 33, 36, 40, 42, 44, 49, 61, 76,
//	   77, 79, 80, 83, 91, 94, 96, 97, 100, 102, 103, 107, 108, 109, 
//	   101, 112, 113, 114, 120, 119, 121, 122, 126, 127, 128, 129, 130, 
//	   131, 132, 133, 135, 140, 141, 142, 143, 144, 145, 146, 147, 148, 
//	   151, 153, 154, 155, 157, 158, 159, 160, 161, 162, 163, 164, 165, 
//	   166, 167, 171, 172, 173, 174, 176, 177, 179, 182, 183, 184, 185, 
//	   186, 188, 189, 190 }
//	#endif
//	   ;

	public rindex_ rindex_1 = new rindex_();

	   public class xsrch_ {
	      final int xmin = 1024; 
	final int    		  xmax = 16384; 
	final int    		  xdown = 10240; 
	final int    		  xup = 9216; 
	final int    		  xnorth = 1024; 
	final int    		  xsouth = 5120; 
	final int    		  xenter = 13312; 
	final int    		  xexit = 14336; 
	final int    		  xeast = 3072; 
	            final int  xwest =  7168;
	   };
//	#ifdef INIT
//	            = { 1024, 16384, 10240, 9216, 1024, 5120, 13312, 14336, 3072, 
//	                7168 }
//	#endif
//	   ;

	public xsrch_ xsrch_1 = new xsrch_();

	   public class objcts_
	{
	      int olnt, odesc1[] = new int[220], odesc2[] = new int[220], odesco[] = new int[220], oactio[] = new int[220], 
	               oflag1[] = new int[220], oflag2[] = new int[220], ofval[] = new int[220], otval[] = new int[220], osize[] = new int[220], 
	               ocapac[] = new int[220], oroom[] = new int[220], oadv[] = new int[220], ocan[] = new int[220], oread[] = new int[220];
	   };


	public objcts_ objcts_1 = new objcts_();
//	#define eqo ((int *)&objcts_1 + 1)

	public class oroom2_
	{
	   int r2lnt, oroom2[] = new int[20], rroom2[] = new int[20];
	};


	public oroom2_ oroom2_1 = new oroom2_();

	/* Object flags (oflags) */

	public static final int VISIBT = 32768;
	public static final int READBT = 16384;
	public static final int TAKEBT = 8192;
	public static final int DOORBT = 4096;
	public static final int TRANBT = 2048;
	public static final int FOODBT = 1024;
	public static final int NDSCBT = 512;
	public static final int DRNKBT = 256;
	public static final int CONTBT = 128;
	public static final int LITEBT = 64;
	public static final int VICTBT = 32;
	public static final int BURNBT = 16;
	public static final int FLAMBT = 8;
	public static final int TOOLBT = 4;
	public static final int TURNBT = 2;
	public static final int ONBT = 1;
	public static final int FINDBT = 32768;
	public static final int SLEPBT = 16384;
	public static final int SCRDBT = 8192;
	public static final int TIEBT = 4096;
	public static final int CLMBBT = 2048;
	public static final int ACTRBT = 1024;
	public static final int WEAPBT = 512;
	public static final int FITEBT = 256;
	public static final int VILLBT = 128;
	public static final int STAGBT = 64;
	public static final int TRYBT = 32;
	public static final int NOCHBT = 16;
	public static final int OPENBT = 8;
	public static final int TCHBT = 4;
	public static final int VEHBT = 2;
	public static final int SCHBT = 1;

	public class oindex_
	{
		final int garli = 2;
		final int food = 3;
		final int gunk = 4;
		final int coal = 5;
		final int machi = 7;
		final int diamo = 8;
		final int tcase = 9;
		final int bottl = 10;
		final int water = 11;
		final int rope = 12;
		final int knife = 13;
		final int sword = 14;
		final int lamp = 15;
		final int blamp = 16;
		final int rug = 17;
		final int leave = 18;
		final int troll = 19;
		
		final int axe = 20;
		final int rknif = 21;
		final int keys = 23;
		final int ice = 30;
		final int bar = 26;
		final int coffi = 33;
		final int torch = 34;
		final int tbask = 35;
		final int fbask = 36;
		final int irbox = 39;
		final int ghost = 42;
		final int trunk = 45;
		final int bell = 46;
		final int book = 47;
		final int candl = 48;
		final int match = 51;
		final int tube = 54;
		final int putty = 55;
		final int wrenc = 56;
		final int screw = 57;
		final int cyclo = 58;
		final int chali = 59;
		final int thief = 61;
		final int still = 62;
		final int windo = 63;
		final int grate = 65;
		final int door = 66;
		final int hpole = 71;
		final int leak = 78;
		final int rbutt = 79;
		final int raili = 75;
		final int pot = 85;
		final int statu = 86;
		final int iboat = 87;
		final int dboat = 88;
		final int pump = 89;
		final int rboat = 90;
		final int stick = 92;
		final int buoy = 94;
		final int shove = 96;
		final int ballo = 98;
		final int recep = 99;
		final int guano = 97;
		final int brope = 101;
		final int hook1 = 102;
		final int hook2 = 103;
		final int safe = 105;
		final int sslot = 107;
		final int brick = 109;
		final int fuse = 110;
		final int gnome = 111;
		final int blabe = 112;
		final int dball = 113;
		final int tomb = 119;
		final int lcase = 123;
		final int cage = 124;
		final int rcage = 125;
		final int spher = 126;
		final int sqbut = 127;
		final int flask = 132;
		
		final int pool = 133;
		final int saffr = 134;
		final int bucke = 137;
		final int ecake = 138;
		final int orice = 139;
		final int rdice = 140;
		final int blice = 141;
		final int robot = 142;
		final int ftree = 145;
		final int bills = 148;
		final int portr = 149;
		final int scol = 151;
		final int zgnom = 152;

		final int egg = 154;
		final int begg = 155;
		final int baubl = 156;
		final int canar = 157;
		final int bcana = 158;
		final int ylwal = 149;
		final int rdwal = 161;
		final int pindr = 164;
		final int rbeam = 171;
		final int odoor = 172;
		final int qdoor = 173;
		final int cdoor = 175;
		final int num1 = 178;
		
		final int num8 = 185;
		final int warni = 186;
		final int cslit = 187;
		final int gcard = 188;
		final int stldr = 189;
		final int hands = 200;
		final int wall = 198;
		final int lungs = 201;
		final int sailo = 196;
		final int aviat = 202;
		final int teeth = 197;
		final int itobj = 192;
		final int every = 194;
		
		final int valua = 195;
		final int oplay = 193;
		final int wnort = 205;
		final int gwate = 209;
		final int master = 215;
	};
//	#ifdef INIT
//	= { 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
//	   20, 21, 23, 30, 26, 33, 34, 35, 36, 39, 42, 45, 46, 47, 48, 51, 
//	   54, 55, 56, 57, 58, 59, 61, 62, 63, 65, 66, 71, 78, 79, 75, 85, 
//	   86, 87, 88, 89, 90, 92, 94, 96, 98, 99, 97, 101, 102, 103, 105, 
//	   107, 109, 110, 111, 112, 113, 119, 123, 124, 125, 126, 127, 132, 
//	   133, 134, 137, 138, 139, 140, 141, 142, 145, 148, 149, 151, 152, 
//	   154, 155, 156, 157, 158, 159, 161, 164, 171, 172, 173, 175, 178, 
//	   185, 186, 187, 188, 189, 200, 198, 201, 196, 202, 197, 192, 194, 
//	   195, 193, 205, 209, 215 }
//	#endif
//	   ;

	public oindex_ oindex_1 = new oindex_();

	   public class cevent_
	{
	      int clnt, ctick[] = new int[25], cactio[] = new int[25];
	      boolean cflag[] = new boolean[25];
	   };


	public cevent_ cevent_1 = new cevent_();
//	#define eqc ((int *)&cevent_1 + 1)

	public class cindex_
	{
		final int cevcur = 1;
		final int cevmnt = 2;
		final int cevlnt = 3;
		final int cevmat = 4;
		final int cevcnd = 5;
		final int cevbal = 6;
		final int cevbrn = 7;
		final int cevfus = 8;

		final int cevled = 9;
		final int cevsaf = 10;
		final int cevvlg = 11;
		final int cevgno = 12;
		final int cevbuc = 13;
		final int cevsph = 14;
		final int cevegh = 15;
		final int cevfor = 16;

		final int cevscl = 17;
		final int cevzgi = 18;
		final int cevzgo = 19;
		final int cevste = 20;
		final int cevmrs = 21;
		final int cevpin = 22;
		final int cevinq = 23;
		final int cevfol = 24;
	};
//	cindex_
//	#ifdef INIT
//	= { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 
//	   18, 19, 20, 21, 22, 23, 24 }
//	#endif
//	   ;

	public cindex_ cindex_1 = new cindex_();

	public class advs_
	{
		int alnt, aroom[] = new int[4], ascore[] = new int[4], avehic[] = new int[4],
				aobj[] = new int[4], aactio[] = new int[4], astren[] = new int[4],
				aflag[] = new int[4];
	};
;
	public advs_ advs_1 = new advs_();
//	#define eqa ((int *)&advs_1 + 1)

	public class aflags_
	{
		final int astag = 32768;
	};
//	aflags_
//	#ifdef INIT
//	          = { 32768 }
//	#endif
//	;

	public aflags_ aflags_1 = new aflags_();

	public class aindex_
	{
		final int player = 1;
		final int arobot = 2;
		final int amastr = 3;
	};
//	aindex_
//	#ifdef INIT
//	          = { 1, 2, 3 }
//	#endif
//	;

	public aindex_ aindex_1 = new aindex_();

	public class vindex_
	{
		final int cintw = 1;
		final int deadxw = 2;
		final int frstqw = 3;
		final int inxw = 4;
		final int outxw = 5;
		final int walkiw = 6;
		final int fightw = 7;
		final int foow = 8;
		final int meltw = 101;
		final int readw = 100;
		final int inflaw = 102;
		final int deflaw = 103;
		final int alarmw = 104;
		final int exorcw = 105;
		final int plugw = 106;
		
		final int kickw = 107;
		final int wavew = 108;
		final int raisew = 109;
		final int lowerw = 110;
		final int rubw = 111;
		final int pushw = 112;
		final int untiew = 113;
		final int tiew = 114;
		final int tieupw = 115;
		final int turnw = 116;
		final int breatw = 117;
		final int knockw = 118;
		final int lookw = 119;
		
		final int examiw = 120;
		final int shakew = 121;
		final int movew = 122;
		final int trnonw = 123;
		final int trnofw = 124;
		final int openw = 125;
		final int closew = 126;
		final int findw = 127;
		final int waitw = 128;
		final int spinw = 129;
		final int boardw = 130;
		final int unboaw = 131;
		final int takew = 132;
		
		final int invenw = 133;
		final int fillw = 134;
		final int eatw = 135;
		final int drinkw = 136;
		final int burnw = 137;
		final int mungw = 138;
		final int killw = 139;
		final int attacw = 141;
		final int swingw = 140;
		final int walkw = 142;
		final int tellw = 143;
		final int putw = 144;
		final int dropw = 145;
		
		final int givew = 146;
		final int pourw = 147;
		final int throww = 148;
		final int digw = 89;
		final int leapw = 91;
		final int stayw = 73;
		final int follow = 85;
		final int hellow = 151;
		final int lookiw = 152;
		final int lookuw = 153;
		final int pumpw = 154;
		final int windw = 155;
		final int clmbw = 156;
		final int clmbuw = 157;
		
		final int clmbdw = 158; 
	    final int trntow = 159;
	};
//	vindex_
//	#ifdef INIT
//	= { 1, 2, 3, 4, 5, 6, 7, 8, 101, 100, 102, 103, 104, 105, 106, 
//	   107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 
//	   120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 
//	   133, 134, 135, 136, 137, 138, 139, 141, 140, 142, 143, 144, 145, 
//	   146, 147, 148, 89, 91, 73, 85, 151, 152, 153, 154, 155, 156, 157, 
//	   158, 159 }
//	#endif
//	   ;

	public vindex_ vindex_1 = new vindex_();

	public class findex_
	{
		boolean trollf, cagesf, bucktf, caroff, carozf, lwtidf, domef, glacrf, echof, riddlf, lldf,
				cyclof, magicf, litldf, safef, gnomef, gnodrf, mirrmf, egyptf, onpolf, blabf,
				brieff, superf, buoyf, grunlf, gatef, rainbf, cagetf, empthf, deflaf, glacmf,
				frobzf, endgmf, badlkf, thfenf, singsf, mrpshf, mropnf, wdopnf, mr1f, mr2f, inqstf,
				follwf, spellf, cpoutf, cpushf;
		int btief, binff, rvmnt, rvclr, rvcyc, rvsnd, rvgua, orrug, orcand, ormtch, orlamp, mdir,
				mloc, poleuf, quesno, nqatt, corrct, lcell, pnumb, acell, dcell, cphere;

		public boolean flags(int index)
		{
			switch (index)
			{
				case 0:
					return trollf;
				case 1:
					return cagesf;
				case 2:
					return bucktf;
				case 3:
					return caroff;
				case 4:
					return carozf;
				case 5:
					return lwtidf;
				case 6:
					return domef;
				case 7:
					return glacrf;
				case 8:
					return echof;
				case 9:
					return riddlf;
				case 10:
					return lldf;
				case 11:
					return cyclof;
				case 12:
					return magicf;
				case 13:
					return litldf;
				case 14:
					return safef;
				case 15:
					return gnomef;
				case 16:
					return gnodrf;
				case 17:
					return mirrmf;
				case 18:
					return egyptf;
				case 19:
					return onpolf;
				case 20:
					return blabf;
				case 21:
					return brieff;
				case 22:
					return superf;
				case 23:
					return buoyf;
				case 24:
					return grunlf;
				case 25:
					return gatef;
				case 26:
					return rainbf;
				case 27:
					return cagetf;
				case 28:
					return empthf;
				case 29:
					return deflaf;
				case 30:
					return glacmf;
				case 31:
					return frobzf;
				case 32:
					return endgmf;
				case 33:
					return badlkf;
				case 34:
					return thfenf;
				case 35:
					return singsf;
				case 36:
					return mrpshf;
				case 37:
					return mropnf;
				case 38:
					return wdopnf;
				case 39:
					return mr1f;
				case 40:
					return mr2f;
				case 41:
					return inqstf;
				case 42:
					return follwf;
				case 43:
					return spellf;
				case 44:
					return cpoutf;
				case 45:
					return cpushf;
			}
			throw new RuntimeException("invalid index for flags: " + index);
		}

		public void flags(int index, boolean value)
		{
			switch (index)
			{
				case 0:
					trollf = value;
					return;
				case 1:
					cagesf = value;
					return;
				case 2:
					bucktf = value;
					return;
				case 3:
					caroff = value;
					return;
				case 4:
					carozf = value;
					return;
				case 5:
					lwtidf = value;
					return;
				case 6:
					domef = value;
					return;
				case 7:
					glacrf = value;
					return;
				case 8:
					echof = value;
					return;
				case 9:
					riddlf = value;
					return;
				case 10:
					lldf = value;
					return;
				case 11:
					cyclof = value;
					return;
				case 12:
					magicf = value;
					return;
				case 13:
					litldf = value;
					return;
				case 14:
					safef = value;
					return;
				case 15:
					gnomef = value;
					return;
				case 16:
					gnodrf = value;
					return;
				case 17:
					mirrmf = value;
					return;
				case 18:
					egyptf = value;
					return;
				case 19:
					onpolf = value;
					return;
				case 20:
					blabf = value;
					return;
				case 21:
					brieff = value;
					return;
				case 22:
					superf = value;
					return;
				case 23:
					buoyf = value;
					return;
				case 24:
					grunlf = value;
					return;
				case 25:
					gatef = value;
					return;
				case 26:
					rainbf = value;
					return;
				case 27:
					cagetf = value;
					return;
				case 28:
					empthf = value;
					return;
				case 29:
					deflaf = value;
					return;
				case 30:
					glacmf = value;
					return;
				case 31:
					frobzf = value;
					return;
				case 32:
					endgmf = value;
					return;
				case 33:
					badlkf = value;
					return;
				case 34:
					thfenf = value;
					return;
				case 35:
					singsf = value;
					return;
				case 36:
					mrpshf = value;
					return;
				case 37:
					mropnf = value;
					return;
				case 38:
					wdopnf = value;
					return;
				case 39:
					mr1f = value;
					return;
				case 40:
					mr2f = value;
					return;
				case 41:
					inqstf = value;
					return;
				case 42:
					follwf = value;
					return;
				case 43:
					spellf = value;
					return;
				case 44:
					cpoutf = value;
					return;
				case 45:
					cpushf = value;
					return;
			}
			throw new RuntimeException("invalid index for flags: " + index);
		}

		public int switch_(int index)
		{
			switch (index)
			{
				case 0:
					return btief;
				case 1:
					return binff;
				case 2:
					return rvmnt;
				case 3:
					return rvclr;
				case 4:
					return rvcyc;
				case 5:
					return rvsnd;
				case 6:
					return rvgua;
				case 7:
					return orrug;
				case 8:
					return orcand;
				case 9:
					return ormtch;
				case 10:
					return orlamp;
				case 11:
					return mdir;
				case 12:
					return mloc;
				case 13:
					return poleuf;
				case 14:
					return quesno;
				case 15:
					return nqatt;
				case 16:
					return corrct;
				case 17:
					return lcell;
				case 18:
					return pnumb;
				case 19:
					return acell;
				case 20:
					return dcell;
				case 21:
					return cphere;

			};
			throw new RuntimeException("invalid index for switch_: " + index);

		}

		public void switch_(int index, int value)
		{
			switch (index)
			{
				case 0:
					btief = value;
					return;
				case 1:
					binff = value;
					return;
				case 2:
					rvmnt = value;
					return;
				case 3:
					rvclr = value;
					return;
				case 4:
					rvcyc = value;
					return;
				case 5:
					rvsnd = value;
					return;
				case 6:
					rvgua = value;
					return;
				case 7:
					orrug = value;
					return;
				case 8:
					orcand = value;
					return;
				case 9:
					ormtch = value;
					return;
				case 10:
					orlamp = value;
					return;
				case 11:
					mdir = value;
					return;
				case 12:
					mloc = value;
					return;
				case 13:
					poleuf = value;
					return;
				case 14:
					quesno = value;
					return;
				case 15:
					nqatt = value;
					return;
				case 16:
					corrct = value;
					return;
				case 17:
					lcell = value;
					return;
				case 18:
					pnumb = value;
					return;
				case 19:
					acell = value;
					return;
				case 20:
					dcell = value;
					return;
				case 21:
					cphere = value;
					return;

			}
			throw new RuntimeException("invalid index for switch_: " + index);

		}
	};
	

	public findex_ findex_1 = new findex_();
//	#define flags ((boolean *)&findex_1)
//	#define switch_ ((int *)&findex_1 + 46)

	public class debug_
	{
	   int dbgflg, prsflg, gdtflg;
	};


	public debug_ debug_1 = new debug_();

	public class hack_
	{
	   int thfpos;
	   boolean thfflg, thfact, swdact;
	   int swdsta;
	};


	public hack_ hack_1 = new hack_();

	public class vill_
	{
	   int vlnt, villns[] = new int[4], vprob[] = new int[4], vopps[] = new int[4], vbest[] = new int[4], vmelee[] = new int[4];
	};


	public vill_ vill_1 = new vill_();
//	#define eqv ((int *)&vill_1 + 1)

	public class state_
	{
	   int moves, deaths, rwscor, mxscor, mxload, ltshft, bloc, mungrm, hs, 
	           egscor, egmxsc;
	};


	public state_ state_1 = new state_();

	public class curxt_
	{
	   int xtype, xroom1, xstrng, xactio, xobj;
	   
	   public int xflag() { return xobj; };
	   public void xflag(int val) { xobj = val; } 
	};


	public curxt_ curxt_1 = new curxt_();
//	#define xflag ((int *)&curxt_1 + 4)
	

	public class xpars_
	{
		final int xrmask = 255;
		final int xdmask = 31744;
		final int xfmask = 3;
		final int xfshft = 256;
		final int xashft = 256;
		final int xelnt[] = new int[] { 1, 2, 3, 3 };
		final int xnorm = 1;
		final int xno = 2;
		final int xcond = 3;
		final int xdoor = 4;
		final int xlflag = 32768;
	};
//	xpars_
//	#ifdef INIT
//	         = { 255, 31744, 3, 256, 256, { 1, 2, 3, 3 }, 1, 2, 3, 4, 32768 }
//	#endif
//	;

	public xpars_ xpars_1 = new xpars_();

	public class star_
	{
	   int mbase, strbit;
	};


	public star_ star_1 = new star_();

	public class input_
	{
	   int inlnt;
	   char[] inbuf = new char[78];
	};


	public input_ input_1 = new input_();

	public class screen_
	{
		int fromdr = 0;
		int scolrm = 0;
		int scolac = 0;
		int[] scoldr = new int[] { 1024, 153, 5120, 154, 3072, 152, 7168, 151 };
		int[] scolwl = new int[]{ 151, 207, 3072, 152, 208, 7168, 153, 206, 5120, 154, 205, 1024 };
	};
//	screen_
//	#ifdef INIT
//	          = { 0, 0, 0, { 1024, 153, 5120, 154, 3072, 152, 7168, 151 },
//	            { 151, 207, 3072, 152, 208, 7168, 153, 206, 5120, 154, 205, 1024 } }
//	#endif
//	      ;

	public screen_ screen_1 = new screen_();

	public class rmsg_ {
	   int mlnt;
	   long mrloc;
	   int[] rtext = new int[1050];
	};


	public rmsg_ rmsg_1 = new rmsg_();

	public class vers_ {
	   int vmaj = 2;
	   int vmin = 7;
	   int vedit = 'A';
	};
//	vers_
//	#ifdef INIT
//	= { 2, 7, 'A' }
//	#endif
//	;

	public vers_ vers_1 = new vers_();

	public class time_
	{
	   int pltime;
	   int[] shour = new int[1];
	   int[] smin = new int[1];
	   int[] ssec = new int[1];
	};


	public time_ time_1 = new time_();

	public class hyper_ {
	   final int hfactr = 500;
	};
//	hyper_
//	#ifdef INIT
//	         = { 500 }
//	#endif
//	;

	public hyper_ hyper_1 = new hyper_();

	public class exits_
	{
	   int xlnt, travel[] = new int[900];
	};


	public exits_ exits_1 = new exits_();

	public class puzzle_ {
	   final int cpdr[] = new int[]{ 1024, -8, 2048, -7, 3072, 1, 4096, 9, 5120, 8, 6144, 7, 
			      7168, -1, 8192, -9 };
	   final int cpwl[] = new int[]{ 205, -8, 206, 8, 207, 1, 208, -1 };
	   final int cpvec[] = new int[]{ 1,  1,  1,  1,  1,  1, 1, 1,
			      1,  0, -1,  0,  0, -1, 0, 1,
			      1, -1,  0,  1,  0, -2, 0, 1,
			      1,  0,  0,  0,  0,  1, 0, 1,
			      1, -3,  0,  0, -1, -1, 0, 1,
			      1,  0,  0, -1,  0,  0, 0, 1,
			      1,  1,  1,  0,  0,  0, 1, 1,
			      1,  1,  1,  1,  1,  1, 1, 1 };
	};
//	puzzle_
//	#ifdef INIT
//	= { { 1024, -8, 2048, -7, 3072, 1, 4096, 9, 5120, 8, 6144, 7, 
//	      7168, -1, 8192, -9 },
//	    { 205, -8, 206, 8, 207, 1, 208, -1 },
//	    { 1,  1,  1,  1,  1,  1, 1, 1,
//	      1,  0, -1,  0,  0, -1, 0, 1,
//	      1, -1,  0,  1,  0, -2, 0, 1,
//	      1,  0,  0,  0,  0,  1, 0, 1,
//	      1, -3,  0,  0, -1, -1, 0, 1,
//	      1,  0,  0, -1,  0,  0, 0, 1,
//	      1,  1,  1,  0,  0,  0, 1, 1,
//	      1,  1,  1,  1,  1,  1, 1, 1 } }
//	#endif
//	      ;

	public puzzle_ puzzle_1 = new puzzle_();

	public class bats_ {
	   final int[] batdrp = new int[]{ 66, 67, 68, 69, 70, 71, 72, 65, 73 };
	};
//	bats_
//	#ifdef INIT
//	        = { 66, 67, 68, 69, 70, 71, 72, 65, 73 }
//	#endif
//	;

	public bats_ bats_1 = new bats_();

//	#endif

}
