// Time Complexity : O(2^n) -- Every element will have 2 choices to choose and not to choose. So 2 choices for n elements of the array
// Space Complexity : O(2^n)
// This Code did not successfully run on Leetcode and gave a Time Limit Exceeded error


// Brute Force
class Solution {
    int max = Integer.MIN_VALUE;
    public int deleteAndEarn(int[] nums) {
        //Edge Case
        if(nums ==null || nums.length ==0)
            return 0;
        helper(nums,0,0);
        helper(nums,1,0);
        return max;
    }
    public void helper(int[] nums,int i,int sum){ 
        // Skip the 0s which are created in the for loop
        while(i < nums.length && nums[i] == 0)   
            i++;
        //Base Case
        if(i == nums.length)    return; 
        //Logic
        int [] temp = nums.clone();
        int tempsum = sum;
        int prev = nums[i] - 1;
        int next = nums[i] + 1;
        for(int j=i;j<nums.length;j++){
            if(nums[j] == prev || nums[j] == next){
                nums[j] =0;
            }
        }
        sum +=nums[i];
        if(max < sum)   max = sum;
        //choose 
        helper(nums,i+1,sum);
        // not choose
        helper(temp,i+1,tempsum);
    }
}

// Dynamic Programing
// Time Complexity - O(1) Since the time taken is to iterate through the dp array which is of constant 
// Space Complexity  - O(1) - The space is 10001 which is constant space taken for creating the dp array
// This solution worked on LeetCode

class Solution {
    public int deleteAndEarn(int[] nums) {
      // Edge Case
       if(nums ==null || nums.length ==0)
            return 0;
      // Logic
        int[] dp = new int[10001]; // dp array of size 10001 because the elements range is [1,10000]
        for(int num: nums){
            dp[num] +=num; // create the dp array and add the num values iterating through the num array. Adding will take care of repeating elements in the nums array
        }
        int skip=0,take=0;
        int temptake=0;
        for (int i=1;i<=10000;i++){
                temptake = take;
                take = skip + dp[i];  // Calculate the take when we skip the previous number // This ensures we are not considering the previous and next number
                skip = Math.max(skip, temptake);     // This is critical because there would be times when skip > take, consider example when 2 times 2 > 1 time 3 
        }
        return Math.max(skip,take); // return the maximum of skip and take which is the maximum earn
    }
}
