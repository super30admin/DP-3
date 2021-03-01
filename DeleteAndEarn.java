// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = findMax(nums);

        int arr[] = new int[max + 1];
        arr[0] = 0;
        for (int i : nums)
            arr[i] += i;

        int temp = 0;
        int c = arr[0];
        int dc = 0;


        for (int i = 1; i < arr.length; i++) {
            temp = dc;
            dc = Math.max(temp, c);
            c = arr[i] + temp;

        }
        return Math.max(dc, c);
    }
    public int findMax(int a[]) {
        int max = Integer.MIN_VALUE;
        for (int x : a) {
            max = Math.max(max, x);
        }
        return max;
    }
}
