package com.niubei.dante.pros;

public class Test337 {

//   树形结构只需要知道当前节点的左子树和右子树的返回结果，分为当前节点偷和当前节点不偷的情况
    public int rob(TreeNode root){
        int[] res = backTrace(root);
        return Math.max(res[0],res[1]);
    }

    public int[] backTrace(TreeNode root){
        if (root == null) return new int[]{0,0};
        int[] left = backTrace(root.left);
        int[] right = backTrace(root.right);
        int dp[] =  new int[2];
        dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }
}
