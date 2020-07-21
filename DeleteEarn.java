//Time Complexity : O(maximum number in nums array)
//Space Complexity : O(maximum number in nums array)
/*Approach
-taking a array and grouping the earnings into that the size of the array would be max of nums + 1, so
that we can group the earnings os same value as well as delete numerical neighbours
-we will make a dp array to store the earnings gained till now based on the conditions
-if we are taking an element we have to add its earning and the value gained by not taking its numerical neighbour
-if we are not taking an element then max of what we can get by taking its previous numerical neighbour
*/
public class DeleteEarn{
    public static int deleteAndEarn(int[] nums){
        int max = 99999;
        for(int n : nums){
            max = Math.max(max, n);
        }
        int earning[] = new int[max+1];
        for(int n: nums){
            earning[n] += n;
        }
        int dp[][] = new int[max+1][2];
        for(int i =1; i < dp.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]= dp[i-1][0] + earning[i];
        }
        return Math.max(dp[max][0],dp[max][1]);
    }
    public static void main(String args[]){
        System.out.println(deleteAndEarn(new int[]{3,4,2}));
        System.out.println(deleteAndEarn(new int[]{3,4,2,2,4,1}));
        System.out.println(deleteAndEarn(new int[]{5}));
        System.out.println(deleteAndEarn(new int[]{}));

    }
}