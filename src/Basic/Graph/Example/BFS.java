package Basic.Graph.Example;

import Basic.Graph.Node_;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 14:50
 * 宽度优先遍历
 */
public class BFS {
    public static void bfs(Node_ node_) {
        if (node_ == null) return;
        Queue<Node_> queue = new LinkedList<>();
        HashSet<Node_> hashSet = new HashSet<>();
        queue.add(node_);
        hashSet.add(node_);
        while (!queue.isEmpty()) {
            Node_ cur = queue.poll();
            for (Node_ next : cur.nexts) {
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    queue.add(next);
                }
            }
        }
    }

}
