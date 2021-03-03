package com.niubei.dante.pros;

import java.util.ArrayList;
import java.util.List;

class Test75 {
    public void sort(int[] nums) {
        int n = nums.length;
        int p = 0, q = n - 1;
        for (int i = 0; i <= q; ++i) {
            if (nums[i] == 0) {
                nums[i] = nums[p];
                nums[p] = 0;
                ++p;
            }
            if (nums[i] == 2) {
                nums[i] = nums[q];
                nums[q] = 2;
                --q;
                if (nums[i] != 1) {
                    --i;
                }
            }
        }
    }




    public static void main(String[] args){
        Test75 t = new Test75();
        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        int target = 12;
        t.sort(candidates);
//        System.out.println();

    }
}
