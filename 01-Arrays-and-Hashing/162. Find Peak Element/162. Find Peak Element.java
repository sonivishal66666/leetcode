1class Solution {
2    public int findPeakElement(int[] nums) {
3        int left = 0, right = nums.length - 1;
4
5        while (left < right) {
6            int mid = left + (right - left) / 2;
7
8            if (nums[mid] < nums[mid + 1]) {
9                left = mid + 1;
10            } else {
11                right = mid;
12            }
13        }
14
15        return left;
16    }
17}