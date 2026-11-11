import java.util.ArrayList;
import java.util.LinkedList;

public class LibrarySeparateChaining {
    static final int SIZE = 10;
    static ArrayList<LinkedList<Integer>> table = new ArrayList<>();

    static void insert(int code) {
        int index = Math.floorMod(code, SIZE);
        table.get(index).add(code);
        System.out.println(code + " added to shelf " + index);
    }

    static void display() {
        System.out.println("\nFinal Shelf Contents:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + " : " + table.get(i));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            table.add(new LinkedList<>());
        }

        int[] bookCodes = {101, 205, 311, 415, 520, 125, 230, 335, 440};

        for (int code : bookCodes) {
            insert(code);
        }

        display();
    }
}
