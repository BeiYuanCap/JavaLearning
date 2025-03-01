package ProgrammerCarl.B_LinkList;
/*    环形链表II

题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。

输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。

输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。

提示：

链表中节点的数目范围在范围 [0, 104] 内
-105 <= Node.val <= 105
pos 的值为 -1 或者链表中的一个有效索引

进阶：你是否可以使用 O(1) 空间解决此题？

*/

/* 
 * 判断链表是否有环
 * 可以使用快慢指针法，分别定义 fast 和 slow 指针，从头结点出发，fast指针每次移动两个节点，slow指针每次移动一个节点，如果 fast 和 slow指针在途中相遇 ，说明这个链表有环。
 * 
 * 如果有环，如何找到这个环的入口
 * 假设从头结点到环形入口节点 的节点数为x。 环形入口节点到 fast指针与slow指针相遇节点 节点数为y。 从相遇节点 再到环形入口节点节点数为 z。
 * 那么相遇时： slow指针走过的节点数为: x + y， fast指针走过的节点数：x + y + n (y + z)，n为fast指针在环内走了n圈才遇到slow指针， （y+z）为 一圈内节点的个数A。
 * 因为fast指针是一步走两个节点，slow指针一步走一个节点， 所以 fast指针走过的节点数 = slow指针走过的节点数 * 2：
 * (x + y) * 2 = x + y + n (y + z)
 * 因为要找环形的入口，那么要求的是x，因为x表示 头结点到 环形入口节点的的距离。
 * 所以要求x ，将x单独放在左面：x = n (y + z) - y ,
 * 再从n(y+z)中提出一个 （y+z）来，整理公式之后为如下公式：x = (n - 1) (y + z) + z 注意这里n一定是大于等于1的，因为 fast指针至少要多走一圈才能相遇slow指针。
 * 先拿n为1的情况来举例，意味着fast指针在环形里转了一圈之后，就遇到了 slow指针了。
 * 当 n为1的时候，公式就化解为 x = z，
 * 这就意味着，从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点。
 * 也就是在相遇节点处，定义一个指针index1，在头结点处定一个指针index2。
 * 让index1和index2同时移动，每次移动一个节点， 那么他们相遇的地方就是 环形入口的节点。
 * 
 */

 public class DetectCycle {
    public static void main(String[] args) {
        int[] val = {3,2,0,-4};
        int pos = 1;
        ListNode head = new ListNode(val[0]);
        ListNode cur = head;
        for(int i = 1;i<val.length;i++){
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }

        int index = 0;
        ListNode tmp = head;
        while(index!=pos){
            tmp = tmp.next;
            index++;
        }
        cur.next = tmp;

        ListNode linknode = detect(head);

        System.out.print(linknode.val+",");
    }

    public static ListNode detect(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;

                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }

        }

        return null;
    }

}