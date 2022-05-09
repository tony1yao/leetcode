package linkedlist;

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode p1, p2, mergedList;
        p1 = list1;
        p2 = list2;

        if (p1.val < p2.val) {
            mergedList = p1;
            p1 = p1.next;
        } else {
            mergedList = p2;
            p2 = p2.next;
        }

        ListNode result = mergedList;

        while (p1!=null && p2 != null) {
            if (p1.val < p2.val) {
                mergedList.next = p1;
                p1 = p1.next;
                mergedList = mergedList.next;
            } else {
                mergedList.next = p2;
                p2 = p2.next;
                mergedList = mergedList.next;
            }
        }

        if (p1 != null) {
            mergedList.next = p1;
        }

        if (p2 != null) {
            mergedList.next = p2;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



