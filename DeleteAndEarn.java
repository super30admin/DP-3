// Time Complexity :
// O(N) (To get Max) + O(N) (fill the array) + O(N) dp => 3 * O(N) => O(N)
// Space Complexity : O(1) (dp) + O(Math.max(N, M)) => M = Max number to delete => O(Math.max(N, M))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class DeleteAndEarn {

// This is house robber pattern problem as if I select
// any number I am actually disableing the neighbours
// we need to count sort here

    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        // calculate the max
        int max = 0;
        for (int i : nums) max = Math.max(max, i);

        // Formulate the array
        int[] arr = new int[max + 1];

        // fill the arr array
        for (int num : nums) {
            arr[num] += num;
        }

        System.out.println(Arrays.toString(arr));

        // House robber from here
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++) {

            int temp = curr;

            curr = Math.max(curr, arr[i] + prev);

            prev = temp;
        }

        return curr;

    }
}