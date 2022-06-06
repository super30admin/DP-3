public class DeleteAndEarn {

    //Time Complexity-O(n)
    //Space Complexity-O(n)
    public int deleteAndEarn(int[] nums) {

        // if(nums.length==1){
        //     return nums[0];
        // }
        int max=0;
        for(int i:nums){
            max=Math.max(max,i);
        }

        int[] arr=new int[max+1];

        for(int num:nums){
            arr[num]+=num;
        }
        int prev=arr[0];
        int curr=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            int temp=curr;
            curr=Math.max(temp,prev+arr[i]);
            prev=temp;
        }

        return curr;
    }
}
