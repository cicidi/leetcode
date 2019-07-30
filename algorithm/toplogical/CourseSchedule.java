package toplogical;

import java.util.*;

/**
 * @author cicidi on 5/26/19
 * Lintcode 615. Course Schedule
 * url https://www.lintcode.com/problem/course-schedule/description
 */
public class CourseSchedule {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here

        // edge case
        if (prerequisites.length == 0) {
            return true;
        }

        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int index = 0; index < prerequisites.length; index++) {
            int from = prerequisites[index][0];
            int to = prerequisites[index][1];
            System.out.printf("from %d  to %d\n", from, to);
            List<Integer> list = map.getOrDefault(from, new ArrayList<Integer>());
            list.add(to);

            // notice 这个地方其实没有必要用map 用arraylist 也行
            map.put(from, list);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int to = 0; to < indegree.length; to++) {
            if (indegree[to] == 0) {
                queue.add(to);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            // System.out.printf("to %d \n",from);
            // System.out.printf("size %d \n",map.size());
            // System.out.println(map.get(from));
            for (Integer to : map.getOrDefault(from, new ArrayList<Integer>())) {
                indegree[to] -= 1;
                if (indegree[to] == 0) {
                    queue.offer(to);
                }
            }
            count++;
        }
        // System.out.printf("count %d numberofCourse %d \n",count,numCourses);
        return count == numCourses;
    }
}
