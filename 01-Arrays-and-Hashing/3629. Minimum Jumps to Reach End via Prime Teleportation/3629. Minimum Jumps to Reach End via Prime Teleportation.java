1import java.util.*;
2
3class Solution {
4
5    static final int MAX = 1000000;
6    static int[] spf = new int[MAX + 1];
7
8    static {
9        for (int i = 0; i <= MAX; i++) spf[i] = i;
10
11        for (int i = 2; i * i <= MAX; i++) {
12            if (spf[i] == i) {
13                for (int j = i * i; j <= MAX; j += i) {
14                    if (spf[j] == j)
15                        spf[j] = i;
16                }
17            }
18        }
19    }
20
21    public int minJumps(int[] nums) {
22
23        int n = nums.length;
24
25        if (n == 1) return 0;
26
27        // ONLY store indices for PRIME VALUES
28        // this is the critical optimization
29        HashMap<Integer, ArrayList<Integer>> primeToIndices = new HashMap<>();
30
31        for (int i = 0; i < n; i++) {
32
33            int x = nums[i];
34
35            // if nums[i] itself is prime
36            if (x > 1 && spf[x] == x) {
37                primeToIndices
38                    .computeIfAbsent(x, k -> new ArrayList<>())
39                    .add(i);
40            }
41        }
42
43        // build teleport lists ONLY for primes that exist in array
44        HashMap<Integer, ArrayList<Integer>> teleport = new HashMap<>();
45
46        for (int p : primeToIndices.keySet()) {
47            teleport.put(p, new ArrayList<>());
48        }
49
50        // factor every number once
51        for (int i = 0; i < n; i++) {
52
53            int x = nums[i];
54
55            while (x > 1) {
56
57                int p = spf[x];
58
59                if (teleport.containsKey(p)) {
60                    teleport.get(p).add(i);
61                }
62
63                while (x % p == 0)
64                    x /= p;
65            }
66        }
67
68        boolean[] vis = new boolean[n];
69
70        int[] q = new int[n];
71        int front = 0, back = 0;
72
73        q[back++] = 0;
74        vis[0] = true;
75
76        int steps = 0;
77
78        while (front < back) {
79
80            int size = back - front;
81
82            while (size-- > 0) {
83
84                int i = q[front++];
85
86                if (i == n - 1)
87                    return steps;
88
89                // left
90                if (i > 0 && !vis[i - 1]) {
91                    vis[i - 1] = true;
92                    q[back++] = i - 1;
93                }
94
95                // right
96                if (i + 1 < n && !vis[i + 1]) {
97                    vis[i + 1] = true;
98                    q[back++] = i + 1;
99                }
100
101                int val = nums[i];
102
103                // teleport only if current value is prime
104                if (val > 1 && spf[val] == val) {
105
106                    ArrayList<Integer> list = teleport.get(val);
107
108                    if (list != null) {
109
110                        for (int idx : list) {
111
112                            if (!vis[idx]) {
113                                vis[idx] = true;
114                                q[back++] = idx;
115                            }
116                        }
117
118                        // VERY IMPORTANT
119                        teleport.remove(val);
120                    }
121                }
122            }
123
124            steps++;
125        }
126
127        return -1;
128    }
129}