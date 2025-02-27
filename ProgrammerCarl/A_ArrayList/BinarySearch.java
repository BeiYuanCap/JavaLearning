package A_ArrayList;

/*

给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

示例 1:
输入: nums = [-1,0,3,5,9,12], target = 9     
输出: 4       
解释: 9 出现在 nums 中并且下标为 4  

示例 2:
输入: nums = [-1,0,3,5,9,12], target = 2     
输出: -1        
解释: 2 不存在 nums 中因此返回 -1    

提示：

你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。

*/

public class BinarySearch {
    public static void main(String[] args) {
        int [] nums1 = {-1,0,3,5,9,12};
        int target1 = 9;
        System.out.println(search(nums1,target1));

        int [] nums2 = {-1,0,3,5,9,12};
        int target2 = 2;
        System.out.println(search(nums2,target2));
       
    }

    public static int search(int[] nums, int target){
        // 避免当 target 超出 nums 范围时多次循环运算
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }

        int right = nums.length - 1;
        int left = 0;

        while(left<=right){
            
            // // 这里直接取中点，可能会导致整数溢出（虽然 Java int 够大，通常不会溢出）。
            // int mid = (right+left)/2;

            // 这里使用了位运算 >> 1，等效于除以 2，避免了 right + left 可能溢出的风险（虽然 Java int 的范围很大，在 n 不超过 10000 的情况下问题不大，但这是一种更安全的写法）
            int mid = left + ((right - left)>>1);

            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid]<target){
                left = mid+1;
            }
            else{ // nums[mid] > target
                right = mid -1;
            }

        }
        // 未找到目标值
        return -1;
    }
}
