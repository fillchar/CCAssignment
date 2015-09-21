package ch4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution01 {

    class GraphNode {
        public int val;
        public List<GraphNode> list;
        public GraphNode(int val) {
            this.val = val;
            this.list = new ArrayList<>();
        }
    }

    private boolean dfs(GraphNode node, GraphNode tar, Set<GraphNode> set) {
        if (node == null) return false;
        boolean ret = false;
        for (GraphNode n: node.list)
            if (!set.contains(n)) {
                set.add(n);
                ret = ret || dfs(n, tar, set);
            }
        return ret;
    }

    public boolean routeBetweenNodes(GraphNode start, GraphNode end) {
        Set<GraphNode> set = new HashSet<>();
        return dfs(start, end, set);
    }

}
