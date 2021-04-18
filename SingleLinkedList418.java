class Node418{
    public int val;
    public Node418 next;
    public Node418(int val){
        this.val = val;
    }
}
public class SingleLinkedList418 {
    public Node head = null;

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
        if(index < 0 || index > this.size()){
            System.out.println("当前index位置不合法！");
            return;
        }
        if(index == 0){
            this.addFirst(data);
        }
        else if(index == this.size()){
            this.addLast(data);
        }
        else{
            Node newNode = new Node(data);
            Node cur = this.head;
            for(int i = 0; i < index - 1; i++){
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
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
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //查找关键字为key的节点
    public Node searchKey(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //查找关键字为key的节点的前驱节点
    public Node searchPrev(int key){
        Node cur = this.head;
        while(cur.next == null){
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现的关键字为key的节点
    public void remove(int key){
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有要删除的这个节点！");
            return;
        }
        Node del = prev.next;
        prev.next = del.next;
    }
    public void remove1(int key){
        //判断头结点是否为要删除的结点
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
        Node cur = this.head.next;
        Node prev = this.head;
        while(cur != null){
            if(cur.val == key){
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        System.out.println("您输入的"+key+"不存在！");
    }


    //删除所有值为key的节点
    //先不管头结点，令cur为节点.next，开始遍历，如果cur.next.val不为key，继续遍历
    //如果等于则只改cur，不改prev，应分别做事件，最后在判断头结点是否为key
    public void removeAllKey(int key){
        if(this.head == null){
            System.out.println("当前顺序表为空！");
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while(cur != null){
            if(cur.val == key){
                prev.next = cur.next;
                cur = cur.next;
            }
            else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.val == key){
            this.head = this.head.next;
        }
    }


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

    //逆序链表，以头插法逆序，从第二个节点开始将其插到前面，重置this.head和cur
    public Node reserveList(){
        if(this.head == null || this.head.next == null){
            return this.head;
        }
        Node cur = this.head;
        Node curNext = this.head.next;
        this.head.next = null;
        cur = curNext;
        while(cur != null){
            curNext = cur.next;
            cur.next = this.head;
            this.head = cur;
            cur = curNext;
        }
        return this.head;
    }

    //给定一个链表判断是否有环
    public boolean isCycle(){
        if(this.head == null || this.head.next == null){
            return false;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //返回倒数第K个节点
    //定义快节点和慢节点，让快节点先走k步，然后再一起走，注意循环的条件，是节点本身为空还是节点的next为空
    public Node findKthToTail(int k){
        if(k <= 0 || this.head == null){
            System.out.println("k的位置不合法！或者头是空的！");
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(k-1 != 0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }
            else{
                System.out.println("k的位置不合法！");
                return null;
            }
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node lastK(int k){
        if(k <= 0 || this.head == null){
            System.out.println("k的位置不合法！或者头是空的！");
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(k != 0){
            if(fast != null){
                fast = fast.next;
                k--;
            }
            else{
                System.out.println("k的位置不合法！");
                return null;
            }
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //给一个x值把链表分成两部分，将小于x值的节点放在大于或等于x节点之前
    //建立两个分段将小于x的和大于x的节点分别放置，最后将前一个分段的尾结点和后一个分段的头结点连起来，注意两个分段是否为空和尾结点的置空行为
    public Node partition(int x){
        if(this.head == null){
            System.out.println("当前链表为空！");
            return null;
        }
        Node cur = this.head;
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        while(cur != null){
            if(cur.val < x){
                //分两种情况，头和非头
                if(beforeStart == null){
                    beforeStart = cur;
                    beforeEnd = cur;
                }
                else{
                    beforeEnd.next = cur;
                    beforeEnd = cur;
                }
            }
            else{
                if(afterStart == null){
                    afterStart = cur;
                    afterEnd = cur;
                }
                else{
                    afterEnd.next = cur;
                    afterEnd = cur;
                }
            }
            cur = cur.next;
        }
        //循环完之后需要判断bs是否为空，若为空则返回as
        if(beforeStart == null){
            return afterStart;
        }
        //没有进入上方if语句说明bs不为空，则将as赋给be.next
        beforeEnd.next = afterStart;
        //此时需要判断as是否为空，若as为空则be.next必为null，若不为空则将ae.next赋为空
        if(afterStart != null){
            afterEnd.next = null;
        }
        return beforeStart;
    }

    //在一个排序的节点中删掉重复的节点,既然是排序这些重复的节点应该是连着的，返回头指针，如1->2->2->3->3->4->5，处理后应为1->4->5
    //建立一个傀儡节点来指向不重复的第一个节点，重复的可能不止两个节点，所谓删除就是指向下一个不重复的节点
    public Node deleteDuplication(){
        Node cur = this.head;
        Node tmpHead = new Node(-1);//定义一个傀儡节点
        Node newHead = tmpHead;
        while(cur != null){
            //找到重复的
            if(cur.next != null && cur.val == cur.next.val){
                //找到重复的且重复的值可能不止两个
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }
            //找不到，移动tmpHead和cur
            else{
                tmpHead.next = cur;
                tmpHead = tmpHead.next;
                cur = cur.next;
            }
        }
        tmpHead.next = null;
        return newHead.next;
    }

    //判断链表是否为回文结构
    //将链表后半段逆序，然后从两边向中间开始判断值是否相等，不等false，相等进行下一步
    //注意链表节点数为奇数和偶数的不同判断条件
    public boolean chkPalindrome(){
        if(this.head == null){
            return false;
        }
        if(this.head.next == null){
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node cur = slow.next;
        while(cur != null){
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while(this.head != slow){
            if(this.head.val != slow.val){
                return false;
            }
            if(this.head.next == slow){
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }

    //返回值为入口点地址
    //先判断是否有环，如果有，那么在他们相遇的地方留下fast，把slow放回head节点，二者一人一步走，再次相遇就是环的入口
    //假设一个有环链表：从开始到环的入口为x，环的长度为c，二倍速的fast与slow相遇的地点距离入口为y，
    //则slow走的长度为x+c-y,而fast走的长度为x+nc+c-y，就有一个等式：x+c-y = x+nc+c-y，则x=y，
    //即让fast在相遇的地点，slow放回起点，同时走，再次相遇点为入口
    public Node detectCycle(){
        if(this.head == null || this.head.next == null){
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        //避免无环
        if(fast == null || fast.next == null){
            return null;
        }
        slow = this.head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
