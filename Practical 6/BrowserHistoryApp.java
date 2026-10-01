
import java.util.Scanner;

class BrowserHistory {

    class Node {
        String page;
        Node next;

        Node(String page) {
            this.page = page;
            this.next = null;
        }
    }

    Node top;

    void visit(String page) {
        Node newNode = new Node(page);

        newNode.next = top;
        top = newNode;

        System.out.println("Visited: " + page);
        displayCurrent();
    }

    void back() {
        if (top == null || top.next == null) {
            System.out.println("Error: No previous page available.");
            displayCurrent();
            return;
        }

        String removed = top.page;
        top = top.next;

        System.out.println("Back from: " + removed);
        displayCurrent();
    }

    void displayCurrent() {
        if (top == null) {
            System.out.println("Current page: No page visited");
        } else {
            System.out.println("Current page: " + top.page);
        }

        System.out.println("--------------------");
    }
}

public class BrowserHistoryApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BrowserHistory browser = new BrowserHistory();

        int choice;

        do {
            System.out.println("1. Visit Page");
            System.out.println("2. Back");
            System.out.println("3. Display Current Page");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter page URL: ");
                    String page = sc.nextLine();
                    browser.visit(page);
                    break;

                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.displayCurrent();
                    break;

                case 0:
                    System.out.println("Browser closed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
