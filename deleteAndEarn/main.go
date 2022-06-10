func deleteAndEarn(nums []int) int {
    max := math.MinInt64
    // o(n) time
    for _, num := range nums {
        if num > max { max = num }
    }
    // o(maxNumber) space
    // o(n) time
    values := make([]int, max+1)
    for _, num := range nums {
        values[num] += num
    }
    
    // o(1) space ( 0 || 1 case )
    dp := make([]int, 2)
    dp[0] = 0
    dp[1] = values[0]
    // o(maxNumber) time
    // o(1) space
    for i := 1; i < len(values); i++ {
        choose := dp[1]
        notChoose := dp[0]
        dp[1] = notChoose + values[i]
        dp[0] = int(math.Max(float64(choose), float64(notChoose)))
    }
    return int(math.Max(float64(dp[0]), float64(dp[1])))
}

// o(n) + o(n) + o(maxNumber) = o(2n) + o(maxNumber) time
// space: o(maxNumber) 
