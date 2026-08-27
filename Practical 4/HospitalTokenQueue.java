import java.util.Scanner;

public class HospitalTokenQueue {

    static class Node {
        int token;
        Node next;

        Node(int token) {
            this.token = token;
        }
    }

    static Node head = null;

    public static void insertAtFront(int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
    }

    public static void insertAtEnd(int token) {
        Node newNode = new Node(token);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public static void insertAtPosition(int token, int position) {
        if (position <= 0 || head == null) {
            insertAtFront(token);
            return;
        }

        Node curr = head;
        int index = 0;
        while (index < position - 1 && curr.next != null) {
            curr = curr.next;
            index++;
        }

        Node newNode = new Node(token);
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public static void printQueue() {
        Node curr = head;
        System.out.print("Queue: ");
        if (curr == null) {
            System.out.println("(empty)");
            return;
        }
        while (curr != null) {
            System.out.print(curr.token + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of operations: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.println("For each operation enter: FRONT <token> | END <token> | POS <token> <position>");

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String op = parts[0].toUpperCase();

            if (op.equals("FRONT")) {
                int token = Integer.parseInt(parts[1]);
                insertAtFront(token);
            } else if (op.equals("END")) {
                int token = Integer.parseInt(parts[1]);
                insertAtEnd(token);
            } else if (op.equals("POS")) {
                int token = Integer.parseInt(parts[1]);
                int position = Integer.parseInt(parts[2]);
                insertAtPosition(token, position);
            } else {
                System.out.println("Unknown operation: " + op);
                continue;
            }

            printQueue();
        }

        sc.close();
    }
}
