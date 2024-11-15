//time O(n)
//space O(n) / O(log n)
class PathSumI {

//Definition for a binary tree node.
    public class TreeNode {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(TreeNode root, int current, int targetSum) {
        if (root == null) return false;
        current += root.val;
        //make sure it equates the sum and also is a leaf node
        if (current == targetSum && root.left == null && root.right == null) return true;
        else return (dfs(root.left, current, targetSum) || dfs(root.right, current, targetSum));
    }
}