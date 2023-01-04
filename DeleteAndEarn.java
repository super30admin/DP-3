// Time Complexity : O(n) + O(K) where k is max(n)
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach we maintain the occurence of each number in the original array into another array. Then we treat that as
//a house robber problem. 

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)return 0;

        int max = nums[0];

        for(int num: nums){
            max = Math.max(max,num);
        }

        int [] arr = new int[max+1];

        for(int num: nums){
            arr[num] += num;
        }

        int prev= arr[0];
        int curr = Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            int temp= curr;
            curr = Math.max(curr,prev+ arr[i]);
            prev= temp;
        }

        return curr;
    }
}
