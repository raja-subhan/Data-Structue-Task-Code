public class CircularQueue {

    private final int[] items;
    private int front;     // index of the first element
    private int rear;      // index of the last element
    private int count;     // number of elements currently stored
    private final int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    // Add an element at the rear
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % capacity;      // wrap around
        items[rear] = value;
        count++;
        System.out.println("Enqueued: " + value);
    }

    // Remove and return the element at the front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int value = items[front];
        front = (front + 1) % capacity;    // wrap around
        count--;
        System.out.println("Dequeued: " + value);
        return value;
    }

    // Show the element at the front without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return items[front];
    }

    // Display all elements from front to rear using a do-while loop
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        int i = 0;
        do {
            System.out.print(items[(front + i) % capacity] + " ");
            i++;
        } while (i < count);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        // fill the queue using a do-while loop
        int value = 10;
        do {
            q.enqueue(value);
            value += 10;
        } while (value <= 50);

        q.enqueue(60);          // queue is full
        q.display();

        q.dequeue();            // remove 10
        q.dequeue();            // remove 20
        q.display();

        q.enqueue(60);          // rear wraps around to the start of the array
        q.enqueue(70);
        q.display();

        // empty the queue using a do-while loop
        do {
            q.dequeue();
        } while (!q.isEmpty());

        q.dequeue();            // queue is empty
        q.display();
    }
}
