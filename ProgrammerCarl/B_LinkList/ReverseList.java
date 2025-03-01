package ProgrammerCarl.B_LinkList;
/*     反转链表

题意：反转一个单链表。

示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
*/

/* 
 * 其实只需要改变链表的next指针的指向，直接将链表反转 ，而不用重新定义一个新的链表
 * 首先定义一个cur指针，指向头结点，再定义一个pre指针，初始化为null。
 * 然后就要开始反转了，首先要把 cur->next 节点用tmp指针保存一下，也就是保存一下这个节点。
 * 为什么要保存一下这个节点呢，因为接下来要改变 cur->next 的指向了，将cur->next 指向pre ，此时已经反转了第一个节点了。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class ReverseList {
    public static void main(String[] args) {
        int[] val = {1,2,3,4,5};
        ListNode head = new ListNode(val[0]);
        ListNode cur = head;
        for(int i = 1;i<val.length;i++){
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }

        head = reverse(head);

        while(head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while(cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
