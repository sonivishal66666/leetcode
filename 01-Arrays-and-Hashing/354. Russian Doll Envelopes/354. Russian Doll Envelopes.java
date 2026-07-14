1import java.util.*;
2
3class Solution {
4    public int maxEnvelopes(int[][] envelopes) {
5        Arrays.sort(envelopes, (a, b) -> {
6            if (a[0] == b[0]) return b[1] - a[1];
7            return a[0] - b[0];
8        });
9
10        int[] dp = new int[envelopes.length];
11        int len = 0;
12
13        for (int[] env : envelopes) {
14            int h = env[1];
15            int idx = Arrays.binarySearch(dp, 0, len, h);
16
17            if (idx < 0) idx = -(idx + 1);
18
19            dp[idx] = h;
20            if (idx == len) len++;
21        }
22
23        return len;
24    }
25}