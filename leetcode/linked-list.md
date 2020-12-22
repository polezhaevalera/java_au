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
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    ListNode l3 = new ListNode(0);
    ListNode tail = l3;
while(true){
    if(l1==null){
        tail.next = l2;
        break;
    }
        
    if(l2==null){
        tail.next = l1;
        break;
    }
        
    if(l1.val<=l2.val){
        tail.next = l1;
        l1=l1.next;
    }
    else{
        tail.next = l2;
        l2 = l2.next;
    }
    tail = tail.next;
  }
    return l3.next;
}
```
## Intersection-Of-Two-Linked-Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
## Sort-List
https://leetcode.com/problems/sort-list/
## Reorder List
https://leetcode.com/problems/reorder-list/
