// Time Complexity : O(m+n) or O(max(n, max element)) where m = largest element , n = number of elements
// pass n is time to search max element and pass m is to fill the array with count and pass m to find sum
// Space Complexity : O(m) 

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
    
        int max = Integer.MIN_VALUE;
        // find the max element to make dp array of this size
        for(int n : nums)
        {
            max = Math.max(max, n);
        }
        // create dp array of max element + 1 such that idx == max element is there
        int dp[] = new int[max+1];
        
        // find count of each element in the array
        for(int n : nums)
        {
            dp[n] += n;
        }
        
        int skip = 0 , take = dp[0]; // sum of taking or not taking no = 0
        // apply DP pattern 2 i.e take or skip
        for(int i = 1 ; i < max +1 ; i ++)
        {
            int temp = skip;
            skip = Math.max(skip, take); // previous numbers
            take = dp[i] + temp; // current sum + previous number did not take
        }
        
        return Math.max(skip, take);
    }
}