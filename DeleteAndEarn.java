/**
 * Time Complexity: O(n) where n = length of nums
 * Space Complexity : O(m) where m = szie of var count
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max =  0;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int[] myArr = new int[max+1];
        for(int num :nums){
            myArr[num]=myArr[num]+num;
        }
            int skip = 0;
            int take = 0;
            for(int i=1;i<myArr.length;i++){
                int temp = skip;
                skip = Math.max(skip,take);
                take = temp+myArr[i];
            }
        return Math.max(skip,take);
        }
    public static void main(String args[]){
        DeleteAndEarn obj = new DeleteAndEarn();
        int[] myArr = new int[] {3,4,2};
        System.out.println("max = "+obj.deleteAndEarn(myArr));

    }
}