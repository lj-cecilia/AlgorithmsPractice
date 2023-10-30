//O((logn)^2) instead of O(n) time complexity
class getNumberOfNodes {
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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        //2<<b is to do 2^b because for every position we shift 2 to its left
        //we double it: 10 -> 100 is 2 -> 4
        if (left == right) return (2 << left) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            root = root.left;
            count++;
        }
        return count;
    }
    public int getRightHeight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            root = root.right;
            count++;
        }
        return count;
    }
}