class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {

        this.val = val;
    }
}

class Solution {

    public ListNode ReverseList(ListNode head) {

        ListNode pre = null, indexNode = head, nextNode = null;

        while (indexNode != null) {

            nextNode = indexNode.next;

            indexNode.next = pre;
            pre = indexNode;

            indexNode = nextNode;
        }

        return pre;
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

        ListNode res = solution.ReverseList(l1);

        ListNode index = res;

        while (index != null) {

            System.out.print(index.val + " ");
            index = index.next;

        }
    }
}
