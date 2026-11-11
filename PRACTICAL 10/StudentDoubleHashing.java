public class StudentDoubleHashing {
    static final int SIZE = 10;
    static final int[] table = new int[SIZE];

    static int hash1(int id) {
        return Math.floorMod(id, SIZE);
    }

    static int hash2(int id) {
        int[] steps = {1, 3, 7, 9};
        return steps[Math.floorMod(id, steps.length)];
    }

    static void insert(int id) {
        int first = hash1(id);
        int step = hash2(id);

        for (int i = 0; i < SIZE; i++) {
            int index = (first + i * step) % SIZE;

            if (table[index] == 0) {
                table[index] = id;
                System.out.println(id + " assigned to slot " + index);
                return;
            }
        }

        System.out.println("Hash table full. Cannot insert " + id);
    }

    static void display() {
        System.out.println("\nFinal Hash Table:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + " : " + (table[i] == 0 ? "Empty" : table[i]));
        }
    }

    public static void main(String[] args) {
        int[] studentIds = {101, 111, 121, 131, 141, 151, 161};

        for (int id : studentIds) {
            insert(id);
        }

        display();
    }
}
