// # DP-3

// ## Problem1: (https://leetcode.com/problems/delete-and-earn/)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Time complexity will be with respective to the new array we just made, so with M and not with N, initially I thought it was with N


// Your code here along with comments explaining your approach
/**
\/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
    //**Time Complexity :O(N+M)  */
    //**Space Complexity :O(M)  */
    let map = new Array(Math.max(...nums)+1).fill(0)
    for(let i = 0; i<nums.length;i++){
        map[nums[i]] += nums[i]
    }
    let dp = []
    dp[0] = map[0]
    dp[1] = Math.max(map[0],map[1]+0)
    for(let i =2;i<=map.length-1;i++){
        dp[i] = Math.max(dp[i-1],map[i]+dp[i-2])
    }
    return dp[map.length-1]
    
};
var deleteAndEarn = function(nums) {
    //**Time Complexity : O(2^M) where m is the size of my MAP*/
    //**Space Complexity : O(M) */
    let map = new Array(Math.max(...nums)+1).fill(0)
    for(let i = 0; i<nums.length;i++){
         map[nums[i]] += nums[i];
    }
    let result = helper(0)
    return result
    //do house robber on map now 
    function helper(idx){
        //Base Case
        if(idx >= map.length){
            return 0
        }
        //Logic
        //Choose but cannot chose adjacent idx+2
        let pick = map[idx]+helper(idx+2)
        //not choose idx+1
        let notPick = helper(idx+1)
        //Return
        return Math.max(pick,notPick)
    }
};