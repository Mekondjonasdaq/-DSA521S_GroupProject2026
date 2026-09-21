public class Student {

    // 4  information about the student
    int studentNo;
    String name;
    String serviceType;
    int serviceTime;

    // Constructor - runs when we create a new Student
    Student(int id, String n, String service, int time) {
        studentNo = id;
        name = n;
        serviceType = service;
        serviceTime = time;
    }

    // Display the student's info in one line
    void display() {
        System.out.println("ID: " + studentNo
                + ", Name: " + name
                + ", Service: " + serviceType
                + ", Time: " + serviceTime + " min");
    }
}
