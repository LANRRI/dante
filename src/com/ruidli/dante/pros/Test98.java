package com.ruidli.dante.pros;


class Test98 {

    public boolean isValidBST(TreeNode root) {
        if(root == null || ((root.left == null || root.left.val < root.val) && ( root.right == null ||root.right.val> root.val))){
            return true;
        }
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        return left && right && ((root.left == null || root.left.val < root.val) && (root.right == null || root.right.val > root.val));
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }




    public static void main(String[] args){
        Test98 t = new Test98();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
