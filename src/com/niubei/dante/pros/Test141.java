package com.niubei.dante.pros;


import java.util.LinkedList;
import java.util.List;

class Test141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Test141 t = new Test141();
        ListNode head = new ListNode(5);
        head.next = head;
        t.hasCycle(head);
    }
}
