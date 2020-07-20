import java.util.Arrays;

public class Delete_and_Earn {
	//Approach: 1. This problem can be solved using dp approach, since in recursive solution, we might find repeated substructure whose solution can be reused.
	//2. The given input array is not sorted and contains duplicates, to fix this am creating an sortedArray of size- max element+1 from the given array.  
	//3. Then we iterate the given array and stored the elements in their corresponding indices. 
	//4. Then we will construct the dp matrix, by filling all possibilities of considering the element and not considering it. Then we return the max of the last two elements in dp matrix.
	    public int deleteAndEarn(int[] nums) {
        
        if(nums.length == 0 || nums == null)
            return 0;
        
        int max = Arrays.stream(nums).max().getAsInt();
        int[] sortedNums = new int[max+1];
        
               
        int[][] dp = new int[max+1][2];
        for(int i=0;i< nums.length;i++)
        {
            sortedNums[nums[i]] += nums[i];
        }
        
        for(int i=1;i< dp.length;i++)
        {
            dp[i][0] = Math.max( dp[i-1][0], dp[i-1][1]);
            dp[i][1] = sortedNums[i] + dp[i-1][0];
        } 
        
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }
	
}
// If the max element is very large like 10 ^ 6 and the array contains only few elements its better to go with sorting the array.
//Time Complexity : O(n), where n is the maximum element in the array 
//Space Complexity : O(n), where n is the maximum element in the array 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
