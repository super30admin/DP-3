#delete and earn


# // Time Complexity : O(N) 
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no, it was pretty much the house robbing problem, but you had to make the array first


def deleteAndEarn( nums):
    skip=0
    take=0
    
    length=max(nums)
    length=max(length, len(nums))
    dp=[0 for i in range(length+1)]                
    for i in range(len(nums)):                           #make an array adding up the numbers on their index
        dp[nums[i]] += nums[i] 
    
    for i in range(len(dp)):                                #for each index, you either skip  or choose it
        temp=skip
        skip = max(skip, take)                              #if you skip, you choose the max between the last index and the current skip
        take = dp[i]+ temp                                  # if you take, you add the last skip and this take
        
    return max(skip, take)


#testing
print(deleteAndEarn([3,4,2]))