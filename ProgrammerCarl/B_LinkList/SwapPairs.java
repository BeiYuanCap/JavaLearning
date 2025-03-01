package ProgrammerCarl.B_LinkList;
/*     两两交换链表中的节点

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

输入：head = [1,2,3,4]
输出：[2,1,4,3]

输入：head = []
输出：[]

输入：head = [1]
输出：[1]

*/

/* 
 * 正常模拟就可以了
 * 建议使用虚拟头结点，这样会方便很多，要不然每次针对头结点（没有前一个指针指向头结点），还要单独处理。
 * 设置一个虚拟头结点在进行删除操作。
 * 均为
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */

public class SwapPairs {
    public static void main(String[] args) {
        int[] val = {1,2,3,4};
        ListNode head = new ListNode(val[0]);
        ListNode cur = head;
        for(int i = 1;i<val.length;i++){
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }

        head = swaplist(head);

        while(head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
    }

    public static ListNode swaplist(ListNode head){
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode cur = dumpy;
        ListNode tmp;
        ListNode firstnode;
        ListNode secondnode;
        while(cur.next!=null&&cur.next.next!=null){
            tmp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;

            cur.next = secondnode;
            secondnode.next = firstnode;
            firstnode.next = tmp;

            cur = firstnode;
        }
        return dumpy.next;
    }

}
