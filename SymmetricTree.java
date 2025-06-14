//class Node{
//    int data;
//    Node left;
//    Node right;
//    Node(int data){
//        this.data = data;
//        left=null;
//        right=null;
//    }
//}

class SymmetricTree {
    public boolean isSymmetric(Node root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.data == b.data && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
