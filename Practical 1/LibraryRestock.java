import java.util.*;

public class LibraryRestock{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of borrow records: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        String[] log = new String[n];
        System.out.println("Enter book IDs one by one:");
        for (int i = 0; i < n; i++) {
            log[i] = sc.nextLine().trim();
        }

        Map<String, Integer> count = new HashMap<>();

        for (String id : log) {
            count.put(id, count.getOrDefault(id, 0) + 1);
        }

        System.out.println("Books needing priority restocking:");
        boolean found = false;
        for (String id : count.keySet()) {
            if (count.get(id) > 1) {
                System.out.println(id);
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        }

        sc.close();
    }
}