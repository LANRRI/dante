package com.niubei.dante.pros;

import java.util.*;

class Test53 {

    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) return 0;
        int max = nums[0];
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            sum+=nums[i];
            max = Math.max(max,sum);
            if (sum <= 0) sum = 0;
        }

        return max;
    }





    public static void main(String[] args){
        Test53 t = new Test53();
        int[] candidates = new int[]{1,-1,3,5,-5,4,2,-3};
        int target = 12;
        int res = t.maxSubArray(candidates);
        System.out.println(res);

    }
}
