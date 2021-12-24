package Basic.Greedy.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/22 14:59
 * 打印一个字符串的全部子序列，包括空字符
 */
public class PrintAllSubsequences {

    public static void printAllSubsequences(char[] chars, int i, String s) {
        if (i == chars.length) {
            System.out.println(s);
            return;
        }
        printAllSubsequences(chars, i + 1, s);
        printAllSubsequences(chars, i + 1, s + chars[i]);
    }

    public static void main(String[] args) {
        String str = "abc";
        printAllSubsequences(str.toCharArray(), 0, "");
    }
}
