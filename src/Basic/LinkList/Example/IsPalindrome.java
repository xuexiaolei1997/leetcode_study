package Basic.LinkList.Example;

import java.util.Stack;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/14 16:49
 * 是否回文问题
 */
public class IsPalindrome {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // n extra space
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) return false;
            head = head.next;
        }
        return true;
    }

    // n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) return true;
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) return false;
            head = head.next;
        }
        return true;
    }

    // O(1) extra space
    public static boolean isPanlindrome3(Node head) {
        if (head == null || head.next == null) return true;
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;  // n1 -> mid
            n2 = n2.next.next;  // n2 -> end
        }

        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        // right part convert
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

}
