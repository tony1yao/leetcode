public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.test();
    }

    public void test() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(8);

        printList(addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode result = node;
        int nextIncrement = 0;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + nextIncrement;
            if (sum < 10) {
                node.val = sum;
                nextIncrement = 0;
            } else {
                node.val = sum % 10;
                nextIncrement = 1;
            }

            if (l1.next != null || l2.next != null) {
                ListNode next = new ListNode();
                node.next = next;
                node = node.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remaining = l1 == null? l2: l1;
        while (remaining != null) {
            if (nextIncrement > 0) {
                int sum = remaining.val + nextIncrement;
                if (sum < 10) {
                    node.val = remaining.val + nextIncrement;
                    nextIncrement = 0;
                } else {
                    node.val = sum % 10;
                    nextIncrement = 1;
                }

            } else {
                node.val = remaining.val;
            }

            if (remaining.next != null) {
                ListNode next = new ListNode();
                node.next = next;
                node = node.next;
            }
            remaining = remaining.next;
        }

        if (nextIncrement > 0) {
            ListNode next = new ListNode();
            next.val = nextIncrement;
            node.next = next;
        }

        return result;
    }

    private void printList(ListNode node) {
        while(node!=null) {
            System.out.print(" " +node.val);
            node = node.next;
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


