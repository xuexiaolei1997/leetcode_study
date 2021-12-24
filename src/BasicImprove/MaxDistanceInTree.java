package BasicImprove;

import javax.swing.*;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/12/4 22:24
 * 从二叉树的节点a出发，可以向上或者向下走，但沿途的节点只能经过一次，到达节点b时路
 * 径上的节点个数叫作a到b的距离，那么二叉树任何两个节点之间都有距离，求整棵树上的最
 * 大距离。
 */
public class MaxDistanceInTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int dis, int h) {
            maxDistance = dis;
            height = h;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(maxDistance, height);
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        h1.left = new Node(2);
        h1.right = new Node(3);
        h1.left.left = new Node(4);
        h1.left.right = new Node(5);
        h1.right.left = new Node(6);
        int a = maxDistance(h1);
        System.out.println(a);
    }

}
