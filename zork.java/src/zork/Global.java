package zork;

import java.io.RandomAccessFile;

public class Global
{
	
	// MISCELLANEOUS VARIABLES
	public int MBASE = 0, STRBIT = 0;
	public int VMAJ = 0, VMIN = 0;
	public char VEDIT = ' ';
	public int[] BATDRP = new int[9];
	public int HFACTR = 0;
	public int PLTIME = 0;
	public int[] SHOUR = new int[] { 0 };
	public int[] SMIN = new int[] { 0 };
	public int[] SSEC = new int[] { 0 };
	public boolean DEBUG = false;

	/** advers.h **/

	// ADVENTURERS //
	public int ALNT = 0;
	public int[] AROOM = new int[4], ASCORE = new int[4], AVEHIC = new int[4],
			AOBJ = new int[4], AACTIO = new int[4], ASTREN = new int[4], AFLAG = new int[4];
//	INTEGER EQA[4,7]
//	EQUIVALENCE (AROOM, EQA)

	public int ASTAG = 0;

	public int PLAYER = 0, AROBOT = 0, AMASTR = 0;

	/** clock.h **/

	// CLOCK INTERRUPTS //
	public int CLNT = 0;
	public int[] CTICK = new int[25], CACTIO = new int[25];
	public boolean[] CFLAG = new boolean[25];

	public int CEVCUR = 0, CEVMNT = 0, CEVLNT = 0, CEVMAT = 0, CEVCND = 0, CEVBAL = 0,
			CEVBRN = 0, CEVFUS = 0, CEVLED = 0, CEVSAF = 0, CEVVLG = 0, CEVGNO = 0, CEVBUC = 0,
			CEVSPH = 0, CEVEGH = 0, CEVFOR = 0, CEVSCL = 0, CEVZGI = 0, CEVZGO = 0, CEVSTE = 0,
			CEVMRS = 0, CEVPIN = 0, CEVINQ = 0, CEVFOL = 0;
//	INTEGER EQC(25,2)
//	EQUIVALENCE (CTICK, EQC)

	/** curxt.h **/

	// CURRENT EXITS //

	public int XTYPE = 0, XROOM1 = 0, XSTRNG = 0, XACTIO = 0, XOBJ = 0;
//		EQUIVALENCE (XFLAG,XOBJ)

	/** debug.h **/
	public int DBGFLG = 0, PRSFLG = 0, GDTFLG = 0;
	public boolean DFLAG = false;

	/** exits.h **/

	// EXITS //
	public int XLNT = 0;
	public int[] TRAVEL = new int[900];

	/** flags.h **/

	// FLAGS //
	public boolean TROLLF = false, CAGESF = false, BUCKTF = false, CAROFF = false,
			CAROZF = false, LWTIDF = false, DOMEF = false, GLACRF = false, ECHOF = false,
			RIDDLF = false, LLDF = false, CYCLOF = false, MAGICF = false, LITLDF = false,
			SAFEF = false, GNOMEF = false, GNODRF = false, MIRRMF = false, EGYPTF = false,
			ONPOLF = false, BLABF = false, BRIEFF = false, SUPERF = false, BUOYF = false,
			GRUNLF = false, GATEF = false, RAINBF = false, CAGETF = false, EMPTHF = false,
			DEFLAF = false, GLACMF = false, FROBZF = false, ENDGMF = false, BADLKF = false,
			THFENF = false, SINGSF = false, MRPSHF = false, MROPNF = false, WDOPNF = false,
			MR1F = false, MR2F = false, INQSTF = false, FOLLWF = false, SPELLF = false,
			CPOUTF = false, CPUSHF = false;
	public int BTIEF = 0, BINFF = 0;
	public int RVMNT = 0, RVCLR = 0, RVCYC = 0, RVSND = 0, RVGUA = 0;
	public int ORRUG = 0, ORCAND = 0, ORMTCH = 0, ORLAMP = 0;
	public int MDIR = 0, MLOC = 0, POLEUF = 0;
	public int QUESNO = 0, NQATT = 0, CORRCT = 0;
	public int LCELL = 0, PNUMB = 0, ACELL = 0, DCELL = 0, CPHERE = 0;

//	LOGICAL FLAGS[46]
//	EQUIVALENCE (FLAGS[1],TROLLF)
//	INTEGER SWITCH[22]
//	EQUIVALENCE (SWITCH[1], BTIEF)

	/** gamestat.h **/

	// GAME STATE //
	public int WINNER = 0, HERE = 0;
	public boolean TELFLG = false;

	/** io.h **/

