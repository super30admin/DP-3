//
//  MinimumFallingPathSum.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/10/26.
//

class MinimumFallingPathSum {
    
    /*
     Return the minimum sum of any fallin gpath through matrix.
     */
    init() {
        let minimumSumExhaustiveApproach = findMinimumFallingPathSum(matrix: [[2,1,3], [6,5,4], [7,8,9]])
        print("minimum falling path sum \(minimumSumExhaustiveApproach)")

        
        let minimumSumUsingTabulation = minimumFallingPathSumUsingTabulation(matrix: [[-19,57],[-40,-5]])
        print("minimumSumUsingTabulation \(minimumSumUsingTabulation)")
        
        let minimumSumUsingMemoization = minimumFallingPathSumUsingMemoization(matrix: [[2,1,3], [6,5,4], [7,8,9]])
        print("minimum falling path sum memoization \(minimumSumUsingMemoization)")
    }
    
    /*
     Bruteforce - go with exhaustve approach. Explore all possible options. Recursive solution
    */
    func findMinimumFallingPathSum(matrix: [[Int]]) -> Int {
        let min0 = helper(matrix: matrix, i: 0, j: 0)
        let min1 = helper(matrix: matrix, i: 0, j: 1)
        let min2 = helper(matrix: matrix, i: 0, j: 2)
        return min(min0, min1, min2)
    }
    
    func helper(matrix: [[Int]], i: Int, j: Int) -> Int {
        
        //base
        if (i == matrix.count) {
            return 0
        }
        
        //logic
        var minimumSum = 0
        if (j == 0) {
            //then we have element of column 0 and 1
            let min0 = matrix[i][j] + helper(matrix: matrix, i: i + 1, j: 0)
            let min1 = matrix[i][j] + helper(matrix: matrix, i: i + 1, j: 1)
            minimumSum = min(min1, min0)
        } else if (j == 1) {
            //column 0,1 and 2
            let min0 = matrix[i][j] + helper(matrix: matrix, i: i + 1, j: 0)
            let min1 = matrix[i][j] + helper(matrix: matrix, i: i + 1, j: 1)
            let min2 = matrix[i][j] + helper(matrix: matrix, i: i + 1, j: 2)
            minimumSum = min(min1, min(min0, min2))
        } else if (j == 2) {
            //column 1 and 2
            let min1 = matrix[i][j] + helper(matrix: matrix, i: i + 1, j: 1)
            let min2 = matrix[i][j] + helper(matrix: matrix, i: i + 1, j: 2)
            minimumSum = min(min1, min2)
        }
        
        //give minimum of all above
        
        return minimumSum
    }
}
/*
 Identified the repeated subproblems, so we can go ahead with dp tabulation approach
 */
extension MinimumFallingPathSum {
    
    func minimumFallingPathSumUsingTabulation(matrix: [[Int]]) -> Int {
        
        var dp: [[Int]] = Array(repeating: Array(repeating: 0, count: matrix[0].count), count: matrix.count)
        //first fill the dp matrix with
        for j in 0..<matrix[0].count {
            dp[matrix.count - 1][j] = matrix[matrix.count - 1][j]
        }
        
        let lastColumn = matrix[0].count - 1
        for i in stride(from: matrix.count - 2, through: 0, by: -1) {
            for j in 0..<matrix[0].count {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][0], dp[i + 1][1])
                } else if (j == lastColumn) {
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][lastColumn], dp[i + 1][j - 1])
                } else {
                    //for middle columns
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j - 1], dp[i + 1][j], dp[i + 1][j + 1])
                }
            }
        }
        var minimum = Int.max
        for i in 0..<lastColumn {
            minimum = min(dp[0][i], minimum)
        }
        return minimum
    }
}
