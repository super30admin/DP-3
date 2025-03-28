from typing import List

# Dynamic Programming approach
# Time Complexity: O(n) where n is the length of the input array
# Space Complexity: O(max(nums)) where nums is the input array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach:
# 1. We notice that deleting one element will eliminate all elements one count before and after it.
# 2. If we choose the current element, we can't choose the adjacent elements.
# 3. We process the array to hold the sum of element at that index. This helps us keep track of which elements are being deleted.
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = max(nums)+1
        # dp array to store the sum of elements at that index
        dp = [0] * n
        # process the array to hold the sum of element at that index
        for num in nums:
            dp[num] += num
        # initialize prev and curr variables
        prev = dp[0]
        curr = max(prev, dp[1])

        for i in range(2, len(dp)):
            # Before updating the current house, we will store the previous house's amount in a temporary variable.
            tmp = curr
            curr = max(curr, prev + dp[i])
            # We will update the previous house with the temporary variable.
            prev = tmp
        return curr

# Space optimized Dynamic Programming approach
# Time Complexity: O(max(n)) where n is the length of the input array
# Space Complexity: O(n) where n is the length of the input array
# Approach:
# We will use bucket sort to store the sum of elements at that index.
# We will use 2 variables to store the maximum amount of money that can be robbed from the houses.
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = max(nums)+1
        dp = {}
        mn = float('inf')
        mx = float('-inf')

        for num in nums:
            dp[num] = num + dp.get(num, 0)
            mn = min(mn, num)
            mx = max(mx, num)

        prev = dp[mn]
        curr = prev
        if mn+1 in dp:
            curr = max(prev, dp[mn+1])
        
        for i in range(mn+2, mx+1):
            tmp = curr
            if i in dp:
                curr = max(curr, prev + dp[i])
            else:
                curr = max(curr, prev + 0)
            prev = tmp
        return curr

# Recursive approach
# Time Complexity: O(2^n) where n is the length of the input array
# Space Complexity: O(max(nums)) where nums is the input array
# Did this code successfully run on Leetcode : No, Time Limit Exceeded
# Any problem you faced while coding this : No
# Approach:
# 1. At each step, we have two choices, either to choose the element or not choose the current element.
# 2. If we choose the current element, we cannot choose the element next to it.
# 3. We will recursively call the function with the current index and the earnings.
# 4. We will return the maximum earnings possible.
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = max(nums)+1
        dp = [0] * n
        for num in nums:
            dp[num] += num
        # let's code up the recursive approach
        def dfs(i, earnings):

            # base case
            if i >= len(dp):
                return earnings
            # At each step, we have two choices, either to choose the element or not choose the current element.
            no_choose = dfs(i+1, earnings)
            # If we choose the current element, we cannot choose the element next to it.
            choose = dfs(i+2, dp[i]+earnings)

            return max(no_choose, choose)
        return dfs(0, 0)