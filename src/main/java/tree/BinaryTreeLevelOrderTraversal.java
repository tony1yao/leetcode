package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        bfs(queue, list);
        return list;
    }

    private void bfs(Queue<TreeNode> queue, List<List<Integer>> list) {
        int numOfCurrentLevel = 1;
        int numOfNextLevel = 0;
        List<Integer> subList = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            subList.add(node.val);
            numOfCurrentLevel--;
            if (node.left != null) {
                queue.add(node.left);
                numOfNextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                numOfNextLevel++;
            }
            if (numOfCurrentLevel == 0) {
                numOfCurrentLevel = numOfNextLevel;
                numOfNextLevel = 0;
                list.add(subList);
                subList = new ArrayList<>();
            }
        }

    }
}
