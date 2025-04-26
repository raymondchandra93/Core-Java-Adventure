# Java `Map` Interface

The `Map` interface in Java represents a collection of key-value pairs where each key is unique, and each key maps to exactly one value. It is part of the `java.util` package.

## Key Points about `Map`
1. **Key-Value Pairs**: A `Map` stores key-value pairs, where each key is associated with a value.
2. **Unique Keys**: Each key must be unique in the map. Duplicate keys are not allowed.
3. **Values**: Multiple keys can map to the same value, i.e., values can be duplicated.
4. **Common Implementations**: 
    - `HashMap`
    - `TreeMap`
    - `LinkedHashMap`
    - `Hashtable`

## Implementations of `Map`

### 1. `HashMap`
- Stores elements in a hash table.
- **Time Complexity**: 
  - **Insert**: O(1) on average (amortized)
  - **Get**: O(1) on average (amortized)
  - **Remove**: O(1) on average
- Allows one `null` key and multiple `null` values.
- Does not guarantee any order of the entries.

### Example of `HashMap`:

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        System.out.println("Value for 'Apple': " + map.get("Apple"));
        System.out.println("Contains 'Banana': " + map.containsKey("Banana"));

        map.remove("Orange");
        System.out.println("Size of the map: " + map.size());
    }
}
```

---

### 2. `TreeMap`
- A TreeMap is a map that stores the keys in sorted order (based on their natural ordering or a custom comparator).
- Time Complexity:
-- Insert: O(log n)
-- Get: O(log n)
-- Remove: O(log n)
- Does not allow null keys (but allows null values).
- Guarantees that the keys are in ascending order.

```
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();

        map.put("Banana", 1);
        map.put("Apple", 2);
        map.put("Orange", 3);

        System.out.println("Value for 'Apple': " + map.get("Apple"));
        System.out.println("Sorted map: " + map);
    }
}
```

---

### 3. `LinkedHashMap`
- A LinkedHashMap maintains the insertion order of the keys.
- Time Complexity:
-- Insert: O(1)
-- Get: O(1)
-- Remove: O(1)
- Unlike HashMap, it keeps the order in which entries were added.

```
import java.util.Map;
import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        System.out.println("Insertion order: " + map);
    }
}
```

---

### 4. `HashTable`
- Hashtable is similar to HashMap but is synchronized (thread-safe).
- Time Complexity:
-- Insert: O(1)
-- Get: O(1)
-- Remove: O(1)
- It does not allow null keys or values.

```
import java.util.Map;
import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<>();

        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        System.out.println("Value for 'Apple': " + map.get("Apple"));
        System.out.println("Contains 'Banana': " + map.containsKey("Banana"));
    }
}
```

---
