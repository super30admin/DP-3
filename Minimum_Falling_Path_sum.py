#time complexity: O(n*n)
#space complexity: O(1)
#leetcode submission:successful

class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
      #  a=len(A)
      #we are starting from the second row as we keep the 1 row as our base case
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                #checking edge cases
                if j == 0:
                    A[i][j]  = min((A[i][j] + A[i - 1][j]), (A[i][j] + A[i - 1][j + 1]) )
				#checking the other edge case
                elif (j == len(A[0]) - 1):
                    A[i][j]  = min((A[i][j] + A[i - 1][j]), (A[i][j] + A[i - 1][j - 1]) )
				
                else:
                    A[i][j] = min(A[i][j] + A[i - 1][j],A[i][j] + A[i - 1][j + 1], A[i][j] + A[i - 1][j - 1])
        
        return min(A[len(A) -1])