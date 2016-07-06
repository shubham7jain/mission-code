/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:
 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ] 
*/
public class Solution {
	public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
	    int c = 1;
	    ArrayList<ArrayList<Integer>> matList = new ArrayList<ArrayList<Integer>>();
	    int[][] mat = new int[a][a];
	    for(int i=0;i<a/2;i++) {
	        for(int j=i; j<a-i;j++) {
	            mat[i][j] = c++;
	        }
	        
	        for(int k=i+1;k<a-i;k++) {
	            mat[k][a-i-1] = c++;
	        }
	        
	        for(int j=a-i-2;j>=i;j--) {
	            mat[a-i-1][j] = c++;
	        }
	        
	        for(int k=a-i-2;k>=i+1;k--) {
	            mat[k][i] = c++;
	        }
	    }
	    if(a%2!=0)
	        mat[a/2][a/2] = c;
	    for(int i=0;i<a;i++) {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for(int j=0;j<a;j++) {
	            list.add(mat[i][j]);
	        }
	        matList.add(list);
	    }
	    return matList;
	}
}
