/*
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes: 
- Expected solution is linear in time and constant in space.

For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode head) {
        
    if(head == null)
        return 1;
 
    ListNode p = head;
    ListNode prev = new ListNode(head.val);
 
    while(p.next != null){
        ListNode temp = new ListNode(p.next.val);
        temp.next = prev;
        prev = temp;
        p = p.next;
    }
 
    ListNode p1 = head;
    ListNode p2 = prev;
 
    while(p1!=null){
        if(p1.val != p2.val)
            return 0;
 
        p1 = p1.next;
        p2 = p2.next;
    }
 
    return 1;
        
    }
}
