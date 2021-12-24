package Basic.Greedy.Example;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/20 16:12
 * 切金条问题：哈夫曼树
 */
public class LessMoneySplitGold {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
}
