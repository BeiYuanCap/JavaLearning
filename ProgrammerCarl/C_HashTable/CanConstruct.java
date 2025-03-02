package ProgrammerCarl.C_HashTable;
/*      赎金信

给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。

(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)

注意：

你可以假设两个字符串均只含有小写字母。

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 
 */
import java.util.Map;
import java.util.HashMap;

/*
  * 暴力枚举了，两层for循环，不断去寻找
  * 时间复杂度: O(n^2)
  * 空间复杂度: O(1)
  *
  * 由于是小写字母，可以用数组作为哈希表
  * 其实在本题的情况下，使用map的空间消耗要比数组大一些的，因为map要维护红黑树或者哈希表，而且还要做哈希函数，是费时的！数据量大的话就能体现出来差别了。 所以数组更加简单直接有效！
  * 时间复杂度: O(n)
  * 空间复杂度: O(1)
  */
public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(check("aa", "aab"));
    }

    // 使用HashSet LeetCode 4ms
    public static boolean check(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] record = new int[26];

        for(char c:magazine.toCharArray()){
            record[c-'a'] += 1;
        }

        for(char c:ransomNote.toCharArray()){
            record[c-'a'] -= 1;
        }

        for(int i:record){
            if(i<0){
                return false;
            }
        }
        return true;
    } 
}
