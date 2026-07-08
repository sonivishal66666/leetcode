1class Solution {
2    public int divide(int dividend, int divisor) {
3        if (dividend == Integer.MIN_VALUE && divisor == -1) {
4            return Integer.MAX_VALUE;
5        }
6
7        long dvd = Math.abs((long) dividend);
8        long dvs = Math.abs((long) divisor);
9        int result = 0;
10
11        while (dvd >= dvs) {
12            long temp = dvs;
13            int multiple = 1;
14
15            while (dvd >= (temp << 1)) {
16                temp <<= 1;
17                multiple <<= 1;
18            }
19
20            dvd -= temp;
21            result += multiple;
22        }
23
24        return ((dividend > 0) == (divisor > 0)) ? result : -result;
25    }
26}