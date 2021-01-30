//Approach is exactly same as house-paint problem
// Time Complexity : O(n*m)
// Space Complexity : O(1)  as we are modifying the input list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix)==0 or len(matrix[0])==0:
            return 0
        n=len(matrix)
        m=len(matrix[0])
        for i in range(1,n):
            for j in range(m):
                if j==0:
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i-1][j+1])    // if we choose first coloumn then for next row we just have to choose from current j and j+1 coloumn
                elif j==m-1:
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i-1][j-1])    // if we choose last coloumn then for next row we just have to choose from current last i.e, j and j-1 coloumn
                else:
                    matrix[i][j]+=min(min(matrix[i-1][j],matrix[i-1][j-1]),matrix[i-1][j+1]) // if we choose mid coloumns (from 2 to 2nd last coloumn) then for next row we just have to choose from current j-1 ,j and j+1 th coloumn
        return min(matrix[n-1])
