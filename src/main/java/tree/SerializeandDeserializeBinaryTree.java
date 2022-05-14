package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class SerializeandDeserializeBinaryTree {
    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree tree = new SerializeandDeserializeBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.right = node5;
        node5.right = node4;
        String value = tree.serialize(node1);
        System.out.println(value);
        TreeNode root = tree.deserialize(value);
        System.out.println(root.toString());
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        bfs(queue, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isBlank()) {
            return null;
        }
        String[] values = data.trim().split(" ");
        return buildTree(values);
    }

    private TreeNode buildTree(String[] values) {
        TreeNode[] treeArrays = new TreeNode[values.length];
        for(int i = 0; i < values.length; i++) {
            if (!values[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.valueOf(values[i]));
                treeArrays[i]  = node;
                if (i-1 >= 0) {
                    int parentIndex = (i-1)/2;
                    if (i%2==1) {
                        treeArrays[parentIndex].left = node;
                    } else {
                        treeArrays[parentIndex].right = node;
                    }
                }
            }
        }
        return treeArrays[0];
    }

    private void bfs(Queue<TreeNode> queue,StringBuilder sb) {
        int level = 1;
        int numOfLevel = (int)Math.pow(2, (level - 1));
        boolean hasNonNullValue = false;
        while(!queue.isEmpty()) {
            if (numOfLevel > 0) {
                TreeNode node = queue.remove();
                numOfLevel--;
                if (node == null) {
                    sb.append("# ");
                    queue.add(null);
                    queue.add(null);
                } else {
                    sb.append(node.val + " ");
                    queue.add(node.left);
                    queue.add(node.right);
                    if (node.left != null || node.right != null) {
                        hasNonNullValue = true;
                    }
                }
            } else {
                if (hasNonNullValue) {
                    level++;
                    numOfLevel = (int)Math.pow(2, (level - 1));
                    hasNonNullValue = false;
                } else {
                    return;
                }
            }
        }
    }
}
