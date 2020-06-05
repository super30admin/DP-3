# Time Complexity : O(n X n) [n = number of elements in the list A]
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 


# Your code here along with comments explaining your approach
# 1. Start with row 1 and move down to the last row in the input list A
# 2. For cell in the 2D grid, there are three possible ancestors from the previous row. 
# 3. We select the minimum values ancestor for each cell and add to its value
# 4. To Find the min path sum, we just need to find minimum in the last row.
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:return 0
        ancestors = [[-1,-1], [-1,0], [-1, 1]]
        for i in range(1, len(A)):
            for j in range(len(A[i])):
                curr = float(inf)
                for ancestor in ancestors:
                    # check if the ancestor is valid and exist in grid
                    if i+ancestor[0] >= 0 and j+ancestor[1] >= 0 and j+ancestor[1] < len(A[i]):
                        # Add the minimum ancestor value from the previous row
                        curr = min(curr, A[i][j] + A[i+ancestor[0]][j+ancestor[1]])
                A[i][j] = curr
        
        # Find minimum in the last row
        res = float(inf)
        for i in range(len(A[0])):
            res = min(res, A[len(A)-1][i])
        return res