public class MathMagic {
	/******************************************************************************/

	/*
	 * Juan: this is part of some code I have previously released under the BSD
	 * 2-clause license - so feel free to use it for the Project Euler problems.
	 * You might want to convert it to Java for your purposes - with C99 types,
	 * an 'unsigned long' is at least 32 bits, and 'long long' at least 64 bits
	 * - the latter is required to hold multiplications.
	 * 
	 * The function returns (0) if (n) (where: 3 < n < 2**32; n in odd) fails
	 * the a-SPRP test, for a given (a) (where: 2 <= a <= n - 2). Otherwise,
	 * return a non-zero (i.e., 'true') value, which means (n) has passed the
	 * a-SPRP test, though it may still be a composite.
	 */

	/* Brett Hale. brettyhale@gmail.c0m *//*
										 * (https://code.google.com/p/mrtab/)
										 * 
										 * /*************************************
										 * *
										 * *************************************
										 * **
										 */

	static boolean sprp(long n, long a) {
		long m, s, r, y, j;

		/* assert(n > 3 && (n & 0x1) == 1); */
		/* assert(a > 1 && a < (n - 1)); *//* (1 < a < n - 1) */

		for (m = n - 1, s = 1; (m & (1 << s)) == 0; s++)
			;
		r = m >> s; /* r, s s.t. 2^s * r = n - 1, r in odd(N). */

		{
			long u = 1, w = a;

			while (r != 0) /* right-to-left exponentiation: */
			{
				if ((r & 0x1) != 0)
					u = (u * w) % n; /* (mul-rdx) */

				if ((r >>= 1) != 0)
					w = (w * w) % n; /* (sqr-rdx) */
			}

			y = (long) u;
		}

		if (y == 1 || y == m) /* (n) is a SPRP base (a): */
			return (true);

		for (j = 1; j < s && y != m; j++) {
			long u = y;
			u = (u * u) % n; /* (sqr-rdx) */

			if ((y = (long) u) == 1) /* (a) is a witness: */
				return (false);
		}

		return (y == m); /* (n) is a SPRP base (a), iff: (y = n - 1). */
	}
	/******************************************************************************/
}
