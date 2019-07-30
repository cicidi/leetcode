package algorithm.company.Square;

public class RevertByteInAnInteger {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int revert = solution.reverse(100);
//        System.out.println(Integer.toBinaryString(100));
//        System.out.println(Integer.toBinaryString(solution.reverse(10)));
        int n = 100;
        System.out.println(solution.intToString(n));
        System.out.println(solution.reverseToString(n));
        System.out.println(solution.invertValue(n));
        // important 从此以后除以2 都用>>2表示
        System.out.println(n >> 1);
        System.out.println(solution.intToString(n >> 1));
        System.out.println(-n >>> 1);
        System.out.println(n >>> 1);
        System.out.println(0 >> 1);
    }

    static class Solution {
        public String intToString(int n) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                String s = ((n % 2) == 0 ? "0" : "1");
                sb.insert(0, s);
                n = n / 2;
            }
            return sb.toString();
        }

        public String reverseToString(int n) {
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                String s = ((n % 2) == 0 ? "0" : "1");
                sb.append(s);
                n = n / 2;
            }
            return sb.toString();
        }

        public int invertValue(int n) {
            int[] arr = new int[32];
            int i = 0;
            while (n > 0) {
                int rem = n % 2;
                arr[31 - i] = rem;
                i++;
                n = n / 2;
            }
            int val = 0;
            int startIndex = i - 1;
            for (int start = 31 - startIndex, powerSize = 0; start < 32; start++, powerSize++) {
                val += Math.pow(2, powerSize) * arr[start];
            }
            return val;
        }
    }

}

