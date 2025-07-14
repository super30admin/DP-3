// Time Complexity : O(n+m) as we created another array arr[] of size m+1
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//I first found the max value in the array and created a new array where each index holds the total points for that number. 
//Then I treated it like the House Robber problem — if I take a number, I skip its neighbor. 
//I used two variables (take and skip) to keep track of the choices. 
//At the end, I returned the max of both.


public class DeleteAndEarn {
    public int solve(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int [] arr = new int[max+1];
        for(int i = 0; i < nums.length; i++){
            int idx = nums[i];
            arr[idx] = arr[idx] + nums[i];
        }
        int take = 0;
        int skip = 0;
        for(int i = 0; i < arr.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];

        }
        return Math.max(skip, take);


    }
    public static void main(String[]args){
        DeleteAndEarn ob = new DeleteAndEarn();
        int [] nums1 = {3,4,2};
        int [] nums2 = {2,2,3,3,3,4};
        System.out.println("Maximum no of points you can earn is: "+ob.solve(nums1));
        System.out.println("Maximum no of points you can earn is: "+ob.solve(nums2));


    }
    
}
