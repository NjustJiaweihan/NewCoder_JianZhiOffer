public class Solution {

    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) {

            return pHead;
        }

        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = pHead;

        //cur: 当前结点 pre: 前结点 reserve: 前前结点(辅助删除前结点)
        ListNode reserve = root, pre = pHead, cur = pHead.next;

        while (cur != null){

            if(cur.val == pre.val){

                //全找出来一起删
                while (cur.val == pre.val){
                    cur = cur.next;

                    if(cur == null){
                        reserve.next = null;
                        return root.next;
                    }
                }

                //此时cur指向第一个不同结点
                reserve.next = cur;
                pre = cur;
                cur = cur.next;

            } else {

                cur = cur.next;
                pre = pre.next;
                reserve = reserve.next;
            }
        }
        return root.next;
    }
}
