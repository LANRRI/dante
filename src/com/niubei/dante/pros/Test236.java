package com.niubei.dante.pros;


import java.util.*;

class Test236 {

//        1->2->3->4->5
//        p  q->n


//        1->4->3->2->5-
    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }
    public TreeNode lowestCommonAncestor() {
        return null;
    }
    //有误,如果有2个p 也会导致输入存在。
    public boolean back(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> res){
        if (root == null) return false;
        if (root.val == p.val || root.val == q.val){
            return true;
        }
        boolean findLeft = back(root.left,p,q,res);
        boolean findRight = back(root.right,p,q,res);
        if (findLeft && findRight && res.size() == 0){
            res.add(root);
            return true;
        }
        return findLeft || findRight || (root.val == p.val || root.val == q.val);
    }
    // 节点中无重复值
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        // 左右均找到，       或者 val 匹配，并且左右，有一个找到
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            TreeNode ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        return l == null ? r : (r == null ? l : root);
    }


    public static void main(String[] args){
        Test236 t = new Test236();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
