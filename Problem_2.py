# 931. Minimum Falling Path Sum

# code:
class Solution:
    def minFallingPathSum(self, arr: List[List[int]]) -> int:
        
        # Edge cases
        if not arr or len(arr[0])==0:
            return 0
        
        # Iterate over the entire grid and keep checking with the above row.
        for i in range(1, len(arr)):
            for j in range(0, len(arr[0])):
                if j==0:
                    arr[i][j] += min(arr[i-1][j],arr[i-1][j+1])
                elif j==len(arr[0])-1:
                    arr[i][j] += min(arr[i-1][j],arr[i-1][j-1])
                else:
                    arr[i][j] += min(arr[i-1][j], min(arr[i-1][j-1],arr[i-1][j+1]))
        
        # Initalizing min to maximum value.
        res = float('inf')
        
        # Iterative over the last row to ge the minimum
        for i in arr[-1]:
            if i<res:
                res = i
        
        return res
        

# Time Complexity: O(N*M).
# Space Complexity: O(1).
# Accepted on Leetcode: Yes.
# Any Difficulty faced. No.