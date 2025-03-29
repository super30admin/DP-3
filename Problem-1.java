/* Using dp array: Time complexity - O(n) + O(max(n)) & Space complexity - O(max(n))
 * n - number of integers in given array */

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int[] arr = new int[max+1];
        for(int num : nums){
            arr[num] += num;
        }

        //int[] dp = new int[max+1];
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i=2; i<=max; i++){
            int temp = curr;
            curr = Math.max(temp, arr[i] + prev);
            prev = temp;
        }

        return curr;
    }
}

/* Recursive logic: Time complexity - 2^n & Space complexity - O(n)
 * n - max number in given array */

/*
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int[] arr = new int[max+1];
        for(int num : nums){
            arr[num] += num;
        }

        return helper(arr, 0, 0);
    }

    private int helper(int[] arr, int i, int points){
        //base case
        if(i >= arr.length) return points;

        //don't choose
        int case0 = helper(arr, i+1, points);

        //choose
        int case1 = helper(arr, i+2, points + arr[i]);

        return Math.max(case0, case1);
    }
}
    */