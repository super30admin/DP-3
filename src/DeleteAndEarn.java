// Time Complexity : brute force: O(2^n), dp: m = nums.length , n = max(nums) , o(m+n)
// Space Complexity : dp O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/delete-and-earn/
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
 *
 */

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums ==null || nums.length==0) return 0;
        
        int[] modifiedArray = new int[10001];
        
        // we convert input so have a relation like select next element or not
        //problem reduced to house robber
        for(int num:nums){
            modifiedArray[num]+=num;
        }
        
        return dp(modifiedArray);
    }
    
    
    private int dp(int[] modifiedArray) {
        
        int prevCase1=0, prevCase2=0;
        
        for(int i=1; i<modifiedArray.length; i++){
            //case1 don't chose current value, max from previous number
            int case1 = Math.max(prevCase1, prevCase2);
            
            //case2, select current value, earning from the prev number not choose case + current number value
            
            int case2 = prevCase1 + modifiedArray[i];
            
            prevCase1 = case1;
            prevCase2 = case2;
        }
        
        return Math.max(prevCase1, prevCase2);
    }
    
    private int bruteForce(int[] modifiedArray, int index, int max) {
        //base
        if(index >= modifiedArray.length) return max;
        
        //logic
        //dont choose current element
        int case1 = bruteForce(modifiedArray, index+1, max);
        
        //choose current element
        int case2 = bruteForce(modifiedArray, index+2, max + modifiedArray[index]);
        
        return Math.max(case1,case2);
        
    }
}