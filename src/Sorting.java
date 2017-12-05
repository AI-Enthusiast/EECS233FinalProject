/**
 * Sorting class to for InsertionSort, BubbleSort, QuickSort, and MergeSort
 *
 * @author1 Cormac Dacker cxd289
 * @author2 Nicole Coury nfc16
 */
class Sorting {

    // FIELDS
    private static long time = System.currentTimeMillis();

    // CONSTRUCTOR
    public Sorting() {
    }

    // WORKING METHODS

    /**
     * Sorts an array using bubble sort
     *
     * @param arr the array being sorted
     */
    static void bubbleSort(int[] arr) {
        long zero = startTime();
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; //simple swap
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        stopTime(zero);
    }

    /**
     * Sorts an array using insertion sort
     *
     * @param arr the array being sorted
     */
    static void insertionSort(int[] arr) {
        long zero = startTime();
        int i, j;   // Loop control variables
        int entry;  // The element that is currently being inserted

        for (i = 1; i < arr.length; i++) {
            entry = arr[i];
            for (j = i; (j > 0) && (arr[j - 1] > entry); j--)
                arr[j] = arr[j - 1];
            arr[j] = entry;
        }
        stopTime(zero);
    }

    /**
     * Sorts an array using quick sort
     *
     * @param arr the array being sorted
     */
    static void quickSort(int[] arr) {
        long zero = startTime();
        quickSort(arr, 0, arr.length);
        stopTime(zero);
    }

    /**
     * Sorts an array using merge sort
     *
     * @param arr the array to be sorted
     */
    static void mergeSort(int[] arr) {
        long zero = startTime();
        int[] fromHere = arr;
        int[] toGoTo = new int[arr.length];
        for (int stepSize = 1; stepSize < arr.length; stepSize *= 2) {
            for (int index = 0; index < arr.length; index += 2 * stepSize) {
                merge(fromHere, toGoTo, index, index + stepSize, index + 2 * stepSize);
            }
            int[] temporary = fromHere;
            fromHere = toGoTo;
            toGoTo = temporary;
        }
        if (arr != fromHere) {
            System.arraycopy(fromHere, 0, arr, 0, arr.length);
        }
        stopTime(zero);
    }

    /**
     * Merges two arrays together
     *
     * @param arr1   array one to be merged with array two
     * @param arr2   array two to be merged with array one
     * @param low    the lowest value
     * @param middle the medium value
     * @param high   the highest value
     */
    private static void merge(int[] arr1, int[] arr2, int low, int middle, int high) {
        if (middle > arr1.length)
            middle = arr1.length;
        if (high > arr1.length)
            high = arr1.length;
        int i = low;
        int j = middle;
        for (int k = low; k < high; k++) {
            if (i == middle) {
                arr2[k] = arr1[j];
                j++;
            } else if (j == high) {
                arr2[k] = arr1[i];
                i++;
            } else if (arr1[j] < arr1[i]) {
                arr2[k] = arr1[j];
                j++;
            } else {
                arr2[k] = arr1[i];
                i++;
            }
        }
    }

    /**
     * Sorts an array of integers using the quickSort algorithm
     *
     * @param arr   The full array to sort
     * @param start The starting index (inclusive)
     * @param end   The ending index (exclusive)
     */
    private static void quickSort(int[] arr, int start, int end) {
        int pivot = (start + end) / 2;
        /* temporary array containing the ordered sub-list */
        int[] sub = new int[end - start];
        int left = 0, right = sub.length;
        /* populate the sub-list */
        for (int index = start; index < end; index++) {
            if (index == pivot) continue;
            if (arr[index] < arr[pivot]) {
                sub[left++] = arr[index];
            } else {
                sub[--right] = arr[index];
            }
        }
        /* add in the original pivot in its new position */
        sub[left] = arr[pivot];
        /* copy back into the original array */
        System.arraycopy(sub, 0, arr, start, end - start);
        /* potential for StackOverflow Error */
        /* translate new pivot position into full list index */
        left += start;
        if (left - start > 0) quickSort(arr, start, left);
        /* the start of the right branch should not include the pivot */
        left++;
        if (end - left > 0) quickSort(arr, left, end);
    }

    /**
     * Produces the start time in milliseconds
     *
     * @return time
     */
    private static long startTime() {
        return (System.currentTimeMillis() * 1000);
    }

    /**
     * Determines how much time has passed since startTime
     *
     * @param zero the start time (not actually 0)
     */
    private static void stopTime(long zero) {
        setTime((System.currentTimeMillis() * 1000) - zero);
    }

    // GETTER/SETTERS
    static long getTime() {
        return time;
    }

    private static void setTime(long time) {
        Sorting.time = time;
    }
}