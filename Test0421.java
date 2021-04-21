public class Test0421 {
    //合并两个有序的链表为一个新的有序链表
    //定义一个傀儡节点，开始遍历head1和head2，谁小谁放进新链表并往后走，最后走到空的必定与tmpHead在一边
    public  static Node mergeTwoLists(Node head1, Node head2){
        Node newHead = new Node(-1);
        Node tmpHead = newHead;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                tmpHead.next = head1;
                head1 = head1.next;
            }
            else{
                tmpHead.next = head2;
                head2 = head2.next;
            }
            tmpHead = tmpHead.next;
        }

        if(head1 != null){
            tmpHead.next = head1;
        }
        if(head2 != null){
            tmpHead.next = head2;
        }
        return newHead.next;
    }
    public static Node myMergeTwoLists(Node head1, Node head2){
        Node newHead = null;
        Node tmpHead = null;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                if(newHead == null){
                    newHead = head1;
                    tmpHead = newHead;
                }
                else{
                    tmpHead.next = head1;
                    tmpHead = head1;
                }
                head1 = head1.next;
            }
            else{
                if(newHead == null){
                    newHead = head2;
                    tmpHead = newHead;
                }
                else{
                    tmpHead.next = head2;
                    tmpHead = head2;
                }
                head2 = head2.next;
            }
        }
        if(head1 == null){
            tmpHead.next = head2;
        }
        if(head2 == null){
            tmpHead.next = head1;
        }
        return newHead;
    }


    //编写一个程序，找到两个单链表相交的起始节点
    public Node getIntersectionNode(Node headA, Node headB){
        if(headA == null || headB == null){
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        Node pl = headA;
        Node ps = headB;
        while(pl != null){
            lenA++;
            pl = pl.next;
        }
        while(ps != null){
            lenB++;
            ps = ps.next;
        }
        pl = headA;
        ps = headB;
        int len = lenA - lenB;
        if(len < 0){
            pl = headB;
            ps = headA;
            len = Math.abs(lenA - lenB);//求绝对值
        }
        while(len != 0){
            pl = pl.next;
            len--;
        }
        while(pl != ps){
            pl = pl.next;
            ps = ps.next;
        }
        if(pl == null || ps == null){
            return null;
        }

        return pl;
    }
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addLast(0);
        singleLinkedList1.addLast(1);
        singleLinkedList1.addLast(3);
        singleLinkedList1.addLast(6);
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addLast(0);
        singleLinkedList2.addLast(0);
        singleLinkedList2.addLast(1);
        singleLinkedList2.addLast(2);
        singleLinkedList2.addLast(5);
        singleLinkedList1.showList();
        singleLinkedList2.showList();
        Node ret = mergeTwoLists(singleLinkedList1.head,singleLinkedList2.head);
        singleLinkedList1.showList(ret);
    }

}
