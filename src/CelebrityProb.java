// Java program to find celebrity
// in the given Matrix of people
// Code by Sparsh_cbs

import java.io.*;

class CelebrityProb {
	public static void main(String[] args)
	{
		int[][] M = { { 0, 0, 0, 1 },
					{ 0, 0, 0, 1 },
					{ 0, 0, 0, 1 },
					{ 0, 0, 0, 0 } };

		int celebIdx = celebrity(M, 4);

		if (celebIdx == -1)
			System.out.println("No celebrity found!");
		else {
			System.out.println(
				"0-based celebrity index is : " + celebIdx);
		}
	}
	public static int celebrity(int M[][], int n)
	{
		// This function returns the celebrity
		// index 0-based (if any)

		int i = 0, j = n - 1;
		/* j is row and i is col */
		while (i < j) {
			System.out.println("*** start **  i = " + i + " j = " +j  + " M[j][i] = " + M[j][i]);
			if (M[j][i] == 1) // j knows i
				j--;
			else // i knows j
				i++;
			System.out.println("*** end ** i = " + i + " j = " +j  + " M[j][i] = " + M[j][i]);
		}
		// i points to our celebrity candidate

		int candidate = i;
		System.out.println(" candidate = " + candidate);

		// Now, all that is left is to check that whether
		// the candidate is actually a celebrity i.e: he is
		// known by everyone but he knows no one
		for (i = 0; i < n; i++) {
			if (i != candidate) {
				if (M[i][candidate] == 0
					|| M[candidate][i] == 1)
					return -1;
			}
		}
		// if we reach here this means that the candidate
		// is really a celebrity
		return candidate;
	}
}
