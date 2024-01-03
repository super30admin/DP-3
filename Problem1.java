// Time Complexity : O(n) + O(max(n))  -----> max(n)  maximum element in a array
// Space Complexity : 0(max(n)) -----> max(n)  maximum element in a array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) { 
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int num: nums) max = Math.max(num,max);
        int [] arr = new int[max+1];
        for(int num: nums)
        {
            arr[num] += num;
        }
        //problem is like house robber one
        int prev = arr[0];
        int curr = arr[1];

        for(int i = 2; i<arr.length; i++)
        {
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }
        return curr;
        
    }
}