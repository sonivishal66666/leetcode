1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> combinationSum(int[] candidates, int target) {
5        List<List<Integer>> result = new ArrayList<>();
6        backtrack(candidates, target, 0, new ArrayList<>(), result);
7        return result;
8    }
9
10    private void backtrack(int[] candidates, int target, int start,
11                           List<Integer> current, List<List<Integer>> result) {
12        if (target == 0) {
13            result.add(new ArrayList<>(current));
14            return;
15        }
16
17        if (target < 0) {
18            return;
19        }
20
21        for (int i = start; i < candidates.length; i++) {
22            current.add(candidates[i]);
23            backtrack(candidates, target - candidates[i], i, current, result);
24            current.remove(current.size() - 1);
25        }
26    }
27}