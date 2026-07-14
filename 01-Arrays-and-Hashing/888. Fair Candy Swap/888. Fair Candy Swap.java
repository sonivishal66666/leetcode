1class Solution {
2    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
3        int sumA = 0, sumB = 0;
4
5        for (int x : aliceSizes) sumA += x;
6        for (int x : bobSizes) sumB += x;
7
8        int diff = (sumA - sumB) / 2;
9
10        HashSet<Integer> set = new HashSet<>();
11        for (int x : bobSizes) {
12            set.add(x);
13        }
14
15        for (int a : aliceSizes) {
16            int b = a - diff;
17            if (set.contains(b)) {
18                return new int[]{a, b};
19            }
20        }
21
22        return new int[]{};
23    }
24}