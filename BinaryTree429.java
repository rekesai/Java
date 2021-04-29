/*class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char val){
        this.val = val;
    }
}*/
public class BinaryTree429 {
    public Node root;//根

    public void creatTree(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        this.root = A;
    }

    public void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val+"->");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val+"->");
        inOrderTraversal(root.right);
    }
    public void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val+"->");
    }

    //遍历思想求节点个数
    static int size = 0;
    void getSize(Node root){
        if(root == null){
            return;
        }
        size++;
        getSize(root.left);
        getSize(root.right);
    }

    //子问题思想求节点个数
    int getSize2(Node root){
        if(root == null){
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    //遍历思想求叶子结点
    static int leafSize = 0;
    void getLeafSize(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }

    //子问题思想求叶子结点
    int getLeafSize2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    //子问题思想求第K层节点个数
    int getKLevelSize(Node root, int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left, k-1)
                + getKLevelSize(root.right, k-1);
    }

    //获取二叉树高度
    int getHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ?
                leftHeight+1 : rightHeight+1;
    }

    //返回值为val的节点
    Node find(Node root, char val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        Node ret = find(root.left, val);
        if(ret != null){
            return ret;
        }
        ret = find(root.right, val);
        if(ret != null){
            return ret;
        }
        return null;
    }
}
