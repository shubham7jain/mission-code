/*
Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3
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
	public ListNode insertionSortList(ListNode a) {
	    if(a==null || a.next == null) {
	        return a;
	    }
	    
	    ListNode prevCurrent = a;
	    ListNode current = a.next;
	    ListNode head = a;
	    while(current!=null) {
	        head = a;
	        ListNode prev = null;
	        while(current.val>head.val && current !=head) {
	            prev = head;
	            head = head.next;
	        }
	        if(prev == null) {
	            a = current;
	            prevCurrent.next = current.next;
	            current.next = head;
	        }
	        
	        else if(current != head) {
	            prev.next = current;
	            prevCurrent.next = current.next;
	            current.next = head;
	        }
	        prevCurrent = current;
	        current = current.next;
	    }
	    return a;
	   
	}
}
