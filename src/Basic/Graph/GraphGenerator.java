package Basic.Graph;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 11:02
 */
public class GraphGenerator {
    public static Graph_ createGraph(Integer[][] matrix){
        Graph_ graph_ = new Graph_();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph_.nodes.containsKey(from)) graph_.nodes.put(from, new Node_(from));
            if (!graph_.nodes.containsKey(to)) graph_.nodes.put(to, new Node_(to));
            Node_ fromNode = graph_.nodes.get(from);
            Node_ toNode = graph_.nodes.get(to);
            Edge_ edge_ = new Edge_(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge_);
            graph_.edges.add(edge_);
        }
        return graph_;
    }
}
