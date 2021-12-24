package Basic.BinaryTree.Example;

import Basic.BinaryTree.Node_;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 9:16
 * 找两个节点最小公共祖先
 */
public class FindLatestAncestorNode {
    public static Node_ findLatestAncestorNode(Node_ head, Node_ o1, Node_ o2) {
        if (head == null || head == o1 || head == o2) return head;
        Node_ left = findLatestAncestorNode(head.left, o1, o2);
        Node_ right = findLatestAncestorNode(head.right, o1, o2);
        if (left != null && right != null) return head;
        return left != null ? left : right;
    }
}
