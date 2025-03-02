package ProgrammerCarl.C_HashTable;
/*      两个数组的交集

给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
 

提示：

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * 主要使用一个数据结构： set
 * C++最好使用std::unordered_set
 * Java使用HashSet
 * 
 * 在给定数值范围后最好使用数组替换掉Hash，而且如果哈希值比较少、特别分散、跨度非常大，使用数组就造成空间的极大浪费。
 */



public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        for(int num:inter(nums1,nums2)){
            System.out.println(num);
        }
    }

    // 使用HashSet LeetCode 4ms
    // public static int[] inter(int[] nums1, int[] nums2) {
    //     if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
    //         return new int[0];
    //     }
        
    //     Set<Integer> set1 = new HashSet<>();
    //     Set<Integer> resSet = new HashSet<>();

    //     for(int i:nums1){
    //         set1.add(i);
    //     }

    //     for(int i:nums2){
    //         if(set1.contains(i)){
    //             resSet.add(i);
    //         }
    //     }
    //     return resSet.stream().mapToInt(x -> x).toArray();
    // }

    // 使用数组 LeetCode 1ms
    public static int[] inter(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];
        for(int i : nums1)
            hash1[i]++;
        for(int i : nums2)
            hash2[i]++;
        List<Integer> resList = new ArrayList<>();
        for(int i = 0; i < 1002; i++)
            if(hash1[i] > 0 && hash2[i] > 0)
                resList.add(i);
        int index = 0;
        int res[] = new int[resList.size()];
        for(int i : resList)
            res[index++] = i;
        return res;        
    }

}
