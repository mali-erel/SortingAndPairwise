package Q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW2_Q1 {

	static Integer arr[];
	static Double arr2[];
	static Integer gereksiz[];

	public static void main(String[] args) throws FileNotFoundException {
// open the text file using the In class

		// STEP 1 START:
		String path1 = "integers.txt";

		try {
			int counter = 0;
			Scanner inp = new Scanner(new File(path1));
			arr = new Integer[inp.nextInt()];
			gereksiz = new Integer[arr.length];
			while (inp.hasNextInt()) {
				if (counter != arr.length) {
					arr[counter] = inp.nextInt();
					gereksiz[counter] = arr[counter];
					counter++;
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Nothing found in the given path.");
		}

		// TEXT FILE INTEGER ARRAY
		StdOut.println("Integers are reading from the integers.txt file, the array is:");
		for (Integer x : arr) {
			StdOut.print(x + " ");
		}

		StdOut.println();

		// SHUFFLE INTEGER ARRAY
		StdRandom.shuffle(arr);

//		// SHUFFLED INTEGER ARRAY
//		StdOut.println("Shuffled integer array");
//		for (Integer x : arr) {
//			StdOut.print(x + " ");
//		}

		StdOut.println();

		// INSERTION SORT OF INTEGER ARRAY
		Insertion.sort(arr);

		// PRINT INSERTION SORT OF INTEGER ARRAY
		StdOut.println("The array has been sorted in increasing order by using the insertion sort algorithm:");
		for (Integer x : arr) {
			StdOut.print(x + " ");
		}

		StdOut.println("\nStep 1 has been completed.");

		// STEP 1 END

		// STEP 2.1 IN Insertion.java

		// STEP 2.2 START
		StdOut.println(
				"The array of integers that has been sorted in decreasing order by using the insertion sort algorithm:\n");
		Insertion.sortRev(arr);
		for (Integer x : arr) {
			StdOut.print(x + " ");
		}
		StdOut.print("\nStep 2 has been completed");

		// STEP 2.2 END

		StdOut.println();
		StdOut.println();

		// STEP 3 START
		String path2 = "/Users/m.ali/Library/Mobile Documents/com~apple~CloudDocs/Kişisel Dosyalar/Uygulama Dosyaları/Cuda Files/HW2_V2/files/doubles.txt";
		try {
			int counter = 0;
			Scanner inp2 = new Scanner(new File(path2));
			arr2 = new Double[inp2.nextInt()];

			while (inp2.hasNextDouble()) {
				if (counter != arr2.length) {
					arr2[counter] = inp2.nextDouble();
					counter++;
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Nothing found in the given path.");
		}

		// PRINT TEXT FILE DOUBLE ARRAY2
		StdOut.println("\ndoubles2 are reading from the doubles2.txt file, the array is:");
		for (Double x : arr2) {
			StdOut.print(x + " ");
		}

		StdOut.println();

		StdOut.println(
				"\nThe array of double values has been sorted in increasing order by using the insertion sort algorithm:");

		// INSERTION SORT OF DOUBLE ARRAY2:D
		Insertion.sort(arr2);

		// PRINT INSERTION SORT OF DOUBLE ARRAY2
		for (Double x : arr2) {
			StdOut.print(x + " ");
		}
		StdOut.println("\nStep 3 has been completed.");
		// STEP 3 END

		// STEP 4.1 STARTS IN Merge.java
		// STEP 4.2 START
		StdOut.println("\nThe original array is:");
		// MERGE SORTED INTEGER ARRAY
		for (Integer x : gereksiz) {
			StdOut.print(x + " ");
		}

		StdOut.print(
				"\nThe array of integer values has been sorted in descending order by using the merge sort algorithm is:");
		for (Integer x : gereksiz) {
			StdOut.print(x + " ");
		}
		StdOut.print("\nStep 4 has been completed.");
		// STEP 4.2 END

		// STEP 5 IN Route.java

		// STEP 6 START

		Route[] routes = new Route[10];
		routes[0] = new Route("Ankara", "Istanbul");
		routes[1] = new Route("Ankara", "Antalya");
		routes[2] = new Route("Istanbul", "Ankara");
		routes[3] = new Route("Istanbul", "Antalya");
		routes[4] = new Route("Istanbul", "Izmir");
		routes[5] = new Route("Antalya", "Ankara");
		routes[6] = new Route("Antalya", "Istanbul");
		routes[7] = new Route("Antalya", "Izmir");
		routes[8] = new Route("Izmir", "Istanbul");
		routes[9] = new Route("Izmir", "Antalya");
		Quick.sort(routes);

		StdOut.println();
		StdOut.println("\nStep 6 has been completed.");

		// PRINTING

		for (Route route : routes) {
			System.out.println(route);
		}

		// STEP 6 END

		// STEP 7.4 START

		StdOut.println();
		StdOut.println("STEP 7 : DESCENDING");

		// FOR "STEP 7.1" PLEASE CHECK "Quick.java" CLASS
		Quick.sortRev(routes);

		for (Route route : routes) {
			System.out.println(route);
		}
		// STEP 7.5 END

		// STEP 8.2 START

		Route[] routes1 = new Route[10];
		routes1[0] = new Route("Ankara", "Istanbul");
		routes1[1] = new Route("Ankara", "Antalya");
		routes1[2] = new Route("Istanbul", "Ankara");
		routes1[3] = new Route("Istanbul", "Antalya");
		routes1[4] = new Route("Istanbul", "Izmir");
		routes1[5] = new Route("Antalya", "Ankara");
		routes1[6] = new Route("Antalya", "Istanbul");
		routes1[7] = new Route("Antalya", "Izmir");
		routes1[8] = new Route("Izmir", "Istanbul");
		routes1[9] = new Route("Izmir", "Antalya");

		StdOut.println();
		StdOut.println("STEP 8 : DEPTH");

		// FOR STEP 8.1 SEE "Quick.java"
		Quick.sortDepth(routes1, 2);

		for (Route route : routes1) {
			System.out.println(route);
		}
		// STEP 8.2 END

	}

}
