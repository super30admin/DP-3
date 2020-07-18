# APPROACH 1: BRUTE FORCE (RECURSION)
# Time Complexity : O(2^n) n: number of row / column of A
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : NO (TIME LIMIT EXCEEDED)
# Any problem you faced while coding this : Yes (to visualise the tree)
#
#
# Your code here along with comments explaining your approach
# 1. Create a binary tree by recursion with 1st node being each of the elements of the first row of A.
# 2. To build each tree - keep track of the previous column from wihich the node is coming. 
# 3. If the column is first - min(0, 1 column elements), if last column - then min (last two column elements of that row) else, it will be min(of all 3 columns - j-1, j, j+1)
# 4. Take min of all trees and within tree also. 

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        result = []
        for ind in range(len(A[0])):
            elem = self.helper(A, A[0][ind], 1, ind)
            result.append(elem)
            
        return min(result)
    
    def helper(self, A, current_cost, curr_row, prev_col):
        
        if curr_row == len(A):
            return current_cost
        
        case_1, case_2, case_3 = float('inf'), float('inf'), float('inf')
        
        if prev_col == 0:
            case_1 = min(self.helper(A, current_cost + A[curr_row][0], curr_row + 1, 0), self.helper(A, current_cost + A[curr_row][1], curr_row + 1, 1))
            
        elif prev_col == len(A) - 1:
            case_2 = min(self.helper(A, current_cost + A[curr_row][len(A) - 2], curr_row + 1, len(A) - 2), self.helper(A, current_cost + A[curr_row][len(A) - 1], curr_row + 1, len(A) - 1))
            
        else:
            case_3 = min(self.helper(A, current_cost + A[curr_row][prev_col - 1], curr_row + 1, prev_col - 1), self.helper(A, current_cost + A[curr_row][prev_col], curr_row + 1, prev_col), self.helper(A, current_cost + A[curr_row][prev_col + 1], curr_row + 1, prev_col + 1))
            
        return min(case_1, case_2, case_3)
        
        
        
# APPROACH  2: DYNAMIC PROGRAMMING
# Time Complexity : O(n^2), n: number of row / column of A
# Space Complexity : O(1) as we are modifying the input matrix itself
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Modify in-place. Each cell value indicates the minimum cost taken to reach that element. (Consider only the previous row)
# 2. If the column is first - min(0, 1 column elements), if last column - then min (last two column elements of that row) else, it will be min(of all 3 columns - j-1, j, j+1)
# 3. Result is the min of the last row of A. 


class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        if not A:
            return 0
        
        for row in range(1, len(A)):
            for column in range(len(A[0])):
                
                if column == 0:
                    A[row][column] += min(A[row - 1][0], A[row - 1][1])
                    
                elif column == len(A[0]) - 1:
                    A[row][column] += min(A[row - 1][column - 1], A[row - 1][column])
                    
                else:
                    A[row][column] += min(A[row - 1][column - 1], A[row - 1][column], A[row - 1][column + 1])
                    
        return min(A[-1])
                
        
        
