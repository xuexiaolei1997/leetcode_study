package Basic.Greedy.Example;

import java.util.Stack;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/22 11:51
 * 栈逆序，不能申请额外的数据结构，只能使用递归函数
 */
public class ReverseStack {
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()) return;
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int f(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else{
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
    }
}
