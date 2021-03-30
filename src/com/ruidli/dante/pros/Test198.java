package com.ruidli.dante.pros;

public class Test198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0;i<nums.length;i++){
            if (i == 0){
                dp[i] = nums[i];
                continue;
            }
            if (i == 1){
                dp[i] = Math.max(nums[i-1],nums[i]);
                continue;
            }
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
