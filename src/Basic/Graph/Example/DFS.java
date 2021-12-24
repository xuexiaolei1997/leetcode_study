package Basic.Graph.Example;

import Basic.Graph.Node_;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/16 15:58
 * 深度优先遍历
 */
public class DFS {
    public static void dfs(Node_ node_) {
        if (node_ == null) return;
        Stack<Node_> stack = new Stack<>();
        HashSet<Basic.Graph.Node_> hashSet = new HashSet<>();
        stack.push(node_);
        hashSet.add(node_);
        System.out.println(node_.value);

        while (!stack.isEmpty()) {
            Node_ cur = stack.pop();
            for (Node_ next : cur.nexts) {
                if (!hashSet.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    hashSet.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }

    }
}
