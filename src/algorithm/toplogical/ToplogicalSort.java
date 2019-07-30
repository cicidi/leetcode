package algorithm.toplogical;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * tag
 * lintcode
 * leetcode
 * url
 */

// notice 方法
//  先创建edge
//  在创建入度
//  入度 为零的先扔到Q里面去
//  不段从Q里面去， 一个是把刚取出来的放到结果集， 另一个是用这个node 去找他的所有toNode
//  toNode 的入度-1， 如果为零 扔回到Q 里面去
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
        // notice 用一个array 就能够表现一个edge 关系， index 是from， 值是出去，
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
            // notice 用一个arrayList 就可以表示入度
            List<Integer> toVertexList = adj[i];
            for (int toVertex : toVertexList) {
                indegree[toVertex]++;
            }
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int index = 0; index < V; index++) {
            if (indegree[index] == 0) {
                queue.offer(index); // notice 把所有入度为0的index 先加到q 里面
            }
        }
        int count = 0;
        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            sortedList.add(vertex);
            System.out.printf("vertex %d \n", vertex);
            //notice 遍历这个入读位0 的node edge  把他的toNode 找出来， 那个node 的入度找出来-1
            // 如果等于零，加到queue 里面去
            // important 不要直接加到结果集里面去
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