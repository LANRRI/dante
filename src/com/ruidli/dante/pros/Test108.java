package com.ruidli.dante.pros;


class Test108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }

    public TreeNode back(int[] nums,int s ,int e){
        if (s > e){
            return null;
        }
        int mid = (s+e)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = back(nums,s,mid-1);
        root.right = back(nums,mid+1,e);
        return root;
    }


    public static void main(String[] args){
        Test108 t = new Test108();
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
