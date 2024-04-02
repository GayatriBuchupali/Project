import junit.framework.TestCase;

import java.util.Random;

import edu.uwm.cs351.CountingSort;
import edu.uwm.cs351.HybridSort;
import edu.uwm.cs351.QuickSort;

public class TestEfficiency extends TestCase {

    private static final int ARRAY_SIZE = 10000;

    public void testHybridSortEfficiency() {
        int[] array = createRandomArray(ARRAY_SIZE);
        int[] arr = HybridSort.calculateDynamicThreshold(array);
        long startTime = System.currentTimeMillis();
        HybridSort.sort(array, arr[0]);
        long endTime = System.currentTimeMillis();
    }
    

    public void testQuickSortEfficiency() {
        int[] array = createRandomArray(ARRAY_SIZE);
        int[] arr = HybridSort.calculateDynamicThreshold(array);
        long startTime = System.currentTimeMillis();
        QuickSort.sort(array, 0, array.length - 1,arr[1],arr[2],arr[0]);
        long endTime = System.currentTimeMillis();
    }

    public void testCountingSortEfficiency() {
        int[] array = createRandomArray(ARRAY_SIZE);
        long startTime = System.currentTimeMillis();
        CountingSort.sort(array);
        long endTime = System.currentTimeMillis();
    }

    private int[] createRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }
}
