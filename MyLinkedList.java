
class Node{
    public int val;
    public Node next;

    public Node(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    public Node head = null;

    //穷举的方式创建链表
    /*public void creatList(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        this.head = node1;
    }*/

    //头插法
    public void addFirst(int val){
        Node node = new Node(val);
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int val){
        Node node = new Node(val);
        if(this.head == null){
            this.head = node;
        }
        else{
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void showList(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

}
