import java.util.HashMap;

//思路不难 指针迷人眼

class RandomListNode {

    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {

        this.label = label;
    }
}

class Solution {

    public RandomListNode Clone(RandomListNode pHead) {

        if(pHead == null) {

            return null;
        }

        RandomListNode cHead = new RandomListNode(pHead.label);
        //N->N'
        RandomListNode cNode = cHead;
        RandomListNode pNode = pHead.next;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        map.put(pHead, cHead);

        //复制简单链表
        while (pNode != null) {

            cNode.next = new RandomListNode(pNode.label);
            map.put(pNode, cNode.next);

            cNode = cNode.next;
            pNode = pNode.next;
        }

        cNode = cHead;
        pNode = pHead;

        //设置random
        while (pNode!=null) {

            //N->S => N'->S' 需要S->S'
            cNode.random = map.get(pNode.random);

            cNode = cNode.next;
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
        System.out.println(qhead.label);
        System.out.println(qhead.next.label);
        System.out.println(qhead.next.next.label);
    }
}
