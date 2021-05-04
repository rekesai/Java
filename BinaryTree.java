import java.util.*;

public class BinaryTree {
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

    //先序遍历二叉树
    public void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val+"->");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public List<Character> preOrderTraversal3(Node root){
        List<Character> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        list.add(root.val);
        List<Character> left = preOrderTraversal3(root.left);
        list.addAll(left);
        List<Character> right = preOrderTraversal3(root.right);
        list.addAll(right);
        return list;
    }

    //中序遍历二叉树
    public void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val+"->");
        inOrderTraversal(root.right);
    }

    //后序遍历二叉树
    public void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val+"->");
    }
    //非递归先中后序
    //将根节点入栈，谁出栈就依次将他的右孩子和左孩子放进栈中，完成先序
    public void preOrderTraversal2(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        //当栈中为空时跳出
        while(!stack.empty()) {
            //将根节点出栈并复制一份给cur
            Node cur = stack.pop();
            //输出出栈的节点的值
            System.out.print(cur.val+" ");
            //当右节点不为空就入栈
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    //非递归中序，建立循环，令cur走到最左边，过程中都入栈，然后出出栈，再令cur等于右孩子再左走达成中序
    public void inOrderTraversal2(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
                root = st.pop();
                System.out.print(root.val+" ");
                root = root.right;
            }
        }
    }
    //非递归后序
    public void postOrderTraversal2(Node root){
        if(root == null) return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.empty()) {
            root = st1.pop();
            st2.push(root);
            if (root.left != null) {
                st1.push(root.left);
            }
            if (root.right != null) {
                st1.push(root.right);
            }
        }
        while(!st2.empty()) {
            System.out.print(st2.pop().val+" ");
        }
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
    //子问题思想就是左孩子右孩子思想，将树分成两个子树，若是求第K层节点，则把左树的K层节点和右树的加起来就是了，往简单了想
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

    //比较两个二叉树是否相同
    public boolean isSameTree(Node p, Node q){
        if(p == null && q == null){
            return true;
        }
        if(p == null && q != null){
            return false;
        }
        if(p != null && q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
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

}