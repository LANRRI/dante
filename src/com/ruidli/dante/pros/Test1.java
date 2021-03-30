package com.ruidli.dante.pros;

import java.util.Hashtable;

public class Test1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Hashtable<Integer,Integer> meta = new Hashtable<>();
//        不能提前put
//        for (int i=0;i<nums.length;i++){
//            meta.put(nums[i],i);
//        }
        for (int i=0;i<nums.length;i++){
            int remain = target-nums[i];
            if (meta.containsKey(remain)){
                res[0] = i;
                res[1] = meta.get(remain);
                return  res;
            }
            meta.put(nums[i],i);
        }
        return res;
    }
}
