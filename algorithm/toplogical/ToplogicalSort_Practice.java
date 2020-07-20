import java.util.*;

public class ToplogicalSort_Practice {
    /*
       1, 0

       2, 0

       2, 1

       indegree [1] =1
       indegree[0] =2
        indegree[2] = 1;

       2.edges = 0 ,1
       1.edges =1

      q.
      init with 2
      get 2,
          for (2.edges){
            (0,1)
            indegree[0] -1
            because indegree[0] != 0
              do nothing
            indegree[1] == 0
              add 1 to q

      }
            g.addEdge(5, 2);
            g.addEdge(5, 0);
            g.addEdge(4, 0);
            g.addEdge(4, 1);
            g.addEdge(2, 3);
            g.addEdge(3, 1);
    */
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        List<Integer> result = g.sort();
        System.out.println(Arrays.toString(result.toArray()));
    }
}

class Graph {
    int size;
    List<List<Integer>> edges = new ArrayList<>();
    int[] indegree;

    public Graph(int size) {
        for (int i = 0; i < size; i++) {
            edges.add(new ArrayList());
        }
        this.size = size;
        this.indegree = new int[size];
    }

    public void addEdge(int from, int to) {
        List<Integer> l = edges.get(from);
        if (l == null) {
            l = new ArrayList<>();
        }
        l.add(to);
        indegree[to] += 1;
    }

    public List<Integer> sort() {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int index = q.poll();
            result.add(index);
            for (int toVetex : edges.get(index)) {
                indegree[toVetex] -= 1;
                if (indegree[toVetex] == 0) {
                    q.add(toVetex);
                }
            }
        }
        return result;
    }
}
