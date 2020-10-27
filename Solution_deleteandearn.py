"""
time complexity = O(M)+o(N) where M is length of nums and N is len of arr 
space Complexity = O(N)

convert the given array to count array so that the sum will become like House rober problem and follow that procedure



"""
class Solution_deleteandearn:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if(nums is None or len(nums)==0):
            return 0
        maxi=-1
        for num in nums:
            maxi=max(maxi,num)
        arr=[0]*(maxi+1)
        for num in nums:
            arr[num]+=num
        skip =0
        take=arr[0]
        for i in range(len(arr)):
            temp=skip
            skip=max(skip,take)
            take=temp+arr[i]
        return max(skip,take)