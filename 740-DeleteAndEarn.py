# T.C =>O(maxVal)
# S.C => O(maxVal)
# Approach => We ahve created an array with length of maxVal in array. At every index we have stored the sum of that val in that particular index. the we are building the main logic of weather skipping or taking that element. If we skip we store that in temp. For every skip we are taking max of skip or the take. and for every take we are adding the temp value plus current value. in this way we are returning the max value among skip and take.
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        maxVal = -10 **100
        for i in nums:
            maxVal = max(maxVal, i)
        print(maxVal)
        dp = [0] * (maxVal + 1)
        for num in nums:
            dp[num] = dp[num] + num
        
        print(dp)
        skip = 0
        take = dp[0]
        for i in range(0, maxVal + 1):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]
            
        return max(skip, take)