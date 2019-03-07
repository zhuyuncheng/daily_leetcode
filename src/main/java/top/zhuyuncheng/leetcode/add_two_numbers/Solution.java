package top.zhuyuncheng.leetcode.add_two_numbers;
/*
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class Solution {

    /*
     *  非递归的形式，每次相加两个节点，如果大于10, 则进位，在下次计算时加上进位值
     *  由于是"尾插法"，链表同时保存头尾节点，这样insert时间复杂度低
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;

            if (head == null) {
                last = head = new ListNode(sum);
            } else {
                last = last.next = new ListNode(sum);
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode head1 = new ListNode(1);
        // head1.next = new ListNode(8);
        // head1.next.next = new ListNode(3);
        System.out.println(head1);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        // head2.next.next = new ListNode(4);
        System.out.println(head2);

        Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(head1, head2));
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            ListNode node = this;
            while (node != null) {
                sb.append(node.val).append(" ");
                node = node.next;
            }
            return sb.toString();
        }
    }
}
