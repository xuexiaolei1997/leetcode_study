package Basic.Graph;

import java.util.ArrayList;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 10:25
 */
public class Node_ {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node_> nexts;
    public ArrayList<Edge_> edges;

    public Node_(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
