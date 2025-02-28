/*       移除元素
 
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。

元素的顺序可以改变【可以用双向指针】。你不需要考虑数组中超出新长度后面的元素。

示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。

示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

你不需要考虑数组中超出新长度后面的元素。

*/

/* 
 * 数组的元素在内存地址中是连续的，不能单独删除数组中的某个元素，只能覆盖。
 * 
 * 暴力解法 ： 
 * 两层for循环，一个for循环遍历数组元素 ，第二个for循环更新数组。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1) 
 * 
 * 双指针法：
 * 通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
 * 快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
 * 慢指针：指向更新 新数组下标的位置
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 
 */

public class RemoveElement {
    public static void main(String[] args) {
        int [] nums1 = {3,2,2,3};
        int target1 = 3;
        System.out.println(remove(nums1,target1));

        int [] nums2 = {0,1,2,2,3,0,4,2};
        int target2 = 2;
        System.out.println(remove(nums2,target2));
    }

    public static int remove(int[] nums, int val){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            if( nums[fast] != val ){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
