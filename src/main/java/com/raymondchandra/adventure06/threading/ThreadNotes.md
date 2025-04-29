# Java `volatile` Keyword – Summary Notes

## 🔹 What is `volatile`?
The `volatile` keyword in Java is used to indicate that a variable's value will be modified by different threads. It ensures **visibility** of changes to variables across threads.

---

## 🔹 Why Use `volatile`?
- Without `volatile`, each thread may **cache** a copy of a variable, and changes by one thread **may not be visible** to others immediately.
- `volatile` tells the JVM **not to cache** the variable and always read/write it from **main memory**.
- It is a **lighter alternative to `synchronized`**, but only addresses **visibility**, not atomicity.

---

## 🔹 When to Use `volatile`
Use `volatile` when:
- The variable is shared between threads.
- The variable is only accessed via simple **read and write** operations.
- You do **not** require compound operations (like incrementing, or checking-then-setting).

---

## 🔹 What `volatile` Guarantees
1. **Visibility**: Changes to the variable by one thread are immediately visible to others.
2. **Happens-Before Relationship**: Writing to a `volatile` variable happens-before any subsequent read of that variable.

---

## 🔹 What `volatile` Does NOT Guarantee
- **Atomicity**: `volatile` does not make compound actions (like `count++`) atomic.
- **Mutual Exclusion**: It doesn't provide thread locking like `synchronized`.

---

## 🔹 Example Without `volatile` (Problem)
```java
private boolean flag = false; // Not volatile

public void toggle() {
    flag = !flag;
}

public boolean isFlag() {
    return flag;
}
```

---

# 📘 Atomic Variables in Java

## 🔒 What Are Atomic Variables?

Atomic variables provide **thread-safe operations** on single variables without using `synchronized`. They belong to the `java.util.concurrent.atomic` package.

---

## ✅ Why Use Atomic Variables?

Regular operations like `counter++` are **not atomic**:
- Read → Modify → Write
- Multiple threads may cause **race conditions**

Atomic variables solve this using **non-blocking** operations based on **CAS (Compare-And-Swap)**.

---

## 🧰 Common Atomic Classes

| Class                | Type             | Key Methods                         |
|----------------------|------------------|-------------------------------------|
| `AtomicBoolean`      | boolean          | `get()`, `set()`, `compareAndSet()` |
| `AtomicInteger`      | int              | `incrementAndGet()`, `addAndGet()`  |
| `AtomicLong`         | long             | Similar to `AtomicInteger`          |
| `AtomicReference<T>` | Object reference | `get()`, `set()`, `compareAndSet()` |

---

## 🔁 Core Methods

- `get()` / `set(value)`: Read and write
- `incrementAndGet()`: Increments and returns the result
- `getAndIncrement()`: Returns current, then increments
- `compareAndSet(expected, update)`: Conditionally sets value

---

## ⚙️ Atomic vs Synchronized

| Feature               | Atomic Variables                         | `synchronized` Keyword                  |
|-----------------------|-------------------------------------------|-----------------------------------------|
| Thread Safety         | ✅ Yes (for one variable)                 | ✅ Yes                                   |
| Performance           | ⚡ Fast (non-blocking)                    | 🐢 Slower (blocking)                     |
| Blocking              | ❌ No (uses CAS)                         | ✅ Yes                                   |
| Deadlock Risk         | ❌ None                                  | ⚠️ Possible                              |
| Multi-variable Safety | ❌ No                                    | ✅ Yes                                   |
| Use Case              | Simple, fast updates to single variable | Complex logic or multiple variables     |

---

## 🔧 When to Use What?

### Use `Atomic` when:
- You need to update a **single shared variable** (e.g., flag, counter)
- You want **lock-free**, high-performance code

### Use `synchronized` when:
- You need to update **multiple variables together**
- You need a **critical section** with complex logic

---

## 📌 Summary

- `Atomic` variables = fast, non-blocking, **for single variable updates**
- `synchronized` = safer for multi-step or multi-variable logic

# 🔒 ReentrantLock in Java Multithreading

## What is `ReentrantLock`?

`ReentrantLock` is a class in the `java.util.concurrent.locks` package. It's a more flexible alternative to the `synchronized` keyword, giving greater control over lock mechanisms in multithreaded environments.

---

## ✅ Key Features

- **Reentrant**: A thread can acquire the same lock multiple times without getting blocked.
- **Explicit Control**: Locking and unlocking must be done manually with `lock()` and `unlock()`.
- **Fairness Option**: You can create a fair lock (`new ReentrantLock(true)`) to allow threads to acquire the lock in the order requested.

---

## 🔄 Reentrant vs Synchronized

| Feature                          | `synchronized` | `ReentrantLock`     |
|----------------------------------|----------------|---------------------|
| Explicit lock/unlock             | ❌              | ✅                   |
| Try to acquire without blocking  | ❌              | ✅ (`tryLock()`)     |
| Interruptible lock waiting       | ❌              | ✅ (`lockInterruptibly()`) |
| Fair thread ordering             | ❌              | ✅                   |

---

## 🧪 Example: Using `ReentrantLock`

```java
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // always release the lock in a finally block
        }
    }

    public int getCount() {
        return count;
    }
}
```
