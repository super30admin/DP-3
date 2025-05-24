
"""
Approach: take a counts of all the numbers and start from the max number and if we choose to delete an element then delete all elements of
same value. and go to num - 2 if present. if not deleting the current element then go to num - 1.
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        counts = collections.defaultdict(int)
        maxNum = 0
        n = len(nums)
        for i in range(n):
            counts[nums[i]] += 1
            maxNum = max(maxNum, nums[i])
        dp = [-1 for i in range(maxNum + 1)]
        
        def recurse(num):
            if num <= 1:
                return counts[num] * num

            if dp[num] != -1:
                return dp[num]

            if num not in counts:
                dp[num] = recurse(num - 1)
                return dp[num]

            ret = 0
            ret = (counts[num] * num) + recurse(num - 2)
            ret = max(ret, recurse(num - 1))
            dp[num] = ret
            return ret
        return recurse(maxNum)