import java.util.*;
public class TestListInHashMap {

	public static void main(String []args){
		List<Integer> list =new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		list.add(1);
		list2.add(1);
		Set<List<Integer>> set=new HashSet<List<Integer>>();
		set.add(list);	
		set.add(list2);
		System.out.println(set.size());	
	}

}
