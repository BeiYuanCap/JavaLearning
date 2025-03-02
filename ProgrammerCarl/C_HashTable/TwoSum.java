package ProgrammerCarl.C_HashTable;
/*      两数之和

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9

所以返回 [0, 1]
 
 */
import java.util.Map;
import java.util.HashMap;

/*
  * 暴力的解法是两层for循环查找，时间复杂度是O(n^2)
  * 什么时候使用哈希法，当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法。
  * 本题，我们不仅要知道元素有没有遍历过，还要知道这个元素对应的下标，需要使用 key value结构来存放，key来存元素，value来存下标，那么使用map正合适。
  * 
  */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        for(int num:check(nums,target)){
            System.out.println(num);
        }
    }

    // 使用HashSet LeetCode 4ms
    public static int[] check(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int tmp = target - nums[i];
            if(map.containsKey(tmp)){
                res[0] = map.get(tmp);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    } 
}
