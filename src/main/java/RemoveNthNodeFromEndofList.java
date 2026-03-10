public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode slow = head;
        ListNode slowPrev = head;
        ListNode fast = head;
        while (fast.next != null) {
            fast = fast.next;
            n = n - 1;
            if (n > 0) {
                continue;
            }
            slowPrev = slow;
            slow = slow.next;
        }
        if (slow == head) {
            head = head.next;
        } else {
            slowPrev.next = slow.next;
        }
        return head;
    }
}
