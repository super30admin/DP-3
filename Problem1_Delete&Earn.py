#Time Complexity: O(n)+O(max(m))
#Space Complexity: O(n)
#Leetcode: Yes

class Solution:
    def deleteAndEarn(self, nums):
        #Find max of the array
        max_ = max(nums)

        #make new array with max size
        arr = [0]*(max_+1)
        for i in range(len(nums)):
            arr[nums[i]] += nums[i]
    
        dp = [[0 for i in range(3)] for j in range(len(arr)+1)]
        for i in range(len(dp)):
            dp[i][0] = i
        
        for i in range(1,len(dp)):
            #Not Chose
            dp[i][1] = max(dp[i-1][1], dp[i-1][2])
            #Chose
            dp[i][2] = dp[i-1][1]+arr[i]
        
        
        return max(dp[-1][1], dp[-1][2])

obj = Solution()
nums = [2,2,3,3,3,4]
print(obj.deleteAndEarn(nums))