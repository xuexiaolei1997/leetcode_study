package Basic.BinaryTree.Example;

import Basic.BinaryTree.Node_;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 22:35
 * 是否满二叉树
 */
public class CheckFull {
    public static class Info {
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static boolean isFull(Node_ head) {
        if (head == null) return true;
        Info data = process(head);
        return data.nodes == (1 << data.height - 1);
    }

    public static Info process(Node_ head) {
        if (head == null) return new Info(0, 0);
        Info leftData = process(head.left);
        Info rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }

    public static void main(String[] args) {
        System.out.println(1 << 5);
    }
}
