import java.util.Random;

/**
 * Reporting generates the information of the sorting algorithms
 *
 * @author1 Cormac Dacker cxd289
 * @author2 Nicole Coury nfc16
 */
public class Reporting {
    /**
     * Generates an array of a specified length and type (default type is random sorted array)
     *
     * @param sorted  create a sorted array
     * @param reverse create a reverse sorted array
     * @param size    the size of the array being created
     * @return the array once it is created
     */
    static int[] generateArray(boolean sorted, boolean reverse, int size) {
        /* if it's sorted or reversed*/
        int[] arr = new int[size];
        if (sorted || reverse) {
            /* if it's reveresed */
            if (reverse) {
                for (int index = size - 1; index < 0; index--) {
                    arr[index] = index + 1;
                }
                /* else it's sorted (increasing order) */
            } else {
                for (int index = 0; index < size - 1; index++) {
                    arr[index] = index + 1;
                }
            }
            /* if it's a random array */
        } else {
            for (int index = 0; index < size - 1; index++) {
                Random r = new Random();
                int low = 1;
                int high = 1000;
                int result = r.nextInt(high - low) + low;
                arr[index] = result;
            }
        }
        return arr;
    }

    /**
     * Shuffels an existing an array so that it is sorted randomly
     *
     * @param arr the array that is being scrambled
     */
    private static void shuffle(int[] arr) {
        Random rnd = new Random();
        for (int index = arr.length - 1; index > 0; index--) {
            int swap = rnd.nextInt(index + 1);
            // Simple swap
            int a = arr[swap];
            arr[swap] = arr[index];
            arr[index] = a;
        }
    }

    /**
     * Reverses an existing array
     *
     * @param array the array being reversed
     */
    private static void reverse(int[] array) {
        for (int index = 0; index < (array.length / 2); index = index + 1) {
            int save = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = save;
        }
    }

