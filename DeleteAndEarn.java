// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class DeleteAndEarn {

    public int deleteEarn(int [] nums){
        int max = max(nums);
        int items[] = new int[max + 1];

        for (int num : nums){

            items[num] += num;
        }

        int dp[] = new int[max + 1];

        for (int i = 1 ; i < max - 1 ; i++){
            dp[i] = Math.max( items[i] +  i - 2 < 0 ? 0 : dp[i - 2] ,
                    dp[i - 1]);
        }

        return dp[max];
    }

    public int max(int[] nums){
        int maxNumber = Integer.MIN_VALUE;

        for (int num : nums){
            maxNumber = Math.max(maxNumber, num);
        }

        return maxNumber;
    }
    public static void main(String[] args){

        DeleteAndEarn obj = new DeleteAndEarn();
        int[] nums = {2,2,3,3,3,4};
        System.out.println(obj.deleteEarn(nums));

    }
}
