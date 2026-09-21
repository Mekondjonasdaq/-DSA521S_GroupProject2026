public class Main {
    public static void main(String[] args) {

        // ==========================================
        // STEP 1: Create the queue
        // ==========================================
        TheQueue q = new TheQueue();

        // ==========================================
        // STEP 2: Create 6 students
        // ==========================================
        Student s1 = new Student(221045678, "Maria", "Registration", 12);
        Student s2 = new Student(222034512, "Tomas", "Student Card", 5);
        Student s3 = new Student(223041876, "Ndapewa", "Fees", 8);
        Student s4 = new Student(221067341, "Simon", "Documents", 4);
        Student s5 = new Student(224012345, "Anna", "Academic", 6);
        Student s6 = new Student(225067890, "John", "Registration", 10);

        // ==========================================
        // STEP 3: 6 students arrive (enqueue)
        // ==========================================
        System.out.println("=== STUDENTS ARRIVING ===\n");
        q.enqueue(s1);
        q.enqueue(s2);
        q.enqueue(s3);
        q.enqueue(s4);
        q.enqueue(s5);
        q.enqueue(s6);

        // ==========================================
        // STEP 4: Show all waiting
        // ==========================================
        System.out.println();
        q.displayQueue();

        // ==========================================
        // STEP 5: Check who is first
        // ==========================================
        System.out.println();
        q.peek();

        // ==========================================
        // STEP 6: 3 students served (dequeue)
        // ==========================================
        System.out.println("\n=== SERVING STUDENTS ===\n");
        q.dequeue();
        q.dequeue();
        q.dequeue();

        // ==========================================
        // STEP 7: Show remaining
        // ==========================================
        System.out.println();
        q.displayQueue();

        // ==========================================
        // STEP 8: Check if empty
        // ==========================================
        System.out.println();
        System.out.println("Is queue empty? " + q.isEmpty());
    }
}