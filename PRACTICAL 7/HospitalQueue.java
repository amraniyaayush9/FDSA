import java.util.LinkedList;
import java.util.Queue;

public class HospitalQueue {
    static Queue<String> patients = new LinkedList<>();

    static void arrive(String name) {
        patients.add(name);
        System.out.println("Arrived: " + name);
        displayFront();
    }

    static void attend() {
        if (patients.isEmpty()) {
            System.out.println("No patients waiting!");
        } else {
            System.out.println("Attended: " + patients.poll());
        }
        displayFront();
    }

    static void displayFront() {
        if (patients.isEmpty()) {
            System.out.println("Current Front: No patients");
        } else {
            System.out.println("Current Front: " + patients.peek());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arrive("Rahul");
        arrive("Amit");
        arrive("Priya");
        attend();
        attend();
        attend();
        attend();
    }
}
