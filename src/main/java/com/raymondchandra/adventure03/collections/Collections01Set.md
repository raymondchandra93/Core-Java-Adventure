# Java Collections - Set

## What is a Set?

- A **Set** is a collection that **cannot contain duplicate elements**.
- It models the mathematical set abstraction.
- Useful for storing **unique** values.

Java provides several Set implementations:

- `HashSet`
- `LinkedHashSet`
- `TreeSet`

---

## Set Example (HashSet)

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicate, will NOT be added

        // Displaying the set
        System.out.println(fruits);

        // Checking if a set contains an element
        if (fruits.contains("Banana")) {
            System.out.println("Banana is in the set.");
        }

        // Removing an element
        fruits.remove("Orange");
        System.out.println(fruits);

        // Iterating through the set
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

**Output Example:**

```
[Banana, Orange, Apple]
Banana is in the set.
[Banana, Apple]
Banana
Apple
```

---

## Types of Set

| Type            | Description                  | Ordered? | Sorted? |
| --------------- | ---------------------------- | -------- | ------- |
| `HashSet`       | Fastest, no duplicates       | ❌ No     | ❌ No    |
| `LinkedHashSet` | Maintains insertion order    | ✅ Yes    | ❌ No    |
| `TreeSet`       | Automatically sorts elements | ❌ No     | ✅ Yes   |

---

## Time Complexity

| Operation    | HashSet                  | LinkedHashSet             | TreeSet       |
| ------------ | ------------------------ | ------------------------- | ------------- |
| `add()`      | O(1) average, O(n) worst | O(1) average              | O(log n)      |
| `remove()`   | O(1) average, O(n) worst | O(1) average              | O(log n)      |
| `contains()` | O(1) average, O(n) worst | O(1) average              | O(log n)      |
| `iteration`  | O(n)                     | O(n) (in insertion order) | O(n) (sorted) |

- The primary reason for O(n) worst-case performance in a HashSet is hash collisions.
- When multiple objects in the HashSet have the same hash code, they end up in the same bucket in the hash table.
- A hash table works by mapping hash codes to specific buckets (array indices), but if several elements have the same hash code, they all end up in the same bucket, and you need to search through them.
- In this case, instead of having constant-time operations (O(1)), the lookup time increases because the set must traverse the linked list of elements in that bucket, which can take O(n) time if all the elements have the same hash code (i.e., they all collide).

---

## Visual Representation

**HashSet**

```
[Orange] [Banana] [Apple] [Grapes]
(no predictable order)
```

**LinkedHashSet**

```
[Apple] -> [Banana] -> [Orange] -> [Grapes]
(insertion order maintained)
```

**TreeSet**

```
[Apple] -> [Banana] -> [Grapes] -> [Orange]
(automatically sorted)
```

---

## Common Use Cases

### Removing Duplicates

```java
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> listWithDuplicates = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana");

        Set<String> uniqueFruits = new HashSet<>(listWithDuplicates);

        System.out.println("Unique fruits: " + uniqueFruits);
    }
}
```

**Output:**

```
Unique fruits: [Banana, Orange, Apple]
```

### Fast Membership Checking

```java
Set<String> whitelistEmails = new HashSet<>();
whitelistEmails.add("user@example.com");
whitelistEmails.add("admin@example.com");

String emailToCheck = "guest@example.com";

if (whitelistEmails.contains(emailToCheck)) {
    System.out.println("Access granted.");
} else {
    System.out.println("Access denied.");
}
```

---

## Summary

- Use `HashSet` for speed.
- Use `LinkedHashSet` when insertion order matters.
- Use `TreeSet` when you need sorted elements.

---

## Note

- Since Set in Java (like HashSet, LinkedHashSet, TreeSet) doesn’t have an index, you cannot get an element by index directly (unlike List).
- But you can still retrieve one element by iterating.
