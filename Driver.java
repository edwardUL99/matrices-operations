import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
		Matrices test = new Matrices();
		int[] nums = {1, 2, 3, 4, 5};
		int[] nums1 = {2, 2, 2, 2, 2};
		int[] nums2 = {5, 6, 7, 8, 9};
		int[] digits = {12, 26, 17, 100, 300, 450};
		String[] names = {"Abby", "Brian", "Claire", "David", "Eddy", "Fionn"};
		
		System.out.println(test.contains(nums, 10));
		System.out.println(test.contains(nums, 4));
		System.out.println(test.contains(nums, 4, 4));
		System.out.println(test.contains(nums, 4, 3));
		System.out.println(Arrays.toString(test.indexesOf(nums, 1)));
		System.out.println(Arrays.toString(test.indexesOf(nums, 2)));
		System.out.println(Arrays.toString(test.indexesOf(nums1, 2)));
		System.out.println(Arrays.toString(test.append(nums, nums1)));
		System.out.println(Arrays.toString(test.union(nums, nums2)));
		System.out.println(Arrays.toString(test.intersection(nums, nums1)));
		System.out.println(Arrays.toString(test.divisible(nums, nums1)));
		System.out.println(Arrays.toString(test.cartesianProduct(nums, nums2)));
		System.out.println(Arrays.toString(test.divisible(test.union(nums, nums2), 4)));
		System.out.println(test.min(nums2));
		System.out.println(test.max(nums2));
		System.out.printf("\nThe range of the array nums2 is %d\n", test.arrayRange(nums2));
		System.out.println(test.arrayAverage(nums2));
		
		int[] rand = test.randomArray(2, 100, 50);
		Arrays.sort(rand);
		System.out.println(Arrays.toString(rand));
		
		System.out.println(Arrays.toString(test.startDigit(digits, 1)));
		System.out.println(Arrays.toString(test.rangeOf(rand, 20, 100)));
		
		int[] a = test.shuffle(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(a));
		
		String[] b = test.shuffle(names);
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(b));
		
		System.out.println("\n" + Arrays.toString(nums));
		System.out.println(Arrays.toString(test.reverse(nums)));
		
		System.out.println("\n" + Arrays.toString(names));
		System.out.println(Arrays.toString(test.reverse(names)));
		
		System.out.println(Arrays.deepToString(test.half(nums)));
		System.out.println(Arrays.deepToString(test.half(names)));
		System.out.println(Arrays.deepToString(test.half(digits)));
		
		int[] numsCopy = Arrays.copyOf(nums, nums.length);
		System.out.println(Arrays.toString(numsCopy));
		numsCopy = test.remove(numsCopy, 4);
		numsCopy = test.remove(numsCopy, 1);
		numsCopy = test.remove(numsCopy, 5);
		numsCopy = test.remove(numsCopy, 2);
		System.out.println(Arrays.toString(numsCopy));
		
		String[] namesCopy = Arrays.copyOf(names,  names.length);
		System.out.println(Arrays.toString(namesCopy));
		namesCopy = test.remove(namesCopy, "Claire");
		namesCopy = test.remove(namesCopy, "Abby");
		namesCopy = test.remove(namesCopy, "Eddy");
		namesCopy = test.remove(namesCopy, "David");
		namesCopy = test.remove(namesCopy, "Brian");
		namesCopy = test.remove(namesCopy, "Fionn");

		int[][] ar1 = {{3,1}, {0, 2}, {-1, 1}, {1, 3}};
		int[][] ar2 = {{0, 2 , 4}, {1, 3, -2}};
		test.display2D(test.matrixMultiply(ar1, ar2));
		System.out.println();
		int[][] ar3 = {{5, 9, 6}, {2, 1, 10}, {7, 1, 9}};
		test.display2D(test.scalarMultiplication(ar2, 2));
		test.display2D(test.matrixAddition(ar2, ar2));
		test.display2D(test.matrixSubtraction(ar2, ar2));
		test.display2D(ar3);
		test.display2D(test.matrixMinor(ar3,2,0));
		System.out.println(test.matrixDeterminant(test.matrixMinor(ar3,2,0)));
		test.display2D(test.matrixTranspose(ar3));
		int[][] ar4 = {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
		test.display2D(ar4);
        test.display2D(test.matrixMinor(ar4,1,2));

        int[][] ar5 = {{5, 10, 9, 16, 20}, {1, 3, 5, 4, 0}, {10, 9, 6, 4, 5}, {1, 2, 5, 4, 0}, {1, 10, 9, 8, 6}};
        System.out.println(test.matrixDeterminant(ar5));

        int[][] ar6 = {{1, 2, 3}, {0, 1, 4}, {5, 6, 0}};
        test.display2D(test.matrixTranspose(ar6));
        test.display2D(test.matrixInverse(ar6));

        int[][] ar7 = {{1, 2}, {3, 4}};
        test.display2D(test.matrixInverse(ar7));
	}
}
