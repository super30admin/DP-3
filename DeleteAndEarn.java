// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //initializing the max variable as 0
        int max = 0;
        
        //looping through the nums array to find the largest element in the array
        for (int num: nums)
        {
            max = Math.max(num, max);
        }
        
        //create an array with a size one larger than the max element
        //this is cuz the array starts from zero and ends at n - 1 whereas,
        //we want an index n as well
        int [] arr = new int [max + 1];
        
        //looping through each element of the mums array
        //adding each element to it's respective index
        for (int num: nums)
        {
            arr[num] += num;
        }
        
        //using the value at the zero'th index to store in prev variable
        int prev = arr[0];
        
        //storing the maximum of the first two indexes in the curr variable
        int curr = Math.max(arr[0], arr[1]);
        
        //looping starting from the third element to the last and storing the max value
        //We will perform the rest of the operations exactly like the house robber problem
        for (int i = 2; i < arr.length; i++)
        {
            int temp = curr;
            
            curr = Math.max(curr, prev + arr[i]);
            
            prev = temp;
        }
        
        return curr;
    }
}