/*
 * #740. Delete and Earn
 * 
 * Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:

Input: nums = [3, 4, 2]
Output: 6
Explanation: 
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.
 

Example 2:

Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation: 
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.
 

Note:

The length of nums is at most 20000.
Each element nums[i] is an integer in the range [1, 10000].

 */

/*
 * Time Complexity: O (N) -> Three for loops but all separate so O(N) + O(N) + O(N) = O (3N) = O (N)
 * 
 * Space Complexity: O (N) -> Using a counter array other than given input  
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DP3;

public class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {
		
		// Base condition/Input validation check
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        // Initialize max element in given array
        int max = Integer.MIN_VALUE;
        
        // Traverse through the input array to find max element
        for(int num : nums){
            if(num > max){
                max = num;
            }
        }
        
        /*
         * We have couple of problems to address here
         * eg: [4, 5, 2, 2, 1, 2]
         * 1. Array can have duplicate elements, in that case if we pick one, we take all of them, it means we delete all of them
         * 	  The only way we can take all of them at once is to add them, we cannot do it in the same array, so will need a counter array
         * 2. Array is not sorted -> means when we pick any element, we have to delete element-1 and element+1 values too. 
         * 	  In order to do that, we will have to go back and forth in the array
         * 3. So, adding to previous point, we need nums-1 at left < nums < nums+1 at right
         * 
         */
        
        // Initialize a counter array with size max+1
        int[] count = new int[max+1];
        
        // Copy/add the elements from input array to counter array at 'num' index, so the elements from input array will be at respective indices 
        // This way, we will address all three problems mentioned above
        for(int num : nums){
            count[num] += num;
        }
        
        /*
         * After getting our counter array, it is similar to House Robber problem
         * where if we pick any element, then we cannot chose its adjacent ones because -> according to problem delete nums-1 and nums+1 elements
         */
        
        // House Robber approach
        int C = 0;
        int DC = 0;
        
        for(int i = 0; i < count.length; i++){
            int temp = DC;
            
            DC = Math.max(C, DC);
            C = temp + count[i];
        }
        
        return Math.max(C, DC);
    }
	
}
