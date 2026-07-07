1class Solution {
2    public TreeNode sortedArrayToBST(int[] nums) {
3        return build(nums, 0, nums.length - 1);
4    }
5
6    private TreeNode build(int[] nums, int left, int right) {
7        if (left > right)
8            return null;
9
10        int mid = left + (right - left) / 2;
11
12        TreeNode root = new TreeNode(nums[mid]);
13        root.left = build(nums, left, mid - 1);
14        root.right = build(nums, mid + 1, right);
15
16        return root;
17    }
18}