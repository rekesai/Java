public class BinaryTree54 {
    public NodeInt root;
    public void creatTree(){
        NodeInt A = new NodeInt(1);
        NodeInt B = new NodeInt(2);
        NodeInt C = new NodeInt(3);
        NodeInt D = new NodeInt(4);
        NodeInt E = new NodeInt(5);
        NodeInt F = new NodeInt(6);
        NodeInt G = new NodeInt(7);
        NodeInt H = new NodeInt(8);
        A.left = B;
        A.right = C;
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        this.root = A;
    }
    /*合并二叉树 需要节点的值是int
    给定两个二叉树，你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值
    否则不为 NULL 的节点将直接作为新二叉树的节点。
    */
    public NodeInt mergeTrees(NodeInt root1, NodeInt root2){
        //如果二者都空，返回空，如果2不为空，返回2
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        NodeInt newRoot = new NodeInt(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }
    public void preOrderTraversal(NodeInt root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

}
