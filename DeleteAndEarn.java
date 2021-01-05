//Problem - DeleteAndEarn
// Time Complexity : O(Max(maxNum,numslength)), maxNum means bigger number in the array, whereas numsLength is array length
            //Eg: 1) [1,3,999]-> here max number is 999 and thus traversal will be done upto that size
            //Eg  2) [1,1,1,1,1,1,2,3], here max number is only 3, but  1 is repeated several times, here traversal will happen till array length;                                     
// Space Complexity : O(maxNum), auxilary array will be created of that size+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**  Steps
 *   Similar to house robber problem, Just do some data preprocessing, by creating an auxilary array of max num in the input array and then sum total occurrences for each element and store that in the newly created auxillary array in respect to the element index.
 * After that implement House Robber  
 * 
*/


class Solution25 {
    public int deleteAndEarn(int[] nums) {
        
        if(nums==null || nums.length==0){
            return 0;
        }
        
        int maxNum = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            maxNum = Math.max(maxNum,nums[i]);
        }
        //TC : O(Max(maxNum,numslength))
        //SC : O(Max(maxNum,numslength)) 
        int[] arr = new int[maxNum+1];
        
        for(int i=0;i<nums.length;i++){
            arr[nums[i]] += nums[i]; 
        }
     
        
        //Now Similar to house robber 1
        int skip = 0;
        int take = arr[0];
        
        for(int i=1;i<arr.length;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp+arr[i];
        }
        
        return Math.max(skip,take);
    }
    
        
        
}