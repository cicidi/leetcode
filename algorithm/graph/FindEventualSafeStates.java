package graph;

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdegree = new int[graph.length];
        List<List<Integer>> fromNodes = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            fromNodes.add(new ArrayList<>());
        }
        for (int from = 0; from < graph.length; from++) {
            for (int to : graph[from]) {
                outdegree[from]++;
                fromNodes.get(to).add(from);
            }
        }

        List<Integer> result = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < outdegree.length; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int from : fromNodes.get(node)) {
                outdegree[from] -= 1;
                if (outdegree[from] == 0) {
                    q.offer(from);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}