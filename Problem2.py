#Time complexity: O(n^2) as we traverse through the entire array
#Space complexity: O(1) no extra space used

#Accepted on Leetcode

#Approach:
#Starting from 1st row, minimum at each index of the row will be the minimum of the previous 2/3 valid 'minimum falling path sums' (MFPS)
#MFPS for 0th row will be the numbers itself
#In this way, compute MFPS from 1st row to last row and then take MFPS of the last row as the global minimum

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(1, len(matrix)):
            for j in range(0, len(matrix[0])):
                leftDiag = float('inf') if j == 0 else matrix[i-1][j-1]
                top = matrix[i-1][j]
                rightDiag = float('inf') if j == len(matrix[0]) - 1 else matrix[i-1][j+1]
                matrix[i][j] = matrix[i][j] + min(leftDiag, top, rightDiag)

        mfps = float('inf')
        for j in range(len(matrix[0])):
            mfps = min(matrix[len(matrix)-1][j], mfps)
        return mfps

#TC1
#[[3][2]]
# i = 1, j = 0, lD = inf, top = 3, rD = inf, m[1][0] = 2 + 3 = 5
# j = 0, mfps = min(m[1][0], inf) = 5


