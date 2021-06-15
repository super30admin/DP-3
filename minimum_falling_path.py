class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        #defining a DP array initial value to 0
        dp = matrix[0]
        #storing the length of the row
        col = len(matrix[0])
        #Looping over the matrix length
        for r in range(1,len(matrix)):
            #storing the val plus the min value in the next rows
            dp = [val + min(dp[max(0,c-1)],dp[c],dp[min(col-1,c+1)]) for c,val in enumerate(matrix[r])]
        
        #returning the minimum
        return min(dp)


#This problem finds out the minimum value in the given matrix with the diff between col can be atmost one.
# Time complexity - O(n^2)
# Space complexity - O(1)

