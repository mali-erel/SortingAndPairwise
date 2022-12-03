package Q2;
/* Name 	: Mehmet Ali EREL
 * ID 		: 11260275756
 * Section 	: 04*/
import java.util.Random;

public class SortingAlgorithmTester {

	private int seed;

	public SortingAlgorithmTester(int seed) {
		super();
		this.seed = seed;
	}

	public static Integer[] randomizer(int seed,int size) {
		Random random = new Random(seed);
		Integer[] arr = new Integer[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(); // storing random integers in an array
		}

		return arr;

	}

}
