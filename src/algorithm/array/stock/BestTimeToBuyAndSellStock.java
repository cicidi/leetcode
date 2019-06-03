package algorithm.array.stock;

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
        for (int price : prices) {
            min = Math.min(min, price);  // notice write download lowest prices in the past
            maxProfile = Math.max(price - min, maxProfile);  // notice check each price minus min
        }
        return maxProfile;
    }
}
