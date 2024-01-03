//TC = O(max value in nums)
//SC = O(max value in nums)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums)
        {
            if(num> max) max = num;
        }
        int[] arr = new int[max + 1];
        for(int num : nums)
        {
            arr[num]+=num;
        }
        int prev = arr[0];
        int curr = arr[1];
        for(int i = 2; i < arr.length; i++)
        {
            int temp = curr;
            curr = Math.max(curr, arr[i]+ prev);
            prev = temp;
        }
        return curr;
    }
}