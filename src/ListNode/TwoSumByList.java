package ListNode;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoSumByList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sortedListNode1 = reverseList(l1);
        ListNode sortedListNode2 = reverseList(l2);
        int num1 = transferToInt(sortedListNode1);
        int num2 = transferToInt(sortedListNode2);
        int num3 = num1+num2;
        String str3 = String.valueOf(num3);
        char[] strChar = str3.toCharArray();

        for (int i = 0; i<strChar.length;i++){
            ListNode n = new ListNode(strChar[i]);
        }
        return null;
    }

    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return cur;
    }

    private int transferToInt(ListNode head){
        String num = "";
        while (head!=null){
            num  += head.val;
            head = head.next;
        }
        System.out.println(num);
        return Integer.getInteger(num);
    }
}
