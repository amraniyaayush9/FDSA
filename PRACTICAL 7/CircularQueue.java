public class CircularQueue {
    int n = 5;
    int q[] = new int[n];
    int front = -1, rear = -1;

    void join(int x) {
        if ((rear + 1) % n == front) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1)
            front = 0;

        rear = (rear + 1) % n;
        q[rear] = x;
        printFront();
    }

    void serve() {
        if (front == -1) {
            System.out.println("Underflow");
            return;
        }

        System.out.println("Served: " + q[front]);

        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % n;

        printFront();
    }

    void printFront() {
        if (front == -1)
            System.out.println("Queue is Empty");
        else
            System.out.println("Front: " + q[front]);
    }

    public static void main(String[] args) {
        CircularQueue obj = new CircularQueue();

        obj.join(10);
        obj.join(20);
        obj.join(30);
        obj.serve();
        obj.join(40);
        obj.join(50);
        obj.join(60);
    }
}
