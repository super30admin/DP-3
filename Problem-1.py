class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        if nums is None or len(nums)==0:
            return 0

        n = max(nums)
        arr =[0]*(n+1)

        for num in nums:
            arr[num]+=num

        skip=0;take=arr[0]
        for i in range(len(arr)):
            temp=skip
            skip=max(skip,take)
            take = temp+arr[i]

        return max(skip,take)
