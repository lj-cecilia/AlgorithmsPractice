//time O(n)
//space O(n) recursion stack space is n in the worst case, if the tree is like a linkdelist
class EvaluateBooleanBinaryTree {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) return root.val != 0;
        boolean leftNode = evaluateTree(root.left);
        boolean rightNode = evaluateTree(root.right);
        return (root.val == 2)? (leftNode || rightNode) : (leftNode && rightNode);
    }
}