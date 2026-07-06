1class Solution {
2    public ListNode deleteDuplicates(ListNode head) {
3        ListNode current = head;
4
5        while (current != null && current.next != null) {
6            if (current.val == current.next.val) {
7                current.next = current.next.next;
8            } else {
9                current = current.next;
10            }
11        }
12
13        return head;
14    }
15}