class DeleteAndEarn {
    //time: O(n) where n=length of nums array
    //Space: O(n)
	//Did it run successfully on leetcode: yes
     public int deleteAndEarn(int[] nums) {
         //finding the largest element in the array
         int max = 0;
         for(int i=0; i<nums.length; i++){
            if(nums[i]>max) max = nums[i];
         }
         
         //initializing new array numSum that contains the sum of each repeating element in nums array
         int[] numSum = new int[max+1];//n
         //finding total sum for each elements till max
         for(int i=0; i<nums.length; i++){
            numSum[nums[i]] += nums[i];
         }
         
         //variable to store points when we don't select current element 
         int zero = 0;
         //variable to store points when we select current element
         int one = numSum[0];
         
         //looping through sum of elemnts
         for(int i=1; i<numSum.length; i++){
             //storing current zero and one values in a temporary variable
             int tmpZero = zero;
             int tmpOne = one;
             
             //if we don't select current element
             zero = Math.max(zero, one);
             //if we slect current element
             one = tmpZero + numSum[i];
         }
         
         return Math.max(zero, one);
         
     }
    
}