package Q1;

public class Quick {
	public static void sort(Route[] a) {
		StdRandom.shuffle(a); // Eliminate dependence on input.
		sort(a, 0, a.length - 1);
	}

	private static void sort(Route[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi); // Partition (see page 291).
		sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
		sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
	}

	// STEP 7.1 START
	public static void sortRev(Route[] a) {
		StdRandom.shuffle(a); // Eliminate dependence on input.
		sortRev(a, 0, a.length - 1);
	}

	private static void sortRev(Route[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partitionRev(a, lo, hi); // Partition (see page 291).
		sortRev(a, lo, j - 1); // Sort left part a[lo .. j-1].
		sortRev(a, j + 1, hi); // Sort right part a[j+1 .. hi].
	}

	// STEP 7.1 END

	// STEP 8.1 START
	public static void sortDepth(Route[] a, int depth) {
		StdRandom.shuffle(a); // Eliminate dependence on input.

		sortDepth(a, 0, depth);
	}

	private static void sortDepth(Route[] a, int lo, int depth) {
		if (depth <= 0) {
			Merge.sort(a);
			return;
		}
		int j = partitionRev(a, lo, a.length - 1); // Partition (see page 291).
		sortDepth(a, j - 1, depth - 1); // Sort left part a[lo .. j-1].
		sortDepth(a, j, depth - 1); // Sort right part a[j+1 .. hi].
	}

	// STEP 8.1 END

	private static int partition(Route[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo, j = hi + 1; // left and right scan indices
		Route v = a[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	// STEP 7.2 START
	private static int partitionRev(Route[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo, j = hi + 1; // left and right scan indices
		Route v = a[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			// ADDED more METHOD FOR COMPARATEION YOU CAN CHECK THE helpers.java
			// IMPLEMENTATION
			while (more(a[++i], v))
				if (i == hi)
					break;
			while (more(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	// STEP 7.2 END

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
