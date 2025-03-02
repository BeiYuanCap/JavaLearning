package ProgrammerCarl.C_HashTable;
/*        有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1: 输入: s = "anagram", t = "nagaram" 输出: true

示例 2: 输入: s = "rat", t = "car" 输出: false

说明: 你可以假设字符串只包含小写字母。

 */


/*
 * 暴力的解法：
 * 两层for循环，同时还要记录字符是否重复出现，很明显时间复杂度是 O(n^2)
 * 
 * 数组其实就是一个简单哈希表
 * 字典解法
 * 时间复杂度O(m+n) 空间复杂度O(1)
 * 
 */

public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(check(s,t));
    }

    public static boolean check(String s, String t){
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }
        for (int count: record) {
            if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;                        // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }

}
