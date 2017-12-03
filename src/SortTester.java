import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created to ensure the sorting algorithms work correctly
 *
 * @author1 Cormac Dacker cxd289
 * @author2 Nicole Coury nfc16
 */
class SortTester {
    /**
     * Test to insure Insertion sort works correctly before timing it
     */
    @Test
    void testInsertionSort() {
        /* randomly sorted array */
        int[] arr = Reporting.generateArray(false, false, 10);
        Sorting.insertionSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");

        /* reverse sorted array */
        arr = Reporting.generateArray(false, true, 10);
        Sorting.insertionSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");

        /* sorted array */
        arr = Reporting.generateArray(true, false, 10);
        Sorting.insertionSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");
    }

    /**
     * Test to insure Bubble sort works correctly before timing it
     */
    @Test
    void testBubbleSort() {
        /* randomly sorted array */
        int[] arr = Reporting.generateArray(false, false, 10);
        Sorting.bubbleSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");

        /* reverse sorted array */
        arr = Reporting.generateArray(false, true, 10);
        Sorting.bubbleSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");

        /* sorted array */
        arr = Reporting.generateArray(true, false, 10);
        Sorting.bubbleSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");
    }

    /**
     * Test to insure Merge sort works correctly before timing it
     */
    @Test
    void testMergeSort() {
        /* randomly sorted array */
        int[] arr = Reporting.generateArray(false, false, 10);
        Sorting.mergeSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");

        /* reverse sorted array */
        arr = Reporting.generateArray(false, true, 10);
        Sorting.mergeSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");

        /* sorted array */
        arr = Reporting.generateArray(true, false, 10);
        Sorting.mergeSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");
    }

    /**
     * Test to insure Quick sort works correctly before timing it
     */
    @Test
    void testQuickSort() {
        /* randomly sorted array */
        int[] arr = Reporting.generateArray(false, false, 10);
        Sorting.quickSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");

        /* reverse sorted array */
        arr = Reporting.generateArray(false, true, 10);
        Sorting.quickSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");

        /* sorted array */
        arr = Reporting.generateArray(true, false, 10);
        Sorting.quickSort(arr);
        assertEquals("PASS", checker(arr), "Failed to sort the array correctly");
    }

    /**
     * Checks to make sure an array is in proper order
     *
     * @param arr the array being checked
     * @return boolean flag on the algorithms desition
     */
        for (int index = 0; index < arr.length - 1; index++) {
            try {
                if (arr[index] > arr[index + 1]) {
                    return "FAIL";
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return "PASS";
            }
        }
        return "PASS";
    }

}
