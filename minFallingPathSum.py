class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        """
        # Top-down approach:

        #Time complexity: O(kn)
        k is len of subarray

        #Space Complexity
        O(n)

        Failed test case for [[51,24],[-50,82]]
        """
        def findMin(i,j):
            # base case
            if i<0 or i>=row or j<0 or j>=column:
                return float('inf') #as we are finding min shouldn't return 0
            
			# base case eg. [[1,2,3],[4,5,6],[7,8,9]] -> A[2]
            if i==row-1:
                return A[i][j]
			
            if dp[i][j]!=0:
                return dp[i][j]
            
            dp[i][j]=A[i][j]+min(findMin(i+1,j),findMin(i+1,j+1),findMin(i+1,j-1))
            return dp[i][j]
            
        row,column=len(A),len(A[0])
        min_score= float('inf')
        dp=[[0 for _ in range(column)] for _ in range(row)] # [[0,0,0],[0,0,0],[0,0,0]]
        
        for j in range(column):
            min_score=min(min_score,findMin(0,j))
            return min_score