// Solution - 1

// TimeComplexity: O(n + maxValue)
// SpaceComplexity: O(maxValue)
// Explanation: First, I convert the problem into a House Robber pattern. 
// I build an array arr where arr[i] stores the total points earned by taking number i (i.e., sum of all occurrences of i). 
// Since picking i deletes i-1 and i+1, it becomes identical to the house robber problem.

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            if (num>max) max=num;
        }
        int[] arr = new int[max+1]; 
        for(int num:nums) {
            arr[num]+=num;
        }
        int[] dp = new int[arr.length+1];
        dp[1] = arr[0];

        for(int i=2; i<arr.length+1; i++) {
            dp[i]= Math.max(dp[i-1], arr[i-1]+dp[i-2]);    
        }

        return dp[arr.length];      
    }
}


// Solution - 2

// TimeComplexity: O(maxValue)
// SpaceComplexity: O(maxValue)
// Explanation: After building the arr array, I use recursion. At each index, I decide: Take current value → arr[idx] + helper(idx+2); Skip it → helper(idx+1)
// I store results in dp[idx] to avoid recomputation. Each index is computed once.

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            if (num>max) max=num;
        }
        int[] arr = new int[max+1]; 
        Integer[] dp = new Integer[max+1];
        for(int num:nums) {
            arr[num]+=num;
        }

        return helper(arr, 0, dp);
        
    }

    private int helper(int[] arr, int idx, Integer[] dp) {
        if(idx>=arr.length) return 0;
        if(dp[idx] !=null) {
            return dp[idx];
        }

        // No choose
        int case1= arr[idx]+ helper(arr, idx+2, dp);

        // no choose
        int case2= helper(arr, idx+1, dp);
        int max = Math.max(case1, case2);
        dp[idx] =max;

        return max;

    }
}

// Solution - 3

// TimeComplexity: Exponential
// SpaceComplexity: O(maxValue)
// Explanation: Here I recursively try both choices (take or skip) without memoization. 
// This causes repeated evaluation of the same states, leading to exponential time complexity.


class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            if (num>max) max=num;
        }
        int[] arr = new int[max+1]; 
        for(int num:nums) {
            arr[num]+=num;
        }

        return helper(arr, 0);
        
    }

    private int helper(int[] arr, int idx) {
        if(idx>=arr.length) return 0;

        // No choose
        int case1= arr[idx]+ helper(arr, idx+2);

        // no choose
        int case2= helper(arr, idx+1);

        return Math.max(case1, case2);

    }
}