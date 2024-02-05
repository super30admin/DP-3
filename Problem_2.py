'''
Time Complexity - O(n^2) as we are traversing the entire matrix and then we traverse the last row to find the min
Space Complexity - O(n^2) if we use matrix to store the repeated subproblems result. O(N) if we use 2 arrays to store the repeated subproblems like in this case.

This code works on Leetcode.
'''


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        #dp = [[1e9 for j in range(len(matrix[0]))] for i in range(len(matrix))]
        prev = matrix[0] #initially result is same as that of the first row of the matrix
        for i in range(1, len(matrix)):
            curr = [1e9 for k in range(len(matrix[0]))] #before the calculting the result set the value to be the maximum
            for j in range(0, len(matrix[0])):
                left, right, up = 1e9, 1e9, 1e9 #set the left, right and mid to be an initial value
                if j - 1 >= 0: #covers the edge case of going left but out of matrix
                    left = prev[j-1] 
                if j + 1 < len(matrix[0]): # covers the edge case of going right but out of matrix 
                    right = prev[j+1]
                up = prev[j]
                curr[j] = matrix[i][j] + min(left, right, up) #current value is minimum of that coming from the left right and up + the value at current index
            prev = curr
        minSum = 1e9 #set initial minimum value present in the last row
        for j in range(len(prev)):
            minSum = min(minSum, prev[j])
        return minSum # the minimum falling path some is the present in the last row of the matrix that we return
                

        