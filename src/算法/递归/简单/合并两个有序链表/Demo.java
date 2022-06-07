package 算法.递归.简单.合并两个有序链表;

import util.TimeTool;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        TimeTool.check("合并两个有序链表", () -> {
            System.out.println("list1: " + list1);
            System.out.println("list2: " + list2);
            ListNode result = mergeTwoLists(list1, list2);
            System.out.println("执行结果为：" + result);
        });
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        System.out.println("==================");
        System.out.println("\tlist1: " + list1);
        System.out.println("\tlist2: " + list2);
        if (list1 == null) {
            // 递归出口，返回 list2
            return list2;
        }

        if (list2 == null) {
            // 递归出口，返回 list1
            return list1;
        }

        if (list1.val < list2.val) {
            // list1 当前值小于 list2
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // list2 当前值小于 list1
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
