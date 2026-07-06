1class Solution {
2    public int maxProductPath(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        long[][] max = new long[m][n];
5        long[][] min = new long[m][n];
6        
7        max[0][0] = grid[0][0];
8        min[0][0] = grid[0][0];
9        
10        // First column
11        for (int i = 1; i < m; i++) {
12            max[i][0] = max[i - 1][0] * grid[i][0];
13            min[i][0] = max[i][0];
14        }
15        
16        // First row
17        for (int j = 1; j < n; j++) {
18            max[0][j] = max[0][j - 1] * grid[0][j];
19            min[0][j] = max[0][j];
20        }
21        
22        for (int i = 1; i < m; i++) {
23            for (int j = 1; j < n; j++) {
24                long val = grid[i][j];
25                
26                long a = max[i - 1][j] * val;
27                long b = min[i - 1][j] * val;
28                long c = max[i][j - 1] * val;
29                long d = min[i][j - 1] * val;
30                
31                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
32                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
33            }
34        }
35        
36        long res = max[m - 1][n - 1];
37        int MOD = 1_000_000_007;
38        
39        if (res < 0) return -1;
40        return (int)(res % MOD);
41    }
42}