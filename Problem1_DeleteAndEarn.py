'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 740. Delete and Earn
# Given an array nums of integers, you can perform operations on the array.

# In each operation, you pick any nums[i] and delete it to earn nums[i] points.
# After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

# You start with 0 points. Return the maximum number of points you can earn by 
# applying such operations.

#-----------------
# Time Complexity: 
#-----------------
# O(max(N, max(N)): Need to iterate over input array once to create reward
#                   array. Then need to iterate over reward array. 
#------------------
# Space Complexity: 
#------------------
# O(N) - Need hashmap to store maximum N <key,value> pairs because of:
#        Worst case when input is all 1s or 0s

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  784 - 1068  ms (99.80 - 5.10 %ile)
# Space            :  18.9 MB (29.44 %ile)


from typing import List
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        reward_array = [0] * (max(nums)+1)

        # print(reward_array)
        for num in nums:
            reward_array[num] += num

        # print(reward_array)

        #Run House robber idea on reward array now

        skip_reward = 0
        delete_reward = reward_array[0]

        for i in range(len(reward_array)):
            prev_skip_reward = skip_reward
            skip_reward = max(skip_reward, delete_reward)
            delete_reward = prev_skip_reward + reward_array[i]

        return max(delete_reward, skip_reward)


obj= Solution()
print(obj.deleteAndEarn([2,3,4,3,3,2]))
