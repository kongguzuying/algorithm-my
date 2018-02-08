package com.lmtech.algorithm;

import org.junit.Test;

public class LinkedCommon {

    @Test
    public void testReverse() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        LinkedCommon obj = new LinkedCommon();
        Node result = obj.reverseList(n1);
        System.out.println(result);
    }

    private void printCommentPart(Node header1, Node header2) {
        if (header1 != null && header2 != null) {
            if (header1.value < header2.value) {
                header1 = header1.next;
            } else if (header2.value < header1.value) {
                header2 = header2.next;
            }
        }
    }

    private Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }
}

class Node {
    public int value;
    public Node next;
    public Node(int value) {
        this.value = value;
    }
}
