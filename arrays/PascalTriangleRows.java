/*
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
*/
public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(a == 0) {
	        return result;
	    }
	    ArrayList<Integer> row1 = new ArrayList<Integer>();
	    row1.add(1);
	    result.add(row1);
	    for(int i = 1; i < a; i++) {
	        ArrayList<Integer> prevRow = result.get(i-1);
	        ArrayList<Integer> currentRow = new ArrayList<Integer>();
	        for(int j=0;j<=i;j++) {
	            if(j==0) {
	                currentRow.add(prevRow.get(j));
	            } else if(j ==i) {
	                currentRow.add(prevRow.get(j-1));
	            } else {
	                currentRow.add(prevRow.get(j) + prevRow.get(j-1));
	            }
	        }
	        result.add(currentRow);
	    }
	    return result;
	}
}
