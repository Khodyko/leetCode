public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode left=head;
        ListNode right=head.next;
        ListNode tmp3=head.next;

        while(tmp3!=null){
            tmp3=right.next;
            right.next=left;
            left=right;
            right=tmp3;
        }
        head.next=null;
        return left;
    }


      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
