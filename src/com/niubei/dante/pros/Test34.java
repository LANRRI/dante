package com.niubei.dante.pros;

class Test34 {

    public int[] searchRange(int[] nums, int target) {
//      找到第一个等于value的index
        int leftIdx = binarySearch(nums, target, true);
//      找到第一个大于 value的index
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Test34 t = new Test34();
        int[] candidates = new int[]{1,2,3,4,5,6};
        int target = 12;
//        List<List<Integer>> res = t.search(candidates,target);
//        System.out.println(res);

    }
}

