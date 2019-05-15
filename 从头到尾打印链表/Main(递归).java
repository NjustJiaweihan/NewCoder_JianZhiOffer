import java.util.ArrayList;

//递归

class ListNode {
    int val;

    ListNode next = null;

    ListNode(int val) {
        this.val = val;
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

class Solution
{
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){

        if(listNode == null)
        {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> res = new ArrayList<>();

        reverse(res, listNode);

        return res;
    }

    private void reverse(ArrayList<Integer> res, ListNode listNode)
    {
        if(listNode.next != null)
        {
            reverse(res, listNode.next);
        }

        res.add(listNode.val);
    }
}
