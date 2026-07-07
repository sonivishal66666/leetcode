1class Solution {
2    public int minDepth(TreeNode root) {
3        if (root == null)
4            return 0;
5
6        if (root.left == null)
7            return 1 + minDepth(root.right);
8
9        if (root.right == null)
10            return 1 + minDepth(root.left);
11
12        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
13    }
14}