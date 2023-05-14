package util;

import java.util.Date;

public class Random
{

	private static boolean randomSet = false;
	private static long nextRand[] = new long[33];
	public static long max_rand = (long) Math.pow(2, 31) - 1;

	private static void shiftNext()
	{
		for (int j = 0; j < 32; j++)
		{
			nextRand[j] = nextRand[j + 1];
		}

	}

	public static void srand(int seed)
	{

		if (seed == 0)
			seed = 1;

		nextRand[0] = seed;

		for (int i = 1; i < 31; i++)
		{
			nextRand[i] = (16807L * nextRand[i - 1]) % 2147483647;
			if (nextRand[i] < 0)
			{
				nextRand[i] += 2147483647;
			}
		}

		for (int i = 0; i < 3; i++)
		{
			nextRand[31] = nextRand[0];
			shiftNext();
		}

		for (int i = 0; i < 310; i++)
		{
			nextRand[31] = nextRand[0] + nextRand[28];
			shiftNext();
		}
	}

	public static long randint()
	{
		initRand(1, false);
		nextRand[31] = nextRand[0] + nextRand[28];
		long result = (((int) nextRand[31] & 0xffffffffl) >> 1);

		shiftNext();
		return result;
	}

	public static double rand()
	{
		double value = (double) randint();		
		value = value / (double)max_rand;
		return value;
	}

	public static void initRand(int seed, boolean useRandom)
	{
		if (!randomSet)
		{
			if (useRandom)
			{
				seed = (int) new Date().getTime();
			}
			srand(seed);
			randomSet = true;
		}
	}

}
