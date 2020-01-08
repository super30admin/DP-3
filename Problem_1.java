
public class Problem_1 {

public int deleteAndEarn(int[] nums) {
        
        if(nums.length == 0 || nums == null){
            return 0;
        }
        
        int values[] = new int[20000];
        for(int num : nums){
            values[num] = values[num] + num;
        }
        
        int skip = 0;
        int take = 0;
        for(int i : values){
            
            int curr_skip = Math.max(skip, take);
            int curr_take = skip + i;
            
            skip = curr_skip;
            take = curr_take;
            
        }
        
        return Math.max(skip, take);
        
    }
}
