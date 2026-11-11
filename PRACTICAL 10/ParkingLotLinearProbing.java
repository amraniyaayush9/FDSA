public class ParkingLotLinearProbing {
    static final int SIZE = 10;
    static final int[] table = new int[SIZE];

    static void insert(int registration) {
        int index = Math.abs(registration % 10);

        for (int i = 0; i < SIZE; i++) {
            int slot = (index + i) % SIZE;

            if (table[slot] == 0) {
                table[slot] = registration;
                System.out.println(registration + " assigned to slot " + slot);
                return;
            }
        }

        System.out.println("Parking full. Cannot insert " + registration);
    }

    static void display() {
        System.out.println("\nFinal Parking Slots:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + " : " + (table[i] == 0 ? "Empty" : table[i]));
        }
    }

    public static void main(String[] args) {
        int[] registrations = {1234, 5678, 9012, 3456, 7890, 2468, 1357};

        for (int registration : registrations) {
            insert(registration);
        }

        display();
    }
}
