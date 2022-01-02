public class DeleteAndEarn {

    //Brute
    // Time Complexity : O(2^N)
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no

    class Solution {
        public int deleteAndEarn(int[] nums) {
            int max=-11111;
            for(int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }

            int arr[] = new int[max+1];
            for(int i = 0; i < nums.length; i++) {
                arr[nums[i]] += nums[i];
            }

            return helper( arr, 0, 0);
        }
        private int helper(int arr[], int index, int maxsofar) {
            //base
            if(index >= arr.length) return maxsofar;
            //logic
            //skip
            int case0 = helper(arr, index+1, maxsofar);
            int case1 = helper(arr, index+2, maxsofar+arr[index]);
            return Math.max(case0, case1);
        }
    }

    //Dp
    // Time Complexity : O(N, max(N))
    // Space Complexity : O(max)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no

    public int deleteAndEarn(int[] nums) {
            int max=-11111;
            for(int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }

            int arr[] = new int[max+1];
            for(int i = 0; i < nums.length; i++) {
                arr[nums[i]] += nums[i];
            }
            int skip=0;
            int take=0;
            for(int i=1; i<arr.length;i++) {
                int temp = skip;
                skip = Math.max(skip, take);
                take = arr[i] + temp;
            }
            return Math.max(skip, take);
        }
}
