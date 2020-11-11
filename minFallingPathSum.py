# Time Complexity : Brute Force: O(m*3^n)
# Space Complexity : Brute Force: O(m*3^n)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : -

class Solution(object):
    def __helper(self, A, row, column):
        if column == len(A[0]) or column < 0:
            return float('inf')
        if row == len(A)-1 :
            return A[row][column]
        left = self.__helper(A, row + 1, column - 1)
        bottom = self.__helper(A, row + 1, column)
        right = self.__helper(A, row + 1, column + 1)
        return A[row][column] + min(left,bottom,right)
    
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        minAmount = float('inf')
        for i in range(len(A[0])):
            minAmount = min(minAmount, self.__helper(A,0,i))
        return minAmount