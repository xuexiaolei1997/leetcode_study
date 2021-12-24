package Basic.Graph.Example;

import Basic.Graph.Edge_;
import Basic.Graph.Graph_;
import Basic.Graph.Node_;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 16:19
 * Prim算法
 * 从随机节点出发，找权重最小的边往下走
 */
public class Prim {

    public static class EdgeComparator implements Comparator<Edge_> {

        @Override
        public int compare(Edge_ o1, Edge_ o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge_> primMST(Graph_ graph_) {
        PriorityQueue<Edge_> priorityQueue = new PriorityQueue<>();
        HashSet<Node_> set = new HashSet<>();
        Set<Edge_> result = new HashSet<>();
        for (Node_ node_ : graph_.nodes.values()) {
            if (!set.contains(node_)) {
                set.add(node_);
                for (Edge_ edge_ : node_.edges) {
                    priorityQueue.add(edge_);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge_ edge_ = priorityQueue.poll();
                    Node_ toNode = edge_.to;
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge_);
                        for (Edge_ nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
