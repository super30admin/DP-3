class DeleteAndEarn {
    /*
    Time Complexity : O(Max(max value in nums, length of nums))
    Space Complexity : O(max value in nums)
    
    Observation 1 : When choosing duplicate (see eg.2)
    When choosing a duplicate ( say 3) --> all the duplicates of 3 also add to the score at some point of time
    so better we take combined score while chosing first time only  ==> 2-> 4, 3 -> 9, 4 -> 4
    
    Observation 2 : Breaking into something known
    [3, 4, 2] ==> [2, 3, 4] => Sorting the array makes it simple to traverse and delete +1 and -1
    For duplicates [2, 2, 3, 3, 3, 4] ==> Replacing with its total score values 
         [4,9,4] ==> [0,0,4,9,4] ==> indices representing numbers and its value is score from that number.
    choosing alternatively. 
    
    ==> House Rob ==> C, DC
    */
    
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        // - New Array to update the points with respect to the index
        // - Using hashmap, we could not traverse using C, DC (needs sorting again since 
        //    we need previous (-1) and next (+1)  element to either Choose or DontChoose)
        int[] newNums = new int[getMax(nums) + 1];
        
        for( int i = 0; i < nums.length; i++){
            newNums[nums[i]] += nums[i];
        }
        
        int C = 0, DC = 0, temp;
        
        for(int i = 1; i < newNums.length; i++){
            temp = DC;
            DC = Math.max(C, DC);
            C = newNums[i] + temp;
        }
          
        return Math.max(C, DC);
    }
    
    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if( i > max)
                max = i;
        }
        return max;
    }
}

