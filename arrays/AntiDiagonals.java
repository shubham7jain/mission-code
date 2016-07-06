/*
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]

*/
public class Solution {
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    for(int i=0;i<a.size();i++) {
	        ArrayList<Integer> row = a.get(i);
	        for(int j=0;j<row.size();j++) {
	            if(i+j>=result.size()) {
	                ArrayList<Integer> resultRow = new ArrayList<Integer>();
	                resultRow.add(row.get(j));
	                result.add(resultRow);
	            } else {
	                ArrayList<Integer> resultRow = result.get(i+j);
	                resultRow.add(row.get(j));
	                result.set(i+j, resultRow);
	            }
	        }
	    }
	    return result;
	}
}
