// Task A2 - Student Service Records: Singly Linked List
// Each node holds a Student record and a next pointer.
// Required operations: insertStudent(), deleteStudent(), searchStudent(), displayStudents()

public class ServiceList {

    // ========== NODE CLASS ==========
    class Node {
        Student data;   // the student record
        Node    next;   // link to the next node

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    // ========== LIST HEAD & SIZE ==========
    Node head = null;
    int  size = 0;


    // ========== INSERT AT BEGINNING ==========
    void insertAtBeginning(Student s) {
        Node newNode = new Node(s);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Inserted at beginning: " + s.name);
    }


    // ========== INSERT AT END ==========
    void insertAtEnd(Student s) {
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Inserted at end: " + s.name);
    }


    // ========== INSERT AT POSITION ==========
    // position 1 = first, position size+1 = last
    void insertAtPosition(Student s, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position: " + position);
            return;
        }
        if (position == 1) {
            insertAtBeginning(s);
            return;
        }

        Node newNode = new Node(s);
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Inserted at position " + position + ": " + s.name);
    }


    // ========== WRAPPER: matches spec's required insertStudent() ==========
    // mode: "start", "end", or "position"
    void insertStudent(Student s, String mode, int position) {
        if (mode.equalsIgnoreCase("start")) {
            insertAtBeginning(s);
        } else if (mode.equalsIgnoreCase("end")) {
            insertAtEnd(s);
        } else if (mode.equalsIgnoreCase("position")) {
            insertAtPosition(s, position);
        } else {
            System.out.println("Invalid insert mode: " + mode);
        }
    }


    // ========== DELETE BY STUDENT NUMBER ==========
    boolean deleteStudent(int studentNo) {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return false;
        }

        // Case 1: delete the head node
        if (head.data.studentNo == studentNo) {
            System.out.println("Deleted: " + head.data.name);
            head = head.next;
            size--;
            return true;
        }

        // Case 2: delete middle or last node
        Node current = head;
        while (current.next != null && current.next.data.studentNo != studentNo) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student with number " + studentNo + " not found.");
            return false;
        }

        System.out.println("Deleted: " + current.next.data.name);
        current.next = current.next.next;
        size--;
        return true;
    }


    // ========== SEARCH BY STUDENT NUMBER ==========
    Student searchStudent(int studentNo) {
        Node current = head;
        while (current != null) {
            if (current.data.studentNo == studentNo) {
                System.out.println("Found: " + current.data.name);
                return current.data;
            }
            current = current.next;
        }
        System.out.println("Student with number " + studentNo + " not found.");
        return null;
    }


    // ========== DISPLAY / TRAVERSAL ==========
    void displayStudents() {
        if (head == null) {
            System.out.println("No student records yet.");
            return;
        }

        System.out.println("--- Student Service Records ---");
        System.out.printf("%-4s %-12s %-10s %-15s %-6s%n",
                "No.", "Student No", "Name", "Service Type", "Time");
        System.out.println("----------------------------------------------------------");

        Node current = head;
        int i = 1;
        while (current != null) {
            System.out.printf("%-4d %-12d %-10s %-15s %-4d min%n",
                    i,
                    current.data.studentNo,
                    current.data.name,
                    current.data.serviceType,
                    current.data.serviceTime);
            current = current.next;
            i++;
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Total records: " + size);
    }
}