// Time Complexity: O(n)
// space complexity: O(1)
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int maxElement = Integer.MIN_VALUE;
        for(int num: nums) {
            maxElement = Math.max(num, maxElement);
        }

        int[] arr = new int[maxElement+1];

        for(int num: nums) {
            arr[num] +=num;
        }

        int prev = arr[0];
        int curr = arr[1];

        for(int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, prev+arr[i]);
            prev = temp;
        }

        return curr;
    }
}