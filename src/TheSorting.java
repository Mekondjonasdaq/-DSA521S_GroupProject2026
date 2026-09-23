public class TheSorting {


    // B1: SELECTION SORT


    static void selectionSort(int arr[]) {
        int n = arr.length;           // Get array length
        int comparisons = 0;          // Counter for comparisons
        int swaps = 0;                // Counter for swaps

        // Loop through each position
        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;         // Assume current position has minimum

            // Find the smallest element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                comparisons++;        // We're comparing two numbers

                // If we find something smaller, remember its position
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // If the minimum is not already in position, swap
            if (minIndex != i) {
                int temp = arr[i];            // Save current value
                arr[i] = arr[minIndex];       // Move minimum here
                arr[minIndex] = temp;         // Put old value where min was
                swaps++;                      // Count this swap
            }

            // Show state after pass 1, 2, 3
            if (i < 3) {
                System.out.print("After pass " + (i + 1) + ": ");
                display(arr);
            }
        }

        // Show final counts
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
    }



    // B2: INSERTION SORT


    static void insertionSort(int arr[]) {
        int n = arr.length;           // Get array length
        int comparisons = 0;          // Counter for comparisons
        int shifts = 0;               // Counter for shifts

        // Start from second element
        for (int i = 1; i < n; i++) {

            int key = arr[i];         // Current element to insert
            int j = i - 1;            // Start comparing with element before

            // Shift all larger elements one position to the right
            while (j >= 0 && arr[j] > key) {
                comparisons++;        // We're comparing
                arr[j + 1] = arr[j];  // Move element right
                shifts++;             // Count this shift
                j = j - 1;            // Move to previous element
            }
            comparisons++;            // Count final comparison (when loop stops)

            arr[j + 1] = key;         // Place key in correct position

            // Show state after pass 1, 2, 3
            if (i < 4) {
                System.out.print("After pass " + i + ": ");
                display(arr);
            }
        }

        // Show final counts
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Shifts: " + shifts);
    }



    // B3: MERGE SORT


    static void mergeSort(int arr[], int left, int right) {

        // Only sort if there's more than one element
        if (left < right) {

            int mid = (left + right) / 2;      // Find middle point

            mergeSort(arr, left, mid);          // Sort left half
            mergeSort(arr, mid + 1, right);     // Sort right half

            merge(arr, left, mid, right);       // Merge the two halves
        }
    }

    static void merge(int arr[], int left, int mid, int right) {

        // Sizes of the two halves
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the two arrays back into original
        int i = 0;      // Index for left array
        int j = 0;      // Index for right array
        int k = left;   // Index for merged array

        // Compare elements from left and right, add smaller one
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left array
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements from right array
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }



    // B4: QUICK SORT


    static void quickSort(int arr[], int low, int high) {

        // Only sort if there's more than one element
        if (low < high) {

            int pi = partition(arr, low, high);    // Get pivot position

            quickSort(arr, low, pi - 1);           // Sort left of pivot
            quickSort(arr, pi + 1, high);          // Sort right of pivot
        }
    }

    static int partition(int arr[], int low, int high) {

        // Choose the last element as pivot
        int pivot = arr[high];

        int i = low - 1;    // Index of smaller element

        // Compare each element with pivot
        for (int j = low; j < high; j++) {

            // If current element is smaller than pivot
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;   // Return pivot position
    }



    // Display array in [a, b, c, ...] format


    static void display(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }



    // MAIN - Test all 4 sorts


    public static void main(String[] args) {


        // B1: SELECTION SORT

        System.out.println("  B1: SELECTION SORT  ");
        int arr1[] = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};
        System.out.print("Original: ");
        display(arr1);
        selectionSort(arr1);
        System.out.print("Sorted:   ");
        display(arr1);
        System.out.println();


        // B2: INSERTION SORT

        System.out.println(" INSERTION SORT");
        int arr2[] = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};
        System.out.print("Original: ");
        display(arr2);
        insertionSort(arr2);
        System.out.print("Sorted:   ");
        display(arr2);
        System.out.println();


        // B3: MERGE SORT

        System.out.println("B3: MERGE SORT");
        int arr3[] = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};
        System.out.print("Original: ");
        display(arr3);
        mergeSort(arr3, 0, arr3.length - 1);
        System.out.print("Sorted:   ");
        display(arr3);
        System.out.println();


        // B4: QUICK SORT

        System.out.println("B4: QUICK SORT ");
        int arr4[] = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};
        System.out.print("Original: ");
        display(arr4);
        quickSort(arr4, 0, arr4.length - 1);
        System.out.print("Sorted:   ");
        display(arr4);
    }
}