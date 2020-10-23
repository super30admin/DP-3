# Time Complexity: O(n)
# Space Complexity: O(10001), this can be optimized by storing the nums in a sorted map but this would increase TC to O(n*logn)
# Did this run on leetcode: yes
# Did you face any issues: No
# Approach:
#     - This problem can be transformed into the house robber problem by transforming the nums array into buckets
#     - The buckets map the index of an element to the element and it's count
#     - Falling back on the house robber approach, if a number from a bucket at index i is chosen, we consult the solution at (i-2)th index
#     - If it is not chosen we consult the solution of (i-1)th index

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Radix Sort
        buckets = [0]*10001
        for i in range(len(nums)):
            buckets[nums[i]] += nums[i]
        dp = [0]*3
        dp[0] = buckets[0]
        dp[1] = max(buckets[0], buckets[1])
        for i in range(2, len(buckets)-1):
            dp[i % 3] = max(dp[(i-1) % 3], dp[(i-2) % 3] + buckets[i])
        return dp[(len(buckets)-1) % 3]
