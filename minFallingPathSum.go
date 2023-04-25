// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*

Approach:
We use a bottom up DP approach where we consider that we're going from the
"leaf" of the decision tree of which path to take, and work our way up towards
the first set of nodes of that tree (which is the first row of our matrix). We
keep accumulating the minimum sum at every row considering the path traversal
constraints (i.e., which cell to choose) imposed by the problem statement.

*/

package main

import "math"

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func minFallingPathSum(matrix [][]int) int {
	if len(matrix) == 0 {
		return 0
	}

	n := len(matrix)

	for i := n - 2; i >= 0; i-- { // start from last but one row
		for j := 0; j <= n-1; j++ { // do all columns
			if j == 0 { // first column
				matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
			} else if j == n-1 { // last column
				matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
			} else { // every other cell
				matrix[i][j] += min(
					matrix[i+1][j-1],
					min(matrix[i+1][j], matrix[i+1][j+1]))
			}
		}
	}

	res := math.MaxInt
	for _, e := range matrix[0] {
		res = min(res, e)
	}

	return res
}
