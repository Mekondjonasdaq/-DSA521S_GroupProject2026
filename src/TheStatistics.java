
public class TheStatistics {

    // Display helper - prints the array contents
    public static void display(int arr[]) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    // A4: total students served
    public static int totalStudentsServed(int arr[]) {
        return arr.length;
    }

    // A4: total service time (manual sum, no built-in sum())
    public static int totalServiceTime(int arr[]) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
        }
        return total;
    }

    // A4: average service time
    public static double averageServiceTime(int arr[]) {
        return (double) totalServiceTime(arr) / arr.length;
    }

    // A4: highest service time (manual search, no built-in max())
    public static int highestServiceTime(int arr[]) {
        int highest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > highest) {
                highest = arr[i];
            }
        }
        return highest;
    }

    // A4: lowest service time (manual search, no built-in min())
    public static int lowestServiceTime(int arr[]) {
        int lowest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < lowest) {
                lowest = arr[i];
            }
        }
        return lowest;
    }

    // A4: number of services longer than 10 minutes
    public static int servicesLongerThan10(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 10) {
                count++;
            }
        }
        return count;
    }

    // MAIN - Test A4: Daily Statistics

    public static void main(String[] args) {

        // A4: DAILY STATISTICS

        System.out.println(" A4: DAILY STATISTICS ");
        int arr1[] = {12, 5, 8, 4, 15, 3};
        System.out.print("Service times: ");
        display(arr1);

        System.out.println("Total students served      : " + totalStudentsServed(arr1));
        System.out.println("Total service time (min)   : " + totalServiceTime(arr1));
        System.out.println("Average service time (min) : " + averageServiceTime(arr1));
        System.out.println("Highest service time (min) : " + highestServiceTime(arr1));
        System.out.println("Lowest service time (min)  : " + lowestServiceTime(arr1));
        System.out.println("Services longer than 10min : " + servicesLongerThan10(arr1));
        System.out.println();
    }
}
