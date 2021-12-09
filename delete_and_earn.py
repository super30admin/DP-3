'''
// Time Complexity : O(max(n, highest element))
// Space Complexity : O(max(n, highest element))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
Approach: transform and conquer. Solve using DP
1.  Create a preprocessed array length(maximum points). 
    the index of this array is the "points" selected
2.  Fill up this pre-processed array as total earning based on points
3.  create 1D DP array
4.  Solve DP, at each step, compare 2 choices, whichever maximum:
    either take current value + with previous 2 steps or
    skip current value, copy previous value of 1 step behind
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # TC: O(max(n, highest element)), SC: O(max(n, highest element))
        #create pre-processed array
        arr = [0] * (max(nums) + 1)
        for num in nums:
            arr[num] += num
        
        #create a dp array and loop it
        dp = [0] * len(arr)
        dp[1] = arr[1]
        
        for i in range(2, len(arr)):
            dp[i] =  max(arr[i] + dp[i-2], dp[i-1])
        
        #answer
        return dp[-1]