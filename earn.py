"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        counter = [0] * 10001
        take = 0
        skip = 0
        for num in nums:
            counter[num] += num
        
        # Loop through n buckets and choose to take n or skip n based on if skipping is better or taking is better
        for i in range(10001):
            takei = skip + counter[i]
            skipi = max(skip, take)
            take = takei
            skip = skipi
            
        return max(take, skip)
    
    