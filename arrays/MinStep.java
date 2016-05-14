// You are in an infinite 2D grid where you can move in any of the 8 directions :

//  (x,y) to 
//     (x+1, y), 
//     (x - 1, y), 
//     (x, y+1), 
//     (x, y-1), 
//     (x-1, y-1), 
//     (x+1,y+1), 
//     (x-1,y+1), 
//     (x+1,y-1) 
// You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
public class Solution {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int[][] arr;
        int sum = 0;
        int x1 = X.get(0);
        int y1 = Y.get(0);
        for(int i=1;i<X.size();i++) {
        	int x2 = X.get(i);
        	int y2 = Y.get(i);
        	int xDiff = Math.abs(x2 - x1);
        	int yDiff = Math.abs(y2 - y1);

        	sum = sum + Math.max(xDiff, yDiff);

        	x1 = x2;
        	y1 = y2;
        }

        return sum;
    }
}
