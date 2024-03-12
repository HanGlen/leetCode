package leetcode.editor.cn;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2010 👎 0

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int res = solution.longestConsecutive(nums);
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer, int[]> map = new HashMap<>();
            Map<Integer, Integer> numsMap = new HashMap<>();
            int res = 0;
            for (int i : nums) {
                if (numsMap.containsKey(i)) {
                    continue;
                } else {
                    numsMap.put(i, i);
                }
                //i是大数
                if (map.containsKey(i - 1) && !map.containsKey(i + 1)) {

                    int[] value = map.get(i - 1);

                    //老端点
                    int smallOld = value[0];
                    int bigOld = value[1];

                    //目前的端点值
                    int small = value[0];
                    int big = i;
                    int size = value[2] + 1;
                    int[] resValue = {small, big, size};

                    //端点值
                    if (size > res) {
                        res = size;
                    }

                    //更新端点


                    if (!(smallOld == bigOld)) {
                        //更新前端点
                        map.remove(smallOld);
                        map.remove(bigOld);
                        map.put(small, resValue);

                        //更新后端点

                        map.put(big, resValue);
                    } else {
                        //更新前端点
                        map.remove(smallOld);
                        map.put(small, resValue);

                        //更新后端点
                        map.put(big, resValue);

                    }
                    continue;


                }

                //i是小数
                if (map.containsKey(i + 1) && !map.containsKey(i - 1)) {

                    int[] value = map.get(i + 1);


                    //老端点
                    int smallOld = value[0];
                    int bigOld = value[1];

                    //目前的端点值
                    int small = i;
                    int big = value[1];
                    int size = value[2] + 1;
                    int[] resValue = {small, big, size};


                    //端点值
                    if (size > res) {
                        res = size;
                    }

                    //更新端点
                    if (!(smallOld == bigOld)) {
                        //更新前端点
                        map.remove(smallOld);
                        map.remove(bigOld);
                        map.put(small, resValue);

                        //更新后端点

                        map.put(big, resValue);
                    } else {
                        //更新前端点
                        map.remove(smallOld);
                        map.put(smallOld, resValue);

                        //更新后端点
                        map.put(small, resValue);

                    }
                    continue;


                }
                if (!map.containsKey(i - 1) && !map.containsKey(i + 1)) {
                    int[] o = {i, i, 1};
                    map.put(i, o);
                    if (1 > res) {
                        res = 1;
                    }
                    continue;

                }

                if (map.containsKey(i - 1) && map.containsKey(i + 1)) {
                    int[] value1 = map.get(i - 1);
                    int[] value2 = map.get(i + 1);
                    int[] value3 = {value1[0], value2[1], value1[2] + value2[2] + 1};
                    if (value3[2] > res) {
                        res = value3[2];
                    }

                    map.remove(i + 1);
                    map.remove(i - 1);
                    map.remove(value1[0]);
                    map.remove(value2[1]);
                    //更新前端点
                    map.put(value1[0], value3);

                    //更新后端点
                    map.put(value2[1], value3);
                    continue;

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}