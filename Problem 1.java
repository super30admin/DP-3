// Time Complexity : O(n) + O(k) ==> O(k) , where k is the max element in the array
// Space Complexity : O(k) where k is the max element in the nums array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, identifying it as a house robber problem and then coming with algo was difficult


// Your code here along with comments explaining your approach
/*
This problem is similar to house robber problem, the diff is that we cannot choose the adjacent values

we will create an array from 0 to max value and store the count of the items, on the corresponding index
We then iterate over the array , and have to choices

1) choose it, and get sum of prev-1 element
2) not choose it and get the sum till prev element
we would take the max of the two and store at the index
*/
class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = Integer.MIN_VALUE; 
        for(int i=0;i<nums.length;i++){ // O(n)
            max = Math.max(max,nums[i]);
        }

        // we will create an array of max+1 size and will store the counts of each element in their corresponding indices

        int[] dp = new int[max+1];

        for(int i=0;i<nums.length;i++){ // O(n)
            dp[nums[i]]+=1; 
        }

        int finalMax = Integer.MIN_VALUE;
        // Filling dp table with dummy values
        dp[0] = 0;
        dp[1] = 1 * dp[1];

        finalMax = Math.max(dp[0],dp[1]);        
    
        // we will iterate over dp and apply the house robber rule

        for(int i=2;i<=max;i++){ // O(k), where k is the max element in the array
            int notChoose = dp[i-1];
            int choose = dp[i-2] + i * dp[i]; // skipping the prev one as nums[i] -1 is not allowed
            int currentMax = Math.max(notChoose,choose);
            dp[i] = currentMax;

            finalMax = Math.max(finalMax,currentMax);
        }

        return finalMax;



    }

}