	// I/O VARIABLES //
	public int INLNT;
	public char[] INBUF = new char[78];
	public int INPCH = 0, OUTCH = 0;
	public RandomAccessFile DBCH = null;

	/** mindex.h **/

	// MESSAGE INDEX //
	public int MLNT = 0;
	public int[] RTEXT = new int[1820];

	/** objects.h **/

	// OBJECTS //
	public int OLNT = 0;
	public int[] ODESC1 = new int[220], ODESC2 = new int[220], ODESCO = new int[220],
			OACTIO = new int[220], OFLAG1 = new int[220], OFLAG2 = new int[220],
			OFVAL = new int[220], OTVAL = new int[220], OSIZE = new int[220], OCAPAC = new int[220],
			OROOM = new int[220], OADV = new int[220], OCAN = new int[220], OREAD = new int[220];
//	INTEGER EQO(220,14)
//	EQUIVALENCE (ODESC1, EQO)

	public int R2LNT;
	public int[] OROOM2 = new int[20], RROOM2 = new int[20];

	/** oflags.h **/

	public int VISIBT = 0, READBT = 0, TAKEBT = 0, DOORBT = 0, TRANBT = 0, FOODBT = 0,
			NDSCBT = 0, DRNKBT = 0, CONTBT = 0, LITEBT = 0, VICTBT = 0, BURNBT = 0, FLAMBT = 0,
			TOOLBT = 0, TURNBT = 0, ONBT = 0;
	public int FINDBT = 0, SLEPBT = 0, SCRDBT = 0, TIEBT = 0, CLMBBT = 0, ACTRBT = 0,
			WEAPBT = 0, FITEBT = 0, VILLBT = 0, STAGBT = 0, TRYBT = 0, NOCHBT = 0, OPENBT = 0,
			TCHBT = 0, VEHBT = 0, SCHBT = 0;

	/** oindex.h **/

	public int GARLI = 0, FOOD = 0, GUNK = 0, COAL = 0, MACHI = 0, DIAMO = 0, TCASE = 0,
			BOTTL = 0;
	public int WATER = 0, ROPE = 0, KNIFE = 0, SWORD = 0, LAMP = 0, BLAMP = 0, RUG = 0;
	public int LEAVE = 0, TROLL = 0, AXE = 0;
	public int RKNIF = 0, KEYS = 0, ICE = 0, BAR = 0;
	public int COFFI = 0, TORCH = 0, TBASK = 0, FBASK = 0, IRBOX = 0;
	public int GHOST = 0, TRUNK = 0, BELL = 0, BOOK = 0, CANDL = 0;
	public int MATCH = 0, TUBE = 0, PUTTY = 0, WRENC = 0, SCREW = 0, CYCLO = 0, CHALI = 0;
	public int THIEF = 0, STILL = 0, WINDO = 0, GRATE = 0, DOOR = 0;
	public int HPOLE = 0, LEAK = 0, RBUTT = 0, RAILI = 0;
	public int POT = 0, STATU = 0, IBOAT = 0, DBOAT = 0, PUMP = 0, RBOAT = 0;
	public int STICK = 0, BUOY = 0, SHOVE = 0, BALLO = 0, RECEP = 0, GUANO = 0;
	public int BROPE = 0, HOOK1 = 0, HOOK2 = 0, SAFE = 0, SSLOT = 0, BRICK = 0, FUSE = 0;
	public int GNOME = 0, BLABE = 0, DBALL = 0, TOMB = 0;
	public int LCASE = 0, CAGE = 0, RCAGE = 0, SPHER = 0, SQBUT = 0;
	public int FLASK = 0, POOL = 0, SAFFR = 0, BUCKE = 0, ECAKE = 0, ORICE = 0, RDICE = 0,
			BLICE = 0;
	public int ROBOT = 0, FTREE = 0, BILLS = 0, PORTR = 0, SCOL = 0, ZGNOM = 0;
	public int EGG = 0, BEGG = 0, BAUBL = 0, CANAR = 0, BCANA = 0;
	public int YLWAL = 0, RDWAL = 0, PINDR = 0, RBEAM = 0;
	public int ODOOR = 0, QDOOR = 0, CDOOR = 0, NUM1 = 0, NUM8 = 0;
	public int WARNI = 0, CSLIT = 0, GCARD = 0, STLDR = 0;
	public int HANDS = 0, WALL = 0, LUNGS = 0, SAILO = 0, AVIAT = 0, TEETH = 0;
	public int ITOBJ = 0, EVERY = 0, VALUA = 0, OPLAY = 0, WNORT = 0, GWATE = 0, MASTER = 0;

