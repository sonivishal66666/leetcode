1class Solution {
2    public String countAndSay(int n) {
3        String result = 1;
4
5        for (int i = 2; i <= n; i++) {
6            StringBuilder sb = new StringBuilder();
7            int count = 1;
8
9            for (int j = 1; j <= result.length(); j++) {
10                if (j < result.length() && result.charAt(j) == result.charAt(j - 1)) {
11                    count++;
12                } else {
13                    sb.append(count);
14                    sb.append(result.charAt(j - 1));
15                    count = 1;
16                }
17            }
18
19            result = sb.toString();
20        }
21
22        return result;
23    }
24}