package com.niubei.dante.pros;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Test104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;

    }


    public static void main(String[] args){
        Test104 t = new Test104();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
        String ss = null;
        System.out.println(ss.equals("a"));
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
