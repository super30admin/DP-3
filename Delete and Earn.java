// Time Complexity : O(n)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: We need to create a new array of the size of the max element from the given array. 
//Then store all the elements in the index equal to them and keep adding it whenever it occurs again. Then we can follow the steps followed in the house robber problem 

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int max=0;

        for(int num:nums)
        {
            //to find the length of the new array we need to find the max element
            max=Math.max(max,num);
        }
        
        int[] arr=new int[max+1];
        //fill the new array with the numbers in nums array and their total
        for(int num:nums)
        {
            arr[num]+=num;
        }

        //Now it is like the house robber problem. We find the previous 2 maximum values. Find the max between the old max+current value and the recent max 

        int prev=arr[0];
        int curr=Math.max(arr[0],arr[1]);

        for(int i=2;i<arr.length;i++)
        {
            int temp=curr;
            curr=Math.max(arr[i]+prev,curr);
            prev=temp;
        }
return curr;
    }
}