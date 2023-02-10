// Time Complexity : O(n + max(nums[i]))
// Space Complexity : O(max(nums[i]))

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++)
            if(nums[i]>max)
                max = nums[i];
        int[] arr = new int[max+1];
        for(int i=0;i<n;i++)
            arr[nums[i]]+=nums[i];

        int prev = arr[0];
        int cur = Math.max(arr[0],arr[1]);

        for(int i=2;i<max+1;i++)
        {
            int newCur = Math.max(prev+arr[i],cur);
            prev = cur;
            cur = newCur;
        }
        return cur;
    }
}