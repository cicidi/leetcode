package algorithm.toplogical;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ToplogicalSort {

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        ToplogicalSort g = new ToplogicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
//        g.addEdge(2, 0);
        System.out.println("Following is a Topological Sort");
        g.toplogicalSort();

    }

    int V;
    List<Integer>[] adj;

    public ToplogicalSort(int V) {
        this.V = V;

        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        adj[from].add(to);
    }

    public void toplogicalSort() {

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            List<Integer> toVertexList = adj[i];
            for (int toVertex : toVertexList) {
                indegree[toVertex]++;
            }
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int index = 0; index < V; index++) {
            if (indegree[index] == 0) {
                queue.offer(index);
            }
        }

        int count = 0;

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {

            int vertex = queue.poll();
            sortedList.add(vertex);
            System.out.printf("vertex %d \n", vertex);
            for (int toVertex : adj[vertex]) {
                indegree[toVertex] -= 1;
                if (indegree[toVertex] == 0) {
                    queue.offer(toVertex);
                }
            }
            count++;
        }
        if (count != V) {
            System.out.printf("circle dep %d \n", count);
            return;
        }
        for (int i : sortedList) {
            System.out.println(i);
        }
    }
}


//package com.cicidi;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//class Graph {
//    int V; // number of vertices
//    ArrayList<Integer>[] adj; // vertices that connect to a vertice
//
//    public Graph(int V) {
//        this.V = V;
//        adj = (ArrayList<Integer>[]) new ArrayList[V];
//        for (int i = 0; i < V; i++) {
//            adj[i] = new ArrayList<>();
//        }
//    }
//
//    public void addEdge(int from, int to) {
//        adj[from].add(to);
//    }
//
//    public void toplogicalSort() {
//        int[] indegree = new int[V];
//        for (int i = 0; i < V; i++) {
//            ArrayList<Integer> fromS = adj[i];
//            for (int node : fromS) {
//                indegree[node]++;
//            }
//        }
//
//        Queue<Integer> queue = new PriorityQueue<>();
//        for (int i = 0; i < indegree.length; i++) {
//            if (indegree[i] == 0) {
//                queue.offer(i);
//            }
//        }
//
//        int count = 0;
//
//        List<Integer> toplogicalOrder = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            int vert = queue.poll();
//            toplogicalOrder.add(vert);
//
//            for (int neighbor : adj[vert]) {
//                indegree[neighbor] -= 1;
//                if (indegree[neighbor] == 0) {
//                    queue.offer(neighbor);
//                }
//            }
//            count++;
//        }
//        if (count != V) {
//            System.out.println("circle dependency");
//            return;
//        }
//        for (int vert : toplogicalOrder) {
//            System.out.println(vert);
//        }
//    }
//}