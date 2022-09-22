class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        # With some changes this problem is similar to House Robber
        max_int = max(nums)
        
        arr = [0] * (max_int + 1) # Space O(max_val in array)
        
        for i in range(len(nums)): # Time O(n)
            
            arr[nums[i]] += nums[i]
            
        
        no_rob = 0
        rob = 0
        
        for num in arr: # Time O(max_val in arr)
            # Storing the previous no_rob value so that it is not changed
            prev_no_rob = no_rob
            no_rob = max(no_rob, rob)
            rob = num + prev_no_rob
        
        return max(no_rob, rob)
            
        # Time Complexity: O(n) + O(max_val in array) Stated above where the time complexities change
        # Space Complexity: O(max_val in array)