/**
 * Queue definitions.
 */
public interface QueueInterface<Type> {
    /**
     * Add an element to the end of the queue.
     */
    void enQueue(Type element);

    /**
     * Remove an element from the front of the queue.
     */
    Type deQueue();

    /**
     * Check if the queue is empty.
     *
     * @return If the queue is empty.
     */
    boolean isEmpty();

    /**
     * Check if the queue is full.
     *
     * @return If the queue is full.
     */
    boolean isFull();

    /**
     * Get the value of the front of the queue without removing it.
     */
    Type peek();
}
