package tree;

public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode node, TreeNode subRoot) {
        if (isTreeIdentical(node, subRoot)) {
            return true;
        } else {
            boolean isSub;
            if (node.left != null) {
                isSub = dfs(node.left, subRoot);
                if (isSub) {
                    return true;
                }
            }
            if (node.right != null) {
                isSub = dfs(node.right, subRoot);
                if (isSub) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean isTreeIdentical(TreeNode node, TreeNode subRoot) {
        if (!isNodeIdentical(node, subRoot)) {
            return false;
        } else {
            if(node.left != null && !isTreeIdentical(node.left, subRoot.left)) {
                return false;
            }
            if (node.right != null && !isTreeIdentical(node.right, subRoot.right)) {
                return false;
            }
            return true;
        }
    }

    private boolean isNodeIdentical(TreeNode node, TreeNode anotherNode) {
        if (node == null && anotherNode == null) {
            return true;
        } else if (node != null && anotherNode == null) {
            return false;
        } else if (node == null && anotherNode != null) {
            return false;
        } else {
            return node.val == anotherNode.val && isNodeIdentical(node.left, anotherNode.left) && isNodeIdentical(node.right, anotherNode.right);
        }
    }
}
