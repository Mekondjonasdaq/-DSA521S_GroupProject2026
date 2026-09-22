// Test driver for Task A2 - Singly Linked List
// Uses the exact students from the project brief (Section 4).

public class TestList {
    public static void main(String[] args) {

        ServiceList list = new ServiceList();

        // Students from the project brief
        Student s1 = new Student(221045678, "Maria",   "Registration", 12);
        Student s2 = new Student(222034512, "Tomas",   "Student Card",  5);
        Student s3 = new Student(223041876, "Ndapewa", "Fees",          8);
        Student s4 = new Student(221067341, "Simon",   "Documents",     4);

        System.out.println("=== INSERT AT BEGINNING ===");
        list.insertAtBeginning(s1);           // Maria first

        System.out.println("\n=== INSERT AT END ===");
        list.insertAtEnd(s2);                 // Tomas at end
        list.insertAtEnd(s3);                 // Ndapewa at end

        System.out.println("\n=== INSERT AT POSITION 2 (Simon) ===");
        list.insertAtPosition(s4, 2);         // Simon goes second

        System.out.println("\n=== DISPLAY LIST ===");
        list.displayStudents();

        System.out.println("\n=== SEARCH FOR Ndapewa (223041876) ===");
        Student found = list.searchStudent(223041876);
        if (found != null) {
            found.display();
        }

        System.out.println("\n=== DELETE Tomas (222034512) ===");
        list.deleteStudent(222034512);

        System.out.println("\n=== DISPLAY LIST AFTER DELETE ===");
        list.displayStudents();
    }
}