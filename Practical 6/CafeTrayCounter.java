
import java.util.Scanner;

class TrayStack {
    int[] stack;
    int top;
    int capacity;

    TrayStack(int n) {
        capacity = n;
        stack = new int[n];
        top = -1;
    }

    void push(int tray) {
        if (top == capacity - 1) {
            System.out.println("Error: Stack Overflow! Counter is full.");
            displayTop();
            return;
        }

        stack[++top] = tray;
        System.out.println("Tray placed: " + tray);
        displayTop();
    }

    void pop() {
        if (top == -1) {
            System.out.println("Error: Stack Underflow! Counter is empty.");
            displayTop();
            return;
        }

        int removed = stack[top--];
        System.out.println("Tray taken: " + removed);
        displayTop();
    }

    void displayTop() {
        if (top == -1) {
            System.out.println("Current top: Empty");
        } else {
            System.out.println("Current top: " + stack[top]);
        }

        System.out.println("--------------------");
    }
}

public class CafeTrayCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack capacity: ");
        int n = sc.nextInt();

        TrayStack trays = new TrayStack(n);

        int choice;

        do {
            System.out.println("1. Place Tray (Push)");
            System.out.println("2. Take Tray (Pop)");
            System.out.println("3. Display Top");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter tray number: ");
                    int tray = sc.nextInt();
                    trays.push(tray);
                    break;

                case 2:
                    trays.pop();
                    break;

                case 3:
                    trays.displayTop();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
