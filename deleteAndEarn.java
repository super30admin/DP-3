// Time Complexity : O(n)
// Space Complexity :O(1) 
public class deleteAndEarn {
    public int solution(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }           
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }
        int dp[] =new int[max+1];
        for(int i=0;i<nums.length;i++){
            dp[nums[i]]+= nums[i]; 
        }
        int case0=0, case1=dp[0];
        for(int i=1;i<max+1;i++){
            int temp=case0;
            case0= Math.max(case0,case1);
            case1=dp[i]+temp;
        }
        
        return Math.max(case0,case1);
    }
    
} 
