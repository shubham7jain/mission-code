/*
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index
*/
public class Solution {
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	   	List<Long> sumList = new ArrayList<Long>();
	    List<Long> lengthList = new ArrayList<Long>();
	    List<Long> indexList = new ArrayList<Long>();
	    Long sum = 0l, length = 0l, index = -1l;
	    for(int i=0;i<a.size();i++) {
	        Integer ele = a.get(i);
	        
	        if(ele >= 0 && sum == 0 && index == -1) {
	            sum = sum + a.get(i);
	            index = (long) i;
	            length = (long) 1;
	        } else if(ele >= 0 && index != -1) {
	            sum = sum + a.get(i);
	            length++;
	        } else if(sum>=0 && ele < 0 &&  index != -1) {
	            sumList.add(sum);
	            lengthList.add(length);
	            indexList.add(index);
	            sum = 0l;
	            length = 0l ;
	            index = -1l;
	        } 
	    }
	    if(sum>=0 && index != -1) {
	    	sumList.add(sum);
            lengthList.add(length);
            indexList.add(index);
            sum = 0l;
            length = 0l ;
            index = -1l;
	    }
	    if(sumList.size() == 0) {
	    	return new ArrayList<Integer>();
	    }
	    Long max = sumList.get(0);
	    int maxIndex = 0;
	    for(int i = 1;i < sumList.size();i++) {
	        if(sumList.get(i)> max) {
	            maxIndex = i;
	            max = sumList.get(i);
	        } else if(sumList.get(i) == max) {
	            if(lengthList.get(i) > lengthList.get(maxIndex)) {
	                maxIndex = i;
	                max = sumList.get(i);
	            }
	        }
	    }
	    List<Integer> result = new ArrayList<Integer>();
	    for(long i = indexList.get(maxIndex); i < indexList.get(maxIndex) + lengthList.get(maxIndex); i++) {
	        result.add(a.get((int)i));
	    }
	    return new ArrayList<Integer>(result);
}
}