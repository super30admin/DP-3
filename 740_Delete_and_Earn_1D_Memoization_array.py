# Time Complexity : O( max(n, max(nums) )) [n = number of elements in the list nums]
# Space Complexity : O(max(nums)) [Since number of colums are two in dp array we consider it as constant]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. The sub problems are not present in a manner such that numerical neighbours can  be accessed in constant time.
# 2. So the given input is transformed with the help of hash table of size max(nums). Each index stores the total sum of number of occurence for that index. For e.g. in [2 2 3 4 7] at index 2 sum 4 will be stored
# 3. After the transformation, the problem is simplifed as a variant of the House Robber problem
# 4. The memoization is done with the help of an 2D array. For each index the value at previous two indexes helps to decide whether to delete the next val or not

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:return 0
        count_tables = [0 for i in range(max(nums)+1)]
        for num in nums:
            count_tables[num] += num
        dp = [[0 for col in range(2)] for row in range(max(nums)+1)]
        
        for i in range(1, max(nums)+1):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = max(dp[i-1][1], count_tables[i] + dp[i-1][0])
        return max(dp[-1])