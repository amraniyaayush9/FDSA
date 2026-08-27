import java.util.Scanner;

public class  {

    public static int[] bubbleSort(int[] marks) {
        int[] arr = marks.clone();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] marks) {
        int[] arr = marks.clone();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] insertionSort(int[] marks) {
        int[] arr = marks.clone();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of answer sheets: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] marks = new int[n];
        System.out.println("Enter marks on each sheet:");
        for (int i = 0; i < n; i++) {
            marks[i] = Integer.parseInt(sc.nextLine().trim());
        }

        int[] bubbleResult = bubbleSort(marks);
        int[] selectionResult = selectionSort(marks);
        int[] insertionResult = insertionSort(marks);

        System.out.print("Bubble Sort:    ");
        printArray(bubbleResult);

        System.out.print("Selection Sort: ");
        printArray(selectionResult);

        System.out.print("Insertion Sort: ");
        printArray(insertionResult);

        sc.close();
    }
}
