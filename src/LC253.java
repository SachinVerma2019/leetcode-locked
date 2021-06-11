import java.util.Arrays;
import java.util.PriorityQueue;

public class LC253 {
    //https://leetcode.ca/2016-08-09-253-Meeting-Rooms-II/
    //Meeting Room 2

    public static void main(String[] args) {
        Interval intervals [] = new Interval [] {
                new Interval(0,30),
                new Interval(5,10),
                new Interval(15,20),
        };
        int res = minMeetingRooms(intervals);
        System.out.println("number of meeting rooms required : " + res);
    }

    private static class Interval {
        public int start;
        public int end;
        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    /*
    * Algortihm
    * 1. Sort the Interval array with start time
    * 2. PriorityQueue min heap based on end time
    * 3. Insert the first interval
    * 4. if the next interval is such that next.start < top.end, add both
    * 5. finally return the size of the queue
    *
    * */
    public static int minMeetingRooms(Interval[] intervals){
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((i1,i2) -> i1.end - i2.end);

        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval prev = pq.poll();
            Interval next = intervals[i];
            if (next.start < prev.end) {
                pq.offer(next);
            }else {
                prev.end = next.end;
            }
            pq.offer(prev);
        }
        return pq.size();


    }

}
