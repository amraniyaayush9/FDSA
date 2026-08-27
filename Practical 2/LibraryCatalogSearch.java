import java.util.Scanner;

public class LibraryCatalogSearch {

   
    public static int iterativeBinarySearch(int[] codes, int target) {
        int low = 0, high = codes.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (codes[mid] == target) {
                return mid;
            } else if (codes[mid] < target) {
                low = mid + 1;   
            } else {
                high = mid - 1;  
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] codes, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (codes[mid] == target) {
            return mid;
        } else if (codes[mid] < target) {
            return recursiveBinarySearch(codes, target, mid + 1, high); 
        } else {
            return recursiveBinarySearch(codes, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of book codes: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] codes = new int[n];
        System.out.println("Enter " + n + " book codes in sorted order:");
        for (int i = 0; i < n; i++) {
            codes[i] = Integer.parseInt(sc.nextLine().trim());
        }

        System.out.print("Enter target book code: ");
        int target = Integer.parseInt(sc.nextLine().trim());

        int posIterative = iterativeBinarySearch(codes, target);
        int posRecursive = recursiveBinarySearch(codes, target, 0, codes.length - 1);

        System.out.println("\n--- Results ---");
        System.out.println("Iterative search: " +
                (posIterative != -1 ? "Found at position " + posIterative : "Not found"));
        System.out.println("Recursive search: " +
                (posRecursive != -1 ? "Found at position " + posRecursive : "Not found"));

        sc.close();
    }
}
