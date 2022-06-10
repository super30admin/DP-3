//****DELETE AND EARN****
// Time Complexity :O(N)+O(MAX*N);
// Space Complexity :O(1);
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        
        //Finding the maximum;
        for(int num: nums)
        {
            max=Math.max(max, num);
            
        }
        //Initializing the new array for converting it into worakble house robber form.
        int[] arr=new int[max+1];
        
        //Inserting data into new array;
        for(int num: nums)
        {
            arr[num] +=num;
        }
        
        //House-Robber
        int prev=arr[0];
        int curr=Math.max(arr[0], arr[1]);
        
        for(int i=2;i<arr.length;i++)
        {
            int temp=curr;
            
            curr=Math.max(prev+arr[i], temp);
            prev=temp;
        }
        
        return curr;
        
    }
}
