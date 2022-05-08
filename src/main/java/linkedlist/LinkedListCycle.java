package linkedlist;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowP = head;
        ListNode fastP = head;
        while(slowP != null) {
            slowP = slowP.next;
            if (fastP.next == null || fastP.next.next == null) {
                return false;
            } else {
                fastP = fastP.next.next;
                if (fastP == slowP) {
                    return true;
                }
            }
        }
        return false;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
