package com.ruidli.dante.pros;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//与Test有些类似
class Test128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;
//        不能从1-n的循环，因为是整数数组，不是正整数
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public int longestConsecutive2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();


        int longestStreak = 0;
        for (int num : nums) {
            if (!map.containsKey(num)){
                int left = map.getOrDefault(num-1,0);
                int right = map.getOrDefault(num+1,0);
                int curr = left+right+1;
                longestStreak = Math.max(longestStreak,curr);
                map.put(num,curr);
                map.put(num-left,curr);
                map.put(num+right,curr);
            }
        }

        return longestStreak;
    }

}
