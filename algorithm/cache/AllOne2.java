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
 */
package cache;

import java.util.*;


//To-do
// create a use case. and draw steps
public class AllOne2 {

    Bucket head = new Bucket(Integer.MIN_VALUE);
    Bucket tail = new Bucket(Integer.MAX_VALUE);

    Map<String, Integer> key2cnt = new HashMap<>(); // notice key <-> count mapping
    Map<Integer, Bucket> cnt2bt = new HashMap<>();  // notice count <-> bucket mapping
    // notice bucket has count, all keys that has the count.

    public void init() {
        head.next = tail;
        tail.prev = head;
    }

    void inc(String key) {
        int cnt = key2cnt.getOrDefault(key, 0);
//        Bucket curBt = cnt2bt.getOrDefault(cnt, new Bucket(1));
//        if (!curBt.keys.contains(key)) {
//            curBt.keys.add(key);
//            addBt(head, curBt);
//        } else {
        changePos(key, cnt, 1);
//        }

    }

    void dec(String key) {

        // check if key2cont has the key
        if (!key2cnt.containsKey(key)) {
            return;
        }
        // find the count
        int cnt = key2cnt.get(key);
        // use count to find bucket
//        Bucket curBt = cnt2bt.get(cnt);
        // if count == 1
        //  -   need remove bucket from key2cnt
        //  -   need to remove key bucket.key
        //  -
        // else
        //  -   change position
        // finally check the bucket
        // if cnt2bt, the bucket size is 0, need to remove the Integer key
//        if (cnt == 1) {
//            curBt.keys.remove(key);
//            if (cnt2bt.keySet().size() == 0) {
//                rmBt(curBt);
//                key2cnt.remove(key);
//            }
//             should throw exceptions
//        } else {
        changePos(key, cnt, -1);
//        }
    }

    void addBt(Bucket cur, Bucket prev) {
        Bucket next = prev.next;
        cur.prev = prev;
        cur.next = next;
        prev.next = cur;
        cnt2bt.put(cur.cnt, cur);
    }

    void rmBt(Bucket cur) {
        Bucket next = cur.next;
        Bucket prev = cur.prev;
        prev.next = next;
        next.prev = prev;
        cnt2bt.remove(cur.cnt);
    }

    //  1 get curBt
    //  2 get tarBt
    void changePos(String key, int cnt, int offset) {
        // get currnet cnt
//        int cnt = key2cnt.get(key);
        // update key2Cnt map
        key2cnt.remove(key);
        int newCnt = cnt + offset;
        key2cnt.put(key, newCnt);

        Bucket curBt = cnt2bt.get(cnt);
        if (curBt != null) {
            curBt.keys.remove(key);
            if (curBt.keys.size() == 0) {
                rmBt(curBt);
            }
        }
        Bucket newBt;
        // update Linkedlistl
        //
        // when add , if bucket(newCnt) exit, add key to bucket
        //               not exit, create new Bucket , and new bukcet to Linkedlist`

        if (cnt2bt.containsKey(newCnt)) {  // next count bucket exit
            newBt = cnt2bt.get(newCnt);
            newBt.keys.add(key);
        } else {
            if (newCnt != 0) {
                newBt = new Bucket(newCnt);
                newBt.keys.add(key);
                addBt(newBt, head);
            }
        }
    }

    class Bucket {
        int cnt;
        Bucket next;
        Bucket prev;
        Set<String> keys;

        public Bucket(int cnt) {
            this.cnt = cnt;
            this.keys = new HashSet<>();
        }
    }

    public static void main(String[] args) {
        AllOne2 test = new AllOne2();
        test.init();
        test.inc("abc");
        test.inc("abc");
        test.inc("abc");
        test.dec("abc");
        System.out.println(test.cnt2bt);
        System.out.println(test.key2cnt);
    }
}
 
