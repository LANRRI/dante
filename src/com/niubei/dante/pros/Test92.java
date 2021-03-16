package com.niubei.dante.pros;


import java.util.List;

class Test92 {

//        1->2->3->4->5
//        p  q->n


//        1->4->3->2->5-

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 0;
        ListNode newHead = new ListNode();
        newHead.next= head;
        ListNode pre = newHead;
        ListNode cur = head;
        while(count < left){
            pre = pre.next;
            cur = cur.next;
            count ++;
        }
        ListNode start = pre;
        ListNode next = cur.next;
        while(count < right){
            ListNode tmp = cur.next;
            cur.next = pre;
            next.next = cur;
            pre = cur;
            cur = tmp;
            next = cur.next;
            count ++;
        }
        ListNode q = start.next;
        q.next = next;
        start.next = cur;
        return null;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

    public static void main(String[] args){
        Test92 t = new Test92();
//        int[] candidates = new int[]{0,1,2,2,1,0};
//        int[][] candidates = new int[][]{{1,2},{-1,3},{3,5},{5,7},{-5,1},{4,6},{2,4},{-3,2}};
        String s="12345";
        int target = 12;
//        System.out.println(t.reverseBetween(s));
//        System.out.println();

    }
}
