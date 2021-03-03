package com.niubei.dante.pros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test45 {
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
//    我们维护当前能够到达的最大下标位置，记为边界 end。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            //每次更新可到达的最大位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //当i遍历到当前的end时，如果当前点能跳的更远，那么跳当前点位置，否则就跳之前可跳的最大位置，所以上面取math.max
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public static void main(String[] args){
        Test45 t = new Test45();
        int[] candidates = new int[]{2,3,1,2,4,2,3};
        int target = 12;
        int res = t.jump2(candidates);
        System.out.println(res);

    }
}
