// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

     func deleteAndEarn(_ nums: [Int]) -> Int {

        var dp = Array(repeating: 0, count: 10005)
        var frequencyCounter = Array(repeating: 0, count: 10005)
        for i in 0...nums.count-1 {
            frequencyCounter[nums[i]] += nums[i]   
        }
        dp[1] = frequencyCounter[1]
        for i in 2...dp.count-1 {
            dp[i] = max(dp[i-1],dp[i-2]+frequencyCounter[i])   
        }
        return dp.max() as! Int
    }