    /**
     * Checks to make sure an array is in proper order
     *
     * @param arr the array being checked
     * @return boolean flag on the algorithms desition
     */
    public static String checker(int[] arr) {
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

    /**
     * A method to return the average value of a given array of run times
     *
     * @param arrayOfSamples the array containing run times
     * @return the average value run time
     */
    private static double meanVal(long[] arrayOfSamples) {
        double avgTime = 0;
        /* a loop to sum the run times contained in the input array */
        for (int i = 0; i < arrayOfSamples.length; i++){
            avgTime += avgTime;
        }
        return avgTime / arrayOfSamples.length;
    }

    static long insertionSort(int[] arr) {
        Sorting.insertionSort(arr);
        return Sorting.getTime();
    }

    public static long bubbleSort(int[] arr){
        Sorting.bubbleSort(arr);
        return Sorting.getTime();
    }

    static long quickSort(int[] arr) {
        Sorting.quickSort(arr);
        return Sorting.getTime();
    }

    static long mergeSort(int[] arr) {
        Sorting.mergeSort(arr);
        return Sorting.getTime();
    }

    /**
     * The main method here does all the heavy lifting
     * here we test the various sorting methods and generate
     * the file "READ_ME.txt" with the results
     *
     * @param args meaningless input
     */
    public static void main(String[] args) {
        String contents = "";
        /* start with all sorted arrays */
        int[] arr1 = generateArray(true, false, 1000);
        int[] arr10 = generateArray(true, false, 10000);
        int[] arr100 = generateArray(true, false, 100000);
        int[] arr1000 = generateArray(true, false, 1000000);

        /* used to compute the average run time */
        long sortIS1 = 0; //Insertion Sort
        long sortIS10 = 0;
        long sortIS100 = 0;
        long sortIS1000 = 0;

        long sortQS1 = 0; //Quick Sort
        long sortQS10 = 0;
        long sortQS100 = 0;
        long sortQS1000 = 0;

        long sortMS1 = 0;//Merge Sort
        long sortMS10 = 0;
        long sortMS100 = 0;
        long sortMS1000 = 0;

        /* arrays to be used for run times */
        long[] arrIS1 = new long[3];
        long[] arrIS10 = new long[3];
        long[] arrIS100 = new long[3];
        long[] arrIS1000 = new long[3];

        long[] arrQS1 = new long[3];
        long[] arrQS10 = new long[3];
        long[] arrQS100 = new long[3];
        long[] arrQS1000 = new long[3];

        long[] arrMS1 = new long[3];
        long[] arrMS10 = new long[3];
        long[] arrMS100 = new long[3];
        long[] arrMS1000 = new long[3];


        /* three rounds of sorting an already sorted array */
        contents = contents + "------ SORTED ------";
        for (int count = 1; count < 4; count++) {
            /* insert sort */
            arrIS1[count - 1] = insertionSort(arr1);
            sortIS1 = sortIS1 + Sorting.getTime();
            arrIS10[count - 1] = insertionSort(arr10);
            sortIS10 = sortIS10 + Sorting.getTime();
            arrIS100[count - 1] = insertionSort(arr100);
            sortIS100 = sortIS100 + Sorting.getTime();
            arrIS1000[count - 1] = insertionSort(arr1000);
            sortIS1000 = sortIS1000 + Sorting.getTime();

            /* quick sort */
            arrQS1[count - 1] = quickSort(arr1);
            sortQS1 = sortQS1 + Sorting.getTime();
            arrQS10[count - 1] = quickSort(arr10);
            sortQS10 = sortQS10 + Sorting.getTime();
            arrQS100[count - 1] = quickSort(arr100);
            sortQS100 = sortQS100 + Sorting.getTime();
            arrQS1000[count - 1] = quickSort(arr1000);
            sortQS1000 = sortQS1000 + Sorting.getTime();

            /* merge sort */
            arrMS1[count - 1] = mergeSort(arr1);
            sortMS1 = sortMS1 + Sorting.getTime();
            arrMS10[count - 1] = mergeSort(arr10);
            sortMS10 = sortMS10 + Sorting.getTime();
            arrMS100[count - 1] = mergeSort(arr100);
            sortMS100 = sortMS100 + Sorting.getTime();
            arrMS1000[count - 1] = mergeSort(arr1000);
            sortMS1000 = sortMS1000 + Sorting.getTime();
        }
        // --- Averages Sorted ---
        contents = contents + "\n      HeapSort1 average time(μs):" + sortIS1 / 3;
        contents = contents + "\n      HeapSort10 average time(μs):" + sortIS10 / 3;
        contents = contents + "\n      HeapSort100 average time(μs):" + sortIS100 / 3;
        contents = contents + "\n      HeapSort1000 average time(μs):" + sortIS1000 / 3;
        contents = contents + "\n      QuickSort1 average time(μs):" + sortQS1 / 3;
        contents = contents + "\n      QuickSort10 average time(μs):" + sortQS10 / 3;
        contents = contents + "\n      QuickSort100 average time(μs):" + sortQS100 / 3;
        contents = contents + "\n      QuickSort1000 average time(μs):" + sortQS1000 / 3;
        contents = contents + "\n      MergeSort1 average time(μs):" + sortMS1 / 3;
        contents = contents + "\n      MergeSort10 average time(μs):" + sortMS10 / 3;
        contents = contents + "\n      MergeSort100 average time(μs):" + sortMS100 / 3;
        contents = contents + "\n      MergeSort1000 average time(μs):" + sortMS1000 / 3;


        /* three rounds of sorting a reversed sorted array */
        contents = contents + "\n\n\n\n------ REVERSED ------";
        for (int count = 1; count < 4; count++) {
            /* insert sort */
            reverse(arr1);
            arrIS1[count - 1] = insertionSort(arr1);
            reverse(arr10);
            arrIS10[count - 1] = insertionSort(arr10);
            sortIS10 = sortIS10 + Sorting.getTime();
            reverse(arr100);
            arrIS100[count - 1] = insertionSort(arr100);
            sortIS100 = sortIS100 + Sorting.getTime();
            reverse(arr1000);
            arrIS1000[count - 1] = insertionSort(arr1000);
            sortIS1000 = sortIS1000 + Sorting.getTime();

            /* quick sort */
            reverse(arr1);
            arrQS1[count - 1] = quickSort(arr1);
            sortQS1 = sortQS1 + Sorting.getTime();
            reverse(arr10);
            arrQS10[count - 1] = quickSort(arr10);
            sortQS10 = sortQS10 + Sorting.getTime();
            reverse(arr100);
            arrQS100[count - 1] = quickSort(arr100);
            sortQS100 = sortQS100 + Sorting.getTime();
            reverse(arr1000);
            arrQS1000[count - 1] = quickSort(arr1000);
            sortQS1000 = sortQS1000 + Sorting.getTime();

            /* merge sort */
            reverse(arr1);
            arrMS1[count - 1] = mergeSort(arr1);
            sortMS1 = sortMS1 + Sorting.getTime();
            reverse(arr10);
            arrMS10[count - 1] = mergeSort(arr10);
            sortMS10 = sortMS10 + Sorting.getTime();
            reverse(arr100);
            arrMS100[count - 1] = mergeSort(arr100);
            sortMS100 = sortMS100 + Sorting.getTime();
            reverse(arr1000);
            arrMS1000[count - 1] = mergeSort(arr1000);
            sortMS1000 = sortMS1000 + Sorting.getTime();
        }
        // --- Averages Reversed ---
        contents = contents + "\n      HeapSort1 average time(μs):" + sortIS1 / 3;
        contents = contents + "\n      HeapSort10 average time(μs):" + sortIS10 / 3;
        contents = contents + "\n      HeapSort100 average time(μs):" + sortIS100 / 3;
        contents = contents + "\n      HeapSort1000 average time(μs):" + sortIS1000 / 3;
        contents = contents + "\n      QuickSort1 average time(μs):" + sortQS1 / 3;
        contents = contents + "\n      QuickSort10 average time(μs):" + sortQS10 / 3;
        contents = contents + "\n      QuickSort100 average time(μs):" + sortQS100 / 3;
        contents = contents + "\n      QuickSort1000 average time(μs):" + sortQS1000 / 3;
        contents = contents + "\n      MergeSort1 average time(μs):" + sortMS1 / 3;
        contents = contents + "\n      MergeSort10 average time(μs):" + sortMS10 / 3;
        contents = contents + "\n      MergeSort100 average time(μs):" + sortMS100 / 3;
        contents = contents + "\n      MergeSort1000 average time(μs):" + sortMS1000 / 3;


        /* three rounds of sorting a randomly sorted array */
        contents = contents + "\n\n\n\n------ RANDOM ------";
        for (int count = 1; count < 4; count++) {
            /* insert sort */
            shuffle(arr1);
            arrIS1[count - 1] = insertionSort(arr1);
            sortIS1 = sortIS1 + Sorting.getTime();
            shuffle(arr10);

            arrIS10[count - 1] = insertionSort(arr10);
            sortIS10 = sortIS10 + Sorting.getTime();
            shuffle(arr100);

            Sorting.insertionSort(arr100);
            arrIS100[count - 1] = insertionSort(arr100);
            sortIS100 = sortIS100 + Sorting.getTime();
            shuffle(arr1000);

            Sorting.insertionSort(arr1000);
            arrIS1000[count - 1] = insertionSort(arr1000);
            sortIS1000 = sortIS1000 + Sorting.getTime();

            /* quick sort */
            shuffle(arr1);
            Sorting.quickSort(arr1);
            arrQS1[count - 1] = Sorting.getTime();
            sortQS1 = sortQS1 + Sorting.getTime();
            shuffle(arr10);

            Sorting.quickSort(arr10);
            arrQS10[count - 1] = Sorting.getTime();
            sortQS10 = sortQS10 + Sorting.getTime();
            shuffle(arr100);

            Sorting.quickSort(arr100);
            arrQS100[count - 1] = Sorting.getTime();
            sortQS100 = sortQS100 + Sorting.getTime();
            shuffle(arr1000);

            Sorting.quickSort(arr1000);
            arrQS1000[count - 1] = Sorting.getTime();
            sortQS1000 = sortQS1000 + Sorting.getTime();

            /* merge sort */
            shuffle(arr1);
            Sorting.mergeSort(arr1);
            arrMS1[count - 1] = Sorting.getTime();
            sortMS1 = sortMS1 + Sorting.getTime();
            shuffle(arr10);

            Sorting.mergeSort(arr10);
            arrMS10[count - 1] = Sorting.getTime();
            sortMS10 = sortMS10 + Sorting.getTime();
            shuffle(arr100);

            Sorting.mergeSort(arr100);
            arrMS100[count - 1] = Sorting.getTime();
            sortMS100 = sortMS100 + Sorting.getTime();
            shuffle(arr1000);

            Sorting.mergeSort(arr1000);
            arrMS1000[count - 1] = Sorting.getTime();
            sortMS1000 = sortMS1000 + Sorting.getTime();
        }
        //  --- Averages Random ---
        contents = contents + "\n      HeapSort1 average time(μs):" + sortIS1 / 3;
        contents = contents + "\n      HeapSort10 average time(μs):" + sortIS10 / 3;
        contents = contents + "\n      HeapSort100 average time(μs):" + sortIS100 / 3;
        contents = contents + "\n      HeapSort1000 average time(μs):" + sortIS1000 / 3;
        contents = contents + "\n      QuickSort1 average time(μs):" + sortQS1 / 3;
        contents = contents + "\n      QuickSort10 average time(μs):" + sortQS10 / 3;
        contents = contents + "\n      QuickSort100 average time(μs):" + sortQS100 / 3;
        contents = contents + "\n      QuickSort1000 average time(μs):" + sortQS1000 / 3;
        contents = contents + "\n      MergeSort1 average time(μs):" + sortMS1 / 3;
        contents = contents + "\n      MergeSort10 average time(μs):" + sortMS10 / 3;
        contents = contents + "\n      MergeSort100 average time(μs):" + sortMS100 / 3;
        contents = contents + "\n      MergeSort1000 average time(μs):" + sortMS1000 / 3;


    }
}
