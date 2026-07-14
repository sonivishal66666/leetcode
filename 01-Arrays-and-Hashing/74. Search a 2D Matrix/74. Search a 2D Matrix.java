1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5
6        int left = 0, right = m * n - 1;
7
8        while (left <= right) {
9            int mid = left + (right - left) / 2;
10
11            int row = mid / n;
12            int col = mid % n;
13
14            if (matrix[row][col] == target) {
15                return true;
16            } else if (matrix[row][col] < target) {
17                left = mid + 1;
18            } else {
19                right = mid - 1;
20            }
21        }
22
23        return false;
24    }
25}