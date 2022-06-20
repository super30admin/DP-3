// Time Complexity : O(n) + O(max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int n: nums) {
            max = Math.max(max, n);
        }
        int[] arr = new int[max + 1];
        for(int num: nums) {
            arr[num] += num;
        }
        int chose = arr[0];
        int notChose = arr[1];
        for(int i = 2; i < arr.length; i++) {
            int temp = chose;
            chose = Math.max(chose, notChose);
            notChose = temp + arr[i];
        }
        return Math.max(chose, notChose);
    }
}
