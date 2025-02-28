/*     长度最小的子数组

给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 【连续】 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

示例：

输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
提示：

1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

*/

/* 
 * 暴力解法：
 * 两个for循环，然后不断的寻找符合条件的子序列
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 
 * 滑动窗口：
 * 滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
 * 只用一个for循环，那么这个循环的索引，一定是表示 滑动窗口的终止位置。
 * 根据当前子序列和大小的情况，不断调节子序列的起始位置。从而将O(n^2)暴力解法降为O(n)
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 
 */

 public class SmallestSubArray {
    public static void main(String[] args) {
        int [] nums1 = {2,3,1,2,4,3};
        int s1 = 7;
        System.out.println(findsub(s1,nums1));
    }

    public static int findsub(int target, int[] nums){
        int result = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;
        for (int r=0;r<nums.length;r++){
            sum += nums[r];

            // 以下窗口滑动方法增加了r--的回退操作，使运行时间上升。
            // if(sum>=target){
            //     result = (r - l + 1)<result?(r - l + 1):result;
            //     sum -= nums[l++];
            //     sum -= nums[r--];
            // }
            
            // 以下实现更加高效
            while(sum>=target){
                result = Math.min(result,r - l + 1);
                sum -= nums[l++];
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}