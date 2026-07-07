1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        return new int[]{findFirst(nums, target), findLast(nums, target)};
4    }
5
6    private int findFirst(int[] nums, int target) {
7        int left = 0, right = nums.length - 1;
8        int ans = -1;
9
10        while (left <= right) {
11            int mid = left + (right - left) / 2;
12
13            if (nums[mid] == target) {
14                ans = mid;
15                right = mid - 1;
16            } else if (nums[mid] < target) {
17                left = mid + 1;
18            } else {
19                right = mid - 1;
20            }
21        }
22
23        return ans;
24    }
25
26    private int findLast(int[] nums, int target) {
27        int left = 0, right = nums.length - 1;
28        int ans = -1;
29
30        while (left <= right) {
31            int mid = left + (right - left) / 2;
32
33            if (nums[mid] == target) {
34                ans = mid;
35                left = mid + 1;
36            } else if (nums[mid] < target) {
37                left = mid + 1;
38            } else {
39                right = mid - 1;
40            }
41        }
42
43        return ans;
44    }
45}