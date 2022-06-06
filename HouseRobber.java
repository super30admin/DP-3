// Time Complexity : O(n)
// Space Complexity : O(1)

//I will take nums = [2,7,9,3,1] for the example
class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        //check if the nums array is empty
        if(n == 0) return 0;
        
        //if there is only one element then return the first element
        if(n < 2) return nums[0];
        
        //initializing the previous max value as the first element's value
        int prevMax = nums[0];
        //prev = nums[0] = 2
        
        //assigning the current maximum's value as the max of first two values
        int currMax = Math.max(nums[0], nums[1]);
        //curr = nums[1] = 7
        
        //iterating from the second element to the last
        for (int i = 2; i < nums.length; i++)
        {
            //storing the curr's value in a temp variable
            //we'll use temp to store this value in prevMax later
            //we cannot directly store the value in prevMax... 
            //cuz we're using its value in the next line of code
            int temp = currMax;
           // temp = curr = nums[1] = 7
            
            //calculating the current maximum by comparing the currentmax,
            //and the previous maximum and the element and current index
            currMax = Math.max(currMax, prevMax + nums[i]);
            //currMax = nums[1] = 7
            //prevMax = nums[0] + nums[2] = 2+9 = 11
            //Therefore, curr now equals to 11 
            
            //saving the temp(previous currMax) value in previous maximum variable
            prevMax = temp;
            //prevMax = temp = nums[1] = 7
        }
        
        //returning the current maximum amount obtained at the end of the loop
        return currMax;
    }
}

