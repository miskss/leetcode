package array;

import java.util.*;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author peter
 * date 2021/2/4 16:24
 */
public class Lesson_17 {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode node = new ListNode();
        ListNode pre = node;
        List<ListNode> nodes = new ArrayList<>(lists.length);
        nodes.addAll(Arrays.asList(lists));
        while (true) {
            if (nodes.size() == 1) {
                pre.next = nodes.get(0);
                break;
            }
            //找出当前这一组的最小值
            int idx = 0;
            ListNode minNode = null;
            for (int i = 0; i < nodes.size(); i++) {
                ListNode node1 = nodes.get(i);
                if (node1 == null) continue;
                if (minNode == null || minNode.val > node1.val) {
                    minNode = node1;
                    idx = i;
                }
            }
            if (minNode == null) break;
            pre.next = minNode;
            pre = pre.next;
            nodes.remove(idx);
            if (minNode.next != null) {
                nodes.add(minNode.next);
            }
        }
        return node.next;
    }

    public static ListNode mergeKListsUsePriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode node = new ListNode();
        ListNode pre = node;
        PriorityQueue<ListNode> nodes = new PriorityQueue<>(lists.length, Comparator.comparing(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                nodes.offer(list);
            }
        }
        while (!nodes.isEmpty()) {
            ListNode poll = nodes.poll();
            pre = pre.next = poll;
            if (poll.next != null) {
                nodes.offer(poll.next);
            }
        }
        return node.next;
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * <p>
     * 示例 2：
     * 输入：head = []
     * 输出：[]
     * <p>
     * 示例 3：
     * 输入：head = [1]
     * 输出：[1]
     *  
     * 提示：
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     *  
     * <p>
     * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode node = new ListNode();
        ListNode pre = node;
        while (head != null) {
            //每次取自己和下一个值做比较
            ListNode next = head.next;
            if (next != null) {
                head.next = next.next;
                next.next = head;
            } else {
                next = head;
            }
            if (pre.next == null) {
                pre.next = next;
            } else {
                pre.next.next = next;
            }
            pre = next;
            head = head.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, new ListNode(5, new ListNode(9)));
        ListNode mergeKLists = swapPairs(node);
        while (mergeKLists != null) {
            System.out.println(mergeKLists.val + " -> ");
            mergeKLists = mergeKLists.next;
        }


    }

    private static class ListNode {
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
