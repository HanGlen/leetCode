package leetcode.editor.cn;

//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4897 👎 0

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //chao shi
//        public int maxArea(int[] height) {
//            int v, i = 0;
//            int h, w = 0;
//            int maxV = 0;
//            while (i < height.length) {
//                for (int j = i; j < height.length; j++) {
//                    if (j == i) {
//                        continue;
//                    } else {
//                        w = j - i;
//                        h = Math.min(height[i], height[j]);
//                        v = w * h;
//                        maxV = Math.max(v, maxV);
//                    }
//                }
//
//                i++;
//
//            }
//            return maxV;
//
//        }
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int maxV = 0;
            while (i != j) {
                maxV = Math.max(maxV, Math.min(height[i], height[j]) * (j - i));
                if (height[i] <= height[j]) {
                    i++;
                } else {
                    j -= 1;
                }
            }
            return maxV;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}