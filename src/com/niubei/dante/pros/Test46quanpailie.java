package com.niubei.dante.pros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Test46quanpailie {

    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> orders = new ArrayList<>();
        int[] labels = new int[nums.length];
        List<Integer> curPre = new ArrayList<>();

        ord(list,orders,size,curPre,labels);
        return orders;
    }

    public void ord(List<Integer> nums,List<List<Integer>> orders,int ordLen, List<Integer> curPre,int[] labels) {
        if (curPre.size() == ordLen){
            orders.add(new ArrayList<>(curPre));
            return;
        }
        for (int i =0; i<ordLen;i++){
            if(labels[i] != 1) {
                int pivot = nums.get(i);
                curPre.add(pivot);
                labels[i]=1;
                ord(nums, orders, ordLen, curPre, labels);
                curPre.remove(curPre.size() - 1);
                labels[i]=0;
            }
        }

    }


//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//        List<Integer> output = new ArrayList<Integer>();
//        for (int num : nums) {
//            output.add(num);
//        }
//
//        int n = nums.length;
//        backtrack(n, output, res, 0);
//        return res;
//    }
//
//    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
//        // 所有数都填完了
//        if (first == n) {
//            res.add(new ArrayList<Integer>(output));
//        }
//        for (int i = first; i < n; i++) {
//            // 动态维护数组
//            Collections.swap(output, first, i);
//            // 继续递归填下一个数
//            backtrack(n, output, res, first + 1);
//            // 撤销操作
//            Collections.swap(output, first, i);
//        }
//    }


    public static void main(String[] args){
        Test46quanpailie t = new Test46quanpailie();
        int[] candidates = new int[]{1,2,3};
        int target = 12;
        List<List<Integer>> res = t.permute(candidates);
        System.out.println(res);

    }
}
