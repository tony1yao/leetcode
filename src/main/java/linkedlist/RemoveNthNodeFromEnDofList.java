package linkedlist;

public class RemoveNthNodeFromEnDofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode firstPointer = head;

        for(int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            firstPointer = firstPointer.next;
        }

        ListNode secondPointer = head;

        if (firstPointer == null) {
            head = head.next;
            secondPointer = null;
            return head;
        }

        while(firstPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        ListNode next = secondPointer.next;
        secondPointer.next = secondPointer.next.next;
        next.next = null;
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
