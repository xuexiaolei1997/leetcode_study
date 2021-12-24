package Basic.BinaryTree.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 9:30
 */
public class PaperFolding {
    public static void paperFolding(int i, int N, boolean down) {
        if (i > N) return;
        paperFolding(i + 1, N, true);
        System.out.println(down ? i + " 凹" : i + " 凸");
        paperFolding(i + 1, N, false);
    }

    public static void main(String[] args) {
        paperFolding(1, 4, true);
    }
}
