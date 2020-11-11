#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Nov 30 09:51:04 2019

@author: tanvirkaur
"""

# time complexity = O(n)
# space comlexity = O(n)
# Optimized algorithm
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        x = max(nums)
        dp = [0]* (x+1)
        for num in nums:
            dp[num] += num
        choose = 0
        notchoose = 0
        for i in range(1,len(dp)):
            temp_choose = dp[i] + notchoose
            temp_notchoose = max(choose, notchoose)
            choose = temp_choose
            notchoose = temp_notchoose
        return max(choose,notchoose)