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
## Sort-List
https://leetcode.com/problems/sort-list/
## Reorder List
https://leetcode.com/problems/reorder-list/
```java
public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
        return;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode first = head;
    ListNode second = reverse(slow.next);

    slow.next = null;
        
    while (second != null) {
        ListNode firstNext = first.next;
        ListNode secondNext = second.next;
        first.next = second;
        second.next = firstNext;

        second = secondNext;
        first = firstNext;
    }
}

private ListNode reverse(ListNode node) {
       
    ListNode prev = null;
    ListNode next;
    while (node != null) {
        next = node.next;
        node.next = prev;
        prev = node;
        node = next;
    }
    return prev;
}
```
