package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


class LinkedHashMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {
    int index = 0;
    MyLinkedHashMap<K, V> map;

    LinkedHashMapIterator(MyLinkedHashMap<K, V> map) {
        this.map = map;
    }

    @Override
    public boolean hasNext() {
        return this.map.size() >= this.index + 1;
    }

    @Override
    public Map.Entry<K, V> next() {
        return this.map.get(index++);
    }
}


class MyLinkedHashMap<K, V> extends HashMap<K, V>
        implements Iterable<Map.Entry<K, V>> {

    class Node {
        Entry<K, V> entry;
        Node nextNode;
        Node prevNode;

        Node(Entry<K, V> entry) {
            this.entry = entry;
        }
    }

    Node startNode;
    Node endNode;

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new LinkedHashMapIterator<>(this);
    }

    Entry<K ,V> get(int index) {
        Node head = this.startNode;

        if (index >= this.size() || index < 0) {
            return null;
        }

        for (int i = 0; i < index; i++) {
            head = head.nextNode;
        }

        return head.entry;
    }

    @Override
    public V put(K key, V value) {
        SimpleEntry<K, V> entry = new SimpleEntry<>(key, value);
        Node add = new Node(entry);

        if (this.startNode == null) {
            this.startNode = add;
            this.endNode = add;
            super.put(entry.getKey(), entry.getValue());
            return entry.getValue();
        }

        addEntry(entry, add);

        return entry.getValue();
    }

    void deleteAtIndex(int index) {
        if (index >= this.size() || index < 0) {
            return;
        };

        if (index == 0) {
            if (this.size() == 1) {
                super.clear();
                this.startNode = null;
                this.endNode = null;
            } else {
                super.remove(this.startNode.entry.getKey());
                this.startNode = this.startNode.nextNode;
                this.startNode.prevNode.nextNode = null;
                this.startNode.prevNode = null;
            }
            return;
        }

        if (index == this.size() - 1) {
            super.remove(this.endNode.entry.getKey());
            this.endNode = this.endNode.prevNode;
            this.endNode.nextNode.prevNode = null;
            this.endNode.nextNode = null;
            return;
        }

        Node head = this.startNode;
        for (int i = 0; i < index; i++) {
            head = head.nextNode;
        }

        super.remove(head.entry.getKey());
        head.prevNode.nextNode = head.nextNode;
        head.nextNode.prevNode = head.prevNode;
        head.nextNode = null;
        head.prevNode = null;
    }

    Entry<K, V> getByKey(K key) {
        if (this.containsKey(key)) {
            return get(findIndexByKey(key));
        }

        return null;
    }

    void delete(K key) {
        if (this.containsKey(key)) {
            deleteAtIndex(findIndexByKey(key));
        }
    }

    void addAtTail(Entry<K, V> entry) {
        Node add = new Node(entry);

        if (this.startNode == null) {
            this.startNode = add;
            this.endNode = add;
            super.put(entry.getKey(), entry.getValue());
            return;
        }

        addEntry(entry, add);
    }

    int findIndexByKey(K key) {
        Node iter = startNode;
        int index = 0;

        while (iter != null) {

            if (iter.entry != null && iter.entry.getKey().equals(key)) {
                return index;
            } else {
                iter = iter.nextNode;
                index++;
            }

        }

        return -1;
    }

    void addEntry(Entry<K, V> entry, Node add) {
        if (this.containsKey(entry.getKey())) {
            this.replace(entry.getKey(), entry.getValue());
        }

        add.prevNode = this.endNode;
        this.endNode.nextNode = add;
        this.endNode = add;
        super.put(entry.getKey(), entry.getValue());
    }

}
