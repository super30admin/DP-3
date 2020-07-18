//Time Complexity of this solution is O(n + n) where n is 10000 which is the size of integer. Not sure if we can say this constant
//The space complexity is O(1)

class Solution {
  public int deleteAndEarn(int[] nums) {
    if(nums.length == 0)
      return 0;
    int[] values = new int[10000];
    //We are mapping each number as index in values array
    for(int i =0;i<nums.length;i++){
      values[nums[i]] += nums[i];
    }
    int prev_skip = 0,prev_take = 0;
    for(int i=0;i<values.length;i++){
      int temp = prev_skip;
      prev_skip=Math.max(prev_skip,prev_take);
      prev_take = values[i]+temp;
    }
    return Math.max(prev_skip,prev_take);
  }
}