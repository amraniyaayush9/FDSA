import java.util.Scanner;

public class BakeryDisplay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items (n): ");
        int n = sc.nextInt();

        String[] items = new String[n];
        System.out.println("Enter " + n + " item names:");
        for (int i = 0; i < n; i++) {
            items[i] = sc.next();
        }

        System.out.print("Enter number of hours (h): ");
        long h = sc.nextLong();

        String[] result = rotateLeft(items, h);

        System.out.println("Final display order:");
        for (String item : result) {
            System.out.print(item + " ");
        }
        System.out.println();

        sc.close();
    }

    public static String[] rotateLeft(String[] items, long h) {
        int n = items.length;
        if (n == 0) return items;

        int shift = (int) (h % n);

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = items[(i + shift) % n];
        }
        return result;
    }
}