#time complexity:O(n*n), have to go through whole matrix
#space complexity:o(1) , storing everything in matrix itself
#passed all cases on LeetCode: yes
#difficulty faced:-
# comments:
#https://leetcode.com/problems/minimum-falling-path-sum/
class Solution:
    def minFallingPathSum(self, matrix: 'List[List[int]]') -> int:
        
        
        n = len(matrix)
        #starting from n-2 row we are going to add min value from row below
        #this way when we reach top row we would have
        
        for i in range(n-2,-1,-1):
            for j in range(0,n):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])
                    
        min1 = float('inf')
        for j in range(n):
            min1 = min(min1, matrix[0][j])
        return min1
            
            