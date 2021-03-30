package com.niubei.dante.pros;

public class Test300maxUpSeq {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for (int i=0;i<nums.length;i++){
          int j = i-1;
          dp[i] = 1;
          while (j>=0){
              if ( nums[j]<nums[i]){
//                  以当前字符结尾的最长上升子序列
                  dp[i] = Math.max(dp[i],dp[j]+1);
              }
              j--;
          }
          max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String args[]){
        int[] arr = new int[]{0,1,0,3,2,3};
        Test300maxUpSeq t = new Test300maxUpSeq();
        t.lengthOfLIS(arr);
    }
}
