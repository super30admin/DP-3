// Time Complexity : O(n + 2m)
// n is the number of elements in input array (given, max value : 20000)
// m is the largest element of the input array (given, max value : 10000)

// Space Complexity : O(m), m is the largest element of the input array (given, max value : 10000)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int maxlenarray = 0; 
        
        //find length for temp array, as in temp array index represents numbers
        //so find max value
        for(int i = 0; i < nums.length; i++) { //O(n)
            if(maxlenarray < nums[i]){
                maxlenarray = nums[i];
            }
        }
        
        //for temp array : index = number; value = total sum of the number
        int[] temp = new int[maxlenarray+1];  //O(m)
        for(int i = 0; i < nums.length; i++){
            temp[nums[i]] += nums[i];
        }
        
        //similar to house robber : space : 0(1) 
        int dp = temp[0];
        int dp1 = Math.max(temp[0],temp[1]);  //in case of even number case eg:choose 1st and 4th
        int result = 0; 
        for (int i = 2; i < temp.length; i++) { // find max value at every number O(m)
            result = Math.max(dp+temp[i], dp1); //temp[i]+dp : as adj numbers cannot be added
            dp = dp1;
            dp1 = result; 
        } return dp1; //return dp1 : has the max       
   }
}
