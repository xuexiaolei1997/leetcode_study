package Basic.Greedy.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/21 16:04
 * 汉诺塔问题
 * 先把左侧除最下面的那一个移到中间，然后把左侧最下面的移动到右侧，再把中间所有的移动到右侧。递归
 */
public class Hanoi {
    public static void hanoi(int n) {
        if (n > 0) func(n, "左", "右", "中");
    }

    public static void func(int i, String start, String end, String other) {
        if (i == 1) {
            // 移动最上面的那一个
            System.out.println("Move 1 from " + start + " to " + end);
        } else {
            func(i-1, start, other, end);
            System.out.println("Move " + i + " from " + start + " to " + end);
            func(i-1, other, end, start);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
        // \u000d System.out.println("end");
    }
}
