import java.util.*;
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}
class BSTDeadEnd {
    public boolean isDeadEnd(Node root) {
        Set<Integer> nodes = new HashSet<>();
        Set<Integer> leaves = new HashSet<>();
        nodes.add(0);
        collectNodes(root, nodes, leaves);
        for (int leaf : leaves) {
            if (nodes.contains(leaf - 1) && nodes.contains(leaf + 1)) {
                return true;
            }
        }
        return false;
    }
    private void collectNodes(Node node, Set<Integer> nodes, Set<Integer> leaves) {
        if (node == null) return;
        nodes.add(node.data);
        if (node.left == null && node.right == null) {
            leaves.add(node.data);
        }
        collectNodes(node.left, nodes, leaves);
        collectNodes(node.right, nodes, leaves);
    }
}
