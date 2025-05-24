// Time Complexity: O(n + maxi)

// Space Complexity: O(maxi)
// maxi is the max value in the nums array which is passed 

class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int  n = nums.length;
        for(int i=0; i<n;++i)
            maxi = Math.max(maxi,nums[i]);
        int []arr = new int[maxi+1];
        for(int i=0; i<n;++i)
            arr[nums[i]] += nums[i];
        
        int prev = arr[0];
        int curr = Math.max(arr[1],arr[0]+0);
        for(int i=2;i <= maxi;++i){
            int temp = curr;
            curr = Math.max(curr,prev+arr[i]);
            prev = temp;
        }
        return curr;
    }
}
