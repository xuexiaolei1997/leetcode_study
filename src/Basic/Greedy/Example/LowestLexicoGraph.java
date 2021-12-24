package Basic.Greedy.Example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/20 15:20
 * 字符排序问题
 */
public class LowestLexicoGraph {
    public static String lowestString(String[] strs){
        if (strs==null||strs.length==0) return "";
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }

    }
}
