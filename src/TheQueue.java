public class TheQueue {

    // VARIABLES

    Student queue[] = new Student[20];
    int front = -1;
    int rear = -1;


    // ENQUEUE - Adding student to the BACK

    void enqueue(Student student) {

        // Check 1: Is queue full?
        if (rear == 19) {
            System.out.println("Queue is full!");
            return;
        }

        // Check 2: Is queue empty?
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        }
        // Check 3: Queue has students
        else {
            rear = rear + 1;
        }

        // Place student at rear
        queue[rear] = student;
        System.out.println(student.name + " joined the queue.");
    }


    // DEQUEUE - Remove student from the FRONT

    void dequeue() {

        // Check 1: Is queue empty?
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty!");
            return;
        }

        // Show who is served
        System.out.println("Served: " + queue[front].name);

        // Check 2: Only ONE student?
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        // Check 3: More students remain
        else {
            front = front + 1;
        }
    }


    // PEEK - Look at first student (don't remove)

    void peek() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("First in line: " + queue[front].name);
        }
    }


    // ISEMPTY - Check if queue has no students

    boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        } else {
            return false;
        }
    }


    // DISPLAYQUEUE - Show all waiting students

    void displayQueue() {

        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("--- Waiting Queue ---");

        // Loop from front to rear
        for (int i = front; i <= rear; i++) {
            System.out.print((i - front + 1) + ". ");
            queue[i].display();
        }
    }
}