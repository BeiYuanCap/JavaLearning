package ProgrammerCarl.C_HashTable;

import java.util.Set;

/*      快乐数

编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 【无限循环】 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

如果 n 是快乐数就返回 True ；不是，则返回 False 。

示例：

输入：19
输出：true
解释：
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 
 */
import java.util.Set;
import java.util.HashSet;
 /*
  * 无限循环 是重点
  * 求和的过程中，sum会重复出现，这对解题很重要！
  * 
  * 使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止。
  * 
  */

public class IsHappy {
    public static void main(String[] args) {
        int nums1 = 2;
        System.out.println(check(nums1));
    }

    // 使用HashSet LeetCode 4ms
    public static boolean check(int n) {
        Set<Integer> sum_record = new HashSet<>();
        while(true){
            int res = 0;
            while(n>0){
                int num = n % 10;
                n = n/10;
                res += num*num;
            }
            if(res==1){
                return true;
            }
            else if(sum_record.contains(res)){
                return false;
            }
            sum_record.add(res);
            n = res;
        }
    } 
}
