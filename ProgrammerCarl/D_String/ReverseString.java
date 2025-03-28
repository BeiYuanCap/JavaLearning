package ProgrammerCarl.D_String;

/*        反转字符串

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

示例 1：
输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]

示例 2：
输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]

 */


/*
 * 如果题目关键的部分直接用库函数就可以解决，建议不要使用库函数。
 * 如果库函数仅仅是 解题过程中的一小部分，并且你已经很清楚这个库函数的内部实现原理的话，可以考虑使用库函数。
 * 使用双指针进行反转
 */

 public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};

        check(s);
    }

    public static void check(char[] s){
        int l=0;
        int r=s.length-1;
        while(l<r){
            // 使用异或操作进行交换
            s[l] ^= s[r]; 
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }

        for(char c:s)
            System.err.println(c);
    }

}
