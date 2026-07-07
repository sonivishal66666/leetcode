1class Solution {
2    public boolean isSymmetric(TreeNode root) {
3        return isMirror(root.left, root.right);
4    }
5
6    private boolean isMirror(TreeNode left, TreeNode right) {
7        if (left == null && right == null)
8            return true;
9
10        if (left == null || right == null)
11            return false;
12
13        if (left.val != right.val)
14            return false;
15
16        return isMirror(left.left, right.right) &&
17               isMirror(left.right, right.left);
18    }
19}