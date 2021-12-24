package Basic.LinkList.Example;

import Basic.LinkList.Node_;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 12:24
 * 针对两个有环链表，寻找其第一次交汇节点
 */
public class FindFirstIntersectNode {
    /**
     * 无环链表
     * @param head1
     * @param head2
     * @return
     */
    public static Node_ noloop(Node_ head1, Node_ head2) {
        if (head1 == null || head2 == null) return null;
        Node_ cur1 = head1;
        Node_ cur2 = head2;

        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) return null;
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 两个有环链表，返回第一个相交节点，不相交则返回null
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static Node_ bothLoop(Node_ head1, Node_ loop1, Node_ head2, Node_ loop2) {
        Node_ cur1 = null;
        Node_ cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;

            int n = 0;
            while (cur1.next != null) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != null) {
                n--;
                cur2 = cur2.next;
            }
            if (cur1 != cur2) return null;
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) return loop1;
                cur1 = cur1.next;
            }
            return null;
        }
    }

    /**
     * 链表若有环，返回第一个循环节点，否则返回空
     * @param head 头节点
     * @return 链表若有环，返回第一个循环节点，否则返回空
     */
    public static Node_ getLoopNode(Node_ head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        Node_ n1 = head.next;
        Node_ n2 = head.next.next;
        while (n1 != n2) {
            if (n1.next == null || n2.next.next == null) return null;
            n2 = n2.next.next;
            n1 = n1.next;
        }
        return n1;
    }


    public static Node_ getIntersectNode(Node_ head1, Node_ head2) {
        if (head1 == null || head2 == null) return null;
        Node_ loop1 = getLoopNode(head1);
        Node_ loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) return noloop(head1, head2);
        if (loop1 != null && loop2 != null) return bothLoop(head1, loop1, head2, loop2);
        return null;
    }
}
