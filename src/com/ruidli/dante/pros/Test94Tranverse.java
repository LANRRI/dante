package com.ruidli.dante.pros;


import java.util.*;

class Test94Tranverse {

    public void midOrder(TreeNode head) {
        if(head == null){
            return;
        }
        midOrder(head.left);
        System.out.println(head.val);
        midOrder(head.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.empty()){
            while (root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.empty()){
            while (root!=null){
                res.add(root.val);
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
        return res;
    }

    public void midOrder3(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
//        s.push(root);
        while (root !=null || !s.empty()){
            while (root!=null){
                s.push(root.left);
                root = root.left;
            }
            root = s.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public void pre(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (root !=null || !s.empty()){
            while (root!=null){
                System.out.println(root.val);
                s.push(root.left);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // ???pre ??????root.right ???????????????????????????????????????????????????????????????root
            // ??????????????????root ??????????????????2???????????????right ????????????????????????root???right ?????????
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                //visit ??????????????? root = s.pop() ?????????????????????root!=null????????????
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }



    public static void main(String[] args){
        Test94Tranverse t = new Test94Tranverse();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
