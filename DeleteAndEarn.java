//Time Complexity- O(n)+O(m) where m is max number in an array
//Space Complexity=O(m) where m is max number in an array
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int num: nums){
            max=Math.max(max,num);
        }
        int[] sumArray=new int[max+1];
        for(int i=0;i<nums.length;i++){
            int currentValue=nums[i];
            sumArray[currentValue]+=currentValue;
        }
        int prev=sumArray[0];
        int curr=Math.max(sumArray[0],sumArray[1]);
        for(int i=2; i<sumArray.length;i++){
            int temp=curr;
            curr=Math.max(curr,sumArray[i] + prev);
            prev=temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        DeleteAndEarn deleteAndEarn=new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(new int[]{3,4,2}));
    }
}
