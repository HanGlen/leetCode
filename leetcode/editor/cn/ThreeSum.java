package leetcode.editor.cn;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6752 👎 0

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = solution.threeSum(nums);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public List<List<Integer>> threeSum(int[] nums) {
//            Arrays.sort(nums);
//            HashMap<Integer, Integer> map = new HashMap<>();
//            HashSet<List<Integer>> res = new HashSet<>();
//            for (int t = 0; t < nums.length; t++) {
//                map.put(t, nums[t]);
//            }
//            int i = 0;
//            int j = nums.length - 1;
//            while (i != j) {
//                map.remove(i);
//                map.remove(j);
//                if (map.containsValue(-(nums[i] + nums[j]))) {
//                    List<Integer> ress = Arrays.asList(nums[i], -(nums[i] + nums[j]), nums[j]);
//                    res.add(ress);
//
//                }
//                if (nums[i] + nums[j] <= 0) {
//                    i++;
//                } else {
//                    j -= 1;
//                }
//            }
//
//            for (int t = 0; t < nums.length; t++) {
//                map.put(t, nums[t]);
//            }
//            i = 0;
//            j = nums.length - 1;
//            while (i != j) {
//                map.remove(i);
//                map.remove(j);
//                if (map.containsValue(-(nums[i] + nums[j]))) {
//                    List<Integer> ress = Arrays.asList(nums[i], -(nums[i] + nums[j]), nums[j]);
//                    res.add(ress);
//
//                }
//                if (nums[i] + nums[j] < 0) {
//                    i++;
//                } else {
//                    j -= 1;
//                }
//            }
//            return new ArrayList<>(res);
//
//        }
//        public List<List<Integer>> threeSum(int[] nums) {
//            Arrays.sort(nums);
//            HashSet<List<Integer>> res = new HashSet<>();
//            int j = nums.length - 1;
//            int i = 0;
//
//            while (nums[i] < 0) {
//                while (nums[j] >= 0) {
//                    int target = -(nums[i] + nums[j]);
//                    if (target < nums[j]) {
//                        j = nums.length - 1;
//                        break;
//                    }
//
//                    if (map.containsValue(target)) {
//                        List<Integer> b = List.of(nums[i], target, nums[j]);
//                        res.add(b);
//                    }
//                    j -= 1;
//                }
//                i += 1;
//            }
//
//            return new ArrayList<>(res);
//        }
        //以上方法都是定住2找1，应当定1找2
        public List<List<Integer>> threeSum(int[] nums) {
            int i = 0;
            int len = nums.length;
            HashSet<List<Integer>> res = new HashSet<>();
            Arrays.sort(nums);

            while (nums[i] <= 0 && i < len - 2) {
                int l = i + 1;
                int r = len - 1;
                while (l < r) {
                    if (nums[i] + nums[r] + nums[l] == 0) {
                        List<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[r]);
                        a.add(nums[l]);
                        res.add(a);
                        l++;
                        r--;
                    } else if (nums[i] + nums[r] + nums[l] < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
                i++;


            }
            return res.stream().toList();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}