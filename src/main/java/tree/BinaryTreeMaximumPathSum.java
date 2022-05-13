package tree;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode node) {
        int maxLeft = 0;
        int maxRight = 0;
        if (node.left != null) {
            maxLeft = maxSum(node.left);
        }
        if (node.right != null) {
            maxRight = maxSum(node.right);
        }

        int tempMax = node.val;
        if (maxLeft > 0) {
            tempMax += maxLeft;
        }
        if (maxRight > 0) {
            tempMax += maxRight;
        }
        maxSum = Math.max(maxSum, tempMax);

        if (maxRight < 0 && maxLeft < 0) {
            return node.val;
        } else {
            if (maxLeft > maxRight) {
                return node.val + maxLeft;
            } else {
                return node.val + maxRight;
            }
        }
    }
}
