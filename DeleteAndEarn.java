package DeleteAndEarn;

public class DeleteAndEarn {
	 public int deleteAndEarn(int[] nums) {
	int[] value = new int[1001];
    
    for(int num : nums)
    {
        value[num] += num;
    }
    
    int skip = 0;
    int take = 0;
    
    for(int i = 0 ; i<value.length;i++)
    {
        int curr_skip = Math.max(skip, take);
        int curr_take = skip+value[i];
        skip = curr_skip;
        take = curr_take;
    }
    
    return Math.max(skip,take);
	
	 }
	public static void main(String[] args) {
		int[] arr = {1,2,3,5,6,8,9,10,23,34,2,3,5};
		//int[] arr = {3, 4, 2};
		DeleteAndEarn obj = new DeleteAndEarn();
		int max_earning = obj.deleteAndEarn(arr);
		System.out.println("The Maximum Earning is : "+max_earning );
		

	}

}
