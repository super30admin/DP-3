# Problem 1: Delete and Earn -> Time Complexicity: O(max(max(nums),n)), Space Complexicity: O(max(nums))

class Solution:
    
    def deleteAndEarn(self, nums: List[int]) -> int:
    
        """
        Convert the problem to ordinary house robber problem by:
        - placing all the sum of a unique value represented by index of the resulting array
        """
        if len(nums) == 0: return 0
        maximum = 0;
        maximum = max(nums)
        aux_array = [0]*(maximum+1)
        
        for i in nums:
            aux_array[i] += i
            
        skip = 0; take = aux_array[0]
        for i in range(len(aux_array)):
            temp = skip
            skip = max(skip, take)
            take = temp + aux_array[i]
        
        return max(skip, take)

# Problem 2: Minimum falling sum for square matrix -> Time Complexicity: O(n^2), Space Complexicity: O(n^2)

class Solution:
    
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        """
        Solve by creating an square dp array:
        - Start from bottom row of matrix A
        - add minimum values to the sum by using the constraints
        """
        
        if len(A) == 0: return 0
        
        n = len(A)
        dp = [[0 for __ in range(n)] for __ in range(n)] # Initialize
        dp[n-1] = A[n-1] # Start
        
        for row in reversed(range(n-1)):
            for i in range(n):
                if i != 0 and i != n-1:
                    dp[row][i] = min(dp[row+1][i-1], dp[row+1][i], dp[row+1][i+1]) + A[row][i]
                elif i == 0:
                    dp[row][i] = min(dp[row+1][i], dp[row+1][i+1]) + A[row][i]
                elif i == n-1:
                    dp[row][i] = min(dp[row+1][i-1], dp[row+1][i]) + A[row][i]
        
        return min(dp[0])
