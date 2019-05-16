class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {

        this.val = val;
    }
}

class Solution {

    public ListNode Merge(ListNode list1, ListNode list2) {
    
        if(list1 == null || list2 == null) {
            
            return list1 == null ? list2 : list1;
        }

        ListNode root = new ListNode(-1);

        ListNode cur = root;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;

            } else {

                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }

        }

        if (list1 == null) {

            cur.next = list2;
        }

        if (list2 == null) {

            cur.next = list1;
        }

        return root.next;

    }
}
