/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
* If n is greater than the size of the list, remove the first node of the list. 
Try doing it using constant additional space.
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
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    if(head==null)
	        return head;
	  ListNode slow=head;
	  ListNode fast=head;
	 
	  for(int i=0;i<n;i++) {
	      if(fast==null)
	        break;
	     fast=fast.next;
	  }
	  if(fast==null) {
	      head=head.next;
	      return head;
	  }
	  while(fast.next!=null) {
	      fast=fast.next;
	      slow=slow.next;
	  }
	  
	  slow.next=slow.next.next;
	  return head;
	}
}
