// Time Complexity : O(max(n) + n)
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Approach:
// Modified the current input to an array of their values considering their no. of occurences.
// As there is a need to eliminate the immediate previous number if the current number is considered,
// the problem is deduced to house robber.




class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int[] arr=new int[max+1];

        for(int i=0;i<n;i++){
            int num=nums[i];
            arr[num]+=num;
        }

        int prev=arr[0];
        int curr=Math.max(arr[0],arr[1]);
        for(int i=2;i<=max;i++){
            int temp=curr;
            curr=Math.max(curr,prev+arr[i]);
            prev=temp;
        }
        return curr;
    }
}