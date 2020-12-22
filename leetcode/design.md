# Design
+ [Flatten Nested List Iterator](#flatten-nested-list-iterator)
+ [lru Cache](#lru-cache)
+ [Min Stack](#min-stack)
+ [Implement Stack Using Queues](#implement-stack-using-queues)
+ [Implement Queue Using Stacks](#implement-queue-using-stacks)
+ [Binary Search Tree Iterator](#binary-search-tree-iterator)

## Flatten Nested List Iterator
https://leetcode.com/problems/flatten-nested-list-iterator/
```java
Stack<Iterator<NestedInteger>> stack = new Stack<>();
Integer val = null;

public NestedIterator(List<NestedInteger> nestedList) {
    if(nestedList != null && !nestedList.isEmpty())
        stack.push(nestedList.iterator());
}

@Override
public Integer next() {
    if(val != null) {
    Integer tmp = val;
        val = null;
        return tmp;
    }
    if(hasNext()) {
        do {
            NestedInteger nestedInteger = stack.peek().next();
            if(!nestedInteger.isInteger() && !nestedInteger.getList().isEmpty())
                stack.push(nestedInteger.getList().iterator());
            else
                return nestedInteger.getInteger();
        } while(true);
    }    
        
    return null;
}

@Override
public boolean hasNext() {
    if(val != null) {
        return true;
     }
     while(!stack.isEmpty()) {
        if(stack.peek().hasNext()) {
            NestedInteger nestedInteger = stack.peek().next();
            if(nestedInteger.isInteger()) {
                val = nestedInteger.getInteger();
                return true;
            } else {
                stack.push(nestedInteger.getList().iterator());
            }
        } else {
            stack.pop();
        }
    }
    return false;
 }
```


## lru Cache
https://leetcode.com/problems/lru-cache/

## Min Stack
https://leetcode.com/problems/min-stack/

## Implement Stack Using Queues
https://leetcode.com/problems/implement-stack-using-queues/

## Implement Queue Using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/

## Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/

