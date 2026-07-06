1import java.util.*;
2
3class Solution {
4    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
5        // business line priority
6        Map<String, Integer> order = new HashMap<>();
7        order.put(electronics, 0);
8        order.put(grocery, 1);
9        order.put(pharmacy, 2);
10        order.put(restaurant, 3);
11
12        List<String[]> valid = new ArrayList<>();
13
14        for (int i = 0; i < code.length; i++) {
15            if (!isActive[i]) continue;
16
17            String c = code[i];
18            String b = businessLine[i];
19
20            // check code validity
21            if (c == null || c.isEmpty()) continue;
22            if (!c.matches([a-zA-Z0-9_]+)) continue;
23
24            // check business line validity
25            if (!order.containsKey(b)) continue;
26
27            valid.add(new String[]{b, c});
28        }
29
30        // sort by businessLine order, then lexicographically by code
31        valid.sort((a, b) -> {
32            int cmp = Integer.compare(order.get(a[0]), order.get(b[0]));
33            if (cmp != 0) return cmp;
34            return a[1].compareTo(b[1]);
35        });
36
37        List<String> result = new ArrayList<>();
38        for (String[] v : valid) {
39            result.add(v[1]);
40        }
41
42        return result;
43    }
44}
45