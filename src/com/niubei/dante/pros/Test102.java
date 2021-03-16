package com.niubei.dante.pros;


import java.util.*;

class Test102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            List<Integer> values = new ArrayList<>();
            int levelSize = queue.size();
            for (int count = 0 ; count < levelSize;count++) {
                root = queue.poll();
                if (root!=null){
                    values.add(root.val);
                    queue.offer(root.left);
                    queue.offer(root.right);
                }
            }
            res.add(values);

        }
        return res;
    }


    public List<Integer> levelOrder2(TreeNode root,List<List<Integer>> res) {
        List<Integer> val = new ArrayList<>();
        if (root == null) return val;

        val.add(root.val);
        List<Integer> left = levelOrder2(root.left,res);
        List<Integer> right = levelOrder2(root.right,res);
        left.addAll(right);
        res.add(left);
        return val;
    }



    public static void main(String[] args){
        Test102 t = new Test102();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
