# TC : O(max(max_element, n)) ; n = size of array
# SC : O(max_element)
# Approach : We store sum of all occurences of a number at its index in an array, where size of array is max 
# element in input array. Then we use two variables, to whether to skip or take value, and take max at each iteration. 
# We return max of skip and take in the end.
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        Max = max(nums)
        dp = [0 for i in range(Max + 1)]
        for num in nums:
            dp[num] += num
        
        skip = 0 ; take = 0
        for i in range(len(dp)):
            temp = max(skip, take)
            take = skip + dp[i]
            skip = temp
        
        return max(skip, take)