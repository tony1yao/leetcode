import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RootToLeafSumTest {
    RootToLeafSum rootToLeafSum = new RootToLeafSum();
    Node root = new Node(2);
    Node node1 = new Node(3);
    Node node2 = new Node(5);
    Node node3 = new Node(12);
    Node node4 = new Node(7);
    Node node5 = new Node(8);

    @Test
    void hasPathSum1() {
        Node root = new Node(2);
        Assertions.assertTrue(rootToLeafSum.hasPathSum(root, 2));
    }

    @Test
    void hasPathSum2() {
        Node root = new Node(2);
        Assertions.assertFalse(rootToLeafSum.hasPathSum(root, 1));
    }

    @Test
    void hasPathSum3() {
        Node root = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(12);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node3.right = node5;

        Assertions.assertFalse(rootToLeafSum.hasPathSum(root, 1));
        Assertions.assertTrue(rootToLeafSum.hasPathSum(root, 25));
        Assertions.assertTrue(rootToLeafSum.hasPathSum(root, 14));
    }
}