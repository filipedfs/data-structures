/**
 * Queue implementation.
 */
public class Queue<Type> implements QueueInterface<Type> {
    private static final int SIZE = 5;
    Type[] items = (Type[]) new Object[SIZE];

    /**
     * Track the first element of the queue.
     */
    private int front;

    /**
     * Track the last element of the queue.
     */
    private int rear;

    public Queue() {
        // Initialize the pointers with -1.
        this.front = -1;
        this.rear = -1;
    }

    /**
     * @see QueueInterface#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * @see QueueInterface#isFull()
     */
    @Override
    public boolean isFull() {
        return front == 0 && rear == SIZE - 1;
    }

    /**
     * @see QueueInterface#enQueue(Object)
     */
    public void enQueue(Type element) {
        // 1. Check if the queue is full.
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                // 2. For the first element, set the value of front to 0.
                front = 0;
            }
            // 3. Increase the rear index by 1.
            rear++;
            // 4. Add the new element in the position pointed to by rear.
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    @Override
    public Type deQueue() {

        Type element;

        // 1. Check if the queue is empty.
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            // 2. Return the value pointed by front.
            element = items[front];
            if (front >= rear) {
                // 3. For the last element, reset the values of front and rear to -1.
                front = -1;
                rear = -1;
            } else {
                // 3. Increase the front index by 1.
                front++;
            }
            System.out.println("Deleted -> " + element);
            return (element);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty queue");
        } else {
            System.out.println("\nFront index -> " + front);
            System.out.println("Items -> ");
            for (int i = front; i <= rear; i++) {
                System.out.println(items[i] + " ");
            }

            System.out.println("\nRear index -> " + rear);
        }
    }

    @Override
    public Type peek() {
        return front >= 0 ? this.items[front] : null;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();

        // deQueue is not possible on empty queue
        q.deQueue();

        // enQueue 5 elements
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // 6th element can't be added to queue because queue is full
        q.enQueue(6);

        q.display();

        q.deQueue();

        System.out.println(q.peek());

        q.display();
    }
}
