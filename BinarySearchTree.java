public class BinarySearchTree {
    public Node root;

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        preOrderTraversal(root.left);
        System.out.print(root.val+" ");
        preOrderTraversal(root.right);
    }
    public void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }


    public boolean search(int key) {
        if(root == null) {
            return false;
        }
        Node cur = root;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }else if(cur.val < key){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return false;
    }

    public void insert(int key) {
        Node node = new Node(key);
        if(root == null){
            root = node;
            return;
        }
        Node cur = root;
        Node prev = cur;
        while(cur != null){
            if(cur.val == key){
                return;
            }
            else if(cur.val < key){
                prev = cur;
                cur = cur.left;
            }
            else{
                prev = cur;
                cur = cur.right;
            }
        }
        if(prev.val < key){
            prev.right = node;
        }
        if(prev.val > key){
            prev.left = node;
        }
    }


    //删除节点
    public void removeNode(Node parent, Node root){

    }
    public void remove(int key){
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(cur.val == key){
                //删除
                removeNode(parent, root);
                return;
            }
            else if(cur.val < key){
                parent = cur;
                cur = cur.left;
            }
            else{
                parent = cur;
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {
        int[]  array = {5,3,4,1,7,8,2,6,0,9};

    }
}
