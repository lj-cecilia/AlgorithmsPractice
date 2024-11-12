//time O(n)
//space O(n)
//visit every node and call stack for worst case scenario a linkedlist-like tree is height n
class CountGoodNodesInBinaryTree {
//    Definition for a binary tree node.
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

    int good = 0;
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        dfs(root, max);
        return good;
    }
    public void dfs(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            good++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}