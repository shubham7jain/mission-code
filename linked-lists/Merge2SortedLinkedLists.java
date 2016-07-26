/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
	    ListNode head = null, start=null;
	    if(a==null) {
	        return b;
	    }
	    if(b==null) {
	        return a;
	    }
	    if(a.val<b.val) {
	        head = a;
	        a = a.next;
	    } else {
	        head =b;
	        b = b.next;
	    }
	    start = head;
	    while(a!=null && b!=null) {
	    if(a.val<b.val) {
	            head.next = a;
	            a = a.next;
	        } else {
	            head.next =b;
	            b = b.next;
	        }
	    head = head.next;
	    }
	    if(a==null) {
	        head.next=b;
	    } else if(b == null) {
	        head.next=a;
	    }
	    return start;
	}
}
