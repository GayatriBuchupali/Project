package edu.uwm.cs351;

public class QuickSort {
    /**
     * Step 2: Modify Quicksort for Preprocessing
     * Input: An array arr, low index low, high index high, and a threshold value threshold.
     * 
     * Sorts the specified portion of the array using the Quick Sort algorithm.
     * The sorting is performed only if the size of the segment is greater than the given threshold.
     * 
     * @param arr       The array to be sorted.
     * @param low       The starting index of the segment of the array to be sorted.
     * @param high      The ending index of the segment of the array to be sorted.
     * @param threshold The size threshold below which the sorting is not performed.
     */
    public static void sort(int[] arr, int low, int high,int maxValue, int minValue,int C) {

    	while ((low < high) && (maxValue- minValue +
                high - low > C))
           {
   int pivot = partition(arr, low, high); int midValue = arr[pivot]; sort(arr, low,
		   pivot - 1, midValue,minValue,C);
             sort(arr, pivot + 1,high, maxValue,
                                midValue,C);
           }
    }

    /**
     * Partitions the given segment of the array around a pivot element.
     * Elements smaller than the pivot are moved to the left of the pivot, 
     * and larger elements are moved to the right.
     * 
     * @param arr  The array to be partitioned.
     * @param low  The starting index of the segment to be partitioned.
     * @param high The ending index of the segment to be partitioned.
     * @return The index of the pivot element after partitioning.
     */
    private static int partition(int[] arr, int low, int high) {
    	
    	 assert wellFormed(arr, low, high) : "Precondition failed: Array or indices not well-formed";
        // Pivot element selected from the end of the segment
        int pivot = arr[high];
        int i = (low - 1);

        // Rearrange elements based on their comparison with the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot element at its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1; // Return the pivot index
    }
    
    private static boolean wellFormed(int[] arr, int low, int high) {
        return arr != null && low >= 0 && high < arr.length && low <= high;
    }

}