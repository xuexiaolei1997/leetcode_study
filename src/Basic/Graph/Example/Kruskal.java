package Basic.Graph.Example;

import Basic.Graph.Node_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 16:19
 * Kruskal算法
 * 找出权重最小的边，判断加入后能否形成环，若能，则忽略，不能，则加入。
 */
public class Kruskal {
    public static class MySets {
        public HashMap<Node_, List<Node_>> setMap;

        public MySets(List<Node_> node_s) {
            for (Node_ cur : node_s) {
                List<Node_> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node_ from, Node_ to){
            List<Node_> fromSet = setMap.get(from);
            List<Node_> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node_ from, Node_ to){
            List<Node_> fromSet = setMap.get(from);
            List<Node_> toSet = setMap.get(to);
            for (Node_ toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

//    public static Set<Edge_> kruskalMST(Graph_ graph_){
//        MySets unionFind = new MySets();
//    }
}
