package com.ruidli.dante.pros;

class Test70 {
    public int climbStairs(int n) {

        if (n == 0 || n == 1 || n == 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i =2;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

//    滚动数组
    public int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
