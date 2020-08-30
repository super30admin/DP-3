
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //if array is empty, return 0
        if(nums.length == 0 || nums == null){
            return 0;
        }
        
        //we initialize a new array which will be filled with modified values
        int[] modifiedNewArray = new int[getMax(nums) + 1];
        
        //fill the new array with modified values
        for(int num : nums){
            modifiedNewArray[num] += num;
        }
        
        //Same as House Robber problem from here
        int choose = 0;
        int dont_choose = 0;
        
        for(int num : modifiedNewArray){
            int temp = dont_choose;
            dont_choose = Math.max(choose, dont_choose);
            choose = temp + num;
        }
        
        //return the maximum points that can be earned
        return Math.max(choose, dont_choose);
        
    }
    
    //function to set the size of the new modified array
    //Size would be equal to the max value in the original array + 1.
    private int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        
        for(int num : nums){
            if(num > max){
                max = num;
            }
        }
        return max;
    }
}