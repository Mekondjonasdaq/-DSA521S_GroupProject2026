// Import Scanner to read user input
import java.util.Scanner;

public class MenuSystem {
    
    public static void main(String[] args) {
        
        // Create the queue for waiting students
        TheQueue queue = new TheQueue();
        
        // Create the linked list for student records
        ServiceList records = new ServiceList();
        
        // Array to store service times of served students
        int times[] = new int[100];
        int count = 0;
        
        // Scanner to read user input
        Scanner sc = new Scanner(System.in);
        
        // Variable to store user's menu choice
        int choice = 0;
        
        // Keep showing menu until user picks 11 (Exit)
        while (choice != 11) {
            
            System.out.println("\n--- CAMPUS SERVICE CENTRE ---");
            System.out.println("1. Add student to queue");
            System.out.println("2. Serve next student");
            System.out.println("3. Display waiting students");
            System.out.println("4. Add student record");
            System.out.println("5. Display student records");
            System.out.println("6. Search student record");
            System.out.println("7. Remove student record");
            System.out.println("8. Display daily statistics");
            System.out.println("9. Sort service times");
            System.out.println("10. Run sorting experiment");
            System.out.println("11. Exit");
            System.out.print("Choose: ");
            
            choice = sc.nextInt();
            sc.nextLine();
            
            // OPTION 1: Add student to queue
            if (choice == 1) {
                System.out.print("Enter Student No: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Service Type: ");
                String service = sc.nextLine();
                System.out.print("Enter Service Time: ");
                int time = sc.nextInt();
                queue.enqueue(new Student(id, name, service, time));
            }
            
            // OPTION 2: Serve next student
            else if (choice == 2) {
                Student served = queue.dequeue();
                if (served != null) {
                    times[count] = served.serviceTime;
                    count++;
                }
            }
            
            // OPTION 3: Display waiting students
            else if (choice == 3) {
                queue.displayQueue();
            }
            
            // OPTION 4: Add student record
            else if (choice == 4) {
                System.out.print("Enter Student No: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Service Type: ");
                String service = sc.nextLine();
                System.out.print("Enter Service Time: ");
                int time = sc.nextInt();
                records.insertStudent(new Student(id, name, service, time), "end", 0);
            }
            
            // OPTION 5: Display student records
            else if (choice == 5) {
                records.displayStudents();
            }
            
            // OPTION 6: Search student record
            else if (choice == 6) {
                System.out.print("Enter Student No: ");
                int id = sc.nextInt();
                Student found = records.searchStudent(id);
                if (found != null) {
                    found.display();
                }
            }
            
            // OPTION 7: Remove student record
            else if (choice == 7) {
                System.out.print("Enter Student No: ");
                int id = sc.nextInt();
                records.deleteStudent(id);
            }
            
            // OPTION 8: Display daily statistics
            else if (choice == 8) {
                if (count == 0) {
                    System.out.println("No students served yet!");
                } else {
                    int served[] = new int[count];
                    for (int i = 0; i < count; i++) {
                        served[i] = times[i];
                    }
                    System.out.println("Total students: " + TheStatistics.totalStudentsServed(served));
                    System.out.println("Total time: " + TheStatistics.totalServiceTime(served));
                    System.out.println("Average: " + TheStatistics.averageServiceTime(served));
                    System.out.println("Highest: " + TheStatistics.highestServiceTime(served));
                    System.out.println("Lowest: " + TheStatistics.lowestServiceTime(served));
                    System.out.println("Over 10 min: " + TheStatistics.servicesLongerThan10(served));
                }
            }
            
            // OPTION 9: Sort service times
            else if (choice == 9) {
                if (count == 0) {
                    System.out.println("No times to sort!");
                } else {
                    int sorted[] = new int[count];
                    for (int i = 0; i < count; i++) {
                        sorted[i] = times[i];
                    }
                    System.out.print("Original: ");
                    TheSorting.display(sorted);
                    System.out.println("1=Selection 2=Insertion 3=Merge 4=Quick");
                    System.out.print("Choose: ");
                    int c = sc.nextInt();
                    if (c == 1) TheSorting.selectionSort(sorted);
                    else if (c == 2) TheSorting.insertionSort(sorted);
                    else if (c == 3) TheSorting.mergeSort(sorted, 0, sorted.length - 1);
                    else if (c == 4) TheSorting.quickSort(sorted, 0, sorted.length - 1);
                    System.out.print("Sorted: ");
                    TheSorting.display(sorted);
                }
            }
            
            // OPTION 10: Run sorting experiment
            else if (choice == 10) {
                SortingExperiment.main(null);
            }
            
            // OPTION 11: Exit
            else if (choice == 11) {
                System.out.println("Goodbye!");
            }
            
            // Invalid choice
            else {
                System.out.println("Invalid choice!");
            }
        }
        
        sc.close();
    }
}