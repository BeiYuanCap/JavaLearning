package ProgrammerCarl.E_StackQueue;
/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true */

import java.util.Deque;
import java.util.LinkedList;

/*
 * 第一种情况：已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false
 * 第二种情况：遍历字符串匹配的过程中，发现栈里没有要匹配的字符。所以return false
 * 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号return false
 * 
 * 注：Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。Deque堆栈操作方法：push()、pop()、peek()。
 * 
 * 普通队列(一端进另一端出):
 * Queue queue = new LinkedList()或Deque deque = new LinkedList()
 * 双端队列(两端都可进出)
 * Deque deque = new LinkedList()
 * 堆栈
 * Deque deque = new LinkedList()
 */
public class isValid {
    public static void main(String[] args) {
        String s = "()[]{}" ;
        System.out.println(check(s));
    }

    public static boolean check(String s){
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            if(ch=='('){
                deque.push(')');
            }else if(ch=='{'){
                deque.push('}');
            }else if(ch=='['){
                deque.push(']');
            } else if(deque.isEmpty()||ch!=deque.peek()){
                return false;
            } else{
                deque.pop();
            } 
        }
        return deque.isEmpty();
    }

}
