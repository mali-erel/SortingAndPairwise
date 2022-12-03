package Q2;

//
// Title: PART 2
// Author: Mehmet Ali EREL
// ID: 11260275756
// Section: 4
// Assignment: 2
//

import java.util.Scanner;

/*myLib CLASS
 * This class helps me to contain and check every 2 pair of the given array.
 */
class myLib {
	int num1, num2, diff, sum;

	public myLib(int n1, int n2, int d, int sum) {
		
		this.num1 = n1;
		this.num2 = n2;
		this.diff = d;
		this.sum = sum;
	}
}

/*
 * METHOD CLASS The only reason it's exists to select the wanted algorithm and
 * proceed with given code.
 */
class Method {

	public static void Method(Integer[] arr, String a) {
		// TODO Auto-generated method stub
		Long[] times = new Long[3];
		switch (a) {
		case "Selection":

			for (int j = 0; j < 3; j++) {
				Long t1 = System.currentTimeMillis();
				Selection.sort(arr);
				Long t2 = System.currentTimeMillis();
				times[j] = t2 - t1;
			}

			Insertion.sort(times);
			System.out.println("Time: " + times[1]);

			break;
		case "Insertion":

			for (int j = 0; j < 3; j++) {
				Long t1 = System.currentTimeMillis();
				Selection.sort(arr);
				Long t2 = System.currentTimeMillis();
				times[j] = t2 - t1;
			}

			Insertion.sort(times);
			System.out.println("Time: " + times[1]);

			break;
		case "Merge":

			for (int j = 0; j < 3; j++) {
				Long t1 = System.currentTimeMillis();
				Merge.sort(arr);
				Long t2 = System.currentTimeMillis();
				times[j] = t2 - t1;
			}

			Insertion.sort(times);
			System.out.println("Time: " + times[1]);

			break;
		case "Quick":

			for (int j = 0; j < 3; j++) {
				Long t1 = System.currentTimeMillis();
				Quick.sort(arr);
				Long t2 = System.currentTimeMillis();
				times[j] = t2 - t1;
			}

			Insertion.sort(times);
			StdOut.println("Time: " + times[1] + "\n");

			break;
		default:
			StdOut.print("\nNot Valid!\n");
		}
	}

}

public class HW2_Q2 {
	/*
	 * pairwiseDifference:
	 * 
	 * Given array sorted. As required in instruction if 2 pairs' differences are
	 * same then choose the smallest of the sums. So sorting helps on. By using
	 * myLib class array elements are paring and calculating their differences and
	 * sums.
	 * 
	 */
	public static void pairwiseDifference(Integer[] arr) {
		Insertion.sort(arr);
		arr.toString();
		myLib[] obj = new myLib[arr.length - 1];
		StdOut.println("\nAfter sort : ");

		for (Integer x : arr) {
			StdOut.print(x + " ");
		}

		StdOut.println();

		// Making and adding myLib objects to myLib[] array.
		for (int i = 0, j = 0; i < arr.length - 1; i = i + 1, j++) {
			StdOut.print(i + " " + (j + 1) + " ");
			int diff = arr[i + 1] - arr[i];
			obj[j] = new myLib(arr[i], arr[j + 1], diff, (arr[i] + arr[i + 1]));
		}

		StdOut.println();

		for (myLib x : obj) {
			StdOut.print("\n" + x.num1 + " " + x.num2);
		}

		// Initializing the values.
		int minDiff = obj[0].diff;
		int x1 = obj[0].num1;
		int x2 = obj[0].num2;
		int min = x1 + x2;

		// Checking every object in myLib array by comparing initialized data above.
		for (myLib x : obj) {

			if (minDiff > x.diff) {
				min = x.sum;
				minDiff = x.diff;
				x1 = x.num1;
				x2 = x.num2;
			}

		}
		StdOut.println("\n" + minDiff + " [" + x1 + " " + x2 + "]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated myLib stub
		Integer[] arr = {113, 23, 1, 109, 4, 102, 7, 105, 100, 107};
//		for (int i = 0; i < 12; i++) {
//			arr[i] = StdRandom.uniformInt(50);
//		}
		StdOut.println("Befor pairwiseDifference : ");
		for (int x : arr) {
			StdOut.print(x + " ");
		}
		StdOut.println();
		pairwiseDifference(arr);

		String[] sortOptions = { "Selection", "Insertion", "Merge", "Quick" };

		Scanner k = new Scanner(System.in);

		Long[] times = new Long[3];

		// uninitialized data to further processes.
		Integer arrRandom[] = null;
		Integer arrAscend[] = null;
		Integer arrDescend[] = null;

		StdOut.println("Enter a seed to create random generated values :\n");
		int seed = k.nextInt();
		StdOut.println("Input size :\n");
		int size = k.nextInt();
		// arrRandom initialized by SortingAlgorithmTester method randomizer.
		arrRandom = SortingAlgorithmTester.randomizer(seed, size);
		arrAscend = arrRandom;
		Insertion.sort(arrAscend);
		arrDescend = arrRandom;
		Insertion.sortRev(arrDescend);

		boolean check = true;
		while (check) {
			StdOut.println("\nEnter the sort you want to use:\n");
			String option = k.next();

			if (option.equals(sortOptions[0]) || option.equals(sortOptions[1]) || option.equals(sortOptions[2])
					|| option.equals(sortOptions[3])) {
				StdOut.println("Random");
				Method.Method(arrRandom, option);
				StdOut.println("Ascending");
				Method.Method(arrAscend, option);
				StdOut.println("Descending");
				Method.Method(arrDescend, option);
			} else if (option.equals("exit")) {
				check = false;
			} else {
				StdOut.println("Enter a valid sorting algorithm");
			}
		}

	}

}
