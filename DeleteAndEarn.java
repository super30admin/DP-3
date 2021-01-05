// Time Complexity : O(max(aux.length, nums.length)), as we constructing as aux aaray of sixe max element in nums array
// Space Complexity : O(max(aux.length, nums.length))
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english
//first to simplify the given problem, we count the  value of  of elements present in given nums array
//store the value of the element at its position in aux array
//then traverse the aux array and every step deicde if to choose or not choose the element, update the dp with max value of choose/notchoose


class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        //calculate the maximum element in the array
        int max =0;
        for(int i : nums){
            if(i > max){
                max = i;
            }
        }
        
        //now declare the auxilary array of size max + 1
        int []aux = new int[max+1];
        //fill the aux array with values
        for(int i =0;i < nums.length;i++){
            aux[nums[i]] += nums[i];
        }
        
        
        //from here the problem bubbles down to house robber problem
        
        int[]dp = new int[aux.length];
        dp[0] = aux[0];
        dp[1] = Math.max(aux[0],aux[1]);
        for(int i = 2; i < aux.length;i++){
            //not choose
            int m1 = dp[i-1];
            //choose
            int m2 = dp[i-2]+aux[i];
            
            dp[i] = Math.max(m1,m2);
        }
        
        
        
        return dp[dp.length-1];
    }
}
