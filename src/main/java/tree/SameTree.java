package tree;

import com.sun.source.tree.Tree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        return same(p, q);
    }

    private boolean same(TreeNode a, TreeNode b) {
        if (a.val != b.val) {
            return false;
        } else if ((a.left != null && b.left == null) || (a.left == null && b.left != null) || (a.right != null && b.right == null) || (a.right == null && b.right != null)) {
            return false;
        } else if (a.left == null && b.left == null && a.right == null && b.right == null) {
            return true;
        } else {
            if (a.left != null && b.left != null) {
                 if (!same(a.left, b.left)) {
                     return false;
                 }
            }
            if (a.right != null && b.right != null ) {
                if (!same(a.right, b.right)) {
                    return false;
                }
            }
        }
        return true;
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
}
