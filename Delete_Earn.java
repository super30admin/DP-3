//TimeComplexity O(m)+O(n) for looping through the arrays of length n and m
//SpaceComplexity O(m+1) Creating an array of length m+1
class Solution {
    public int deleteAndEarn(int[] nums) {
        //1.find max in nums
        //2.Create new array of size max+1 and fill the index with their resepective sum values 
        //from nums and tle remaining indexes will be zero
        //3.Iterate through the new array and 
        //find the max between choose and not choose case
        int max = nums[0];
        for(int num : nums){
           max = Math.max(num,max); 
        }
        
        int[] arr = new int[max+1]; //max +1 : since the index starts from zero till max value
        for(int num : nums){
            arr[num] += num;
        }
        
        for(int i = 2; i < arr.length; i++){
            arr[i] = Math.max(arr[i-1], arr[i-2]+arr[i]);
        }
        return arr[max];
    }
}
