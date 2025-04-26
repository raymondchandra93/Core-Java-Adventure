# 📚 Java List Collection

## 🔵 What is `List`?

- A `List` in Java is an **ordered collection** (also known as a sequence).
- It **allows duplicate elements**.
- It **preserves insertion order**.
- You can **access elements by index** (position).

`List` is an **interface** in `java.util` package and it is implemented by several classes like:
- `ArrayList`
- `LinkedList`
- `Vector`
- `Stack`

---

## 🔵 List Implementations

### 1. `ArrayList`

- Backed by a **dynamic array**.
- **Fast** random access (`get()` is O(1)).
- **Slow** for insertions and deletions (especially in the middle) because elements need to be shifted.

```java
import java.util.ArrayList;

List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Orange");

System.out.println(list.get(1)); // Banana
```

# 📚 Java `LinkedList`

---

## 🔵 Overview

- `LinkedList` is part of the `java.util` package.
- It implements `List`, `Deque`, and `Queue` interfaces.
- It is based on a **doubly-linked list**.
- **Allows duplicate elements** and **preserves insertion order**.

---

## 🔵 Characteristics

- Insertion and deletion are **fast** (especially at the beginning or middle).
- Accessing an element by index is **slow** (O(n)).
- **Not synchronized** (not thread-safe).

---

## 🔵 Code Example

```java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");

        animals.addFirst("Cow");
        animals.addLast("Sheep");

        System.out.println(animals); // [Cow, Dog, Cat, Horse, Sheep]
    }
}
```

# 📚 Java `Vector`

---

## 🔵 Overview

- `Vector` is part of `java.util` package.
- Implements `List` interface.
- **Synchronized** — thread-safe.
- **Dynamic array** that grows as needed.

---

## 🔵 Characteristics

- All methods are **thread-safe** by synchronization.
- Performance is slower compared to `ArrayList` (due to locking).
- Allows **duplicate elements**.
- Maintains **insertion order**.

---

## 🔵 Code Example

```java
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> colors = new Vector<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        System.out.println(colors.get(1)); // Green
    }
}
```


# 📚 Java `Stack`

---

## 🔵 Overview

- `Stack` is a subclass of `Vector`.
- Represents a **Last In First Out (LIFO)** data structure.
- Part of `java.util` package.

---

## 🔵 Characteristics

- Extends `Vector`, thus **thread-safe**.
- Provides methods like `push()`, `pop()`, `peek()`.
- Useful for **undo mechanisms**, **expression evaluations**, **function call management**, etc.

---

## 🔵 Code Example

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());  // 30
        System.out.println(stack.peek()); // 20
        System.out.println(stack.empty()); // false
    }
}
```

🎯 When to Use Which List?

Situation	Recommended List
Fast random access needed	ArrayList
Frequent insertions/deletions at ends	LinkedList
Thread safety needed	Vector
Need Stack (LIFO) behavior	Stack
