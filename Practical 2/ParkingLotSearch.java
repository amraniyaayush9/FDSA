import java.util.Scanner;

public class ParkingLotSearch {

    public static int iterativeSearch(String[] plates, String target) {
        for (int i = 0; i < plates.length; i++) {
            if (plates[i].equals(target)) {
                return i;   
            }
        }
        return -1;       
    }

    public static int recursiveSearch(String[] plates, String target, int index) {
        if (index >= plates.length) {
            return -1;                  
        }
        if (plates[index].equals(target)) {
            return index;                  
        }
        return recursiveSearch(plates, target, index + 1);  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        String[] plates = new String[n];
        System.out.println("Enter license plates one by one:");
        for (int i = 0; i < n; i++) {
            plates[i] = sc.nextLine().trim();
        }

        System.out.print("Enter target license plate: ");
        String target = sc.nextLine().trim();

        int posIterative = iterativeSearch(plates, target);

        System.out.println("\n--- Results ---");
        if (posIterative != -1) {
            System.out.println("Found at position " + posIterative);
        } else {
            System.out.println("Not found");
        }

       

        sc.close();
    }
}
