//Problem: LeetCode 740
//Approach: Used Dynamic Programming to find the pattern of repeating sub-problems. 
//Time Complexity: O(n) where n is number of elements in nums[]
//Space complexity: O(1) 

class EarnAndDelete {
    
    public int deleteAndEarn (int[] nums) {
        int [] total = new int[10001];
        int skipValue = 0, takeValue = 0;
        
        for (int n: nums) {
            total[n] += n;
        }
        
        for (int i=0; i< total.length; i++) {
            int tmp = skipValue;
            skipValue = Math.max(skipValue,takeValue); 
            takeValue = tmp + total[i];  
        }
        
        return Math.max(skipValue,takeValue);
    }
        
    }