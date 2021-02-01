package array;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * @author peter
 * date 2021/2/1 9:55
 */
public class Lesson_2 {


    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        while (true) {
            int flag = 0;
            if (l1 != null) {
                x.add(l1.val);
                l1 = l1.next;
            } else {
                ++flag;
            }
            if (l2 != null) {
                y.add(l2.val);
                l2 = l2.next;
            } else {
                ++flag;
            }
            if (flag == 2) break;
        }
        int s1 = x.size(), s2 = y.size();
        int i = Math.max(s1, s2);
        List<Integer> sum = new ArrayList<>(i + 1);
        int count = 0;
        for (int i1 = 0; i1 < i; i1++) {

            int x1 = 0, y1 = 0;
            if (i1 < s1) {
                x1 = x.get(i1);
            }
            if (i1 < s2) {
                y1 = y.get(i1);
            }
            int temp = x1 + y1 + count;
            if (temp >= 10) {
                sum.add(temp - 10);
                count = 1;
            } else {
                sum.add(temp);
                count = 0;
            }
        }
        if (count > 0) {
            sum.add(count);
        }
        ListNode next = null;
        for (int i1 = sum.size() - 1; i1 >= 0; i1--) {
            next = new ListNode(sum.get(i1), next);

        }
        return next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode next = null;
        List<Integer> sum = new ArrayList<>(32);
        int count = 0;
        while (l1 != null || l2 != null) {
            int x = 0, y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }
            int temp = x + y + count;
            if (temp >= 10) {
                sum.add(temp - 10);
                count = 1;
            } else {
                sum.add(temp);
                count = 0;
            }
        }
        if (count > 0) {
            sum.add(count);
        }
        System.out.println(sum);
        for (int i1 = sum.size() - 1; i1 >= 0; i1--) {
            next = new ListNode(sum.get(i1), next);

        }
        return next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int count = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0, y = l2 != null ? l2.val : 0;
            int temp = x + y + count;
            if (head == null) {
                head = tail = new ListNode(temp % 10);
            } else {
                tail.next = new ListNode(temp % 10);
                tail = tail.next;
            }
            count = temp / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (count > 0) {
            tail.next = new ListNode(count);
        }
        return head;
    }

    @Data
    class ListNode {
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
    }
}
