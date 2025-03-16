package ProgrammerCarl.D_String;
/*       重复的子字符串

给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"
输出: True
解释: 可由子字符串 "ab" 重复两次构成。
示例 2:

输入: "aba"
输出: False
示例 3:

输入: "abcabcabcabc"
输出: True
解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */


/*
 * 移动匹配
 * 判断字符串s是否由重复子串组成，只要两个s拼接在一起，里面还出现一个s的话，就说明是由重复子串组成。
 * 这种解法还有一个问题，就是 我们最终还是要判断 一个字符串（s + s）是否出现过 s 的过程，大家可能直接用contains，find 之类的库函数， 却忽略了实现这些函数的时间复杂度（暴力解法是m * n，一般库函数实现为 O(m + n)）
 * 
 * KMP
 * 前缀表里，统计了各个位置为终点字符串的最长相同前后缀的长度
 * 如果这个字符串s是由重复子串组成，那么最长相等前后缀不包含的子串是字符串s的最小重复子串
 * 关键是需要证明， 字符串s的最长相等前后缀不包含的子串 什么时候才是 s最小重复子串。
 * 当 最长相等前后缀不包含的子串的长度 可以被 字符串s的长度整除，那么不包含的子串 就是s的最小重复子串。
 * 
 * next 数组记录的就是最长相同前后缀（ 字符串：KMP算法精讲 (opens new window)）， 如果 next[len - 1] != -1，则说明字符串有最长相同的前后缀（就是字符串里的前缀子串和后缀子串相同的最长长度）。
 * 最长相等前后缀的长度为：next[len - 1] + 1。(这里的next数组是以统一减一的方式计算的，因此需要+1，两种计算next数组的具体区别看这里：字符串：KMP算法精讲 (opens new window))
 * 数组长度为：len。
 * len - (next[len - 1] + 1) 是最长相等前后缀不包含的子串的长度。
 * 如果len % (len - (next[len - 1] + 1)) == 0 ，则说明数组的长度正好可以被 最长相等前后缀不包含的子串的长度 整除 ，说明该字符串有重复的子字符串。
 */
public class repeatedSubstringPattern {
    public static void main(String[] args) {
        String haystack = "abcabcabcabc";
        System.out.println(check(haystack));
    }

    public static boolean check(String s) {
        if (s.equals("")) return false;
        int len = s.length();
        int[] next = new int[len];

        int j=-1;
        next[0] = j;
        for(int i=1;i<s.length();i++){
            while(j>=0 && s.charAt(i)!=s.charAt(j+1)) j = next[j];
            if(s.charAt(i)==s.charAt(j+1)) j++;
            next[i] = j;
        }

        if(next[len-1] > -1 && len%(len-next[len-1]-1)==0){
            return true;
        }

        return false;
    }

}
