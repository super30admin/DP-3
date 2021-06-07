from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        max_element=0
        for num in nums:
            max_element=max(num, max_element)
        #print("max", max_element)

        new_arr=[0]*(max_element+1) #new arr
        #print(new_arr)
        for i in range(len(nums)):
            index=nums[i]
            new_arr[index]+=nums[i]

        #print(new_arr)
        #[0,0,2,3,4]
        skip=0
        take=new_arr[0]
        for i in range(len(new_arr)):
            temp=skip
            skip=max(skip,take)
            #take=new_arr[i-1]+new_arr[i]
            take= temp+ new_arr[i]
        return max(skip,take)
