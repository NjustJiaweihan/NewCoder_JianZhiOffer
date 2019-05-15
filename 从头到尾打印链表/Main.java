import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;

class ListNode {
    int val;

    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

//链表逆序

class Solution {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode == null) {
            return new ArrayList<Integer>();
        }

        ListNode prev = null, head = listNode, nextNode;

        while (head != null) {

            nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;

        }

        ArrayList<Integer> res = new ArrayList<>();

        for (ListNode node = prev; node != null; node = node.next) {

            res.add(node.val);
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<ListNode> listNodes = new ArrayList<>();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        Solution solution = new Solution();

        System.out.println(solution.printListFromTailToHead(l1));
    }
}
