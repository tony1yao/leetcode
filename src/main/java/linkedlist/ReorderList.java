package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public void reorderList(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        while(head != null) {
            nodeList.add(head);
            head = head.next;
        }

        ListNode pointer;
        head = pointer = nodeList.get(0);
        int start = 1;
        int end = nodeList.size() - 1;
        while(start <= end) {
            ListNode node;
            node = nodeList.get(end);
            node.next = null;
            pointer.next = nodeList.get(end);;
            pointer = pointer.next;
            if (start != end) {
                node = nodeList.get(start);
                node.next = null;
                pointer.next = node;
                pointer = pointer.next;
            }
            start++;
            end--;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
