'''
Solution 1: Recursion
We consolidate the nums with a frequency count of 0 to max value. Then at each step, we explore
choose, no choose. For choose, we jump to idx+2 to eliminate the nums[i]+1 value.  
Time Complexity: O(2^(max_val))
Space Complexity: O(max_val)
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_val = max(nums)
        freq_nums = [0]*(max_val+1) # consolidated array
        for i in nums:
            freq_nums[i]+=i 
        earned_points = self.helper(freq_nums,0)
        return earned_points

    def helper(self,freq_array,idx):
        # base
        if idx>=len(freq_array): # idx might skip to > len(freq_array) when we do idx+2 in choose
            return 0

        #logic
        # no choose
        case1 = self.helper(freq_array,idx+1) 

        # choose
        case2 = freq_array[idx] + self.helper(freq_array,idx+2)

        return max(case1, case2)

'''
Solution 2: Recursion + Memoization
We consolidate the nums with a frequency count of 0 to max value. Then at each step, we explore
choose, no choose. For choose, we jump to idx+2 to eliminate the nums[i]+1 value.  
Time Complexity: O(max_val)
Space Complexity: O(max_val)
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_val = max(nums)
        self.mem = {}
        freq_nums = [0]*(max_val+1) # consolidated array
        for i in nums:
            freq_nums[i]+=i 
        earned_points = self.helper(freq_nums,0)
        return earned_points

    def helper(self,freq_array,idx):
        # base
        if idx>=len(freq_array): # idx might skip to > len(freq_array) when we do idx+2 in choose
            return 0

        # memoization check
        if idx in self.mem:
            return self.mem[idx]

        #logic
        # no choose
        case1 = self.helper(freq_array,idx+1) 

        # choose
        case2 = freq_array[idx] + self.helper(freq_array,idx+2)

        self.mem[idx] = max(case1,case2)
        return max(case1, case2)
        
'''
Solution 3: DP (Tabulation)
We consolidate the nums with a frequency count of 0 to max value. Then at each step, we explore
choose, no choose. For choose, we jump to idx+2 to eliminate the nums[i]+1 value.  
Time Complexity: O(max_val)
Space Complexity: O(max_val)
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_val = max(nums)
        
        freq_nums = [0]*(max_val+1) # consolidated array
        for i in nums:
            freq_nums[i]+=i 
        
        dp_mat = [[None]*2 for i in range(max_val+1)]  # choose / NO choose
        dp_mat[0] = [0,freq_nums[0]] # [0,0]
        dp_mat[1] = [0,freq_nums[1]]
        for i in range(2,len(dp_mat)):
            # no choose
            dp_mat[i][0] = max(dp_mat[i-1]) # prev can be deleted or not deleted, if curr is not chosen to be deleted
            # choose
            dp_mat[i][1] = freq_nums[i] + max(dp_mat[i-2]) # if curr chosen to be deleted, prev has to be skipped
     
        return max(dp_mat[-1])

'''
Solution 3: DP (Tabulation) + space optimized on dp_mat
We consolidate the nums with a frequency count of 0 to max value. Then at each step, we explore
choose, no choose. For choose, we jump to idx+2 to eliminate the nums[i]+1 value.  
Time Complexity: O(max_val)
Space Complexity: O(max_val)
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
    
        max_val = max(nums)
        
        freq_nums = [0]*(max_val+1) # consolidated array
        for i in nums:
            freq_nums[i]+=i 

        if len(freq_nums)==2: # when only 1s are present
            return freq_nums[1]
        
        dp_s0 = 0 # i-2 state
        dp_s1 = freq_nums[1] # i-1 state
        dp_curr = [0,0]
        for i in range(2,len(freq_nums)):
            # no choose
            dp_curr[0] = dp_s1 
            # choose
            dp_curr[1] = freq_nums[i] + dp_s0

            # update the state
            dp_s0 = dp_s1
            dp_s1 = max(dp_curr)
            
        return max(dp_curr)