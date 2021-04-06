class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums is None or len(nums)==0:
            return 0
        max_num=0
        for i in range(len(nums)):
            max_num=max(max_num,nums[i])
        dp_arr=[0]* (max_num+1)
        for num in nums:
            dp_arr[num]=dp_arr[num]+num
        skip=0
        take=dp_arr[0]
        for i in range(1,len(dp_arr)):
            temp=skip
            skip=max(skip,take)
            take=temp+dp_arr[i]
        return max(skip,take)
        