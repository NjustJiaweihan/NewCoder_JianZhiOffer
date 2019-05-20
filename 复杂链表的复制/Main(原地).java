//再也不写这题 头大
class RandomListNode {

    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {

        this.label = label;
    }
}

class Solution {

    //原地算法 时间O(n) 空间O(1)

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {

            return null;
        }
        RandomListNode pNode = pHead;

        //STEP1: A->A'->B->B'->C->C'...
        while (pNode != null) {

            RandomListNode cNode = new RandomListNode(pNode.label);
            cNode.next = pNode.next;

            pNode.next = cNode;
            pNode = cNode.next;
        }

        //STEP2:
        //|----------|
        //A -> A'....B -> B'....
        //     |----------|
        pNode = pHead;
        while (pNode != null) {

            pNode.next.random = pNode.random == null ? null : pNode.random.next;
            pNode = pNode.next.next;
        }

        //STEP3: 拆分成两个链表 奇数位的是复制的链表

        //A->A'->B->B'...
        //    变成
        //|------|
        //A  A'->B->B'...
        pNode = pHead;
        RandomListNode cNode;
        RandomListNode cHead;

        cHead = cNode = pNode.next;
        pNode.next = cNode.next;
        pNode = pNode.next;

        while (pNode != null) {

            cNode.next = pNode.next;
            cNode = cNode.next;
            pNode.next = cNode.next;
            pNode = pNode.next;
        }

        return cHead;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        RandomListNode phead = new RandomListNode(1);
        phead.next = new RandomListNode(2);
        phead.next.next = new RandomListNode(3);

        phead.random = phead.next.next;
        phead.next.random = phead;
        phead.next.next.random = phead;

        RandomListNode qhead = solution.Clone(phead);
        while (qhead != null) {

            System.out.println(qhead.label);
            qhead = qhead.next;
        }
    }
}
