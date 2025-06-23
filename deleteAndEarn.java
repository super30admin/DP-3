//time = O(n)+O(max(n))
//Space = O(max(n))
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i<n;i++) //O(n)
        {
            max = Math.max(max,nums[i]);
        }
        int[] arr = new int[max+1];
        for(int i: nums)
        {
            arr[i] += i;
        }
        //house robber
        int prev = arr[0];
        int curr = Math.max(arr[0],arr[1]);
        for(int i=2; i < arr.length;i++) //O(max(n))
        {
            int temp = curr;
            curr = Math.max(curr, prev+arr[i]);
            prev = temp;
        }
        return curr;
    }
}