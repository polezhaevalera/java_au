# Linked List
+ [Reverse-Linked-List](#reverse-linked-list)
+ [Middle-Of-The-Linked-List](#rmiddle-of-the-linked-list)
+ [Palindrome-Linked-List](#palindrome-linked-list)
+ [Merge-Two-Sorted-Lists](#merge-two-sorted-lists)
+ [Intersection-Of-Two-Linked-Lists](#intersection-of-two-linked-lists)
+ [Sort-List](#Sort-List)
+ [Reorder-List](#Reorder-List)

## Reverse-Linked-List
https://leetcode.com/problems/reverse-linked-list/
## Middle-Of-The-Linked-List
https://leetcode.com/problems/middle-of-the-linked-list/
## Palindrome-Linked-List
https://leetcode.com/problems/palindrome-linked-list/
## Merge-Two-Sorted-Lists
https://leetcode.com/problems/merge-two-sorted-lists/
## Intersection-Of-Two-Linked-Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    negate(headA);
    while(headB != null) {
        if(headB.val < 0) break;
        headB = headB.next;
    }
    negate(headA);
    return headB;
}
    
public void negate(ListNode headA) {
    while(headA != null) {
        headA.val = -headA.val;
        headA = headA.next;
    }
}
```
## Sort-List
https://leetcode.com/problems/sort-list/
## Reorder List
https://leetcode.com/problems/reorder-list/
