import java.lang.reflect.Array;

public class CircularQueue<Type> implements QueueInterface<Type> {
    private static final int SIZE = 5; // Size of the circular queue.
    /**
     * Track the first element of the queue.
     */
    private int front;
    /**
     * Track the last element of the queue.
     */
    private int rear;
    private Type[] items = (Type[]) new Object[SIZE];

    public CircularQueue() {
        // Initially, set value of front and rear to -1;
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public Type peek() {
        return front >= 0 ? this.items[front] : null;
    }

    @Override
    public void enQueue(Type element) {
        // 1. Check if the queue is full.
        if (this.isFull()) {
            System.out.println("Queue is full.");
        }
        else {
            // 2. For the first element, set value of front to 0.
            if (this.front == -1) {
                this.front = 0;
            }
            // 3. Circularly increase the rear index by 1 (i.e. if the rear reaches the end, next it would be at the start of the queue)
            this.rear = (rear + 1) % SIZE;

            items[this.rear] = element;
        }
    }

    @Override
    public Type deQueue() {
        Type element = null;
        // 1. Check if the queue is empty.
        if (this.isEmpty()) {
            System.out.println("Queue is empty.");
        }
        else {
            // 2. Return the value pointed by front.
            element = this.items[front];
            //3. Circularly increase the front index by 1.
            // 4. For the last element, reset the values of front and rear to -1.
            if (front == rear) {
                this.front = -1;
                this.rear = -1;
            } else {
                front = (front + 1) % SIZE;
            }
        }
        return element;
    }

    @Override
    public boolean isFull() {
        return front == 0 && rear == SIZE - 1 || front == rear + 1;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty queue");
        } else {
            int i;
            for (i = front; i != rear; i = ((i + 1) % SIZE)) {
                System.out.println(items[i]);
            }
            System.out.println(items[i]);
        }
    }

    public static void main(String[] args) {
        CircularQueue<Integer> q = new CircularQueue<>();

        // Fails because front = -1
        q.deQueue();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // Fails to enqueue because front == 0 && rear == SIZE - 1
        q.enQueue(6);

        q.display();

        int elem = q.deQueue();

        if (elem != -1) {
            System.out.println("Deleted Element is " + elem);
        }
        q.display();

        q.enQueue(7);

        q.display();

        // Fails to enqueue because front == rear + 1
        q.enQueue(8);
    }
}
