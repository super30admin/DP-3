// Time Complexity: O(n + max), n is the no of elements, max is max value
// Space Complexity: O(n + max)

// We use the same approach as house robber pattern, and generating an array of length max+1

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        for (int num : nums) { // finding the maximum
            max = Math.max(max, num);
        }
        int arr[] = new int[max+1]; // creating a contribution array of size max + 1

        for (int num : nums) {
            arr[num] = arr[num] + num; // storing the contribution of each number
        }

        int skip = 0, take = 0; // using 2 variables to denote how much the contribution if we skip first element or we take first take element and compute best path 

        for (int contribution : arr) { // DP algorithm
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + contribution;
        }

        return Math.max(skip, take); // return the maximum of 2 paths


    }
}
