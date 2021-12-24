package Basic.Graph;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 10:27
 */
public class Edge_ {
    public int weight;
    public Node_ from;
    public Node_ to;

    public Edge_(int weight, Node_ from, Node_ to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
