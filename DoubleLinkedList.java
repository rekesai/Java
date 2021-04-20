class Node{

    public int val;
    public Node prev;
    public Node next;
    public Node(int val){
        this.val = val;
    }
}

public class DoubleLinkedList {
    //傀儡节点
    public Node head = new Node(-1);
    public Node tail = new Node(-1);

    //展示链表
    public void display(){
        if(this.head.next == null){
            System.out.println("当前链表为空！");
            return;
        }
        Node cur = this.head.next;
        while(cur != this.tail){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int val){
        Node node = new Node(val);
        if(this.head.next == null){
            this.head.next = node;
            node.next = this.tail;
            this.tail.prev = node;
            node.prev = this.head;
        }
        else{
            node.prev = this.head;
            node.next = this.head.next;
            node.next.prev = node;
            this.head.next = node;
        }
    }

    //尾插法
    public void addLast(int val){
        Node node = new Node(val);
        if(this.tail.prev == null){
            this.head.next = node;
            node.next = this.tail;
            this.tail.prev = node;
            node.prev = this.head;
        }
        else{
            node.prev = this.tail.prev;
            node.next = this.tail;
            this.tail.prev = node;
            node.prev.next = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标（不是傀儡节点）
    public void addIndex(int index,int val){
        if(index < 0 || index > this.size()){
            System.out.println("当前index位置不合法！");
            return;
        }
        if(index == 0){
            addFirst(val);
            return;
        }
        if(index == this.size()){
            addLast(val);
            return;
        }
        Node cur = this.head.next;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        Node indexNode = new Node(val);
        indexNode.prev = cur.prev;
        indexNode.next = cur;
        cur.prev.next = indexNode;
        cur.prev = indexNode;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if(this.head.next == null){
            System.out.println("当前链表为空！");
            return false;
        }
        Node cur = this.head.next;
        while(cur != tail){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null){
            System.out.println("当前链表为空！");
            return;
        }
        Node cur = this.head.next;
        while(cur != tail){
            if(cur.val == key){
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            }
            cur = cur.next;
        }
        System.out.println("没有关键字为 " + key +" 的节点！");
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(this.head == null){
            System.out.println("当前链表为空！");
            return;
        }
        boolean flag = true;
        Node cur = this.head.next;
        while(cur != tail){
            if(cur.val == key){
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                flag = false;
            }
            cur = cur.next;
        }
        if(flag){
            System.out.println("没有关键字为 " + key +" 的节点！");
        }
    }

    //得到单链表的长度
    public int size(){
        if(this.head.next == null){
            System.out.println("当前链表为空！");
            return -1;
        }
        Node cur = this.head.next;
        int size = 0;
        while(cur != tail){
            size++;
            cur = cur.next;
        }
        return size;
    }

    //清空链表
    public void clear(){
        if(this.head.next == null){
            System.out.println("当前链表为空！");
            return;
        }
        Node cur = this.head;
        Node curNext = cur.next;
        while(cur != tail){
            cur.next = null;
            cur = curNext;
            curNext = cur.next;
        }
    }

}
