1class Solution {
2    public int maxDepth(TreeNode root) {
3        if (root == null)
4            return 0;
5
6        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
7    }
8}