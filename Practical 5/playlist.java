
import java.util.Scanner;

class PlaylistList {

    class Node {
        String song;
        Node prev, next;

        Node(String song) {
            this.song = song;
            this.prev = null;
            this.next = null;
        }
    }

    Node head, tail;
    int count = 0;

    void addFirst(String song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        count++;
        display();
    }

    void addLast(String song) {
        Node newNode = new Node(song);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        count++;
        display();
    }

    void insertAfter(String target, String song) {
        Node current = head;

        while (current != null && !current.song.equals(target)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Song not found: " + target);
            display();
            return;
        }

        Node newNode = new Node(song);

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;

        count++;
        display();
    }

    void removeFirst() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            display();
            return;
        }

        System.out.println("Removed: " + head.song);

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        count--;
        display();
    }

    void display() {
        Node current = head;

        System.out.print("Playlist: ");

        while (current != null) {
            System.out.print(current.song + " ");
            current = current.next;
        }

        System.out.println("\nTotal songs: " + count);
        System.out.println("--------------------");
    }
}

public class Playlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlaylistList playlist = new PlaylistList();

        int choice;

        do {
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Insert After");
            System.out.println("4. Remove First");
            System.out.println("5. Display");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song: ");
                    playlist.addFirst(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter song: ");
                    playlist.addLast(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter target song: ");
                    String target = sc.nextLine();

                    System.out.print("Enter new song: ");
                    String song = sc.nextLine();

                    playlist.insertAfter(target, song);
                    break;

                case 4:
                    playlist.removeFirst();
                    break;

                case 5:
                    playlist.display();
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
