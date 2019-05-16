class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {

        this.val = val;
    }
}

class Solution {

    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k < 0) {

            return null;
        }

        int length = 0;
        for (ListNode node = head; node != null; node = node.next) {

            length++;
        }
        if (k > length) {

            return null;
        }
        if (k == length) {

            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {

            fast = fast.next;
        }

        while (fast != null) {

            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        System.out.println(solution.FindKthToTail(l1, 2).val);


    }
}
