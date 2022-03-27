package com.example.code.al.one;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * <p>
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * <p>
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * <p>
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * <p>
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 *
 * @author gdLiu
 */
public class LengthOfLongestSubstring {

    /**
     * 暴力破解
     * <p>
     * 效果不好，时间复杂度O(n^2)
     *
     * @param s 字符串
     * @return int
     * @author gdLiu
     * @date 2022/3/24 14:11
     */
    public int solution1(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
            }
            if (set.size() > max) {
                max = set.size();
            }
        }
        return max;
    }

    /**
     * 基于解法1的优化
     * <p>
     * 时间复杂度O(n)
     *
     * @param s 字符串
     * @return int
     * @author gdLiu
     * @date 2022/3/27 9:26
     */
    public int solution2(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
