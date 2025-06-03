/* Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time complexity - O(N) + O(max(n)) ~ O(N)
Space complexity - O(max(n)) ~ O(N)
 ***/
public class DeleteAndEarn_LC_740 {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            max = Math.max(max, num);
        }
        int arr[] = new int[max+1];

        for(int num : nums) {
            arr[num] += num;
        }
        //house robber logic once we have arr with all the sum of elements at the given indexes
        int prev = arr[0];
        int current = Math.max(arr[0] ,arr[1]);
        for(int i = 2; i < arr.length; i++) {
            int temp = current;
            current = Math.max(current, arr[i] + prev);
            prev = temp;
        }

        return current;

    }
}