package dp;

public class Fib {

    static int[] dp;

    // 0 , 1 ,2, 3 ,4  ,5
    //
    // 0 ,1, 1, 2, 3, 5, 8 ,13, 21 
    public static void main(String[] args) {
        Fib fib = new Fib();
        int n = 10;
        dp = new int[n + 1];
        System.out.println(fib(n));
        System.out.println(fibLoop(n));

    }

    public static int fib(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        if (dp[i] != 0) {
            return dp[i];
        }

        dp[i] = fib(i - 1) + fib(i - 2);
        return dp[i];

    }

    public static int fibLoop(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];
    }


}
