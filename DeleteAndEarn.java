// Time Complexity : O(N) + O(M) where N is the number of input elements
//                                and M is the max value amongst the elements.
//                  This will be O(M) or O(N) whichever is higher.

// Space Complexity : O(M) we used one 1D array of size M (max element)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially was stuck with an 
//                      approach where I was only tracking one path. Realizing that I
//                      will need to know maximum and counts of each number (or total).
//                      Spent almost entire day to get it right. Practicing more will help it.

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        //if empty arr, return 0 as the max points earned.
        if(nums.length == 0) {
            return 0;
        }
        
        //find max in the array, this will help us create DP array.
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
        }
        
        //create DP array to start with.
        int[] DP = new int[max+1];
        for(int i = 0; i < nums.length ; i++) {
            //find total of all occurrences of each element upto max.
            DP[nums[i]] += nums[i];
        }
        
        //Here we add the max to our current element
        //This helps us progress forward in the solution,
        //by eliminating paths that don't give us the max points
        for(int i = 2 ; i < DP.length ; i++) {
            DP[i] = Math.max(DP[i-1], (DP[i] + DP[i-2]));
        }
        
        //return last element of DP array as it will be the max.
        return DP[DP.length-1];
    }
}