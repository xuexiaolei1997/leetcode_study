package Basic.BinaryTree.Example;

import Basic.BinaryTree.Node_;

import java.util.Stack;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 20:50
 * 是否二叉搜索树
 */
public class CheckBST {
    public static int preValue = Integer.MIN_VALUE;

    public static boolean checkBST(Node_ head) {
        if (head == null) return true;
        boolean isLeftBST = checkBST(head.left);
        if (!isLeftBST) {
            return false;
        }
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }

    public static boolean checkBST2(Node_ head) {
        if (head != null) {
            int preValue = Integer.MIN_VALUE;
            Stack<Node_> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    if (head.value <= preValue) {
                        return false;
                    } else {
                        preValue = head.value;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }

    public static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnData process(Node_ head) {
        if (head == null) return null;
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        boolean isBST = true;
        int min = head.value;
        int max = head.value;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.min(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.min(max, rightData.max);
        }
        if (leftData != null && !leftData.isBST || leftData.max >= head.value) isBST = false;
        if (rightData != null && !rightData.isBST || rightData.max <= head.value) isBST = false;

        return new ReturnData(isBST, min, max);
    }
}
