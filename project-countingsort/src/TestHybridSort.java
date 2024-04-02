import junit.framework.TestCase;
import java.util.Arrays;
import edu.uwm.cs351.HybridSort;

public class TestHybridSort extends TestCase {

    // Test sorting an empty array. It should remain empty.
    public void test1() {
        int[] array = {};
        HybridSort.sort(array, 10);
        assertTrue(Arrays.equals(new int[]{}, array));
    }

    // Test sorting an array with a single element. It should remain unchanged.
    public void test2() {
        int[] array = {5};
        HybridSort.sort(array, 10);
        assertTrue(Arrays.equals(new int[]{5}, array));
    }

    // Test sorting an array with two elements.
    public void test3() {
        int[] array = {7, 3};
        HybridSort.sort(array, 10);
        assertTrue(Arrays.equals(new int[]{3, 7}, array));
    }

    // Test sorting an array with multiple elements in random order.
    public void test4() {
        int[] array = {7, 3, 5, 2, 6, 4, 1};
        HybridSort.sort(array, 10);
        assertTrue(Arrays.equals(sortedCopy(array), array));
    }

    // Test sorting an array that is already in ascending order.
    public void test5() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        HybridSort.sort(array, 10);
        assertTrue(Arrays.equals(sortedCopy(array), array));
    }

    // Test sorting an array in descending order.
    public void test6() {
        int[] array = {7, 6, 5, 4, 3, 2, 1};
        HybridSort.sort(array, 10);
        assertTrue(Arrays.equals(sortedCopy(array), array));
    }

    // Test sorting an array where all elements are the same.
    public void test7() {
        int[] array = {5, 5, 5, 5, 5};
        HybridSort.sort(array, 10);
        assertTrue(Arrays.equals(sortedCopy(array), array));
    }

    // Utility method to create a sorted copy of an array for comparison.
    private int[] sortedCopy(int[] array) {
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        return sortedArray;
    }
}
