package com.ruidli.dante.pros;

public class Test83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode next = head.next;
        ListNode cur = head;
        while (next != null) {
            while (next != null && cur.val == next.val){
                next = next.next;
            }
            cur.next = next;
            cur = next;
            if(next != null){
                next = next.next;
            }

        }
        return head;
    }
    public static void  main(String args[]){
        Test83 t = new Test83();
        ListNode l  = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        t.deleteDuplicates(l);
    }
}
