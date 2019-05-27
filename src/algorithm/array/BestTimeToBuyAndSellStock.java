package algorithm.array;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 149. Best Time to Buy and Sell Stock
  * https://www.lintcode.com/problem/best-time-to-buy-and-sell-stock/description
  */
public class BestTimeToBuyAndSellStock {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int min = Integer.MAX_VALUE;
        int maxProfile = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            min = Math.min(min, prices[i]);
            maxProfile = Math.max(prices[i + 1] - min, maxProfile);
        }
        return maxProfile;
    }
}
