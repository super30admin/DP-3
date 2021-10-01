// Time Complexity : 0(n*n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func minFallingPathSum(_ matrix:  [[Int]]) -> Int {
        var minimumPathSum = Int.max
        var matrix = matrix
        if matrix.count == 1 {
            return matrix[0][0]
        }
        for row in 1..<matrix.count {
            for col in 0..<matrix[0].count {
                matrix[row][col] = getMinimumSum(matrix,row,col)  
            }   
        }
        for col in 0..<matrix.count {
           minimumPathSum = min(matrix[matrix.count-1][col],minimumPathSum) 
        }
         return minimumPathSum
    }
    func getMinimumSum(_ matrix: [[Int]], _ row: Int, _ col: Int) -> Int {
            var minimumSum = Int.max
            if row - 1 >= 0 && col - 1 >= 0 {
                 minimumSum = min(matrix[row][col] + matrix[row-1][col-1],minimumSum)
            }
            if row - 1 >= 0 {
                 minimumSum = min(matrix[row][col] + matrix[row-1][col],minimumSum)
            }
            if row - 1 >= 0 && col + 1 < matrix.count {
                 minimumSum = min(matrix[row][col] + matrix[row-1][col+1],minimumSum)
            }
        return minimumSum
        }