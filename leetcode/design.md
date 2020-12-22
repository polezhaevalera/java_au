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

## Min Stack
https://leetcode.com/problems/min-stack/
```java
Deque<Integer> stack;
PriorityQueue<Integer> min;
public MinStack() {
    stack = new ArrayDeque<>();
     min = new PriorityQueue<>();
}
    
public void push(int x) {
    stack.push(x);
    min.offer(x);
}

public void pop() {
    int x = stack.pop();
    min.remove(x);
}
   
public int top() {
    return stack.peek();
}
    
public int getMin() {
    return min.peek();
}
```

## Implement Stack Using Queues
https://leetcode.com/problems/implement-stack-using-queues/

## Implement Queue Using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/

## Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/

