// space complexity - o(n)
    	//time - o(n)
      //Ran on leeetcode successfully : Yes
      // Problem faced  : No
    	//Approach : take an array of length of maximun number in tehe given array, now count the frequency and problem becomes house robber problem.
  class Solution {
      public int deleteAndEarn(int[] nums) {

        int max = Integer.MIN_VALUE;

        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];

         for(int num : nums){
             arr[num] = arr[num] + num;
         }

         int prevMax = arr[0];
         int currMax = Math.max(arr[0],arr[1]);

         for(int i = 2; i<arr.length; i++){
             int temp = Math.max(currMax, arr[i] + prevMax);
             prevMax = currMax;
             currMax = temp;
         }
         return currMax;

      }
  }
