/*
首先遍历两个链表得到他们的长度，就能知道哪个链表比较长，以及长的链表比短的链表多几个结点。
在第二次遍历的时候，在较长的链表上先走若干步，接着再同时在两个链表上遍历，找到第一个相同的结点就是他们的第一个公共结点。
*/

class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        int length1 = 0, length2 = 0;

        for(ListNode node=pHead1; node!=null; node=node.next) {

            length1++;
        }

        for(ListNode node=pHead2; node!=null; node=node.next) {

            length2++;
        }

        ListNode node1 = pHead1, node2 = pHead2;

        if(length1 > length2) {

            for(int i=0; i<length1-length2; i++) {

                node1 = node1.next;
            }
        } else if(length2 > length1) {

            for(int i=0; i<length2-length1; i++) {

                node2 = node2.next;
            }
        }

        while (node1 != node2) {

            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }
}