	/** parser.h **/

	// PARSER OUTPUT //
	public int PRSA = 0, PRSI = 0, PRSO = 0;
	public boolean PRSWON = false;
	public int PRSCON;

	// PARSER STATE //
	public int OFLAG = 0, OACT = 0, OSLOT = 0, OPREP = 0, ONAME = 0;
// 	INTEGER ORP[5]
// 	EQUIVALENCE (OFLAG, ORP)

	public int LASTIT = 0;

	public int ACT = 0, O1 = 0, O2 = 0, P1 = 0, P2 = 0;
// 	INTEGER OBJVEC[2],PRPVEC[2],PVEC[5]
// 	EQUIVALENCE (OBJVEC[1],O1),(PRPVEC[1],P1),(PVEC,ACT)

	public int VFLAG = 0, DOBJ = 0, DFL1 = 0, DFL2 = 0, DFW1 = 0, DFW2 = 0, IOBJ = 0,
			IFL1 = 0, IFL2 = 0, IFW1 = 0, IFW2 = 0;
// 	INTEGER SYN[11]
// 	EQUIVALENCE (VFLAG, SYN)

	public int SDIR = 0, SIND = 0, SSTD = 0, SFLIP = 0, SDRIV = 0, SVMASK = 0;

	public int VABIT = 0, VRBIT = 0, VTBIT = 0, VCBIT = 0, VEBIT = 0, VFBIT = 0, VPMASK = 0;

	/** puzzle.h **/

	// PUZZLE ROOM STATE //
	public int[] CPDR = new int[16], CPWL = new int[8], CPVEC = new int[64];

	/** rflag.h **/

	public int RSEEN = 0, RLIGHT = 0, RLAND = 0, RWATER = 0, RAIR = 0, RSACRD = 0, RFILL = 0,
			RMUNG = 0, RBUCK = 0, RHOUSE = 0, RNWALL = 0, REND = 0;

	/** rindex.h **/

	public int WHOUS = 0, LROOM = 0, CELLA = 0;
	public int MTROL = 0, MAZE1 = 0;
	public int MGRAT = 0, MAZ15 = 0;
	public int FORE1 = 0, FORE3 = 0, CLEAR = 0, RESER = 0;
	public int STREA = 0, EGYPT = 0, ECHOR = 0;
	public int TSHAF = 0;
	public int BSHAF = 0, MMACH = 0, DOME = 0, MTORC = 0;
	public int CAROU = 0;
	public int RIDDL = 0, LLD2 = 0, TEMP1 = 0, TEMP2 = 0, MAINT = 0;
	public int BLROO = 0, TREAS = 0, RIVR1 = 0, RIVR2 = 0, RIVR3 = 0, MCYCL = 0;
	public int RIVR4 = 0, RIVR5 = 0, FCHMP = 0, FALLS = 0, MBARR = 0;
	public int MRAIN = 0, POG = 0, VLBOT = 0, VAIR1 = 0, VAIR2 = 0, VAIR3 = 0, VAIR4 = 0;
	public int LEDG2 = 0, LEDG3 = 0, LEDG4 = 0, MSAFE = 0, CAGER = 0;
	public int CAGED = 0, TWELL = 0, BWELL = 0, ALICE = 0, ALISM = 0, ALITR = 0;
	public int MTREE = 0, BKENT = 0, BKVW = 0, BKTWI = 0, BKVAU = 0, BKBOX = 0;
	public int CRYPT = 0, TSTRS = 0, MRANT = 0, MREYE = 0;
	public int MRA = 0, MRB = 0, MRC = 0, MRG = 0, MRD = 0, FDOOR = 0;
	public int MRAE = 0, MRCE = 0, MRCW = 0, MRGE = 0, MRGW = 0, MRDW = 0, INMIR = 0;
	public int SCORR = 0, NCORR = 0, PARAP = 0, CELL = 0, PCELL = 0, NCELL = 0;
	public int CPANT = 0, CPOUT = 0, CPUZZ = 0;

	/** rooms.h **/

	// ROOMS //
	public int RLNT = 0, RDESC2 = 0;
	public int[] RDESC1 = new int[200], REXIT = new int[200], RACTIO = new int[200],
			RVAL = new int[200], RFLAG = new int[200];
// 		INTEGER RRAND[200]
// 		EQUIVALENCE (RVAL,RRAND)
// 		INTEGER EQR(200,5)
// 		EQUIVALENCE (RDESC1, EQR)

	/** screen.h **/

