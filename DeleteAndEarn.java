// Time Complexity : O(MaximumValue)
// Space Complexity : O(MaximumValue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DeleteAndEarnSolution {
    public static int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
        }
        //create array of max+1 length to store frequencies
        int[] hash = new int[max+1];
        
        for(int i=0; i<=max ; i++) {
            hash[i] = 0;
        }
        //frequency
        for(int i=0; i<nums.length; i++) {
            hash[nums[i]] += nums[i]; // nums[i] is our key
        }  
        
        int skip = 0;
        int take = 0;
        int temp;
        
        for(int i=0; i<=hash.length-1; i++) {
            temp = skip;
            skip = Math.max(skip,take);
            take = hash[i] + temp;            
        }
        return Math.max(skip,take);
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,3,4,2};
        int result = deleteAndEarn(nums);
        System.out.print(result);
    }

}