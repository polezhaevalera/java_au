# Design
+ [Flatten Nested List Iterator](#flatten-nested-list-iterator)
+ [lru Cache](#lru-cache)
+ [Min Stack](#min-stack)
+ [Implement Stack Using Queues](#implement-stack-using-queues)
+ [Implement Queue Using Stacks](#implement-queue-using-stacks)
+ [Binary Search Tree Iterator](#binary-search-tree-iterator)

## Flatten Nested List Iterator
https://leetcode.com/problems/flatten-nested-list-iterator/

## lru Cache
https://leetcode.com/problems/lru-cache/
```java
LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
int cap;
public LRUCache(int capacity) {
    this.cap = capacity;
}
   
public int get(int key) {
    if (!cache.containsKey(key)) {
        return -1;
    }
    moveRecently(key);
    return cache.get(key);
}
    
public void put(int key, int value) {
    if (cache.containsKey(key)) {
        cache.put(key, value);
        moveRecently(key);
        return;
    }
    if (cache.size() >= this.cap) {
        int oldKey = cache.keySet().iterator().next();
        cache.remove(oldKey);
    }
    cache.put(key, value);
}
public void moveRecently(int key) {
    int val = cache.get(key);
    cache.remove(key);
    cache.put(key, val);
}
```
## Min Stack
https://leetcode.com/problems/min-stack/

## Implement Stack Using Queues
https://leetcode.com/problems/implement-stack-using-queues/

## Implement Queue Using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/

## Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/

