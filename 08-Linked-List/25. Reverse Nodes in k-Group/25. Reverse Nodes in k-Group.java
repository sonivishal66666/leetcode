1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode reverseKGroup(ListNode head, int k) {
13        ListNode dummy = new ListNode(0);
14        dummy.next = head;
15
16        ListNode prevGroup = dummy;
17
18        while (true) {
19            ListNode kth = prevGroup;
20            for (int i = 0; i < k && kth != null; i++) {
21                kth = kth.next;
22            }
23
24            if (kth == null) break;
25
26            ListNode groupNext = kth.next;
27            ListNode prev = groupNext;
28            ListNode curr = prevGroup.next;
29
30            while (curr != groupNext) {
31                ListNode temp = curr.next;
32                curr.next = prev;
33                prev = curr;
34                curr = temp;
35            }
36
37            ListNode temp = prevGroup.next;
38            prevGroup.next = kth;
39            prevGroup = temp;
40        }
41
42        return dummy.next;
43    }
44}