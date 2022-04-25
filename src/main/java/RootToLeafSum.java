
/*
// A Binary Tree node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
public class RootToLeafSum {
    boolean hasPath = false;
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int S) {
        // Your code here
        dfs(root, 0, S);
        return hasPath;
    }

    private void dfs(Node node, int sum, int target) {
        if (!hasPath) {
            sum = sum + node.data;
            if (node.left != null) {
                dfs(node.left, sum, target);
            }

            if (node.right != null) {
                dfs(node.right, sum, target);
            }

            if (node.left == null && node.right == null) {
                if (sum == target) {
                    hasPath = true;
                    return;
                }
            }
        }
    }
}
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}



