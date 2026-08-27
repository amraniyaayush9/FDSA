import java.util.Scanner;

public class HospitalTokenQueue1 {

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

    public static void deleteByValue(int token) {
        if (head == null) {
            System.out.println("Queue is empty. Cannot delete " + token);
            return;
        }

        if (head.token == token) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next != null && curr.next.token != token) {
            curr = curr.next;
        }

        if (curr.next == null) {
            System.out.println("Token " + token + " not found in queue.");
            return;
        }

        curr.next = curr.next.next;
    }

    public static void printForward() {
        Node curr = head;
        System.out.print("Front to Back: ");
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

    public static void printReverse(Node node) {
        if (node == null) {
            return;
        }
        printReverse(node.next);   
        System.out.print(node.token + " "); 
    }

    public static void printReverseWrapper() {
        System.out.print("Back to Front: ");
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        printReverse(head);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of operations: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Operations: FRONT <token> | END <token> | POS <token> <position> | DEL <token> | AUDIT | SHOW");

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String op = parts[0].toUpperCase();

            switch (op) {
                case "FRONT":
                    insertAtFront(Integer.parseInt(parts[1]));
                    printForward();
                    break;
                case "END":
                    insertAtEnd(Integer.parseInt(parts[1]));
                    printForward();
                    break;
                case "POS":
                    insertAtPosition(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    printForward();
                    break;
                case "DEL":
                    deleteByValue(Integer.parseInt(parts[1]));
                    printForward();
                    break;
                case "AUDIT":
                    printReverseWrapper();
                    break;
                case "SHOW":
                    printForward();
                    break;
                default:
                    System.out.println("Unknown operation: " + op);
            }
        }

        sc.close();
    }
}
