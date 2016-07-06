/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

You aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
*/
public class Solution {
    public ArrayList<Integer> flip(String A) {
        int c = 0;
        int max = 0;
        int l=0, r=0, max_l=0, max_r=0;
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i) == '0') {
                c++;
            } else if(A.charAt(i)=='1') {
                c--;
            }
            if(c<0) {
                c = 0;
                l=i+1;
                r=i+1;
            }
            if(c>max) {
                max = c;
                r = i;
                max_l = l;
                max_r = r;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(max==0)
            return result;
        result.add(max_l+1);
        result.add(max_r+1);
        return result;
    }
}
