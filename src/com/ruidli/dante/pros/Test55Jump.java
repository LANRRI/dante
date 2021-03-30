package com.ruidli.dante.pros;

class Test55Jump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
//            rightmost 代表当前位置可以行进的最远距离，所以所有小于rightmost的i都可以到达
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args){
        Test55Jump t = new Test55Jump();
        int[] candidates = new int[]{1,-1,3,5,-5,4,2,-3};
        int target = 12;
//        int res = t.maxSubArray(candidates);
//        System.out.println(res);

    }
}
