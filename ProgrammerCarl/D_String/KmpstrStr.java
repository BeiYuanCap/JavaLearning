package ProgrammerCarl.D_String;
/*        实现 strStr()

实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2

示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1

说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符

 */


/*
 * KMP主要应用在字符串匹配上。
 * 当出现字符串不匹配时，可以知道一部分之前已经匹配的文本内容，可以利用这些信息避免从头再去做匹配了。
 * next数组记录已经匹配的文本内容
 * next数组就是一个前缀表（prefix table）
 * 前缀表是用来回退的，它记录了模式串与主串(文本串)不匹配的时候，模式串应该从哪里开始重新匹配。
 * 什么是前缀表：记录下标i之前（包括i）的字符串中，有多大长度的相同前缀后缀。
 * 
 * 最长公共前后缀
 * kmp就是最长相等前后缀
 * a  a  b  a  a  f
 * 0  1  0  1  2  0
 */

 public class KmpstrStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int[] next = new int[needle.length()];

        // j+1指向前缀末尾位置
        // next[j+1]就是记录着j+1（包括j+1）之前的子串的相同前后缀的长度。
        int j = -1;
        next[0] = j;
        for(int i=1;i<needle.length();i++){
            while(j>=0 && needle.charAt(i) != needle.charAt(j+1)){// 前后缀不相同了
                j = next[j];// 向前回退
            }

            if(needle.charAt(i)==needle.charAt(j+1)){ // 找到相同的前后缀
                j++;
            }

            next[i] = j;
        }

        int k=-1;
        for(int i=0;i<haystack.length();i++){
            // 字符不匹配
            while(k>=0 && haystack.charAt(i)!=needle.charAt(k+1)){
                k = next[k];
            }
            // 字符匹配
            if(haystack.charAt(i) == needle.charAt(k+1)){
                k++;
            }
            if(k==needle.length()-1){
                return (i-needle.length()+1);
            }
        }

        return -1;
    }

}
