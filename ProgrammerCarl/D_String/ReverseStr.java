package ProgrammerCarl.D_String;
/*        反转字符串 II

给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 

示例 1：

输入：s = "abcdefg", k = 2
输出："bacdfeg"
示例 2：

输入：s = "abcd", k = 2
输出："bacd"
 

提示：

1 <= s.length <= 104
s 仅由小写英文组成
1 <= k <= 104

 */


/*
 * 其实在遍历字符串的过程中，只要让 i += (2 * k)，i 每次移动 2 * k 就可以了，然后判断是否需要有反转的区间。
 * 因为要找的也就是每2 * k 区间的起点，这样写，程序会高效很多。
 * 所以当需要固定规律一段一段去处理字符串的时候，要想想在for循环的表达式上做做文章。
 */

 public class ReverseStr {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(check(s,k));
    }

    public static String check(String s, int k){
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int start = 0;
        while(start<length){
            int firstK = (start+k>length)?length:start+k;
            int secondK = (start+2*k>length)?length:start+2*k;
            StringBuffer temp = new StringBuffer();

            temp.append(s.substring(start,firstK));
            res.append(temp.reverse());

            if(firstK<secondK){
                res.append(s.substring(firstK,secondK));
            }
            start += 2*k;
        }
        return res.toString();
    }

}
