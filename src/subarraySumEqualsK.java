//time O(n^2)
//space O(n)
//brute force
//class subarraySumEqualsK {
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
//
//    public ListNode removeZeroSumSublists(ListNode head) {
//        ListNode temp = new ListNode(0);
//        temp.next = head;
//        ListNode start = temp;
//        while (start != null) {
//            int sum = 0;
//            ListNode end = start.next;
//            while (end != null) {
//                sum += end.val;
//                if (sum == 0) {
//                    start.next = end.next;
//                }
//                end = end.next;
//            }
//            start = start.next;
//        }
//        return temp.next;
//    }
//}

//time O(n)
//space O(n)
//optimized