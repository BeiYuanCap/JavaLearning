package ProgrammerCarl.B_LinkList;
/*     设计链表

在链表类中实现这些功能：

get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

*/

/* 
 * 链表操作的两种方式：
 * 直接使用原来的链表来进行删除操作。
 * 设置一个虚拟头结点在进行删除操作。
 * 均为
 * 时间复杂度: 涉及 index 的相关操作为 O(index), 其余为 O(1)
 * 空间复杂度: O(n)
 * 
 */

// 单链表
// public class MyLinkedList {
//     class ListNode {
//         int val;
//         ListNode next;
//         ListNode(int val) {
//             this.val=val;
//         }
//     }

//     private int size; // 存储元素个数
//     private ListNode head; //虚拟头节点

//     public MyLinkedList() {
//         this.size = 0;
//         this.head = new ListNode(0);
//     }
    
//     //获取第index个节点的数值，注意index是从0开始的，第0个节点就是虚拟头结点
//     public int get(int index) {
//         //如果index非法，返回-1
//         if(index<0||index>=size){
//             return -1;
//         }
//         ListNode cur=head;
//         //第0个节点是虚拟头节点，所以查找第 index+1 个节点
//         for(int i=0;i<=index;i++){
//             cur = cur.next;
//         }
//         return cur.val;
//     }
    
//     public void addAtHead(int val) {
//         ListNode newNode = new ListNode(val);
//         newNode.next = head.next;
//         head.next = newNode;
//         size++;
//     }
    
//     public void addAtTail(int val) {
//         ListNode newNode = new ListNode(val);
//         ListNode cur=head;
//         while(cur.next != null){
//             cur = cur.next;
//         }
//         cur.next = newNode;
//         size++;
//     }

//     // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。    
//     public void addAtIndex(int index, int val) {
//         //如果index非法，返回-1
//         if(index<0||index>size){
//             return;
//         }
        
//         ListNode pred=head;
//         for(int i=0;i<index;i++){
//             pred = pred.next;
//         }
//         ListNode newNode = new ListNode(val);
//         newNode.next = pred.next;
//         pred.next = newNode;
//         size++;      
//     }
    
//     public void deleteAtIndex(int index) {
//         //如果index非法，返回-1
//         if(index<0||index>=size){
//             return;
//         }
        
//         ListNode pred=head;
//         for(int i=0;i<index;i++){
//             pred = pred.next;
//         }
//         pred.next = pred.next.next;
//         size--;   
//     }
// }

// 双链表
class MyLinkedList {  

    class ListNode{
        int val;
        ListNode next, prev;
        ListNode(int val){
            this.val = val;
        }
    }

    //记录链表中元素的数量
    private int size;
    //记录链表的虚拟头结点和尾结点
    private ListNode head, tail;
    
    public MyLinkedList() {
        //初始化操作
        this.size = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int index) {
        //判断index是否有效
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        //判断是哪一边遍历时间更短
        if(index >= size / 2){
            //tail开始
            cur = tail;
            for(int i = 0; i < size - index; i++){
                cur = cur.prev;
            }
        }else{
            for(int i = 0; i <= index; i++){
                cur = cur.next; 
            }
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        //等价于在第0个元素前添加
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        //等价于在最后一个元素(null)前添加
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        //判断index是否有效
        if(index < 0 || index > size){
            return;
        }

        //找到前驱
        ListNode pre = head;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        //新建结点
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next.prev = newNode;
        newNode.prev = pre;
        pre.next = newNode;
        size++;
        
    }
    
    public void deleteAtIndex(int index) {
        //判断index是否有效
        if(index < 0 || index >= size){
            return;
        }

        //删除操作
        ListNode pre = head;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next.next.prev = pre;
        pre.next = pre.next.next;
        size--;
    }
}
