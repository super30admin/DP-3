class Solution:
    # time - O(N), space - O(1)
    # Accepted in leetcode
    # For this problem , either we have to consider a number or we have to skip it. But as the data is not properly ordered and we have to increase the sum by number of times it appears.
    def deleteAndEarn(self, nums) -> int:
        dp = [] # create a dp array 10000 items.
        for i in range(10001):
            dp.append(0)
        for num in nums:
            # fill it will all the number and their sum if they appears more than once in the index
            dp[num] = dp[num] + num
        take = 0
        skip = 0
        for i in range(len(dp)):
            curr_skip = max(take, skip) # if num not selected, choose max of take and skip
            curr_take = dp[i] + skip # if selected, the add current number with previous skipped element
            skip = curr_skip
            take = curr_take
        return max(take,skip) # at the end return max of last take and skip items

s = Solution()
print(s.deleteAndEarn([3,4,2,2,5,6,3,7]))