// Time Complexity : O(max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class DeleteandEarn {
    public int deleteAndEar(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            max = Math.max(max, num);
        }
        int[] a = new int[max+1];
        for (int num: nums) {
            a[num] += num;
        }

        int pre = a[0];
        int curr = a[1];
        for (int i = 2; i < a.length; i++) {
            int t = curr;
            curr = Math.max(curr, pre + a[i]);
            pre = t;
        }
        return curr;
    }
}