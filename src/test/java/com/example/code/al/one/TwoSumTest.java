package com.example.code.al.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class TwoSumTest {

    int[] nums = new int[]{2, 7, 11, 15};
    int target = 9;

    @Test
    void solution1() {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.solution1(nums, target);
        log.info("solution1:{}", ints);
    }

    @Test
    void solution2() {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.solution2(nums, target);
        log.info("solution1:{}", ints);
    }

}