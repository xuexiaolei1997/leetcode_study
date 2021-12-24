package Basic.Graph.Example;

import Basic.Graph.Graph_;
import Basic.Graph.Node_;

import java.util.*;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 16:10
 * 拓扑排序
 */
public class TopologySort {
    public static List<Node_> sortedTopology(Graph_ graph_) {
        HashMap<Node_, Integer> inMap = new HashMap<>();
        Queue<Node_> zeroInQueue = new LinkedList<>();
        for (Node_ node_ : graph_.nodes.values()) {
            inMap.put(node_, node_.in);
            if (node_.in == 0) zeroInQueue.add(node_);
        }
        List<Node_> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node_ cur = zeroInQueue.poll();
            result.add(cur);
            for (Node_ node_ : cur.nexts) {
                inMap.put(node_, inMap.get(node_) - 1);
                if (inMap.get(node_) == 0) zeroInQueue.add(node_);
            }
        }
        return result;
    }
}
