# // Time Complexity : O(nm) n is the len of rows, m is len of cols in the matrxi give its a n*n so O(n*2) which is optimal as we have to look at every cell
# // Space Complexity : O(n) where n is the number of cols in the matrix
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : no
class Problem2(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        # condtion at index matrix[row][col] we can go from row+1,col-1 to row+1,col+1
        # we have to check possibility at every row and col position to see which will give us the minFallingPathSum
        # lets start from the first row and when we go tot the second row lets chck at evrry possiblity which of ht previosu step would give me min at this index 
        # i.e to check matrxi[row][col] value at this palce + min ( between range of row-1,col-1 to row-1 col+1)
        # and in the end that gives us the minimum path to reach from the first row to last row. 
        
        rows = len(matrix)
        cols = len(matrix[0])
        dp = matrix[0]
        
        for row in range(1,rows): 
            temp = dp[:]
            for col in range(cols):
                if col == 0:
                    dp[col] = matrix[row][col] + min(temp[col], temp[col+1])
                elif col == cols -1:
                    dp[col] = matrix[row][col] + min(temp[col-1], temp[col])
                else:
                    dp[col] = matrix[row][col] + min(temp[col-1], temp[col], temp[col+1])

        return min(dp)
                    
                



        