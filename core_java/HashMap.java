public class  HashMap <K,V>  {


	public static void main(String []args) {
		HashMap<String,String> map=new HashMap (16);
		map.put("hello1","world1");	
		map.put("hello2","world2");	
		map.put("hello3","world3");	
		map.put(null,"world");

		System.out.println( map.get("hello1"));	
		System.out.println( map.get("hello2"));	
		System.out.println( map.get("hello3"));	
		System.out.println( map.get("hello"));	
	
	}




	public Entry<K,V>[] table;

	public int capacity ;

	


	public HashMap (int capacity ){
		this.capacity = capacity;
		this.table = new Entry [this.capacity];
	}

	public V  put (K key, V value ){
			
		if ( key == null ) return null ;
		int hash = key.hashCode();
		int index = Math.abs(hash % capacity);
		Object k ;
		for (Entry <K,V> e = table [index]; e !=null; e = e.next){
			if ( hash == e.key.hashCode() && ((k=e.key) == key|| key.equals(k))){
				V old = e.value;
				e.value = value ;
				return old ;
				// ? 
			}
		}

		addEntry( key, value , hash , index ); 

		return null ;
	}


	public V get (Object key ) {
	
		if ( key == null ) return null ;	
		int hash = key.hashCode();
		int index =Math.abs( hash % capacity) ;
		Object k;
		for ( Entry <K,V> e = table[index]; e !=null ; e=e.next){
			if (hash == e.key.hashCode() && ( (k = e.key) ==key || key.equals(k) )){
				return e.value;
			}
		
		}
		return null;
	}


	public void addEntry ( K key, V value , int hash, int index)  {
		
		Entry <K,V> e = table [index];
		table [index]  = new Entry (key, value, hash , e );

	}

	public static class Entry <K,V> {
	
		public final K key;
		
		public V value;
		
		public final int hash;

		public Entry<K,V> next;

		public Entry (K key, V value, int hash, Entry<K,V> next) {
		
			this.key = key;
			this.value = value;
			this.hash = hash;
			this.next = next;
		}


	}

}
