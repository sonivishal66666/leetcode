1class Solution {
2    public int romanToInt(String s) {
3        int ans = 0;
4
5        for (int i = 0; i < s.length(); i++) {
6            int curr = value(s.charAt(i));
7
8            if (i < s.length() - 1 && curr < value(s.charAt(i + 1))) {
9                ans -= curr;
10            } else {
11                ans += curr;
12            }
13        }
14
15        return ans;
16    }
17
18    private int value(char c) {
19        switch (c) {
20            case 'I': return 1;
21            case 'V': return 5;
22            case 'X': return 10;
23            case 'L': return 50;
24            case 'C': return 100;
25            case 'D': return 500;
26            case 'M': return 1000;
27        }
28        return 0;
29    }
30}