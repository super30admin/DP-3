"""
Intuition:  Check greedy. Greedy will fail.

We will have to browse all possible comvbinations. (Be exhaustive)

After drawing the recursive tree,we will notice the subproblems.

eg: if given costs = costs = [[2,1,3],[6,5,4],[7,8,9]]
Recursive tree:   2             
                /  \
               6     5 
               /\  / | \
              7 8  7 8 9  

                    1             
                /   |  \  
               6    5    4    
               /\  /|\   /\ 
              7 8  7 8 9 8  9 

We can notice how for subtree 6,5 we have a repeated subproblem.

Start by using a bottom up approach to create the mincost matrix. (we can also do top down)
#####################################################################
For Recursive:
Time Complexity : O(3^N)  N = number of rows
Space Complexity : O(1) 
#####################################################################
For DP Approach: Both top to bottom & bottom to top
Time Complexity : O(N* N)  N = number of rows
Space Complexity : O(1) 
#####################################################################
"""
#Recursive 
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        minCosts = []
        for i in range(len(matrix)):
            minCosts.append(self.helper(matrix, 0, i, 0 ))
        return min(minCosts)
    def helper(self,matrix, row, col, cost ):
        
        if row == len(matrix):
            return cost
        
        else:
            if col == 0:
                case1 = self.helper(matrix, row + 1, 0, cost + matrix[row][col])
                case2 = self.helper(matrix, row + 1, 1, cost + matrix[row][col])
                return min(case1, case2)
            elif col == len(matrix[0]) - 1:
                case1 = self.helper(matrix, row + 1, len(matrix[0]) - 1, cost + matrix[row][col])
                case2 = self.helper(matrix, row + 1, len(matrix[0]) - 2, cost + matrix[row][col])
                return min(case1, case2)
            else:
                case1 = self.helper(matrix, row + 1, col -1, cost + matrix[row][col])
                case2 = self.helper(matrix, row + 1, col, cost + matrix[row][col])
                case3 = self.helper(matrix, row + 1, col + 1, cost + matrix[row][col])
                return min(case1, case2, case3)


#Top Down 
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        
        if len(matrix) == 1:
            return matrix[0][0]
        
        
        for i in range(1, len(matrix)):
            
            for j in range(len(matrix[0])):
                
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][0],matrix[i-1][1] )
                elif j ==  len(matrix[0])-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][len(matrix[0])-1],matrix[i-1][len(matrix[0])-2])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j],matrix[i-1][j-1], matrix[i-1][j+1])
            
        
        return min(matrix[-1])
                    
#Bottom up
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        if len(matrix) == 1:
            return matrix[0][0]
        
        for i in range(len(matrix)-2 , -1, -1):
            
            for j in range(len(matrix[0])):
                print(i,j)
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][0],matrix[i+1][1] )
                elif j ==  len(matrix[0])-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][len(matrix[0])-1],matrix[i+1][len(matrix[0])-2])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j],matrix[i+1][j-1], matrix[i+1][j+1])
            
        return min(matrix[0])
                    
                    