package algorithm.array;

import algorithm.model.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author cicidi on 5/26/19
 * Lintcode 920. Meeting Rooms
 * url https://www.lintcode.com/problem/meeting-rooms/description
 */
public class MeetingRooms {

    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here

        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        Collections.sort(intervals, new IntervalComparator());
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < end) {
                return false;
            }
            end = Math.max(end, intervals.get(i).end);
        }
        return true;
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        if (i1.start == i2.start) {
            return i1.end - i2.end;
        } else {
            return i1.start - i2.start;
        }
    }
}
