package Basic.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 19:27
 * 宽度优先遍历
 */
public class TreeMaxWidth {
    public static void w(Node_ head) {
        if (head == null) return;
        Queue<Node_> queue = new LinkedList<>();
        queue.add(head);

        HashMap<Node_, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node_ cur = queue.poll();
            int curNodelLevel = levelMap.get(cur);

            if (curNodelLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }

            System.out.println(cur.value);
            if (cur.left != null) {
                levelMap.put(cur.left, curLevel + 1);
                queue.add(cur.left);
            }
            ;
            if (cur.right != null) {
                levelMap.put(cur.right, curLevel + 1);
                queue.add(cur.right);
            }
        }
    }
}
