package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2290 👎 0

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        int[] nums = {1, 1, 1};
        int k = 2;
        int res = solution.subarraySum(nums, k);
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                //这里判断的是有无pre(i-1)，但是i=0的时候，
                // pre(-1)意味着第一个数之前的数的和，
                // 其实就是没有数也就是0，所以初始化要加上（0，1）
                if (map.containsKey(sum - k)) {
                    res += map.get(sum - k);
                }
                if (map.containsKey(sum)) {
                    int value = map.get(sum);
                    map.replace(sum, value + 1);
                } else {
                    map.put(sum, 1);
                }
            }
            return res;
        }
        //        public int subarraySum(int[] nums, int k) {
//            int i = 0;
//            int j = 0;
//            int sum = nums[0];
//            int res = 0;
//
//            while (j < nums.length && i < nums.length) {
//                //判断sum和k的大小
//                if (sum == k) {
//                    res++;
//                    sum -= nums[i];
//                    i++;
//                    j++;
//                    if (j == nums.length) {
//                        break;
//                    }
//                    sum += nums[j];
//                } else if (sum < k) {
//                    j++;
//                    if (j == nums.length) {
//                        break;
//                    }
//                    sum += nums[j];
//                } else {
//                    sum -= nums[i];
//                    i++;
//                }
//            }
//            return res;
//
//        }
//        public int subarraySum(int[] nums, int k) {
//            if (nums.length == 1) {
//                if (k == nums[0]) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//            HashMap<Integer, Integer> map = new HashMap<>();
//            int res = 0;
//
//            int sum = 0;
//            for (int num : nums) {
//                sum += num;
//                if (map.containsKey(sum)) {
//                    int value = map.get(sum);
//                    map.replace(sum, value + 1);
//                } else {
//                    map.put(sum, 1);
//                }
//            }
//
//
//            sum = 0;
//            for (int i = 0; i < nums.length; i++) {
//                //pre(i)
//                sum = sum + nums[i];
//                if (map.containsKey(k + sum - nums[i])) {
//                    res += map.get(k + sum - nums[i]);
//
//                }
//            }
//            return res;
//        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}