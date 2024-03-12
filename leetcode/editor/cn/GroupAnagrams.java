package leetcode.editor.cn;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1840 👎 0

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution.groupAnagrams(strs);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] charStr = str.toCharArray();
                Arrays.sort(charStr);
                String key = Arrays.toString(charStr);

                if (map.isEmpty()) {
                    ArrayList<String> value = new ArrayList<>();
                    value.add(str);
                    map.put(key, value);
                } else {
                    if (map.containsKey(key)) {
                        List<String> val = map.get(key);
                        val.add(str);
                        map.put(key, val);
                    } else {
                        ArrayList<String> value = new ArrayList<>();
                        value.add(str);
                        map.put(key, value);
                    }
                }

            }
            return new ArrayList<List<String>>(map.values());

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}