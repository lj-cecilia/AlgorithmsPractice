//time O(log n), average case is the height of the tree
//space O(log n)

class DeleteNodeInBinarySearchTree {
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
    public TreeNode deleteNode(TreeNode root, int key) {
        //root is null, can't find val
        if (root == null) return null;
        //root val is greater, search in left tree
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        //root val is smaller, search in right tree
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        //root val match key, perform deletion
        else {
            //is leaf node, set root to null
            if (root.left == null && root.right == null) {
                root = null;
            }
            //has no left tree, set root to right node
            else if (root.left == null) {
                root = root.right;
            }
            //has no right tree, set root to left node
            else if (root.right == null) {
                root = root.left;
            }
            //has both left and right tree, search in the right tree to find nextGreater val
            //set root val to the nextGreater val
            //delete the nextGreater node by calling this method
            else {
                //find the next greater val
                TreeNode rightNode = findNextGreater(root.right);
                root.val = rightNode.val;
                root.right = deleteNode(root.right, rightNode.val);
            }
        }
        return root;
    }
    //search in the left tree of a node to get the smallest val in this tree
    //this doesn't need to be a function, can also be a while loop in the main function
    public TreeNode findNextGreater(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}