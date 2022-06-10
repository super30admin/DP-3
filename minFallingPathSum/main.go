// time: o(mn)
// space: o(1) 
func minFallingPathSum(matrix [][]int) int {
    m := len(matrix)
    n := len(matrix[0])
    
    dirs := [][]int{{1,-1},{1,0},{1,1}}
    for i := m-2; i >= 0; i-- {
        for j := 0; j < n; j++ {
            min := math.MaxInt64
            // this for loop is constant -- its 3 loops for each r,c
            for _, dir := range dirs {
                nr := i+dir[0]
                nc := j+dir[1]
                if nr < m && nc < n && nr >= 0 && nc >= 0 {
                    if matrix[nr][nc] < min {
                        min = matrix[nr][nc]
                    }
                }
            }
            matrix[i][j] += min
        }
    }
    minVal := matrix[0][0]
    for j := 1; j < n; j++ {
        if matrix[0][j] < minVal {
            minVal = matrix[0][j]
        }
    }
    return minVal
}

