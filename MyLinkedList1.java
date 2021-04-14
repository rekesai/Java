public class MyLinkedList1 {
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

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index == 0){
            this.addFirst(data);
        }
        else if(index == this.size()){
            this.addLast(data);
        }
        else{
            Node newNode = new Node(data);
            Node cur = this.head;
            Node curNext = this.head.next;
            for(int i = 0; i < index - 1; i++){
                cur = curNext;
                curNext = cur.next;
            }
            cur.next = newNode;
            newNode.next = curNext;
        }
    }

    //展示链表
    public void showList(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找是否包含关键字key是否在单链表当中
    //public boolean contains(int key);

    //查找关键字为key的节点
    /*public Node searchPrev(int key){
    }*/

    //删除第一次出现的关键字为key的节点
    public void remove(int key){
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }


    }

    //删除所有值为key的节点
    //public void removeAllKey(int key);


    //得到单链表的长度
    public int size(){
        int listSize = 0;
        Node cur = this.head;
        while(cur != null){
            cur = cur.next;
            listSize++;
        }
        return listSize;
    }

    //清空链表
    public void clear(){
        Node cur = this.head;
        while(cur != null){
            Node curNext = cur.next;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
    }

    //求链表中间节点，若链表节点数为偶数则返回中间靠右节点
    public Node middleNode(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
