/**
 * @param {number[]} nums
 * @return {number}
 Intuition:
* Convert the problem into a value-based array where each index stores total points earned by taking that number.
* At each index, decide between **skipping it** or **taking it and skipping the next adjacent value**.
* Use DFS + memoization to avoid recomputing states, effectively turning it into a House Robber–style DP.
T.C: O(n+k)
S.C: O(k)
 */
var deleteAndEarn = function (nums) {

    let maxLength = Math.max(...nums);
    let dp = new Array(maxLength + 1).fill(0);
    let memo = [];

    for (let i = 0; i < nums.length; i++) {
        let currNum = nums[i];
        dp[currNum] += currNum;
    }

    const dfs = (idx) => {
        // base case
        if (idx > maxLength) return 0;

        if (memo[idx]) return memo[idx];
        // action
        // 0
        let zero = dfs(idx + 1);
        // 1
        let one = dp[idx] + dfs(idx + 2);
        memo[idx] = Math.max(zero, one);
        return memo[idx];
    };

    return dfs(0);
};


/**
 * @param {number[]} nums
 * @return {number}
 * Intuition:
 Convert values into a dp array where each index holds total points for that number.
For each number i, choose between taking it (add dp[i-2]) or skipping it (keep dp[i-1]).
This mirrors the House Robber pattern: avoid adjacent values while maximizing total points.
T.C: O(n+k)
S.C: O(k)
 */
var deleteAndEarn = function(nums) {

    let maxLength = Math.max(...nums);
    let dp = new Array(maxLength+1).fill(0);

    for(let i = 0; i<nums.length;i++){
     let currNum = nums[i];
     dp[currNum] += currNum;
    }
    
    for(let i = 2; i<dp.length; i++){
    dp[i] = Math.max(dp[i]+dp[i-2], dp[i-1]);
    }

    return dp[maxLength];
};