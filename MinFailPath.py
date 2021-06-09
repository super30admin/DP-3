#Time complexity: O(n*n)   
#Space complexity: O(n*n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        #make another 2d array of same dimenesions
        dp = [[0 for el in xrange(len(matrix[0]))] for el in xrange(len(matrix))]
        
        #last row same as matrix, bottom up dp
        for idx,el in enumerate(matrix[-1]):
            dp[-1][idx] = el
        
        #iterate from second last row to first row in the dp array
        for i in xrange(len(dp)-2,-1,-1):
            # unlike paint house, this has n elements, so another loop to iterate
            for j in xrange(len(dp[0])):
                #take minimum of below row elements, and add it to item
                #considering edge cases too
                if j==0:
                    dp[i][j] = matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1])
                elif j==len(dp[0])-1:
                    dp[i][j] = matrix[i][j]+min(dp[i+1][j],dp[i+1][j-1])
                else:
                    dp[i][j] = matrix[i][j]+min(dp[i+1][j],dp[i+1][j-1],dp[i+1][j+1])
        #minimum of the first row of the new array would have the min falling path sum
        return min(dp[0])