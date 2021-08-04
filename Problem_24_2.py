def fallingpathsum(grid, row, col, Row, Col, dp):
 
   
    if row == Row-1 and col == Col-1: 
        return grid[row][col]
       
    
    if row > Row-1 or col > Col-1: 
        return 0
       
   
    rightdown = fallingpathsum(grid, row+1, col, Row, Col, dp)
    rdd = fallingpathsum(grid, row+1, col+1, Row, Col, dp)
    ldd = fallingpathsum(grid, row+1, col-1, Row, Col, dp)
     
     
    if dp[row][col] == -1:
        dp[row][col] = grid[row][col] + min(rightdown, ldd, rdd)
    return dp[row][col]
 
 
grid = [[1,2,3], [4,5,6],[7,8,9]]
Row = len(grid)
Col = len(grid[0])
dp = [[-1 for i in range(Row)]for _ in range(Col)]
print(fallingpathsum(grid, 0, 0, Row, Col, dp))

%TC:O(n)
%SC:O(1)