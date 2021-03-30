class Solution {
    public int deleteAndEarn(int[] nums) {
        
        /*
        
        Thought Process:
        Understanding the minute detail in the problem was tricky.
        Brute force mechanism goes to repeated recursion.
        So need to create a dp for this.
        
        Convert the input strings into array of sum of numbers present
        Eg: [2,2,3,3,3,4] -> [0,0,4,9,4]
        Now its like a house robber array -> Exclude alternate number and find maximum sum.
        
        Two outputs possible at every step;
            - Considering the number (1) or 'take'
            - Not considering the no (0) or 'skip'
        
        skip would be max of prev skip and prev take
        take would be max of prev skip and value of current number
        
        Finally return max of skip or take
        
        T.C -> O(N)
        S.C -> O(N) for the array
        
        */
        
        if(nums==null || nums.length==0) return 0;
        int max = 0;
        //find max number
        for(int num : nums){
            max = Math.max(max, num);
        }
        
        int[] completeArray = new int[max+1];
        
        for(int i=0; i< nums.length; i++)
        {
            completeArray[nums[i]] += nums[i];
        }
        
        int skip = 0, take = completeArray[0];
        
        for(int i=1; i<completeArray.length; i++){
            int tempSkip = skip;
            skip = Math.max(skip,take);
            take = tempSkip + completeArray[i];
        }
        return Math.max(skip, take);
    }
}