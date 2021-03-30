package com.ruidli.dante.pros;

public class Test122 {
//    dp
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
    //贪心方式
    public int maxProfit1(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

}
