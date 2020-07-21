  ---------------------- Dynamic Programming ------------------------------------------------   
# Time Complexity : O(N) N is the length of the Array.
# Space Complexity : O(N+N) dp array $ dict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# 1. [2,2,3,3,3,4], One observation is array should be sorted. if we choose 2, we cannot choose 3, if we choose 3, we cannot choose 4.
#2. Another observation is to add the frequency of elements as we just need the total amount.
#3. Now the problem reduced to House robbing. Here we have 4 amount in house 1, 9 in house 2, 4 in house 3.
#4. we will take the maximum amount robbing from each house leaving the adjacent houses.
        

        
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        nums.sort()
        array = []
        d = Counter(nums)
        
        for k,v in d.items():
            array.append([k,v*k])
            
        dp = [0]*len(array)
        dp[0] = array[0][1]
        
        for i in range(1,len(dp)):
            if array[i][0]== array[i-1][0]+1:
                dp[i] = max(dp[i-1], dp[i-2]+array[i][1])
            else:
                dp[i] = dp[i-1]+array[i][1]
        return dp[-1]