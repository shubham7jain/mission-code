/*
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.
*/
public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    int xor = 0, x=0, y=0;
	    for(int i=0;i<a.size();i++) {
	        xor = xor^a.get(i)^(i+1);
	    }
	    int rightShift = xor&(~(xor-1));
	    for(int i=0;i<a.size();i++) {
	        if((a.get(i) & rightShift) !=0) {
	            x = x^a.get(i);
	        } else {
	            y = y ^ a.get(i);
	        }
	    }
	    for(int i=1;i<=a.size();i++) {
	        if((i & rightShift) !=0) {
	            x = x^i;
	        } else {
	            y = y^i;
	        }
	    }
	    int repeat = -1, missing = -1;
	    for(int i=0;i<a.size();i++) {
	        if(a.get(i) == x) {
	            repeat = x;
	            missing = y;
	            break;
	        }
	        else if(a.get(i) == y) {
	            repeat = y;
	            missing = x;
	            break;
	        }
	    }
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    result.add(repeat);
	    result.add(missing);
	    return result;
	}
}