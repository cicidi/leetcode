/*
 * 1. create several test case.
 * 2. find the edge case
 * 3. review test case, see if enough
 * 4. use recursive
 * 5.
 * */
public class DecodeNumber {
    public static void main(String[] args) {
        String test = "1201";
        DecodeNumber d = new DecodeNumber();
        d.init(test.length());
        int result = d.helper(test, 0);
        System.out.println(result);

    }

    int dp[];

    public int solve(String str) {
        if (str.length() == 0 || str.charAt(0) == '0') {
            return 0;
        }
        return helper(str, 0);
    }

    public int helper(String str, int i) {
        // here need to check if i is larege then lenght, because the helper(str, i + 2) might go to i = len + 1
        // directly, so only equal cannot capture all exceptions.`
        if (str.length() == 0 || i >= str.length()) {
            return 0;
        }
        // here "str.charAt(i)" is a keypoint 
        // because when the char is '0',  the number is either 0  or "0?"  both are meaningless.
        // so the base of dp[i] value of index, which is  =='0'   is 0
        if (str.charAt(i) == '0') {
            return 0;
        }

        // when reach to the last index
        // AND  this char is not '0', so it will have onluy option.
        if (i == str.length() - 1) {
            return 1;
        }
        // check if dp[i] it has a value before, if yes, then use previous calculated value.
        if (dp[i] != -1) {
            return dp[i];
        }
        int result = helper(str, i + 1);
        if (i + 1 < str.length()) {
            int a = str.charAt(i) - '0';
            int b = str.charAt(i + 1) - '0';
            if (a * 10 + b >= 10 && a * 10 + b <= 26) {
                if (i == str.length() - 2) {
                    result += 1;
                }
                result += helper(str, i + 2);
            }
        }
        dp[i] = result;
        return result;
    }

    public void init(int length) {
        dp = new int[length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
    }


    /*
     *Num(12345) = Num(2345) + Num(345)
     *Num(34567) = Num(4567)

     if String equal "" or str[0-1] < 26
     * */


}
