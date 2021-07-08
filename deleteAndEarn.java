class Solution {
    public int deleteAndEarn(int[] nums) {
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        int maxNum = Integer.MIN_VALUE;
        for (int i: nums) maxNum = Math.max(maxNum, i);
        
        int arr[] = new int[maxNum+1];
        for (int i: nums) arr[i] += i;
        
        int choose = arr[0] , skip = 0;
        for (int i=1; i<arr.length; i++) {
            int prevSkip = skip;
            skip = Math.max(skip, choose);
            choose = prevSkip + arr[i];
        }
        return Math.max(skip, choose);
    }
}