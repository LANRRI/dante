package com.ruidli.dante.pros;


import java.util.PriorityQueue;
import java.util.Queue;

class Test101 {

    public boolean isSymmetric(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }
        if (p==null || q== null){
            return false;
        }
        return p.val == q.val && isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
    }


    public boolean isSymmetric2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }

            if (p == null || q == null){
                return false;
            }
            if (p.val != q.val){
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }




    public static void main(String[] args){
        Test101 t = new Test101();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
