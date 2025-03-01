package ProgrammerCarl.B_LinkList;

public class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int x){this.val=x;}
    public ListNode(int x, ListNode node){
        this.val = x;
        this.next = node;
    }
}
