package com.example.code.al.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 10^4
 * <p>
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * -10^9 <= target <= 10^9
 * <p>
 * 只会存在一个有效答案
 * <p>
 * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
 *
 * @author gdLiu
 */
public class TwoSum {

    /**
     * 方式一：暴力法，时间复杂度O(n^2)
     * <p>
     * 从左到右依次寻找,如果找到相加等于target的数，则返回
     *
     * @param nums   数组
     * @param target 和
     * @return int[]
     * @author gdLiu
     * @date 2022/3/17 14:19
     */
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 方式二：哈希表，时间复杂度O(n)
     * <p>
     * 将数组中的数字和下标存入哈希表，遍历数组，如果哈希表中存在target-当前数字的值，则返回
     *
     * @param nums   数组
     * @param target 和
     * @return int[]
     * @author gdLiu
     * @date 2022/3/17 14:34
     */
    public int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
