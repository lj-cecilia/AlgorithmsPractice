// time Jan 10th, 2024
// time O(n) as we visit every node for once
// space O(n) for the recursion stack, height is O(logN) for average case and O(n) for worst case
class MaxAncestorDiff {
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
    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root.val, root.val, root);
        return result;
    }

    public void dfs(int min, int max, TreeNode node) {
        if (node == null) return;
        result = Math.max(result, Math.max(Math.abs(min - node.val), Math.abs(max - node.val)));
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        dfs(min, max, node.left);
        dfs(min, max, node.right);
    }
}
