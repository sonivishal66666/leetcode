1import java.util.HashMap;
2
3class Solution {
4    public int[] twoSum(int[] nums, int target) {
5        HashMap<Integer, Integer> map = new HashMap<>(); 
6
7        for (int i = 0; i < nums.length; i++) {
8            int complement = target - nums[i];
9
10            if (map.containsKey(complement)) {
11                return new int[] { map.get(complement), i };
12            }
13
14            map.put(nums[i], i);
15        }
16
17        return new int[] {};
18    }
19}
20