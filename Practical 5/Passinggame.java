
import java.util.Scanner;

class SinglyCircularList {

    class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    Node head, tail;
    int size = 0;

    void join(String name, int pos) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(name);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        }
        else if (pos == 1) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        else if (pos == size + 1) {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        else {
            Node current = head;

            for (int i = 1; i < pos - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
        display();
    }

    void leave(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if (size == 1) {
            head = tail = null;
        }
        else if (pos == 1) {
            head = head.next;
            tail.next = head;
        }
        else {
            Node current = head;

            for (int i = 1; i < pos - 1; i++) {
                current = current.next;
            }

            Node deleted = current.next;
            current.next = deleted.next;

            if (deleted == tail) {
                tail = current;
            }

            tail.next = head;
        }

        size--;
        display();
    }

    void display() {
        System.out.print("Singly Circular: ");

        if (head == null) {
            System.out.println("Empty");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.name + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to " + head.name + ")");
        System.out.println("Students: " + size);
    }
}

class DoublyCircularList {

    class Node {
        String name;
        Node next, prev;

        Node(String name) {
            this.name = name;
        }
    }

    Node head, tail;
    int size = 0;

    void join(String name, int pos) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(name);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }
        else if (pos == 1) {
            newNode.next = head;
            newNode.prev = tail;

            head.prev = newNode;
            tail.next = newNode;

            head = newNode;
        }
        else {
            Node current = head;

            for (int i = 1; i < pos - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;

            current.next.prev = newNode;
            current.next = newNode;

            if (pos == size + 1) {
                tail = newNode;
            }
        }

        size++;
        display();
    }

    void leave(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if (size == 1) {
            head = tail = null;
        }
        else {
            Node current = head;

            for (int i = 1; i < pos; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;

            if (current == head) {
                head = current.next;
            }

            if (current == tail) {
                tail = current.prev;
            }

            head.prev = tail;
            tail.next = head;
        }

        size--;
        display();
    }

    void display() {
        System.out.print("Doubly Circular: ");

        if (head == null) {
            System.out.println("Empty");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.name + " <-> ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to " + head.name + ")");
        System.out.println("Students: " + size);
    }
}

public class Passinggame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SinglyCircularList singly = new SinglyCircularList();
        DoublyCircularList doubly = new DoublyCircularList();

        int choice;

        do {
            System.out.println("\n1. Join Student");
            System.out.println("2. Leave Student");
            System.out.println("3. Display Circle");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter position: ");
                    int joinPos = sc.nextInt();

                    singly.join(name, joinPos);
                    doubly.join(name, joinPos);
                    break;

                case 2:
                    System.out.print("Enter position to leave: ");
                    int leavePos = sc.nextInt();

                    singly.leave(leavePos);
                    doubly.leave(leavePos);
                    break;

                case 3:
                    singly.display();
                    doubly.display();
                    break;

                case 0:
                    System.out.println("Game ended.");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
