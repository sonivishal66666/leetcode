1class Solution {
2    public int search(int[] nums, int target) {
3        int left = 0, right = nums.length - 1;
4
5        while (left <= right) {
6            int mid = left + (right - left) / 2;
7
8            if (nums[mid] == target) {
9                return mid;
10            } else if (nums[mid] < target) {
11                left = mid + 1;
12            } else {
13                right = mid - 1;
14            }
15        }
16
17        return -1;
18    }
19}