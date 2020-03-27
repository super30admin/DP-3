"""
Time complexity: O(nlogn) ??
Space complexity: O(n)
Challenges: Failed many times initiallly while using a counter
Executed in Leetcode: Yes
Comments: Given below
"""

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # Result for nums=[3,4,2] is Counter({3: 1, 4: 1, 2: 1})
        """
        Alternate route:
        counter = collections.Counter(nums)   
        select, unselect = 0,0
        """
        # Boundary conditions
        if not nums:
            return 0
        max_no = max(nums)
        
        if max_no <= 2: 
            return (sorted(nums)[-1])
        
        # Create 2 DP array
        x = [0]*max_no
        y = [0]*max_no
        for i in range(len(nums)): x[nums[i]-1] += 1   
        y[0] = x[0]; y[1] = max(x[0],2*x[1])

        for i in range(2,max_no):
            y[i] = max(y[i-1],(i+1)*x[i] + y[i-2])
        
        # The last value is the maximum amount accrued
        return y[-1]
