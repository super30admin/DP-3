package main

import "math"

/*
   approach: bottom up DP
   - selecting nums[i] means we cannot choose nums[i]+1 and nums[i]-1 ( value not idx! )
       - sounds very similar to; robbing houses[i] means you cannot rob adjacent ( houses[i-1] && houses[i+1] ; idxs in this case )
   - We can take inspirations from house robber pattern since it sounds similar to house robber
   - The problem
       - numbers in nums array will not be sorted .... so sort it ??
           - why do we want sorted array?
           - because when we choose a nums[i], we cannot use nums[i]+1 and nums[i]-1 ( values )
           - if the nums array was sorted, then we could easily excluded the prev and next indicies and literrally used house robber
           - that also means we are implying numbers are not missing... and are arithmetic (+1) sequence
       - numbers are not in +1 arithmetic sequence
           - example;
           - [11,2,4,5,6,6,8,22,11]
           - even if sort it
           - [2,4,5,6,6,8,11,11,22]
           - numbers are missing which means we cannot easily exclude using indicies.
           - so fill in the missing numbers????
           - YEP , but their values should be 0 because we do not want to count them into maximizing our points, if they are missing they should not be counted.
           - Therefore we will use a values like array which will have a 1:1 mapping of number in nums array to its sum ( sum of times we have seen this number )
           - each idx will be mapped to a number (1:1)
           - what will be the array size? - max number in our range that we care about
           - [11,2,4,5,6,6,8,22,11], therefore values array size will be 22+1 ( so we can map each number 1:1 to its idx )
           - values array [0,0,2,0,4,5,12, 0,8,0,0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22]
                           0,1,2,3,4,5, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22
                               2 shows up once
                                   4 shows up once
                                        6 shows up 2 times ( 6+6 )
                                                    11 shows up 2 times (11+11)
           - now our values array acts as input of house robber.

   - using 1d array because we only have 1 decision making variable ( nums array )
       - matrix can also work if we want to use 0/1 as decision making vars (naive; memorized ans.. not doing this)
   - what is bottom up dp;
       - we solve the smallest subproblem and use previous answers to solve current problem in hand
   - do bottom up from left to right
       - which means we will look back for previously solved subproblems
       - why? because we saw repeating subproblems which should be solved before current subproblem, therefore look back
       - example; [1,2,3,4,5,6,7]
           - if we are solving for idx 2
           - then our subproblem is from idx 0 up to and including idx 2 [1,2,3] ; forget the remaining right side when solving bottom up subproblem
           - since we are doing bottom up, we will solve for idx 2 ( value 3)
           - if we pick 3, we cannot pick 3-1 or 3+1(does not matter for us since 4 will be on the right side ;)  )
           - if we choose 3, then we have to select the precalculated value for 1 ( since we cannot use 2)
               - which is 2 steps back
           - if we do not choose 3, then our subproblem is [1,2] - which is 1 step back
           - therefore;
               dp[i] = max(dp[i-1], nums[i]+dp[i-2])
           - why dp array? remember we are writing each optimal answer for each subproblem in dp array
           - each idx in theory maps to its own corresponding idx in dp array
           - therefore dp array
   time: max(o(n), o(k)) ; n = len of nums, k = max number in nums array
   space: o(k)
*/
// func deleteAndEarn(nums []int) int {
//     maxNum := math.MinInt64
//     for i := 0; i < len(nums); i++ {
//         maxNum = max(maxNum, nums[i])
//     }

//     values := make([]int, maxNum+1)
//     for i := 0; i < len(nums); i++ {
//         num := nums[i]
//         values[num] += num
//     }
//     dp := make([]int, maxNum+1)
//     dp[0], dp[1] = values[0], max(values[0], values[1])
//     for i := 2; i < len(dp); i++ {
//         dp[i] = max(dp[i-1], values[i]+dp[i-2])
//     }

//     return dp[len(dp)-1]
// }

// time: max(o(n), o(k)) ; n = len of nums, k = max number in nums array
// space: o(k)
func deleteAndEarn(nums []int) int {
	maxNum := math.MinInt64
	for i := 0; i < len(nums); i++ {
		maxNum = max(maxNum, nums[i])
	}
	values := make([]int, maxNum+1)
	for i := 0; i < len(nums); i++ {
		num := nums[i]
		values[num] += num
	}

	prev := values[0]
	curr := max(values[0], values[1])

	for i := 2; i < len(values); i++ {
		newCurrent := max(curr, values[i]+prev)
		prev = curr
		curr = newCurrent
	}

	return max(prev, curr)
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
