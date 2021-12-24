package Basic.Graph;


import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 10:22
 */
public class Graph_ {
    public HashMap<Integer, Node_> nodes;
    public HashSet<Edge_> edges;
    public Graph_(){
        nodes = new HashMap<Integer, Node_>();
        edges = new HashSet<>();
    }
}
