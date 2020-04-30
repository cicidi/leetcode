package array;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 Input:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3

Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.*

 * 分析
 *
 * 1. your tank = 1 - 3 failed
 * 2. your tank = 2 - 4 failed
 * 3. your tank = 3 -5 failed
 * 4. your ...
 * 5. your tank = 5 - 2 = 3 
 *                3 + 1 - 3 = 1
 *                1 + 2 - 4  no  falied
 * important 起始这道题又一个关键的点 -> 第一个array 的 总数 - 第二个array 的总数必须要大于0，
 *  不然肯定不可能
 * notice 第二件事情，就是从每一个index， 计算可否走到下一步
 *  然后最后一个 可以从current 走到最后的index 就是最终结果，尽管我还不知道怎么证明这个
 * important 猜想， 假设一个index ， 这个index 之前的所有方式都不可能性，而total 又大于 第二个array 的total
 *  那么说明这个index 之后一定有一个index 是可以的， 而既然index 这个值可定比后面的sum 更有可能， 因为这个
 * index 还是帮tank里多添油了呢
 * */


public class GasStation {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int out = s.canCompleteCircuit(gas, cost);
        System.out.println(out);
    }

    static class Solution {

        public int canCompleteCircuit(int[] gas, int[] cost) {
            if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
                return -1;
            }

            int sum = 0;
            int total = 0;
            int index = -1;

            for (int i = 0; i < gas.length; i++) {
                //notice 一个用来track 当前 sum  如果sum 小于0  index走下一个, sum重新开始
                sum += gas[i] - cost[i];  
                // 用一个total 来track
                total += gas[i] - cost[i]; 
                if (sum < 0) {
                    index = i;
                    sum = 0;
                }
            }
            return total < 0 ? -1 : index + 1;
            // index should be updated here for cases ([5], [4]);
            // total < 0 is for case [2], [2]
        }
        public int canCompleteCircuitSolution2(int[] gas, int[] cost) {
            if (gas == null || cost == null || gas.length <= 0 || cost.length == 0){
                return -1;
            }
        
            int total = 0;
            int cur = 0;
            int index = -1;
            for (int i = 0; i < gas.length; i++){
                int count = 0;
                for (int j = i; count < gas.length; count++) {
                    cur = cur + gas[j] - cost[j];
                    // if cur < 0 then start from next i
                    if (cur < 0){
                        cur = 0;
                        total = 0;
                        index = -1;
                        break;
                    }
                    if (j + 1 == gas.length){
                        j = 0;
                    }else{
                        j = j + 1;
                    }
                    index = j;
                }
                if (cur >= 0 && index != -1){
                    System.out.println(" stop " + i);
                    return i;
                }
            }
            return -1;
        }
    }
}

