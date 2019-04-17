public class Soultion{



	public int solution(){
	
		HashMap<Pair<Integer,Integer>,Integer> map =new HashMap<>();
		HashMap<Pair<Integer,Integer>,Integer> copy =new HashMap<>();
		// fill all exist route to map and copy
		// if no need fix, then cost is 0
		//
		fillMap(map);
		List<Pair<Integer,Integer>> replace=new ArrayList<>();
		for(int n=1; n <= lengh; n++ ){
			int total=0;
			for (i=n,j = n+1; i<=length-1&&j<= length; i++,j++){
				Integer value=map.get(new Pair(n,j));
				Integer tmp=map.get(new Pair(i,j))
				if (value!=null){
					total+=tmp;
				}
				total=Math.min(total,value)
				map.put(new Pair(i,j),total);
			}
			
		}
		//copy map and copy  
		//find entry which  entry1.value= entry2.value  //  which means  replacement is needed.
		//Then sort by value
		//if can only replace n road ,then take n smallest.
	}
}
