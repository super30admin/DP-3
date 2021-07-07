// Time Complexity : O(M) where M is the maximum value in th nums array
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Finding the all the occurrences of the number in the given array and iterating through it to find the maximum points we can achieve
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] counter=new int[10001];		// given that nums doesn't cross 10000, have one extra space for 0th element
        int points=0;						// to record points 
        for(int i = 0; i <nums.length; i++){	// traverse through the nums array 
            int idxValue = nums[i];				// get the index value from each position
            counter[idxValue] += 1;				// go to the index value position in counter and increment the value by 1, each time we find it
            if(points < idxValue){				// this is used to determine the maximum element in the nums array
                points = idxValue;
            }
        }    
        
       for(int i=2;i<=points;i++) {				// since we know that values start from 1 and we need to subtract its neighbours, start the loop with 2
           counter[i]= Math.max(counter[i]*i+counter[i-2], counter[i-1]);		// number of occurrences * value + 2 places behind the current value, from this we are eliminating the 
																				// previous neighbour taken into consideration for maximum points, compare with the previous sum
       }
        return counter[points];				// return the maximum value which is stored in the last position.
   }
}