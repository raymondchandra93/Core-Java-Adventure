package com.raymondchandra.adventure06.threading;

/** 
 * Deadlock happens when two threads are WAITING for each other FOREVER
 */


class Friend {
    private final String name;

    Friend(String name) {
        this.name = name;
    }

    synchronized void bow(Friend bower) {
        System.out.println(this.name + " bows to " + bower.name);
        bower.bowBack(this);
    }

    synchronized void bowBack(Friend bower) {
        System.out.println(this.name + " bows back to " + bower.name);
    }
}

public class Thread04Deadlock {
	public static void main(String[] args) {
		Friend alice = new Friend("Alice");
        Friend bob = new Friend("Bob");
        
        // Deadlock - no one bows back
        new Thread(() -> alice.bow(bob)).start();
        new Thread(() -> bob.bow(alice)).start();
	}
}
