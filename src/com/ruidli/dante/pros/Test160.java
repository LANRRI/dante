package com.ruidli.dante.pros;

public class Test160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = headA;
        ListNode tailB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (tailA != null || tailB != null){
            if (tailA != null){
                tailA = tailA.next;
                lengthA++;
            }
            if (tailB != null){
                tailB = tailB.next;
                lengthB++;
            }
        }
        int gap = Math.abs(lengthA-lengthB);
        for (int i = 0;i<gap;i++){
            if (lengthA>lengthB){
                headA = headA.next;
            }else{
                headB = headB.next;
            }
        }

        while (headA!=null && headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }
}
