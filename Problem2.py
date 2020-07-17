#Time complexity: O(n*n) where  n is the length of square array
#Space complexity: O(n) where  n is the length of square array
#Works on leetcode: yes
#Approach:This is similar to house painting cost. The only difference is the choice must from previous row from 
# columns which are at most 1 column away. The current value is the sum of current row-column from A and minimum of 
# columns from previous row which are at most 1 column away from current row-column. First and last columns make the edge cases

    
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        #Function to find  the minimum sum of a falling path through A.
        if not A:
            return 0
        dp = A[0]
        for i in range(1,len(A)):
            prev = dp[:]
            for j in range(len(A[0])):
                if j==0:
                    dp[j] = A[i][j] + min(prev[j], prev[j+1])
                elif j==(len(A[0])-1):
                    dp[j] = A[i][j] + min(prev[j], prev[j-1])
                else:
                    dp[j] = A[i][j] + min(prev[j], prev[j+1], prev[j-1])
        return min(dp)