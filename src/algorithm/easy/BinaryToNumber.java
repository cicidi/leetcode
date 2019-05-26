package algorithm.easy;

/*
  * tag
  * lintcode
  * leetcode
  * url
  */
public class BinaryToNumber {

    public static void main(String[] args) {
        String arr = Integer.toBinaryString(100000000 * 1000000000);
        int count = 0;
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == '1') {
                count++;
            }
        }
        System.out.println(arr);
        System.out.println(count);
    }
}
