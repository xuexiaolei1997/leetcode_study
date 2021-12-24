package Basic.BinaryTree.Example;

import Basic.BinaryTree.Node_;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 22:07
 * 是否平衡二叉树
 */
public class IsBalancedTree {
    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int h) {
            this.isBalanced = isB;
            this.height = h;
        }
    }

    public static boolean isBalancedTree(Node_ head) {
        return process(head).isBalanced;
    }

    public static ReturnType process(Node_ head) {
        if (head == null) return new ReturnType(true, 0);

        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }
}
