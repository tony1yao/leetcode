package symmetric.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = solution.isSymmetric(root);
        System.out.println(result);
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> nodes = new ArrayList<>();
        nodes.add(root.val);
        bfs(root, queue, nodes);
        int level = 0;
        int nodeIndex = 0;
        while (nodeIndex < nodes.size()) {
            int nodeCountPerLevel = (int)Math.pow(2, level);

            int startIndex = nodeIndex;
            int endIndex = startIndex + nodeCountPerLevel - 1;
            while (startIndex < endIndex && endIndex < nodes.size()) {
                if (nodes.get(startIndex)!=nodes.get(endIndex)) {
                    return false;
                }
                startIndex ++;
                endIndex --;
            }

            nodeIndex = nodeIndex + nodeCountPerLevel;

            level++;
        }
        return true;
    }

    private void bfs(TreeNode node, Queue<TreeNode> queue, List<Integer> nodes) {
        if (node.left != null) {
            nodes.add(node.left.val);
            queue.add(node.left);
        } else {
            nodes.add(-1000);
        }
        if (node.right != null) {
            nodes.add(node.right.val);
            queue.add(node.right);
        } else {
            nodes.add(-1000);
        }
        if (!queue.isEmpty()) {
            TreeNode next = queue.remove();
            bfs(next, queue, nodes);
        }
    }
}

 class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}