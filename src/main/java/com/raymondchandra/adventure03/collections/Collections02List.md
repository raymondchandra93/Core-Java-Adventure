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

### 2. `LinkedList`

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

### 3. `Vector`

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


### 1. `Stack`

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

---

# 🎯 When to Use Which List?

- Situation	-> Recommended List
- Fast random access needed -> ArrayList
- Frequent insertions/deletions at ends	-> LinkedList
- Thread safety needed -> Vector
- Need Stack (LIFO) behavior ->Stack

---

# 📚 Java List Collections — Time Complexity Comparison

| Operation            | ArrayList     | LinkedList    | Vector         | Stack          |
|----------------------|---------------|---------------|----------------|----------------|
| get(int index)        | O(1)           | O(n)           | O(1)            | O(1) (inherited) |
| add(E element)        | O(1) (amortized) | O(1)         | O(1) (amortized, synchronized) | O(1) (push) |
| add(int index, E)     | O(n)           | O(n)           | O(n)            | -              |
| remove(int index)     | O(n)           | O(n)           | O(n)            | O(1) (pop)     |
| contains(Object o)    | O(n)           | O(n)           | O(n)            | O(n) (search)  |
| push(E item)          | -              | -              | -               | O(1)           |
| pop()                 | -              | -              | -               | O(1)           |
| peek()                | -              | -              | -               | O(1)           |
| search(Object o)      | -              | -              | -               | O(n)           |

---

# 🔥 Notes:

- `ArrayList` and `Vector` offer **fast random access** (O(1)) but **slow shifting** on insertions/deletions at arbitrary positions.
- `LinkedList` is **efficient for adding/removing** at the start or end but **inefficient for random access**.
- `Vector` is **synchronized** — safe for multi-threading, but slower due to locking.
- `Stack` is based on `Vector` but specializes for **LIFO** operations.

✅ `push`, `pop`, and `peek` operations in `Stack` are **constant time** O(1).


# 📚 Java Collections — Initial Backing Array Size

---

## ✨ ArrayList

- When instantiated with `new ArrayList<>()`, **no array** is immediately created.
- **Internal array size = 0** initially.
- On first element insertion, an internal array of **size 10** is allocated.

```java
ArrayList<Integer> list = new ArrayList<>();
// Initial array size = 0
// After first add() → array size = 10
```

- **Vector** and **Stack** are also the same as ArrayList
- **LinkedList** is not because it is made out of **Node**