//time complexity:O(N) + O(max(N))
//space complexity:O(max(N))
public class DeleteAndEarn {
    public int DeleteAndEarn(int[] nums){
        if(nums.length==0 && nums ==null)  return 0;
        int max=0;
        for(int num: nums){
            max = Math.max(max, num);
        }
        int[] arr= new int[max+1];
        for(int num: nums) {
            arr[num] += num;
        }
        int choose=arr[0];
        int notChoose=arr[1];
        for(int i=2;i<arr.length;i++) {
            int temp = choose;
            choose = Math.max(choose, notChoose);
            notChoose = temp + arr[i];
        }
    return Math.max(choose,notChoose);
    }
}
