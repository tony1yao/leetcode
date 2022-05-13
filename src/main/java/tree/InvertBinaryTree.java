package tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.right != null || node.left != null) {
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = temp;
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return root;
    }
}
