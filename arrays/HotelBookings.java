/*
A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input:


First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether its possible to make a booking. 
Return 0/1 for C programs.
O -> No there are not enough rooms for N booking.
1 -> Yes there are enough rooms for N booking.
*/
public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        ArrayList<Custom> eventPoints = new ArrayList<Custom>();
        for(int  i=0;i<arrive.size(); i++) {
            if(arrive.get(i) != depart.get(i)) {
            eventPoints.add(new Custom(arrive.get(i), true));
            eventPoints.add(new Custom(depart.get(i), false));
            }
        }
        Object[] eventPointsArrayTotal = eventPoints.toArray();
        Arrays.sort(eventPointsArrayTotal, new CustomComparator());
        int c =0;
        int k =0, i = 1;
        for(i=0;i<eventPointsArrayTotal.length;i++) {
            Object eventPoint = eventPointsArrayTotal[i];
            Custom custom = (Custom)eventPoint;
            if(custom.type)
               c++;
            else
               c--;
            if(c>K)
               return false;
        }
        return true;
    }
    
    class CustomComparator implements Comparator<Object> {
        public int compare(Object s1, Object s2) {
            if(((Custom)s1).event-((Custom)s2).event == 0) {
                if(((Custom)s1).type == false) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return ((Custom)s1).event-((Custom)s2).event;
        }
    }
    
    class Custom {
        Integer event;
        boolean type;
        
        public Custom(Integer event, boolean type) {
            this.event = event;
            this.type = type;
        }
    }
}