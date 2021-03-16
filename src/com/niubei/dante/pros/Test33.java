package com.niubei.dante.pros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test33 {
    public int search(int[] nums, int target) {
        if (nums.length==0) return -1;
//        return search(nums,target,0,nums.length-1);
        return 0;
    }

//    public int search(int[] nums, int target,int start,int end) {
//        int mid = (start+end)/2;
//        if(nums[mid] == target) return mid;
//        if(nums[mid] >= nums[start]){
//            if (nums[mid] > target && nums[start] <= target){
//                search(nums,target,start,mid-1);
//            }else{
//                search(nums,target,mid+1,end);
//            }
//        }else {
//            if (nums[mid] <= target && target<nums[end]){
//                search(nums,target,mid+1,end);
//            }else {
//                search(nums,target,start,mid-1);
//            }
//        }
//        return -1;
//    }

    public int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args){
        Test33 t = new Test33();
        int[] candidates = new int[]{1,2,3,4,5,6};
        int target = 12;
//        List<List<Integer>> res = t.search(candidates,target);
//        System.out.println(res);

    }
}

