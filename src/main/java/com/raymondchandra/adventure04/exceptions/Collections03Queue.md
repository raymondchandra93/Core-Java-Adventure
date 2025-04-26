# Queue in Java

In Java, the `Queue` is a part of the Java Collections Framework, specifically under the `java.util` package. A `Queue` is a collection designed to hold elements prior to processing, typically in a first-in, first-out (FIFO) manner. It's often used in scenarios like task scheduling, handling requests, and more.

## 1. Queue Interface

The `Queue` interface extends the `Collection` interface and defines several methods that are meant to handle the elements in a queue.

Here are the key methods of the `Queue` interface:

- **add(E e)**: Adds the specified element to the queue. If the element cannot be added (e.g., because of capacity restrictions), it throws an `IllegalStateException`.
- **offer(E e)**: Adds the specified element to the queue. Returns `true` if the element is added successfully, or `false` if it fails.
- **remove()**: Retrieves and removes the head (first) of the queue. Throws `NoSuchElementException` if the queue is empty.
- **poll()**: Retrieves and removes the head (first) of the queue. Returns `null` if the queue is empty.
- **peek()**: Retrieves, but does not remove, the head of the queue. Returns `null` if the queue is empty.
- **element()**: Retrieves, but does not remove, the head of the queue. Throws `NoSuchElementException` if the queue is empty.

## 2. Common Queue Implementations

Java provides several classes that implement the `Queue` interface. Some of the most common ones are:

- **LinkedList**: A doubly-linked list that implements both the `Queue` interface and the `Deque` interface (which allows it to function as a double-ended queue).
- **PriorityQueue**: A queue where elements are ordered based on their natural ordering or by a comparator provided at queue construction. It does **not** follow the FIFO order; instead, it orders elements based on priority.
- **ArrayDeque**: A resizable array that implements the `Deque` interface, allowing elements to be added or removed from both ends (making it a double-ended queue).
- **BlockingQueue**: This is an interface that extends `Queue` and is designed for use in concurrent programming. Implementations like `ArrayBlockingQueue` and `LinkedBlockingQueue` allow thread-safe operations.

## 3. Example of Using a Queue

Here’s an example of how to use a `Queue` in Java using `LinkedList` (which implements the `Queue` interface):

```java
import java.util.Queue;
import java.util.LinkedList;

public class QueueExample {
    public static void main(String[] args) {
        // Create a queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");

        // Peek at the front element of the queue
        System.out.println("Front of the queue: " + queue.peek());

        // Remove elements from the queue (FIFO order)
        System.out.println("Removed from queue: " + queue.poll());
        System.out.println("Removed from queue: " + queue.poll());

        // Check the queue after removal
        System.out.println("Queue after removals: " + queue);

        // Add more elements
        queue.offer("David");
        queue.offer("Eve");

        // Display the queue again
        System.out.println("Queue after adding more elements: " + queue);
    }
}
```

---

### PriorityQueue Example

In a PriorityQueue, the order of elements is determined by their priority rather than the order they were added. Here's an example:

```
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements
        pq.add(20);
        pq.add(10);
        pq.add(30);
        pq.add(15);

        // The elements are ordered by their natural ordering (ascending order)
        System.out.println("PriorityQueue: " + pq);

        // Remove elements from the queue (smallest element first)
        while (!pq.isEmpty()) {
            System.out.println("Removed from PriorityQueue: " + pq.poll());
        }
    }
}
```

---

### BlockingQueue Example (for Concurrency)

A BlockingQueue is useful for thread synchronization. It is particularly useful in multi-threaded programs where threads need to wait for an item to become available in the queue.

Here's a simple example using ArrayBlockingQueue:

```
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a blocking queue with a capacity of 2
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                queue.put("Item 1");
                System.out.println("Produced Item 1");
                queue.put("Item 2");
                System.out.println("Produced Item 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                String item1 = queue.take();
                System.out.println("Consumed " + item1);
                String item2 = queue.take();
                System.out.println("Consumed " + item2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads
        producer.start();
        consumer.start();

        // Wait for the threads to finish
        producer.join();
        consumer.join();
    }
}
```

---

# Time Complexity of Different Queue Implementations in Java

The time complexity of various operations in a `Queue` depends on the specific implementation. Below is the time complexity for common queue implementations in Java:

## 1. **LinkedList (implements `Queue` and `Deque`)**

A `LinkedList` is a doubly-linked list, meaning it can efficiently add or remove elements at both ends.

### Time Complexity for Common Operations:
- **add(E e)** / **offer(E e)** (to add an element to the queue): 
  - **O(1)**: The element is added at the end of the list.
  
- **remove()** / **poll()** (to remove and return the front element):
  - **O(1)**: Removal happens at the head (front) of the list, which is efficient.
  
- **peek()** (to view the front element):
  - **O(1)**: Simply accessing the head of the list.

- **element()** (to retrieve but not remove the front element):
  - **O(1)**: Simply accessing the head of the list.

