// # DP-3
// ## Problem1: (https://leetcode.com/problems/delete-and-earn/)
// Any problem you faced while coding this : I didnt face any problem while coding this
//[2,2,3,3,3,4]
public class DeleteAndEarn {
    // Time Complexity : O(2 ^ n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : yes
    public int deleteAndEarnBruteForce(int[] nums) {
        //find maximum number
        if(nums == null || nums.length == 0) return 0;
        int max =  Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num: nums){
            arr[num] += num;
        }
        return helper(arr, 0, 0);
    }
    private int helper(int[] arr, int index, int totalAmount){
        if(arr == null) return 0;
        if(index >= arr.length) return totalAmount;
        int case1 = helper(arr, index+1, totalAmount);
        int case2 = helper(arr, index+2, totalAmount+arr[index]);
        return Math.max(case1, case2);

    }

    // Time Complexity : O(n) + O(max(m))
    // Space Complexity : O(max(m))
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : I didnt face any problem while coding this
    public int deleteAndEarnOptimized(int[] nums) {
        //find maximum number
        if(nums == null || nums.length == 0) return 0;
        int max =  Integer.MIN_VALUE;
        for(int num: nums){ //O(n) number of elemnts in the num array
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num: nums){ //O(n)
            arr[num] += num;
        }
        int prev = arr[0];
        int curr = arr[1];

        for(int i=2; i<arr.length; i++){ //O(max(m)) - maximum number of elements in the array
            int temp = curr;
            curr = Math.max(curr, prev+arr[i]);
            prev = temp;
        }
        return curr;

    }
}
