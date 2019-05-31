/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

import java.util.ArrayList;
public class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if(pHead1 == null || pHead2 == null) {
            
            return null;
        }
        
        ArrayList<ListNode> resp = new ArrayList<>();
        
        for(ListNode node = pHead1; node!=null; node=node.next) {
            
            resp.add(node);
        }

        for(ListNode node = pHead2; node!=null; node=node.next) {

            if(resp.contains(node)) {
                
                return node;
            }
        }
        
        return null;
    }
}
