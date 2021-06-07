"""
Approach: Try to find the pattern and repeated sub-problems to use DP.

see that just by applied the decision making logic on the given array would be difficult. Try to check if this pattern
can be changed. One way would be to modify the array such that the indices of the new array go from 0 to max element of
the given array. Then you store the sum of same valued elements from the given array onto the respective indices.

"""

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        simplified = [0 ] *(max(nums ) +1)
        for i in (nums):
            simplified[i] += i

        # Approach 1:
        """
        return self.helper(simplified, 0, 0)

    def helper(self, nums, index, earned):
        #base
        if index >= len(nums):
            return earned

        #choose  to delete:
        case0 = self.helper(nums, index + 2, earned + nums[index])

        # choose not to delete:
        case1 = self.helper(nums, index + 1, earned)

        return max(case0, case1)
        """
        dp = [[0 ] *2 for _ in range(len(simplified))]
        dp[0][1] =  simplified[0]

        for i in range(len(simplified)):
            dp[i][0] = max(dp[ i -1][0], dp[ i -1][1])
            dp[i][1] = dp[ i -1][0] + simplified[i]
        return max(dp[-1])
"""
Approach 1:
TC: O(2^n)
SC: O(n)
Approach 2:
TC: O(n)
SC: O(n)
"""