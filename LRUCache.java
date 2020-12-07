package com.company;

import java.util.Map;

class LRUCache<K, V> {
    MyLinkedHashMap<K, V> cache = new MyLinkedHashMap<>();
    int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        Map.Entry<K, V> entry = cache.getByKey(key);
        cache.delete(key);
        cache.addAtTail(entry);

        return entry.getValue();
    }

    V put(K key, V value) {
        if (cache.containsKey(key)) {
            cache.delete(key);
            cache.put(key, value);
            return null;
        }

        if (cache.size() >= this.capacity) {
            cache.deleteAtIndex(0);
        }

        cache.put(key, value);

        return null;
    }

}
