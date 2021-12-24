package Basic.BinaryTree;

import java.util.Stack;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 14:14
 * 二叉树前中后序遍历，递归/非递归
 */
public class PreInPosTraversal {
    public static void traversal(Node_ head) {
        if (head == null) return;
        // pre
        System.out.println(head.value);
        traversal(head.left);
        // in
//        System.out.println(head.value);
        traversal(head.right);
        // post
//        System.out.println(head.value);
    }

    public static void preOrderUnRecur(Node_ head) {
        if (head != null) {
            Stack<Node_> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) stack.push(head.right);
                if (head.left != null) stack.push(head.left);
            }
        }
    }

    public static void postOrderUnRecur(Node_ head) {
        if (head != null) {
            Stack<Node_> stack = new Stack<>();
            Stack<Node_> saveStack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                saveStack.push(head);
                if (head.left != null) stack.push(head.left);
                if (head.right != null) stack.push(head.right);
            }
            while (!saveStack.isEmpty()) System.out.print(saveStack.pop().value + " ");

        }
    }

    public static void inOrderUnRecur(Node_ head) {
        if (head == null) return;
        Stack<Node_> stack = new Stack<>();
        stack.push(head);
        while (head.left != null) {
            stack.push(head.left);
            head = head.left;
        }
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value);
            if (head.right != null) {
                stack.push(head.right);
                head = head.right;
                while (head.left != null) {
                    stack.push(head.left);
                    head = head.left;
                }
            }
        }
    }

    public static void inOrderUnRecur2(Node_ head) {
        if (head != null) {
            Stack<Node_> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node_ head = new Node_(1);
        head.left = new Node_(2);
        head.right = new Node_(3);
        head.left.left = new Node_(4);
        head.left.right = new Node_(5);
        head.left.right.left = new Node_(6);
        head.left.right.left.left = new Node_(7);
        head.right.left = new Node_(8);
        head.right.right = new Node_(9);
        head.right.left.right = new Node_(10);
        head.right.left.right.left = new Node_(11);
        inOrderUnRecur(head);
    }
}
