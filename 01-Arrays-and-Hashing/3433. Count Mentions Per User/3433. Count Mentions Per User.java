1import java.util.List;
2import java.util.ArrayList;
3import java.util.Collections;
4import java.util.Comparator;
5import java.util.Arrays;
6
7public class Solution {
8    // LeetCode-style signature: numberOfUsers, events as List<List<String>>
9    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
10        int n = events.size();
11        List<Integer> idx = new ArrayList<>();
12        for (int i = 0; i < n; i++) idx.add(i);
13
14        // sort by timestamp ascending; tie-breaker: OFFLINE before MESSAGE
15        Collections.sort(idx, new Comparator<Integer>() {
16            public int compare(Integer a, Integer b) {
17                int ta = Integer.parseInt(events.get(a).get(1));
18                int tb = Integer.parseInt(events.get(b).get(1));
19                if (ta != tb) return Integer.compare(ta, tb);
20                String typeA = events.get(a).get(0);
21                String typeB = events.get(b).get(0);
22                if (typeA.equals(typeB)) return 0;
23                if (typeA.equals(OFFLINE) && typeB.equals(MESSAGE)) return -1;
24                if (typeA.equals(MESSAGE) && typeB.equals(OFFLINE)) return 1;
25                return 0;
26            }
27        });
28
29        int[] mentions = new int[numberOfUsers];
30        boolean[] online = new boolean[numberOfUsers];
31        Arrays.fill(online, true); // initially all online
32        int[] offlineUntil = new int[numberOfUsers]; // time when user becomes online again
33        Arrays.fill(offlineUntil, -1); // -1 means not currently offline
34
35        for (int idIndex : idx) {
36            List<String> ev = events.get(idIndex);
37            String type = ev.get(0);
38            int timestamp = Integer.parseInt(ev.get(1));
39
40            // Reactivate any users whose offlineUntil <= timestamp
41            for (int u = 0; u < numberOfUsers; u++) {
42                if (!online[u] && offlineUntil[u] <= timestamp) {
43                    online[u] = true;
44                    offlineUntil[u] = -1;
45                }
46            }
47
48            if (type.equals(OFFLINE)) {
49                int user = Integer.parseInt(ev.get(2));
50                // problem guarantees user is online when OFFLINE occurs
51                online[user] = false;
52                offlineUntil[user] = timestamp + 60; // becomes online at timestamp + 60
53            } else if (type.equals(MESSAGE)) {
54                String mentionsStr = ev.get(2).trim();
55                if (mentionsStr.equals(ALL)) {
56                    for (int u = 0; u < numberOfUsers; u++) mentions[u]++;
57                } else if (mentionsStr.equals(HERE)) {
58                    for (int u = 0; u < numberOfUsers; u++) if (online[u]) mentions[u]++;
59                } else {
60                    String[] tokens = mentionsStr.split(\\s+);
61                    for (String tok : tokens) {
62                        if (tok.startsWith(id)) {
63                            int user = Integer.parseInt(tok.substring(2));
64                            mentions[user]++;
65                        }
66                    }
67                }
68            }
69        }
70
71        return mentions;
72    }
73
74    // Optional quick test harness (if running standalone)
75    public static void main(String[] args) {
76        Solution s = new Solution();
77
78        List<List<String>> ev1 = new ArrayList<>();
79        ev1.add(Arrays.asList(MESSAGE,10,id1 id0));
80        ev1.add(Arrays.asList(OFFLINE,11,0));
81        ev1.add(Arrays.asList(MESSAGE,71,HERE));
82        System.out.println(Arrays.toString(s.countMentions(2, ev1))); // [2,2]
83
84        List<List<String>> ev2 = new ArrayList<>();
85        ev2.add(Arrays.asList(MESSAGE,10,id1 id0));
86        ev2.add(Arrays.asList(OFFLINE,11,0));
87        ev2.add(Arrays.asList(MESSAGE,12,ALL));
88        System.out.println(Arrays.toString(s.countMentions(2, ev2))); // [2,2]
89
90        List<List<String>> ev3 = new ArrayList<>();
91        ev3.add(Arrays.asList(OFFLINE,10,0));
92        ev3.add(Arrays.asList(MESSAGE,12,HERE));
93        System.out.println(Arrays.toString(s.countMentions(2, ev3))); // [0,1]
94    }
95}
96