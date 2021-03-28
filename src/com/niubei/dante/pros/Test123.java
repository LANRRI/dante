package com.niubei.dante.pros;

public class Test123 {
////    dp
//    public int maxProfit(int[] prices) {
//        int[][][] dp = new int[prices.length][2][3];
//        dp[0][0][0] = 0;
//        dp[0][0][1] = 0;
//        dp[0][0][2] = 0;
//        dp[0][1][0] = -prices[0];
//        dp[0][1][1] = -prices[0];
//        dp[0][1][2] = -prices[0];
//        for ( int i = 1;i<prices.length;i++){
////            三维动态规划，将交易次数做个限制就好，保证最终交易次数不超过2次
//            for (int j =1;j<3;j++){
//                dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j-1] + prices[i]);
////                # k = 1 表示持有
//                dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][0][j-1] - prices[i]);
//            }
//        }
//    }

    //    dp 优化版 buy1 buy2 sale1 sale2  全不操作
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int buy2 = -prices[0];
        int sale1 = 0;
        int sale2 = 0;
        for (int i= 0;i<prices.length;i++){
            buy1 = Math.max(buy1,-prices[i]);
            sale1 = Math.max(sale1,buy1+prices[i]);
            buy2 = Math.max(buy2,sale1-prices[i]);
            sale2 = Math.max(sale2,buy2+prices[i]);
        }
        return Math.max(sale1,sale2);
    }



}
