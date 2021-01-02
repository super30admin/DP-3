// Time Complexity : O(n) n: max element
// Space Complexity :O(n) n: max element
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// sum all same elements and it converts into house robber problem. 

public int deleteAndEarn(int[] nums) {
    int[] cost = new int[10001];
    for(int i = 0;i<nums.length;i++){
        cost[nums[i]] += nums[i];
    }
    //same as house robber
    for(int i = 3;i<cost.length;i++){
        cost[i] += Math.max(cost[i-2],cost[i-3]);
    }
    return Math.max(cost[10000],cost[9999]);
}