#TimeComplexity: O(MN) 
#SpaceComplexity: O(MN) DP array 
#It successfully runs on leetcode


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp=[[0 for i in range(len(matrix[0]))] for j in range(len(matrix))]
        dp[0]=matrix[0]
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):    
                #if only one column is there           
                if j==0 and j==len(dp[0])-1:
                    dp[i][j]= matrix[i][j]+ dp[i-1][j]
                # for the first column
                elif j==0:
                    dp[i][j]= matrix[i][j]+ min(dp[i-1][j+1], dp[i-1][j])
                #for the last column
                elif j==len(dp[0])-1:
                    dp[i][j]= matrix[i][j]+ min(dp[i-1][j-1], dp[i-1][j])
                #For rest of cases
                else:
                    dp[i][j]= matrix[i][j]+ min(dp[i-1][j-1], dp[i-1][j+1], dp[i-1][j])
        return min(dp[-1])