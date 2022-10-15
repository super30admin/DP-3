class Solution:
    # leetcode URL : https://leetcode.com/problems/minimum-falling-path-sum/
    # Problem : 931. Minimum Falling Path Sum
    # Time Complexity : O(mn) - where m is len of matrix and n is depth of matrix
    # Space Complexity : O (1) - no extra space
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(1,len(matrix)):
            for j in range(0,len(matrix[i])):
                sum_amount = 0
                if j == 0 and j == len(matrix[i])-1:
                    sum_amount = matrix[i-1][j]
                elif j == 0:
                    sum_amount = min( matrix[i-1][j], matrix[i-1][j+1])
                elif j == len(matrix[i])-1:
                    sum_amount = min( matrix[i-1][j], matrix[i-1][j-1])
                else:
                    sum_amount = min( matrix[i-1][j-1] ,matrix[i-1][j] ,matrix[i-1][j+1])
                # would not need so many conditions if i append zero to left and right of each list in the 2D array
                matrix[i][j] = matrix[i][j] + sum_amount
        return min(matrix[len(matrix)-1])