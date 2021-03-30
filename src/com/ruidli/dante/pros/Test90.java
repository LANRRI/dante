package com.ruidli.dante.pros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); //排序
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过,
            // ********************避免递归的同一层级 add了相同的元素，避免了元素的重复******************
            // i > start 代表了非第一次进入该层级，第一次进入该层级可以不考虑元素重复，直接add
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }




    public static void main(String[] args){
        Test90 t = new Test90();
        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        int target = 12;
        t.subsetsWithDup(candidates);
//        System.out.println();

    }
}
