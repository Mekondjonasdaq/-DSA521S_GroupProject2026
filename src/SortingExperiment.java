// PART C - Algorithm Experiment
// Compares Selection Sort, Insertion Sort, Merge Sort and Quick Sort
// using arrays of size 20, 50, 100, and 500.
//
// Measures:
//   - Number of comparisons between data values only
//   - Execution time of the sorting call only (in nanoseconds)
//
// NOTE: The four sorting algorithms below are instrumented copies.
//       They are used only in this experiment file (Part C).
//       Part B's original algorithms remain in TheSorting.java.

import java.util.Random;

public class SortingExperiment {

    // Shared comparison counter for all four algorithms
    static long comparisons = 0;


    // =====================================================
    // 1. SELECTION SORT
    // =====================================================
    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                comparisons++;                          // count this comparison
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp      = arr[i];
                arr[i]        = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }


    // =====================================================
    // 2. INSERTION SORT
    // =====================================================
    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j   = i - 1;

            while (j >= 0) {
                comparisons++;                          // count this comparison
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }


    // =====================================================
    // 3. MERGE SORT
    // =====================================================
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            comparisons++;                              // count this comparison
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) { arr[k] = L[i]; i++; k++; }
        while (j < n2) { arr[k] = R[j]; j++; k++; }
    }


    // =====================================================
    // 4. QUICK SORT
    // =====================================================
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;                              // count this comparison
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i]   = arr[j];
                arr[j]   = temp;
            }
        }
        int temp   = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high]  = temp;

        return i + 1;
    }


    // =====================================================
    // HELPERS
    // =====================================================

    // Generate a random array of the given size (values 1 to 1000)
    static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000) + 1;
        }
        return arr;
    }

    // Return a copy of an array
    static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }

    // Map algorithm number to display name
    static String algorithmName(int a) {
        if (a == 1) return "Selection Sort";
        if (a == 2) return "Insertion Sort";
        if (a == 3) return "Merge Sort";
        if (a == 4) return "Quick Sort";
        return "Unknown";
    }


    // =====================================================
    // RUN ONE ALGORITHM ON ONE ARRAY - TIMED AND COUNTED
    // =====================================================
    // algorithm: 1=Selection, 2=Insertion, 3=Merge, 4=Quick
    static void runOne(int algorithm, int[] source) {

        int[] copy = copyArray(source);                 // fresh copy each time
        comparisons = 0;                                // reset counter

        long startTime = System.nanoTime();             // START timer

        if (algorithm == 1) selectionSort(copy);
        if (algorithm == 2) insertionSort(copy);
        if (algorithm == 3) mergeSort(copy, 0, copy.length - 1);
        if (algorithm == 4) quickSort(copy, 0, copy.length - 1);

        long endTime = System.nanoTime();               // STOP timer
        long timeNs  = endTime - startTime;

        // Print: size | algorithm | comparisons | time
        System.out.printf("%-6d %-16s %-14d %-14d%n",
                source.length, algorithmName(algorithm), comparisons, timeNs);
    }


    // =====================================================
    // MAIN - RUN THE WHOLE EXPERIMENT
    // =====================================================
    public static void main(String[] args) {

        // Sizes required by the brief
        int[] sizes = { 20, 50, 100, 500 };

        System.out.println();
        System.out.println("========= PART C: SORTING ALGORITHM EXPERIMENT =========");
        System.out.println();
        System.out.printf("%-6s %-16s %-14s %-14s%n",
                "Size", "Algorithm", "Comparisons", "Time (ns)");
        System.out.println("----------------------------------------------------------");

        // For each size, generate ONE original array, give each algorithm a copy
        for (int size : sizes) {
            int[] original = generateArray(size);

            runOne(1, original);   // Selection Sort
            runOne(2, original);   // Insertion Sort
            runOne(3, original);   // Merge Sort
            runOne(4, original);   // Quick Sort

            System.out.println("----------------------------------------------------------");
        }

        // =============== ALMOST-SORTED TEST ===============
        System.out.println();
        System.out.println("===== ALMOST-SORTED TEST (size 100) =====");
        System.out.printf("%-6s %-16s %-14s %-14s%n",
                "Size", "Algorithm", "Comparisons", "Time (ns)");
        System.out.println("----------------------------------------------------------");

        // Build a nearly-sorted array: 1, 2, 3, ..., 100
        int[] almostSorted = new int[100];
        for (int i = 0; i < 100; i++) almostSorted[i] = i + 1;

        // Swap FIVE pairs of neighbouring values to make it "almost" sorted
        swap(almostSorted, 10, 11);
        swap(almostSorted, 30, 31);
        swap(almostSorted, 50, 51);
        swap(almostSorted, 70, 71);
        swap(almostSorted, 90, 91);

        runOne(1, almostSorted);
        runOne(2, almostSorted);
        runOne(3, almostSorted);
        runOne(4, almostSorted);
        System.out.println("----------------------------------------------------------");
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
}