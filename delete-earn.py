'''
Approach:
This problem is a variation of the House Robber problem. We first count the total points for each unique number
and sort the unique numbers. If two consecutive numbers appear, we must decide whether to take the current number
and skip the previous (earn1 + current sum), or skip the current (earn2). If they are not consecutive, we can safely add the current sum to earn2.

Time Complexity: O(n log n) – due to sorting the unique numbers
Space Complexity: O(n) – for storing the count of each number
'''

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        count = Counter(nums)
        nums = sorted(set(nums))  # Sort unique numbers

        earn1, earn2 = 0, 0  # earn1 = dp[i-2], earn2 = dp[i-1]
        for i in range(len(nums)):
            curSum = nums[i] * count[nums[i]]
            if i > 0 and nums[i] == nums[i - 1] + 1:
                temp = earn2
                earn2 = max(earn2, earn1 + curSum)
                earn1 = temp
            else:
                temp = earn2
                earn2 += curSum
                earn1 = temp

        return earn2
