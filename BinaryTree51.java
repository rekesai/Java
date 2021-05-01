import java.util.*;


class Node51{
    public int val;
    public Node51 left;
    public Node51 right;
    public Node51(char val){
        this.val = val;
    }
}
public class BinaryTree51 {
    public Node root;
    public void creatBinaryTree(){
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
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        this.root = A;
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
    }
    //非递归后序
    public void postOrderTraversal2(Node root){
        if(root == null) return;
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
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    public void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    public int size = 0;
    public void getSize(Node root){
        if(root == null){
            return;
        }
        size++;
        getSize(root.left);
        getSize(root.right);
    }
    public int getSize2(Node root){
        if(root == null){
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    public int leafSize = 0;
    public void getLeafSize(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }
    public int getLeafSize2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    public int getKthLevelSize(Node root, int k){

        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKthLevelSize(root.left, k-1)+getKthLevelSize(root.right, k-1);
    }

    public int getHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ?
                leftHeight+1 : rightHeight+1;
    }

    public Node find(Node root, char val){
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