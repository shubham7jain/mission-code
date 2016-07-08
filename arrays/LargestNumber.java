/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
public class Solution {
	    public String largestNumber(final List<Integer> a) {
	    int flag = 0;
		for(Integer element : a) {
			if(element != 0) {
				flag = 1;
				break;
			}
		}
		if(flag == 0)
			return "0";
		Object[] b = a.toArray();
		Arrays.sort(b, new SortComparator());
		StringBuilder sb = new StringBuilder();
		for(Object elem : b) {
			sb.append(elem);
		}
		return sb.toString();
	}
	
	public class SortComparator implements Comparator {

		@Override
		public int compare(Object a1, Object a2) {
		    String x = String.valueOf(a1);
		    String y = String.valueOf(a2);
		    
		    String xy = x + y;
		    String yx = y + x;
		    
		    return yx.compareTo(xy);
	    }
	}
}