public class AllOne2{
       
   Bucket head = new Bucket(Integer.MIN_VALUE);
   Bucket tail = new Bucket(Integer.MAX_VALUE);

   Map<String, Integer> key2Bt = new HashMap<>();
   Map<Integer, Bucket> cnt2Bt = new HashMap<>();
   void inc (String key) {
       int cnt = cnt2Bt.getOrDefault(key, 1);
       Bucket curBt = cnt2Bt.getOrDefault(cnt, new Bucket(1));
       if (!curBt.keys.contains(key)){
           curBt.keys.add(key);
           addBt(head, curBt); 
       }else{
            changePos(cur, 1);
       } 
      
     }

    void dec (String key){
     if (!cnt2Bt.containsKey(key)){
        return;
     }   
     int cnt = cnt2Bt.getOrDefault(key);
        Bucket curBt = cntBt.get(cnt);
        
        if ()
    }
 
    void addBt(Bucket cur, Bucket prev){
      Bucket next = prev.next;
      current.prev = prev;
      current.next = next;
      prev.next = current;
    }

    void rmBt(Bucket cur){
      Bucket next = current.next;
      Bucket prev = current.prev;
      prev.next = next;
      next.prev = prev;
    }

    //  1 get curBt
    //  2 get tarBt
    void changePos(String key, offset){
       // get currnet cnt
       int cnt = key2Cnt.get(key);
       // update key2Cnt map
       key2Cnt.put(cnt + offset);
       key2Cnt.remove(cnt);
       // update Linkedlistl
       //
       Bucket newBt;
       // when add , if bucket(newCnt) exit, add key to bucket
       //               not exit, create new Bucket , and new bukcet to Linkedlist`
      
     if (cnt2Bt.containsKey(cnt+ offset)){  // next count bucket exit
            newBt = cnt2Bt.get(cnt + offset);
     } else {
            newBt = new Bucket(cnt + offset);
            addBt(newBt, head);
     }
            newBt.keys.add(key);
            cntBt.get(key).keys.remove(key);
       }else{
            newBt = new Bucket(1);
            add
       }

       Bucket curBt = key2Bt.get(cur)  
    }
}

class Bucket {
    int cnt;
    Bucket next;
    Bucket prev;
    Set<String> keys; 

    public Bucket(int cnt){
        this.cnt = cnt;
    }
}
    /*
     * key should be group by value.
     * need 1 map -> <String, Bucket{ count, keys}> - one solution was using 2 map, cnt2Bt mapping   
     * need 2 map here, if only has 1 key to Bucket. then not able to find next count group to Join
     * need head, and tail attach to min and max.
     * 
     * Step 
     *      inc and dec can be same operator, use different offset.
     *             if inc 
     *                  ! exist -> addKey and bt
     *                  exit -> switch(+1)
     *             if dec 
     *                  count == 1 -> removeKey and bt
     *                  count !=1 -> switch(-1)
     *                
     *                *      use the count to find current Bucket.keys
 *          to increament 
 *              move the key to currentBucket.next.keys
 *                  if currentBucket.next.count != count+1
 *                          create newBucket(count+1)
 *                              add to key to new Bucket
 *                  else findNextBucket : nextBucket = currentBucket.next
 *                              add key to nextBucket;
 *                  
 *                  whe add key done
 *                  remove key from currentBucket;
 *
 *              remove the key from currentBucket.keys.
 * Map : map key -> String val -> count
 *      use the key to find current Curent
 *      
 *
 *
 * /

 
