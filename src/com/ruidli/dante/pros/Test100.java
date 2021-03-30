package com.ruidli.dante.pros;


class Test100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null &&  q == null){
            return true;
        }else if (p==null || q == null){
            return false;
        } else if (p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }




    public static void main(String[] args){
        Test100 t = new Test100();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
