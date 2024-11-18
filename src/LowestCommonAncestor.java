//time O(n)
//space O(n)
class LowestCommonAncestor {

//Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode node;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return node;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean findLeft = dfs(root.left, p, q);
        boolean findRight = dfs(root.right, p, q);
        boolean findRoot = (root.val == q.val || root.val == p.val);
        if ((findLeft && findRight) || (findLeft && findRoot) || (findRoot && findRight)) node = root;
        return findLeft || findRight || findRoot;
    }
}