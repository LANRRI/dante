package com.niubei.dante.pros;

import java.util.*;

class Test78subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int[] visited = new int[nums.length];
        List<Integer>res = new ArrayList<>();
        dfs(nums,0,res);
        return subs;
    }
    List<List<Integer>> subs = new ArrayList<>();
//    此种方法  add 的结果会有重复结果
    public void find(int[] nums,int[] visited,int index,List<Integer>res){
        if (res.size() <= nums.length){
            subs.add(new ArrayList<>(res));
//            return;
        }
        for (int i = index;i<nums.length;i++){
            if (visited[i] != 1){
                visited[i] = 1;
                res.add(nums[i]);
                find(nums,visited,i+1,res);
                visited[i] = 0;
                res.remove(res.size()-1);
                find(nums,visited,i+1,res);
            }
        }
    }


//  此方法是对的
    public void dfs(int[] nums,int index,List<Integer>res){
        if (index == nums.length){
            subs.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[index]);
        dfs(nums,index+1,res);
        res.remove(res.size()-1);
        dfs(nums,index+1,res);
    }





    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String args[]){
        int [] arr = new int[]{1,2,3};
        Test78subsets t = new Test78subsets();
        t.subsets(arr);
    }
}
