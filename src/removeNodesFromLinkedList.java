import java.util.Stack;

//time O(n)
//space O(n)
// Definition for singly-linked list.

class removeNodesFromLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNodes(ListNode head) {
        //two stacks
        //first stack stores all nodes
        //second stack to store desired nodes reversely
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        //result node for return, temp node for iteration
        ListNode result = new ListNode();
        ListNode temp = head;
        int max = Integer.MIN_VALUE;

        //s1 store all nodes
        while (temp != null) {
            s1.push(temp.val);
            temp = temp.next;
        }

        //another iteration
        temp = result;

        //if nodes in s1 greater than max, store in s2 and update max
        while (!s1.isEmpty()) {
            int value = s1.pop();
            if (value >= max) {
                max = value;
                s2.push(value);
            }
        }

        //give all nodes from s2 to list
        while (!s2.isEmpty()) {
            int value = s2.pop();
            temp.next = new ListNode(value);
            temp = temp.next;
        }
        return result.next;
    }
}