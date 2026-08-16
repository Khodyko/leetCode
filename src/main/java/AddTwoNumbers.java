public class AddTwoNumbers {


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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode res = new ListNode();
        ListNode tmpNode = res;

        while (l1 != null || l2 != null || tmp != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum =val1+val2 + tmp;
            tmp = sum/10;
            tmpNode.next = new ListNode(sum%10);
            tmpNode=tmpNode.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return res.next;
    }


}
