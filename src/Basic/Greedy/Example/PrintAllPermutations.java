package Basic.Greedy.Example;

import java.util.ArrayList;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/22 9:45
 * 打印一个字符串的全部排列
 */
public class PrintAllPermutations {

    public static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "aabb";
        ArrayList<String> res = new ArrayList<String>();
        process(s.toCharArray(), 0, res);
        for (String ss : res)
            System.out.println(ss);
    }
}
