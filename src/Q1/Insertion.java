package Q1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Insertion {

	// STEP 2.1:

	public static void sortRev(Comparable[] a) {
		int N = a.length;
		for (int i = N - 1; i > 0; i--) {
			// STEP 2.1 START
			for (int j = i; j > 0; j--) {
				if (less(a[j - 1], a[i])) {
					exch(a, i, j - 1);
				}
				// STEP 2.1 END
			}

		}
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
		}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// STEP 7.3 START
	public static boolean more(Comparable v, Comparable w) {
		return v.compareTo(w) > 0;
	}

	// STEP 7.3 END
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void show(Comparable[] a) { // Print the array, on a single line.
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}
}