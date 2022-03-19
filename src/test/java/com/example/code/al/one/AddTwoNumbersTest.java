package com.example.code.al.one;

import com.example.code.al.one.node.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class AddTwoNumbersTest {

    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(5);
    ListNode l5 = new ListNode(6);
    ListNode l6 = new ListNode(4);

    @Test
    void solution1() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        l1.next = l2;
        l1.next.next = l3;
        l4.next = l5;
        l4.next.next = l6;
        ListNode listNode = addTwoNumbers.solution1(l1, l4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    @Test
    void solution2() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        l1.next = l2;
        l1.next.next = l3;
        l4.next = l5;
        l4.next.next = l6;
        ListNode listNode = addTwoNumbers.solution2(l1, l4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}