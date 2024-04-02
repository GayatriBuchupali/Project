package edu.uwm.cs351;

import java.util.Arrays;

public class CountingSort {

    /**
     * Step 1: Implement Cache complexity of Counting Sort
     * Input: An array arr of integers and its size n.
     * 
     * Sorts an array of integers using the Counting Sort algorithm.
     * 
     *  
     * 
     * @param arr The array to be sorted.
     */
    public static void sort(int[] arr) {
    	
    	assert wellFormed(arr) : "Precondition failed: Array is not well-formed";
        // Find the maximum and minimum values in the array to determine the range
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // Calculate the range of the values
        int range = max - min + 1;

        // Initialize count array with size equal to the range of values
        int[] count = new int[range];

        // Initialize output array which will hold the sorted values
        int[] output = new int[arr.length];

        // Count each number's occurrences in the original array
        for (int i : arr) {
            count[i - min]++;
        }

        // Perform cumulative sum on the count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        //  Iterate backward through arr, place each element in its correct position in output, and decrement the respective count value.

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy the sorted elements back into the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
        
        assert isSorted(arr) : "Postcondition failed: Array is not sorted";
    }

    /**
     * Sorts an array of integers using the Counting Sort algorithm with a dynamic threshold.
     * If the size of the array is less than or equal to the dynamic threshold, 
     * the method uses a different sorting algorithm.
     * 
     * @param arr The array to be sorted.
     * @param dynamicThreshold The dynamic threshold for choosing the sorting algorithm.
     */
    public static void sort(int[] arr, int dynamicThreshold) {
        if (arr.length <= dynamicThreshold) {
            // Use a different sorting algorithm (e.g., insertion sort) for small arrays
            // You can replace the following line with the sorting algorithm of your choice
            Arrays.sort(arr);
        } else {
            // Use Counting Sort for larger arrays
            sort(arr);
        }
    }
    

    private static boolean wellFormed(int[] arr) {
        return arr != null && arr.length > 0;
    }
    
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}