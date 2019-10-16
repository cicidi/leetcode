package array.meetingRoom;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cicidi on 5/26/19
 * Lintcode 391. Number of Airplanes in the Sky
 * url https://www.lintcode.com/problem/number-of-airplanes-in-the-sky/description
 */
public class NumberOfAirplanesintheSky {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here

        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        PriorityQueue<Activity> queue = new PriorityQueue<Activity>((x, y) -> {
            if (x.time == y.time) {
                return x.takeOff - y.takeOff;
            } else {
                return x.time - y.time;
            }

        });
        for (Interval i : airplanes) {
            queue.add(new Activity(i.start, 1));
            queue.add(new Activity(i.end, -1));
        }
        int max = Integer.MIN_VALUE;
        int current = 0;
        while (!queue.isEmpty()) {
            Activity a = queue.remove();
            current += a.takeOff;
            max = Math.max(max, current);
            if (a.time > 90) {
                System.out.printf("time %d takeOff %d max %d \n", a.time, a.takeOff, max);
                System.out.printf("size %d \n", airplanes.size());

            }
        }
        return max;
    }

    class Activity {
        int time;
        int takeOff;

        public Activity(int time, int takeOff) {
            this.time = time;
            this.takeOff = takeOff;
        }
    }

    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

// class Point{
//     int time;
//     int flag;

//     Point(int t, int s) {
//         this.time = t;
//         this.flag = s;
//     }
//     public static Comparator<Point> PointComparator = new Comparator<Point>() {
//         public int compare(Point p1, Point p2) {
//             if(p1.time == p2.time)
//                 return p1.flag - p2.flag;
//             else
//                 return p1.time - p2.time;
//       }
//     };
// }

// class Solution {
//     /**
//      * @param intervals: An interval array
//      * @return: Count of airplanes are in the sky.
//      */
//     public int countOfAirplanes(List<Interval> airplanes) {
//         if (airplanes==null||airplanes.size()==0){
//             return 0;
//         }
//         List<Point> list = new ArrayList<>(airplanes.size() * 2);
//         for (Interval i : airplanes) {
//             list.add(new Point(i.start, 1));
//             list.add(new Point(i.end, 0));
//         }

//         Collections.sort(list, Point.PointComparator);
//         int count = 0, ans = 1;
//         for (Point p : list) {
//             if(p.flag == 1)
//                 count++;
//             else
//                 count--;
//             ans = Math.max(ans, count);
//         }

//         return ans;
//     }

// }
