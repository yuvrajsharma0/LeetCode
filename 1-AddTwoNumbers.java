class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;

        int carry = 0;

        while (l1 != null && l2 != null) {
            current.next = new ListNode();
            current = current.next;

            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            current.val = sum % 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            current.next = new ListNode();
            current = current.next;

            int sum = l1.val + carry;
            carry = sum / 10;
            current.val = sum % 10;

            l1 = l1.next;
        }

        while (l2 != null) {
            current.next = new ListNode();
            current = current.next;

            int sum = l2.val + carry;
            carry = sum / 10;
            current.val = sum % 10;


            l2 = l2.next;
        }

        if (carry != 0) {
            current.next = new ListNode();
            current = current.next;

            current.val = carry;
        }
        return result.next;
    }

public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;

        int carry = 0;

        while (l1 != null || l2 != null) {
            current.next = new ListNode();
            current = current.next;

            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;

            int sum = x + y + carry;
            carry = sum / 10;
            current.val = sum % 10;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        if (carry != 0) {
            current.next = new ListNode();
            current = current.next;

            current.val = carry;
        }

        return result.next;
    }
}

class ListNode {
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
