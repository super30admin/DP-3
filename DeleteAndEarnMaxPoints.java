//TC: O(n)
//SC: O(1)
//works in leetcode
class DeleteAndEarnMaxPoints {

    static  public int deleteAndEarn(int[] nums) {
        int max = max(nums);

        //calc max to create array of max to store freq
        int[] freq = new int [max+1];

        //freq array to store the points of each num; problem converted to house robber
        for(int num : nums){
            freq[num] +=num;
        }

        int[] dp = new int[max+1];

        for(int i=0;i<=max;i++){
            dp[i] = Math.max(
                    freq[i] + (i-2<0? 0: dp[i-2]),  //select
                    (i-1<0? 0: dp[i-1])// not select
            );

        }
        return dp[max];

    }
    private static int max(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int num:arr){
            max = Math.max(max, num);
        }
        return max;
    }



    public static void main(String [] args){
        int [] nums = {2,2,3,3,3,4};

        System.out.println(deleteAndEarn(nums));
        int [] nums1 = {3,4,2};

        System.out.println(deleteAndEarn(nums1));
    }
}