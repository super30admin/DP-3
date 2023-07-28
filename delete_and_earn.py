class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        hashset=[0 for i in range(max(nums)+1)]
        for i in nums:
            hashset[i]+=i
        # print(hashset)
        dp_array=[None for i in range(len(hashset))]
        dp_array[0]=hashset[0]
        dp_array[1]=max(dp_array[0], hashset[1])
        i=2
        while(i<len(dp_array)):
            dp_array[i]=max(dp_array[i-1], dp_array[i-2]+ hashset[i])
            i+=1
        return dp_array[-1]