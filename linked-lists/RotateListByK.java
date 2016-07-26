/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode rotateRight(ListNode a, int b) {
	    ListNode head = a;
	    ListNode slow = a;
	    ListNode fast = a;
	    int size = 0;
	    while(a!=null) {
	        size++;
	        a = a.next;
	    }
	    b = b%size;
	    int i =0;
	    while(i<b && fast !=null) {
	        fast = fast.next;
	        i++;
	    }
	    
	    if(b==0){
	        return head;
	    }
	    if(fast == null) {
	        return head;
	    }
	    while(fast.next!=null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    
	    ListNode newHead = slow.next;
	    fast.next = head;
	    slow.next = null;
	    return newHead;
	}
}
