package ProgrammerCarl.C_HashTable;
/*      四数相加II

给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。

例如:

输入:

A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
输出:

2

解释:

两个元组如下:

(0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
(1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 
 */
import java.util.Map;
import java.util.HashMap;

/*
  * 首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
  * 遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
  * 定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
  * 再遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
  * 最后返回统计值 count 就可以了
  * 
  * 不用考虑有重复的四个元素相加等于0的情况
  * 
  */
public class FourSumCount {
    public static void main(String[] args) {
        int[] nums1 = {-1, -1};
        int[] nums2 = {-1, 1};
        int[] nums3 = {-1, 1};
        int[] nums4 = {1, -1};
        System.out.println(check(nums1,nums2,nums3,nums4));
    }

    public static int check(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums1){
            for(int j:nums2){
                int sum = i+j;
                map.put(sum,map.getOrDefault(sum, 0)+1);
            }
        }
        for(int i:nums3){
            for(int j:nums4){
                res += map.getOrDefault(-i-j, 0);
            }
        }
        return res;
    } 
}
