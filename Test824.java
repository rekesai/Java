import java.util.Scanner;

public class Test824 {
    

    // 判断链表中是否有环
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    // 反转链表
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }

    // 每K个一组反转链表
    public static ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = pre.next;
        pre.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int k = sc.nextInt();
        // 初始化链表
        ListNode head = new ListNode(Integer.parseInt(strs[0]));
        ListNode cur = head;
        for (int i = 1; i < strs.length; i++) {
            cur.next = new ListNode(Integer.parseInt(strs[i]));
            cur = cur.next;
        }
        // 开始逆序
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode end = preHead;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            cur = reverse(start);
            // 重置节点位置
            pre.next = cur;
            start.next = next;
            pre = start;
            end = pre;
        }
        // 打印链表值
        cur = preHead.next;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }
}
