package 算法.递归.简单.合并两个有序链表;

public class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(val).append(" ");
        ListNode cur = next;
        while (cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }

        return sb.append("]").toString();
    }
}
