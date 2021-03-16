package com.niubei.dante.pros;


import java.util.List;

class Test110 {

    public boolean isBalanced(TreeNode root) {
        return recursion(root) == -1;
    }

    public int recursion(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = recursion(root.left);
        int rightHeight = recursion(root.right);
        if (leftHeight != -1 && rightHeight != -1 && Math.abs(leftHeight - rightHeight) <= 1){
            return Math.max(leftHeight,rightHeight) + 1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args){
        Test110 t = new Test110();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
