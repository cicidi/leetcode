import java.util.*;
public class  TopSort {
	public static void main(String[] args){
		TopSort topSort = new TopSort(5);
		topSort.addEdge(4,2);
		topSort.addEdge(3,2);
		topSort.addEdge(2,1);
		topSort.addEdge(1,0);
		
		for (Integer vetex:topSort.sort()){
			System.out.println(vetex);		
		}
	}
	
	List<Integer>[] edgeList ;
	int[] indegree;	
	int size;

	public TopSort(int size){
		this.size = size;
		edgeList = new ArrayList[size];
		for (int i =0; i < size; i++){
			edgeList[i] = new ArrayList<>();
		}
	}
	public void  addEdge(int from, int to){
		edgeList[from].add(to);	
	}

	/*
	 *A <-B
	 *    B <- C
	 *    B <- D
	 * 0[1] //A
	 * 1[2]	//B
	 * 2[0]	//C
	 * 3[0] //D
	 *
	 * */
	public List<Integer> sort(){
		int[] indegree = new int[size];
		for (int i = 0 ; i < size; i++){
			for (int to : edgeList[i]){
				indegree[to]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < size; i++){
			if ( indegree[i]==0 ){
				q.offer(i);	
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		while(!q.isEmpty()){
			int fromVetex = q.poll();
			List<Integer> edge = edgeList[fromVetex];
			list.add(fromVetex);
			for (int i = 0; i < edge.size(); i++){
				int to = edge.get(i);
				indegree[to]--;
				if (indegree[to] == 0){
					q.offer(to);
				}
			}
		}
		return list;
	}
}
