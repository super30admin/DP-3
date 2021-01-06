#Time : O(Max(max(nums), n)) max element and len of nums
#Space: O(max(n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # Check base case
        if nums == None or len(nums) == 0:
            return 0
        
        #Create a auxiliary array with max nums + 1
        freq = [0] * (max(nums) + 1)
        
        for n in nums:
            freq[n] += n
         
        # Reduced to house robber problem
        dp = [freq[0], max(freq[0], freq[1])]
            
        for i in range(2, len(freq)):
            dp.append(max(dp[i-2] + freq[i], dp[i-1]))
        return dp[-1]
