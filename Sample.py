// Time Complexity : O(n) + max(n)
// Space Complexity : max(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

// convert the nums arr to a bucket sorted list. Then apply same approach as house robbing.

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_num = max(nums)
        arr = [0] * (max_num + 1) 
        for i in nums:
            arr[i] += i

        dp=[0] * (max_num+1)
        dp[0] = arr[0]
        dp[1] = max(arr[0],arr[1])
        for i in range(2,len(dp)):
            dp[i] = max(dp[i-1],arr[i]+dp[i-2])  
        return dp[-1]

// Time Complexity : O(n^2)
// Space Complexity : max(1)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)

        for r in range(1, n):
            for c in range(n):
                best_above = matrix[r - 1][c]

                if c > 0:
                    best_above = min(best_above, matrix[r - 1][c - 1])
                if c < n - 1:
                    best_above = min(best_above, matrix[r - 1][c + 1])

                matrix[r][c] += best_above
        
        return min(matrix[-1])
        