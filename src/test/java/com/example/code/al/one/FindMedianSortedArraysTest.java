package com.example.code.al.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class FindMedianSortedArraysTest {

    @Test
    void solution1() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        log.info("{}", findMedianSortedArrays.solution1(nums1, nums2));
    }

    @Test
    void solution2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        log.info("{}", findMedianSortedArrays.solution2(nums1, nums2));
    }
}