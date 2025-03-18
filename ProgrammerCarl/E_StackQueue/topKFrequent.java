package ProgrammerCarl.E_StackQueue;
/*   前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 $O(n \log n)$ , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
 */

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 *  主要涉及到如下三块内容：
 * 要统计元素出现频率
 * 对频率排序
 * 找出前K个高频元素
 * 
 * map来进行统计频率
 * 优先级队列进行排序（披着队列外衣的堆）
 * 
 * 用小顶堆，保证堆的大小为k，超过就将最小元素弹出，这样能保证时间复杂度在O(nlogk)
 * 
*/
public class topKFrequent {
    public static void main(String[] args) {
        int[] nums ={1,1,1,2,2,3} ;
        int k = 2;
        for(int n:check(nums,k)){
            System.out.println(n);
        }
    }

    public static int[] check(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        for(var x:map.entrySet()){ // entrySet 获取 k-v Set 集合
            int[] tmp=new int[2];
            tmp[0] = x.getKey();
            tmp[1] = x.getValue();
            pq.offer(tmp);
            if(pq.size()>k){
                pq.poll();
            }
        }

        for(int i=0;i<k;i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }

}
