package com.example.code.al.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class LengthOfLongestSubstringTest {

    private String s1 = "abcabcbb";
    private String s2 = " ";

    @Test
    void solution1() {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        log.info("solution1:{}", lengthOfLongestSubstring.solution1(s2));
    }

    @Test
    void solution2() {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        log.info("solution1:{}", lengthOfLongestSubstring.solution2(s2));
    }
}