//time O(n), two pass
//space O(1)

class DeleteTheMiddleNodeOfLinkedList {
//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < size/2 - 1; ++i) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}


//time O(n), one pass
//space O(1)

//class DeleteTheMiddleNodeOfLinkedList {
//    //Definition for singly-linked list.
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
//    public ListNode deleteMiddle(ListNode head) {
//        //if one element, delete the one element
//        //if null return null
//        if (head == null) return head;
//        ListNode prev = new ListNode(0);
//        prev.next = head;
//        ListNode fast = head;
//        //make slow the prev one so that it can delete the middle node
//        ListNode slow = prev;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return prev.next;
//    }
//}
