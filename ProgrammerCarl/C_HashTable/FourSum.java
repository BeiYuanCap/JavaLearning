package ProgrammerCarl.C_HashTable;
/*      四数之和

题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 
 */
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * 四数之和的双指针解法是两层for循环nums[k] + nums[i]为确定值，依然是循环内有left和right下标作为双指针，找出nums[k] + nums[i] + nums[left] + nums[right] == target的情况
 * 三数之和的时间复杂度是O(n^2)，四数之和的时间复杂度是O(n^3) 。
 * 时间复杂度: O(n^3)
 * 空间复杂度: O(1)
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target = 0;
        for(List<Integer> list:check(nums1,target)){
            for(int i:list){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> check(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            if(nums[k]>target && nums[k]>=0){
                return result;
            }
            // a去重
            if(k>0 && nums[k] == nums[k-1]){
                continue;
            }
            for(int i=k+1;i<nums.length;i++){
                if(nums[k]+nums[i]>target && nums[i] >= 0){
                    break;
                }
                // b去重
                if(i>k+1 && nums[i] == nums[i-1]){
                    continue;
                }
                int left=i+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[k]+nums[i]+nums[left]+nums[right];
                    if(sum>target){
                        right--;
                    }
                    else if(sum<target){
                        left++;
                    }
                    else{
                        result.add(Arrays.asList(nums[k],nums[i],nums[left],nums[right]));
                        while(right>left && nums[left]==nums[left+1]) left++;
                        while(right>left && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
           
        }
        return result;
    } 
}
