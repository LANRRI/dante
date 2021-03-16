package com.niubei.dante.pros;


import java.util.*;

class Test236 {
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
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        //在当前节点
        boolean inCurrentNode = root.val == p.val || root.val == q.val;
        //在左节点
        boolean inLeft = dfs(root.left,p,q);
        //在右节点
        boolean inRight = dfs(root.right,p,q);
        if((inLeft && inRight) || (inCurrentNode && (inLeft || inRight))){
//            更上一层节点值不符合,inRight/inLeft
           TreeNode ans = root;
        }
        return inLeft || inRight || inCurrentNode;
    }

//    最优雅
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
