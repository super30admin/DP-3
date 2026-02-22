#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb 22 13:29:02 2026

@author: rishigoswamy

    LeetCode 740: Delete and Earn
    Link: https://leetcode.com/problems/delete-and-earn/
    
    Approach:
    Convert the problem into House Robber (LeetCode 198).
    
    If we pick value x, we earn (x * freq[x]) points, but we lose the ability to pick
    x-1 and x+1 (since they get deleted). That creates an "adjacent conflict" on the
    value line: choosing x conflicts with choosing x-1 and x+1.
    
    So we build an array points[] where:
        points[x] = total points we can earn by taking all occurrences of value x
    
    Then the problem becomes:
        "Choose non-adjacent indices in points[] to maximize sum"
    which is exactly House Robber.
    
    // Time Complexity : O(n + maxVal)
        n = len(nums), maxVal = max(nums)
        - O(n) to build points array
        - O(maxVal) for the DP pass
    // Space Complexity : O(maxVal)
        points array size is maxVal + 1

"""
from typing import List 

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        array = [0] * (max(nums)+1)

        for num in nums:
            array[num] += num
        
        print(array)

        del1 = 0
        del2 = 0
        for i in range(len(array)):

            temp = max(array[i]+ del1, del2)
            del1 = del2
            del2 = temp
        return del2

        

