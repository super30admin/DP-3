# time complexity: O(max(nums))+O(len(nums)) whichever is greater
# space complexity: O(max(nums)) - to create dp array
# approach:
# first create a dp array with length of largest element in array +1
# update the dp array with count of the index as value in array with * value
# use robber problem technique-using skip and take from dp array
# initialise skip and take as 0 and dp[0]
# update skip with max value of prev skip and take
# update take with prev skip and present value of dp
# return max of skip and take in the end



class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        maxnum = -math.inf
        for num in nums:
            maxnum = max(num, maxnum)
        dp = [0 for i in range(maxnum+1)]
        for num in nums:
            dp[num] = dp[num]+num
        skip = 0
        take = dp[0]
        # print(take)
        for i in range(1,maxnum+1):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]
        return max(skip, take)
        
        
        