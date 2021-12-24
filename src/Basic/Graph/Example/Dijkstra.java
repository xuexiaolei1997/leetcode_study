package Basic.Graph.Example;

import Basic.Graph.Edge_;
import Basic.Graph.Node_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 18:51
 * Dijkstra算法：可以权重为负值，但是权重累加和不能为负
 */
public class Dijkstra {
    public static HashMap<Node_, Integer> dijkstra1(Node_ head) {
        HashMap<Node_, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node_> selectedNodes = new HashSet<>();
        Node_ minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge_ edge_ : minNode.edges) {
                Node_ toNode = edge_.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge_.weight);
                }
                distanceMap.put(edge_.to, Math.min(distanceMap.get(toNode), distance + edge_.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node_ getMinDistanceAndUnselectedNode(HashMap<Node_, Integer> distanceMap, HashSet<Node_> touchedNodes) {
        Node_ minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node_, Integer> entry : distanceMap.entrySet()) {
            Node_ node_ = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node_) && distance < minDistance) {
                minNode = node_;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
