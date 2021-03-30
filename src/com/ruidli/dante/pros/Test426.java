package com.ruidli.dante.pros;

import java.util.Stack;

class Test426 {
    public TreeNode treeToDoublyList(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = new TreeNode();
        TreeNode hair = head;
        while (root!=null || !stack.empty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            head.right = root;
            root.left = head;
            head = root;
            root = root.right;

        }
        if (root != null) {
            root.right = hair.left;
        }
        return hair;

    }

}
