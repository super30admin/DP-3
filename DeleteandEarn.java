//Time complexity - max (O(n) + O(max(n)))
//Space Complexity - o(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
      //null case 
      if(nums == null || nums.length == 0) {
        return 0;
      }
      
      int max = 0;
      //find max number in the arr
      for(int num : nums) {
        max = Math.max(max,num);
      }
      //add the same numbers in the arr
      int [] arr = new int [max+1];
      for(int num : nums) {
         arr[num] += num;
      }
      
      int skip = 0; int take = arr[0];
       for(int i=0; i< arr.length;i++) {
         int temp = skip;
         skip = Math.max(skip,take);
         take = temp+arr[i];
       }
      
      return Math.max(skip, take);
    }
}