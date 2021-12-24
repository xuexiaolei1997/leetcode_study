package Basic.BinaryTree.Example;

import Basic.BinaryTree.Node_;

import java.util.LinkedList;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 21:12
 * 是否完全二叉树
 */
public class CheckCBT {
    public static boolean isCBT(Node_ head) {
        if (head == null) return true;
        LinkedList<Node_> queue = new LinkedList<>();
        boolean isLeaf = false;
        Node_ l = null;
        Node_ r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((isLeaf && (l != null || r != null)) || (l == null && r != null)) return false;

            if (l != null) queue.add(l);
            if (r != null) queue.add(r);
            if (l == null || r == null) isLeaf = true;
        }
        return true;
    }
}
