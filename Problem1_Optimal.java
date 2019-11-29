/*
LeetCode Submitted : YES
Time Complexity : O(N)
Space Complexity : O(1)
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int MAX_INPUT_SIZE = 10001; //max input possible; including 10000
        int[] input_map = new int[MAX_INPUT_SIZE];
        
        
        //Boundary Case
        if(nums == null || nums.length <1)
            return 0;
        
        //Filling Input Map with Values where its present
        for(int i =0; i <nums.length; i++){
            input_map[nums[i]] = input_map[nums[i]] + nums[i];
        }
        
        //Once item located perform 2 operations 
        //Delete nums-1 and nums + 1
        //Storing previous and next points
        
        int prev =  0;
        int next = 0;
        
        for (int i=0;i<input_map.length; i++) {
            int temp = next;
            next = Math.max(prev + input_map[i], next);
            prev = temp;
        }
        
        return next;
    }
    
}
