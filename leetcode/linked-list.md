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
```java
public ListNode middleNode(ListNode head) {
        
    ListNode prev, curr, next;
        
    curr = head;
    int counter = 0;
    while (curr != null) {
        curr = curr.next;
        counter++;
    }
        
    curr = head;
    counter = counter / 2;
    while (counter != 0) {
        counter--;
        curr = curr.next;
    }
        
    return curr;
}

public ListNode reverseList(ListNode head) {
    ListNode prev, curr, next;

    prev = null;
    curr = head;

    while(curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
        
    return prev;
}
    
public boolean isPalindrome(ListNode head) {
    ListNode prev, curr, next, middle;
        
    middle = middleNode(head);
    middle = reverseList(middle);
        
    curr = head;
    while (middle != null) {
        if (curr.val != middle.val) {
            return false;
        }
        curr = curr.next;
        middle = middle.next;
    }
        
    return true;
}
```
## Merge-Two-Sorted-Lists
https://leetcode.com/problems/merge-two-sorted-lists/
## Intersection-Of-Two-Linked-Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
## Sort-List
https://leetcode.com/problems/sort-list/
## Reorder List
https://leetcode.com/problems/reorder-list/
