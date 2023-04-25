// Time Complexity: O(n) + O(max) where max is the max element in given array
// Space Complexity: O(n) + O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*

Approach:
We first "process" the array so that it can be solved in a familiar pattern -
the House Robber pattern, which has similar adjacency constraints for choosing
elements while maximising our "profit", which is the sum here. We find the max
value of the array first and then make another array of size = max value. This
array will contain the sum of all elements of that particular index (example,
index 2 will contain the sum of all 2's in the original array). Once we have
this array, we follow the House Robber pattern where we calculate the running
sum while also considering the adjacency constraint. The final answer will be
present at the max value index of the DP array.

*/

package main

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func deleteAndEarn(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	// first find max, as we have to construct DP array of that size
	m := -1
	for _, v := range nums {
		m = max(m, v)
	}

	dp := make([]int, m+1)

	// we calculate and keep sum of all elements found in nums
	for _, v := range nums {
		dp[v] += v
	}

	// now we traverse the array and find the solution
	skip := 0
	take := dp[0]
	// calculate based on prev sum values
	for i := range dp {
		temp := skip
		// we take max of previous 2 sums if we skip current sum
		skip = max(skip, take)
		// we skip prev if we choose current sum
		take = dp[i] + temp
		dp[i] = max(skip, take)
	}

	return dp[m]
}
