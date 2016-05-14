// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

// For example:

// Given the array [-2,1,-3,4,-1,2,1,-5,4],

// the contiguous subarray [4,-1,2,1] has the largest sum = 6.

// For this problem, return the maximum sum.

public class Solution {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
		boolean isAllNegative = true;
		for(Integer no : a) {
			if(no > 0) {
				isAllNegative = false;
				break;
			}
		}

		if(isAllNegative) {
			int max = Integer.MIN_VALUE;
			for(Integer no : a) {
				if(max < (int)no) {
					max = (int)no;
				}
			}
			return max;
		}

		int maxSoFar = 0;
		int currentMax = 0;
		for(Integer no : a) {
			currentMax = currentMax + no;
			if(currentMax<0) {
				currentMax = 0;
			}
			if(currentMax>maxSoFar) {
				maxSoFar = currentMax;
			}
		}
		return maxSoFar;
	}
}
