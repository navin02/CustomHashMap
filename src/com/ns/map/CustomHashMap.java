package com.ns.map;

public class CustomHashMap<K, V> {
	private Entry<K, V>[] table; // Array Of Entry
	private static int initialCapacity = 4;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public CustomHashMap() {
		table = new Entry[initialCapacity];
	}

	/**
	 * Method allows you put key-value pair in HashMapCustom. If the map already
	 * contains a mapping for the key, the old value is replaced. Note: method does
	 * not allows you to put null key though it allows null values. Implementation
	 * allows you to put custom objects as a key as well. Key Features:
	 * implementation provides you with following features:- >provide complete
	 * functionality how to override equals method. >provide complete functionality
	 * how to override hashCode method.
	 * 
	 * @param newKey
	 * @param data
	 */

	public void put(K key, V value) {
		if (null == key)
			return;
		int hash = hash(key);
		Entry<K, V> newEntry = new Entry<K, V>(key, value, null);
		Entry<K, V> current = table[hash];
		if (null == current) {
			table[hash] = newEntry;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> temp;
			while (null != current) {

				if (key.equals(current.key)) {
					if (null == previous) {
						temp = current.next;
						newEntry.next = temp;
						table[hash] = newEntry;
						return;
					} else {
						temp = current.next;
						previous.next = newEntry;
						newEntry.next = temp;
						return;
					}

				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	/**
	 * Method returns value corresponding to key.
	 * 
	 * @param key
	 */
	public V get(K key) {
		if (null == key)
			return null;
		int hash = hash(key);
		Entry<K, V> entry = table[hash];
		while (null != entry) {
			if (entry.key.equals(key))
				return entry.value;
			entry = entry.next;
		}
		return null;

	}

	/**
	 * Method removes key-value pair from HashMapCustom.
	 * 
	 * @param key
	 */
	public boolean remove(K key) {
		if (null == key)
			return false;
		int hash = hash(key);
		Entry<K, V> current = table[hash];
		Entry<K, V> previous = null;
		while (null != current) {
			if (key.equals(current.key)) {
				if (null == previous) {
					current = current.next;
					table[hash] = current;
					return true;
				} else {
					previous.next = current.next;
					return true;
				}
			}
			previous = current;
			current = current.next;

		}
		return false;
	}

	/**
	 * Method implements hashing functionality, which helps in finding the
	 * appropriate bucket location to store our data. This is very important method,
	 * as performance of HashMapCustom is very much dependent on this method's
	 * implementation.
	 * 
	 * @param key
	 */
	public int hash(K key) {
		return Math.abs(key.hashCode()) % initialCapacity;
	}

	/**
	 * Method displays all key-value pairs present in HashMapCustom., insertion
	 * order is not guaranteed, for maintaining insertion order refer
	 * LinkedHashMapCustom.
	 * 
	 * @param key
	 */

	public void display() {
		Entry<K, V> entry;
		for (int i = 0; i < initialCapacity; i++) {
			entry = table[i];
			while (null != entry) {
				System.out.println(entry.key + "   " + entry.value);
				entry = entry.next;
			}
		}
	}
}
