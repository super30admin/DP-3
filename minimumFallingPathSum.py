# // Time Complexity : O(mn) 
# // Space Complexity :O(1) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class solution:
    def minFallingPathSum(self, matrix):
        ## the approach is very similar to paint house. We cannot use the greedy approach here as tchoosing the minimum everytime will not give us the most optimum . So
        ## we have to go for an exhasutive approach. We also see that there will be repeated subproblems that would be covered. So we start off with the 1st row and for each element we check from prev row which is the minimum and add it to the current element
        ## in the last row we return the minimum element
        for i in range(1,len(matrix)):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1])
                elif j == len(matrix[0]-1):
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j-1])
                else:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j-1], matrix[i-1][j+1])
        
        return min(matrix[-1])


