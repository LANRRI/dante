package com.niubei.dante.pros;

import java.util.ArrayList;
import java.util.List;

public class Test448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length+1;

//        标准代码使用此方式修改值，而非我下述方式
//        for (auto& num : nums) {
//            int x = (num - 1) % n;
//            nums[x] += n;
//        }


        for (int i = 0;i<nums.length;i++){
//          如果置为-1 就不知道原值是多少，覆盖了原值，不知道被覆盖位置的值，所以可以使用取反或者加上max
            nums[nums[i]-1] += n;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i<nums.length;i++){
            if (nums[i] < n){
                res.add(i+1);
            }
        }
        return res;
    }








    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length+1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ;i<nums.length;i++){
            if (nums[i] != -1) {
                nums[(nums[i] - 1) % n] = -1;
            }
        }
        for (int i = 0;i<n;i++){
            if(nums[i] != -1){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String args[]){
        Test448 t = new Test448();
        t.findDisappearedNumbers2(new int[]{4,3,2,7,8,2,3,1});
    }










}
