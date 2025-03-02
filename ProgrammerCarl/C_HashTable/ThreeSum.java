package ProgrammerCarl.C_HashTable;
/*      三数之和

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意： 答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 
 */
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
  * 哈希解法
  * 两层for循环就可以确定 两个数值，可以使用哈希法来确定 第三个数 0-(a+b) 或者 0 - (a + c) 是否在 数组里出现过
  * 其实这个思路是正确的，但是我们有一个非常棘手的问题，就是题目中说的不可以包含重复的三元组。
  * 把符合条件的三元组放进vector中，然后再去重，这样是非常费时的，很容易超时，也是这道题目通过率如此之低的根源所在。
  * 
  * 去重的过程不好处理，有很多小细节，如果在面试中很难想到位。
  * 时间复杂度可以做到O(n^2)，但还是比较费时的，因为不好做剪枝操作。
  * 大家可以尝试使用哈希法写一写，就知道其困难的程度了。
  * 
  * 双指针
  * 首先将数组排序，然后有一层for循环，i从下标0的地方开始，同时定一个下标left 定义在i+1的位置上，定义下标right 在数组结尾的位置上
  * 还是在数组中找到 abc 使得a + b +c =0，我们这里相当于 a = nums[i]，b = nums[left]，c = nums[right]。
  * 如果nums[i] + nums[left] + nums[right] > 0 就说明 此时三数之和大了，因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些。
  * 如果 nums[i] + nums[left] + nums[right] < 0 说明 此时 三数之和小了，left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。
  * 时间复杂度：O(n^2)
  * 空间复杂度: O(1)
  * 
  * 去重逻辑的思考
  * a的去重:判断 nums[i] 与 nums[i-1] 是否相同,可以在去重的同时防止pass掉三元组中出现重复元素的情况
  * b与c的去重:
  * 
  * 
  * 双指针法一定要排序，一旦排序之后原数组的索引就被改变了。 所以两数之和不能使用双指针法
  */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        for(List<Integer> list:check(nums1)){
            for(int i:list){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> check(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                return result;
            }
            // a去重
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left=i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(right>left && nums[left]==nums[left+1]) left++;
                    while(right>left && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    } 
}
