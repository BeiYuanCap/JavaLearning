package ProgrammerCarl.B_LinkList;
/*     删除链表的倒数第N个节点

给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？

示例 1：
输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5]

示例 2：

输入：head = [1], n = 1 输出：[]

示例 3：

输入：head = [1,2], n = 1 输出：[1]
*/

/* 
 * 双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */

 public class RemoveNthFromEnd {
    public static void main(String[] args) {
        int[] val = {1,2,3,4,5};
        ListNode head = new ListNode(val[0]);
        ListNode cur = head;
        for(int i = 1;i<val.length;i++){
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }
        int n = 2;
        head = delete(head,n);

        while(head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
    }

    public static ListNode delete(ListNode head, int n){
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode slowNode = dumpy;
        ListNode fastNode = dumpy;

        for(int i = 0; i <= n; i++){
            fastNode = fastNode.next;
        }

        while(fastNode!=null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        if (slowNode.next != null) {
            slowNode.next = slowNode.next.next;
        }        

        return dumpy.next;
    }

}
