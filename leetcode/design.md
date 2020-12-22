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

## Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/
```java
Stack<TreeNode> stack;
public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null) {
        stack.push(cur);
        cur = cur.left;
    }
}
    
public int next() {
    TreeNode current = stack.pop();
    TreeNode cur = current.right;
    while (cur != null) {
        stack.push(cur);
        cur = cur.left;
    }
    return current.val;
}
    
public boolean hasNext() {
    return !stack.isEmpty();
}
```
