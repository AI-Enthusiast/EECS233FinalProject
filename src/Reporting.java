import java.awt.*;
import java.util.Random;

/**
 * Reporting generates the information of the sorting algorithms
 *
 * @author Cormac Dacker cxd289
 * @author Nicole Coury nfc16
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
                for (int index = size - 1; index > 0; index--) {
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
     * A method to return the average value of a given array of run times
     *
     * @param arr the array containing run times
     * @return the average value run time
     */
    private static int meanVal(long[] arr) {
        int avgTime = 0;
        /* a loop to sum the run times contained in the input array */
        for (int i = 0; i < arr.length; i++) {
            avgTime += arr[i];
        }
        return avgTime / arr.length;
    }

    /**
     * Calls Insertion sort in sorting.java
     *
     * @param arr The array being sorted
     * @return The runtime to sort the array
     */
    private static long insertionSort(int[] arr) {
        Sorting.insertionSort(arr);
        return Sorting.getTime();
    }

    /**
     * Calls bubble sort in sorting.java
     *
     * @param arr The array being sorted
     * @return The runtime to sort the array
     */
    private static long bubbleSort(int[] arr) {
        Sorting.bubbleSort(arr);
        return Sorting.getTime();
    }

    /**
     * Calls quick sort in sorting.java
     *
     * @param arr The array being sorted
     * @return The runtime to sort the array
     */
    private static long quickSort(int[] arr) {
        Sorting.quickSort(arr);
        return Sorting.getTime();
    }

    /**
     * Calls merge sort in sorting.java
     *
     * @param arr The array being sorted
     * @return The runtime to sort the array
     */
    private static long mergeSort(int[] arr) {
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
        /* start with all sorted arrays */
        int[] arr0 = generateArray(true, false, 10000);
        int[] arr1 = generateArray(true, false, 25000);
        int[] arr10 = generateArray(true, false, 50000);
        int[] arr100 = generateArray(true, false, 75000);
        int[] arr1000 = generateArray(true, false, 100000);

        /* y coordinates that will be used on the graph */
        int[] xCords = {10000, 25000, 50000, 75000, 100000};

        /* arrays to be used for run times */
        long[] arrIS0 = new long[3];    //Insertion sort
        long[] arrIS1 = new long[3];
        long[] arrIS10 = new long[3];
        long[] arrIS100 = new long[3];
        long[] arrIS1000 = new long[3];
        long[] arrBS0 = new long[3];    //Bubble sort
        long[] arrBS1 = new long[3];
        long[] arrBS10 = new long[3];
        long[] arrBS100 = new long[3];
        long[] arrBS1000 = new long[3];
        long[] arrQS0 = new long[3];    //Quick sort
        long[] arrQS1 = new long[3];
        long[] arrQS10 = new long[3];
        long[] arrQS100 = new long[3];
        long[] arrQS1000 = new long[3];
        long[] arrMS0 = new long[3];    //Merge sort
        long[] arrMS1 = new long[3];
        long[] arrMS10 = new long[3];
        long[] arrMS100 = new long[3];
        long[] arrMS1000 = new long[3];

        /* three rounds of sorting an already sorted array */
        // ------ SORTED ------
        for (int count = 0; count < 3; count++) {
            System.out.println(((count + 1) * 10) + "% Done");
            /* insert sort */
            arrIS0[count] = insertionSort(arr0);
            arrIS1[count] = insertionSort(arr1);
            arrIS10[count] = insertionSort(arr10);
            arrIS100[count] = insertionSort(arr100);
            arrIS1000[count] = insertionSort(arr1000);
            /* bubble sort */
            arrBS0[count] = bubbleSort(arr0);
            arrBS1[count] = bubbleSort(arr1);
            arrBS10[count] = bubbleSort(arr10);
            arrBS100[count] = bubbleSort(arr100);
            arrBS1000[count] = bubbleSort(arr1000);
            /* quick sort */
            arrQS0[count] = quickSort(arr0);
            arrQS1[count] = quickSort(arr1);
            arrQS10[count] = quickSort(arr10);
            arrQS100[count] = quickSort(arr100);
            arrQS1000[count] = quickSort(arr1000);
            /* merge sort */
            arrMS0[count] = mergeSort(arr0);
            arrMS1[count] = mergeSort(arr1);
            arrMS10[count] = mergeSort(arr10);
            arrMS100[count] = mergeSort(arr100);
            arrMS1000[count] = mergeSort(arr1000);
        }
        // --- Averages Sorted ---
        int[] ISmeanSort = {meanVal(arrIS0), meanVal(arrIS1), meanVal(arrIS10), meanVal(arrIS100), meanVal(arrIS1000)};
        int[] QSmeanSort = {meanVal(arrQS0), meanVal(arrQS1), meanVal(arrQS10), meanVal(arrQS100), meanVal(arrQS1000)};
        int[] MSmeanSort = {meanVal(arrMS0), meanVal(arrMS1), meanVal(arrMS10), meanVal(arrMS100), meanVal(arrMS1000)};
        int[] BSmeanSort = {meanVal(arrBS0), meanVal(arrBS1), meanVal(arrBS10), meanVal(arrBS100), meanVal(arrBS1000)};

        /* three rounds of sorting a reversed sorted array */
        // ----- REVERSED ------
        for (int count = 0; count < 3; count++) {
            System.out.println(((count + 4) * 10) + "% Done");
            /* insert sort */
            reverse(arr1);
            arrIS1[count] = insertionSort(arr1);
            reverse(arr10);
            arrIS10[count] = insertionSort(arr10);
            reverse(arr100);
            arrIS100[count] = insertionSort(arr100);
            reverse(arr1000);
            arrIS1000[count] = insertionSort(arr1000);
            /* bubble sort */
            reverse(arr1);
            arrBS1[count] = bubbleSort(arr1);
            reverse(arr10);
            arrBS10[count] = bubbleSort(arr10);
            reverse(arr100);
            arrBS100[count] = bubbleSort(arr100);
            reverse(arr1000);
            arrBS1000[count] = bubbleSort(arr1000);
            /* quick sort */
            reverse(arr1);
            arrQS1[count] = quickSort(arr1);
            reverse(arr10);
            arrQS10[count] = quickSort(arr10);
            reverse(arr100);
            arrQS100[count] = quickSort(arr100);
            reverse(arr1000);
            arrQS1000[count] = quickSort(arr1000);
            /* merge sort */
            reverse(arr1);
            arrMS1[count] = mergeSort(arr1);
            reverse(arr10);
            arrMS10[count] = mergeSort(arr10);
            reverse(arr100);
            arrMS100[count] = mergeSort(arr100);
            reverse(arr1000);
            arrMS1000[count] = mergeSort(arr1000);
        }
        // --- Averages Reversed ---
        int[] ISmeanRev = {meanVal(arrIS0), meanVal(arrIS1), meanVal(arrIS10), meanVal(arrIS100), meanVal(arrIS1000)};
        int[] QSmeanRev = {meanVal(arrQS0), meanVal(arrQS1), meanVal(arrQS10), meanVal(arrQS100), meanVal(arrQS1000)};
        int[] MSmeanRev = {meanVal(arrMS0), meanVal(arrMS1), meanVal(arrMS10), meanVal(arrMS100), meanVal(arrMS1000)};
        int[] BSmeanRev = {meanVal(arrBS0), meanVal(arrBS1), meanVal(arrBS10), meanVal(arrBS100), meanVal(arrBS1000)};



        /* three rounds of sorting a randomly sorted array */
        // ------ RANDOM ------
        for (int count = 0; count < 3; count++) {
            System.out.println(((count + 7) * 10) + "% Done");
            /* insert sort */
            shuffle(arr1);
            arrIS1[count] = insertionSort(arr1);
            shuffle(arr10);
            arrIS10[count] = insertionSort(arr10);
            shuffle(arr100);
            arrIS100[count] = insertionSort(arr100);
            shuffle(arr1000);
            arrIS1000[count] = insertionSort(arr1000);
            /* bubble sort */
            shuffle(arr1);
            arrBS1[count] = bubbleSort(arr1);
            shuffle(arr10);
            arrBS10[count] = bubbleSort(arr10);
            shuffle(arr100);
            arrBS100[count] = bubbleSort(arr100);
            shuffle(arr1000);
            arrBS1000[count] = bubbleSort(arr1000);
            /* quick sort */
            shuffle(arr1);
            arrQS1[count] = quickSort(arr1);
            shuffle(arr10);
            arrQS10[count] = quickSort(arr10);
            shuffle(arr100);
            arrQS100[count] = quickSort(arr100);
            shuffle(arr1000);
            arrQS1000[count] = quickSort(arr1000);
            /* merge sort */
            shuffle(arr1);
            arrMS1[count] = mergeSort(arr1);
            shuffle(arr10);
            arrMS10[count] = mergeSort(arr10);
            shuffle(arr100);
            arrMS100[count] = mergeSort(arr100);
            shuffle(arr1000);
            arrMS1000[count] = mergeSort(arr1000);
        }
        //  --- Averages Random ---
        int[] ISmeanRand = {meanVal(arrIS0), meanVal(arrIS1), meanVal(arrIS10), meanVal(arrIS100), meanVal(arrIS1000)};
        int[] QSmeanRand = {meanVal(arrQS0), meanVal(arrQS1), meanVal(arrQS10), meanVal(arrQS100), meanVal(arrQS1000)};
        int[] MSmeanRand = {meanVal(arrMS0), meanVal(arrMS1), meanVal(arrMS10), meanVal(arrMS100), meanVal(arrMS1000)};
        int[] BSmeanRand = {meanVal(arrBS0), meanVal(arrBS1), meanVal(arrBS10), meanVal(arrBS100), meanVal(arrBS1000)};
        System.out.println("100% Done!");
         /* Graphing Time!*/
         /* sorted */
        Grapher graphSort = new Grapher();
        graphSort.graph(ISmeanSort, xCords, Color.BLUE); //Insertion
        graphSort.graph(BSmeanSort, xCords, Color.PINK); //Bubble
        graphSort.graph(QSmeanSort, xCords, Color.ORANGE); //Quick
        graphSort.graph(MSmeanSort, xCords, Color.GREEN); //Merge
        graphSort.display("Presorted Array");
        /* reversed */
        Grapher graphRev = new Grapher();
        graphRev.graph(ISmeanRev, xCords, Color.BLUE);
        graphRev.graph(BSmeanRev, xCords, Color.PINK);
        graphRev.graph(QSmeanRev, xCords, Color.ORANGE);
        graphRev.graph(MSmeanRev, xCords, Color.GREEN);
        graphRev.display("Reversed Array");
        /* random */
        Grapher graphRand = new Grapher();
        graphRand.graph(ISmeanRand, xCords, Color.BLUE);
        graphRand.graph(BSmeanRand, xCords, Color.PINK);
        graphRand.graph(QSmeanRand, xCords, Color.ORANGE);
        graphRand.graph(MSmeanRand, xCords, Color.GREEN);
        graphRand.display("Random Array");
        /* insertion */
        Grapher is = new Grapher();
        is.graph(ISmeanSort, xCords, Color.BLUE); //Sort
        is.graph(ISmeanRev, xCords, Color.ORANGE); //Reversed
        is.graph(ISmeanRand, xCords, Color.PINK); //Random
        is.display("Insertion Sort");
        /* bubble */
        Grapher bs = new Grapher();
        bs.graph(BSmeanSort, xCords, Color.BLUE);
        bs.graph(BSmeanRev, xCords, Color.ORANGE);
        bs.graph(BSmeanRand, xCords, Color.PINK);
        bs.display("Bubble Sort");
        /* quick */
        Grapher qs = new Grapher();
        qs.graph(QSmeanSort, xCords, Color.BLUE);
        qs.graph(QSmeanRev, xCords, Color.ORANGE);
        qs.graph(QSmeanRand, xCords, Color.PINK);
        qs.display("Quick Sort");
        /* merge */
        Grapher ms = new Grapher();
        ms.graph(MSmeanSort, xCords, Color.BLUE);
        ms.graph(MSmeanRev, xCords, Color.ORANGE);
        ms.graph(MSmeanRand, xCords, Color.PINK);
        ms.display("Merge Sort");
    }
}