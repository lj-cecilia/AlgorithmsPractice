//time O(n)
//space O(n)


import java.util.Stack;

class MaxTwinSumOfLinkedList {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        int result = Integer.MIN_VALUE;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        node = head;
        while (!stack.isEmpty()) {
            result = Math.max(result, stack.pop() + node.val);
            node = node.next;
        }
        return result;
    }
}