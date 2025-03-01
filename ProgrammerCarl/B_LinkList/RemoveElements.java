package ProgrammerCarl.B_LinkList;
/*     移除链表元素

题意：删除链表中等于给定值 val 的所有节点。

示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]

示例 2： 输入：head = [], val = 1 输出：[]

示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]

*/

/* 
 * 链表操作的两种方式：
 * 直接使用原来的链表来进行删除操作。
 * 设置一个虚拟头结点在进行删除操作。
 * 均为
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * 
 * 对于空链表，不需要移除元素。可以通过递归的思路解决本题
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 
 */

public class RemoveElements {
    public static void main(String[] args) {
        // ListNode noden = new ListNode(6);
        // ListNode noden_1 = new ListNode(5,noden);
        // ListNode noden_2 = new ListNode(4,noden_1);
        // ListNode noden_3 = new ListNode(3,noden_2);
        // ListNode noden_4 = new ListNode(6,noden_3);
        // ListNode noden_5 = new ListNode(2,noden_4);
        // ListNode noden_6 = new ListNode(1,noden_5);

        ListNode noden = new ListNode(7);
        ListNode noden_1 = new ListNode(7,noden);
        ListNode noden_2 = new ListNode(7,noden_1);
        ListNode noden_3 = new ListNode(7,noden_2);
        ListNode noden_4 = new ListNode(7,noden_3);
        ListNode noden_5 = new ListNode(7,noden_4);
        ListNode noden_6 = new ListNode(7,noden_5);
        ListNode head = noden_6;
        int val = 7 ;
        head = removenode(head,val);
        printnode(head);
    }

    public static void printnode(ListNode head){
        if(head!=null){
            while(head.next != null){
                System.out.print(head.val+",");    
                head = head.next ;        
            }
            System.out.print(head.val);  
        }   
        else{
            System.out.print("[]");
        }
    }

    public static ListNode removenode(ListNode head, int val){
        ListNode virtual_head = new ListNode(0);
        virtual_head.next = head;
        ListNode cur = virtual_head;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return virtual_head.next;
    }

}
