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

## Implement Queue Using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/
```java
Stack stk = new Stack(); 
Stack rev = new Stack();//used when performing DeQueue operation

public MyQueue() {
        
}
    
public void push(int x) {
    stk.push(x);
}
    

public int pop() {
    while(!stk.isEmpty()){
        rev.push(stk.pop());
    }
    Object x = rev.pop();
    while(!rev.isEmpty()){
        stk.push(rev.pop());
    }
    return (int)x;
}
    

public int peek() {
    Iterator value = stk.iterator();
    return (int)value.next();
}
    
public boolean empty() {
    if(stk.isEmpty())
       return true;
    else
        return false;
}
```

## Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/

