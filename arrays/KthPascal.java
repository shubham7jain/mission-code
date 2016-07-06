/*
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
Note:-k is 0 based. k = 0, corresponds to the row [1]. 
*/
public class Solution {
	public ArrayList<Integer> getRow(int a) {
	    ArrayList<Integer> pascal = new ArrayList<Integer>();
	    pascal.add(1);
	    for(int i=2;i<=a+1;i++) {
	        ArrayList<Integer> newpascal = new ArrayList<Integer>();
	        for(int j=0;j<i;j++) {
	            if(j>=i-1) {
	                newpascal.add(j, pascal.get(j-1));
	            } else if(j==0) {
	                newpascal.add(j, pascal.get(j));
	            } else {
	                newpascal.add(j, pascal.get(j) + pascal.get(j-1));
	            }
	        }
	        pascal = newpascal;
	    }
	    return pascal;
	}
}