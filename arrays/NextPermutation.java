/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50

*/
public class Solution {
	public void nextPermutation(ArrayList<Integer> a) {
	    int pos1 = -1;
	    int pos2 = -1;
	    for(int i=a.size()-1;i>=0;i--) {
	        if(i-1>=0 && a.get(i-1) < a.get(i)) {
	            pos1 = i-1;
	            break;
	        }
	    }
	    if(pos1 == -1) {
	        reverse(a, 0);
	        return;
	    }
	    for(int i=a.size()-1;i>=0;i--) {
	        if(a.get(i)>a.get(pos1)) {
	            pos2 = i;
	            break;
	        }
	    }
	    int temp = a.get(pos2);
	    a.set(pos2, a.get(pos1));
	    a.set(pos1, temp);
	    reverse(a, pos1+1);
	}

	public void reverse(ArrayList<Integer> a, int start) {
	    int end = a.size()-1;
	    while(start<=end) {
	        int temp = a.get(start);
	        a.set(start, a.get(end));
	        a.set(end, temp);
	        start++;
	        end--;
	    }
	}
}
