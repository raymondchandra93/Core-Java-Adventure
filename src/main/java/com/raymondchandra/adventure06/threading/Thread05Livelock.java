package com.raymondchandra.adventure06.threading;

// Livelock happens when two threads are RESPONDING for each other FOREVER

class Friend2 {
    private final String name;

    Friend2(String name) {
        this.name = name;
    }

    void interact(Friend2 other) {
        while (true) {
            System.out.println(this.name + " wants to interact with " + other.name);
            
            // Avoid deadlock by not holding the lock, but this results in livelock
            if (this.name.compareTo(other.name) < 0) {
            	
                // Release the lock and allow the other thread to proceed
                System.out.println(this.name + " gives up temporarily and lets " + other.name + " go first");
                continue;  // Keep yielding control, but never make progress
            }
            
            // Continue interaction
            System.out.println(this.name + " interacts with " + other.name);
            break;
        }
    }
}

public class Thread05Livelock {
	public static void main(String[] args) {
		Friend2 alice = new Friend2("Alice");
		Friend2 bob = new Friend2("Bob");
        
        // Deadlock - no one bows back
        new Thread(() -> alice.interact(bob)).start();
        new Thread(() -> bob.interact(alice)).start();
	}
}
