package com.niubei.dante.pros;

class Test41 {
//    hash表的空间复杂度更高,所以需要寻找代替的空间方案
//    对于一个长度为 NN 的数组，其中没有出现的最小正整数只能在 [1, N+1][1,N+1] 中。
//    这是因为如果 [1, N][1,N] 都出现了，那么答案是 N+1N+1，否则答案是 [1, N][1,N] 中没有出现的最小正整数。
//    先将所有的负值标记为不存在的正值，然后对对应的index的值设置为负值，然后第一个正值所在的位置即为第一个缺失的
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
