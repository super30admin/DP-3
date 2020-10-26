// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
starting from row 1 for each element store the sum of current + min of previous row adjacent elements
return min of last row
*/
package main

import "fmt"

/*func minFallingPathSum(A [][]int) int {
    case1 := helper(A, 0, 0, 0)
    case2 := helper(A, 0, 1, 0)
    case3 := helper(A, 0, 2, 0)
    return min(case1, min(case2, case3))
}


func helper(a [][]int, row int, col int, tot int) int {
    if row == len(a) - 1 {
        case1, case2, case3 := 9999, 9999, 9999
        if col - 1 >= 0 {
            case1 = tot + a[row][col - 1]
        }
        case2 = tot + a[row][col]
        if col + 1 < len(a[0]) {
            case3 = tot + a[row][col]
        }
        return min(case1, min(case2, case3))
    }

    case1, case2, case3 := 9999, 9999, 9999
    if col - 1 >= 0 {
        case1 = helper(a, row + 1, col - 1, tot + a[row][col])
    }
    case2 = helper(a, row + 1, col, tot + a[row][col])
    if col + 1 < len(a[0]) {
        case3 = helper(a, row + 1, col + 1, tot + a[row][col])
    }
    return min(case1, min(case2, case3))
}*/

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}


func minFallingPathSum(A [][]int) int {
	for i:=1;i<len(A);i++ {
		for j:=0;j<len(A);j++ {
			curr := A[i-1][j]

			if j>0 {
				curr = min(A[i-1][j-1], curr)
			}
			if j<len(A)-1 {
				curr = min(A[i-1][j+1], curr)
			}
			A[i][j]+=curr
		}
	}

	minv:=9999

	for i:=0; i<len(A); i++ {
		minv = min(minv, A[len(A) - 1][i])
	}
	return minv
}

func MainMinSum() {
	fmt.Println(minFallingPathSum([][]int{{1,2,3},{4,5,6},{7,8,9}})) //expected 12
}
