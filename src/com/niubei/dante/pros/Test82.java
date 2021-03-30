package com.niubei.dante.pros;

class Test82 {
//    public ListNode deleteDuplicates(ListNode head) {
//
//        ListNode hair = new ListNode(-1);
//        hair.next = head;
//        ListNode p = hair;
//        while (head != null && head.next != null){
//           while (head == head.next){
//               head = head.next;
//           }
//           p.next = head;
//           p = head;
//           head = head.next;
//        }
//    }
//    用一个新node 指代 重复或者非重复
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        while (cur != null) {
            int curRepeatNum = 0;
            ListNode difNode = cur;
            // 找到和cur指向的结点值不同的结点
            while (difNode != null && difNode.val == cur.val) {
                curRepeatNum++;
                difNode = difNode.next;
            }

            // 如果curRepeatNum的值大于1，则表示cur指向的结点重复出现了
            if (curRepeatNum > 1) {
                prev.next = difNode;
            }else {
                // cur指向的结点没有重复出现，则将变量prev指向cur所指向的结点
                prev = cur;
            }
            cur = difNode;
        }

        return dummyHead.next;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode x = preHead;
        ListNode p = head.next;
        while(p != null){
            while(p != null && head.val == p.val){
                p = p.next;
            }
//            通过判断 p 和 head.next 是否相等 来确认是否存在重复元素

            if(p == head.next){
                x = head;
                head = head.next;
                p = p.next;
//            如果 重复，此时pre的指针是不移动位置的
            }else{
                x.next = p;
                head = p;
                if(p!= null){
                    p = p.next;
                }
            }
        }
        return preHead.next;

    }

}
