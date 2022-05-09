package linkedlist;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
//        if (lists.length == 1) {
//            return lists[0];
//        }
//
//        ListNode firstList = lists[0];
//        for(int i = 1; i < lists.length; i++) {
//            ListNode secondList = lists[i];
//            ListNode mergedList = mergeTwoLists(firstList, secondList);
//            firstList = mergedList;
//        }
//        return firstList;
        return partition(lists, 0, lists.length-1);
    }

    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start<end) {
            int middle = (start+end)/2;
            ListNode list1 = partition(lists, start, middle);
            ListNode list2 = partition(lists, middle+1, end);
            return mergeTwoLists(list1, list2);
        } else {
            return null;
        }
    }


    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
