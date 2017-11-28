import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created to ensure the sorting algorithms work correctly
 * @author1 Cormac Dacker cxd289
 * @author2 Nicole Coury nfc16
 */
public class SortTester {

    /**
     * Test to insure Insertion sort works correctly before timing it
     */
    @Test
    public void testInsertionSort() {
        /* randomly sorted array */
        int[] arr = Reporting.generateArray(false, false, 10);
        Sorting.insertionSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");

        /* reverse sorted array */
        arr = Reporting.generateArray(false, true, 10);
        Sorting.insertionSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");

        /* sorted array */
        arr = Reporting.generateArray(true, false, 10);
        Sorting.insertionSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");
    }

    /**
     * Test to insure Bubble sort works correctly before timing it
     */
    @Test
    public void testBubbleSort() {
        /* randomly sorted array */
        int[] arr = Reporting.generateArray(false, false, 10);
        Sorting.bubbleSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");

        /* reverse sorted array */
        arr = Reporting.generateArray(false, true, 10);
        Sorting.bubbleSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");

        /* sorted array */
        arr = Reporting.generateArray(true, false, 10);
        Sorting.bubbleSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");
    }

    /**
     * Test to insure Merge sort works correctly before timing it
     */
    @Test
    public void testMergeSort() {
        /* randomly sorted array */
        int[] arr = Reporting.generateArray(false, false, 10);
        Sorting.mergeSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");

        /* reverse sorted array */
        arr = Reporting.generateArray(false, true, 10);
        Sorting.mergeSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");

        /* sorted array */
        arr = Reporting.generateArray(true, false, 10);
        Sorting.mergeSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");
    }

    /**
     * Test to insure Quick sort works correctly before timing it
     */
    @Test
    public void testQuickSort() {
        /* randomly sorted array */
        int[] arr = Reporting.generateArray(false, false, 10);
        Sorting.quickSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");

        /* reverse sorted array */
        arr = Reporting.generateArray(false, true, 10);
        Sorting.quickSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");

        /* sorted array */
        arr = Reporting.generateArray(true, false, 10);
        Sorting.quickSort(arr);
        assertEquals("PASS", Reporting.checker(arr), "Failed to sort the array correctly");
    }
}
