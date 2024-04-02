package edu.uwm.cs351;

public class HybridSort {
	static int minValue, maxValue;
    /**
     * Step 3: Implement the Hybrid Sort
     * Sorts an array using a hybrid sorting approach which combines Quick Sort and Counting Sort.
     * The array is first preprocessed with a modified version of Quick Sort, and then Counting Sort is applied.
     *
     * @param arr       The array to be sorted.
     * @param threshold The initial threshold value to determine when to stop further recursion in Quick Sort.
     */
    public static void sort(int[] arr, int threshold) {
    	int [] arra = new int[3];
        assert wellFormed(arr) : "Precondition failed: Array is not well-formed";
        arra = calculateDynamicThreshold(arr);
        // Apply the modified Quick Sort algorithm up to the given threshold.
        QuickSort.sort(arr, 0, arr.length - 1,arra[1],arra[2],threshold);

        // Once the array is partially sorted with Quick Sort, apply Counting Sort for final sorting.
        // Counting Sort is only applied if the array is not empty.
        if (arr.length > 0) {
           // int[] dynamicThreshold = calculateDynamicThreshold(arr);
            CountingSort.sort(arr, arra[0]);
        }
    }

    private static boolean wellFormed(int[] arr) {
        return arr != null;
    }

    // Calculate a dynamic threshold based on array characteristics.
    public static int[] calculateDynamicThreshold(int[] arr) {
        // Get the size of the array
        int size = arr.length;
        int[] array_1 = new int[3];
        // Calculate some statistics about the array, such as range, average, etc.
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
        long sum = 0;

        for (int value : arr) {
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
            sum += value;
        }
        int averageValue = 0;

        // Calculate the average value
        if (sum > 0)  averageValue = (int) (sum / size);

        // Define the threshold parameters (you may adjust these based on your design)
        int thresholdMultiplier = 2; // You may adjust this multiplier based on your design
        int dynamicThreshold = averageValue + thresholdMultiplier * (maxValue - minValue);
        
        array_1[0] = dynamicThreshold;
        array_1[1] = minValue;
        array_1[2] = maxValue;

        return array_1;
    }
}