package com.example.code.al.one;

import com.example.code.al.one.node.ListNode;

import java.math.BigDecimal;

/**
 * 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * <p>
 * 输出：[7,0,8]
 * <p>
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * <p>
 * 输出：[0]
 * <p>
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * <p>
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内 0 <= Node.val <= 9
 * <p>
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author gdLiu
 */
public class AddTwoNumbers {

    /**
     * 方式1:转换成数字,然后相加
     * <p>
     * int存在长度不够问题,故采用BigDecimal
     * <p>
     * 效果不理想,在统计中属于垫底的操作
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return com.example.code.al.one.node.ListNode
     * @author gdLiu
     * @date 2022/3/19 9:20
     */
    public ListNode solution1(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        while (l1 != null) {
            sb1.insert(0, l1.val);
            l1 = l1.next;
        }
        StringBuilder sb2 = new StringBuilder();
        while (l2 != null) {
            sb2.insert(0, l2.val);
            l2 = l2.next;
        }
        BigDecimal b1 = new BigDecimal(sb1.toString());
        BigDecimal b2 = new BigDecimal(sb2.toString());
        BigDecimal b3 = b1.add(b2);
        String s3 = b3.toString();
        final String[] split = s3.split("");
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = split.length; i > 0; i--) {
            head.next = new ListNode(Integer.parseInt(split[i - 1]));
            head = head.next;
        }
        return cur.next;
    }

    /**
     * 方式2:递归
     * <p>
     * 这个方式比较好理解,效率高
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return com.example.code.al.one.node.ListNode
     * @author gdLiu
     * @date 2022/3/19 10:02
     */
    public ListNode solution2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int num = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + num;
            num = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (num > 0) {
            head.next = new ListNode(num);
        }
        return cur.next;
    }
}
