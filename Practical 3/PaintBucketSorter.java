import java.util.Scanner;

public class PaintBucketSorter {

    public static void sortColors(int[] buckets) {
        int low = 0, mid = 0, high = buckets.length - 1;

        while (mid <= high) {
            if (buckets[mid] == 0) {
                swap(buckets, low, mid);
                low++;
                mid++;
            } else if (buckets[mid] == 1) {
                mid++;
            } else { 
                swap(buckets, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of buckets: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] buckets = new int[n];
        System.out.println("Enter colour codes (0, 1, or 2) for each bucket:");
        for (int i = 0; i < n; i++) {
            buckets[i] = Integer.parseInt(sc.nextLine().trim());
        }

        sortColors(buckets);

        System.out.print("Arranged buckets: ");
        for (int val : buckets) {
            System.out.print(val + " ");
        }
        System.out.println();

        sc.close();
    }
}
