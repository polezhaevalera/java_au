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

## Implement Stack Using Queues
https://leetcode.com/problems/implement-stack-using-queues/
```java
Queue<Integer> mainQ;
Queue<Integer> helperQ;
public MyStack() {
    mainQ = new ArrayDeque<>();
    helperQ = new ArrayDeque<>();
}

public void push(int x) {
    mainQ.add(x);
}

public int pop() {
    while(mainQ.size()>1){
        helperQ.add(mainQ.remove());
    }
        
    int val = mainQ.remove();
    Queue<Integer> temp = mainQ;
    mainQ = helperQ;
    helperQ = temp;
    return val;
}

public int top() {
    while(mainQ.size()>1){
        helperQ.add(mainQ.remove());
    }
        
   int val = mainQ.remove();
    helperQ.add(val);
    Queue<Integer> temp = mainQ;
    mainQ = helperQ;
    helperQ = temp;
    return val;
}
public boolean empty() {
    if(mainQ.size()!=0) return false;
    else return true;
}
```

## Implement Queue Using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/

## Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/

