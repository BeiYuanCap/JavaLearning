/*     区间和（ACM模式）

给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。

输入描述

第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。随后的输入为需要计算总和的区间，直至文件结束。

输出描述

输出每个指定区间内元素的总和。

输入示例

5
1
2
3
4
5
0 1
1 3
输出示例

3
9
数据范围：

0 < n <= 100000

*/

/* 
 * 数组 上常用的解题技巧：前缀和
 * 最直观的想法：给一个区间，然后 把这个区间的和都累加一遍
 * 若查询m次，每次查询的范围都是从0 到 n - 1，则该算法的时间复杂度是 O(n * m) m 是查询的次数。如果查询次数非常大的话，这个时间复杂度也是非常大的。
 * 
 * 前缀和的思想是重复利用计算过的子数组之和，从而降低区间查询需要累加计算的次数。
 *
 * 前缀和 在涉及计算区间和的问题时非常有用！
 * 
 */

import java.util.Scanner;

public class SumOfIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] sumres = new int[n];
        int sumcount = 0;
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
            sumcount += nums[i];
            sumres[i] = sumcount;
        }

        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if(a==0){
                System.out.println(sumres[b]);
            }
            else{
                System.out.println(sumres[b]-sumres[a-1]);
            }
        }
        sc.close();
    }
}

