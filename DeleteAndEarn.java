class DeleteAndEarn {
  /*
    S30 problem.
    Attempt to solve this problem first.
    
    Hint: Can you reduce this Problem to a House Robber pattern?
    
    
    Time Complexity: O(max(n, m))
        n -> length of nums,
        m -> max in nums

    Space Complexity: O(m)

    Were you able to solve this on leetcode? Yes
    */ 
    public int deleteAndEarn(int[] nums) {
      int max = Integer.MIN_VALUE;
      for(int i : nums){
          max = Math.max(max, i);
      }
      
      int[] valueEarned = new int[max+1];
      for(int i = 0; i < nums.length; i++){
          valueEarned[nums[i]] += nums[i];
      }
      
      int skip = 0, take = 0;
      
      for(int i = 1; i < valueEarned.length; i++) {
          int tempSkip = skip;
          skip = Math.max(skip, take);
          take = valueEarned[i] + tempSkip;
      }
      
      return Math.max(skip, take);
      
  }
}