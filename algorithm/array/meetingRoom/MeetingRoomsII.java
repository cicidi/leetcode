//package array.meetingRoom;
//
//import java.util.List;
//import java.util.PriorityQueue;
//
///**
// * @author cicidi on 5/26/19
// * Lintcode 919. Meeting Rooms
// * url https://www.lintcode.com/problem/meeting-rooms-ii/my-submissions
// */
//public class MeetingRoomsII {
//    /**
//     * @param intervals: an array of meeting time intervals
//     * @return: the minimum number of conference rooms required
//     */
//    public int minMeetingRooms(List<Interval> intervals) {
//        // Write your code here
//        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((x, y) -> {
//            if (x.time == y.time)
//                return x.count - y.count;
//            else
//                return x.time - y.time;
//        }
//        );
//        for (Interval interval : intervals) {
//            int start = interval.start;
//            int end = interval.end;
//            queue.add(new Pair(start, 1));
//            queue.add(new Pair(end, -1));
//        }
//        int max = 0;
//        int concurrent = 0;
//        while (!queue.isEmpty()) {
//            Pair pair = queue.poll();
//            concurrent += pair.count;
//            max = Math.max(max, concurrent);
//        }
//        String s;
//        s.su
//        return max;
//    }
//
//    class Pair {
//        int time;
//        int count;
//
//        public Pair(int time, int count) {
//            this.time = time;
//            this.count = count;
//        }
//    }
//
//    public class Interval {
//        int start, end;
//
//        Interval(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//    }
//}