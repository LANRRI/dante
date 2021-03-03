package com.niubei.dante.pros;


import javax.swing.tree.TreeNode;
import java.util.*;

class Test94 {

//        1->2->3->4->5
//        p  q->n


//        1->4->3->2->5-
    static class ListNode {
        int val;
        ListNode right;
        ListNode left;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
    public void midOrder(ListNode head) {
        if(head == null){
            return;
        }
        midOrder(head.left);
        System.out.println(head.val);
        midOrder(head.right);
    }

//    public List<Integer> inorderTraversal(TreeNode root) { {
//        List<Integer> res = new ArrayList<Integer>();
//        Stack<ListNode> s = new Stack<>();
//        s.push(root);
//        while (!s.empty()){
//            while (root.left!=null){
//                s.push(root.left);
//                root = root.left;
//            }
//            res.add(root.val);
//            if (root.right == null){
//                root = s.pop();
//            }else {
//                root = root.right;
//            }
//        }
//        return res;
//    }

    public void midOrder3(ListNode root) {
        Stack<ListNode> s = new Stack<>();
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

    public void pre(ListNode root) {
        Stack<ListNode> s = new Stack<>();
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
//
//    public void post(ListNode root) {
//        Stack<ListNode> s = new Stack<>();
////        s.push(root);
//        while (root !=null || !s.empty()){
//            while (root!=null){
//                s.push(root.left);
//            }
//            root = s.pop();
//            if (root.right != null){
//                s.push(root);
//                root = root.right;
//            }else{
//                System.out.println(root.val);
//                root = s.pop();
//            }
//        }
//    }

    public List<Integer> postorderTraversal(ListNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 用pre 代表root.right 是否已被访问，如果已被访问，则直接访问当前root
            // 直接访问当前root 节点的可能有2中，一种是right 已被访问，一种是root的right 为空。
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                //visit 后不能直接 root = s.pop() 否则会进入上层root!=null的循环。
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }



    public static void main(String[] args){
        Test94 t = new Test94();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