### Summary for `LinkedList`:
- **Add:** O(1)
- **Remove:** O(1)
- **Peek:** O(1)
- **Element:** O(1)

## 2. **PriorityQueue**

A `PriorityQueue` is a type of queue where elements are ordered by their priority. It is implemented as a **heap** (usually a binary heap), which allows for efficient priority-based ordering.

### Time Complexity for Common Operations:
- **add(E e)** / **offer(E e)** (to add an element to the queue):
  - **O(log n)**: Inserting an element requires reordering the heap, which takes logarithmic time.
  
- **remove()** / **poll()** (to remove and return the head element, i.e., the element with the highest priority):
  - **O(log n)**: Removing the element and reordering the heap requires logarithmic time.
  
- **peek()** (to view the top (highest priority) element):
  - **O(1)**: Simply accessing the root of the heap.

- **element()** (to retrieve but not remove the top element):
  - **O(1)**: Simply accessing the root of the heap.

### Summary for `PriorityQueue`:
- **Add:** O(log n)
- **Remove:** O(log n)
- **Peek:** O(1)
- **Element:** O(1)

## 3. **ArrayDeque**

An `ArrayDeque` is a dynamic array implementation that allows for adding and removing elements from both ends, making it a **double-ended queue** (deque).

### Time Complexity for Common Operations:
- **add(E e)** / **offer(E e)** (to add an element to the queue):
  - **O(1)**: Adding elements at the end of the array (amortized).
  
- **remove()** / **poll()** (to remove and return the front element):
  - **O(1)**: Removing elements from the front of the array is efficient.

- **peek()** (to view the front element):
  - **O(1)**: Simply accessing the front of the array.

- **element()** (to retrieve but not remove the front element):
  - **O(1)**: Simply accessing the front of the array.

### Summary for `ArrayDeque`:
- **Add:** O(1)
- **Remove:** O(1)
- **Peek:** O(1)
- **Element:** O(1)

## 4. **ArrayBlockingQueue** (a type of `BlockingQueue`)

`ArrayBlockingQueue` is a **bounded** blocking queue that uses an array to hold the elements. It’s thread-safe, meaning it can be used in concurrent programming scenarios.

### Time Complexity for Common Operations:
- **add(E e)** / **offer(E e)** (to add an element to the queue):
  - **O(1)**: Inserting an element into the queue is efficient as long as the queue is not full.
  
- **remove()** / **poll()** (to remove and return the front element):
  - **O(1)**: Removing the element from the head is efficient.

- **peek()** (to view the front element):
  - **O(1)**: Simply accessing the front of the queue.

- **element()** (to retrieve but not remove the front element):
  - **O(1)**: Simply accessing the front of the queue.

### Summary for `ArrayBlockingQueue`:
- **Add:** O(1)
- **Remove:** O(1)
- **Peek:** O(1)
- **Element:** O(1)

## 5. **LinkedBlockingQueue** (a type of `BlockingQueue`)

`LinkedBlockingQueue` is an **unbounded** blocking queue that uses a linked node structure. It also supports operations that can be blocked until an element becomes available or space is available for adding an element.

### Time Complexity for Common Operations:
- **add(E e)** / **offer(E e)** (to add an element to the queue):
  - **O(1)**: Inserting an element is efficient, but this may depend on whether the queue is bounded.
  
- **remove()** / **poll()** (to remove and return the front element):
  - **O(1)**: Removing the element from the head is efficient.

- **peek()** (to view the front element):
  - **O(1)**: Simply accessing the front of the queue.

- **element()** (to retrieve but not remove the front element):
  - **O(1)**: Simply accessing the front of the queue.

### Summary for `LinkedBlockingQueue`:
- **Add:** O(1)
- **Remove:** O(1)
- **Peek:** O(1)
- **Element:** O(1)

## Summary of Time Complexities:

| Queue Type               | `add()` / `offer()` | `remove()` / `poll()` | `peek()` | `element()` |
|--------------------------|---------------------|-----------------------|----------|-------------|
| **LinkedList**            | O(1)                | O(1)                  | O(1)     | O(1)        |
| **PriorityQueue**         | O(log n)            | O(log n)              | O(1)     | O(1)        |
| **ArrayDeque**            | O(1)                | O(1)                  | O(1)     | O(1)        |
| **ArrayBlockingQueue**    | O(1)                | O(1)                  | O(1)     | O(1)        |
| **LinkedBlockingQueue**   | O(1)                | O(1)                  | O(1)     | O(1)        |

## Notes:
- The **`add()`** and **`offer()`** operations are generally O(1) in most queues, except in the case of `PriorityQueue`, which needs to reorder elements after insertion (O(log n)).
- **`remove()`** and **`poll()`** are O(1) for most queues, except for the `PriorityQueue`, where they are O(log n) due to the heap structure.
- **`peek()`** and **`element()`** are typically O(1) in all queues because they only involve accessing the front element.