	// SCREEN OF LIGHT //
	public int FROMDR = 0, SCOLRM = 0, SCOLAC = 0;
	public int[] SCOLDR = new int[8], SCOLWL = new int[12];

	/** state.h **/
	public int MOVES = 0, DEATHS = 0, RWSCOR = 0, MXSCOR = 0, MXLOAD = 0, LTSHFT = 0,
			BLOC = 0, MUNGRM = 0, HS = 0, EGSCOR = 0, EGMXSC = 0;

	/** verbs.h **/

	// VERBS //
	public int CINTW = 0, DEADXW = 0, FRSTQW = 0, INXW = 0, OUTXW = 0;
	public int WALKIW = 0, FIGHTW = 0, FOOW = 0;
	public int MELTW = 0, READW = 0, INFLAW = 0, DEFLAW = 0, ALARMW = 0, EXORCW = 0;
	public int PLUGW = 0, KICKW = 0, WAVEW = 0, RAISEW = 0, LOWERW = 0, RUBW = 0;
	public int PUSHW = 0, UNTIEW = 0, TIEW = 0, TIEUPW = 0, TURNW = 0, BREATW = 0;
	public int KNOCKW = 0, LOOKW = 0, EXAMIW = 0, SHAKEW = 0, MOVEW = 0, TRNONW = 0,
			TRNOFW = 0;
	public int OPENW = 0, CLOSEW = 0, FINDW = 0, WAITW = 0, SPINW = 0, BOARDW = 0,
			UNBOAW = 0, TAKEW = 0;
	public int INVENW = 0, FILLW = 0, EATW = 0, DRINKW = 0, BURNW = 0;
	public int MUNGW = 0, KILLW = 0, ATTACW = 0, SWINGW = 0;
	public int WALKW = 0, TELLW = 0, PUTW = 0, DROPW = 0, GIVEW = 0, POURW = 0, THROWW = 0;
	public int DIGW = 0, LEAPW = 0, STAYW = 0, FOLLOW = 0;
	public int HELLOW = 0, LOOKIW = 0, LOOKUW = 0, PUMPW = 0, WINDW = 0;
	public int CLMBW = 0, CLMBUW = 0, CLMBDW = 0, TRNTOW = 0;

	/** villains.h **/

	// VILLAINS AND DEMONS //
	public int THFPOS = 0;
	public boolean THFFLG = false, THFACT = false, SWDACT = false;
	public int SWDSTA = 0;

	public int VLNT = 0;
	public int[] VILLNS = new int[4], VPROB = new int[4], VOPPS = new int[4],
			VBEST = new int[4], VMELEE = new int[4];

//	INTEGER EQV(4,5)
//	EQUIVALENCE (VILLNS, EQV)

	/** vocab.h **/

	// VOCABULARIES //
	public int[] BVOC = new int[20];
	public int[] PVOC = new int[45];
	public int[] DVOC = new int[75];
//	INTEGER AVOC[450]
	public int[] AVOC1 = new int[184], AVOC2 = new int[114], AVOC3 = new int[106];
	public int AVOCND = 0;
//	INTEGER VVOC[950]
	public int[] VVOC1 = new int[92], VVOC1A = new int[108], VVOC1B = new int[38],
			VVOC2 = new int[104], VVOC3 = new int[136], VVOC4 = new int[116], VVOC5 = new int[134],
			VVOC6 = new int[117], VVOC7 = new int[89];
	public int VVOCND = 0;
//	INTEGER OVOC[1050]
	public int[] OVOC1 = new int[159], OVOC2 = new int[144], OVOC3 = new int[150],
			OVOC4 = new int[128], OVOC5 = new int[111], OVOC6 = new int[104], OVOC6A = new int[97],
			OVOC7 = new int[127];
	public int OVOCND = 0;

//		EQUIVALENCE (VVOC[1],VVOC1[1])
//		EQUIVALENCE (AVOC[1],AVOC1[1])
//		EQUIVALENCE (OVOC[1],OVOC1[1])

	/** xpars.h **/
	public int XRMASK = 0, XDMASK = 0, XFMASK = 0, XFSHFT = 0, XASHFT = 0;
	public int[] XELNT = new int[4];
	public int XNORM = 0, XNO = 0, XCOND = 0, XDOOR = 0, XLFLAG = 0;

	/** xsrch.h **/
	public int XMIN = 0, XMAX = 0, XDOWN = 0, XUP = 0, XNORTH = 0, XSOUTH = 0, XENTER = 0,
			XEXIT = 0, XEAST = 0, XWEST = 0;
}
