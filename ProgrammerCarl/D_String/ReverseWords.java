package ProgrammerCarl.D_String;
/*        翻转字符串里的单词【重要，属于综合了之前的几个算法】

给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：
输入: "the sky is blue"
输出: "blue is sky the"

示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

 */


/*
 * 不要使用辅助空间，空间复杂度要求为O(1)。
 * 移除多余空格
 * 将整个字符串反转
 * 将每个单词反转
 */

 public class ReverseWords {
    public static void main(String[] args) {
        String s = "the sky is blue";

        System.out.println(reverse(s));
    }

    public static String reverse(String s){
        char[] chars = s.toCharArray();
        // 1. 去除首尾及中间多余空格
        chars = removeExtraSpaces(chars);
        // 2. 反转整个字符串
        reversestring(chars, 0, chars.length - 1);
        //3.单词反转
        reverseEachWord(chars);
        return new String(chars);
    }

    public static char[] removeExtraSpaces(char[] chars){
        int slow = 0;
        for(int fast=0;fast<chars.length;fast++){
            if(chars[fast]!=' '){
                if(slow!=0){
                    chars[slow++] = ' ';
                }
                //fast 遇到空格或遍历到字符串末尾，就证明遍历完一个单词了
                while (fast < chars.length && chars[fast] != ' ')
                    chars[slow++] = chars[fast++];
            }
        }
        char[] newChar = new char[slow];
        System.arraycopy(chars, 0, newChar, 0, slow);
        return newChar;
    }

    public static void reversestring(char[] chars,int left,int right){
        if(right>=chars.length){
            System.out.println("set a wrong right");
            return;
        }
        while(left<right){
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }

    public static void reverseEachWord(char[] chars){
        int start = 0;
        for(int end=0;end<=chars.length;end++){
            if(end==chars.length || chars[end]==' '){
                reversestring(chars,start,end-1);
                start = end + 1; 
            }
        }
    }

}