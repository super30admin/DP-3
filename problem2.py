class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
            if len(matrix)==0:
                return 0
            if len(matrix)==1:
                return min(matrix[0])
            
            for i in range(1,len(matrix)):
                for j in range(0,len(matrix[i])):
                    if j==0:
                        
                        matrix[i][j]+=min(matrix[i-1][j:j+2])
                    elif j==len(matrix[i])-1:
                        matrix[i][j]+=min(matrix[i-1][j-1:j+1])
                    else:
                        matrix[i][j]+=min(matrix[i-1][j-1:j+2])
            return min(matrix[len(matrix)-1])
        #Time O(n)
        #Space O(1), no space used matrix itself modified
        #Ran successfully
        #https://leetcode.com/problems/minimum-falling-path-sum/
