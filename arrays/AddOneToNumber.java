/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    int sum = a.get(a.size()-1) + 1;
	    int c = sum/10;
	    sum = sum%10;
	    a.set(a.size()-1,sum);
	    for(int i = a.size()-2;i>=0;i--) {
	        if(c == 0)
	            break;
	        sum = a.get(i) + c;
	        c = sum/10;
	        sum = sum%10;
	        a.set(i, sum);
	    }
	    
	    if(c!=0) {
	        a.add(0, c);
	    }
	    Set<Integer> zeroes = new HashSet<Integer>();
	    int i =0;
	    while((int)a.get(0) == 0) {
	        a.remove(0);
	    }
	    return a;
	}
}