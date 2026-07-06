1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        int n = grid.length, m = grid[0].length;
4        int size = n * m;
5        int MOD = 12345;
6
7        // Flatten grid
8        int[] arr = new int[size];
9        int idx = 0;
10        for (int[] row : grid) {
11            for (int val : row) {
12                arr[idx++] = val % MOD;
13            }
14        }
15
16        // Prefix product
17        int[] prefix = new int[size];
18        prefix[0] = 1;
19        for (int i = 1; i < size; i++) {
20            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD;
21        }
22
23        // Suffix product and result
24        int[] result = new int[size];
25        int suffix = 1;
26        for (int i = size - 1; i >= 0; i--) {
27            result[i] = (prefix[i] * suffix) % MOD;
28            suffix = (suffix * arr[i]) % MOD;
29        }
30
31        // Convert back to 2D
32        int[][] ans = new int[n][m];
33        idx = 0;
34        for (int i = 0; i < n; i++) {
35            for (int j = 0; j < m; j++) {
36                ans[i][j] = result[idx++];
37            }
38        }
39
40        return ans;
41    }
42}