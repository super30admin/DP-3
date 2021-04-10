class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        M, N = len(matrix), len(matrix[0])
        dp = matrix[0].copy() # DP Array
        
        # For all rows
        for i in range(1, M):
            new_dp = [] # Dp Update Arrau
            
            # For all cols of given row
            for j in range(N):
                cur_val = matrix[i][j]
                
                # If at first col, just get values at col1 and col2 of dp
                if j==0:
                    min_so_far = min(dp[j], dp[j+1])
                    new_dp.append(cur_val + min_so_far)
                    
                # If at last col, just get values of last two cols of dp
                elif j==N-1:
                    min_so_far = min(dp[j-1], dp[j])
                    new_dp.append(cur_val + min_so_far)
                    
                # Get min of all three cols i.e. col-1, col, col+1 of dp
                else:
                    min_so_far = min(dp[j-1], dp[j], dp[j+1])
                    new_dp.append(cur_val + min_so_far)

            # Update dp
            dp = new_dp
        
        # Return min falling path sum
        return min(dp)

### Complexity Analysis

# Time Complexity: O(MxN) --> Iterating the entire matrix once
# Space Complexity: O(N) --> N = number of cols. Space used for DP array