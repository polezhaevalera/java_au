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
```java
public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) return head ; 
    ListNode mid = getMid(head) ; 
    ListNode left = sortList(head) ;
    ListNode right = sortList(mid);
    return merge(left , right); 
        
}
    
ListNode merge(ListNode left , ListNode right){
    ListNode merged =new ListNode() ; 
    ListNode head2= merged ; 
    while(left!= null && right != null){
        if(left.val <= right.val){  // '<=' to maintain stability
            head2.next = left ; 
            left = left.next ; 
            head2=head2.next ; 
        }
        else {
            head2.next = right; 
            right = right.next ; 
            head2=head2.next ;
        }
    }
    head2.next = left != null ? left : right ; 
    return merged.next ; 
}
   
ListNode getMid(ListNode head){
    ListNode slow = null ; 
    ListNode fast = head ; 
    while(fast != null && fast.next !=null){
        slow = (slow == null )? fast : slow.next ; 
        fast = fast.next.next ; 
    }
    ListNode mid = slow.next ; 
    slow.next = null ;  // to split the lists 
    return mid ; 
}
```
## Reorder List
https://leetcode.com/problems/reorder-list/
