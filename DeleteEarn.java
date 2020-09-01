// Time Complexity :O(N) where N = Maximum among the maximum element and the nums.length;
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. We consider an array which will keep track of the elements and sort it according to their indices.
//2. We then delete the maximum among those elements 

class DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] storeTracker = new int[getMax(nums) + 1];

        for (int num : nums) {
            storeTracker[num] += num;

        }

        int c = 0, dc = 0;
        for (int i = 0; i < storeTracker.length; i++) {
            int temp = dc;
            dc = Math.max(c, dc);
            c = storeTracker[i] + temp;
        }
        return Math.max(c, dc);

    }

    int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    public static void main(String args[]) {
        DeleteEarn obj = new DeleteEarn();
        int arr[] = { 3, 4, 2 };
        System.out.println(obj.deleteAndEarn(arr));

    }
}