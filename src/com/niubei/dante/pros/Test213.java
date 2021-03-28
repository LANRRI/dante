package com.niubei.dante.pros;

import java.util.Arrays;

public class Test213 {
    public int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i<nums.length-1;i++){
            dp[i] = Math.max(dp[i-2],dp[i-1]+nums[i]);
        }
        int max1 = dp[nums.length-2];
        Arrays.fill(dp,0);
        dp[0] = nums[nums.length-1];
        dp[1] = dp[0]+nums[1];
        for (int i = 2; i<nums.length-2;i++){
            dp[i] = Math.max(dp[i-2],dp[i-1]+nums[i]);
        }
        return Math.max(max1,dp[nums.length-3]);
    }


    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
