package DP3;
/**
 * 
 * First we preprocess the input such that we can store the profit associated by deleting each number.
 * 
 * Then we maximize the profit using bottom up DP approach
 * 
 * Time Complexity :
 * O(n) +n O(max element in nums), where n is the length of nums
 * 
 * Space Complexity :
 * O(max element in nums)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class Problem1 {
    public int deleteAndEarn(int[] nums) {

        if(nums.length==1)
            return nums[0];

        int max=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>max)
                max=nums[i];
        }

        int processedNums[]=new int[max+1];

        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            processedNums[curr]+=curr;
        }

        int prev=processedNums[0];
        int curr=Math.max(processedNums[0],processedNums[1]);

        for(int i=2; i< processedNums.length;i++){
            int temp=curr;
            curr=Math.max(curr, processedNums[i]+prev);
            prev=temp;
        }

        return curr;
        
    }

}
