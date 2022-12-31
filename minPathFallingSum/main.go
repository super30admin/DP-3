package main

import "math"

// time : o(mn)
// space: o(1)
func minFallingPathSum(matrix [][]int) int {
	dirs := [][]int{
		{-1, 0}, {-1, -1}, {-1, 1},
	}
	m := len(matrix)
	n := len(matrix[0])

	for i := 1; i < m; i++ {
		for j := 0; j < n; j++ {
			minVal := math.MaxInt64
			for _, dir := range dirs {
				r := i + dir[0]
				c := j + dir[1]
				if r >= 0 && c >= 0 && c < n {
					minVal = min(matrix[r][c], minVal)
				}
			}
			matrix[i][j] += minVal
		}
	}
	out := math.MaxInt64
	for j := 0; j < n; j++ {
		out = min(matrix[m-1][j], out)
	}
	return out
}
func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
