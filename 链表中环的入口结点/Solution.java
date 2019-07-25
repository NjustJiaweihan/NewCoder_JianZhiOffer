public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return null;
        }

        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast != null){

            slow = slow.next;
            fast = fast.next.next;

            //此时是相遇点 不是环入口
            if(slow == fast){
                
                fast = pHead;
                while (fast != slow){
                    
                    fast = fast.next;
                    slow = slow.next;
                }
                //此时是环入口
                return slow;
            }
        }
        return null;
    }
}
